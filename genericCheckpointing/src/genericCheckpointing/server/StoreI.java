package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI {
    void writeObj(MyAllTypesFirst aRecord, String wireFormat);

    void writeObj(MyAllTypesSecond bRecord, String wireFormat);
}
