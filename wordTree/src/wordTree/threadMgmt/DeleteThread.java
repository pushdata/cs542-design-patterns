package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

import static wordTree.store.Results.root;
import static wordTree.threadMgmt.CreateWorkers.lockObj;
import static wordTree.util.MyLogger.DebugLevel.CONSTRUCTOR;
import static wordTree.util.MyLogger.DebugLevel.RUN_STATE;

public class DeleteThread implements Runnable {

    private FileProcessor fileProcessor;
    private Thread t;
    private String word;

    DeleteThread(FileProcessor fp, String iword) {
        MyLogger.writeMessage("DeleteThread Constructor Called", CONSTRUCTOR);
        fileProcessor = fp;
        word = iword;
    }

    @Override
    public void run() {
        Driver.logger.writeMessage("Run method called", RUN_STATE);
        delete(word);
    }

    /**
     * <p>delete method is used to delete the incoming word from the word Tree.
     * </p>
     *
     * @param data
     * @return void
     */
    private synchronized void delete(String data) {
        synchronized (lockObj) {
            deleteRec(data, root);
        }
    }

    /**
     * <p>deleteRec method is used to recurse through the Tree to find & delete the target word.
     * </p>
     *
     * @param data,node
     * @return void
     */
    private synchronized void deleteRec(String data, Node node) {
        synchronized (lockObj) {
            if (node == null) {
                return;
            } else {
                if (data.compareTo(node.getData()) < 0) {
                    deleteRec(data, node.left);
                } else if (data.compareTo(node.getData()) > 0) {
                    deleteRec(data, node.right);
                } else if (data.compareTo(node.getData()) == 0 && node.getCount() > 0) {
                    node.setCount(node.getCount() - 1);
                }
            }
            return;
        }
    }
}
