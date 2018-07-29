
public class KnightsTour
{
	static int [] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
	static int [] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

	static int [][] board = new int[8][8];
	static int currentRow = 0, currentColumn = 0;
	static int moveRow, moveColumn;



	public static void main(String[] args)
	{

		board[currentRow][currentColumn] = -1;

		int moves = 0, move = 0;

		boolean correctMove;
		boolean movePosible = true;

		while (moves <= 64 && movePosible == true)
		{
			correctMove = false;
			while (correctMove == false && movePosible == true)
			{
				move = 0;
				while (move < 8 && movePosible == true)
				{

					moveRow = currentRow;
					moveColumn = currentColumn;
					moveNumber(move);

					if(moveRow <= 7 && moveRow >= 0 &&
							moveColumn <= 7 && moveColumn >= 0 &&
						board[moveRow][moveColumn] == 0)
						{
							correctMove = true;
							board[moveRow][moveColumn] = ++moves;
							System.out.printf("Knight to %d %d at move %d.%n",moveRow + 1, moveColumn + 1,moves);
							currentRow = moveRow;
							currentColumn = moveColumn;

							break;
						} // end if

					else
						{
							move++;

							if(move > 7)
							{
								movePosible = false;
								break;
							}
						}
				}	// end while (move < 8)


			}// end while (!correctMove)
		} //end while (moves <= 64)

		System.out.printf("Stoped after %d moves.%n", moves);
		printGrid();
	}

	public static void moveNumber(int number)
	{
		moveRow += vertical[number];
		moveColumn += horizontal[number];
	}

	public static void printGrid()
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			System.out.printf("[%2d]  ",board[row][column]);
			System.out.println();
			System.out.println();
		}


	}


}
