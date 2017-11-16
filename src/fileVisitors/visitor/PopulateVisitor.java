package fileVisitors.visitor;

import static fileVisitors.util.MyLogger.DebugLevel;
import fileVisitors.visitor.Node;
import fileVisitors.driver.Driver;
import fileVisitors.util.FileProcessor;

public class PopulateVisitor {

	FileProcessor fp;
	Node root;
	public PopulateVisitor(FileProcessor fp)
	{
		this.fp = fp;
	}

	public void BuildTree()
	{
		// Driver.logger.writeMessage("Run method called", RUN_STATE);
	        String data;
	        while ((data = fp.readWord()) != null) {
	            insert(data);
	        }
	}
	
	private synchronized void insert(String data) {
            root = insertRec(data, root);
    }
	
	   private synchronized Node insertRec(String data, Node node) {
	            if (node == null) {
	                node = new Node();
	                node.setData(data);
	                return node;
	            } else {
	                if (data.compareTo(node.getData()) < 0) {
	                    node.left = insertRec(data, node.left);
	                } else if (data.compareTo(node.getData()) > 0) {
	                    node.right = insertRec(data, node.right);
	                } else if (data.compareTo(node.getData()) == 0) {
	                    //node.setCount(node.getCount() + 1);
	                	
	                }
	            
	            return node;
	        }
	    }
}
