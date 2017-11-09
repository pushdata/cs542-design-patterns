package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

import static wordTree.util.MyLogger.DebugLevel.CONSTRUCTOR;
import static wordTree.util.MyLogger.DebugLevel.DELETE_THREADS;
import static wordTree.util.MyLogger.DebugLevel.POPULATE_THREADS;

public class CreateWorkers {
    Results results;
    FileProcessor fileProcessor;
    private Thread[] populateThreads;
    private Thread[] deleteThreads;

    static final Object lockObj = new Object();


    /**
     * <p>CreateWorkers constructor method is used to initialize the populate and delete
     * Threads and also the FileProcessor.
     * </p>
     *
     * @param iresults,ifileProcessor,numThreads
     */

    public CreateWorkers(Results iresults, FileProcessor ifileProcessor, int numThreads) {
        MyLogger.writeMessage("CreateWorkers Constructor Called", CONSTRUCTOR);
        results = iresults;
        fileProcessor = ifileProcessor;
        populateThreads = new Thread[numThreads];
        deleteThreads = new Thread[numThreads];
    }

    /**
     * <p>startPopulateWorkers method is used to start the Populate Threads
     * which creates the word Tree using the input text file.
     * </p>
     *
     * @param numThreads
     * @return void
     */

    public void startPopulateWorkers(int numThreads) {
        Driver.logger.writeMessage("Words being populated", POPULATE_THREADS);
        for (int i = 0; i < numThreads; i++) {
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
    }

    /**
     * <p>startDeleteWorkers method is used to start the Delete Threads
     * which iterates through the word Tree to delete words.
     * </p>
     *
     * @param words,numThreads
     * @return void
     */
    public void startDeleteWorkers(String words, int numThreads) {
        String[] wordArray = words.split("\\s+");
        Driver.logger.writeMessage("Words being deleted", DELETE_THREADS);
        for (int i = 0; i < numThreads; i++) {
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

    }


}
