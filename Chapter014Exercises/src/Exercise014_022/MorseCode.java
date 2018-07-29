package Exercise014_022;

public class MorseCode {

	public static void main(String[] args)
	{
		String test = "This is a test of the public broad cast system";
		System.out.println(test);
		System.out.println(toMorse(test));
		System.out.println(toAlphabet(toMorse(test)));
		//System.out.println(toAlphabet2(toMorse(test)));

	}

	public static String toMorse(String input)
	{
		final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				 '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
		      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
		      ".---", "..---", "...--", "....-", "....", "-....", "--...", "---..", "----.", "-----"};

		char[] charArray = input.toCharArray();

		String output = "";


		for (int i = 0; i < charArray.length; i++)
		{
			for(int j = 0; j < alphabet.length; j++)
			{
				if((Character.toUpperCase(charArray[i])) == alphabet[j])
				{
					output += morse[j];
					output += " ";
					continue;
				}


			}

			if(charArray[i] == ' ')
			{
				output += " / ";
				continue;
			}
		}
		return output;

	}


	public static String toAlphabet(String input)
	{
		final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				 '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
		      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
		      ".---", "..---", "...-"
		      		+ "-", "....-", "....", "-....", "--...", "---..", "----.", "-----"};

		String[] inputArray = input.split(" ");
		input = "";
		for (int i = 0; i< inputArray.length; i ++)
		{
			for (int j = 0; j < morse.length; j++)
				if (inputArray[i].equals(morse[j]))
					inputArray[i] = String.format("%c", Character.toLowerCase(alphabet[j]));
			if(inputArray[i].equals("/"))
				inputArray[i] = " ";


		}

		for(int i = 0; i< inputArray.length; i ++)
			input = input + inputArray[i];

		return input;
	}
	
	public static String toAlphabet2(String input)
	{
		final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				 '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
		      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
		      ".---", "..---", "...-"
		      		+ "-", "....-", "....", "-....", "--...", "---..", "----.", "-----"};

		
		for (int j = morse.length - 1; j >= 0; j--)
		{
			String regex = String.format("%s%s ","\\", morse[j]);
			String replace = String.format("%c", Character.toLowerCase(alphabet[j]));
			
			System.out.println(input);
			
			input = input.replaceAll(regex, replace);
			
			System.out.printf("%s %s%n", regex, replace);
			System.out.println(input);
		}
			
		
		return input;
	}
}
