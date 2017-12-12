package genericCheckpointing.util;

import java.io.*;
import java.util.Scanner;

import static genericCheckpointing.util.MyLogger.DebugLevel.*;

public class FileProcessor {

    private static int index = 0;
    public String checkpointFile;
    private Scanner scanner;
    private FileWriter fileWriter;

    public FileProcessor() {
    }

    public FileProcessor(String iFile) {
        MyLogger.writeMessage("File Processor Constructor Called", CONSTRUCTOR);
        checkpointFile = iFile;
    }


    public void initializeReader() {
        try {
            scanner = new Scanner(new File(checkpointFile));
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
            e.printStackTrace();
            System.exit(0);
        }
    }


    public void initializeWriter() {
        try {
            fileWriter = new FileWriter(checkpointFile, false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public String readLine() {
        return scanner.nextLine();
    }

    public void closeRead() {
        scanner.close();
    }

    public void closeWrite() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(StringBuilder s) {
        try {
            fileWriter.write(s.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}