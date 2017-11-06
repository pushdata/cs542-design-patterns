package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.store.Results;
import wordTree.util.FileProcessor;

import static wordTree.util.MyLogger.DebugLevel.DELETE_THREADS;
import static wordTree.util.MyLogger.DebugLevel.POPULATE_THREADS;

public class CreateWorkers {
    Results results;
    FileProcessor fileProcessor;
    private volatile Node root;
    private Thread[] populateThreads;

    public CreateWorkers(Results iresults, FileProcessor ifileProcessor, int numThreads) {
        results = iresults;
        fileProcessor = ifileProcessor;
        root = iresults.root;
        populateThreads = new Thread[numThreads];
    }

    public void startPopulateWorkers() {
        Driver.logger.writeMessage("Words being populated", POPULATE_THREADS);

        for (int i = 0; i < populateThreads.length; i++) {
            PopulateThread populateThread = new PopulateThread(fileProcessor, root);
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

    public void testM() {
        PopulateThread x = new PopulateThread(fileProcessor, root);
        Thread t = new Thread(x);
        t.start();
    }

    private void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.getLeft());
        System.out.printf("%s ", node.getData());
        printTree(node.getRight());

    }

}
