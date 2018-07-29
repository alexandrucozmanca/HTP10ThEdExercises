package Exercise16_14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordTypeCount 
{

	public static void main(String[] args)
	{
		// create HashMap to store String keys and Integer values
		Map<Character, Integer> myMap = new HashMap<>();
		
		createMap(myMap);
		displayMap(myMap);
	}
	
	// create map from user input
	private static void createMap(Map<Character, Integer> map)
	{
		Scanner scanner = new Scanner(System.in); // create scanner
		System.out.println("Enter a string: "); // prompt for user input
		String input = scanner.nextLine();
		
		//Tokenize the input
		String[] tokens = input.split(" ");
		
		// processing input text
		for (String token : tokens)
		{
			String word = token.toLowerCase(); // get lowercase word
			char[] charArray = word.toCharArray();
			
			for (char letter : charArray)
				// if the map contains the letter
				if (map.containsKey(letter)) // is word in map?
				{
					int count = map.get(letter); // get current count
					map.put(letter, count + 1 );
				}
				else
					map.put(letter, 1);
 		}
		
		scanner.close();
	}
	
	// display map content
	private static void displayMap(Map<Character, Integer> map)
	{
		Set<Character> keys = map.keySet();
		
		
		// sort keys
		TreeSet<Character> sortedKeys = new TreeSet<>(keys);
		
		System.out.printf("%nMap contains:%nKey Value%n");
		
		// generate output for each key in map
		for (char key : sortedKeys)
			System.out.printf("%-4s%5s%n", String.format("%c", key), map.get(key));
		
		System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
	}
	
}
