package wordTree.threadMgmt;

import wordTree.util.FileProcessor;

import static wordTree.threadMgmt.CreateWorkers.lockObj;
import static wordTree.threadMgmt.CreateWorkers.root;

public class PopulateThread implements Runnable {
    private FileProcessor fileProcessor;
    private Thread t;

    PopulateThread(FileProcessor fp) {
        fileProcessor = fp;
    }

    @Override
    public void run() {
        System.out.println("Running Thread");
        String data;
        while ((data = fileProcessor.readWord()) != null) {
            insert(data);
        }
    }

    private synchronized void insert(String data) {
        synchronized (lockObj) {
            root = insertRec(data, root);
            // System.out.println("Head node" + root.getData() + "Left " + root.left + "Right " + root.right);
        }
    }

    private synchronized Node insertRec(String data, Node node) {
        synchronized (lockObj) {
            if (node == null) {
                node = new Node();
                node.setData(data);
                // System.out.println(Thread.currentThread().getName() + " " + data);
                return node;
            } else {
                // System.out.println("Actual data" + data + "Node Data " + node.getData());
                if (data.compareTo(node.getData()) < 0) {
                    node.left = insertRec(data, node.left);
                    // System.out.println("Str1 less than Str 2");
                } else if (data.compareTo(node.getData()) > 0) {
                    node.right = insertRec(data, node.right);
                    //System.out.println("Str1 greater than Str 2");
                } else if (data.compareTo(node.getData()) == 0) {
                    // System.out.println("Str1 equals Str 2");
                    node.setCount(node.getCount() + 1);
                    //System.out.println("Node value "+node.getData() + "Count "+node.getCount());
                }
            }
            return node;
        }
    }
}