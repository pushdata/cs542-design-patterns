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

    public static void main(String args[]) throws IOException {
        System.out.println("Working from Main!");
        if (args.length < 1 || args.length > 3) {
            System.err.println("Usage: java <Main Class> <Argument 1>");
            System.exit(0);
        }
        switch (args.length) {
            case 1:
                fp = new FileProcessor(args[0]);
                break;
            case 2:
                fp = new FileProcessor(args[0], args[1]);
                break;
            case 3:
                fp = new FileProcessor(args[0], args[1]);
                debugValue = Integer.parseInt(args[2]);
                if (debugValue < 0 || debugValue > 4) {
                    System.err.println("Invalid Debug Value. Debug value range is [0-4]");
                    System.exit(0);
                }
                logger.setDebugValue(debugValue);
                break;
            default:
                System.err.println("Invalid number of arguments supplied!");
                System.exit(0);
        }
        sf = new SecurityFactors();
        riskState = new RiskState();
        sf.calculateAverageValues(data);
        riskState.invokeSecurity(sf.getAverageTrafficPerDay(), sf.getAverageProhibitedPerDay());
        fp.writeFile();

    }
}
