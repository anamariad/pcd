package main.translate;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public abstract class WebUtils {

	// we check a HttpResponse's status code. If it is > 2, then there is an error
	public static void checkForErrors(HttpResponse serverResponse, String locationTag) throws ClientProtocolException 
	{
		int responseCode = serverResponse.getStatusLine().getStatusCode();
		// this means there is an error with the http request, either from the client or from the server
		if(responseCode / 100 > 2)
		{
			StringBuilder error = new StringBuilder(locationTag).append(" Error ");
			error.append(responseCode);
			error.append(":");
			error.append(serverResponse.getStatusLine().getReasonPhrase());
			throw new ClientProtocolException(error.toString());
		}
		
	}
	
	public static <T> T deserializeJsonString (String jsonString, Class<T> clazz) throws IOException {

        GsonBuilder gsonb = new GsonBuilder().
						setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

		Gson gson = gsonb.create();

		return gson.fromJson(jsonString, clazz);

	}


}
