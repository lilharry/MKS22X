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
   }
   private void pushDown(int k){
       
   }
   private void pushUp(int k)
   private void heapify()
   public T delete()
   public void add(T x)
   private void doubleSize()
   public String toString()

   //do this last
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)

}
