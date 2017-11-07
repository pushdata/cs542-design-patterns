package wordTree.threadMgmt;

public class Node {
    public Node left;
    public Node right;
    private String data;
    private int count;

    public Node() {
        left = null;
        right = null;
        data = null;
        count = 1;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
