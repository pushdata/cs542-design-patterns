package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.Field;

public class XMLSerialization implements StrategyI {

    private FileProcessor fileProcessor;
    private SerializeTypes serializeTypes;
    private StringBuilder stringBuilder;

    public XMLSerialization(FileProcessor fp) {
        fileProcessor = fp;
        stringBuilder = new StringBuilder();
        serializeTypes = new SerializeTypes();
    }

    @Override
    public void processInput(SerializableObject obj) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        stringBuilder.append("<DPSerialization>\n");
        stringBuilder.append(serializeTypes.serializeMyClass(cls.getCanonicalName())); //Full Class Name
        for (Field f : fields) {
            f.setAccessible(true);
            String type = f.getName();
            try {
                Object value = f.get(obj);
                stringBuilder.append(serializeTypes.serializeType(type, value) + "\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.append("</complexType>" + "\n");
        stringBuilder.append("</DPSerialization>" + "\n");
        fileProcessor.writeFile(stringBuilder);
    }

}
