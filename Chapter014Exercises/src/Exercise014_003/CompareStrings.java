package Exercise014_003;

import java.util.Scanner;

public class CompareStrings 
{
	
	public static void main (String[] args)
	{
		String string1, string2;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please input first string:");
		string1 = keyboard.next();
		
		System.out.println("Please input second string:");
		string2 = keyboard.next();
		
		keyboard.close();
		int comparison = string1.compareTo(string2);
		
		if(comparison == 0)
			System.out.println("The two strings match");
		
		if(comparison > 0)
			System.out.println("The first string is greater");
		
		if(comparison < 0)
			System.out.println("The second string is greater");
	}

}
