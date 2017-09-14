package src.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

	private BufferedReader bufferedReader;

	public FileProcessor(String inputFileName_in){
		try {
			bufferedReader= new BufferedReader(new FileReader(inputFileName_in));

		}catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: "+e.getMessage());
			System.exit(1);
		}

	}

	public String readLine() throws IOException{
		String line =null;
		if(null!=bufferedReader)		
			line= bufferedReader.readLine();
		return line;
	}



	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
}