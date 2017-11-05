package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;

import java.util.ArrayList;

public class CreateWorkers {
    Results results;
    FileProcessor fileProcessor;
    Node root;
    private ArrayList<Thread> threadArray;

    public CreateWorkers(Results r, FileProcessor fp, Node root) {
        results = r;
        fileProcessor = fp;
        this.root = root;
    }

    public void startPopulateWorkers(int numThreads) {
        for (int i = 0; i < numThreads; i++) {
            threadArray.add(new Thread(new PopulateThread(fileProcessor, root)));
            threadArray.get(i).start();
            numThreads--;
        }
        for (int i = 0; i < threadArray.size(); i++) {
            try {
                threadArray.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
