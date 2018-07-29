package exercise8_17_AdvancedGraphicsAtempt;

public class TicTacToe
{

	public enum boardCell
	{
		X,
		O,
		EMPTY;
	}

	public final int boardLength = 3;
	private boardCell [][] board = new boardCell[boardLength][boardLength];
	private int gameMove;
	private int gameRound;

	private final int player1 = 0; // named variable to denote a move by player1
	private final int player2 = 1; // named variable to denote a move by player2

	TicTacToe()
	{
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				board[row][column] = boardCell.EMPTY;
		gameMove = 0;
		gameRound = 1;
	}


	// accesor methods
	// accesor method to recover the state of a cell with row and column provided as arguments
	public boardCell getCell(int row, int column)
	{
		return board[row][column];
	}

	// accesor method to determine if all cells are occupied
	public boolean boardFull()
	{
		boolean boardFull = true;

		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				if (board[row][column] == boardCell.EMPTY)
					boardFull = false;

		return boardFull;
	}

	// accesor method to determine if X`s have won
	public boolean winX()
	{
		boolean winX = false;
		boolean testEnd = false;

		while (!winX && !testEnd)
		{
			// test diagonal
			for ( int row = 0; row < board.length; row ++)
				if(board[row][row] != boardCell.O && board[row][row] != boardCell.EMPTY)
					winX = true;
				else
					{
					winX = false;
					break;
					}

			if (winX)
				break;

			// test cross - diagonal
			for ( int row = 0; row < board.length; row ++)
				if(board[row][board.length - row - 1] != boardCell.O &&
					board[row][board.length - row - 1] != boardCell.EMPTY)
				winX = true;
				else
				{
					winX = false;
					break;
				}

			if (winX)
				break;

			// test columns
			for (int row = 0; row < board.length; row ++)
			{
				winX = true;
				for (int column = 0; column < board[row].length; column ++)
				{
					if(board[row][column] == boardCell.O ||
							board[row][column] == boardCell.EMPTY)
					{
						winX = false;
						break;
					}
				}

				if (winX == true)
					break;
			}

			if (winX == true)
				break;

			// test rows
			for (int column = 0; column < board.length; column ++)
			{
				winX = true;
				for (int row = 0; row < board.length; row ++)
				{
					if(board[row][column] == boardCell.O ||
						board[row][column] == boardCell.EMPTY)
					{
						winX = false;
						continue;
					}
				}

				if (winX == true)
					break;
			}

			if (winX == true)
				break;

			testEnd = true;
		}
		return winX;
	}

	// accesor method to determine if O`s have won
	public boolean winO()

	{
		boolean winO = false;
		boolean testEnd = false;

		while (!winO && !testEnd)
		{
			// test diagonal
			for ( int row = 0; row < board.length; row ++)
				if(board[row][row] != boardCell.X && board[row][row] != boardCell.EMPTY)
					winO = true;
				else
					{
					winO = false;
					break;
					}

			if (winO)
				break;

			// test cross - diagonal
			for ( int row = 0; row < board.length; row ++)
				if(board[row][board.length - row - 1] != boardCell.X &&
					board[row][board.length - row - 1] != boardCell.EMPTY)
				winO = true;
				else
				{
					winO = false;
					break;
				}

			if (winO)
				break;

			// test columns
			for (int row = 0; row < board.length; row ++)
			{
				winO = true;
				for (int column = 0; column < board[row].length; column ++)
				{
					if(board[row][column] == boardCell.X ||
							board[row][column] == boardCell.EMPTY)
					{
						winO = false;
						break;
					}
				}

				if (winO == true)
					break;
			}

			if (winO == true)
				break;

			// test rows
			for (int column = 0; column < board.length; column ++)
			{
				winO = true;
				for (int row = 0; row < board.length; row ++)
				{
					if(board[row][column] == boardCell.X ||
						board[row][column] == boardCell.EMPTY)
					{
						winO = false;
						continue;
					}
				}

				if (winO == true)
					break;
			}

			if (winO == true)
				break;

			testEnd = true;
		}
		return winO;
	}

	// accesor method to return current game move
	public int getMoves()
	{
		return gameMove;
	}

	// accesor method to return current game round
	public int getRound()
	{
		return gameRound;
	}

	// mutator methods
	// mutator method to occupy a boardCell - row column and player provided as argument
	public void occupyCell(int row, int column, int player)
	{
		if (row > board.length - 1 || row < 0)
			throw new IllegalArgumentException("Row value is invalid.");
		if (column > board[board.length-1].length || column < 0)
			throw new IllegalArgumentException("Column value is invalid.");

		if (board[row][column] == boardCell.X || board[row][column] == boardCell.O)
			throw new IllegalArgumentException("Cell already occupied.");


		if (player == player1)
			board[row][column] = boardCell.X;
		if (player == player2)
			board[row][column] = boardCell.O;


		if(++gameMove % 2 == 1)
			gameRound++;
	}

	// mutator method to assign this object the characteristics of another TicTacToe object provided as arguments
	// assigns the progression of another game to this one
	public void setBoard(TicTacToe game)
	{
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				this.board[row][column] = game.board[row][column];

		this.gameMove = game.getMoves();
		this.gameRound = game.getRound();
	}


