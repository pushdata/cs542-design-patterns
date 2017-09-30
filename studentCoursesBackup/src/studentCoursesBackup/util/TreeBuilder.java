package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {
	private Node head;
	Node backupNode1 = null;
	Node backupNode2 = null;
	private boolean flag = true;
	
	public TreeBuilder(){

		head = null;
	}
	
	public void insert(int bNo,String cName){
		Node found = search(bNo, cName);
		if (head == null) {
			insertRec(head, bNo, cName);
		} else {
			insertRec(found, bNo, cName);
		}
	}

	public Node getRoot() {
		return head;
	}

	private Node insertRec(Node root,int bNo,String cName){
		//Executed only once for the root node
		if (flag) {
			head = new Node(bNo, cName);
			backupNode1 = (Node) head.clone();
			backupNode2 = (Node) head.clone();
			head.registerObserver(head, backupNode1, backupNode2);
			flag = false;
		}
		//Executed after the root node is created
		else {
			if (root == null) {
				root = new Node(bNo, cName);
				backupNode1 = (Node) root.clone();
				backupNode2 = (Node) root.clone();
				root.registerObserver(root, backupNode1, backupNode2);
			}
			//Insert node at proper position
			else {
				if (bNo == root.getbNumber()) {
					root.setCourseName(cName);
					updateBackupNodesOnInsert(root, cName);
				} else if (bNo > root.getbNumber()) {
					root.right = insertRec(root.right, bNo, cName);
				} else if (bNo < root.getbNumber()) {
					root.left = insertRec(root.left, bNo, cName);
				}
			}
		}
		return root;
	 }

	public void updateBackupNodesOnInsert(Node node, String cName) {
		for (int i = 0; i < 2; i++) {
			node.getNodeBackupRef().get(i).setCourseName(cName);
		}
	}
	public void delete(int bNo,String cName){
		deleteRec(head,bNo,cName);
	}
	
	private Node deleteRec(Node root,int bNo,String cName){
		if (root.getbNumber()==bNo && root.getCourseName().equals(cName)) {
			root.getCourseName().remove(cName);
			root.update(root, cName);
		}
        else{
        if (bNo < root.getbNumber()){
        	root.left = deleteRec(root.left,bNo,cName);
        }
        else {
        	root.right = deleteRec(root.right,bNo,cName);
        }
        }
        return root;
	}
	
	public Node search(int bNo,String cName){
		return searchRec(head,bNo,cName);
	}
	
	private Node searchRec(Node root,int bNo,String cName){
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
