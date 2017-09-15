package src.myArrayList;

public class MyArrayList {

	private int capacity;
	private int[] data;
	private int count;
	private Integer sum;

	public MyArrayList(){
		capacity=6;
		data= new int[capacity];
		count=0;
		sum=0;
	}

	public void insertSorted(int newValue){
		if(count>=capacity){
			int oldCapacity=capacity;
			int newCapacity= oldCapacity+oldCapacity/2;
			this.capacity=newCapacity;
			int[] newdata= new int[capacity];
			//System.arraycopy(data, 0, newdata, 0,oldCapacity);
			for(int i=0;i<oldCapacity;i++){
				newdata[i]=data[i];
			}
			
			data= newdata;
		}
		insertNewValue(newValue);
		sum+=newValue;
	}

	private void insertNewValue(int newValue) {
		if(count==0){
			data[0]=newValue;

			// if new value is the last element 
		}else if(count>0 && newValue==data[count-1] || newValue> data[count-1]){
			data[count]=newValue;
		}else{
			int insertIndex=findIndexforEntry(newValue);	
			insertAtindex(insertIndex,newValue);	
		}
		count++;
	}

	private void insertAtindex(int insertIndex, int newValue) {
		int currIndex=0;
		if(count>0){
			currIndex=count;
			while(currIndex>insertIndex){
				data[currIndex]=data[currIndex-1];
				currIndex--;
			}
		}
		data[currIndex]=newValue;
	}

	private int findIndexforEntry(int newValue) {
		int index=0;
		if(data.length>0){
			while(data[index]<newValue){
				index++;
			}
		}
		return index;
	}

	public  int removeValue(int value){
		int errorCode=-1;
		int index=indexOf(value);	
		int startIndex;
		int endIndex;
		if(index!=-1){
			startIndex=index;
			endIndex=startIndex;
			while(endIndex<count && data[endIndex]==value){
				endIndex++;
			}
			
			int[] array1= new int[startIndex];
			//Copying values before target element
			for(int i=0;i<startIndex;i++){
				array1[i]=data[i];
			}
			//System.arraycopy(data, 0, array1, 0,startIndex);
			int remainingLength = count-endIndex;
			int[] array2= new int[remainingLength];
			for(int i=0;i<remainingLength;i++){
				array2[i]=data[endIndex+i];
			}
			for(int i=0;i<array1.length;i++){
				data[i]=array1[i];
			}
			for(int i=0;i<array2.length;i++){
				data[startIndex+i]=array2[i];
			}
		/*	System.arraycopy(data, endIndex, array2,0,array2.length);
			System.arraycopy(array1, 0, data,0,array1.length);
			System.arraycopy(array2, 0, data,startIndex,array2.length);
		*/	int noOfElementsRemoved=endIndex-startIndex;
			while(noOfElementsRemoved>0){
				data[count-1]=0;
				count--;
				noOfElementsRemoved--;
			}
			errorCode=0;
		}
		return errorCode;


	}


	public int indexOf(int value){
		int index=-1;
		if(data.length>0){
			int currIndex=0;
			while(currIndex<count-1 && data[currIndex]!=value){
				currIndex++;
			}
			if(data[currIndex]==value){
				index=currIndex;
			}
		}
		return index;
	}

	public int size(){
		return count;
	}
	
	public int trueSize(){
		return this.capacity;
	}

	public int  sum(){
		int temp=0;
		for(int i=0;i<count;i++){
			temp+=data[i];
		}
		return temp;

	}

	public String  toString(){
		StringBuilder builder= new StringBuilder("");
		if(count>0){
			int i=0;
			while(i<count){
				builder.append(data[i]+" ");
				i++;	
			}
		}
		return builder.toString();
	}
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}
}
