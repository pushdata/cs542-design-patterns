package genericCheckpointing.xmlStoreRestore;

public class SerializeTypes {

    private Object resultString = "";


    public SerializeTypes() {

    }

    public Object serializeMyClass(Object className) {
        resultString = "<complexType xsi:type=\"" + className + ">";
        return resultString;
    }

    public Object serializeMyInt(Object val) {
        resultString = "<myInt xsi:type=\"xsd:int\">" + val + "</myInt>";
        return resultString;
    }

    public Object serializeMyOtherInt(Object val) {
        resultString = "<myOtherInt xsi:type=\"xsd:int\">" + val + "</myOtherInt>";
        return resultString;
    }

    public Object serializeMyLong(Object val) {
        resultString = "<myLong xsi:type=\"xsd:long\">" + val + "</myLong>";
        return resultString;
    }

    public Object serializeMyOtherLong(Object val) {
        resultString = "<myOtherLong xsi:type=\"xsd:long\">" + val + "</myOtherLong>";
        return resultString;
    }

    public Object serializeMyString(Object val) {
        resultString = "<myString xsi:type=\"xsd:string\">" + val + "</myString>";
        return resultString;
    }

    public Object serializeMyBool(Object val) {
        resultString = "<MyBool xsi:type=\"xsd:boolean\">" + val + "</MyBool>";
        return resultString;
    }

    public Object serializeMyDoubleT(Object val) {
        resultString = "<myDoubleT xsi:type=\"xsd:double\">" + val + "</myDoubleT>";
        return resultString;
    }

    public Object serializeMyOtherDoubleT(Object val) {
        resultString = "<myOtherDoubleT xsi:type=\"xsd:double\">" + val + "</myOtherDoubleT>";
        return resultString;
    }

    public Object serializeMyFloatT(Object val) {
        resultString = "<myFloatT xsi:type=\"xsd:float\">" + val + "</myFloatT>";
        return resultString;
    }

    public Object serializeMyCharT(Object val) {
        resultString = "<myCharT xsi:type=\"xsd:char\">" + val + "</myCharT>";
        return resultString;
    }

    public Object serializeMyShortT(Object val) {
        resultString = "<myShortT xsi:type=\"xsd:short\">" + val + "</myShortT>";
        return resultString;
    }

    public Object serializeType(String type, Object val) {

        switch (type) {
            case "myInt":
                return serializeMyInt(val);
            case "myOtherInt":
                return serializeMyOtherInt(val);
            case "myLong":
                return serializeMyLong(val);
            case "myOtherLong":
                return serializeMyOtherLong(val);
            case "myString":
                return serializeMyString(val);
            case "myBool":
                return serializeMyBool(val);
            case "myDoubleT":
                return serializeMyDoubleT(val);
            case "myOtherDoubleT":
                return serializeMyOtherDoubleT(val);
            case "myCharT":
                return serializeMyCharT(val);
            case "myFloatT":
                return serializeMyFloatT(val);
            case "myShortT":
                return serializeMyShortT(val);
        }

        return null;
    }
}
