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
        String data = null;
        while ((data = fileProcessor.readWord()) != null) {
            insert(data, head);
        }
    }


    private synchronized void insert(String data, Node node) {
        if (node == null) {
            node = new Node();
            node.setData(data);
            node.setCount(1);
            if (data.equals("A")) {
                System.out.println("head added");
            }
            System.out.println(Thread.currentThread().getName() + " " + data);
            return;
        } else {
            if (data.compareTo(node.getData()) < 0) {
                insert(data, node.getLeft());
            } else if (data.compareTo(node.getData()) > 0) {
                insert(data, node.getRight());
            } else if (data.compareTo(node.getData()) == 0) {
                node.setCount(node.getCount() + 1);
            }
        }
    }
}