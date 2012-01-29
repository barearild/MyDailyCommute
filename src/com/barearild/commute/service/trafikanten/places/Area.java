package com.barearild.commute.service.trafikanten.places;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Area extends Place {
	
	protected static final String STOPS = "Stops";

    protected static final StopType TYPE = StopType.Area;
	
	ArrayList<Stop> stops = new ArrayList<Stop>();

	public Area() {
		super();
	}

	public Area(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		
		JSONArray stopsJSonArray = jsonObject.getJSONArray(STOPS);
		
		for(int i = 0; i < stopsJSonArray.length(); i++) {
			JSONObject stopJson = stopsJSonArray.getJSONObject(i);
			stops.add(new Stop(stopJson));
		}
	}

    @Override
    public StopType getType() {
        return TYPE;
    }

    public ArrayList<Stop> getStops() {
		return stops;
	}
	
	
	
	

}
