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

	Integer id;
	String name = null;
	String district = null;
	GeoPoint location = null;
	StopType type = StopType.None;
	String shortName = null;

	public Place() {
	}

	public Place(JSONObject jsonObject) throws JSONException {
		id = getIntegerNullSafe(ID, jsonObject);
		name = jsonObject.getString(NAME);
		district = jsonObject.getString(DISTRICT);
		location = new GeoPoint(jsonObject.getInt(LOCATION_X), jsonObject.getInt(LOCATION_Y));
		type = StopType.getStopType(jsonObject.getInt(TYPE));
		shortName = jsonObject.getString(SHORT_NAME);
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
					return new Area(jsonObject);
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

	protected Integer getIntegerNullSafe(String tag, JSONObject jsonObject) {
		Integer value = null;

		if (jsonObject.has(tag) && !jsonObject.isNull(tag)) {
			try {
				value = jsonObject.getInt(tag);
			} catch (NullPointerException e) {
				// ignore
			} catch (JSONException e) {
				Log.e(TAG, e.getMessage());
			}
		}

		return value;
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
