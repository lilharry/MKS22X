public class Recursion{
    public String name(){
	return "Lum,Harry";
    }
    
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	double guess = (n + 1) / 2;
<<<<<<< HEAD
	if (Math.abs(guess*guess -n) 
=======
	if (Math.abs((guess*guess -n)/n) < 0.0000000000001){
	    return guess;
	}else{
	    return helper(n,guess);
	}
>>>>>>> 313a41c602cee9583031f58d89f46779c424af4f
    }

    private double helper(double n, double guess){
	guess = (n/guess + guess) / 2;
<<<<<<< HEAD

    }

    
=======
	if (Math.abs((guess*guess -n)/n) < 0.0000000000001){
	    return guess;
	}else{
	    return helper(n,guess);
	}
    }
    /*
    public static void main(String[]args){
	Recursion x = new Recursion();
	System.out.println(x.sqrt(100));
	System.out.println(x.sqrt(100232.2));
	System.out.println(x.sqrt(15.2));
    }
    */
>>>>>>> 313a41c602cee9583031f58d89f46779c424af4f
}
