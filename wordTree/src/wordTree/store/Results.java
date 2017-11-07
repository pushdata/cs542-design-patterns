package wordTree.store;

import wordTree.threadMgmt.Node;
import wordTree.util.ComputeResults;
import wordTree.util.FileDisplayInterface;
import wordTree.util.FileProcessor;
import wordTree.util.StdoutDisplayInterface;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    public static Node root;

    @Override
    public void writeSchedulesToFile(FileProcessor fileProcessor, ComputeResults computeResults) {
        fileProcessor.writeFile(computeResults.getResult());
    }

    @Override
    public void writeToScreen() {

    }

}
