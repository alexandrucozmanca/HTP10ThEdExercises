import java.util.Random;

public class DiceRollDistribution {

	public static void main(String[] args)
	{
		int [] dieDistribution = new int[11];

		for (int i = 0; i < 36000000; i ++)
		{
			dieDistribution[(rollDice() - 2)] ++;
		}

		for (int i = 0; i < dieDistribution.length; i++)
		{
			System.out.printf("Sum %d appeared %d times.%n", i+2, dieDistribution[i]);
		}

	}

	static int rollDice()
	{
		Random die = new Random();
		int sum = die.nextInt(6) + die.nextInt(6) + 2;
		return sum;
	}

}
