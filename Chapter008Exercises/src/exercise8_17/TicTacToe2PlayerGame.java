package exercise8_17;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe2PlayerGame
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

		if (turn == 0)
			System.out.println("Player1 goes first.");
		else
			System.out.println("Player2 goes first.");

		// for user input
		Scanner keyboard = new Scanner(System.in);

		while (gameOn)
		{
			System.out.println("Player" + (turn%2+1) +" please specify the cell you would like to occupy: 1->3 1->3");

			String pattern = "\\d \\d";
			String input = keyboard.nextLine();

			if (!input.matches(pattern))
				{
				System.out.println("Incorect input, try Again!");
				continue;
				}

			else
			{
				try
				{
					game.occupyCell(Integer.parseInt(""+ input.charAt(0)) - 1, Integer.parseInt(""+ input.charAt(2)) - 1, turn%2);
					turn ++;
					System.out.println(game);
				}

				catch (IllegalArgumentException e)
				{
					System.out.println(e.getLocalizedMessage() + "\nTry Again!");
				}
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



		keyboard.close();

	}

}
