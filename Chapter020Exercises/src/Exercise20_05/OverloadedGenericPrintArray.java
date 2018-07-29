package Exercise20_05;
public class OverloadedGenericPrintArray
{
	public static void main(String[] args)
	{
		// create arrays of Integer, Double and Character
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
		
		System.out.printf("Array integerArray contains: %n");
		printArray(integerArray); // pass an Integer array
		System.out.printf("%nArray integerArray between index 1 and 3 contains: %n");
		printArray(integerArray, 1, 4); // pass an Integer array
		
		System.out.printf("%nArray doubleArray contains: %n");
		printArray(doubleArray); // pass a double array
		System.out.printf("%nArray doubleArray between index 0 and 3 contains: %n");
		printArray(doubleArray, 0 , 4); // pass a double array
		
		System.out.printf("%nArray characterArray contains: %n");
		printArray(characterArray); // pass a character array
		System.out.printf("%nArray characterArray between index -1 and 3 contains: (intentional Invalid Subscript to throw error) %n");
		try
		{
			printArray(characterArray, -1, 3); // pass a character array
		}
		catch(InvalidSubscriptException invalidSubscriptException)
		{
			System.err.println(invalidSubscriptException);
		}
	}
	
	// method printArray to print Integer array
	public static <T> void printArray(T[] array)
	{
		// display array elements
		for (T element : array)
			System.out.printf("%s ", element);
	}
	
	public static <T> void printArray(T[] array, int lowSubscript, int highSubscript)
	{
		if(lowSubscript< 0 || highSubscript > array.length - 1)
			throw new InvalidSubscriptException("Invalid subscript");
		
		else
		for (int element = lowSubscript; element < highSubscript; element++)
			System.out.printf("%s ", array[element]);
	}
		
}
