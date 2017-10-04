package studentCoursesBackup.util;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>Results Class implements the FileDisplayInterface,StdoutDisplayInterface.
 * It is responsible for writing the data to the 3 output files.
 * </p>
 */


public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private ArrayList<String> result = new ArrayList<>();

    /**
     * <p>This is the Results default constructor method.
     * </p>
     */
    public Results() {
    }


    /**
     * <p>getResult() method returns the ArrayList containing the output result.
     * </p>
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getResult() {
        return result;
    }


    /**
     * <p>setResult() method will add the final output to the ArrayList.
     * </p>
     *
     * @return ArrayList<String>
     */
    public void setResult(String res) {
        String temp = res.toString().replace("[", "").replace("]", "");
        result.add(temp + "\n");
    }

    /**
     * <p>writeToFile(String file1) method will create a FileProcessor object with output file and final Result.
     * </p>
     * @param file1 outputFile
     * @exception IOException
     * @return ArrayList<String>
     */
    public void writeToFile(String file1) {
        try {
            FileProcessor fp = new FileProcessor(file1, this.getResult());
        } catch (IOException e) {
            System.out.println("Error while writing to File");
            e.printStackTrace();
        }
    }
}
