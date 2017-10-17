package airportSecurityState.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import airportSecurityState.airportStates.RiskState;
import airportSecurityState.util.Data;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.SecurityFactors;

public class Driver {
    private static ArrayList<Data> data = new ArrayList<>();
    public static Queue<String> operations_list = new LinkedList<>();
    public static Set<Integer> days = new HashSet<>();
    public static MyLogger logger = new MyLogger();
    private static SecurityFactors sf;
    private static int debugValue = -9;
    private static int count = 0;
    private static RiskState riskState;

    public static void main(String args[]) throws IOException {
        System.out.println("Working from Main!");
        if (args.length < 1 || args.length > 3) {
            System.err.println("Usage: java <Main Class> <Argument 1>");
            System.exit(0);
        }
        BufferedReader br = null;
        FileWriter fw = null;
        switch (args.length) {
            case 1:
                br = new BufferedReader(new FileReader(args[0]));
                break;
            case 2:
                br = new BufferedReader(new FileReader(args[0]));
                fw = new FileWriter(args[1]);
                break;
            case 3:
                br = new BufferedReader(new FileReader(args[0]));
                fw = new FileWriter(args[1]);
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

        try {
            String line = br.readLine();
            if (line == null) {
                System.err.println("Empty File Supplied!");
                System.exit(0);
            }
            String[] temp;
            while (line != null) {
                count++;
                temp=line.split(";");
                days.add(Integer.parseInt(temp[0].substring(4)));
                data.add(new Data(Integer.parseInt(temp[0].substring(4)), temp[1].substring(4), temp[2], temp[3], count, days.size()));
                line = br.readLine();
            }
        }
        catch (IOException e){
            System.err.println("Error Reading from File");
            e.printStackTrace();
            System.exit(0);
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error closing BufferReader");
                e.printStackTrace();
                System.exit(0);
            }
        }
        sf = new SecurityFactors();
        riskState = new RiskState();
        sf.calculateAverageValues(data);
        riskState.invokeSecurity(sf.getAverageTrafficPerDay(), sf.getAverageProhibitedPerDay());
    }
}
