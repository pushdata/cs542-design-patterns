package airportSecurityState.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import airportSecurityState.airportStates.RiskState;
import airportSecurityState.util.Data;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.SecurityFactors;

public class Driver {
    private static ArrayList<Data> data = new ArrayList<>();
    public static Queue<String> operations_list = new LinkedList<>();
    public static Set<Integer> days = new HashSet<Integer>();
    private static int count = 0;
    private static RiskState riskState = new RiskState();
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("Working from Main!");
        if(args.length!=1){
            System.err.println("Usage: java <Main Class> <Argument 1>");
            System.exit(0);
        }
        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        try {
            StringBuilder sb = new StringBuilder();
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
        SecurityFactors sf = new SecurityFactors();
        sf.calculateAverageValues(data);
        riskState.invokeSecurity(sf.getAverageTrafficPerDay(), sf.getAverageProhibitedPerDay());
        MyLogger ml = new MyLogger();

    }
}
