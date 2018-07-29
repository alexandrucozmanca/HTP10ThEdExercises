package Exercise19_10;

import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSortTest2 
{
	public static void quickSort(int[] data, int lowIndex, int highIndex)
	{
		while (highIndex - lowIndex > 0)
		{
			//	System.out.printf("Recursion with low: %d and high: %d%n%n", lowIndex, highIndex);
			int sortedIndex = placeValue(data, lowIndex, highIndex);
			//System.out.printf("SortedIndex: %d%n", sortedIndex);
			
			//System.out.println("Right SubArray");
			quickSort(data, sortedIndex + 1, highIndex);
			
			//System.out.println("Left SubArray");
			quickSort(data, lowIndex, sortedIndex - 1);
			
			if(sortedIndex == lowIndex)
				break;
			
		}
		
					
	}
	
	
	public static int placeValue(int[] data, int startIndex, int endIndex)
	{
		
		boolean positionFound = false;
		int testValue = data[startIndex];
		int testIndex = startIndex;
		
		while (!positionFound)
		{
			positionFound = true;	
			
			for(int i = endIndex; i > testIndex; i --)
			{
				if (testValue > data[i])
				{
					int temp = data[testIndex];
					data[testIndex] = data[i];
					data[i] = temp;
					
					testIndex = i;
					positionFound = false;
					break;
				}
			}
			
			for (int i = startIndex + 1; i < testIndex; i ++)
			{
				if (testValue < data[i])
				{
					int temp = data[testIndex];
					data[testIndex] = data[i];
					data[i] = temp;
					
					testIndex = i;
					positionFound = false;
					break;
				}
			}
		
		//	printPass(data);
						
		}
		
		return testIndex;
	}
	
	
	private static void printPass(int[] data)
	{
		for (int i = 0; i < data.length; i ++)
			System.out.printf("%2d ", data[i]);
		System.out.println();
	}
	

	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[20];
		
		for (int i = 0; i < data.length; i ++)
			data[i] = 10 + generator.nextInt(90);
		
		System.out.printf("Unsorted array: %n%s%n%n", Arrays.toString(data));
		quickSort(data, 0, data.length - 1);
		
		System.out.printf("Sorted array: %n%s%n%n", Arrays.toString(data));
		
	}

}
