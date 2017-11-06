package wordTree.threadMgmt;

import wordTree.driver.Driver;
import wordTree.util.MyLogger;

import static wordTree.util.MyLogger.DebugLevel.RUN_STATE;

public class DeleteThread implements Runnable {

    @Override
    public void run() {
        Driver.logger.writeMessage("Run method called", RUN_STATE);
    }
}
