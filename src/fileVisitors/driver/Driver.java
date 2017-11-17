package fileVisitors.driver;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.visitor.Node;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.TreeBuilder;


public class Driver {

	  public static FileProcessor fp;
	  private static volatile Node root = null;
	  public static MyLogger logger = new MyLogger();
	  private static int debugValue = -9;
	  private static String deleteWords;
	public static void main(String[] args) {
		        try {
		            if (args.length != 3) {
		                System.err.println("Usage: java <MainClass> <InputFile> <OutputFile> <NUM_THREADS> <Words> <DebugValue[0-2]>");
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

		            debugValue = Integer.parseInt(args[2]);
		            deleteWords = args[1].trim();

		            if (debugValue < 0 || debugValue > 4) {
		                System.err.println("Debug Value should be [0-4]");
		                System.exit(1);
		            }

		            logger.setDebugValue(debugValue);

		           

		            int numOfWords = (deleteWords.isEmpty() ? 0 : deleteWords.split("\\s+").length);

		        //    Results results = new Results();

		            fp = new FileProcessor(args[0], args[1]);

		            PopulateVisitor populate_visitor = new PopulateVisitor(fp);

		       //     cw.startPopulateWorkers(NUM_THREADS);
		         //   cw.startDeleteWorkers(args[3], NUM_THREADS);

		           // ComputeResults computeResults = new ComputeResults(results);

		            //results.writeSchedulesToFile(fp, computeResults);

		           // if (debugValue != 0) {
		             //   results.writeToScreen(computeResults);
		            //}

		        } catch (NumberFormatException e) {
		            e.printStackTrace();
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {

		        }
		    }

	}

