package Exercise19_10;

import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSortTest 
{
	public static void quickSort(int[] data, int lowIndex, int highIndex)
	{
		boolean sorted = false;
		while(!sorted || !(lowIndex == highIndex))
		{	
			sorted = true;
					
			int startIndex = lowIndex;
			int endIndex = highIndex;
			
			int testValue = data[lowIndex];
			boolean foundPosition = false;
			
			int run = 0;
			
			while (!foundPosition || !(startIndex == endIndex))
			{
				System.out.println(run);
				foundPosition = true;
				for (int i = endIndex; i > startIndex; i --)
					if(data[i] < testValue)
					{
						int temp = data[i];
						data[i] = data[startIndex];
						data[startIndex] = temp;
						
						endIndex = i;
						startIndex ++;
						
						System.out.println("High sort");
						printPass(data);
						foundPosition = false;
						sorted = false;
						break;
					}
				
				for(int i = startIndex; i < endIndex; i ++)
					if(data[i] > testValue)
					{
						int temp = data[i];
						data[i] = data[endIndex];
						data[endIndex] = temp;
						
						startIndex = i;
						
						System.out.println("Low sort");
						printPass(data);
						foundPosition = false;
						sorted = false;
						break;
					}
				run++;
			}
	
			System.out.println("New recursion");
			System.out.println("Upper half");
			quickSort(data, startIndex + 1, highIndex);
			System.out.println("Lower half");
			quickSort(data, lowIndex, startIndex - 1);
						
		}
		
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
		
		int[] data = new int[10];
		
		for (int i = 0; i < data.length; i ++)
			data[i] = 10 + generator.nextInt(90);
		
		System.out.printf("Unsorted array: %n%s%n%n", Arrays.toString(data));
		quickSort(data, 0, data.length - 1);
		
		System.out.printf("Sorted array: %n%s%n%n", Arrays.toString(data));
		
	}

}
