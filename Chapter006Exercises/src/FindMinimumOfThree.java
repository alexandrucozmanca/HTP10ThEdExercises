// find the minimum of three numbers

import java.util.Random;// for 'random' objects

public class FindMinimumOfThree 
{
	public static void main(String[] args) 
	{
	 Random tester = new Random(); // random no. generator for testing 
		
	// run for 10 iterations
	 
	 for (int i = 1; i <= 10; i++)
	 {
		int number1 = tester.nextInt(500);
		int number2 = tester.nextInt(500);
		int number3 = tester.nextInt(500);
		
		System.out.printf("Of %d %d and %d the smallest is %d.%n",
				number1, number2, number3, Math.min(number1, Math.min(number2, number3)));
			 
	 }
		
	}
	
	
}
