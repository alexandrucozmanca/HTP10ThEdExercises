package Exercise014_011;

import java.util.Scanner;

public class SearchingStrings
{
	 public static void main (String[] args)
	 {
		System.out.println("Please input your sentece:");
		Scanner keyboard = new Scanner(System.in);
		String sentence = keyboard.nextLine();

		int[] alphabet = new int[25];
		int[] letterCount = new int[25];

		for (int i = 0; i< alphabet.length; i++)
		{
			alphabet [i] = 97 + i;
			int index = 0;

			while (index != -1)
			{
				index = sentence.toLowerCase().indexOf((char) alphabet[i], index) ;

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





		keyboard.close();
	 }
}
