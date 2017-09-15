package src.driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import src.myArrayList.MyArrayList;
import src.test.MyArrayListTest;
import src.util.FileProcessor;
import src.util.Results;

public class Driver 
{

	
	public static void main(String[] args) {
		try {
			Driver driver=new Driver();
			driver.validateGivenArguments(args);;
			Results results;
			FileProcessor processor= new FileProcessor(args[0],args[1]);
			MyArrayList list= new MyArrayList();
			MyArrayListTest arrayListTest= new MyArrayListTest();
			String line=null;
			while((line= processor.readLine())!=null){
				int value=Integer.parseInt(line);
				list.insertSorted(value);
			}
			results=new Results(processor);
		
			//list.removeValue(3);
			
			System.out.println(list.toString());
			arrayListTest.testMe(list, results);
			for(String testResult: results.getTestCaseResults()){
				results.writeOutpuToFile(testResult);
			}
			BufferedWriter writer=processor.getBufferedWriter();
			results.writeOutpuToFile("\nSum of the elements in inputFile is: "+list.sum());

			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


	private void validateGivenArguments(String[] args){
		String inputFile=null;	
		String outPutFile=null;
		try {
			if (null==args || args.length!=2) {
				System.out.println(args.length);
				System.err.println("No of arguments should be equal to 2" );
				System.exit(1);
			}
			if (null !=args[0] && !args[0].equals("${arg0}")) {
				inputFile = args[0];
				validateInputFile(inputFile);
			} if (null !=args[0] && !args[0].equals("${arg1}")) {
				outPutFile = args[1];
				File file= new File(outPutFile);
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
	public static void validateInputFile(String input_FileName){
		try {
			File file= new File(input_FileName);
			if(!file.exists() || !file.canRead()){
				System.err.println("The file "+input_FileName+ " doesnot exist or is not readable"  );
				System.exit(1);
			}
		}catch (Exception exception) {
			System.err.println("Exception in in method validateInputArguments in Driver.java");
			System.exit(1);
		}
		finally{
		}

	}
}
