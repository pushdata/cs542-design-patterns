package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler {

    private String checkpointFile;
    private FileProcessor fileProcessor;
    private DeserializeTypes xmlDeserialize;
    private StrategyI strategyI;

    public StoreRestoreHandler(FileProcessor fp) {
        fileProcessor = fp;
        xmlDeserialize = new DeserializeTypes(fileProcessor); //Fileprocessor wont be reset each time invoke is called. So it can read more complex types
    }

    public void serializeData(SerializableObject sObject, StrategyI sStrategy) {
        sStrategy.processInput(sObject);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        if (method.getName().equals("writeObj")) {
            if (args[1].equals("XML")) {
                serializeData((SerializableObject) args[0], new XMLSerialization(fileProcessor));
            }
        } else if (method.getName().equals("readObj")) {
            result = xmlDeserialize.getObject();
        }

        return result;

    }

    public void setCheckpointFile(String checkpointFile) {
        this.checkpointFile = checkpointFile;
    }

    public void openFile() {
        fileProcessor.initializeScanner();
    }

    public void closeFile() throws IOException {
        fileProcessor.close();
    }
}
