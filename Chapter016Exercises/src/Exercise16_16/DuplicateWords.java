package Exercise16_16;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DuplicateWords 
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please input sentence:");
		evaluateSentence(keyboard.nextLine());
		
		keyboard.close();
	}
	
	private static void evaluateSentence(String sentence) 
	{
		String[] wordArray = sentence.split(" "); 
				
		Map<String, Integer> wordMap = new HashMap<>();
		
		for (int word = 0; word < wordArray.length; word ++)
		{
			wordArray[word] = wordArray[word].toLowerCase();
			
			if(wordMap.containsKey(wordArray[word]))
				wordMap.put(wordArray[word], wordMap.get(wordArray[word]) + 1);
			else
				wordMap.put(wordArray[word], 1);
		}
		
		Set<String> orderedSet = wordMap.keySet();
		
		int maxValue = Collections.max(wordMap.values());
		
		
		if (maxValue > 1)
		{
			System.out.printf("%s%n%-5s%5s%n", "Duplicate words:", "Word", "Count");  
			
			for (String word : orderedSet)
				if (wordMap.get(word) > 1)
					System.out.printf("%-5s%5s%n", word, wordMap.get(word) );  
		} 
		else 
			System.out.println("There are no duplicate words in the sentence.");
		
	}
	
}
