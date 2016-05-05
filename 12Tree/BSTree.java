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


	public T setValue(T value){
	    T temp = data;
	    data = value;
	    return temp;
	}

	public T getValue(){
	    return data;
	}

	public void setLeft(Node node){
	    left = node;
	}

	public void setRight(Node node){
	    right = node;
	}
	
	public Node getLeft(){
	    return left;
	}
	
	public Node getRight(){
	    return right;
	}


	
	public int height(){
	    if (left == null && right == null){
		return 1;
	    }else{
		if (right == null){
		    return left.height() + 1;
		}else if (left == null){
		    return right.height() + 1;
		}else{
		    return Math.max(left.height(),right.height()) + 1;
		}
	    }
	}

	public void add(T value){
	    if (value.compareTo(data) < 0){
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
	    ans += data + " ";

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
	    if (data.equals(value)){
		return true;
	    }
	    
	    boolean contains = false;

	    if (value.compareTo(data) < 0){
		if (left != null){
		    contains = left.contains(value);
		}
	    }else{
		if (right != null){
		    contains = right.contains(value);
		}
	    }
	    return contains;
	}
	public boolean remove(T value, Node parent){
	    if (contains(value)){
		
		if (value.compareTo(data) == 0){
		    if (left != null && right != null){
			data = right.min();
			right.remove(data,this);
     		    }else{
			if (parent.left == this){
			    if (this.left != null){
				parent.left = left;
			    }else{
				parent.left = right;
			    }
			}
			if (parent.right == this){
			    if (this.left != null){
				parent.right = left;
			    }else{
				parent.right = right;
			    }
			}
			       
		    }
		    return true;
		    
		}else{   
		    if (value.compareTo(data) < 0){
			return left.remove(value, this);
		    }else{
			return right.remove(value,this);
		    }
		}
		    
		
	    }else{
		return false;
	    }
	    
	}

	private T min(){
	    if (left != null){
		return left.min();
	    }else{
		return data;
	    }
	}
	    

	
	   
		
		    
		    

    }

    private Node root;
    
    public BSTree(T data){
        root = new Node(data);
    }


    public int getHeight(){
	if (root != null){
	    return root.height();
	}else{
	    return 0;
	}
    }

    public void add(T value){
	if (root != null){
	    root.add(value);
	}else{
	    throw new NullPointerException();
	}
    }

    public String toString(){
	if (root != null){
	    return root.toString();
	}else{
	    throw new NullPointerException();
	}
    }
       
    

    public boolean contains(T value){
	if (root != null){
	    return root.contains(value);
	}else{
	    throw new NullPointerException();
	}
    }

    public boolean remove(T value){
	if (root != null){
	    Node temp = new Node(value); //random node, has no significance.
	    temp.setLeft(root);
	    boolean ans = root.remove(value, temp);
	    root = temp.getLeft();
	    return ans;
	}else{
	    return false;
	}
    }


    // public static void main(String[] args){
    // 	BSTree<Integer> n = new BSTree<Integer>(3);
    // 	System.out.println(n.toString());
    // 	n.add(4);
    // 	n.add(6);
    // 	n.add(7);
    // 	n.add(2);
    // 	n.add(1);
    // 	System.out.println(n.toString());
    // 	System.out.println(n.getHeight());
    // 	n.remove(7);
    // 	System.out.println(n.toString());
    // 	n.remove(3);
    // 	System.out.println(n.toString());
    // 	System.out.println(n.remove(2));
    // 	System.out.println(n.toString());
    // 	System.out.println(n.remove(8));
    // 	System.out.println(n.toString());

			   
	
    // }
}
