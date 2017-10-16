package airportSecurityState.util;

import java.util.ArrayList;

public class Data {
    private int day;
    private String time;
    private String airline;
    private String item;
    private boolean isProhibited;

    public Data(int iDay, String iTime, String iAirline, String iItems){
        day=iDay;
        time=iTime;
        airline=iAirline.substring(8);
        item=iItems.substring(5);
        if(item.matches("Gun|Knife|Blade|NailCutter")){
            isProhibited=true;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getItems() {
        return item;
    }

    public void setItems(String item) {
        this.item = item;
    }

    public boolean isProhibited() {
        return isProhibited;
    }

    public void setProhibited(boolean prohibited) {
        isProhibited = prohibited;
    }


}
