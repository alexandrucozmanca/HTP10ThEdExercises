package Exercise014_013;

import java.util.Scanner;

public class TokenizingAndComparing {
	public static void main(String[] args)
	{
		System.out.println("Please input your sentece");
		Scanner keyboard = new Scanner(System.in);
		String sentence = keyboard.nextLine();
		String[] sentenceArray = sentence.split(" ");
		
		for(int word = 0; word < sentenceArray.length; word++)
		{
			if(sentenceArray[word].startsWith("b"))
				System.out.println("Word starting with \'b\': " + sentenceArray[word]);
			
			if(sentenceArray[word].startsWith("ED"))
				System.out.println("Word starting with \"ED\": " + sentenceArray[word]);
		}
		
		keyboard.close();
	}

}
