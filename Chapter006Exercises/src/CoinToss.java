// application to simulate the tossing of a coin based on user input
import java.util.Random; // needed for 'random' object
import java.util.Scanner; // needed for 'scanner' object


public class CoinToss 
{
	enum coinFace {HEADS, TAILS};
	static coinFace testerCoin;

	
	public static void main(String[] args)
	{
		int numberOfHeads = 0, numberOfTails = 0; // local variable to count each result
		
		// display user info and prompt for input
		System.out.printf("Would you like to toss a coin?%n"
				+ "1. Toss coin.%n"
				+ "2. No thank you.");
		
		Scanner input = new Scanner(System.in); // scanner object for user input
		int answer = input.nextInt(); // user answer		
		
		while (answer == 1)
		{
			flip();
			System.out.printf("%nCoin landed on %s.%n",testerCoin);
			if (testerCoin == coinFace.HEADS) numberOfHeads ++;
			else numberOfTails ++;
			System.out.printf("So far the coin landed on HEADS %d times and on TAILS %d times.",
					numberOfHeads, numberOfTails);
			
			// re-query user for input
			System.out.printf("%n%nWould you like to toss a coin?%n"
					+ "1. Toss coin.%n"
					+ "2. No thank you.");
						
			answer = input.nextInt(); // user answer	
		}
	
		System.out.println("Good bye.");
	}
	
	
	private static void flip()
	{
		Random toss = new Random(); // random object to simulate coin tosses;
		if (toss.nextInt(100) <= 49) 
		{
			testerCoin = coinFace.HEADS;
		}
		else 
		{
			testerCoin = coinFace.TAILS;
		}
				
	}
	
	
}
