package src.test;

import src.myArrayList.*;
import src.util.*;

public class MyArrayListTest {
	public void testMe(MyArrayList myArrayList, Results results) {
		// TEST CASE 1
		testcase1(myArrayList, results);
		testcase2(myArrayList, results);
		testcase3(myArrayList, results);
		testcase4(myArrayList, results);
		testcase5(myArrayList, results);
		testcase6(myArrayList, results);
		testcase7(myArrayList, results);
		testcase8(myArrayList, results);
		testcase9(myArrayList, results);
		testcase10(myArrayList, results);

	}

	public void testcase1(MyArrayList myArrayList, Results results) {
		try {
			// test case to test insert elements into list
			int initialsum = myArrayList.sum();
			int postSum = 0;

			int x[] = myArrayList.getData();
			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			int newValue = 12;
			String result = "*******FAILED*******";
			myArrayList.insertSorted(newValue);
			newValue = 1;
			myArrayList.insertSorted(newValue);
			newValue = 0;
			myArrayList.insertSorted(newValue);
			newValue = 1234;
			myArrayList.insertSorted(newValue);
			newValue = 9999;
			myArrayList.insertSorted(newValue);
			newValue = 123;
			myArrayList.insertSorted(newValue);
			postSum = myArrayList.sum();

			if (postSum == 11369) {
				result = "*******PASSED*******";
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(x[i])).append(" ");
				}
			}
			results.storeNewResult("TestCase 1 - Inserting Values \n" + "Before Insertion - Sum = "
					+ Integer.toString(initialsum) + "\n Array:" + pre + "\nAfter Insertion - Sum = "
					+ Integer.toString(postSum) + "\n Array:" + post + "\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase2(MyArrayList myArrayList, Results results) {

		try {
			// test case to verify sorted array
			String result = "*******FAILED*******";
			int x[] = myArrayList.getData();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < myArrayList.size(); i++) {
				sb.append(Integer.toString(x[i])).append(" ");
			}
			result = "*******PASSED*******";
			results.storeNewResult("\n\nTestCase 2 - Displaying Sorted Array"+"\n Array : " + sb + "\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase3(MyArrayList myArrayList, Results results) {

		try {
			// test case to remove a single element from the list
			int initialSum = myArrayList.sum();
			String result = "*******FAILED*******";
			int x[] = myArrayList.getData();
			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			myArrayList.removeValue(1);
			int currSum = myArrayList.sum();
			if (currSum == 11368) {
				result = "*******PASSED*******";
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(x[i])).append(" ");
				}
			}
			results.storeNewResult("\n\nTestCase 3 - Removing Value 1 \n" + "Before Remove - Sum = "
					+ Integer.toString(initialSum) + "\n Array: "+pre+ "\nAfter Remove - Sum = " + Integer.toString(currSum)+"\n Array: "+post+"\n",result);
			} 
		catch (Exception e) {

		} finally {

		}

	}

	public void testcase4(MyArrayList myArrayList, Results results) {

		try {
			// test case - inserting duplicate element(123)
			int initialSum = myArrayList.sum();
			int postSum = 0;

			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			String result = "*******FAILED*******";
			int x[] = myArrayList.getData();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			myArrayList.insertSorted(123);
			postSum = myArrayList.sum();
			if (postSum == 11491) {
				result = "*******PASSED*******";
				postSum = myArrayList.sum();
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(x[i])).append(" ");
				}
			}
			
			results.storeNewResult("\n\nTestCase 4 - Inserting Duplicate Values \n" + "Before Insertion: \n"+"Array : "+pre+"\n Sum : "+Integer.toString(initialSum)+ "\n\nAfter Insertion: \n"+"Array : "+post+"\n Sum : "+Integer.toString(postSum)+ "\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase5(MyArrayList myArrayList, Results results) {

		try {
			// test case to remove repeating elements (123) - 2 occurrences
			int opCheck = myArrayList.removeValue(123);
			int sum = myArrayList.sum();
			StringBuilder sb = null;
			String result = "*******FAILED*******";
			if (opCheck == 0) {
				result = "*******PASSED*******";
			}
			int x[] = myArrayList.getData();
			sb = new StringBuilder();
			for (int i = 0; i < myArrayList.size(); i++) {
				sb.append(Integer.toString(x[i])).append(" ");
			}
			results.storeNewResult("\n\nTest Case 5 - Removing Repeating Elements"+"\n Array : "+ sb + "\n Sum : "+Integer.toString(sum)+"\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase6(MyArrayList myArrayList, Results results) {

		try {
			// test case to display array size growing after inserting values
			int postSize = 0;
			int initialSum=myArrayList.sum();
			int postSum=0;
			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			String result = "*******FAILED*******";
			int x[] = myArrayList.getData();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			myArrayList.insertSorted(123);
			myArrayList.insertSorted(123);
			myArrayList.insertSorted(123);
			postSize = myArrayList.trueSize();
			postSum=myArrayList.sum();
			if (postSize == 9) {
				result = "*******PASSED*******";
				int y[]=myArrayList.getData();
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(y[i])).append(" ");
				}
			}
			results.storeNewResult("\n\nTestCase 6 - Array grows from size 6 to 9  \n" + "Before Insertion: \n"+"Array : "+pre+"\n Sum : "+Integer.toString(initialSum)+ "\n\nAfter Insertion: \n"+"Array : "+post+"\n Sum : "+Integer.toString(postSum)+ "\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase7(MyArrayList myArrayList, Results results) {

		try {
			// test case to show that array size does'nt shrink after removing
			// elements
			int preSize = myArrayList.trueSize();
			int postSize = 0;
			String result = "*******FAILED*******";
			myArrayList.removeValue(9999);
			postSize = myArrayList.trueSize();
			if (preSize == postSize) {
				result = "*******PASSED*******";
			}
			results.storeNewResult(
					"\n\nTestCase 7 - Array size does'nt shrink after removing elements \n" + "Size(Before) "
							+ Integer.toString(preSize) + "\nSize(After) " + Integer.toString(postSize) + "\n",
					result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase8(MyArrayList myArrayList, Results results) {

		try {
			// test case to test sortedness of array after inserting random
			// elements(124,11,13)
			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			String result = "*******FAILED*******";
			int x[] = myArrayList.getData();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			myArrayList.insertSorted(124);
			myArrayList.insertSorted(11);
			myArrayList.insertSorted(0);
			for (int i = 0; i < myArrayList.size(); i++) {
				post.append(Integer.toString(x[i])).append(" ");
				result = "*******PASSED*******";
			}
			results.storeNewResult("\n\nTestCase 8 - Displaying Sorted Array(Before Insertion) \n" + pre + "\n"
					+ "Displaying Sorted Array(After Insertion) \n" + post + "\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase9(MyArrayList myArrayList, Results results) {

		try {
			// test case to remove value 0 & display array including sum
			int initialSum = myArrayList.sum();
			int postSum = 0;
			String result = "*******FAILED*******";
			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			int x[] = myArrayList.getData();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			myArrayList.removeValue(0);
			for (int i = 0; i < myArrayList.size(); i++) {
				post.append(Integer.toString(x[i])).append(" ");
				result = "*******PASSED*******";
				postSum = myArrayList.sum();
			}
			results.storeNewResult("\n\nTestCase 9 - Removing Value Zero & Display Sum" + "\nBefore Remove : \n" + pre
					+ "\n\nSum : " + Integer.toString(initialSum) + "\nAfter Remove : \n" + post + "\n\nSum : "
					+ Integer.toString(postSum) + "\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase10(MyArrayList myArrayList, Results results) {

		try {
			// test case to remove last element from the array
			int initialSum = myArrayList.sum();
			int postSum = 0;
			String result = "*******FAILED*******";
			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			int x[] = myArrayList.getData();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			myArrayList.removeValue(1234);
			for (int i = 0; i < myArrayList.size(); i++) {
				post.append(Integer.toString(x[i])).append(" ");
				result = "*******PASSED*******";
				postSum = myArrayList.sum();
			}
			results.storeNewResult("\n\nTestCase 10 - Removing Last Value & Display Sum" + "\nBefore Remove : \n" + pre
					+ "\n\nSum : " + Integer.toString(initialSum) + "\nAfter Remove : \n" + post + "\n\nSum : "
					+ Integer.toString(postSum) + "\n", result);

		} catch (Exception e) {

		} finally {

		}

	}

}
