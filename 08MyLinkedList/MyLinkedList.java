import java.io.*;
import java.lang.*;
public class MyLinkedList<T>{
    private class LNode{
	private T data;
	private LNode next;
	

	LNode(T data, LNode next){
	    this.data = data;
	    this.next = next;
	}
	
	void setValue(T data){
	    this.data = data;
	}
	void setNext(LNode next){
	    this.next = next;
	}

	T getValue(){
	    return data;
	}

	LNode getNext(){
	    return next;
	}
	
	
    }
    
    //LinkedList class
    
    //begin
    private LNode start;
    //end
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    public MyLinkedList(LNode x){
	start = x;
	size = 1;
    }



    //add new LNode
    public boolean add(T value){
	return add(size,value);
    }

    public boolean add(int index,T value){
	if (index == 0){
	    LNode x = new LNode(value,start);
	    start = x;
	    size++;
	    return true;
	}

	if (index <= size){
	    LNode current = loopToAdd(index - 1);
	    LNode x = new LNode(value,current.getNext());
	    current.setNext(x);
	    size++;
	    return true;
	}
	return false;
	
    }

    public String toString(){
	LNode current = start;
	String ans = "[";

	for (int i = 0; i < size - 1; i++){
	    ans += current.getValue() + ", ";
	    current = current.getNext();
	}
        ans += current.getValue() + "]";
	return ans;
    }

    public T get(int index){
	int i = 0;
	LNode current = loopTo(index);
	return current.getValue();
    }
    public T set(int index, T newValue){
	LNode current = loopTo(index);
	T old = current.getValue();
	current.setValue(newValue);
	return old;
    }
    public int size(){
	return size;
    }
    
    public int indexOf(T value){
	int i = 0;
	LNode current = start;
	while (i < size){
	    if (current.getValue().equals(value)){
		return i;
	    }
	    current = current.getNext();
	    i++;
	}
	return -1;
    }

    public T remove(int index){
	LNode current = loopTo(index - 1);
	T old = current.getNext().getValue();
	current.setNext(current.getNext().getNext());
	size--;
	return old;
    }

    //returns LNode at given index
    private LNode loopTo(int index){
	if (index < size){
		
	    int i = 0;
	    LNode current = start;
	    while (i < index){
		current = current.getNext();
		i++;
	    }
	    return current;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    private LNode loopToAdd(int index){
	if (index <= size && 0 <= index){
		
	    int i = 0;
	    LNode current = start;
	    while (i < index){
		current = current.getNext();
		i++;
	    }
	    return current;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
}
