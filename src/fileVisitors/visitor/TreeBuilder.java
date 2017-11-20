package fileVisitors.visitor;

public class TreeBuilder {

	Tree tree;

	public TreeBuilder() {
		tree = new Tree();
	}

	public void accept(VisitorI visitor) {
		visitor.visit(this);
	}

}
