package genericCheckpointing.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static genericCheckpointing.util.MyLogger.DebugLevel.*;

public class FileProcessor {

    private static int index = 0;
    private String inputFile;
    private Scanner scanner;
    private String outputFile;
    private BufferedWriter outputWriter;

    public FileProcessor(String iFile) {
        MyLogger.writeMessage("File Processor Constructor Called", CONSTRUCTOR);
        inputFile = iFile;
    }


    public void initializeScanner() {
        try {
            scanner = new Scanner(new File(inputFile));
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Error Reading from File");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public String readLine() {
        return scanner.nextLine();
    }


//    public void writeFile(StringBuilder s) {
//        try {
//            outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
//            outputWriter.write(s.toString());
//            outputWriter.flush();
//        } catch (FileNotFoundException e) {
//            System.err.println("File Not Found!");
//            e.printStackTrace();
//            System.exit(0);
//        } catch (IOException e) {
//            System.err.println("Error Writing to File!");
//            e.printStackTrace();
//            System.exit(0);
//        } finally {
//            try {
//                outputWriter.close();
//            } catch (IOException e) {
//                System.err.println("Error Closing FileWriter!");
//                e.printStackTrace();
//                System.exit(0);
//            }
//        }
//
//    }
}