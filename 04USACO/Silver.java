import java.util.Scanner;
import java.io.*;


public class Silver{
    int N,M,T;
    int[][] maze;
    int R1,C1,R2,C2;
    public Silver(String fileName){
    	try{
    	    File file = new File(fileName);
    	    Scanner in = new Scanner(file);
    	    Scanner inLine = new Scanner(in.nextLine());
    	    N = inLine.nextInt();
    	    M = inLine.nextInt();
    	    T = inLine.nextInt();
    	    inLine.close();
    	    maze = new int[N][M];
    	    int[][] temp1 = new int[N][M];
	    int[][] temp2 = new int[N][M];
	    
	    String line;
	    for (int i = 0; i < N; i++){
    		line = in.nextLine();
    		for (int j = 0; j < M; j++){
    		    if (line.charAt(j) == '*'){
    			temp1[i][j] = -1;
    		    }
		    
    		}
    	    }
	    inLine = new Scanner(in.nextLine());
	    R1 = inLine.nextInt();
	    C1 = inLine.nextInt();
	    R2 = inLine.nextInt();
	    C2 = inLine.nextInt();
	    inLine.close();
	    in.close();	    
	    
	    temp1[R1-1][C1-1] = 1;
	    
    	  
	    
    	    int x = 0;
	    
    	    while (x < T){

		// if T odd, stored in temp2
    		if (x%2 == 0){
    		    for (int i = 0; i < N; i++){
    			for (int j = 0; j < M; j++){
    			    temp2[i][j] = sumAround(temp1,i,j);
    			}
			
    		    }
		}
		// if T even, stored in temp1
    		else{
    		    for (int i = 0; i < N; i++){
    			for (int j = 0; j < M; j++){
    			    temp1[i][j] = sumAround(temp2,i,j);
    			}
			
    		    }
    		}
		
    		x++;
    	    }
	    if (T%2 == 0){
		maze = temp1;
	    }else{
		maze = temp2;
	    }
	    
	    

	    


    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}
	    
    }
    public int solve(){
	return maze[R2-1][C2-1];
    }
    public void printSolution(){
	for (int i = 0; i < N; i++){
	    String ans = "";
	    for (int j = 0; j < M; j++){
		ans += maze[i][j] + " ";
	    }
	    System.out.println(ans + "\n");
	}
    }
    //returns sum of tiles adjacent to (x,y) in the 2d array specified
    private int sumAround(int[][] array, int x,int y){
	if (array[x][y] == -1){
	    return -1;
	}
	int a,b,c,d;
	a = sumAroundH(array,x,y+1);
	b = sumAroundH(array,x,y-1);
	c = sumAroundH(array,x+1,y);
	d = sumAroundH(array,x-1,y);
	return a + b + c + d;
    }
    private int sumAroundH (int[][] array, int x,int y) {
	try{
	    int val = array[x][y];
	    if (val == -1){
		return 0;
	    }
	    return val;
	}catch(ArrayIndexOutOfBoundsException e){
	} 
	return 0;
    }
   
    public static void main(String[]args){
	Silver s = new Silver("test2.txt");
	System.out.println(s.solve() + ",7,Lum,Harry");
	//s.printSolution();
	
    }
	
}
