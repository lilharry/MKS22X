import java.util.Arrays;
public class Sorts{
    public static void InsertionSort(int[]array){
	int currentval = array[0];
	for (int i = 0;i<array.length;i++){
	    currentval = array[i];
	    int j;
	    for (j = i - 1; j >= 0 && currentval < array[j]; j--){
		array[j+1] = array[j];
	    }
	    array[j+1] = currentval;
	    //System.out.println(Arrays.toString(array));
			      
	}
	    
    }

    public static void SelectionSort(int[]array){
	for (int i = 0;i<array.length - 1;i++){
	    int indexmin = i;
	    for (int j = i+1; j < array.length; j++){
		if (array[j] < array[indexmin]){
		    indexmin = j;
		}
	    }
	    int minimum = array[indexmin];
	    array[indexmin] = array[i];
	    array[i] = minimum;
	    
	    //System.out.println(Arrays.toString(array));
	}
    }
    public static void BubbleSort(int[]array){
	boolean marker = true;
	int z = 1;
	while (marker){
	    marker = false;
	    for (int i = 0;i<array.length-z;i++){
		if (array[i] > array[i+1]){
		    int x = array[i+1];
		    array[i+1] = array[i];
		    array[i] = x;
		    marker = true;
		}
		System.out.println(Arrays.toString(array));
	    }
	    z++;
	    
	    
	}
    }
    public static void merge(int[] data, int startA, int endA, int startB, int endB){
	int[] temp = new int[endB - startA + 1];
	int x = startA;
	int y = startB;
	int z = 0;
	for (int i = startA; i < endB; i++){
	    while (x < endA + 1 && y < endB + 1){
		if (data[x] >= data[y]){
		    temp[z] = data[y];
		    
		    y++;
		}else{
		    temp[z] = data[x];
		    x++;
		}
		z++;
	    }
	    
	}

	
	if (x < endA + 1){
	    while (x < endA + 1){
	 	temp[z] = data[x];
	 	x++;
	 	z++;
	    }
	}
	if (y < endB + 1){
	    while (y < endB + 1){
	 	temp[z] = data[y];
	 	y++;
	 	z++;
	    }
	}
	for (int i = 0; i < temp.length; i++){
	    data[startA + i] = temp[i];
	}
    }

    public static void mergesort(int[] data){
	mergeSortHelper(data,0,data.length - 1);
    }
    
    public static void mergeSortHelper(int[] data, int start, int end){
	if (start != end){
	    mergeSortHelper(data,start,(start + end) / 2);
	    mergeSortHelper(data,(start+end)/2 + 1, end);
	}
	merge(data,start,(start+end)/2,(start + end)/2+1,end);
    }
    
    public static void main(String[]args){
	int[] x = {6,4,2,3,5,7,1,1,2,2,2,3,1,3,4,5,6,7};
	mergesort(x);
	for (int i = 0; i< x.length; i++){
	    System.out.print(x[i]);
	}
	//InsertionSort(x);
        //SelectionSort(x);
	//BubbleSort(x);
    }
}
