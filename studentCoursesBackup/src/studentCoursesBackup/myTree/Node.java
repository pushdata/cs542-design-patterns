package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import studentCoursesBackup.util.FileProcessor;

public class Node {
	//Data Members
	private int bNumber;
	private ArrayList<String> courseName=new ArrayList<>();
	public Node left,right=null;
	
	
	public Node(int bNo,String cName){
		this.bNumber=bNo;
		courseName.add(cName);
	}
	
	public int getbNumber() {
		return bNumber;
	}
	
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	
	public ArrayList<String> getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String cName) {
		courseName.add(cName);
	}
	
	public void deleteCourse(String cName){
		courseName.remove(cName);
	}
	
	
			
}
