package main.translate;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 * @author Annouk
 *	
 */
public class TranslateRequest 
{
	private static AccessToken accessToken;
	private static final String TRANSLATION_URI = "http://api.microsofttranslator.com/V2/Http.svc/Translate";
	
	/*
	 * It is always better to check elapsed time between time at which token issued and current time. 
	 * If elapsed time exceeds 10 minutes, renew access token by following obtaining access token procedure. 
	 */
	public static String translate(String textToTranslate, String fromLanguage, 
										String toLanguage) 
						 throws ClientProtocolException, IOException
	{
		String headerValue = null;
        String translation = null;
        
		obtainAccessToken();
		
		// Create a header with the access_token property of the returned token
		if (accessToken != null)
		{
	        headerValue = "Bearer " + accessToken.getAccessToken();
	        translation = translateMethod(headerValue, textToTranslate, fromLanguage, toLanguage);
		}

        return translation;
	    
	}

	private static String translateMethod(String headerValue,String textToTranslate, 
						  				  String fromLanguage, String toLanguage)
						  throws ClientProtocolException, IOException {
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = null;
		HttpResponse serverResponse = null;
		String answer = "";
		
		String requestParams = String.format("text=%s&contentType=%s&from=%s&to=%s", 
                URLEncoder.encode(textToTranslate), URLEncoder.encode("text/plain"),
                fromLanguage, toLanguage);
		
		StringBuilder requestBuilder = new StringBuilder(TRANSLATION_URI)
											.append("?")
											.append(requestParams);
		
		request = new HttpGet(requestBuilder.toString());
		
		// we set the authorization header and we don't need to set the appId field
		request.setHeader("Authorization", headerValue);
		
		// send it and get the response
		serverResponse = client.execute(request);
		
		// we check for errors on the answer
		WebUtils.checkForErrors(serverResponse, "Translate");
		
		// if we got here, then there is no exception
		InputStream is = serverResponse.getEntity().getContent();	
		
		// the beginnng of a input stream is \A
		answer = new Scanner(is).useDelimiter("\\A").next();

		// extract the id from the xml tag (the only one in the answer)
		int firstPoz = answer.indexOf(">");
		int lastPoz = answer.lastIndexOf("<");
		answer = answer.substring(firstPoz + 1, lastPoz);
		return answer;
	}
	/**
	 * obtains an accessToken to authenticate translation requests over MS Translator API
	 * @throws java.io.IOException
	 * @throws ClientProtocolException 
	 */
	public static String obtainAccessToken() throws ClientProtocolException, IOException {
		
		
		if (accessToken == null || isAccessTokenExpired())
		{
			// we get the authentication token and then serialize it
			Authentication auth = new Authentication(ClientAuthData.CLIENT_ID, 
												ClientAuthData.CLIENT_SECRET);
			
			accessToken = auth.getAccessToken();
		}

        return accessToken.getAccessToken();
	}

	/*
	 * checks if access token is expired (there have been more than 10 minutes since it was issued)
	 */
	private static boolean isAccessTokenExpired() {
		if (accessToken != null)
		{
			int diff = Calendar.getInstance().getTime().getMinutes() - 
						accessToken.getIssuedTime().getMinutes();
			
			if (diff < Integer.parseInt(accessToken.getExpirationPeriod()) / 60)
			{
				return false;
			}
						
		}
		return true;
	}
}
