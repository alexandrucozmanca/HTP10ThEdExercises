package exercise8_17;

import java.util.Random;


import javax.swing.JOptionPane;

public class TicTacToe2PlayerGameGraphic
{

	public static void main(String[] args)
	{
		// instance variable consisting of a TicTacToe object
		TicTacToe game = new TicTacToe();
		// instance variable simulating the tossing of a coin
		int turn = 0; // instance variable for determining which players turn is new

		boolean gameOn = true; // instance variable to control game loop

		Random coin = new Random();
		// toss a coin to determine who starts
		if(coin.nextInt(1000) > 499)
			turn++;

		String display = "";


		if (turn == 0)
			display += "Player1 goes first.";
		else
			display += "Player2 goes first.";

		JOptionPane.showMessageDialog(null, display);

		// for user input

		while (gameOn)
		{

			String pattern = "\\d \\d";
			String input = JOptionPane.showInputDialog(
						"Player" + (turn%2+1) +" please specify the cell you would like to occupy: 1->3 1->3");

			if (input == null)
			{
				JOptionPane.showMessageDialog(null, "Good bye!");
				System.exit(1);
			}

			if (!input.matches(pattern))
				{
				JOptionPane.showMessageDialog(null, "Incorect input, try Again!");
				continue;
				}

			else
			{
				try
				{
					game.occupyCell(Integer.parseInt(""+ input.charAt(0)) - 1, Integer.parseInt(""+ input.charAt(2)) - 1, turn%2);
					turn ++;
					JOptionPane.showMessageDialog(null, game.toJPanelString());
				}

				catch (IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(null, "Try Again!");
				}
			}

			if(game.boardFull())
			{
				JOptionPane.showMessageDialog(null, "Sorry the game ended in a draw, try again!");
				gameOn = false;
			}
			if(game.winX())
			{
				JOptionPane.showMessageDialog(null, "Congrats Player1 has won");
				gameOn = false;
			}
			if(game.winO())
			{
				JOptionPane.showMessageDialog(null, "Congrats Player2 has won");
				gameOn = false;
			}

		}

	}

}
