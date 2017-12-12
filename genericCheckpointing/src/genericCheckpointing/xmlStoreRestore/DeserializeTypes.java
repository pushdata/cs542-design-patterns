package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeserializeTypes implements DeserStrategy {

    private FileProcessor fileProcessor;
    private String className;

    public DeserializeTypes(FileProcessor fp) {
        fileProcessor = fp;
    }

    @Override
    public Object getObject() {
        Class<?> aClass = null;
        Object obj = null;
        Method meth = null;
        String line = "";

        while (line != null) {
            line = fileProcessor.readLine();

            if (line.contains("<DPSerialization>")) {
                continue;
            }

            if (line.contains("</complexType>")) {
                fileProcessor.readLine();
                break;
            }

            if (line.contains("complexType")) {
                int startIndex = line.indexOf("genericCheckpointing");
                int endIndex = line.lastIndexOf("\">");
                className = line.substring(startIndex, endIndex);
                try {
                    aClass = Class.forName(className);
                    obj = aClass.newInstance();
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
            int endIndex = line.lastIndexOf(">");
            String type = line.substring(startIndex + 2, endIndex);
            startIndex = line.indexOf(">");
            endIndex = line.indexOf("</");
            String value = line.substring(startIndex + 1, endIndex);
            if (value.equals("")) {
                continue;
            }

            try {
                switch (type) {
                    case "myInt":
                        meth = aClass.getDeclaredMethod("setMyInt", int.class);
                        meth.invoke(obj, Integer.parseInt(value));
                        break;
                    case "myOtherInt":
                        meth = aClass.getDeclaredMethod("setMyOtherInt", int.class);
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
                        meth = aClass.getDeclaredMethod("setMyBool", boolean.class);
                        meth.invoke(obj, Boolean.parseBoolean(value));
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
                        meth.invoke(obj, value.charAt(0));
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
