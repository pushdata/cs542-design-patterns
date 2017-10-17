package airportSecurityState.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
      DEBUG_VALUE=2 [Print to stdout everytime there is a transition from Low Risk State to High Risk State]
      DEBUG_VALUE=1 [Print to stdout everytime there is a transition from High Risk State to Low Risk State]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */

    private static DebugLevel debugLevel;

    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
            // FIXME: add code for other cases
            case 3:
                debugLevel = DebugLevel.STATE_CHANGE;
                break;
            case 2:
                debugLevel = DebugLevel.LOW_TO_HIGH;
                break;
            case 1:
                debugLevel = DebugLevel.HIGH_TO_LOW;
                break;
            case 0: debugLevel = DebugLevel.RELEASE; break;
        }
    }


    public static enum DebugLevel {
        RELEASE, STATE_CHANGE, LOW_TO_HIGH, HIGH_TO_LOW, CONSTRUCTOR
    }

    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    /**
     * @return String
     */
    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}