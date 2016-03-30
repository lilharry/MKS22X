import java.util.*;
public class MyQueue<T>{
    MyLinkedList data;
    public MyQueue(){
	data = new MyLinkedList<T>();
    }
    public void enqueue(T item){
        data.add(size(),item);
    }
    public T dequeue(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data.remove(0);
    }
    public T peek(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data.get(0);
    }
    public int size(){
	return data.size();
    }
    public boolean isEmpty(){
	return size() == 0;
    }
}
	    
