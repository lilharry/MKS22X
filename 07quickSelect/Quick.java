import java.io.*;
import java.util.*;

public class Quick{
    public static int partitionOld(int[]data,int left,int right){
	Random r = new Random();
	int pivotIndex = left + r.nextInt(right - left + 1);
	int pivot = data[pivotIndex];
	swap(data,right,pivotIndex);
	int i = left-1;
	int j = left;
	while (j < right){
	    if (data[j] < pivot){
		i++;
		swap(data,i,j);
	    }
	    j++;
	}
	swap(data,i+1,right);
	return i+1;
    }
    public static int quickselectOld(int[]data, int k){
	return quickselectOld(data,k,0,data.length-1);
    }
    
    private static int quickselectOld(int[]data, int k, int left, int right){
	int pos = partitionOld(data,left,right);
	if (pos == k){
	    return data[pos];
	}
	if (pos < k){
	    return quickselectOld(data,k,pos+1,right);
	}else{
	    return quickselectOld(data,k,left,pos-1);
	}
	   
	    
    }
    public static void quickSortOld(int[]data){
	quickSortOld(data,0,data.length-1);
    }
    private static void quickSortOld(int[]data,int left,int right){
        if (right - left >= 1){
	    int pos = partitionOld(data,left,right);
	    quickSortOld(data,left,pos-1);
	    quickSortOld(data,pos+1,right);
	}
    }





    
    // public static int[] partition(int[]data,int left,int right){
    // 	int pivotIndex = left + (int)(Math.random()*(right-left+1));
    // 	int pivot = data[pivotIndex];
    // 	int[] temp = new int[right-left+1];
    // 	int j = 0;
    // 	int k = right - left;
    // 	for (int i = left; i <= right; i++){
    // 	    if (data[i] < pivot){
    // 		temp[j] = data[i];
    // 		j++;
    // 	    }
    // 	    if (data[i] > pivot){
    // 		temp[k] = data[i];
    // 		k--;
    // 	    }
    // 	}
       
    // 	int[] ans = {j,k};
	
    // 	for (int i = j; i <= k; i++){
    // 	    temp[i] = pivot;
    // 	}
	
    // 	for (int i = 0; i < temp.length; i++){	    
    // 	    data[left + i] = temp[i];
    // 	}
    // 	return ans;
    // }
    public static int[] partition(int[] data, int left, int right) {
        int pivotIndex = (int) ((right - left + 1) * Math.random() + left);
        int pivot = data[pivotIndex];
	swap(data,pivotIndex,right);
        int i = left;
        while(left < right){
            if (data[left] < pivot) {
		swap(data,i,left);
                i++;
            }
	    left++;
        }
	int[] ans = new int[2];
	ans[0] = i;
	
        int j = i; 
        while (i < right){
            if (data[i] == pivot) {
                swap(data,i,j); 
                j++;
            }
	    i++;
        }
        ans[1] = j - 1;
	return ans;
    }
    public static void swap(int[]data,int i,int j){
	int temp = data[i];
	data[i] = data[j];
	data[j] = temp;
	
    }
    

    public static void quickSort(int[]data){
    	quickSort(data,0,data.length-1);
    }
    private static void quickSort(int[]data,int left,int right){
        if (right - left >= 1){
	    int[] pos = partition(data,left,right);
	    quickSort(data,left,pos[0]-1);
    	    quickSort(data,pos[1]+1,right);

    	}
    }



    
    public static String name(){
	return "7,Lum,Harry";
    }

    public static void main(String[]args){
	int[] d = new int [4000000];

	double totaltime,startTime,stopTime;
	totaltime = 0;

	for (int i = 0; i < 3; i++){
	    for(int x = 0; i < d.length; i++){
		d[i]= (int)(Math.random()*4) + 1;
	    }
	    startTime = System.currentTimeMillis();
	    Arrays.sort(d);
	    stopTime = System.currentTimeMillis();
	    totaltime += stopTime - startTime;
	}
	totaltime/=3000;
	System.out.println("Arrays.sort 0-3: " + totaltime);

	totaltime = 0;
	for (int i = 0; i < 3; i++){
	    for(int x = 0; i < d.length; i++){
		d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    }
	    startTime = System.currentTimeMillis();
	    Arrays.sort(d);
	    stopTime = System.currentTimeMillis();
	    totaltime += stopTime - startTime;
	}
	totaltime/=3000;
	
	
	System.out.println("Arrays.sort all ints: " + totaltime);


	for (int i = 0; i < 3; i++){
	    for(int x = 0; i < d.length; i++){
		d[i]= (int)(Math.random()*4) + 1;
	    }
	    startTime = System.currentTimeMillis();
	    quickSort(d);
	    stopTime = System.currentTimeMillis();
	    totaltime += stopTime - startTime;
	}
	totaltime/=3000;
	System.out.println("quickSort 0-3: " + totaltime);

	totaltime = 0;
	for (int i = 0; i < 3; i++){
	    for(int x = 0; i < d.length; i++){
		d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    }
	    startTime = System.currentTimeMillis();
	    quickSort(d);
	    stopTime = System.currentTimeMillis();
	    totaltime += stopTime - startTime;
	}
	totaltime/=3000;
	
	
	System.out.println("quickSort all ints: " + totaltime);

	for (int i = 0; i < 3; i++){
	    for(int x = 0; i < d.length; i++){
		d[i]= (int)(Math.random()*4) + 1;
	    }
	    startTime = System.currentTimeMillis();
	    quickSortOld(d);
	    stopTime = System.currentTimeMillis();
	    totaltime += stopTime - startTime;
	}
	totaltime/=3000;
	System.out.println("quickSort 0-3: " + totaltime);

	totaltime = 0;
	for (int i = 0; i < 3; i++){
	    for(int x = 0; i < d.length; i++){
		d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    }
	    startTime = System.currentTimeMillis();
	    quickSortOld(d);
	    stopTime = System.currentTimeMillis();
	    totaltime += stopTime - startTime;
	}
	totaltime/=3000;
	
	
	System.out.println("quickSortOld all ints: " + totaltime);
    }
}
