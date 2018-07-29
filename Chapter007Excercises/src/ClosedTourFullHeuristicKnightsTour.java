
public class ClosedTourFullHeuristicKnightsTour
{
	// arrays that iterate all possible knight moves
	static int [] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
	static int [] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

	static int [][] board = new int[8][8]; // chess board array
	static int currentRow = 7, // initial position row
			currentColumn = 0, // initial position column
			bestMove, // best move that knight can make bases on accessibility algorithm
			bestAccesibility; // best cell the knight can choose for each
	static int moveRow, moveColumn; // intermediate row and column positions for the movement algorithm

	// heuristic availability board
	static int[][] heuristicBoard = {{2, 3, 4, 4, 4, 4, 3, 2},
								 	 {3, 4, 6, 6, 6, 6, 4, 3},
									 {4, 6, 8, 8, 8, 8, 6, 4},
									 {4, 6, 8, 8, 8, 8, 6, 4},
									 {4, 6, 8, 8, 8, 8, 6, 4},
									 {4, 6, 8, 8, 8, 8, 6, 4},
									 {3, 4, 6, 6, 6, 6, 4, 3},
									 {2, 3, 4, 4, 4, 4, 3, 2},
															};
	// default heuristic board for reset between runs
	static int[][] resetHeuristicBoard = {{2, 3, 4, 4, 4, 4, 3, 2},
										  {3, 4, 6, 6, 6, 6, 4, 3},
										  {4, 6, 8, 8, 8, 8, 6, 4},
										  {4, 6, 8, 8, 8, 8, 6, 4},
										  {4, 6, 8, 8, 8, 8, 6, 4},
										  {4, 6, 8, 8, 8, 8, 6, 4},
										  {3, 4, 6, 6, 6, 6, 4, 3},
										  {2, 3, 4, 4, 4, 4, 3, 2},
																 };



	public static void main(String[] args)
	{
		for (int row = 0; row < board.length; row ++)
			for (int column = 0; column < board.length; column ++)
			{

				resetBoard();
				resetHeuristic();
				currentRow = row;
				currentColumn = column;
				board[currentRow][currentColumn] = -1; // set first cell to occupied

				System.out.printf("Knight leaves from [%d] [%d].%n", currentRow, currentColumn);

				int moves = 0, move; //Initialize and reset local variables
				boolean movePosible = true; // prime while

				// run until full circuit
				while (moves < 65 && movePosible)
				{
					// run until a new move is not possible
					while (movePosible)
					{
						move = 0; // rest variable between runs
						movePosible = false; // Assume a new move is impossible
						bestAccesibility = 8; //assume the best accessibility value is the worst on the board

						for (;move < 8; move++ ) // explore the 8 possible knight moves
						{
							// set and reset intermediate movement positions
							moveRow = currentRow;
							moveColumn = currentColumn;

							moveNumber(move); // make a move

							// test if move is valid and does not land on a previously visited cell
							if(moveRow <= 7 && moveRow >= 0 &&
									moveColumn <= 7 && moveColumn >= 0 &&
									board[moveRow][moveColumn] == 0)
							{

								movePosible = true; // once a valid move found validate while loop

								// test if current cell has a better availability value
								if(bestAccesibility >= heuristicBoard[moveRow][moveColumn])
								{
									// if yes record better movement
									bestAccesibility = heuristicBoard[moveRow][moveColumn];
									bestMove = move;
								} //end if

							} // end if

						}	// end for (move < 8)

						// if valid jump
						if(movePosible)
						{
							// reset intermediate movement coordinates to starting cell
							moveRow = currentRow;
							moveColumn = currentColumn;

							// compute coordinates of the best move
							moveNumber(bestMove);
							// increase total moves counter and occupy destination cell
							board[moveRow][moveColumn] = ++moves;

							// notify user of new move
							//System.out.printf("Knight to %d %d at move %d.%n",moveRow + 1, moveColumn + 1,moves);

							// record new position
							currentRow = moveRow;
							currentColumn = moveColumn;

							// modify availability values after movement
							// run the 8 possible moves from the new starting position
							for (int i = 0; i < 8; i ++)
							{
								// rest starting position
								moveRow = currentRow;
								moveColumn = currentColumn;

								// make the move
								moveNumber(i);

								// if valid move decrease by 1 the availability index
								if(moveRow <= 7 && moveRow >= 0 &&
										moveColumn <= 7 && moveColumn >= 0)
									heuristicBoard[moveRow][moveColumn] --;

							} // end for  ( i < 8)

						} // end if(movePosible)


					}// end while (movePosible)

				} //end while (moves < 64)


				// print tour results
				String temp = "";
				if(isClosedTour(row, column, currentRow, currentColumn))
					 temp = String.format("This run is a closed tour.%n");
				
				System.out.printf("Stoped after %d moves at [%d][%d].%n%s%n  ", moves, 
						currentRow, currentColumn,temp);
								
				
			} // end for

	} // end main


	// method to simulate the movement of the knight
	public static void moveNumber(int number)
	{
		moveRow += vertical[number];
		moveColumn += horizontal[number];
	}

	// method to print board after Knight tour
	public static void printGrid(int[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			System.out.printf("[%2d]  ",board[row][column]);
			System.out.println();
			System.out.println();
		}
	}

	public static void resetBoard()
	{
			for (int row = 0 ; row < board.length ; row++)
				for (int column = 0; column < board.length ; column ++)
					board [row][column] = 0;
	}

	// method to reset the Heuristic accessibility board
	public static void resetHeuristic()
	{
			for (int i = 0 ; i < resetHeuristicBoard.length ; i++)
			System.arraycopy(resetHeuristicBoard[i], 0 ,
							 heuristicBoard[i], 0, resetHeuristicBoard[0].length);
	}

	public static boolean isClosedTour(int initialRow, int initialColumn, int finalRow, int finalColumn )
	{
		boolean isClosedTour = false;
		for (int move = 0; move < 8; move ++)
			if (initialRow + vertical[move] == finalRow && 
			initialColumn + horizontal[move] == finalColumn)
				isClosedTour = true;
		
		return isClosedTour;
	}
	
}
