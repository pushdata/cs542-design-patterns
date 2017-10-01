package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

import java.io.IOException;

public class Driver 
{
	public static void main(String[] args) throws IOException {

		FileProcessor fp = null;
		String inputArray[];
		int inputLineCount;
		try{
            if (args.length != 5) {
                throw new IllegalArgumentException();
			}
			fp = new FileProcessor(args[0]);

		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		TreeBuilder tb = new TreeBuilder();

		inputLineCount = fp.inputLineCount();

        // Insert Operation
        for(int i=0;i<inputLineCount;i++){
			String temp = fp.readLine();
			inputArray = temp.split(":");
			tb.insert(Integer.parseInt(inputArray[0]),inputArray[1]);
		}

		//Processing the delete.txt

		fp = new FileProcessor(args[1]);
		inputLineCount = fp.inputLineCount();
		for (int i = 0; i < inputLineCount; i++) {
			String temp = fp.readLine();
			inputArray = temp.split(":");
			tb.delete(Integer.parseInt(inputArray[0]), inputArray[1]);
		}


        Results r = new Results();
        Results rb1 = new Results();
        Results rb2 = new Results();

        //Printing to output files
        tb.printNodes(r, rb1, rb2, tb.getRoot());
        r.writeToFile(args[2]);
        rb1.writeToFile(args[3]);
        rb2.writeToFile(args[4]);
    }
}
			