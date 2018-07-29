// determine if a number is prime
public class PrimeNumber {

	public static void main(String[] args)
	{

		for (int i = 1; i <= 10000; i++)
		{
			if (isPrime(i)) System.out.printf("Number %d is a prime no.%n", i);

		}


	}

	// method to check if a number is prime
	private static boolean isPrime (int number)
	{
		boolean isPrime = false; // initial local variable

		if (number > 1) // only run check if no. is greater that 1
		{
			isPrime = true;  // assume number is prime

			//check for divisor up to the sqrt of the number
			for (int i = 2 ; i <= Math.sqrt(number); i++)
				if (number % i == 0) isPrime = false; // if a divisor is found, the number is not prime
		}

		return isPrime;
	}

}
