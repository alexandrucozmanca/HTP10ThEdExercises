package Exercise16_18;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReversedLinkedList 
{
	public static void main (String[] args)
	{
		Character[] characters = {'a','b', 'c', 'd', 'e', 'f'}; 
		List<Character> charList = new LinkedList<>(Arrays.asList(characters));
		
		printList(charList);
		System.out.println();
		
		List<Character> inverseList = new LinkedList<>(charList);
		Collections.sort(inverseList, Collections.reverseOrder());
		
		printList(inverseList);
	}

	private static void printList(Collection<Character> collection)
	{
		Iterator<Character> iterator = collection.iterator();
		while (iterator.hasNext())
			System.out.printf("%c ", iterator.next());
	}
	
}
