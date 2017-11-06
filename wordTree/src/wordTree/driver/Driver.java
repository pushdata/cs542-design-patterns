package wordTree.driver;

import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.threadMgmt.Node;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class Driver {
    public static MyLogger logger = new MyLogger();
    public static FileProcessor fp;
    public static int NUM_THREADS = 0;
    private static int debugValue = -9;
    private static volatile Node root = null;


    //Invokes FileProcessor,Delegates processing to SecurityFactors,Validates the debug value
    public static void main(String args[]) {
        try {
            if (args.length != 5) {
                System.err.println("Usage: java <MainClass> <InputFile> <OutputFile> <NUM_THREADS> <Words> <DebugValue[0-4]>");
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

            if (null == args[3] || args[3].equals("${arg3}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);
            }

            if (null == args[4] || args[4].equals("${arg4}")) {
                System.err.println("Please provide valid input arguments");
                System.exit(1);
            }

            fp = new FileProcessor(args[0]);
            Results r = new Results();
            CreateWorkers cw = new CreateWorkers(r, fp, Integer.parseInt(args[2]));
            cw.testM();
            //       cw.startPopulateWorkers();
            NUM_THREADS = Integer.parseInt(args[2]);
            debugValue = Integer.parseInt(args[4]);
            if (debugValue < 0 || debugValue > 4) {
                System.err.println("Invalid Debug Value. Debug value range is [0-4]");
                System.exit(0);
            }
            logger.setDebugValue(debugValue);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
