package main.translate;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Scanner;

public class Authentication {

	private final static String DATAMARKET_ACCESS_URI = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";
	private String clientId;
    private String clientSecret;
    
	public Authentication(String clientId, String clientSecret)
	{
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		
	}
	
	public AccessToken getAccessToken() throws ClientProtocolException, IOException
	{
		return httpPost();
	}

	private AccessToken httpPost() throws ClientProtocolException, IOException {
		
		//Prepare OAuth request 
		HttpClient client = new DefaultHttpClient();
		HttpPost request = null;
		HttpResponse serverResponse = null;
		String answer = "";
		String requestParams = null;
		
		request = new HttpPost(DATAMARKET_ACCESS_URI);
		
		// we build the request params
		requestParams = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s&scope=http://api.microsofttranslator.com", 
                URLEncoder.encode(clientId), URLEncoder.encode(clientSecret));
		StringEntity se = new StringEntity(requestParams);
		
		// we specify the MIME type of the entity
		// !!!!!VERY IMPORTANT: this should not be an HTTP request header, but an entity header 
		se.setContentType("application/x-www-form-urlencoded");
		
		request.setEntity(se);
		// send it and get the response
		serverResponse = client.execute(request);
		
		// we check for errors on the answer
		WebUtils.checkForErrors(serverResponse, "Get Access Token");
		
		// if we got here, then there is no exception
		InputStream is = serverResponse.getEntity().getContent();	
		
		// the beginnng of a input stream is \A
		answer = new Scanner(is).useDelimiter("\\A").next();

		AccessToken accessToken =  WebUtils.deserializeJsonString(answer, AccessToken.class);

		
		// we set the issued date to this moment's date
		accessToken.setIssuedTime(Calendar.getInstance().getTime());
		
		return accessToken;
		 
	}

	

}
