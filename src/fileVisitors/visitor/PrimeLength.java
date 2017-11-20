package fileVisitors.visitor;

public class PrimeLength implements VisitorI{

	Tree tree;
	TreeBuilder treeBuilder;

	public PrimeLength(Tree tree) {
		this.tree = tree;
	}

	public void visit(TreeBuilder treeBuilder) {
		this.treeBuilder = treeBuilder;
		traverseTree(tree.root);
		this.treeBuilder.tree = tree;
	}


	public void traverseTree(Node node) {
		if (node == null) {
			return;
		}
		traverseTree(node.left);
		updatePrimeLength(node);
		traverseTree(node.right);
	}

	public void updatePrimeLength(Node node) {
		int length = node.getLength();
		boolean isPrime = true;

		for (int i = 2; i < length; i++) {
			if (length % i == 0)
				isPrime = false;
		}

		if (isPrime && length > 1) {
			node.setData(node.getData() + "-PRIME");
		}
	}

	public Tree getTree() {
		return tree;
	}



}
