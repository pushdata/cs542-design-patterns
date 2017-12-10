package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {

    private double myDoubleT;
    private double myOtherDoubleT;
    private char myCharT;
    private float myFloatT;
    private short myShortT;

    public MyAllTypesSecond(int val) {
        myDoubleT = (Math.random() * val) + 1;
        myOtherDoubleT = (Math.random() * val) + 1;
        myCharT = (char) (Math.random() * val);
        myFloatT = (float) (Math.random() * val + 1);
        myShortT = (short) (Math.random() * val);
    }

    public double getMyDoubleT() {
        return myDoubleT;
    }

    public void setMyDoubleT(double myDoubleT) {
        this.myDoubleT = myDoubleT;
    }

    public double getMyOtherDoubleT() {
        return myOtherDoubleT;
    }

    public void setMyOtherDoubleT(double myOtherDoubleT) {
        this.myOtherDoubleT = myOtherDoubleT;
    }

    public char getMyCharT() {
        return myCharT;
    }

    public void setMyCharT(char myCharT) {
        this.myCharT = myCharT;
    }

    public float getMyFloatT() {
        return myFloatT;
    }

    public void setMyFloatT(float myFloatT) {
        this.myFloatT = myFloatT;
    }

    public short getMyShortT() {
        return myShortT;
    }

    public void setMyShortT(short myShortT) {
        this.myShortT = myShortT;
    }
}

