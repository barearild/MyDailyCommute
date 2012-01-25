package com.barearild.commute.service.trafikanten.places;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Stop extends Place {

	protected static final String WALKING_DISTANCE = "WalkingDistance";
	protected static final String ARRIVAL_TIME = "ArrivalTime";
	protected static final String ALIGHTNING_ALLOWED = "AlightningAllowed";
	protected static final String DEPARTURE_TIME = "DepartureTime";
	protected static final String BOARDING_ALLOWED = "BoardingAllowed";
	protected static final String REALTIME_STOP = "RealTimeStop";
	protected static final String RANK = "Rank";
	protected static final String ZONE = "Zone";
	protected static final String STOPS = "Stops";

	int walkingDistance;
	int arrivalTime;
	boolean alightningAllowed;
	int departureTime;
	boolean boardingAllowed;
	boolean realTimeStop;
	int rank;
	// ArrayList<Line> lines;
	// ArrayList<StopPoint> stopPoints;
	String zone;
	ArrayList<Stop> stops;

	public Stop() {
		super();
	}

	public Stop(JSONObject stopJsonObject) {
		super(stopJsonObject);

		try {
			walkingDistance = stopJsonObject.getInt(WALKING_DISTANCE);
			arrivalTime = stopJsonObject.getInt(ARRIVAL_TIME);
			alightningAllowed = stopJsonObject.getBoolean(ALIGHTNING_ALLOWED);
			departureTime = stopJsonObject.getInt(DEPARTURE_TIME);
			boardingAllowed = stopJsonObject.getBoolean(BOARDING_ALLOWED);
			realTimeStop = stopJsonObject.getBoolean(REALTIME_STOP);
			rank = stopJsonObject.getInt(RANK);
		} catch (JSONException e) {
			Log.e(Stop.class.getSimpleName(), e.getMessage());
		}

	}

	public int getWalkingDistance() {
		return walkingDistance;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public boolean isAlightningAllowed() {
		return alightningAllowed;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public boolean isBoardingAllowed() {
		return boardingAllowed;
	}

	public boolean isRealTimeStop() {
		return realTimeStop;
	}

	public int getRank() {
		return rank;
	}

	public String getZone() {
		return zone;
	}

	public ArrayList<Stop> getStops() {
		return stops;
	}

}
