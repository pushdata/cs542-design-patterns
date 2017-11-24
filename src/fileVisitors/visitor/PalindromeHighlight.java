package fileVisitors.visitor;


import fileVisitors.util.MyLogger;

import static fileVisitors.util.MyLogger.DebugLevel.CONSTRUCTOR;

public class PalindromeHighlight implements VisitorI {

	Tree tree;
	TreeBuilder treeBuilder;

	public PalindromeHighlight(Tree tree) {
        MyLogger.writeMessage("Palindrome Constructor Called", CONSTRUCTOR);
        this.tree = tree;
    }

	public void updatePalindromeNodes(Node node) {

		if (node == null) {
			return;
		}

		updatePalindromeNodes(node.left);

		if (node.getLength() > 3 && (node.getData()).equalsIgnoreCase(new StringBuilder(node.getData()).reverse().toString())) {
			node.setData(node.getData().toUpperCase());
		}

		updatePalindromeNodes(node.right);
	}

	public void visit(TreeBuilder treeBuilder) {
		this.treeBuilder = treeBuilder;
		updatePalindromeNodes(tree.root);
		this.treeBuilder.tree = tree;
	}

	public Tree getTree() {
		return tree;
	}
}
