package Exercise19_07;

import java.security.SecureRandom;
import java.util.Arrays;

public class BucketSortTest 
{
	private static void bucketSort(int[] data)
	{
		int[][] bucketArray = new int[10][data.length - 1];
		for (int i = 0; i < bucketArray.length; i ++)
			Arrays.fill(bucketArray[i], -1);
		int position = 1;
		
		do
		{
			for (int i = 0; i < data.length; i ++)
			{ 
				int j = 0;
				while (bucketArray[(data[i] / position) % 10][j] != -1)
					j++;
				bucketArray[(data[i] / position) % 10][j] = data[i];
			}

			
			int index = 0;
			
			for (int i = 0; i < bucketArray.length; i ++)
				for(int j = 0; j < bucketArray[i].length; j ++)
					if(bucketArray[i][j] != -1)
						data[index++] = bucketArray[i][j];
			
			for (int i = 0; i < bucketArray.length; i ++)
				Arrays.fill(bucketArray[i], -1);
			
			printPass(data, position);
									
			position *= 10;
			
			
		} while (position <= 100);
	}
	
	private static void printPass(int[] data, int position)
	{
		System.out.printf("after position %3d: ", position);
		
		// output elements till selected item
		for (int i = 0; i < data.length; i ++)
			System.out.printf("%3d  ", data[i]);
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[20];
		
		for (int i = 0; i < data.length; i ++)
			data[i] = generator.nextInt(900);
		
		System.out.printf("Unsorted array: %n%s%n%n", Arrays.toString(data));
		bucketSort(data);
		
		System.out.printf("Sorted array: %n%n%s%n%n", Arrays.toString(data));
		
	}

}
