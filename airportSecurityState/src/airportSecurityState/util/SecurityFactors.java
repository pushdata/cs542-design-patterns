package airportSecurityState.util;

import airportSecurityState.airportStates.AirportStateI;

import java.util.ArrayList;
import java.util.HashMap;

public class SecurityFactors {
    AirportStateI state;

    private HashMap<Integer, Float> averageTrafficPerDay = new HashMap<>();
    private HashMap<Integer, Float> averageProhibitedPerDay = new HashMap<>();

    public HashMap<Integer, Float> getAverageTrafficPerDay() {
        return averageTrafficPerDay;
    }

    public void setAverageTrafficPerDay(HashMap<Integer, Float> averageTrafficPerDay) {
        this.averageTrafficPerDay = averageTrafficPerDay;
    }

    public HashMap<Integer, Float> getAverageProhibitedPerDay() {
        return averageProhibitedPerDay;
    }

    public void setAverageProhibitedPerDay(HashMap<Integer, Float> averageProhibitedPerDay) {
        this.averageProhibitedPerDay = averageProhibitedPerDay;
    }

    public SecurityFactors(){
    }

    public void calculateAverageValues(ArrayList<Data> data) {
        int line = 0;
        float count = 0;
        for(Data d:data){
            averageTrafficPerDay.put(line, (float) (d.getTravellerCount() / d.getDayOrder()));
            if (d.isProhibited()) {
                count++;
            }
            averageProhibitedPerDay.put(line, (count / d.getDayOrder()));
            line++;
        }

    }

}
