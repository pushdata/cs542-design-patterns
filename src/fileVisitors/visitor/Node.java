package fileVisitors.visitor;

import fileVisitors.util.MyLogger;

import static fileVisitors.util.MyLogger.DebugLevel.CONSTRUCTOR;

public class Node {
    public Node left;
    public Node right;
    private String data;
    private int length = 0;
  

	MyLogger MyLogger = new MyLogger();

    public Node() {
        MyLogger.writeMessage("Node Constructor Called", CONSTRUCTOR);
        left = null;
        right = null;
        data = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLength() {
  		return length;
  	}

  	public void setLength(int length) {
  		this.length = length;
  	}
 
}