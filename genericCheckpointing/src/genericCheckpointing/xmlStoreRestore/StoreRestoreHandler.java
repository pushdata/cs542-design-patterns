package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler {

    private String fileName;
    private FileProcessor fileProcessor;
    private DeserializeTypes xmlDeserialize;
    private StrategyI strategyI;

    public StoreRestoreHandler(FileProcessor fp) {
        fileProcessor = fp;
        xmlDeserialize = new DeserializeTypes(fileProcessor); //Fileprocessor wont be reset each time invoke is called. So it can read more complex types
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        if (method.getName().equals("writeObj")) {
            if (args[1].equals("XML")) {
                strategyI = new XMLSerialization(fileProcessor);
                strategyI.processInput((SerializableObject) args[0]);
            }
        } else if (method.getName().equals("readObj")) {
            result = xmlDeserialize.getObject();
        }

        return result;

    }


}
