package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements Cloneable, ObserverI, SubjectI {
	//Data Members
	private int bNumber;
	private ArrayList<String> courseName=new ArrayList<>();
	private ArrayList<Node> nodeBackupRef = new ArrayList<>();
	public Node left,right=null;

	public ArrayList<Node> getNodeBackupRef() {
		return nodeBackupRef;
	}

	public void setNodeBackupRef(Node node) {
		nodeBackupRef.add(node);
	}

	public void deleteNodeBackupRef(Node node) {
		node.nodeBackupRef.remove(0);
		node.nodeBackupRef.remove(1);
	}


	//Newly added
	public Node(int bNo, ArrayList<String> cName) {
		this.bNumber = bNo;
		this.courseName = cName;
	}

	@Override
	public void registerObserver(Node node_orig, Node backup_node_1, Node backup_node_2) {
		node_orig.setNodeBackupRef(backup_node_1);
		node_orig.setNodeBackupRef(backup_node_2);
	}

	@Override
	public void removeObserver(Node node_orig) {
		node_orig.deleteNodeBackupRef(node_orig);
	}

	@Override
	public void notifyAll(Node node_orig, String cName) {
		update(node_orig, cName);
	}

	public Node clone() {
		Node cloned = null;
		try {
			cloned = (Node) super.clone();
			cloned.nodeBackupRef = (ArrayList<Node>) nodeBackupRef.clone();
			cloned.courseName = (ArrayList<String>) courseName.clone();
//			if(this instanceof Cloneable) {
//				cloned = new Node(this.getbNumber(), this.getCourseName());
//			}
//			else{
//				throw new CloneNotSupportedException();
//			}
		} catch (CloneNotSupportedException e) {
			System.err.println("Cloning not supported");
		}
		return cloned;
	}

	public Node(int bNo,String cName){
		this.bNumber=bNo;
		courseName.add(cName);
	}

	public int getbNumber() {
		return bNumber;
	}

	public ArrayList<String> getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String cName) {
		courseName.add(cName);
	}

	public void update(Node node, String cName) {
		for (int i = 0; i < 2; i++) {
			node.getNodeBackupRef().get(i).getCourseName().remove(cName);
		}
	}

}
