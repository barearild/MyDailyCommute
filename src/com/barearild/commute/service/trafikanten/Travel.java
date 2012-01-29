package com.barearild.commute.service.trafikanten;

import android.util.Log;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Travel {
    
    public static final String DEPARTURE_TIME = "DepartureTime";
    public static final String ARRIVAL_TIME = "ArrivalTime";
    public static final String REMARKS = "Remarks";
    public static final String TRAVEL_STAGES = "TravelStages";

    Date departureTime;
    Date arrivalTime;
    ArrayList<String> remarks = new ArrayList<String>();
    ArrayList<TravelStage> travelStages = new ArrayList<TravelStage>();

    public Travel() {
    }

    public Travel(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if(name.equals(Travel.DEPARTURE_TIME)) {
                departureTime = JSONConnector.jsonStringToDate(reader.nextString());
            } else if(name.equals(Travel.ARRIVAL_TIME)) {
                arrivalTime = JSONConnector.jsonStringToDate(reader.nextString());
            } else if(name.equals(Travel.REMARKS)) {
//                reader.beginArray();
//                while (reader.hasNext()) {
//                    reader.beginObject();
//                    while (reader.hasNext()) {
//
//                    }
//                }
                reader.skipValue();
            } else if(name.equals(Travel.TRAVEL_STAGES)) {
                reader.beginArray();
                while (reader.hasNext()) {
                    travelStages.add(new TravelStage(reader));
                }
                reader.endArray();
            } else {
                reader.skipValue();
                Log.d(JSONConnector.class.getSimpleName(), "Name not mapped for Travel: " + name);
            }
        }
        reader.endObject();

    }



    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public ArrayList<String> getRemarks() {
        return remarks;
    }

    public void setRemarks(ArrayList<String> remarks) {
        this.remarks = remarks;
    }
    
    public void addRemark(String remark) {
        this.remarks.add(remark);
    }

    public ArrayList<TravelStage> getTravelStages() {
        return travelStages;
    }

    public void setTravelStages(ArrayList<TravelStage> travelStages) {
        this.travelStages = travelStages;
    }

    public void addTravelStage(TravelStage travelStage) {
        this.travelStages.add(travelStage);
    }
}
