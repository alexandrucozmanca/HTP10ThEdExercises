package Exercise18_16;

public class PrintArrayRecursive 
{
	public static String printArrayForward(int index, int[] array)
	{
		String output = "";
		
		if (index == array.length - 1)
			return output = output.concat(String.format("%d", array[index]));
		else 
			return output = output.concat(String.format("%d %s",array[index], printArrayForward(index + 1, array)));
	}
	
	public static String printArrayBackward(int index, int[] array)
	{
		String output = "";
		
		if (index == 0)
			return output = output.concat(String.format("%d", array[index]));
		else 
			return output = output.concat(String.format("%d %s", array[index], printArrayBackward(index - 1, array)));
	}
	
	
	public static void main(String[] args)
	{
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		
		System.out.println(printArrayForward(0, array));
		System.out.println(printArrayBackward(6, array));
	}
	
	
}
