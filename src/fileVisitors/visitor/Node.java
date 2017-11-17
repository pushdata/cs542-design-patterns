package fileVisitors.visitor;

import fileVisitors.util.MyLogger;

import static fileVisitors.util.MyLogger.DebugLevel;

public class Node {
    public Node left;
    public Node right;
    private String data;
    MyLogger MyLogger = new MyLogger();

    public Node() {
      //  MyLogger.writeMessage("Node Constructor Called", CONSTRUCTOR);
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

  
}