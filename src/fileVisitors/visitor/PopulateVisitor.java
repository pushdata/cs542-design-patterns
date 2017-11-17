package fileVisitors.visitor;

import static fileVisitors.util.MyLogger.DebugLevel;
import fileVisitors.visitor.Node;
import fileVisitors.driver.Driver;
import fileVisitors.util.FileProcessor;

public class PopulateVisitor implements VisitorI {

	FileProcessor fp;
	Node root = null;
	TreeBuilder tree_builder;
	int length ;
	public PopulateVisitor(FileProcessor fp)
	{
		this.fp = fp;
	}

	public PopulateVisitor()
	{
		
	}
	public void BuildTree()
	{
		// Driver.logger.writeMessage("Run method called", RUN_STATE);
	        String data;
	        while ((data = fp.readWord()) != null) {
	        	if(root == null)
	        	{
	        	 length = data.length();
	        	Node value = tree_builder.insertRec(data,root,length);
	        	root = value;
	        }
	        	else
	        	{
	        		tree_builder.insertRec(data,root,length);
	        	}
	}
}
	
	public Node Return_root()
	{
		return root;
	}

	@Override
	public Node vist(TreeBuilder tree_builder) {
		return root;
	}
	}