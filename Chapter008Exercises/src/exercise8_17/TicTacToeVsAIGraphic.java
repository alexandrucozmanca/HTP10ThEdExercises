package exercise8_17;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TicTacToeVsAIGraphic
{
	static TicTacToe game = new TicTacToe(); 	// instance variable consisting of a TicTacToe object
	static int turn = 0; 	// instance variable for determining which players turn is new

	static Scanner keyboard = new Scanner(System.in);	// for user input

	public static void main(String[] args)
	{

		boolean gameOn = true; // instance variable to control game loop

		// instance variable simulating the tossing of a coin
		Random coin = new Random();
		// toss a coin to determine who starts
		if(coin.nextInt(1000) > 499)
			turn++;

		String display = "A game of Tic Tac Toe!\n"
				+ "A coin will determine which player goes first! \n\n\n";

		if (turn == 0)
			display += "Player1 goes first.";
		else
			display += "Player2 goes first.";

		JOptionPane.showMessageDialog(null, display);

		while (gameOn)
		{
			if (turn%2 == 0)
			{

				try
				{
					playerMove();
					turn++;
				}

				catch (IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
					continue;
				}


			}

			else
			{
				game.AIMove();
				turn++;
			}

			if(game.boardFull())
			{
				JOptionPane.showMessageDialog(null,"Sorry the game ended in a draw, try again!");
				gameOn = false;
			}
			if(game.winX())
			{
				JOptionPane.showMessageDialog(null,"Congrats Player1 has won");
				gameOn = false;
			}
			if(game.winO())
			{
				JOptionPane.showMessageDialog(null,"Congrats Player2 has won");
				gameOn = false;
			}

		}

	}

	static void playerMove()
	{
		String pattern = "\\d \\d";
		String input =JOptionPane.showInputDialog(game.toJPanelString() +
				"\nPlayer" + (turn%2+1) +" please specify the cell you would like to occupy: 1->3 1->3");

		if (input == null)
		{
			JOptionPane.showMessageDialog(null, "Good bye!");
			System.exit(1);
		}

		if (!input.matches(pattern))
			throw new IllegalArgumentException("Incorect input, try Again!");

		else
		{
			try
			{
				game.occupyCell(Integer.parseInt(""+ input.charAt(0)) - 1, Integer.parseInt(""+ input.charAt(2)) - 1, turn%2);
			}

			catch (IllegalArgumentException e)
			{
				throw new IllegalArgumentException("Try Again!");
			}
		}
	}// end of playerMove class

}
