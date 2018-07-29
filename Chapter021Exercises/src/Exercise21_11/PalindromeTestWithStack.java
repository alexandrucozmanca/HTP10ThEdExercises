package Exercise21_11;

import com.deitel.datastructures.StackInheritance;

public class PalindromeTestWithStack 
{
	
	public static void main (String[] args)
	{
		String test1 = "1234321";
		String test2 = "1 2 3 . 44,3.2.1";
		String test3 = "this is not a palindrome";
		String test4 = "this is a palindrome emordn.ilap,asisiht";
		
		System.out.printf("String \"%s\" %s a palindrome%n", test1, isPalindrome(test1) ? "is" : "is not");
		System.out.printf("String %s %s a palindrome%n", test2, isPalindrome(test2) ? "is" : "is not");
		System.out.printf("String %s %s a palindrome%n", test3, isPalindrome(test3) ? "is" : "is not");
		System.out.printf("String %s %s a palindrome%n", test4, isPalindrome(test4) ? "is" : "is not");
						
		
	}
	
	
	
	public static boolean isPalindrome(String tested)
	{
		// parametrize string - remove spaces, punctuation marks and convert to lower case
		tested = tested.toLowerCase().replaceAll("(?!'`)\\p{P}", "").replaceAll(" ", "");
		
		
		StackInheritance<Boolean> isPalindrome = new StackInheritance<>();
		while (tested.length() > 1)
		{
			//System.out.printf("Testing %c %c%n", tested.charAt(0), tested.charAt(tested.length() - 1));
			isPalindrome.push(tested.charAt(0) == tested.charAt(tested.length() - 1));
			tested = tested.substring(1, tested.length() - 1);
		}
		
		while(!isPalindrome.isEmpty())
			if(isPalindrome.pop() == false)
				return false;
		
		return true;
	}
	
}
