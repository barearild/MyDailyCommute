package com.barearild.commute.service.trafikanten.places;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Stop extends Place {

	protected static final String WALKING_DISTANCE = "WalkingDistance";
	protected static final String ARRIVAL_TIME = "ArrivalTime";
	protected static final String ALIGHTING_ALLOWED = "AlightingAllowed";
	protected static final String DEPARTURE_TIME = "DepartureTime";
	protected static final String BOARDING_ALLOWED = "BoardingAllowed";
	protected static final String REALTIME_STOP = "RealTimeStop";
	protected static final String RANK = "Rank";
	protected static final String ZONE = "Zone";

    protected static final StopType TYPE = StopType.Stop;

    Integer walkingDistance;
	Integer arrivalTime;
	boolean alightingAllowed;
	Integer departureTime;
	boolean boardingAllowed;
	boolean realTimeStop;
	Integer rank;
	// ArrayList<Line> lines;
	// ArrayList<StopPoint> stopPoints;
	String zone;
	ArrayList<Stop> stops;

	public Stop() {
		super();
	}

	public Stop(JSONObject stopJsonObject) throws JSONException {
		super(stopJsonObject);

		walkingDistance = getIntegerNullSafe(WALKING_DISTANCE, stopJsonObject);
		arrivalTime = getIntegerNullSafe(ARRIVAL_TIME, stopJsonObject);
		alightingAllowed = stopJsonObject.getBoolean(ALIGHTING_ALLOWED);
		departureTime = getIntegerNullSafe(DEPARTURE_TIME, stopJsonObject);
		boardingAllowed = stopJsonObject.getBoolean(BOARDING_ALLOWED);
		realTimeStop = stopJsonObject.getBoolean(REALTIME_STOP);
		rank = getIntegerNullSafe(RANK, stopJsonObject);
		zone = stopJsonObject.getString(ZONE);

	}

    @Override
    public StopType getType() {
        return TYPE;
    }

    public Integer getWalkingDistance() {
		return walkingDistance;
	}

	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public boolean isAlightingAllowed() {
		return alightingAllowed;
	}

	public Integer getDepartureTime() {
		return departureTime;
	}

	public boolean isBoardingAllowed() {
		return boardingAllowed;
	}

	public boolean isRealTimeStop() {
		return realTimeStop;
	}

	public Integer getRank() {
		return rank;
	}

	public String getZone() {
		return zone;
	}

	public ArrayList<Stop> getStops() {
		return stops;
	}

}
