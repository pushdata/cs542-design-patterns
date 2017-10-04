package studentCoursesBackup.util;

import java.io.*;
import java.util.ArrayList;

/**
 * <p>FileProcessor Class is responsible for processing the input.txt and delete.txt.
 * It used BufferedReader,BufferedWriter to read and write.
 * </p>
 */

public class FileProcessor {

	private BufferedReader inputLineCount;
	private BufferedReader inputReader;
	private BufferedWriter outputWriter;


	/**
	 * <p>FileProcessor Default no-args Constructor
	 * </p>
	 */

	FileProcessor() {

	}

	/**
	 * <p>FileProcessor Constructor  is used to create a buffered reader object
	 * to read data from the input file
	 * </p>
	 * @param inputFile
	 * @exception Exception
	 * @return Nothing
	 */

	public FileProcessor(String inputFile){
		try {
			inputLineCount= new BufferedReader(new FileReader(inputFile));
			inputReader= new BufferedReader(new FileReader(inputFile));
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * <p>This FileProcessor Constructor method is used to create a buffered writer object
	 * to write data to the output files.
	 * </p>
	 * @param file1
	 * @param result
	 * @exception IOException
	 * @return Nothing
	 */

	public FileProcessor(String file1, ArrayList<String> result) throws IOException {

		outputWriter = new BufferedWriter(new FileWriter(new File(file1)));
		for (String line : result) {
			outputWriter.write(line);
			outputWriter.flush();
		}
		outputWriter.close();

	}

	/**
	 * <p>inputLineCount methods is used to return the number of lines in the given input file
	 * </p>
	 *
	 * @return the number of lines in the input text file
	 * @throws IOException
	 */
	public int inputLineCount() throws IOException {
		int lines = 0;
		try {
			while (inputLineCount.readLine() != null) {
				lines++;
			}
		} catch (IOException e) {
			System.err.println("Error while counting the no. of lines in the given input file");
			e.printStackTrace();
			System.exit(0);
		}
		inputLineCount.close();
		return lines;
	}

	/**
	 * <p>readLine method is used to return a line to the invoking method.
	 * </p>
	 * @exception IOException
	 * @return A line from the input file will be returned
	 */
	public String readLine() throws IOException{
		String inputLine = null;
		if(null!=inputReader)
			inputLine= inputReader.readLine();
		return inputLine;
	}

}