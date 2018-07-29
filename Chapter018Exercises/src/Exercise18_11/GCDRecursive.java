package Exercise18_11;

import java.util.Random;

public class GCDRecursive 
{
	
	public static int GCD(int x, int y)
	{
		if (y == 0)
			return x;
		else
			return GCD(y, x % y);
	}

	public static void main (String[] args)
	{
		Random tester = new Random(); // random no. generator for tests
		
		//run for 10 iterations
		
		for (int i = 1; i <= 10; i++)
		{ 
			int firstNumber = tester.nextInt(5000);
			int secondNumber = tester.nextInt(5000);
			System.out.printf(" Greatest common divisor for %d and %d is %d.%n", 
					firstNumber , secondNumber, GCD(firstNumber,secondNumber));
		}
	}
}
