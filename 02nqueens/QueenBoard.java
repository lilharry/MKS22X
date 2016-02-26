public class QueenBoard{
    private int[][]board;
    int size;

    public QueenBoard(int size){
	board = new int[size][size];
	this.size = size;
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve(){
        return solveH(0);
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	if (col >= size){
	    return true;
	}
	
	for (int i = 0; i < size; i++){
	    if (addQueen(i, col)){
		return solveH(col + 1);
	    }
	    removeQueen(i,col);

	}

	if (col == 0){
	    return false;
	}else{
	    return solveH(col - 1);
	}

    }

    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
	String ans = "";
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		if (board[i][j] == 1){
		    ans += "Q ";
		}else{
		    ans += "_ ";
		}
			
	    }
	    ans += "\n";
	}
	System.out.println(ans);
		
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(1);
        b.solve();
	b.printSolution();
    }
    
    
}
