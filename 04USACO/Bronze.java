import java.util.Scanner;
public class Bronze{
    int R,C,E,N;
    int[][] map;
    int[] R_s;
    int[] C_s;
    int[] D_s;
    public Bronze(String fileName){
	Scanner in = new Scanner(new File(fileName));
	String line = in.nextLine();  
	R = line.nextInt();
	C = line.nextInt();
	E = line.nextInt();
	N = line.nextInt();
	

	    
	
	    
    }



    public static void main(String[] args){
	Bronze b = new Bronze(args[0]);
	System.out.println(b.solve() + ",7,Lum,Harry");
    }
}
