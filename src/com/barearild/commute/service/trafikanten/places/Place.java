package com.barearild.commute.service.trafikanten.places;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.android.maps.GeoPoint;

public abstract class Place {

	private static final String TAG = Place.class.getSimpleName();
	protected static final String ID = "ID";
	protected static final String NAME = "Name";
	protected static final String DISTRICT = "District";
	protected static final String LOCATION_X = "X";
	protected static final String LOCATION_Y = "Y";
	protected static final String TYPE = "Type";
	protected static final String SHORT_NAME = "ShortName";

	int id;
	String name = null;
	String district = null;
	GeoPoint location = null;
	StopType type = StopType.None;
	String shortName = null;

	public Place() {
	}

	public Place(JSONObject placeJsonObject) {
		try {
			if (placeJsonObject.has(ID)) {
				id = placeJsonObject.getInt(ID);
			}
			if (placeJsonObject.has(NAME)) {
				name = placeJsonObject.getString(NAME);
			}
			if (placeJsonObject.has(DISTRICT)) {
				district = placeJsonObject.getString(DISTRICT);
			}
			if (placeJsonObject.has(LOCATION_X) && placeJsonObject.has(LOCATION_Y)) {
				location = new GeoPoint(placeJsonObject.getInt(LOCATION_X), placeJsonObject.getInt(LOCATION_Y));
			}
			if (placeJsonObject.has(TYPE)) {
				type = StopType.getStopType(placeJsonObject.getInt(TYPE));
			}
			if (placeJsonObject.has(SHORT_NAME)) {
				shortName = placeJsonObject.getString(SHORT_NAME);
			}
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage());
		}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDistrict() {
		return district;
	}

	public GeoPoint getLocation() {
		return location;
	}

	public StopType getType() {
		return type;
	}

	public String getShortName() {
		return shortName;
	}

	public static Place parseJsonObject(JSONObject jsonObject) {
		try {
			if (jsonObject.has(TYPE)) {
				switch (jsonObject.getInt(TYPE)) {
				case 0:
					return new Stop(jsonObject);
				case 1:
				case 2:
				case 3:
				default:
					return null;
				}
			}
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage());
		}

		return null;
	}

	/**
	 * "Zone": null, "X": 0, "Y": 0, "ID": 1000027573, "Name":
	 * "Jernbanetorget #", "District": "Oslo", "Type": 1, "ShortName": null,
	 * "Stops": [
	 */

	/**
	 * { "Houses": [ { "Name": "1", "X": 574338, "Y": 6565442 } ], "Zone": null,
	 * "X": 0, "Y": 0, "ID": 72001054, "Name": "Storgata", "District": "Stokke",
	 * "Type": 3, "Stops": [], "ShortName": null },
	 */
}
