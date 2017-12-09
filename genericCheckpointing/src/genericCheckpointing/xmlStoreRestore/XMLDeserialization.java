package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.Method;

public class XMLDeserialization implements StrategyI {

    private FileProcessor fileProcessor;

    public XMLDeserialization(FileProcessor fp) {
        fileProcessor = fp;
    }

    public void processInput(SerializableObject obj) {
    }

}
