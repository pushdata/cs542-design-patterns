package genericCheckpointing.util;

import java.util.Random;

public class MyAllTypesFirst extends SerializableObject {

    private int myInt;
    private int myOtherInt;
    private long myLong;
    private long myOtherLong;
    private String myString;
    private boolean myBool;

    public MyAllTypesFirst() {
        myInt = 1105;
        myOtherInt = 1105;
        myLong = 11051105;
        myOtherLong = 11051105;
        myString = "SAI";
        myBool = false;
    }

    public MyAllTypesFirst(int val) {
        Random rand = new Random();
        String randomString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        myInt = rand.nextInt(100);
        myOtherInt = rand.nextInt(100);
        myLong = rand.nextLong();
        myOtherLong = rand.nextLong();
        myString = "" + randomString.substring(0, rand.nextInt(randomString.length()));
        myBool = rand.nextBoolean();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyAllTypesFirst that = (MyAllTypesFirst) o;

        if (myInt != that.myInt) return false;
        if (myOtherInt != that.myOtherInt) return false;
        if (myLong != that.myLong) return false;
        if (myOtherLong != that.myOtherLong) return false;
        if (myBool != that.myBool) return false;
        return myString != null ? myString.equals(that.myString) : that.myString == null;
    }

    @Override
    public int hashCode() {
        int result = myInt;
        result = 31 * result + myOtherInt;
        result = 31 * result + (int) (myLong ^ (myLong >>> 32));
        result = 31 * result + (int) (myOtherLong ^ (myOtherLong >>> 32));
        result = 31 * result + (myString != null ? myString.hashCode() : 0);
        result = 31 * result + (myBool ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyAllTypesFirst{" +
                "myInt=" + myInt +
                ", myOtherInt=" + myOtherInt +
                ", myLong=" + myLong +
                ", myOtherLong=" + myOtherLong +
                ", myString='" + myString + '\'' +
                ", myBool=" + myBool +
                '}';
    }
}
