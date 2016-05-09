import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap(){
	isMax = true;
	size = 0;
	data = (T[])new Comparable[10];
    }
   
    public MyHeap(T[] array){
	isMax = true;
	size = array.length;
	data = (T[])new Comparable[size+1];
	for (int i = 0; i < array.length; i++){
	    data[i+1] = array[i];
	}
	heapify();
    }


    public MyHeap(boolean isMax){
	this.isMax = isMax;
	size = 0;
	data = (T[])new Comparable[10];
    }
    
    public MyHeap(T[] array, boolean isMax){
	this.isMax = isMax;
	size = array.length;
	data = (T[])new Comparable[size+1];
	for (int i = 0; i < array.length; i++){
	    data[i+1] = array[i];
	}
	heapify();
    }

    
   
    private void pushDown(int k){
	T temp = data[k];
	int leaf;
	
	if (isMax){
	    //for loop structure belongs to
	    //https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
	    
	    for (; k*2 <= size; k = leaf){
	
		
		//determine bigger child
		leaf = k*2;
		if (leaf != size && data[leaf].compareTo(data[leaf+1]) < 0){ 
		    leaf++; 
		}

		//swap if need be
		if (temp.compareTo(data[leaf]) < 0){
		    data[k] = data[leaf];
		}else{
		    break;
		}

	    }
	}else{
	    for (; k*2 <= size; k = leaf){
	    
		//determine smaller child
		leaf = k*2; 
		if (leaf != size && data[leaf].compareTo(data[leaf+1]) > 0){ 
		    leaf++; 
		}

		//swap if need be
		if (temp.compareTo(data[leaf]) > 0){
		    data[k] = data[leaf];
		}else{
		    break;
		}

	    }
	}
	
	data[k] = temp;
    }


   
       
    private void pushUp(int k){
	T value = data[k];
	if (isMax){
	    for (; k > 1; k = k/2){
		if (value.compareTo(data[k/2]) > 0){
		    data[k] = data[k/2];
		    data[k/2] = value;
		}
	    }
	}else{
	    for (; k > 1; k = k/2){
		if (value.compareTo(data[k/2]) < 0){
		    data[k] = data[k/2];
		    data[k/2] = value;
		}
	    }
	}

    }
   
    private void heapify(){
	for (int k = size/2; k > 0; k--){
	    pushDown(k);
	}
    }

    public T delete(){
	if (size == 0){
	    throw new RuntimeException("cannot delete from empty heap");
	}
	
	T temp = data[1];
        data[1] = data[size--];
	pushDown(1);
	return temp;
       
    }

    public void add(T x){
	
	if (size == data.length - 1){
	    grow();
	}

	//set next available slot to the element
	int index = ++size;
	data[index] = x;
	
	//adjust heap
	pushUp(index);
    }




       
    private void grow(){
	T[] temp = (T[])new Comparable[size * 2 + 1];
	for (int i = 0; i < data.length; i++){
	    temp[i] = data[i];
	}

	data = temp;
	
    }
    
    public String toString(){
	String ans = "[";
	for (int i = 0; i < size + 1; i++){
	    ans += " " + data[i] + ",";
	}
	ans = ans.substring(0,ans.length() - 1) + "]";
	return ans;
	
    }
    public int size(){
	return size;
    }


}
