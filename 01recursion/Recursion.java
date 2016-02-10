public class Recursion{
    public String name(){
	return "Lum,Harry";
    }
    
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	double guess = (n + 1) / 2;
	if (Math.abs(guess*guess -n) 
    }

    private double helper(double n, double guess){
	guess = (n/guess + guess) / 2;

    }

    
}
