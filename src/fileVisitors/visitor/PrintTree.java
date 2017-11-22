package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;

import static fileVisitors.util.MyLogger.DebugLevel.PRINT_TREE;

public class PrintTree implements VisitorI{

    Tree tree;
    TreeBuilder treeBuilder;
    StringBuilder sb;
    FileProcessor fileProcessor;

    public PrintTree(Tree tree, FileProcessor fp) {
        this.sb = new StringBuilder();
        this.tree = tree;
        this.fileProcessor = fp;
    }

	@Override
    public void visit(TreeBuilder treeBuilder) {
        MyLogger.writeMessage("Print Tree Visitor Invoked", PRINT_TREE);
        this.treeBuilder = treeBuilder;
        inorder(this.tree.root); // Manipulating with the Root Node
        this.treeBuilder.tree = tree; //Updating the Root Node in the Tree Builder
        fileProcessor.writeFile(sb);
    }

	public void inorder(Node node)
	{
        if (node == null) {
            return;
        }
        inorder(node.left);
        sb.append(node.getData() + " ");
        inorder(node.right);
    }
}
