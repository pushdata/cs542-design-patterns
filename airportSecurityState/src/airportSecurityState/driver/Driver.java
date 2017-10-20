package airportSecurityState.driver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import airportSecurityState.airportStates.RiskState;
import airportSecurityState.util.Data;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.SecurityFactors;

public class Driver {
    public static ArrayList<Data> data = new ArrayList<>();
    public static Queue<String> operations_list = new LinkedList<>();
    public static Set<Integer> days = new HashSet<>();
    public static MyLogger logger = new MyLogger();
    public static FileProcessor fp;
    private static SecurityFactors sf;
    private static int debugValue = -9;
    public static int count = 0;
    private static RiskState riskState;

    //Invokes FileProcessor,Delegates processing to SecurityFactors,Validates the debug value
    public static void main(String args[]) {
        try {
            if (args.length != 3) {
                System.err.println("Usage: java <MainClass> <InputFile> <OutputFile> <DebugValue[0-4]>");
                System.exit(0);
            }


            if (null == args[0] || args[0].equals("${arg0}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);

            }


            if (null == args[1] || args[1].equals("${arg1}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);
            }


            if (null == args[2] || args[2].equals("${arg2}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);
            }

            fp = new FileProcessor(args[0], args[1]);
            debugValue = Integer.parseInt(args[2]);
            if (debugValue < 0 || debugValue > 4) {
                System.err.println("Invalid Debug Value. Debug value range is [0-4]");
                System.exit(0);
            }
            logger.setDebugValue(debugValue);

            //Helper Class to Calculate the average values
            sf = new SecurityFactors();

            //Context Class used by Low Risk,Moderate Risk,High Risk states
            riskState = new RiskState();

            sf.calculateAverageValues(data);
            riskState.invokeSecurity(sf.getAverageTrafficPerDay(), sf.getAverageProhibitedPerDay());
            fp.writeFile();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}
