package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

import java.io.IOException;

/**
 * <h1>Backup System For Student Course Assignments</h1>
 * The Driver program implements an application that
 * simply accepts 5 files as command line arguments.
 * It processes the input.txt,delete.txt and then writes
 * the results from the 3 Trees to the three output files.
 *
 * @author Sai Prudhvi Chode
 * @version 1.0
 * @since 10-03-2017
 */

public class Driver 
{
    /**
     * <p>
     * This is the main method where the application starts execution.
     * This is provided with 5 command-line args.
     *
     * @param args Five arguments should be supplied to the program to work correctly.
     *             </p>
     *             <p>
     *             This method is responsible for reading command-line arguments,
     *             building the 3 trees, processing the input.txt and delete.txt
     *             </p>
     *             <p>
     *             Creating a Results instance for each of the three trees and printing the
     *             results of each tree to output1.txt output2.txt output3.txt using the
     *             FileDisplayInterface.
     *             </p>
     * @return Nothing.
     * @throws IOException On invalid input
     * @see IOException
     */

    public static void main(String[] args) throws IOException {

        FileProcessor fp = null;
        String inputArray[];
        int inputLineCount;
        try {
            if (args.length != 5) {
                System.err.println("No of args should be equal to 5");
                System.exit(0);
            }
            fp = new FileProcessor(args[0]);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid number of arguments supplied. Please provide 5 args");
            e.printStackTrace();
            System.exit(0);
        }

        TreeBuilder tb = new TreeBuilder();

        inputLineCount = fp.inputLineCount();

        for (int i = 0; i < inputLineCount; i++) {
            String line = fp.readLine();
            if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
            } else {
                inputArray = line.split(":");
                tb.insert(Integer.parseInt(inputArray[0]), inputArray[1]);
            }
        }

        fp = new FileProcessor(args[1]);
        inputLineCount = fp.inputLineCount();
        for (int i = 0; i < inputLineCount; i++) {
            String line = fp.readLine();
            if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
            } else {
                inputArray = line.split(":");
                tb.delete(Integer.parseInt(inputArray[0]), inputArray[1]);
            }
        }


        Results r = new Results();
        Results rb1 = new Results();
        Results rb2 = new Results();

        tb.printNodes(r, rb1, rb2, tb.getRoot());
        r.writeToFile(args[2]);
        rb1.writeToFile(args[3]);
        rb2.writeToFile(args[4]);
    }
}
			