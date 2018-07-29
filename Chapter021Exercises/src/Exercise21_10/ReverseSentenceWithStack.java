package Exercise21_10;

import com.deitel.datastructures.StackInheritance;

public class ReverseSentenceWithStack 
{
	public static void main (String[] args)
	{
		String sentence = "This is the test sentence";
		String[] wordArray = sentence.split(" ");
		
		StackInheritance <String> sentenceStack = new StackInheritance<>();
		
		for (int i = 0; i < wordArray.length; i ++)
			sentenceStack.push(wordArray[i]);

		System.out.println(sentence);
		
		while (!sentenceStack.isEmpty())
			System.out.printf("%s ",sentenceStack.pop());
		
	}
		
	
}
