package wordTree.driver;

import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class Driver {
    public static MyLogger logger = new MyLogger();
    public static FileProcessor fp;
    public static int NUM_THREADS = 0;
    private static int debugValue = -9;

    //Invokes FileProcessor,Delegates processing to SecurityFactors,Validates the debug value
    public static void main(String args[]) {
        try {
            if (args.length != 4) {
                System.err.println("Usage: java <MainClass> <InputFile> <OutputFile> <NUM_THREADS> <DebugValue[0-4]>");
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
            NUM_THREADS = Integer.parseInt(args[2]);
            debugValue = Integer.parseInt(args[3]);
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
