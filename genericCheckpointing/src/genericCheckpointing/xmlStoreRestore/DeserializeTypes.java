package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeserializeTypes {

    private FileProcessor fileProcessor;
    private String className;

    public DeserializeTypes(FileProcessor fp) {
        fileProcessor = fp;
    }

    public SerializableObject getObject() {
        boolean exitFlag = false; //Used to check for Complex Type
        Class<?> aClass = null;
        SerializableObject obj = null;
        Method meth = null;
        String line = "";

        while (line != null) {
            line = fileProcessor.readLine();

            if (!exitFlag && line.contains("<DPSerialization>")) {
                continue;
            }

            if (!exitFlag && line.contains("</DPSerialization>")) {
                exitFlag = true;
                break;
            }

            if (line.contains("complexType")) {
                int startIndex = line.indexOf("genericCheckpointing");
                int endIndex = line.indexOf("\">");
                className = line.substring(startIndex, endIndex);
                try {
                    aClass = Class.forName(className);
                    obj = (SerializableObject) aClass.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                continue;
            }
            int startIndex = line.indexOf("</");
            int endIndex = line.indexOf(">");
            String type = line.substring(startIndex + 2, endIndex);
            startIndex = line.indexOf(">");
            endIndex = line.indexOf("</");
            String value = line.substring(startIndex + 1, endIndex);

            try {
                switch (type) {
                    case "myInt":
                        meth = aClass.getDeclaredMethod("setMyInt", int.class);
                        meth.invoke(obj, Integer.parseInt(value));
                        break;
                    case "myOtherInt":
                        meth = aClass.getDeclaredMethod("setmyOtherInt", int.class);
                        meth.invoke(obj, Integer.parseInt(value));
                        break;
                    case "myLong":
                        meth = aClass.getDeclaredMethod("setMyLong", long.class);
                        meth.invoke(obj, Long.parseLong(value));
                        break;
                    case "myOtherLong":
                        meth = aClass.getDeclaredMethod("setMyOtherLong", long.class);
                        meth.invoke(obj, Long.parseLong(value));
                        break;
                    case "myString":
                        meth = aClass.getDeclaredMethod("setMyString", String.class);
                        meth.invoke(obj, value);
                        break;
                    case "myBool":
                        meth = aClass.getDeclaredMethod("setMyInt", int.class);
                        meth.invoke(obj, Integer.parseInt(value));
                        break;
                    case "myDoubleT":
                        meth = aClass.getDeclaredMethod("setMyDoubleT", double.class);
                        meth.invoke(obj, Double.parseDouble(value));
                        break;
                    case "myOtherDoubleT":
                        meth = aClass.getDeclaredMethod("setMyOtherDoubleT", double.class);
                        meth.invoke(obj, Double.parseDouble(value));
                        break;
                    case "myCharT":
                        meth = aClass.getDeclaredMethod("setMyCharT", char.class);
                        meth.invoke(obj, (char) Integer.parseInt(value));
                        break;
                    case "myFloatT":
                        meth = aClass.getDeclaredMethod("setMyFloatT", float.class);
                        meth.invoke(obj, Float.parseFloat(value));
                        break;
                    case "myShortT":
                        meth = aClass.getDeclaredMethod("setMyShortT", short.class);
                        meth.invoke(obj, Short.parseShort(value));
                        break;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

}
