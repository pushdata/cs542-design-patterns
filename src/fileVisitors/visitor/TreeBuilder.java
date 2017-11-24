package fileVisitors.visitor;

import fileVisitors.util.MyLogger;

import static fileVisitors.util.MyLogger.DebugLevel.ACCEPT_VISITOR;
import static fileVisitors.util.MyLogger.DebugLevel.CONSTRUCTOR;

public class TreeBuilder {

	Tree tree;

	public TreeBuilder() {
        MyLogger.writeMessage("TreeBuilder Constructor Called", CONSTRUCTOR);
        tree = new Tree();
    }

	public void accept(VisitorI visitor) {
        MyLogger.writeMessage("Accept Method Invoked", ACCEPT_VISITOR);
        visitor.visit(this);
    }

}
