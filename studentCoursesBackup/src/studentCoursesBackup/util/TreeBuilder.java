package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {
	private Node head;
	
	public TreeBuilder(){
		head = null;
	}
	
	public void insert(int bNo,String cName){
		insertRec(head,bNo,cName);
	}

	private Node insertRec(Node root,int bNo,String cName){
	        /* If the tree is empty, return a new node */
	        if (root == null) {
	        	root = new Node(bNo,cName);
	        }
	        else{
	        /* Otherwise, recur down the tree */
	        if (bNo < root.getbNumber()){
	        	root.left = insertRec(root.left,bNo,cName);
	        }
	        else {
	        	root.right = insertRec(root.right,bNo,cName);
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
		if (root.getbNumber()==bNo && root.getCourseName().equals(cName)) {
        	return root;
        }
        else{
        if (bNo < root.getbNumber()){
        	root.left = searchRec(root.left,bNo,cName);
        }
        else {
        	root.right = searchRec(root.right,bNo,cName);
        }
        }
        return root;
	}
}
