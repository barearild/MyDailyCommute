package com.barearild.commute.service.trafikanten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;


public class JSONConnector {
	
	public static JSONArray getJsonResult(String request) {
		JSONArray result = null;
		StringBuilder responseString = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(request);
		
		try {
			HttpResponse response = client.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String line;
				while((line = reader.readLine()) != null) {
					responseString.append(line);
				}
				
				result = new JSONArray(responseString.toString());
				
				
			} else {
				
			}
			
		} catch (ClientProtocolException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} catch (NullPointerException e) {
			// TODO: handle exception
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
