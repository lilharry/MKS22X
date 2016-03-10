import java.io.*;
import java.util.*;

public class Quick{
    public static int partition(int[]data,int left,int right){
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
    public static void swap(int[]data,int i,int j){
	int temp = data[i];
	data[i] = data[j];
	data[j] = temp;
	
    }
    
    public static int quickselect(int[]data, int k){
	return quickselect(data,k,0,data.length-1);
    }
    
    private static int quickselect(int[]data, int k, int left, int right){
	int pos = partition(data,left,right);
	if (pos == k){
	    return data[pos];
	}
	if (pos < k){
	    return quickselect(data,k,pos+1,right);
	}else{
	    return quickselect(data,k,left,pos-1);
	}
	   
	    
    }
    
    public static String name(){
	return "7,Lum,Harry";
    }
    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }
    private static void quickSort(int[]data,int left,int right){
        if (right - left >= 1){
	    int pos = partition(data,left,right);
	    quickSort(data,left,pos-1);
	    quickSort(data,pos+1,right);
	}
    }
    public static void main(String[]args){
	int[] x = {3,8,2,4,7,7,2,3,5,7,1,7,8,3,5,23,-1,4,16,0,14,7,8,2,3,4,7,8,8,4,125};
	//2,8,3,4,7
	quickSort(x);
	for (int i = 0; i<x.length;i++){
	    System.out.print(x[i] + ",");
	}
    }
}
