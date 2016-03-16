public class MyLinkedList{
    private class LNode{
	int data;
	LNode next;
	

	LNode(int data, LNode next){
	    this.data = data;
	    this.next = next;
	}
	
	void setValue(int data){
	    this.data = data;
	}
	void setNext(LNode next){
	    this.next = next;
	}

	int getValue(){
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
    public boolean add(int value){
	return add(size,value);
    }

    public boolean add(int index,int value){
	if (index == 0){
	    LNode x = new LNode(value,start);
	    start = x;
	    size++;
	    return true;
	}

	if (index <= size){
	    LNode current = loopTo(index - 1);
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

    public int get(int index){
	int i = 0;
	LNode current = loopTo(index);
	return current.getValue();
    }
    public int set(int index, int newValue){
	LNode current = loopTo(index);
	int old = current.getValue();
	current.setValue(newValue);
	return old;
    }
    public int size(){
	return size;
    }
    
    public int indexOf(int value){
	int i = 0;
	LNode current = start;
	while (i < size){
	    if (current.getValue() == value){
		return i;
	    }
	    current = current.getNext();
	    i++;
	}
	return -1;
    }

    public int remove(int index){
	LNode current = loopTo(index - 1);
	int old = current.getNext().getValue();
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
    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList();
	x.add(4);
	System.out.println(x.toString());
	x.add(5);
	x.add(6);
	System.out.println(x.toString());
	x.add(1,100);
	System.out.println(x.toString());
	x.set(1,0);
	System.out.println(x.toString());
	System.out.println(x.get(3));
	x.set(3,0);
	System.out.println(x.toString());
	System.out.println(x.indexOf(5));
	x.set(1,5);
	System.out.println(x.indexOf(0));
	System.out.println(x.toString());
	System.out.println(x.remove(3));
	System.out.println(x.toString());
	System.out.println(x.remove(1));
	System.out.println(x.toString());
	System.out.println(x.size());
	x.add(3,100);
	System.out.println(x.toString());
    }
}
