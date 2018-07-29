package Exercise18_14;

import java.util.regex.Pattern;

public class RecursivePalindrome 
{
	public static boolean isPalindrome(String tested)
	{
		
		if(tested.charAt(0) != tested.charAt(tested.length() - 1))
			return false;
		else
			if(tested.length() != 2)
				return isPalindrome(tested.substring(1, tested.length() - 1));
			else
				return true;
	}
	
	public static String parametrizeString(String tested)
	{
	
		tested = tested.toLowerCase();
		tested = tested.replaceAll("\\s+" , "");
		tested = tested.replaceAll("\\p{P}", "");
		
		if (tested.length() % 2 == 1)
			tested = tested.substring(0, tested.length() / 2).concat(tested.substring(tested.length() / 2  + 1));
		
		return tested;
	}

	public static void main(String[] args)
	{
		String tested = "0, . 12 ' [ ]	"
				+ " 321 0";
					
		
		
		
		System.out.println(tested);
				
		System.out.println(isPalindrome(parametrizeString(tested)));
	
		
	}
	

}
