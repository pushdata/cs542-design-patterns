package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;

public class PrintTree implements VisitorI{

	FileProcessor fp;
	@Override
	public Node vist(TreeBuilder tree_builder) {
		// TODO Auto-generated method stub
		return null;
	}

	public void print_output()
	{
		PopulateVisitor populate = new PopulateVisitor();
		Node node = populate.Return_root();
		inorder(node);
	}

	public void inorder(Node node)
	{
		inorder(node.left);
		fp.writeFile(new StringBuilder(node.getData()));
		inorder(node.right);
	}
}
