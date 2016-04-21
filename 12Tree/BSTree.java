public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data; 
	Node left; 
	Node right; 
	public Node(T value){
	    data = value;
	}

	public Node (T value, Node leaf1, Node leaf2){
	    data = value;
	    left = leaf1;
	    right = leaf2;
	}
	public int height(){
	    if (left == null && right == null){
		return 1;
	    }else{
		return Math.max(left.height(),right.height()) + 1;
	    }
	}

	public void add(T value){
	    if (value < data){
		if (left == null){
		    left = new Node(value);
		}else{
		    left.add(value);
		}
	    }
	    else{
		if (right == null){
		    right = new Node(value);
		}else{
		    right.add(value);
		}
	    }
	    
	}
	
	public String toString(){
	    String ans = "";
	    ans += value + " ";

	    if (left == null){
		ans += "_ ";
	    }else{
		ans += left.toString();
	    }

	    if (right == null){
		ans += "_ ";
	    }else{
		ans += right.toString();
	    }

	    return ans;
	}

	public boolean contains(T value){
	    if (value.equals(value)){
		return true;
	    }
	    try{ //fix
		marker = left.contains(value) || right.contains(value);
	    }catch(NullPointerException e){
	    }
	   
		
		    
		    

    }

    private Node root; 

    public int getHeight(){
	return root.height();
    }
}