	// method to simulate a computer player
	public void AIMove()
	{
		int[][] preferredMoves = {
				{1,1}, {0,0}, {0,2}, {2,0}, {2,2}, {0,1}, {1,0}, {1,2}, {2,1}};

		boolean moveMade = false;

		while (!moveMade)
		{
			// first move
			if (gameMove < 3)
				for (int move = 0; move < preferredMoves.length; move ++)
					if (getCell(preferredMoves[move][0], preferredMoves[move][1]) == boardCell.EMPTY)
					{
						occupyCell(preferredMoves[move][0], preferredMoves[move][1], player2);
						moveMade = true;
						break;
					}

			if (moveMade)
				break;

			// determine if game can be won with this move and do so if yes
			for (int row = 0; row < board.length; row ++)
			{
				for (int column = 0; column < board[row].length; column++)
				{
					if (board[row][column] == boardCell.EMPTY)
					{
						board[row][column] = boardCell.O;
						if (winO())
						{
							board[row][column] = boardCell.EMPTY;
							occupyCell(row, column, player2);
							moveMade = true;
							break;
						}
						else
							board[row][column] = boardCell.EMPTY;
					}

				}

				if (winO())
					break;
			}
			if (moveMade)
				break;

			// determine if opponent can win with next move and block it
			for (int row = 0; row < board.length; row ++)
			{
				boolean stop = false;
				for (int column = 0; column < board[row].length; column++)
				{

					if (board[row][column] == boardCell.EMPTY)
					{
						board[row][column] = boardCell.X;
						if (winX())
						{
							stop = true;
							board[row][column] = boardCell.EMPTY;
							occupyCell(row, column, player2);
							moveMade = true;
							break;
						}
						else
							board[row][column] = boardCell.EMPTY;
					}
				}
				if (stop)
					break;
			}

			if (moveMade)
				break;


			// second move and onwards - determine a heuristic table of moves and choose the best one
			if (gameMove >= 3)
			{
				int [][] heuristicArray = {{3, 2, 3},
										   {2, 4, 2},
										   {3, 2, 3}};

				for (int row = 0; row < board.length; row ++)
					for (int column = 0; column < board[row].length; column++)
					{
						// downgrade affected cells
						if (board[row][column] == boardCell.X)
						{
							// this cell will is not available
							heuristicArray[row][column] = -100;

							// downgrade column
							for (int column2 = 0; column2 < board[row].length; column2 ++)
								if (column2!= column)
									heuristicArray[row][column2]--;

							// downgrade row
							for (int row2 = 0; row2 < board.length; row2 ++)
								if (row2 != row)
									heuristicArray[row2][column]--;

							// downgrade diagonals
							if(row == 0 && column == 0)
							{
								heuristicArray[1][1]--;
								heuristicArray[2][2]--;
							}

							if(row == 0 && column == 2)
							{
								heuristicArray[1][1]--;
								heuristicArray[2][0]--;
							}

							if(row == 2 && column == 0)
							{
								heuristicArray[1][1]--;
								heuristicArray[0][2]--;
							}

							if(row == 2 && column == 2)
							{
								heuristicArray[1][1]--;
								heuristicArray[0][0]--;
							}

						}

						//upgrade good cells
						if (board[row][column] == boardCell.O)
						{
							// this cell will is not available
							heuristicArray[row][column] = -100;

							// upgrade column
							for (int column2 = 0; column2 < board[row].length; column2 ++)
								if (column2!= column)
									heuristicArray[row][column2]++;

							// upgrade row
							for (int row2 = 0; row2 < board.length; row2 ++)
								if (row2 != row)
									heuristicArray[row2][column]++;

							// downgrade diagonals
							if(row == 0 && column == 0)
							{
								heuristicArray[1][1]++;
								heuristicArray[2][2]++;
							}

							if(row == 0 && column == 2)
							{
								heuristicArray[1][1]++;
								heuristicArray[2][0]++;
							}

							if(row == 2 && column == 0)
							{
								heuristicArray[1][1]++;
								heuristicArray[0][2]++;
							}

							if(row == 2 && column == 2)
							{
								heuristicArray[1][1]++;
								heuristicArray[0][0]++;
							}

						}

					}


			int bestIndex = -99;
			int[] bestMove = new int[2];

			// determine best move based on the heuristicArray result
			for (int row = 0; row < board.length; row ++)
				for (int column = 0; column < board[row].length; column++)
				{
					if (heuristicArray[row][column] > bestIndex)
					{
						bestIndex = heuristicArray[row][column];
						bestMove[0] = row;
						bestMove[1] = column;
					}

				}

			// make the best move
			occupyCell(bestMove[0], bestMove[1], player2);
			moveMade = true;
			}
		}

	}

	//toString
	public String toString()

	{
		String output = "";
		output += "Game Move: " + gameMove + "\n" + "Game Round: " + gameRound + "\n\n";
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			{
				if (board[row][column] == boardCell.EMPTY)
					output += " ";
				if (board[row][column] == boardCell.X)
					output += "X";
				if (board[row][column] == boardCell.O)
					output += "O";
				if(column != board[row].length - 1)
					output += "|";
			}

			output +="\n";

			if (row != board.length - 1)
			{
				for (int column = 0; column < board[row].length; column++)
				{
					output += "-";
					if(column != board[row].length -1)
						output += "+";
				}


				output +="\n";

			}

		}

		return output;

	}

	// toJPanel String
	public String toJPanelString()
	{
		String output = "";
		output += "Game Move: " + gameMove + "\n" + "Game Round: " + gameRound + "\n\n";

		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			{
				if (board[row][column] == boardCell.EMPTY)
					output += "|   ";
				if (board[row][column] == boardCell.X)
					output += "|X";
				if (board[row][column] == boardCell.O)
					output += "|O";

			}
			output += "|";
			output +="\n";

		}

		return output;
	}
}


