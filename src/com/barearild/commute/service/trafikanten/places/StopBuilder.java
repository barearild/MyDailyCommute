package com.barearild.commute.service.trafikanten.places;

import java.util.ArrayList;

import com.google.android.maps.GeoPoint;


public class StopBuilder {
			
	Stop stop = new Stop();
	
	public Stop build() {
		return stop;
	}
	
	public StopBuilder id(int id) {
		stop.id = id;
		return this;
	}
	
	public StopBuilder name(String name) {
		stop.name = name;
		return this;
	}
	
	public StopBuilder district(String district) {
		stop.district = district;
		return this;
	}
	
	public StopBuilder location(int x, int y) {
		stop.location = new GeoPoint(x, y);
		return this;
	}
	
	public StopBuilder type(Integer type) {
		stop.type = StopType.getStopType(type);
		return this;
	}
	
	public StopBuilder shortName(String shortName) {
		stop.shortName = shortName;
		return this;
	}
	
	public StopBuilder walkingDistance(int distance) {
		stop.walkingDistance = distance;
		return this;
	}
	
	public StopBuilder arrivalTime(Integer arrivalTime) {
		stop.arrivalTime = arrivalTime;
		return this;
	}
	
	public StopBuilder alightningAllowed(boolean allowed) {
		stop.alightingAllowed = allowed;
		return this;
	}
	
	public StopBuilder departureTime(Integer departureTime) {
		stop.departureTime = departureTime;
		return this;
	}
	
	public StopBuilder boardingAllowed(boolean allowed) {
		stop.boardingAllowed = allowed;
		return this;
	}
	
	public StopBuilder realTimeStop(boolean realTimeStop) {
		stop.realTimeStop = realTimeStop;
		return this;
	}
	
	public StopBuilder rank(Integer rank) {
		stop.rank = rank;
		return this;
	}
	
	public StopBuilder zone(String zone) {
		stop.zone = zone;
		return this;
	}
	
	public StopBuilder stops(ArrayList<Stop> stops) {
		stop.stops = stops;
		return this;
	}
	
//	ArrayList<Line> lines;
//	ArrayList<StopPoint> stopPoints;
	
	

}
