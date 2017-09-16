package myArrayList.test;


import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {
	public void testMe(MyArrayList myArrayList, Results results) {
		//Individual Test Case Methods
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
			String result = "*******FAILED*******";
			myArrayList.insertSorted(100);
			myArrayList.insertSorted(200);
			myArrayList.insertSorted(50);
			postSum = myArrayList.sum();

			if (postSum == 11719) {
				result = "*******PASSED*******";
				int y[] = myArrayList.getData();
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(y[i])).append(" ");
				}
			}
			results.storeNewResult("TestCase 1 - Inserting 3 Values(50,100,200) \n\n" + "\t\tBefore Insertion :\n\n\t\t"
				+"Array : " + pre + "\n\t\t Sum : "+Integer.toString(initialsum)+"\n\n\t\tAfter Insertion :\n\n\t\t"
				+ "Array : " + post + "\n\t\t Sum : "+Integer.toString(postSum)+"\n\n", result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase2(MyArrayList myArrayList, Results results) {

		try {
			// test case to remove a non-existing element
			String result = "*******FAILED - ELEMENT NOT FOUND*******";
			int x[] = myArrayList.getData();
			StringBuilder pre = new StringBuilder();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			int errorCheck = myArrayList.removeValue(567);
			if(errorCheck==-1){
			}
			else{
				 result = "*******PASSED*******";
			}
			results.storeNewResult("\n\nTestCase 2 - Removing non-existing element (567)\n\n"+"\t\tArray : " + pre + "\n\n", result);
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
			if (currSum == 11718) {
				result = "*******PASSED*******";
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(x[i])).append(" ");
				}
			}
			results.storeNewResult("\n\nTestCase 3 - Removing Existing Value \n\n" + "\t\tBefore Remove :\n"+"\t\tArray: "+pre+ "\n\t\tSum : "+ Integer.toString(initialSum)+"\n\n\t\tAfter Remove : \n"+"\t\tArray: "+post+ "\n\t\tSum : "+ Integer.toString(currSum)+"\n\n",result);
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
			if (postSum == 11841) {
				result = "*******PASSED*******";
				postSum = myArrayList.sum();
				int y[] = myArrayList.getData();
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(y[i])).append(" ");
				}
			}
			
			results.storeNewResult("\n\nTestCase 4 - Inserting Duplicate Values \n\n" + "\t\tBefore Insertion: \n\t\t"+"Array : "+pre+"\n\t\tSum : "+Integer.toString(initialSum)+ "\n\n\t\tAfter Insertion: \n\t\t"+"Array : "+post+"\n\t\tSum : "+Integer.toString(postSum)+ "\n\n", result);
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
			results.storeNewResult("\n\nTest Case 5 - Removing Repeating Elements\n\n\t\tAfter Removing :"+"\n\t\tArray : "+ sb + "\n\t\tSum : "+Integer.toString(sum)+"\n\n", result);
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
			int initialSize = myArrayList.trueSize();
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
			if (postSize > initialSize) {
				result = "*******PASSED*******";
				int y[]=myArrayList.getData();
				for (int i = 0; i < myArrayList.size(); i++) {
					post.append(Integer.toString(y[i])).append(" ");
				}
			}
			results.storeNewResult("\n\nTestCase 6 - Array Size grows from "+initialSize+" to "+postSize + "\n\n\t\tBefore Insertion: \n\t\t"+"Array : "+pre+"\n\t\tSum : "+Integer.toString(initialSum)+ "\n\n\t\tAfter Insertion: \n"+"\t\tArray : "+post+"\n\t\tSum : "+Integer.toString(postSum)+ "\n\n", result);
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
					"\n\nTestCase 7 - Array size does'nt shrink after removing elements \n\n" + "\t\tSize(Before) "
							+ Integer.toString(preSize) + "\n\t\tSize(After) " + Integer.toString(postSize) + "\n\n",
					result);
		} catch (Exception e) {

		} finally {

		}

	}

	public void testcase8(MyArrayList myArrayList, Results results) {

		try {
			// test case to test sortedness of array after inserting zero's
			// elements(124,11,13)
			StringBuilder pre = new StringBuilder();
			StringBuilder post = new StringBuilder();
			String result = "*******FAILED*******";
			int x[] = myArrayList.getData();
			for (int i = 0; i < myArrayList.size(); i++) {
				pre.append(Integer.toString(x[i])).append(" ");
			}
			myArrayList.insertSorted(0);
			myArrayList.insertSorted(0);
			myArrayList.insertSorted(0);
			for (int i = 0; i < myArrayList.size(); i++) {
				post.append(Integer.toString(x[i])).append(" ");
				result = "*******PASSED*******";
			}
			results.storeNewResult("\n\nTestCase 8 - Displaying Sorted Array After Inserting three 0's"+"\n\n\t\tBefore Insertion : " + pre + "\n"
					+ "\t\tAfter Insertion :  " + post + "\n\n", result);
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
			results.storeNewResult("\n\nTestCase 9 - Removing 0's & Display Sum" + "\n\n\t\tBefore Remove : \n\t\tArray : " + pre
					+ "\n\t\tSum : " + Integer.toString(initialSum) + "\n\n\t\tAfter Remove : \n\t\tArray : " + post + "\n\t\tSum : "
					+ Integer.toString(postSum) + "\n\n", result);
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
			results.storeNewResult("\n\nTestCase 10 - Removing Last Element & Display Sum" + "\n\n\t\tBefore Remove : \n\t\tArray : " + pre
					+ "\n\t\tSum : " + Integer.toString(initialSum) + "\n\n\t\tAfter Remove : \n\t\tArray : " + post + "\n\t\tSum : "
					+ Integer.toString(postSum) + "\n\n", result);

		} catch (Exception e) {

		} finally {

		}

	}

}
