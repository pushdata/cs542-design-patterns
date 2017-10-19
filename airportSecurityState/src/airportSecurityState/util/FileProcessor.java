package airportSecurityState.util;

import airportSecurityState.driver.Driver;

import java.io.*;

public class FileProcessor {

    private String inputFile;
    private String outputFile;
    private BufferedReader inputReader;
    private BufferedWriter outputWriter;

    public FileProcessor(String inputFile) {
        this.inputFile = inputFile;
        this.outputFile = "output.txt";
        readFile(inputFile);
    }

    public FileProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        readFile(inputFile);
    }

    public void writeFile() {
        try {
            outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
            for (String line : Driver.operations_list) {
                outputWriter.write(line);
                outputWriter.newLine();
                outputWriter.flush();
            }
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

    public void readFile(String inputFile) {
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
                Driver.count++;
                temp = line.split(";");
                Driver.days.add(Integer.parseInt(temp[0].substring(4)));
                Driver.data.add(new Data(Integer.parseInt(temp[0].substring(4)), temp[1].substring(4), temp[2], temp[3], Driver.count, Driver.days.size()));
                line = inputReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
            e.printStackTrace();
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