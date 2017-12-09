package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;

public class XMLSerialization implements StrategyI {

    private FileProcessor fileProcessor;

    public XMLSerialization(FileProcessor fp) {
        fileProcessor = fp;
    }



}
