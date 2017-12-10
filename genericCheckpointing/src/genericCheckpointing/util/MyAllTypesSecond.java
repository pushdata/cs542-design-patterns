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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyAllTypesSecond that = (MyAllTypesSecond) o;

        if (Double.compare(that.myDoubleT, myDoubleT) != 0) return false;
        if (Double.compare(that.myOtherDoubleT, myOtherDoubleT) != 0) return false;
        if (myCharT != that.myCharT) return false;
        if (Float.compare(that.myFloatT, myFloatT) != 0) return false;
        return myShortT == that.myShortT;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(myDoubleT);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(myOtherDoubleT);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) myCharT;
        result = 31 * result + (myFloatT != +0.0f ? Float.floatToIntBits(myFloatT) : 0);
        result = 31 * result + (int) myShortT;
        return result;
    }
}

