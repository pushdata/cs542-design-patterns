package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;

import static fileVisitors.util.MyLogger.DebugLevel.POPULATE_TREE;

public class PopulateVisitor implements VisitorI {

    FileProcessor fileProcessor;

    Tree tree;

    public PopulateVisitor(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    @Override
    public void visit(TreeBuilder treeBuilder) {
        tree = treeBuilder.tree;
        BuildTree();
    }

	public void BuildTree()
	{
        MyLogger.writeMessage("POPULATE VISITOR INVOKED", POPULATE_TREE);
        String data;
        while ((data = fileProcessor.readWord()) != null) {
            int length = data.length();
            if (tree.root == null) {
                tree.root = tree.insertRec(data, tree.root, length);

            } else {
                tree.insertRec(data, tree.root, length);
            }
        }
    }

    public Tree getTree() {
        return tree;
    }

}