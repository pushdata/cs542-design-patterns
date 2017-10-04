package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

/**
 * <p>TreeBuilder Class is responsible for creating the Trees and also the backup-trees.
 * It implements Insert,Search,Delete operations on the Tree. It also checks for valid
 * course-entries(A-K).
 * </p>
 * <p>
 * This class uses Binary-Search-Tree Implementation for populating the tree.
 * </p>
 */

public class TreeBuilder {
	private Node head;
	Node backupNode1 = null;
	Node backupNode2 = null;
	private boolean flag = true;

	/**
	 * <p>TreeBuilder default constructor sets the root(head) node to null.
	 * </p>
	 */
	public TreeBuilder(){
		head = null;
	}


	/**
	 * <p>insert method inserts the Node into the Tree with the provided input parameters after performing a search on the existing BST.
	 * </p>
	 *
	 * @param bNo
	 * @param cName
	 */
	public void insert(int bNo, String cName){
		Node found = search(bNo, cName);
		if (head == null) {
			insertRec(head, bNo, cName);
		} else {
			insertRec(found, bNo, cName);
		}
	}


	/**
	 * <p>getRoot method returns the root(head) node.
	 * </p>
	 * @return Root(head) Node.
	 */
	public Node getRoot() {
		return head;
	}


	/**
	 * <p>insertRec is a recursive method that performs the lookup of the Tree before inserting in to the Tree
	 * </p>
	 * <p>
	 * It checks the validity of the course names and inserts the new Node at the correct position in the tree.
	 * Updates the backup-nodes upon inserting a course to the Node
	 * </p>
	 *
	 * @param root
	 * @param bNo
	 * @param cName
	 * @return Node
	 */

	private Node insertRec(Node root, int bNo, String cName) {
		if (flag) {
			int checkCourse = cName.charAt(0);
			if (checkCourse >= 65 && checkCourse <= 75) {
				head = new Node(bNo, cName);
				backupNode1 = (Node) head.clone();
				backupNode2 = (Node) head.clone();
				head.registerObserver(head, backupNode1, backupNode2);
				flag = false;
			} else {
				head = new Node(bNo, "");
				backupNode1 = (Node) head.clone();
				backupNode2 = (Node) head.clone();
				head.registerObserver(head, backupNode1, backupNode2);
				flag = false;
			}
		} else {
			if (root == null) {
				int checkCourse = cName.charAt(0);
				if (checkCourse >= 65 && checkCourse <= 75) {
					root = new Node(bNo, cName);
					backupNode1 = (Node) root.clone();
					backupNode2 = (Node) root.clone();
					root.registerObserver(root, backupNode1, backupNode2);
				} else {
					root = new Node(bNo, "");
					backupNode1 = (Node) root.clone();
					backupNode2 = (Node) root.clone();
					root.registerObserver(root, backupNode1, backupNode2);
				}
			} else {
				if (bNo == root.getbNumber() && !root.getCourseName().contains(cName)) {
					int checkCourse = cName.charAt(0);
					if (checkCourse >= 65 && checkCourse <= 75) {
						root.setCourseName(cName);
						updateBackupNodesOnInsert(root, cName);
					} else {
						root.setCourseName("");
						updateBackupNodesOnInsert(root, "");
					}
				} else if (bNo > root.getbNumber()) {
					root.right = insertRec(root.right, bNo, cName);
				} else if (bNo < root.getbNumber()) {
					root.left = insertRec(root.left, bNo, cName);
				}
			}
		}
		return root;
	}

	/**
	 * <p>updateBackupNodesOnInsert(Node node,String cName) which update the backup-nodes when inserting into the tree initially.
	 * </p>
	 * @param cName Course Name.
	 * @param node Node
	 * @return Nothing.
	 */
	public void updateBackupNodesOnInsert(Node node, String cName) {
		for (int i = 0; i < 2; i++) {
			node.getNodeBackupRef().get(i).setCourseName(cName);
		}
	}

	/**
	 * <p>delete(int bNo,String cName) which will delete the course by traversing the tree with the provided bNumber
	 * </p>
	 * @param bNo bNumber.
	 * @param cName Course Name.
	 * @return Nothing.
	 */
	public void delete(int bNo, String cName) {
		deleteRec(head, bNo, cName);
	}

	/**
	 * <p>deleteRec(Node root,int bNo,String cName) is a recursive-method which searches the tree recursively using the bNumber
	 * and deletes the course that matches with the supplied course name.
	 * </p>
	 * @param cName Course Name.
	 * @param bNo bNumber.
	 * @param root Root of the tree.
	 * @return Node.
	 */
	private Node deleteRec(Node root, int bNo, String cName){
		if (root != null && root.getbNumber() == bNo)
			for (String temp : root.getCourseName()) {
				if (temp.equals(cName)) {
					root.getCourseName().remove(cName);
					root.update(root, cName);
					break;
				}
			}
		else {
			if (root != null && bNo < root.getbNumber() && root.left != null) {
				root.left = deleteRec(root.left, bNo, cName);
			} else if (root != null && bNo < root.getbNumber() && root.right != null) {
				root.right = deleteRec(root.right, bNo, cName);
			}
		}
		return root;
	}

	/**
	 * <p>search(int bNo,String cName) which will search for the course by traversing the tree with the provided bNumber
	 * </p>
	 * @param bNo bNumber.
	 * @param cName Course Name.
	 * @return Node.
	 */

	public Node search(int bNo, String cName) {
		return searchRec(head, bNo, cName);
	}

	/**
	 * <p>searchRec(Node root,int bNo,String cName) is a recursive-method which searches the tree recursively using the bNumber
	 * and returns the Node with the matching entry.
	 * </p>
	 * @param cName Course Name.
	 * @param bNo bNumber.
	 * @param root Root of the tree.
	 * @return Node.
	 */

	private Node searchRec(Node root, int bNo, String cName){
		if (root != null) {
			if (root.getbNumber() == bNo && !root.getCourseName().equals(cName)) {
				return root;
			} else {
				if (bNo < root.getbNumber()) {
					root.left = searchRec(root.left, bNo, cName);
				} else {
					root.right = searchRec(root.right, bNo, cName);
				}
			}
		} else {
			return root;
		}
		return root;
	}

	/**
	 * <p>printNodes(Results r, Results rb1, Results rb2, Node node) which takes 3 result objects and a Node instance
	 * It will update the three result objects with the final output from the three trees.
	 * </p>
	 * @param r Result instance 1.
	 * @param rb1 Result instance 2.
	 * @param rb2 Result instance 3.
	 * @param node Node instance.
	 * @return Nothing.
	 */
	public void printNodes(Results r, Results rb1, Results rb2, Node node) {
		String line = null;
		if (node == null) {
			return;
		} else {
			printNodes(r, rb1, rb2, node.left);
			for (String temp : node.getCourseName()) {
				line = node.getbNumber() + ":" + temp;
				r.setResult(line);
			}
			for (String temp : node.getNodeBackupRef().get(0).getCourseName()) {
				line = node.getNodeBackupRef().get(0).getbNumber() + ":" + temp;
				rb1.setResult(line);
			}
			for (String temp : node.getNodeBackupRef().get(0).getCourseName()) {
				line = node.getNodeBackupRef().get(0).getbNumber() + ":" + temp;
				rb2.setResult(line);
			}
			printNodes(r, rb1, rb2, node.right);
		}
	}

}
