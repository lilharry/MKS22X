public class test{
    

    public static int nestAndBreakfast(int[] array){
	return nestAndBreakfastH(array,0,0);
    }
    
    public static int nestAndBreakfastH(int[]array, int index, int sum){
    
	if (index >= array.length){
	    return sum;
	}
	else{
            
	    return Math.max( nestAndBreakfastH(array,index + 2, sum + array[index]),
			    
			    nestAndBreakfastH(array,index + 1, sum) 
			     )
		;
	}
    }
    


    public static void main(String[] args){
    int [] a = {5, 1, 5};
      int [] b = {10, 4, 5,9,1};
      int [] c = {1,5,3};
    System.out.println(test.nestAndBreakfast(a));
    System.out.println(test.nestAndBreakfast(b));
    System.out.println(test.nestAndBreakfast(c));
    }
    
}
