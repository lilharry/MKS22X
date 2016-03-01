import java.util.Scanner;
import java.io.*;
import java.util.File;
import java.lang.FileNotFoundException;


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
	    int[][] temp = new int[N][M];
	    temp[0][0] = 1;
	    int[][] temp2 = new int[N][M];
	    
	    x = 0;
	    while (x < T){
		for (int i = 0; i < N; i++){
		    //fixthis
		}
		x++;
	    }

	    

	    String line;
	    for (int i = 0; i < N; i++){
		line = in.nextLine();
		for (int j = 0; j < M; j++){
		    if (line.charAt(j) == '*'){
			maze[i][j] = -1;
		    }
		
	    }
	}
	catch(FileNotFoundException e){
	    e.printStackTrace();
	}
    }
}
