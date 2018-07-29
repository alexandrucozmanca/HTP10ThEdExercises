package Exercise16_20;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetSort 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
			
		SortedSet <String> sentenceTree = new TreeSet<>(Arrays.asList(keyboard.nextLine().split(" ")));
	
		for (String s : sentenceTree)
			System.out.printf("%s%n", s);
	
		keyboard.close();
	}
}
