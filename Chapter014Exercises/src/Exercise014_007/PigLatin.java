package Exercise014_007;

import java.util.Scanner;

public class PigLatin 
{
	public static void main (String[] args)
	{
		System.out.println("Please input sentece to code:");
		
		Scanner keyboard = new Scanner(System.in);
		String sentence = keyboard.nextLine();
		String[] sentenceArray = sentence.split(" ");
		
		for (int word = 0; word < sentenceArray.length; word++)
		{
			System.out.printf("%s ",printLatin(sentenceArray[word]));
		}
		
		keyboard.close();
		
	}

	static String printLatin(String string)
	{
		if (string.length() > 1)
			return String.format("%s%c%s", string.substring(1), Character.toLowerCase(string.charAt(0)), "ay");
		else 
			return String.format("%s%s", string, "ay");
	}	
}
