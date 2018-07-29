package Exercise18_15;

public class RecursiveEightQueens 
{
	private static int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
		 												   };
	private static int currentRow = 0;
	private static int currentColumn = 0;
	private static int placedQueens = 0;
	
	// method to test if a queen can be placed at a cell location 
	public static boolean testCell(int row, int column, int[][] board)
	{
		
		if(board[row][column] == 1)
			return false;
			
			// test row
			for (int c = 0; c < board[row].length; c++)
				if (board[row][c] == 1)
					return false;
			// test column
			for (int r = 0; r < board.length; r ++)
				if(board[r][column] == 1)
					return false;
			
			// test diagonal
			for(int r = 0; r < board.length; r++)
			{	
				try
				{
				if (board[row + r][column + r] == 1)
					return false;
				}
				catch(IndexOutOfBoundsException indexOutOfBounds)
				{
					
				}
				try
				{
				if (board[row - r][column - r] == 1)
					return false;
				}
				catch(IndexOutOfBoundsException indexOutOfBounds)
				{
					
				}
			}
			
			// test counter diagonal
			for(int r = 0; r < board.length; r++)
			{	try
				{
				if (board[row - r][column + r] == 1)
					return false;
				}
				catch(IndexOutOfBoundsException indexOutOfBounds)
				{
					
				}
				try
				{
					if (board[row + r][column - r] == 1)
					return false;
				}
				catch(IndexOutOfBoundsException indexOutOfBounds)
				{
					
				}
			}
	
						
		return true;
	}
	
	// method to print board 
	public static void printGrid(int[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			System.out.printf("[%2d]  ",board[row][column]);
			System.out.println();
			System.out.println();
		}// end for
	} // end printGrid method
	
	//recursive method - eigthQueens
	public static void eightQueens(int[][]board)
	{
		while (placedQueens < 8) // run while there are more queens to be placed
		{
			
			//test if queen can be placed at current cell
			if (testCell(currentRow, currentColumn, board) == true) // if yes
			{
				//printGrid(board);
				//System.out.println(placedQueens + "\n");
								
				board[currentRow][currentColumn] = 1; // occupy cell 
				placedQueens ++; // increase counter
			
				//printGrid(board);
				//System.out.println(placedQueens + "\n");
		
									 
				currentColumn ++; // increase column
				currentRow = 0; // reset row 
				
				eightQueens(board); // execute next step
			}
			else 
			{ // if not try to increase row count or go back one step and delete placed queen and move placed queen to another place
				if (currentRow < 7)
				{
					currentRow ++; // increase row count
					eightQueens(board); // execute next step
				}
				else
				{
					backtrack(currentColumn, board); // backtrack and move last queen
				}
				
			}
		}
	}
	
	// method to backtrack board moves and delete last move
	public static void backtrack(int column, int[][] board)
	{
		for (int r = 0; r < board.length; r ++)
			if(board[r][currentColumn - 1] == 1)
			{
				currentRow = r; // reset to previous queen position
				currentColumn -=1 ;
				
				board[currentRow][currentColumn] = 0; // remove queen
				placedQueens -- ; // decrease counter
				
			//	printGrid(board);
			//	System.out.println(placedQueens + "\n");
				
				// if current row is 7, the current column has been exhausted and board should be backtracked again
				if(currentRow == 7)
					backtrack(currentColumn, board);
								
				// increase current row so test can begin again from new position
				currentRow ++;
				
				eightQueens(board); // execute next step
			}
	}
	
	
	public static void main (String[] args)
	{
		eightQueens(board);
		//board[7][4] = 1;
		printGrid(board);
		System.out.println("Placed queens: " + placedQueens);
	}

}
