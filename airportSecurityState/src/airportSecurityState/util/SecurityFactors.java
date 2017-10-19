package airportSecurityState.util;

import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.driver.Driver;
import java.util.ArrayList;
import java.util.HashMap;

import static airportSecurityState.util.MyLogger.DebugLevel.CONSTRUCTOR;

public class SecurityFactors {

    private HashMap<Integer, Float> averageTrafficPerDay = new HashMap<>();
    private HashMap<Integer, Float> averageProhibitedPerDay = new HashMap<>();

    public HashMap<Integer, Float> getAverageTrafficPerDay() {
        return averageTrafficPerDay;
    }
    public HashMap<Integer, Float> getAverageProhibitedPerDay() {
        return averageProhibitedPerDay;
    }

    public SecurityFactors(){
        Driver.logger.writeMessage("Security Factors Constructor Called!", CONSTRUCTOR);
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
