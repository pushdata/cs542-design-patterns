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
    private Thread[] deleteThreads;

    static final Object lockObj = new Object();

    // public static Node root;
    public CreateWorkers(Results iresults, FileProcessor ifileProcessor, int numThreads) {
        results = iresults;
        fileProcessor = ifileProcessor;
        populateThreads = new Thread[numThreads];
        deleteThreads = new Thread[numThreads];
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
        // printTree(root);
    }

    public void startDeleteWorkers(String words) {
        String[] wordArray = words.split(" ");
        Driver.logger.writeMessage("Words being deleted", DELETE_THREADS);
        for (int i = 0; i < populateThreads.length; i++) {
            DeleteThread deleteThread = new DeleteThread(fileProcessor, wordArray[i]);
            deleteThreads[i] = new Thread(deleteThread);
            deleteThreads[i].start();
        }
        for (int i = 0; i < deleteThreads.length; i++) {
            try {
                deleteThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //printTree(root);


    }


}
