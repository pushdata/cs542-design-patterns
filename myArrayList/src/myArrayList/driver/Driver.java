package myArrayList.driver;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver 
{
	private static String outputFile=null;

	public static void main(String[] args) {
		try {
			Driver driver=new Driver();
			driver.validateGivenArguments(args);;
			Results results;
			FileProcessor processor= new FileProcessor(args[0],outputFile);
			MyArrayList list= new MyArrayList();
			MyArrayListTest arrayListTest= new MyArrayListTest();
			String line=null;
			//Error Checking for Input File
			while((line= processor.readLine())!=null){
				try{
					int value=Integer.parseInt(line);
					list.insertSorted(value);
				}
				catch(NumberFormatException e){
					System.err.println("Error in parsing input file. Input file should contains only integers(0-10000)");
					System.exit(0);
				}
				
			}
			results=new Results(processor);
			arrayListTest.testMe(list, results);
			for(String testResult: results.getTestCaseResults()){
				results.writeOutpuToFile(testResult);
			}
			BufferedWriter writer=processor.getBufferedWriter();
			results.writeOutpuToFile("\nThe sum of all the values in the array list is: "+list.sum());

			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	//Validates command line arguments
	private void validateGivenArguments(String[] args){
		String inputFile=null;	
		try {
			if (args.length==0) {
				System.out.println(args.length);
				System.err.println("No of arguments should be equal to 2" );
				System.exit(1);
			}
			if (args[0]!=null && !args[0].equals("${arg0}")) {
				inputFile = args[0];
				validateInputFile(inputFile);
			}
			if(args.length==1){
			outputFile = "output.txt";
			File file= new File(outputFile);
			if(!file.exists()){
				file.createNewFile();
			}
			}
			else{
				outputFile = args[1];
				File file= new File(outputFile);
				if(!file.exists()){
					file.createNewFile();
			}
			}

		}	catch (Exception exception) {
			System.err.println("Exception in in method validateGivenArguments in Driver.java");
			System.exit(1);
		}
		finally{
		}
	}
	
	//Checks for File Validity
	public static void validateInputFile(String input_FileName){
		try {
			File file= new File(input_FileName);
			if(!file.exists() || !file.canRead()){
				System.err.println("The file "+input_FileName+ " does not exist or is not readable"  );
				System.exit(1);
			}
		}catch (Exception exception) {
			System.err.println("Exception in in method validate InputArguments in Driver.java");
			System.exit(1);
		}
		finally{
		}

	}
}
