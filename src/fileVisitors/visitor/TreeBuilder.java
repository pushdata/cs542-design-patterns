package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;

public class TreeBuilder {

	
	   public Node insertRec(String data, Node node, int length) {
	            if (node == null) {
	                node = new Node();
	                node.setData(data);
	                node.setLength(length);
	                return node;
	            } else {
	                if (data.compareTo(node.getData()) < 0) {
	                    node.left = insertRec(data, node.left,length);
	                } else if (data.compareTo(node.getData()) > 0) {
	                    node.right = insertRec(data, node.right,length);
	                } else if (data.compareTo(node.getData()) == 0) {
	                    //node.setCount(node.getCount() + 1);
	                	
	                }
	            
	            return node;
	        }
	    }

	

}
