package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.util.FileProcessor;

import static wordTree.store.Results.root;
import static wordTree.threadMgmt.CreateWorkers.lockObj;
import static wordTree.util.MyLogger.DebugLevel.RUN_STATE;

public class PopulateThread implements Runnable {
    private FileProcessor fileProcessor;
    private Thread t;

    PopulateThread(FileProcessor fp) {
        fileProcessor = fp;
    }

    @Override
    public void run() {
        Driver.logger.writeMessage("Run method called", RUN_STATE);
        String data;
        while ((data = fileProcessor.readWord()) != null) {
            insert(data);
        }
    }

    private synchronized void insert(String data) {
        synchronized (lockObj) {
            System.out.println("Thread id " + Thread.currentThread().getId() + "Inserting Word " + data);
            root = insertRec(data, root);
        }
    }

    private synchronized Node insertRec(String data, Node node) {
        synchronized (lockObj) {
            if (node == null) {
                node = new Node();
                node.setData(data);
                return node;
            } else {
                if (data.compareTo(node.getData()) < 0) {
                    node.left = insertRec(data, node.left);
                } else if (data.compareTo(node.getData()) > 0) {
                    node.right = insertRec(data, node.right);
                } else if (data.compareTo(node.getData()) == 0) {
                    node.setCount(node.getCount() + 1);
                }
            }
            return node;
        }
    }
}