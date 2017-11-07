package wordTree.util;

import wordTree.store.Results;
import wordTree.threadMgmt.Node;

public class ComputeResults {

    private int totalWords;
    private int totalDistinctWords;
    private int totalChars;


    public ComputeResults(Results r) {
        computeResult(Results.root);
    }

    public void computeResult(Node node) {
        if (node == null) {
            return;
        }
        computeResult(node.left);
        totalWords = totalWords + node.getCount();
        if (node.getCount() > 0) {
            totalDistinctWords += 1;
        }
        totalChars += (node.getData().length() * node.getCount());
        System.out.println("Word " + node.getData() + " Length " + node.getData().length() * node.getCount());
        computeResult(node.right);
    }

    public StringBuilder getResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("The total number of words: " + totalWords).
                append("\nThe number of characters: " + totalChars).
                append("\nThe total number of distinct words: " + totalDistinctWords);
        return sb;
    }

}
