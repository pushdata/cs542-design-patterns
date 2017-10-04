package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
 * <p>Node Class implements the Cloneable,ObserverI,SubjectI interfaces.
 * It contains the data-structures for storing the B-Number,Course Name,
 * ArrayList of references.
 * It overrides the clone method and implements deep-cloning to get 2 backup-nodes.
 * </p>
 * <p>
 * It implements the methods in Observer,Subject Interfaces.
 * </p>
 */

public class Node implements Cloneable, ObserverI, SubjectI {

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


	/**
	 * <p>Node class constructor with 2 input arguments.
	 * </p>
	 *
	 * @param bNo   bNumber.
	 * @param cName ArrayList of Courses.
	 * @return Nothing.
	 */

	public Node(int bNo, ArrayList<String> cName) {
		this.bNumber = bNo;
		this.courseName = cName;
	}

	/**
	 * <p>Node class constructor with 2 input arguments.
	 * </p>
	 *
	 * @param bNo   bNumber.
	 * @param cName Course Name.
	 * @return Nothing.
	 */
	public Node(int bNo, String cName) {
		this.bNumber = bNo;
		courseName.add(cName);
	}

	/**
	 * <p>registerObserver() method which will accept 3 Node objects as input arguments.
	 * This method will store the node-backup references in the Original Node ArrayList.
	 * </p>
	 *
	 * @param node_orig     Original Node.
	 * @param backup_node_1 Backup Node 1.
	 * @param backup_node_2 Backup Node 2.
	 * @return Nothing.
	 */
	@Override
	public void registerObserver(Node node_orig, Node backup_node_1, Node backup_node_2) {
		node_orig.setNodeBackupRef(backup_node_1);
		node_orig.setNodeBackupRef(backup_node_2);
	}

	/**
	 * <p>removeObserver() method which will accept the Original Node object as input argument.
	 * This method will delete the node-backup reference from the Original Node ArrayList.
	 * </p>
	 * @param node_orig Original Node.
	 * @return Nothing.
	 */
	@Override
	public void removeObserver(Node node_orig) {
		node_orig.deleteNodeBackupRef(node_orig);
	}

	/**
	 * <p>notifyAll() method which will accept the Original Node object as input argument and a String.
	 * This method will update the Backup-Nodes with the Course-Name when the delete file is processed.
	 * </p>
	 * @param node_orig Original Node.
	 * @param cName Course Name.
	 * @return Nothing.
	 */
	@Override
	public void notifyAll(Node node_orig, String cName) {
		update(node_orig, cName);
	}

	/**
	 * <p>clone() method will perform deep cloning of the Original Node object and returns the cloned object
	 * to the invoking method.
	 * </p>
	 * @return Node(Cloned object will be returned).
	 */
	public Node clone() {
		Node cloned = null;
		try {
			cloned = (Node) super.clone();
			cloned.nodeBackupRef = (ArrayList<Node>) nodeBackupRef.clone();
			cloned.courseName = (ArrayList<String>) courseName.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("Type Mismatch - Cloning not supported.");
			e.printStackTrace();
			System.exit(0);
		}
		return cloned;
	}

	/**
	 * <p>getNumber() methods returns the bNumber
	 * </p>
	 * @return bNumber.
	 */
	public int getbNumber() {

		return bNumber;
	}

	/**
	 * <p>getCourseName() method returns the ArrayList of Coursenames.
	 * </p>
	 * @return ArrayList of course names.
	 */
	public ArrayList<String> getCourseName() {
		return this.courseName;
	}

	/**
	 * <p>setCourseName(String cName) which takes a String as a input argument and adds the course to the ArrayList.
	 * </p>
	 * @param cName Course Name.
	 * @return Nothing.
	 */
	public void setCourseName(String cName) {
		courseName.add(cName);
	}


	/**
	 * <p>update(Node node,String cName) which takes a Node Object and a String as a input argument
	 * and updates the backup-nodes when this method is invoked.
	 * </p>
	 * @param cName Course Name.
	 * @param node Node Object.
	 * @return Nothing.
	 */
	public void update(Node node, String cName) {
		for (int i = 0; i < 2; i++) {
			node.getNodeBackupRef().get(i).getCourseName().remove(cName);
		}
	}

}
