package src.test;

import src.myArrayList.*;
import src.util.*;
import sun.net.www.content.image.png;

public class MyArrayListTest {
	public void testMe(MyArrayList myArrayList, Results results){
		//TEST CASE 1
		testcase1(myArrayList, results);
		testcase2(myArrayList, results);
		testcase3(myArrayList, results);
		testcase4(myArrayList, results);
		testcase5(myArrayList, results);
	}

	public void testcase1(MyArrayList myArrayList, Results results){
		try {
			// test case to test insert elements into list
			int initialsum = myArrayList.sum();
			int newValue = 12;
			String result = "Failed";
			myArrayList.insertSorted(newValue);
			newValue=1;
			myArrayList.insertSorted(newValue);
			newValue=0;
			myArrayList.insertSorted(newValue);
			newValue=1234;
			myArrayList.insertSorted(newValue);
			newValue=9999;
			myArrayList.insertSorted(newValue);
			newValue=123;
			myArrayList.insertSorted(newValue);
			int currSum = myArrayList.sum();
			if (currSum == 11369) {
				result = "Passed";
			} 
			results.storeNewResult("TestCase 1 - Inserting Values \n"+"Before Insertion - Sum = "+Integer.toString(initialsum)+ " \n"+"After Insertion - Sum = "+Integer.toString(currSum)+"\n",result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase2(MyArrayList myArrayList, Results results){
		
		try {
			// test case to verify sorted array
			String result = "Failed";
			int x[]=myArrayList.getData();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<myArrayList.size();i++){
				sb.append(Integer.toString(x[i])).append(" ");
			}
			result = "Passed";
			results.storeNewResult("\n\nTestCase 2 - Displaying Sorted Array \n"+sb+"\n",result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase3(MyArrayList myArrayList, Results results){
		
		try {
			// test case to remove a single element from the list 
			int initialSum = myArrayList.sum();
			String result = "Failed";
			myArrayList.removeValue(1);
			int currSum = myArrayList.sum();
			if (currSum == 11368) {
				result = "Passed";
			} 
			results.storeNewResult("\n\nTestCase 3 - Removing Value 1 \n"+"Before Remove - Sum = "+Integer.toString(initialSum)+ "\n"+"After Remove - Sum = "+Integer.toString(currSum)+"\n",result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase4(MyArrayList myArrayList, Results results){
		
		try {
			// test case - inserting duplicate element 
			StringBuilder sb=null;
			int newValue = 123;
			String result = "Failed";
			myArrayList.insertSorted(newValue);
			int currSum = myArrayList.sum();
			if (currSum == 11491) {
				result = "Passed";
				}
			int x[]=myArrayList.getData();
			sb = new StringBuilder();
			for(int i=0;i<myArrayList.size();i++){
				sb.append(Integer.toString(x[i])).append(" ");
			} 
			results.storeNewResult("\n\nTestCase 4 - Displaying Sorted Array \n"+sb+"\n",result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase5(MyArrayList myArrayList, Results results){
		
		try {
			// test case to remove repeating elements
			int opCheck=myArrayList.removeValue(1);
			StringBuilder sb=null;
			String result = "Failed";
			if (opCheck == 0) {
				result = "Passed";	
			}
			int x[]=myArrayList.getData();
			sb = new StringBuilder();
			for(int i=0;i<myArrayList.size();i++){
				sb.append(Integer.toString(x[i])).append(" ");
			} 
			results.storeNewResult("\n\nTest Case 5 - Removing Repeating Elements \n"+sb+"\n",result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase6(MyArrayList myArrayList, Results results){
		
		try {
			// test case to test insertion 
			int initialsum = myArrayList.sum();
			int newValue = 123;
			String result = "Test Insertion Failed";
			myArrayList.insertSorted(newValue);
			int currSum = myArrayList.sum();
			if (initialsum + newValue == currSum) {
				result = "Test Insertion Passed";
			} 
			results.storeNewResult("TestCase 1 - Inserting Value 100 \n"+"Before Insertion - Sum = \n"+Integer.toString(initialsum)+ " "+"After Insertion - Sum = \n"+Integer.toString(currSum),result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase7(MyArrayList myArrayList, Results results){
		
		try {
			// test case to test insertion 
			int initialsum = myArrayList.sum();
			int newValue = 100;
			String result = "Test Insertion Failed";
			myArrayList.insertSorted(newValue);
			int currSum = myArrayList.sum();
			if (initialsum + newValue == currSum) {
				result = "Test Insertion Passed";
			} 
			results.storeNewResult("TestCase 1 - Inserting Value 100 \n"+"Before Insertion - Sum = \n"+Integer.toString(initialsum)+ " "+"After Insertion - Sum = \n"+Integer.toString(currSum),result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase8(MyArrayList myArrayList, Results results){
		
		try {
			// test case to test insertion 
			int initialsum = myArrayList.sum();
			int newValue = 100;
			String result = "Test Insertion Failed";
			myArrayList.insertSorted(newValue);
			int currSum = myArrayList.sum();
			if (initialsum + newValue == currSum) {
				result = "Test Insertion Passed";
			} 
			results.storeNewResult("TestCase 1 - Inserting Value 100 \n"+"Before Insertion - Sum = \n"+Integer.toString(initialsum)+ " "+"After Insertion - Sum = \n"+Integer.toString(currSum),result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase9(MyArrayList myArrayList, Results results){
		
		try {
			// test case to test insertion 
			int initialsum = myArrayList.sum();
			int newValue = 100;
			String result = "Test Insertion Failed";
			myArrayList.insertSorted(newValue);
			int currSum = myArrayList.sum();
			if (initialsum + newValue == currSum) {
				result = "Test Insertion Passed";
			} 
			results.storeNewResult("TestCase 1 - Inserting Value 100 \n"+"Before Insertion - Sum = \n"+Integer.toString(initialsum)+ " "+"After Insertion - Sum = \n"+Integer.toString(currSum),result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	public void testcase10(MyArrayList myArrayList, Results results){
		
		try {
			// test case to test insertion 
			int initialsum = myArrayList.sum();
			int newValue = 100;
			String result = "Test Insertion Failed";
			myArrayList.insertSorted(newValue);
			int currSum = myArrayList.sum();
			if (initialsum + newValue == currSum) {
				result = "Test Insertion Passed";
			} 
			results.storeNewResult("TestCase 1 - Inserting Value 100 \n"+"Before Insertion - Sum = \n"+Integer.toString(initialsum)+ " "+"After Insertion - Sum = \n"+Integer.toString(currSum),result);
		} catch (Exception e) {

			
		}finally{
			
		}

	}
	
	
	}

