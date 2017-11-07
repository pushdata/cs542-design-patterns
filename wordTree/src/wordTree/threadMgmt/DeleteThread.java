package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

import static wordTree.store.Results.root;
import static wordTree.threadMgmt.CreateWorkers.lockObj;
import static wordTree.util.MyLogger.DebugLevel.RUN_STATE;

public class DeleteThread implements Runnable {

    private FileProcessor fileProcessor;
    private Thread t;
    private String word;

    DeleteThread(FileProcessor fp, String iword) {
        fileProcessor = fp;
        word = iword;
    }

    @Override
    public void run() {
        Driver.logger.writeMessage("Run method called", RUN_STATE);
        delete(word);
    }

    private synchronized void delete(String data) {
        synchronized (lockObj) {
            System.out.println("Thread id " + Thread.currentThread().getId() + "Deleting Word " + data);
            deleteRec(data, root);
        }
    }

    private synchronized void deleteRec(String data, Node node) {
        synchronized (lockObj) {
            if (node == null) {
                return;
            } else {
                if (data.compareTo(node.getData()) < 0) {
                    deleteRec(data, node.left);
                } else if (data.compareTo(node.getData()) > 0) {
                    deleteRec(data, node.right);
                } else if (data.compareTo(node.getData()) == 0) {
                    node.setCount(node.getCount() - 1);
                }
            }
            return;
        }
    }
}
