package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

import static wordTree.store.Results.root;
import static wordTree.threadMgmt.CreateWorkers.lockObj;
import static wordTree.util.MyLogger.DebugLevel.CONSTRUCTOR;
import static wordTree.util.MyLogger.DebugLevel.RUN_STATE;

public class PopulateThread implements Runnable {
    private FileProcessor fileProcessor;
    private Thread t;

    PopulateThread(FileProcessor fp) {
        MyLogger.writeMessage("PopulateThread Constructor Called", CONSTRUCTOR);
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

    /**
     * <p>insert method is used to insert the incoming word to the word Tree.
     * </p>
     *
     * @param data
     * @return void
     */
    private synchronized void insert(String data) {
        synchronized (lockObj) {
            root = insertRec(data, root);
        }
    }

    /**
     * <p>insertRec method is used to recurse through the Tree to insert the target word.
     * </p>
     *
     * @param data,node
     * @return void
     */
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