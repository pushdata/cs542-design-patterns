package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements ObserverI, SubjectI {
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

	@Override
	public void notifyNodes(Node node) {
		ArrayList<Node> temp = null;
		temp = node.getNodeBackupRef();
		for (int i = 0; i < 2; i++) {
			temp.get(i).courseName = node.getCourseName();
			temp.get(i).setbNumber(node.getbNumber());
		}

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

	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}

	public void setCourseName(String cName) {
		courseName.add(cName);
	}


	public void deleteCourse(String cName){
		courseName.remove(cName);
	}
	
	
			
}
