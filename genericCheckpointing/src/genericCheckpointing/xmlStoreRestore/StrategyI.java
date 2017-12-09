package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

public interface StrategyI {
    public void processInput(SerializableObject obj);
}
