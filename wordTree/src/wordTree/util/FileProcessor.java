package wordTree.util;

import wordTree.driver.Driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static wordTree.util.MyLogger.DebugLevel.CONSTRUCTOR;

public class FileProcessor {

    private String inputFile;
    private String outputFile;
    private static int index = 0;
    private ArrayList<String> words = new ArrayList<>();
    private BufferedReader inputReader;
    private BufferedWriter outputWriter;

    public FileProcessor(String iFile) {
        MyLogger.writeMessage("File Processor Constructor Called", CONSTRUCTOR);
        inputFile = iFile;
        Scanner sc1 = null;
        try {
            sc1 = new Scanner(new File(inputFile));
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Error Reading from File");
            e.printStackTrace();
            System.exit(0);
        }
        while (sc1.hasNextLine()) {
            Scanner sc2 = new Scanner(sc1.nextLine());
            while (sc2.hasNext()) {
                String s = sc2.next();
                words.add(s);
            }
        }

    }

    //Writes the operations to the output file
    public void writeFile() {
        try {
            outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
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

    public synchronized String readWord() {
        if (index > words.size() - 1) {
            return null;
        } else {
            String data = words.get(index);
            index++;
            System.out.println(index + " index");
            return data;
        }
    }
}