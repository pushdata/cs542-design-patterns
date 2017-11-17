package fileVisitors.visitor;


public class PalindromeHighlight implements VisitorI {

	@Override
	
	public Node vist(TreeBuilder tree_builder) {
		// TODO Auto-generated method stub
		return null;
	}


	public void check_palindrome()
	{
		PopulateVisitor populate = new PopulateVisitor();
		Node node = populate.Return_root();
		inorder(node);
	}
	
	public void inorder(Node node)
	{
		if(node != null)
		{
			inorder(node.left);
			if(node.getLength() > 3 && (node.getData()).equalsIgnoreCase(new StringBuilder(node.getData()).reverse().toString()))
			{
				node.setData(node.getData().toUpperCase());
			}
			inorder(node.right);
		}
	}

}
