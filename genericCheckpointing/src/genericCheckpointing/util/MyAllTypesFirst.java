package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {

    private int myInt;
    private int myOtherInt;
    private long myLong;
    private long myOtherLong;
    private String myString;
    private boolean myBool;


    public MyAllTypesFirst(int val) {
        myInt = (int) Math.random() * val + 1;
        myLong = (long) Math.random() * val + 1;
        myOtherLong = (long) Math.random() * val + 1;
        myString = "" + (int) Math.random() * val + 1;
        myOtherInt = (int) Math.random() * val + 1;
        myBool = (Math.random() * val) % 2 == 0 ? true : false;
    }

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public int getMyOtherInt() {
        return myOtherInt;
    }

    public void setMyOtherInt(int myOtherInt) {
        this.myOtherInt = myOtherInt;
    }

    public long getMyLong() {
        return myLong;
    }

    public void setMyLong(long myLong) {
        this.myLong = myLong;
    }

    public long getMyOtherLong() {
        return myOtherLong;
    }

    public void setMyOtherLong(long myOtherLong) {
        this.myOtherLong = myOtherLong;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public boolean isMyBool() {
        return myBool;
    }

    public void setMyBool(boolean myBool) {
        this.myBool = myBool;
    }


}
