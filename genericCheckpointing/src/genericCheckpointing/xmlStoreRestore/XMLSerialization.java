package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class XMLSerialization implements StrategyI {

    private FileProcessor fileProcessor;

    public XMLSerialization(FileProcessor fp) {
        fileProcessor = fp;
    }

    public void processInput(SerializableObject obj) {
    }

}
