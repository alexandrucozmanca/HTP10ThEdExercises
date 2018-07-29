// application to determine the GreatestCommonDivisor
import java.util.Random; // needed for 'random' objects

public class GreatestCommonDivisor
{
	public static void main(String[] args)
	{
		Random tester = new Random(); // random no. generator for tests
		
		//run for 10 iterations
		
		for (int i = 1; i <= 10; i++)
		{ 
			int firstNumber = tester.nextInt(5000);
			int secondNumber = tester.nextInt(5000);
			System.out.printf(" Greatest common divisor for %d and %d is %d.%n", 
					firstNumber , secondNumber, computeGreatestCommonDivisor(firstNumber,secondNumber));
		}
	
	}
	
	// method for computing the Greatest common divisor of 2 integers
	private static int computeGreatestCommonDivisor(int firstNumber, int secondNumber)
	{
		int greatestCommonDivisor = 1, // assume no. are coprime
				quotient = 1, remainder = 1; // local variables

		// run Euclid`s algorithm
		while (secondNumber != 0)
		{
			quotient = firstNumber / secondNumber;
			remainder = firstNumber % secondNumber;
			firstNumber = secondNumber;
			secondNumber = remainder;
	
		}
		// if Euclid`s algorithm outputs a result > 1 update result
		if (secondNumber == 0) greatestCommonDivisor = firstNumber;
		return greatestCommonDivisor;
	}

}
