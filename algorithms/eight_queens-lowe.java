public class EightQueens
{
	// board[i] = column in row i with a queen in column row[i]
	private int [] board;
	private int counter;
	
	// constructor
	public EightQueens()
	{
		board = new int[8];
		counter = 0;
		
		// 0 means no queen on that row
		// 1-8 indicates the position of the queen on that row
	}
	
	// generate the next queen placement
	// return the next row to place
	// -1 on failure
	private int nextCandidate(int row)
	{
		counter ++;
		if(board[row] < 8){
			++board[row];
			return row+1;
		}
		
		//no other moves to try
		return -1;
	}
	
	// check to see if the candidate is feasible
	private boolean feasible(int row)
	{
		for (int i=0; i<row; i++){
			// check column
			if(board[i] == board[row]) {
				return false;
			}
			
			// check diagonals
 			if (Math.abs(board[i]-board[row]) == Math.abs(i-row)){
				return false;
			}
		}
		// feasible solution
		return true;
	}
	
	// if we put down the 8th queen, we win!
	private boolean success(int row)
	{		
		return feasible(row-1) && row == 8;
	}
	
	// backtrack returns true on solution, false on failure
	private boolean backtrack(int row)
	{
		int next;
		
		while((next == nextCandidate(row)) != -1){
			if (success(next)) {
				//	print a solution
				printBoard();
			}			
			else if (feasible(row)) {
				//	backtrack to find next solution
				backtrack(next);
			}
		}
		// reset this row
			board[row] = 0;
			
			// not a solution
			// need to keep looking for a solution
			return false;
	}
	
	// print the solution
	private void printBoard()
	{
		for (int i=0; i<8; i++){
			System.out.printf("(%d, %d) ", i+1, board[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		EightQueens q = new EightQueens();
		
		q.backtrack(0);
		System.out.printf("I search %d candidates\n", q.counter); //17685 < 4.4 million brute force
	}
}
//GVIM
//!javac ?.java
//!java	?
//(1,1) (2,5) (3,8) (4,6) (5,3) (6,7) (7,2) (8,4)
//92 possible solutions in total