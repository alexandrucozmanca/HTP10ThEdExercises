package Exercise18_20;

public class RecursiveMaze 
{
	private static char[][] board = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
									 {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
									 {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
									 {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
									 {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
									 {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
									 {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
									 {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
									 {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
									 {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
									 {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
									 {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};
			
	private static int currentRow = 2;
	private static int currentColumn = 0;
	private static boolean solved = false;
	
	// method to print board 
	public static void printGrid(char[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			System.out.printf(" %c  ",board[row][column]);
			System.out.println();
			System.out.println();
		}// end for
	} // end printGrid method

	// test cell if it can be occupied
	public static boolean testCell(int row, int column, char c)
	{
		if(row < 0 || row > 11)
			return false;
		
		if(column < 0 || column > 11)
			return false;
		
		if(board[row][column] == c)
			return true;
		
		return false;
	}
	
	// run maze
	public static void recursiveMaze(char[][] board)
	{	
		board[currentRow][currentColumn] = 'o'; // mark cell
		System.out.println();
		printGrid(board);
		
		if(currentRow == 4 && currentColumn == 11)
		{
			solved = true;
		}
	
		while(!solved)
		{
							
			// test up
			if(testCell(currentRow - 1, currentColumn, '.'))
			{
				currentRow --;
				recursiveMaze(board);
			}
			
			// test right
			else if(testCell(currentRow, currentColumn + 1, '.'))
			{
				currentColumn ++;
				recursiveMaze(board);
			}
						
			// test down
			else if(testCell(currentRow + 1, currentColumn, '.'))
			{
				currentRow ++;
				recursiveMaze(board);
			}
			// test left
			else if(testCell(currentRow, currentColumn - 1, '.'))
			{
				currentColumn --;
				recursiveMaze(board);
			}
			else if(currentRow == 4 && currentColumn == 11)
			{
				solved = true;
				break;
			}
			else	
				backtrack(board); // if no possible moves backtrack
			
							
		}
		
	}

	public static void backtrack(char[][] board)
	{
		board[currentRow][currentColumn] = 'X';
		
		System.out.println();
		printGrid(board);
		
		// test up
		if(testCell(currentRow - 1, currentColumn, 'o'))
		{
			currentRow --;
			recursiveMaze(board);
		}
	
		// test right
		else if(testCell(currentRow, currentColumn + 1, 'o'))
		{
			currentColumn ++;
			recursiveMaze(board);
		}
								
		// test down
		else if(testCell(currentRow + 1, currentColumn, 'o'))
		{
			currentRow ++;
			recursiveMaze(board);
		}
		// test left
		else if(testCell(currentRow, currentColumn - 1, 'o'))
		{
			currentColumn --;
			recursiveMaze(board);
		}
		else
		{
			System.out.println("Maze is unsolvable");
			solved = true;
		}

	}
	
	public static void main(String[] args)
	{
		printGrid(board);
		recursiveMaze(board);
		
	}

}
