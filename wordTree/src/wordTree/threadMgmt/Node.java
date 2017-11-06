package wordTree.threadMgmt;

public class Node {
    private Node left;
    private Node right;
    private String data;
    private int count;

    public Node() {
        left = null;
        right = null;
        data = null;
        count = 1;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
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
