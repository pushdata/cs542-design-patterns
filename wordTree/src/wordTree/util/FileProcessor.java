package wordTree.util;

import wordTree.driver.Driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import static wordTree.util.MyLogger.DebugLevel.CONSTRUCTOR;

public class FileProcessor {

    private String inputFile;
    private String outputFile;
    private BufferedReader inputReader;
    private BufferedWriter outputWriter;

    public FileProcessor(String iInput, String iOutput) {
        MyLogger.writeMessage("File Processor Constructor Called", CONSTRUCTOR);
        inputFile = iInput;
        outputFile = iOutput;
        readFile(inputFile);
    }

    //Writes the operations to the output file
    public void writeFile() {
        try {
            outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
//            for (String line : Driver.operations_list) {
//                outputWriter.write(line);
//                outputWriter.newLine();
//                outputWriter.flush();
//            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Error Writing to File!");
            e.printStackTrace();
            System.exit(0);
        } finally {
            try {
                outputWriter.close();
            } catch (IOException e) {
                System.err.println("Error Closing FileWriter!");
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    //Reads the data from the input file
    public synchronized void readFile(String inputFile) {
        String line = null;
        String[] temp;

        try {
            inputReader = new BufferedReader(new FileReader(inputFile));
            line = inputReader.readLine();
            if (line == null) {
                System.err.println("Empty File Supplied!");
                System.exit(0);
            }
            while (line != null) {
                line = inputReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Error Reading from File");
            e.printStackTrace();
            System.exit(0);
        } finally {
            try {
                inputReader.close();
            } catch (IOException e) {
                System.err.println("Error Closing FileReader!");
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

}