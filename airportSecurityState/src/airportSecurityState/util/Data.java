package airportSecurityState.util;

public class Data {
    private int day;
    private String time;
    private int dayOrder;
    private float travellerCount = 0;
    private String airline;
    private String item;
    private boolean isProhibited;

    public Data(int iDay, String iTime, String iAirline, String iItems, int iCount, int idayOrder) {
        day=iDay;
        time=iTime;
        airline=iAirline.substring(8);
        item=iItems.substring(5);
        if(item.matches("Gun|Knife|Blade|NailCutter")){
            isProhibited=true;
        }
        travellerCount = iCount;
        dayOrder = idayOrder;
    }

    public int getDayOrder() {
        return dayOrder;
    }

    public float getTravellerCount() {
        return travellerCount;
    }

    public boolean isProhibited() {
        return isProhibited;
    }

}
