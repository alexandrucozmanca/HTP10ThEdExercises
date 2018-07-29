package Exercise014_024;

import java.util.Scanner;

public class Test {

	public static void main(String[] args)
	{

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input desired word");
		String word = keyboard.next();

		SpellChecker checker = new SpellChecker(word);
		
		if(checker.checkWord())
			System.out.printf("\"%s\" is a valid English word.", checker.getCheckedWord());
		else
			System.out.println(checker.checkAproximation());

		keyboard.close();

	}

}
