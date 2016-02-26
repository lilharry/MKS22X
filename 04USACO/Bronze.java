import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Bronze{
    int R,C,E,N;
    int[][] map;
<<<<<<< HEAD
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
=======
    ArrayList<Integer> R_s;
    ArrayList<Integer> C_s;
    ArrayList<Integer> D_s;
    
    public Bronze(String fileName){
	try{
	    File file = new File(fileName);
	    Scanner in = new Scanner(file);
	    Scanner line = new Scanner(in.nextLine());
	    R = line.nextInt();
	    C = line.nextInt();
	    E = line.nextInt();
	    N = line.nextInt();
	    map = new int[R][C];
	    for(int i = 0; i < R; i++){
		line = new Scanner(in.nextLine());
		for (int j = 0; j < C; j++){
		    map[i][j] = line.nextInt();
		}
	    }
	    R_s = new ArrayList<Integer>();
	    C_s = new ArrayList<Integer>();
	    D_s = new ArrayList<Integer>();
	    for(int i = 0; i < N; i++){
		line = new Scanner(in.nextLine());
		R_s.add(line.nextInt());
		C_s.add(line.nextInt());
		D_s.add(line.nextInt());
	    }
	}catch(FileNotFoundException e){
	    e.printStackTrace();
	}
	
    }

    public String solve(){
	for (int x = 0; x < R_s.size(); x++){
	    int r = R_s.get(x) - 1;
	    int c = C_s.get(x) - 1;
	    int d = D_s.get(x);
	    int max = 0;
	    for (int i = 0; i<3; i++){
		for (int j = 0; j<3; j++){
		    max = Math.max(max,map[r + i][c + j]);
		}
	    }
	    max -= d;
	    for (int i = 0; i<3; i++){
		for (int j = 0; j<3; j++){
		    if (map[r+i][c+j] > max){
			map[r+i][c+j] = max;
		    }
		}
	    }
	}
	int sum = 0;
	for (int i = 0; i<R; i++){
	    for (int j = 0; j<C; j++){
		if (map[i][j] < E){
		    sum += E - map[i][j];
		}
	    }
	}
	return sum * 72 * 72 + ",7,Lum,Harry";
	
    }

    
    public static void main(String[] args){
	Bronze b = new Bronze("makelake.txt");
	System.out.println(b.solve());
>>>>>>> db9820e884bb55766a5927ed6ef6a88bbd262c80
    }
}
