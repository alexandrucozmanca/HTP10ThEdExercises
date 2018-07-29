package Exercise16_13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateElimination 
{
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		Collection<String> collection = readNames();
		
		printSet(collection);
		
		System.out.println("Please input name to check for:");
		String name = keyboard.next();
		
		System.out.printf("The name %s %s in the list", name, hasToken(name, collection) ? "is" : "is not");
		
		
	}

	private static ArrayList<String> readNames()
	{
		
		ArrayList<String> list = new ArrayList<>();
		
		System.out.println("Please insert the names, or No to stop:");
		
		
		
		while (keyboard.hasNext())
		{
			String input = keyboard.next();
			if (!input.toLowerCase().equals("no"))
				{
				list.add(input);
				System.out.println("more?");
				}
			else
				break;
		}
 						
		return list;
	}
	
	private static void printSet( Collection<String> collection)
	{
		Set<String> set = new TreeSet<>(collection);
		
		System.out.println("The set of names is:");
		for (String s : set)
			System.out.printf("%s ",s);
		
		System.out.println();
	}
	
	private static boolean hasToken(String token, Collection<String> collection)
	{
		Set<String> set = new TreeSet<>(collection);
		Iterator<String> iterator = set.iterator();
		
		while (iterator.hasNext())
			if (token.matches(iterator.next()))
				return true;
		
		return false;
	}
}
