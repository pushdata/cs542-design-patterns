package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {
	private Node head;
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
		if (flag) {
			head = new Node(bNo, cName);
			head.setNodeBackupRef(head);
			head.setNodeBackupRef(head);
			flag = false;
		} else {
			/* If the tree is empty, return a new node */
			if (root == null) {
				root = new Node(bNo, cName);
				root.setNodeBackupRef(root);//Backup ref 1
				root.setNodeBackupRef(root);//Backup ref 1
			} else {
			/* Otherwise, recur down the tree */
				if (bNo < root.getbNumber()) {
					root.left = insertRec(root.left, bNo, cName);
				} else if (bNo > root.getbNumber()) {
					root.right = insertRec(root.right, bNo, cName);
				} else if (bNo == root.getbNumber()) {
					root.setCourseName(cName);
				}
			}
		}
		return root;
	 }
		
	public void delete(int bNo,String cName){
		deleteRec(head,bNo,cName);
	}
	
	private Node deleteRec(Node root,int bNo,String cName){
		if (root.getbNumber()==bNo && root.getCourseName().equals(cName)) {
        	root.setCourseName(null);
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

	public void printNodes(Results r, Node node) {
		String line = null;
		if (node == null) {
			return;
		} else {
//			if(node.left == null){
//				return;
//			}
//			else{
			printNodes(r, node.left);
			line = node.getbNumber() + ":" + node.getCourseName();
			r.setResult(line);
//				if(node.right == null){
//					return;
//				}
//				else {
			printNodes(r, node.right);
//					line = node.getbNumber() + ":"+node.getCourseName();
//					r.setResult(line);
//				}
		}
	}

}
