// code to simulate a game of Craps

import java.util.Random;

public class CrapsDistribution
{
	private static enum Status {CONTINUE, WON, LOST}; // enum type with constraints regarding the game

	public static void main(String[] args)
	{
		int[] gamesWon = new int[20]; // won games distribution
		int[] gamesLost = new int[20]; // lost games distribution
		Status gameStatus = Status.CONTINUE;
		int dieSum = 0; // variable for sum of dice
		int point = 0; // variable for "point"

		// run 1000 games
		int games = 100000;
		int gameHand;

		for (int i = 1; i <= games; i ++)
		{
			gameStatus = Status.CONTINUE; // reset game
			gameHand = 0; // reset counter;
			dieSum = rollDice(); // first roll
			if (dieSum == 7 || dieSum == 11)
				{
				gameStatus = Status.WON; // for 7 or 11 on the first roll - WIN
				gamesWon[gameHand]++; // mark when the game was WON
				}
			else
				if (dieSum == 2 || dieSum == 3 || dieSum == 12)
					{
					gameStatus = Status.LOST;  // for 2, 3 or 12 on first roll - LOSE
					gamesLost[gameHand]++; // mark when game was lost
					}
				else // if first roll did not throw WIN or LOSE events assign "point" - which roll to look out for
				{
					point = dieSum;

					while (gameStatus == Status.CONTINUE)
					{
						gameHand++;	// increment game hands dealt
						dieSum = rollDice(); // subsequent rolls

						// check for LOSE condition for rolling 7 before "making point" (rolling twice same neutral roll)
						if (dieSum == 7)
						{
							gameStatus = Status.LOST;  // set game to LOSE
							if (gameHand > 18)
								gamesLost[19] ++;
							else
								gamesLost[gameHand] ++; // mark when game was lost
							break; //stop rolls
						}

						else
							//	check for WIN condition for rolling twice a neutral roll
							if (dieSum == point)
							{
								gameStatus = Status.WON; // set game to Win
								if (gameHand > 18)
									gamesWon[19] ++;
								else
									gamesWon[gameHand] ++;
								break; // stop rolls
							}

					}// end while

				}// end else
		
		}//end for

		//print distribution for WON games
		for(int i = 0;  i< gamesWon.length;i ++)
			System.out.printf(" Games won on hand %2d: %5d.%n", i+1, gamesWon[i]);

		System.out.println();

		//print distribution for LOST games
		for(int i = 0;  i< gamesLost.length;i ++)
			System.out.printf(" Games lost on hand %2d: %5d.%n", i+1, gamesLost[i]);

		System.out.println();
		//print chance of winning
		int wins = 0; // variable for no. of WON games
		for (int win: gamesWon)
			wins += win;
		System.out.printf("The chance to win a game was: %.2f%s.%n",(double)wins * 100 / games,"%");

		//print chance of losses
		int looses = 0; // variable for no. of LOST games
		for (int lost: gamesLost)
			looses += lost;
		System.out.printf("The chance to loose a game was: %.2f%s.%n",(double)looses * 100 / games,"%");

		
		// compute length of games
		int gameLenghts = 0;
		for (int i= 0 ; i < gamesWon.length; i ++)
		gameLenghts += gamesWon[i] * i + gamesLost[i] * i;
		System.out.printf("Average lenght of a game was: %.2f hands. long %n",(double)gameLenghts / games);
		
	} // end of main method 

	//simulate 2 die rolls and return sum
   private  static	int rollDice()
	 {
		int sum = 0, die1 = 0, die2 = 0; // sum variable
		Random randomDie = new Random(); // Random object for random generation

		die1 = 1 + randomDie.nextInt(6); // simulate first die
		die2 = 1 + randomDie.nextInt(6); // simulate second die

		sum = die1 + die2; // compute sum

		//System.out.printf("Die 1:   %d  Die 2:   %d  Sum:   %d%n",die1,die2,sum);

		return sum;
	 } // end method Roll

}// end class Craps