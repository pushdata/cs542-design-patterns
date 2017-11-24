package fileVisitors.driver;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.visitor.*;


public class Driver {

    public static MyLogger logger = new MyLogger();

    private static int debugValue = -9;

	public static void main(String[] args) {
        try {
            if (args.length != 3) {
                System.err.println("Usage: java <MainClass> <InputFile> <OutputFile> <DebugValue[0-2]>");
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

            if (debugValue < 0 || debugValue > 4) {
                System.err.println("Debug Value should be [0-4]");
                System.exit(1);
            }

            logger.setDebugValue(debugValue);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        FileProcessor fileProcessor = new FileProcessor(args[0], args[1]);

        TreeBuilder treeBuilder = new TreeBuilder();

        PopulateVisitor populateVisitor = new PopulateVisitor(fileProcessor);

        treeBuilder.accept(populateVisitor);

        PalindromeHighlight palindromeHighlightVisitor = new PalindromeHighlight(populateVisitor.getTree());

        treeBuilder.accept(palindromeHighlightVisitor);

        PrimeLength primeLengthVisitor = new PrimeLength(palindromeHighlightVisitor.getTree());

        treeBuilder.accept(primeLengthVisitor);

        PrintTree printTreeVisitor = new PrintTree(primeLengthVisitor.getTree(), fileProcessor);

        treeBuilder.accept(printTreeVisitor);
    }


}

