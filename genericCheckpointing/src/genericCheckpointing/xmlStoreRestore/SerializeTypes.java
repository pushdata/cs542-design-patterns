package genericCheckpointing.xmlStoreRestore;

public class SerializeTypes {

    private Object resultString = "";

    public Object serializeBoolean(boolean val) {
        resultString = "<myBool xsi:type=\"xsd:boolean\">" + val + "</myBool>";
        return resultString;
    }

    public Object serializeInt(int val) {
        resultString = "<myInt xsi:type=\"xsd:int\">" + val + "</myInt>";
        return resultString;
    }

    public Object serializeMyOtherInt(int val) {
        resultString = "<myOtherInt xsi:type=\"xsd:int\">" + val + "</myOtherInt>";
        return resultString;
    }

    public Object serializeLong(long val) {
        resultString = "<myLong xsi:type=\"xsd:long\">" + val + "</myLong>";
        return resultString;
    }

    public Object serializeShort(short val) {
        resultString = "<myLong xsi:type=\"xsd:long\">" + val + "</myLong>";
        return resultString;
    }

    public Object serializeString(String val) {
        resultString = "<myString xsi:type=\"xsd:string\">" + val + "</myString>";
        return resultString;
    }

    public Object serializeChar(char val) {
        return "";
    }

    public Object serializeDouble(double val) {
        return "";
    }

    public Object serializeFloat(float val) {
        return "";
    }


}
