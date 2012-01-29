package com.barearild.commute.service.trafikanten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.util.Log;
import com.google.gson.stream.JsonReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;


public class JSONConnector {

    public static List<Travel> getTravels(InputStreamReader in) throws IOException {
        List<Travel> travels = new ArrayList<Travel>();

        JsonReader reader = new JsonReader(in);

        reader.beginArray();
        while (reader.hasNext()) {
            travels.add(new Travel(reader));
        }
        reader.endArray();

        return travels;
    }

    private static InputStreamReader getRequestInputStreamReader(String request) {

        try {
            HttpResponse response = new DefaultHttpClient().execute(new HttpGet(request));
            if(response.getStatusLine().getStatusCode() == 200) {
                return new InputStreamReader(response.getEntity().getContent());
            }
        } catch (IOException e) {
            Log.e(JSONConnector.class.getSimpleName(), e.getMessage());
        }

        return null;
    }
	
    public static Date jsonStringToDate(String dateString) {
        dateString = dateString.replaceAll("/Date\\(", "");
        dateString = dateString.replaceAll("\\+0100\\)/", "");
        Date date = new Date();
        date.setTime(Long.valueOf(dateString));

        return date;
    }

    public static List<String> jsonToArrayListString(JsonReader reader) throws IOException {
        ArrayList<String> strings = new ArrayList<String>();
        reader.beginArray();
        while(reader.hasNext()) {
            reader.beginObject();
            strings.add(reader.nextString());
            reader.endObject();
        }
        reader.endArray();

        return strings;
    }
    
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
