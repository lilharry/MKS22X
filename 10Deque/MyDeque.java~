public class MyDeque<T>{
    T[] data;
    int size;
    int start,end;
    @SuppressWarning({"unchecked"})
	public MyDeque(){
	
	data = (T[]) new Object[10];
	size = 0;
	

    }
    public MyDeque(int size){
	if (size < 0){
	    data = new T[size];
	    this.size = size;
	}
	else{
	    throw new IllegalArgumentException();
	}

    }
    
    private void grow(){
	newData T[];
	if (size == 0){
	    newData = new T[1];
	}else{
	    newData = new T[size * 2];
	    for (int i = 0; i < data.size; i++){
		if (i + start < data.size){
		    newData[i] = data[i + start];
		}
		else{
		    newData[i] = data[size - start + i];
		}
	}
      
	
       
    }
    
}
