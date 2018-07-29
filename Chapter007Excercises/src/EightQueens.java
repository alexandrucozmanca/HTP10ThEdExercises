
public class EightQueens 
{
	static int[][] heuristicBoard = {{22, 22, 22, 22, 22, 22, 22, 22},
									 {22, 24, 24, 24, 24, 24, 24, 22},
									 {22, 24, 26, 26, 26, 26, 24, 22},
									 {22, 24, 26, 28, 28, 26, 24, 22},
									 {22, 24, 26, 28, 28, 26, 24, 22},
									 {22, 24, 26, 26, 26, 26, 24, 22},
									 {22, 24, 24, 24, 24, 24, 24, 22},
									 {22, 22, 22, 22, 22, 22, 22, 22},
															 		 };
	static int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0},
									 		 };

	public static void main(String[] args)
	{
		int bestMove = 22; // initial best move criteria
		int placedQueens = 0; // initial count of placed queens
		
		// run until 8 queens placed or no more suitable cells exist
		while (placedQueens < 8 && testGrid(board))
		{
			for (int row = 0; row < board.length; row++)
				for (int column = 0; column < board[row].length; column++)
				{
					// place queen on suitable cell
					if (board[row][column] == 0)
					{
						occupyCells(row, column, board);
						System.out.printf("Queen placed at %d %d.%n",row,column);
						placedQueens++;
						
						System.out.println();
						printGrid(board);
						System.out.println();
						
					} 
					
					// if board fully traversed increase allowed best move criteria
					if (row == 7 && column == 7)
						{
						bestMove += 2;
						System.out.printf("Best move increased to %d.%n",bestMove);
						}
				}// end for
		} // end while
		
		System.out.printf("Run ended after %d queens placed and best move criteria is: %d.%n",
				placedQueens, bestMove);
		
		normaliseGrid(board);
		
		printGrid(board);
		

	}
	
	
	//method to "occupy" cells - i.e to denote which cells can not be occupied by other 
	//queens because of previously placed queens
	public static void occupyCells(int x, int y, int[][] board)
	{
		board[x][y] = 1;
		
		// occupy same column
		for (int row = 0; row < board.length; row ++)
			if (row != x) 
				board[row][y] = 99;
		
		// occupy same row
		for (int column = 0; column < board[x].length; column ++)
			if (column != y) 
				board[x][column] = 99;
		
		// occupy normal diagonal
		for (int offset = -7; offset < 8; offset++)
			if (offset !=0)
			{
				try
				{
					board[x + offset][y + offset] = 99;
				}
		
				catch (ArrayIndexOutOfBoundsException e)
				{
					
				}// end catch
			}
		
		// occupy transverse diagonal
		for (int offset = -7; offset < 8; offset++)
			if (offset !=0)
			{
				try
				{
					board[x + offset][y - offset] = 99;
				}
		
				catch (ArrayIndexOutOfBoundsException e)
				{
					
				}// end catch
			}
	
	}// end occupyCells method
	
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
	
	public static void normaliseGrid(int[][] board)
	{
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				if (board[row][column] != 1) 
					board[row][column] = 0;
	} // end printGrid method
	
	public static boolean testGrid(int[][] board)
	{
		boolean movePosible = false;
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				if (board[row][column] == 0) 
					movePosible = true;
		return movePosible;
	} // end testGrid method
	 
}
