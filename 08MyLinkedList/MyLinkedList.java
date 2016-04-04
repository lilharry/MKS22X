import java.io.*;
import java.lang.*;
public class MyLinkedList<T>{
    private class LNode{
	private T data;
	private LNode previous,next;
	
	
	LNode(T data){
	    this.data = data;
	}
	LNode(T data, LNode previous, LNode next){
	    this.data = data;
	    this.previous = previous;
	    this.next = next;
	}
	
	void setValue(T data){
	    this.data = data;
	}

	void setPrev(LNode previous){
	    this.previous = previous;
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
    private LNode head,tail;
    //end
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    //add new LNode
    public boolean add(T value){
	return add(size,value);
    }

    public boolean add(int index,T value){
	//check if in bounds
	if (index >= 0 && index <= size){
	    //special case (when there are no elements in list);
	    if (index == 0){
		LNode x = new LNode(value);
		head = x;
		tail = x;
	    }

	    else{ 
		//position the LNode
		LNode before = loopTo(index - 1);
		LNode after = before.getNext();
		//lock it in
		LNode toAdd = new LNode(value,before,after);
		before.setNext(toAdd);
		after.setPrev(toAdd);

	    }

	    size++;
	    return true;
	
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public String toString(){
	LNode current = head;
	String ans = "[";

	for (int i = 0; i < size - 1; i++){
	    ans += current.getValue() + ", ";
	    current = current.getNext();
	}
        ans += current.getValue() + "]\n";
	
	//now backwards
	current = tail;
	String temp = "]";
	for (int i = 0; i < size - 1; i++){
	    temp = current.getValue() + temp;
	    current = current.getPrev();
	}
	
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
	if (index == 0){
	    T old = start.getValue();
	    start = start.getNext();
	    size--;
	    return old;
	}
	LNode current = loopTo(index - 1);
	T old = current.getNext().getValue();
	current.setNext(current.getNext().getNext());
	size--;
	return old;
    }

    //returns LNode at given index
    private LNode loopTo(int index){
	int i = 0;
	LNode current = start;
	while (i < index){
	    current = current.getNext();
	    i++;
	}
	return current;

    }
}
