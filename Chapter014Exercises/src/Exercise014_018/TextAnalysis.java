package Exercise014_018;

import java.util.ArrayList;

public class TextAnalysis {
	
	public static void main(String[] args)
	{
		String test = "To be, or not to be: that is the question: Whether 'tis nobler in the mind to suffer";
		wordOccurence(test);
		
	}

	public static void letterCount(String string)
	{
		int[] alphabet = new int[25];
		int[] letterCount = new int[25];

		for (int i = 0; i< alphabet.length; i++)
		{
			alphabet [i] = 97 + i;
			int index = 0;

			while (index != -1)
			{
				index = string.toLowerCase().indexOf((char) alphabet[i], index) ;

				if(index != -1)
					{
					letterCount[i]++;
					index++;
					}

			}
			if(i % 4 == 0 && i != 0)
				System.out.println();
			System.out.printf("%c count: %d\t", (char)alphabet[i], letterCount[i]);
		}
	}
	
	
	public static void wordLengthCount(String sentence)
	{
		String[] sentenceArray = sentence.split(" ");
		int[] wordLength = new int[10];
		
		for (int word = 0; word< sentenceArray.length; word++)
			{
				if(sentenceArray[word].length() < wordLength.length)
					wordLength[sentenceArray[word].length()]++;
				else
					wordLength[wordLength.length-1]++;
			}
	
		for (int i = 1; i < wordLength.length; i++)
		{
			if(i % 2 == 0 && i != 0)
				System.out.println();
			System.out.printf("Word length: %d, occurence: %d", i, wordLength[i]);
		}
		
	}
	
	public static void wordOccurence(String sentence)
	{
		String[] sentenceArray = sentence.split(" ");
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> wordOccurence = new ArrayList<Integer>();
		
		for(int i = 0; i < sentenceArray.length; i++)
		{
			sentenceArray[i] = removeSigns(sentenceArray[i]);
			words.add(i, sentenceArray[i]);
			wordOccurence.add(i, 1);
		}
		
		
		for (int i = 0; i < words.size() - 1; i ++)
		{
			String string1 = words.get(i);
			
			for (int j = i + 1; j< words.size(); j++)
			{
				
				String string2 = words.get(j);
				if(string1.equalsIgnoreCase(string2))
				{
					words.remove(j);
					wordOccurence.add(i,wordOccurence.get(i) + 1);
					words.trimToSize();
				}
			}
		}
		
		
		
		
		
		
		for(int i = 0; i < words.size(); i++)
		{	
			if(i % 2 == 0 && i != 0)
				System.out.println();
			System.out.printf("Word: %s \t occurs: %d times.\t ", words.get(i), wordOccurence.get(i));
		}
		
	}

	public static String removeSigns(String word)
	{
		
		if((word.startsWith("`") || word.startsWith("\'")))
			word = word.substring(1);
		if(word.endsWith("!") || word.endsWith("?") || word.endsWith(":") || word.endsWith(";") || word.endsWith(".")
				|| word.endsWith(","))
			word = word.substring(0, word.length() - 1);	
			
		return word;
	}
}
