package com.barearild.commute.service.trafikanten.places;

public enum StopType {
	
	Stop,
	Area,
	POI,
	Street,
	None;
	
	private StopType() {
	}
	
	public static StopType getStopType(int type) {
		return StopType.values()[type];
	}
	
}
