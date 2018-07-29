package Exercise18_18;

import java.util.Arrays;

public class MinimumValueArrayRecursive 
{
	@SuppressWarnings("unused")
	public static int minimumValue(int[] array)
	{
		if (array.length == 1)
			return array[0];
		else
		{
			int min = array[array.length - 1];
			
			for (int i = array.length - 2; i >= 0; i--)
				if (min > array[i])
				{
					int[] returnArray = Arrays.copyOf(array, i + 1);
					return minimumValue(returnArray);
				}
				
			int[] returnArray = new int[1];
			returnArray[0] = min;
			return minimumValue(returnArray);	
			
			
		}
				
	}
	
	public static void main (String[] args)
	{
		int[] tester = {4, 2, 3 ,5 , 9 , 7};
		
		System.out.println(minimumValue(tester));
	}

}
