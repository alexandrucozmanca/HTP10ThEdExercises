package Exercise014_004;

import java.util.Scanner;

public class StringPartialComparison 
{
	public static void main(String[] args)
	{
		String string1, string2;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please input first string:");
		string1 = keyboard.next();
		
		System.out.println("Please input second string:");
		string2 = keyboard.next();
		
		int characters, index;
		
		System.out.println("Please input how many characters should be matched:");
		characters = keyboard.nextInt();
		
		System.out.println("Please input index from where characters should be matched");
		index = keyboard.nextInt();
		
		try
		{
			if(string1.regionMatches(true, index, string2, index, characters))
				System.out.printf("First %d characters from index %d of first and second string match with case ignored", characters, index);
			else
				System.out.printf("First %d characters from index %d of first and second string do not match with case ignored", characters, index);
		}
		
		catch (StringIndexOutOfBoundsException e)
		{
			System.out.println("Unable to match characters from that index.");
		}
		
		int comparison = string1.compareTo(string2);
		
		if(comparison == 0)
			System.out.println("The two strings match");
		
		if(comparison > 0)
			System.out.println("The first string is greater");
		
		if(comparison < 0)
			System.out.println("The second string is greater");
		keyboard.close();
	}
}
