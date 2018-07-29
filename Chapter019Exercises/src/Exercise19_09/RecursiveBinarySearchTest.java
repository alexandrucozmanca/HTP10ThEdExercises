package Exercise19_09;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinarySearchTest 
{
	
	// preform a binary search on the data
	public static int recursiveBinarySearch(int[] data, int searchKey, int lowIndex, int highIndex)
	{
		int middle = (lowIndex + highIndex + 1) / 2;
		int location = -1;
		
		// if array has 1 element
		if(lowIndex == highIndex)
		{
			if (searchKey == data[lowIndex])
				location = lowIndex;
			
			return location;
		}
		
		// if the element is found at the middle
		if (searchKey == data[middle])
			location = middle; // location is the current middle
		else if(searchKey < data[middle]) // middle element is too high
			location = recursiveBinarySearch(data, searchKey, lowIndex, middle-1);
		else // middle element is too low
			location = recursiveBinarySearch(data, searchKey, middle, highIndex);
			
				
		return location; // return location of search key
	} // end method binarySearch

	
	// method to output certain values in array
	private static String remainingElements(int[] data, int low, int high)
	{
		StringBuilder temp = new StringBuilder();
		
		// append spaced for alignment
		for (int i = 0; i < low; i++)
			temp.append("    ");
		
		// append elements left in array
		for (int i = low ; i <= high; i ++)
			temp.append(data[i] + "  ");
		
		return String.format("%s%n", temp);
	}// end method remainingElements
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[15]; 
		
		for (int i = 0; i < data.length; i ++)
			data[i] = 10 + generator.nextInt(90);
		
		Arrays.sort(data); // sort array
		System.out.printf("%s%n%n", Arrays.toString(data));
		
		// get input from user
		System.out.printf("Please enter an integer value (-1 to quit)");
		int searchKey = input.nextInt();
		
		while(searchKey != -1)
		{
			
			int location = recursiveBinarySearch(data, searchKey, 0, data.length-1);
			
			if(location == -1)
				System.out.printf("%d was not found%n%n", searchKey);
			else
				System.out.printf("%d was found at position %d%n%n", searchKey, location);
			
			// get input from user
			System.out.print("Please enter an integer value (-1 to quit)");
			searchKey = input.nextInt();
		}
		
		
	}
}
