// application to create a square of a given side and of a given character
import java.util.Random; // for 'random' objects

public class ASquareOfThings 
{
	public static void main(String[] args)
	{
		Random tester = new Random(); // random no. generator for testing purposes
		
		// run test for 10 iterations
		for (int i = 1; i <= 10; i++)
		{
			characterSquare(1 + tester.nextInt(9), (char)(33 + tester.nextInt(94)));
			System.out.println();
		}
		
		
		
	}
	
	private static void characterSquare(int side, char character)
	{
		for (int i = 1; i <= side; i++)
		{
			for (int j = 1; j <= side; j++)
				System.out.printf("%s",character);
			System.out.println();
		}
		
	}
	
}
