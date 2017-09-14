package src.util;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	private FileProcessor fileProcessor;
	
	
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
	public void writeOutpuToFile() {
		
	}

	@Override
	public void writeOutPutToStdout() {
		
	}



}
