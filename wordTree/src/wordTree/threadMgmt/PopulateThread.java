package wordTree.threadMgmt;

import wordTree.util.FileProcessor;

public class PopulateThread implements Runnable {

    private static boolean flag = false;
    private FileProcessor fileProcessor;
    private Thread t;
    private volatile Node head;

    PopulateThread(FileProcessor fp, Node root) {
        this.head = root;
        fileProcessor = fp;
    }

    @Override
    public void run() {
        System.out.println("Running Thread");
        String data;
        while ((data = fileProcessor.readWord()) != null) {
            insert(data, head);
        }
    }

    private synchronized void insert(String data, Node node) {
        if (head == null) {
            head = new Node();
            head.setData(data);
        } else {
            insertRec(data, head);
        }
    }

    private synchronized Node insertRec(String data, Node node) {
        if (node == null) {
            node = new Node();
            node.setData(data);
            System.out.println(Thread.currentThread().getName() + " " + data);
        } else {
            System.out.println("Actual data" + data + "Node Data " + node.getData());
            if (data.compareTo(node.getData()) < 0) {
                node.setLeft(insertRec(data, node.getLeft()));
                System.out.println("Str1 less than Str 2");
            } else if (data.compareTo(node.getData()) > 0) {
                node.setRight(insertRec(data, node.getRight()));
                System.out.println("Str1 greater than Str 2");
            } else if (data.compareTo(node.getData()) == 0) {
                System.out.println("Str1 equals Str 2");
                node.setCount(node.getCount() + 1);
            }
        }
        return node;
    }
}