

public class EratosthenesSieve
{
	final static int arrayLength = 1000; // array length equates to upper limit of prime no. search
	static boolean[] isPrime = new boolean[arrayLength]; // prime number array

	public static void main(String[] args)
	{
		prepareArray(isPrime); // prepare the array  - assume all numbers are prime

		for (int index = 2; index < isPrime.length; index ++) // test all values after second index
		{
			if (isPrime[index] == true) // if index is true

				// for all multiples of that index assign false value
				for (int multiple = 2; multiple <isPrime.length/index + 2; multiple++)
					try
					{
						isPrime[index * multiple] = false;
					}

					catch (ArrayIndexOutOfBoundsException e)
					{

					}

		}


		// print array
		System.out.println(printArray(isPrime));

	}

	// method to assign TRUE to all values of an array
	static void prepareArray (boolean[] array)
	{
		for (int index = 0; index < array.length; index ++)
			array[index] = true;
	}

	// method to format and print an array with prime numbers
	static String printArray (boolean[] array)
	{
		int counter = 0;
		String output = "The prime numbers up to: " + arrayLength + " :\n";
		for (int index = 2; index < array.length; index ++)
			{
			if (array[index] == true)
				{
					output = output + String.format(" %3d ",index) ;
					counter ++;
					if (counter % 20 == 0)
						output = output + String.format("%n");
				}


			}

			output = output + String.format("%n");

		return output;
	}

}
