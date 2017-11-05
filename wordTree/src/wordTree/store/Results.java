package wordTree.store;

import wordTree.threadMgmt.Node;
import wordTree.util.FileDisplayInterface;

public class Results implements FileDisplayInterface {
    public volatile Node root;
    @Override
    public void writeSchedulesToFile() {

    }
}
