package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileProcessor {

	private BufferedReader inputLineCount;
	private BufferedReader deleteLineCount;
	private BufferedReader inputReader;
	private BufferedReader deleteReader;
	private BufferedWriter outputOneWriter;
	private BufferedWriter outputTwoWriter;
	private BufferedWriter outputThreeWriter;
	public FileProcessor(String inputFile){
			//,String deleteFile,String outputOne,String outputTwo, String outputThree){
		try {
			inputLineCount= new BufferedReader(new FileReader(inputFile));
			//outputLineCount= new BufferedReader(new FileReader(deleteFile));
			inputReader= new BufferedReader(new FileReader(inputFile));
			//deleteReader= new BufferedReader(new FileReader(deleteFile));
			//outputOneWriter=new BufferedWriter(new FileWriter(new File(outputOne)));
			//outputTwoWriter=new BufferedWriter(new FileWriter(new File(outputTwo)));
			//outputThreeWriter=new BufferedWriter(new FileWriter(new File(outputThree)));

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			System.exit(1);
		}

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

	//Writes output from testcases to file
	public void writeOutput(String line){
		try {
			outputOneWriter.write(line);
			outputOneWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
	}

	public BufferedReader getBufferedReader() {
		return inputReader;
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.inputReader = bufferedReader;
	}

	public BufferedWriter getBufferedWriter() {
		return outputOneWriter;
	}

	public void setBufferedWriter(BufferedWriter bufferedWriter) {
		this.outputOneWriter = bufferedWriter;
	}
}