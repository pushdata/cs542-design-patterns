package studentCoursesBackup.util;

import java.io.*;
import java.util.ArrayList;


public class FileProcessor {

	private BufferedReader inputLineCount;
	private BufferedReader deleteLineCount;
	private BufferedReader inputReader;
	private BufferedReader deleteReader;
	private BufferedWriter outputWriter;

	FileProcessor() {

	}
	public FileProcessor(String inputFile){
		try {
			inputLineCount= new BufferedReader(new FileReader(inputFile));
			//outputLineCount= new BufferedReader(new FileReader(deleteFile));
			inputReader= new BufferedReader(new FileReader(inputFile));
			//deleteReader= new BufferedReader(new FileReader(deleteFile));
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			System.exit(1);
		}

	}

	public FileProcessor(String file1, String file2, String file3, ArrayList<String> result) throws IOException {

		outputWriter = new BufferedWriter(new FileWriter(new File(file1)));
		for (String line : result) {
			outputWriter.write(line);
			outputWriter.flush();
		}
		outputWriter.close();

	}
	public int inputLineCount() throws IOException{
		int lines=0;
		while (inputLineCount.readLine() != null) {
			lines++;
		}
		inputLineCount.close();
		return lines;
	}
	
	public int deleteLineCount() throws IOException{
		int lines=0;
		while (deleteLineCount.readLine() != null) {
			lines++;
		}
		deleteLineCount.close();
		return lines;
	}
	
	//Returns each line from inputFile to invoking method
	public String readLine() throws IOException{
		String inputLine =null;
		if(null!=inputReader)		
			inputLine= inputReader.readLine();
		return inputLine;
	}


	public BufferedReader getBufferedReader() {
		return inputReader;
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.inputReader = bufferedReader;
	}

	public BufferedWriter getBufferedWriter() {
		return outputWriter;
	}

	public void setBufferedWriter(BufferedWriter bufferedWriter) {
		this.outputWriter = bufferedWriter;
	}
}