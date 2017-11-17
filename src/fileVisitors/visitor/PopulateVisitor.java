package fileVisitors.visitor;

import static fileVisitors.util.MyLogger.DebugLevel;
import fileVisitors.visitor.Node;
import fileVisitors.driver.Driver;
import fileVisitors.util.FileProcessor;

public class PopulateVisitor implements VisitorI {

	FileProcessor fp;
	Node root = null;
	TreeBuilder tree_builder;
	public PopulateVisitor(FileProcessor fp)
	{
		this.fp = fp;
	}

	public void BuildTree()
	{
		// Driver.logger.writeMessage("Run method called", RUN_STATE);
	        String data;
	        while ((data = fp.readWord()) != null) {
	        	if(root == null)
	        	{
	        	Node value = tree_builder.insertRec(data,root);
	        	root = value;
	        }
	        	else
	        	{
	        		tree_builder.insertRec(data,root);
	        	}
	}
}

	@Override
	public Node vist(TreeBuilder tree_builder) {
		return root;
	}
	}