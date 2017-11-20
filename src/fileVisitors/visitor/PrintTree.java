package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;

public class PrintTree implements VisitorI{

	FileProcessor fp;
	@Override
	public Node visit(TreeBuilder tree_builder) {
		// TODO Auto-generated method stub
		return null;
	}

	public void print_output()
	{
		PopulateVisitor populate = new PopulateVisitor();
		Node node = populate.Return_root();
		System.out.println(node);
		inorder(node);
	}

	public void inorder(Node node)
	{
		inorder(node.left);
		fp.writeFile(new StringBuilder(node.getData()));
		inorder(node.right);
	}
}
