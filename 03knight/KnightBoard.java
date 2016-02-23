public class KnightBoard{
    private int[][] board;
    private int moved;

    public KnightBoard(int size){
	board = new int[size][size];
    }
    public KnightBoard(int cols, int rows){
	board = new int[rows][cols];
	moved = 1;
    }

    public boolean solve(){
	return solveH(0,0);
    }

    public boolean solveH(int row, int col){
	if (moved == board.length * board[0].length + 1){
	    return true;
	}
	if (board[row][col] != 0){
	    return false;
	}

	board[row][col] = moved++;

	if (okSpot(row+2,col+1) && solveH(row+2,col+1)){

	    return true;
	}
	if (okSpot(row+2,col-1) && solveH(row+2,col-1)){
	    return true;
	}
	if (okSpot(row-2,col+1) && solveH(row-2,col+1)){
	    return true;
	}
	if (okSpot(row-2,col-1) && solveH(row-2,col-1)){
	    return true;
	}
	if (okSpot(row+1,col+2) && solveH(row+1,col+2)){
	    return true;
	}
	if (okSpot(row+1,col-2) && solveH(row+1,col-2)){
	    return true;
	}
	if (okSpot(row-1,col+2) && solveH(row-1,col+2)){
	    return true;
	}
	if (okSpot(row-1,col-2) && solveH(row-1,col-2)){
	    return true;
	}
	board[row][col] = 0;
	moved --;
	return false;


    	
    }

    public boolean okSpot(int row, int col){
	return (row >= 0 && row < board.length &&
		col >= 0 &&  col < board[0].length);
    }
	

    public void printSolution(){
	boolean leadWithSpace = false;
	if (board.length * board[0].length >= 10){
	    leadWithSpace = true;
	}
	for (int i = 0; i < board.length; i++){
	    String line = "";
	    for (int j = 0; j < board[0].length; j++){
		if (leadWithSpace && board[i][j] < 10){
		    line += " " + board[i][j] + " ";
		}else{
		    line += board[i][j] + " ";
		}
	    }
	    System.out.println(line);
	}
		

    }

    public static void main(String[]args){
	KnightBoard b = new KnightBoard(10,10);
	b.solve();
	b.printSolution();
    }
}
