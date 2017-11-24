package fileVisitors.visitor;

import fileVisitors.util.MyLogger;

import static fileVisitors.util.MyLogger.DebugLevel.CONSTRUCTOR;
import static fileVisitors.util.MyLogger.DebugLevel.VISITOR_INVOKED;

public class PrimeLength implements VisitorI{

	Tree tree;
	TreeBuilder treeBuilder;

	public PrimeLength(Tree tree) {
		MyLogger.writeMessage("PrimeLength Constructor Called", CONSTRUCTOR);
		this.tree = tree;
	}

	public void visit(TreeBuilder treeBuilder) {
		MyLogger.writeMessage("PrimeLength Visitor Invoked", VISITOR_INVOKED);
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
