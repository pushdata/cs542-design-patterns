package myArrayList.util;

import java.util.ArrayList;
import java.util.List;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private FileProcessor fileProcessor;
	private List<String> testCaseResults = new ArrayList<String>();
	
	
	public Results(FileProcessor fileProcessor_in){
			this.fileProcessor= fileProcessor_in;
	}

	public FileProcessor getFileProcessor() {
		return fileProcessor;
	}

	public void setFileProcessor(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	@Override
	public void writeOutpuToFile(String outputLine) {
		fileProcessor.writeOutPuttoFile(outputLine+"\n");
	}

	@Override
	public void writeOutPutToStdout() {
		
	}
	
	
	public void storeNewResult(String testCaseName, String result){
		
		this.getTestCaseResults().add(testCaseName+result);
		
	}

	public List<String> getTestCaseResults() {
		return testCaseResults;
	}

	public void setTestCaseResults(List<String> testCaseResults) {
		this.testCaseResults = testCaseResults;
	}
	
	


}
