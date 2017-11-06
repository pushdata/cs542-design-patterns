package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.store.Results;
import wordTree.util.FileProcessor;

import static wordTree.util.MyLogger.DebugLevel.DELETE_THREADS;
import static wordTree.util.MyLogger.DebugLevel.POPULATE_THREADS;

public class CreateWorkers {
    Results results;
    FileProcessor fileProcessor;
    private Thread[] populateThreads;
    static final Object lockObj = new Object();
    public static Node root;
    public CreateWorkers(Results iresults, FileProcessor ifileProcessor, int numThreads) {
        results = iresults;
        fileProcessor = ifileProcessor;
        populateThreads = new Thread[numThreads];
    }

    public void startPopulateWorkers() {
        Driver.logger.writeMessage("Words being populated", POPULATE_THREADS);
        for (int i = 0; i < populateThreads.length; i++) {
            PopulateThread populateThread = new PopulateThread(fileProcessor);
            populateThreads[i] = new Thread(populateThread);
            populateThreads[i].start();
        }
        for (int i = 0; i < populateThreads.length; i++) {
            try {
                populateThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printTree(root);
    }

    public void startDeleteWorkers() {
        Driver.logger.writeMessage("Words being deleted", DELETE_THREADS);
    }

    public void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println("Word " + node.getData() + " : " + node.getCount());
        printTree(node.right);

    }

}
