package genericCheckpointing.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static genericCheckpointing.util.MyLogger.DebugLevel.*;

public class FileProcessor {

    private static int index = 0;
    private String inputFile;
    private String outputFile;
    private ArrayList<String> words = new ArrayList<>();
    private BufferedWriter outputWriter;

    public FileProcessor(String iFile, String oFile) {
        MyLogger.writeMessage("File Processor Constructor Called", CONSTRUCTOR);
        inputFile = iFile;
        outputFile = oFile;
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

    public void writeFile(StringBuilder s) {
        try {
            outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
            outputWriter.write(s.toString());
            outputWriter.flush();
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
            return data;
        }
    }
}