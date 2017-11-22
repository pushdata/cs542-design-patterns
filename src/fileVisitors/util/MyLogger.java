package fileVisitors.util;

//import fileVisitors.util.MyLogger.DebugLevel;

public class MyLogger {

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime when the thread's run method in invoked]
      DEBUG_VALUE=2 [Print to stdout when the words are being deleted]
      DEBUG_VALUE=1 [Print to stdout when the words are being populated]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */

    private static DebugLevel debugLevel;

    public static void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 4:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;
            case 3:
                debugLevel = DebugLevel.PRINT_TREE;
                break;
            case 2:
                debugLevel = DebugLevel.POPULATE_TREE;
                break;
            case 1:
                debugLevel = DebugLevel.PALINDROME_CHECKER;
                break;
            case 0:
                debugLevel = DebugLevel.RELEASE;
                break;
        }
    }

    public static void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage(String message,
                                    DebugLevel levelIn) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    /**
     * @return String
     */
    public String toString() {
        return "Debug Level is " + debugLevel;
    }


    public static enum DebugLevel {
        RELEASE, PALINDROME_CHECKER, POPULATE_TREE, PRINT_TREE, CONSTRUCTOR
    }
}