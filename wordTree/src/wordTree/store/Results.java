package wordTree.store;

import wordTree.threadMgmt.Node;
import wordTree.util.ComputeResults;
import wordTree.util.FileDisplayInterface;
import wordTree.util.FileProcessor;
import wordTree.util.StdoutDisplayInterface;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    public static Node root;

    /**
     * <p>writeSchedulesToFile method is used to store the output to
     * the text file.
     * </p>
     *
     * @param fileProcessor, computeResults
     * @return void
     */
    @Override
    public void writeSchedulesToFile(FileProcessor fileProcessor, ComputeResults computeResults) {
        fileProcessor.writeFile(computeResults.getResult());
    }

    /**
     * <p>writeToScreen method is used to print the output to
     * the Screen.
     * </p>
     *
     * @param computeResults
     * @return void
     */
    @Override
    public void writeToScreen(ComputeResults computeResults) {
        System.out.println(computeResults.getResult());
    }

}
