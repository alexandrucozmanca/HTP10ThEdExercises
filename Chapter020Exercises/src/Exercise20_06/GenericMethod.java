package Exercise20_06;
public class GenericMethod 
{
	public static void main(String[] args)
	{
		// create arrays of Integer, Double and Character
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
		String[] stringArray = {"one", "two", "three", "four", "five", "six", "seven", "eight"};
		
		System.out.printf("Array integerArray contains: %n");
		printArray(integerArray); // pass an Integer array
		System.out.printf("%nArray doubleArray contains: %n");
		printArray(doubleArray); // pass a double array
		System.out.printf("%nArray characterArray contains: %n");
		printArray(characterArray); // pass a character array
		System.out.printf("%nArray stringArray contains(overloaded with specific method): %n");
		printArray(stringArray); // pass a character array
	}
	
	// method printArray to print Integer array
	public static <T> void printArray(T[] array)
	{
		// display array elements
		for (T element : array)
			System.out.printf("%s ", element);
	}
	
	public static void printArray(String[] array)
	{
		for (int i = 0; i < array.length; i ++)
		{
			System.out.printf("%-7s", array[i]);
			if (i % 4 == 3)
				System.out.println();
		}
	}
		
}
