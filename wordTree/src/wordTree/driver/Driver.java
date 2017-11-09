package wordTree.driver;

import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.threadMgmt.Node;
import wordTree.util.ComputeResults;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

/**
 * <p>The Word Counter program implements an application that
 * simply displays the number of words,characters,distinct words
 * after processing the input file to the standard output.
 * </p>
 *
 * @author Sai Prudhvi Chode, Sravan Kumar Guduru
 * @version 1.0
 * @since 11/08/2017
 */
public class Driver {
    public static MyLogger logger = new MyLogger();
    public static FileProcessor fp;
    public static int NUM_THREADS = 0;
    private static int debugValue = -9;
    private static String deleteWords;
    private static volatile Node root = null;

    /**
     * <p>This is the main driver code where the program
     * execution brings, it creates the instances of Results,
     * FileProcessor,CreateWorkers etc.
     * </p>
     *
     * @param args - Input File, Output File, Num Of Threads, Words, Debug Value
     * @return void
     */

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

            NUM_THREADS = Integer.parseInt(args[2]);
            deleteWords = args[3].trim();
            debugValue = Integer.parseInt(args[4]);

            if (debugValue < 0 || debugValue > 4) {
                System.err.println("Debug Value should be [0-4]");
                System.exit(1);
            }

            logger.setDebugValue(debugValue);

            if (NUM_THREADS < 0 || NUM_THREADS > 4) {
                System.err.println("Number of threads should be [1-3]");
                System.exit(1);
            }

            int numOfWords = (deleteWords.isEmpty() ? 0 : deleteWords.split("\\s+").length);

            if (numOfWords != NUM_THREADS) {
                System.err.println("Number of Threads = Number of Delete words");
                System.exit(1);
            }

            Results results = new Results();

            fp = new FileProcessor(args[0], args[1]);

            CreateWorkers cw = new CreateWorkers(results, fp, NUM_THREADS);

            cw.startPopulateWorkers(NUM_THREADS);
            cw.startDeleteWorkers(args[3], NUM_THREADS);

            ComputeResults computeResults = new ComputeResults(results);

            results.writeSchedulesToFile(fp, computeResults);

            if (debugValue != 0) {
                results.writeToScreen(computeResults);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
