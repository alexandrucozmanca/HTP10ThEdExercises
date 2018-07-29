/*
  application to:
  a) Calculate the integer part of the quotient when integer a is divided by integer b.
  b) Calculate the integer remainder when integer a is divided by integer b.
  c) Use the methods developed in parts (a) and (b) to write a method displayDigits that
	receives an integer between 1 and 99999 and displays it as a sequence of digits, separating
	each pair of digits by two spaces.
 */

import java.util.Random; // needed for Random objects

public class SeparatingDigits
{

	public static void main(String[] args)
	{
		Random tester = new Random(); // random no. generator for testing purposes

		// run for 5 iterations
		for (int i = 1; i <= 5; i++)
		{
			int firstNumber = 1 + tester.nextInt(99999);
			int secondNumber = 1 + tester.nextInt(10000);

			System.out.printf("%nRound %d%n",i);
			
			System.out.println("a.");
			System.out.printf("Integer part of no. %d divided by no. %d is: %d.%n",
					firstNumber, secondNumber,integerPart(firstNumber, secondNumber));
			
			System.out.println("b.");
			System.out.printf("Integer part of no. %d divided by no. %d is: %d.%n",
					firstNumber, secondNumber,remainderPart(firstNumber, secondNumber));
			
			System.out.println("c.");
			separateDigits(firstNumber);
			separateDigits(secondNumber);
			
			System.out.println("c **.");
			inverseSeparateDigits(firstNumber);
			inverseSeparateDigits(secondNumber);

		}

	}


	// method to compute the integer part of firstNumber divided by secondNumber
	private static int integerPart(int firstNumber, int secondNumber)
	{
		int integer = firstNumber / secondNumber; // compute integer part
		return integer;
	}

	// method to compute the remainder of firstNumber divided by secondNumber
	private static int remainderPart(int firstNumber, int secondNumber)
	{
		int remainder = firstNumber % secondNumber; // compute remainder
		return remainder;
	}

	// method to separate the digits of a number
	private static void separateDigits(int number)
	{
		String output = ""; // local variable to store output
		int processedNumber = number; // local variable that will be processed

		while (processedNumber != 0)
		{
			output = remainderPart(processedNumber, 10) + "  " + output;
			processedNumber = integerPart(processedNumber, 10);
		}

		System.out.printf("Number %d is separated in: %s%n", number, output); //print the digits
	}
	
	private static void inverseSeparateDigits(int number)
	{
		String output = ""; // local variable to store output
		int processedNumber = number; // local variable that will be processed

		while (processedNumber != 0)
		{
			output = output + "  " + remainderPart(processedNumber, 10);
			processedNumber = integerPart(processedNumber, 10);
		}

		System.out.printf("Number %d is separated in invers digits: %s%n", number, output); //print the digits

	}

}
