import java.io.*;
import java.util.*;

public class Quick{
    public static int partition(int[]data,int left,int right){
	Random r = new Random();
	int pivotIndex = left + r.nextInt(right - left + 1);
	int pivot = data[pivotIndex];
	swap(data,left,pivotIndex);
	int x = left+1;
	int y = left+1;
	//i is the current card
	//x is the first open card
	//y is the last closed card
        for (int i = left+1 ; i <= right; i++){
	    System.out.println("x=" + x);
	    System.out.println("y=" + y);
	    if (data[i] < pivot){
		
		swap(data,i,x);
		y = i;
	    }
	    x++;
	    
	}
	swap(data,left,y);

	return y;
    }
    public static void swap(int[]data,int i,int j){
	int temp = data[i];
	data[i] = data[j];
	data[j] = temp;
	
    }
    public static void main(String[]args){
	int[] x = {3,8,2,4,7};
	//2,8,3,4,7
	
        System.out.println(partition(x,0,4));
	for (int i = 0; i<x.length;i++){
	    System.out.print(x[i] + ",");
	}
    }
}
