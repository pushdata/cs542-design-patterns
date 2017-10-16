package airportSecurityState.util;

import airportSecurityState.airportStates.AirportStateI;

import java.util.ArrayList;
import java.util.HashMap;

public class SecurityFactors {
    AirportStateI state;
    HashMap<Integer,Integer> averageDay = new HashMap<>();
    HashMap<Integer,Integer> averageProhibitedPerDay = new HashMap<>();
    public SecurityFactors(){
    }

    public void AverageTrafficPerDay(ArrayList<Data> data){
        for(Data d:data){
            averageDay.put(d.getDay(),averageDay.getOrDefault(d.getDay(),1)+1);
        }
    }

    public void AverageProhibitedItemsPerDay(ArrayList<Data> data){
    }
}
