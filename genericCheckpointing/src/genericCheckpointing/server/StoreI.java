package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI {
    void writeObj(MyAllTypesFirst myFirst, String xml);

    void writeObj(MyAllTypesSecond mySecond, String xml);
}
