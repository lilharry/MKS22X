import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       size = 0;
       data = new Comparable[10];
   }
   
   public MyHeap(T[] array){
       size = array.length;
       data = new Comparable[size];
       heapify(data);
   }
   
   private void pushDown(int k){
       if (k <= size / 2){ //works only if k has children
	   T temp = data[k];
	   data[k] = data[k*2];
	   data[k*2] = temp;
       }

   }

   private void pushUp(int k){
       T temp = data[k];
       data[k] = data[k/2];
       data[k/2] = temp;
   }
   
   private void heapify(){}

   public T delete(){

   }

   public void add(T x){
       if (size == 0){
       }
   }

   private void grow(){
       int temp = new Comparable[data.length*2];
       for (int i = 0; i < data.length; i++){
	   temp[i] = data[i];
       }
       data = temp;
   }

       
   private void doubleSize(){}
   public String toString(){}

   //do this last
   public MyHeap(boolean isMax){}
   public MyHeap(T[] array, boolean isMax){}

}
