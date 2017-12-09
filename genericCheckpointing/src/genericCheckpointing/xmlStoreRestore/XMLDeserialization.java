package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;

public class XMLDeserialization implements StrategyI {

    private FileProcessor fileProcessor;

    public XMLDeserialization(FileProcessor fp) {
        fileProcessor = fp;
    }


}
