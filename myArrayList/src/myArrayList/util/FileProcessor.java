package myArrayList.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileProcessor {

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	public FileProcessor(String inputFileName_in, String outputFile){
		try {
			bufferedReader= new BufferedReader(new FileReader(inputFileName_in));
			bufferedWriter=new BufferedWriter(new FileWriter(new File(outputFile)));
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			System.exit(1);
		}

	}
	
	//Returns each line from inputFile to invoking method
	public String readLine() throws IOException{
		String line =null;
		if(null!=bufferedReader)		
			line= bufferedReader.readLine();
		return line;
	}

	//Writes output from testcases to file
	public void writeOutPuttoFile(String line){
		try {
			bufferedWriter.write(line);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
	}

	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}

	public void setBufferedWriter(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}
}