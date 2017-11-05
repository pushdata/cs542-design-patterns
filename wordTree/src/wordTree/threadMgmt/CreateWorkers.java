package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;

import java.util.ArrayList;

public class CreateWorkers {
    Results results;
    FileProcessor fileProcessor;
    private volatile Node root;
    private Thread[] populateThreads;

    public CreateWorkers(Results r, FileProcessor fp, int numThreads) {
        results = r;
        fileProcessor = fp;
        root = r.root;
        populateThreads = new Thread[numThreads];
    }

    public void startPopulateWorkers() {
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

    private void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.getLeft());
        System.out.printf("%s ", node.getData());
        printTree(node.getRight());

    }

}
