package fileVisitors.visitor;

public class PrimeLength implements VisitorI{

	@Override
	public Node visit(TreeBuilder tree_builder) {
		// TODO Auto-generated method stub
		return null;
	}

	public void check_forprime()
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
			checkprimelength(node);
			inorder(node.right);
			
		}
	}
	
	public void checkprimelength(Node node){
		int length = node.getLength();
		boolean result = true;
		for(int i=2;i<length;i++) {
	        if(length%i==0)
	            result = false;
	    }
		if(result == true)
		{
			String data = node.getData();
			node.setData(data + "-PRIME");
		}
		
	}

}
