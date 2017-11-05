package wordTree.threadMgmt;

import wordTree.util.FileProcessor;

public class PopulateThread implements Runnable {

    private FileProcessor fileProcessor;
    private Node root;

    PopulateThread(FileProcessor fp, Node iNode) {
        fileProcessor = fp;
        root = iNode;
    }

    @Override
    public void run() {
        String data = fileProcessor.readWord();
        while (null != data) {
            insert(data, root);
        }
    }

    private void insert(String data, Node node) {
        if (node == null) {
            node.setData(data);
        } else {
            insertRecursive(data, node);
        }
    }

    private void insertRecursive(String data, Node node) {
        if (node == null) {
            node = new Node();
            node.setData(data);
            node.setCount(1);
        } else {
            if (data.compareTo(node.getData()) < 0) {
                insertRecursive(data, node.getLeft());
            } else if (data.compareTo(node.getData()) > 0) {
                insertRecursive(data, node.getRight());
            } else if (data.compareTo(node.getData()) == 0) {
                node.setCount(node.getCount() + 1);
            }
        }
    }
}