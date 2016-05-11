public class RunningMedian{
    private MyHeap<Integer> min;
    private MyHeap<Integer> max;
    
    private int size;
    
    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap();
    }

    public double getMedian(){
	if (size = 0){
	    throw new NoSuchElementException();
	}
	if (size % 2 == 0){
	    return min.peek() / max.peek();
	}else{
	    return biggersize().peek();
	}
    }

    private MyHeap biggersize(){
	if (min.size() > max.size()){
	    return min;
	}else{
	    return max;
	}
    }

    public void add(Integer x){
	if (x < getMedian()){
	    min.add(x);
	}else{
	    max.add(x);
	}
	
	
    }
  
    
    
    
}
   
