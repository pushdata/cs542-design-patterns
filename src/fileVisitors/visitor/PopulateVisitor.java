package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;

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