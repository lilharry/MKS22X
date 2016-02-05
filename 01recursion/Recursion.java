public class Recursion{
    public String name(){
	return "Lum,Harry";
    }
    
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	double guess = (n + 1) / 2;
	if (Math.abs((guess*guess -n)/n) < 0.0000000000001){
	    return guess;
	}else{
	    return helper(n,guess);
	}
    }

    private double helper(double n, double guess){
	guess = (n/guess + guess) / 2;
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
}
