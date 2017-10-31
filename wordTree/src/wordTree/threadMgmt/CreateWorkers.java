package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;

public class CreateWorkers {
    Results results;
    FileProcessor fileProcessor;

    public CreateWorkers(Results r, FileProcessor fp) {
        results = r;
        fileProcessor = fp;
    }

}
