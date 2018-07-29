package exercise8_17_AdvancedGraphicsAtempt;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeVsAI
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

		if (turn == 0)
			System.out.println("Player1 goes first.");
		else
			System.out.println("Player2 goes first.");



		while (gameOn)
		{
			if (turn%2 == 0)
			{
				try
				{
					playerMove();
					turn++;
					System.out.println(game);
				}

				catch (IllegalArgumentException e)
				{
					System.out.println(e.getLocalizedMessage());
					continue;
				}


			}

			else
			{
				System.out.println("Player2`s turn.");
				game.AIMove();
				turn++;
				System.out.println(game);
			}

			if(game.boardFull())
			{
				System.out.println("Sorry the game ended in a draw, try again!");
				gameOn = false;
			}
			if(game.winX())
			{
				System.out.println("Congrats Player1 has won");
				gameOn = false;
			}
			if(game.winO())
			{
				System.out.println("Congrats Player2 has won");
				gameOn = false;
			}

		}

	}

	static void playerMove()
	{
		System.out.println("Player" + (turn%2+1) +" please specify the cell you would like to occupy: 1->3 1->3");

		String pattern = "\\d \\d";
		String input = keyboard.nextLine();

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
