package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;

public class TreeBuilder {

	
	   public Node insertRec(String data, Node node) {
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
