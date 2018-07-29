package Exercise17_12;

import java.util.Arrays;

public class DuplicateWordRemoval 
{
	
	public static void main (String[] args)
	{
		String sentence = "The quick fox jumps over the lazy brown fox hunter";
		String[] sentenceArray = sentence.toLowerCase().split(" ");
		
		Arrays.asList(sentenceArray)
		.stream()
		.sorted()
		.distinct()
		.forEach(System.out::println);
				
	}

}
