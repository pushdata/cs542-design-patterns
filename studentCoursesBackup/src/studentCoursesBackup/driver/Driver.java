package studentCoursesBackup.driver;

import java.io.IOException;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.TreeBuilder;

public class Driver 
{
	public static void main(String[] args) throws IOException {
		FileProcessor fp = null;
		String inputArray[];
		String deleteArray[];
		int inputLineCount;
		try{
			if(args.length ==5){
				throw new IllegalArgumentException();
			}
			fp = new FileProcessor(args[0]);
					//,args[1],args[2],args[3],args[4]);
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		TreeBuilder tb = new TreeBuilder();
		

		inputLineCount = fp.inputLineCount();

		// Creating a Key-value to store the input file
		for(int i=0;i<inputLineCount;i++){
			String temp = fp.readLine();
			inputArray = temp.split(":");
			tb.insert(Integer.parseInt(inputArray[0]),inputArray[1]);
		}	
		
	}
}
			