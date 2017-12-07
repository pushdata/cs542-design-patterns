package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler {

    private String fileName;

    public StoreRestoreHandler() {
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        if (method.getName().equals("writeObj")) {

        } else if (method.getName().equals("readObj")) {

        }


        return null;
    }

    public void setFileName(String name) {
        fileName = name;
    }


}
