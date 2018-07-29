package Exercise014_009;

import java.util.Scanner;

public class OrderReversed {

	public static void main(String[] args) {
		
	System.out.println("Please input your sentece");
	Scanner keyboard = new Scanner(System.in);

	String sentence = keyboard.nextLine();
	String[] sentenceArray = sentence.split(" ");
	StringBuilder buffer = new StringBuilder();
	
	for (int word = sentenceArray.length - 1; word >= 0; word --)
		{ 
		System.out.print(sentenceArray[word] + " ");
		buffer.append(sentenceArray[word]).append(" ");
		}
	
	System.out.println();
	System.out.println(sentence.toLowerCase());
	System.out.println(sentence.toUpperCase());
	System.out.println(buffer.reverse());
	keyboard.close();
	}
}
