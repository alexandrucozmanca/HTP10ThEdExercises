import javax.swing.JOptionPane;

// compute distance between two points

public class DistanceBetweenPoints
{

	static private String X1 = "", // X1 in String format
							Y1 = "", // Y1 in String format
							X2 = "", // X2 in String format
							Y2 = ""; // Y2 in String format

	public static void main(String[] args)
	{
		double  point1X, // point1 X coord
				point1Y, // point1 Y coordS
				point2X, // point2 X coord
				point2Y; // point2 Y coord

		String input; // local variable for user input

		// query user until valid input
		do
		{
			input = JOptionPane.showInputDialog("Please input coordinates\n(X1,Y1)(X2,Y2)");
			if (!testInput(input)) JOptionPane.showMessageDialog(null, "Try Again!");
		}
		while (!testInput(input));

		
		// split input format in 4 intermediary strings for later conversion to double
		splitInput(input);
			
		// convert each intermediary string to double format
		point1X = stringToDouble(X1);
		point1Y = stringToDouble(Y1);
		point2X = stringToDouble(X2);
		point2Y = stringToDouble(Y2);

		// compute distance between the 2 no.
		JOptionPane.showMessageDialog(null, "Distance between the two points is: "
		+ String.format("%.6f", computeDistance(point1X, point1Y, point2X, point2Y)));
		
	}

	// method for computing distance between 2 points with (x,y)
	private static double computeDistance(
			double point1X, double point1Y, double point2X, double point2Y)
	{
		double distance = 0.0; // initiate

		// compute distance between two points
		distance = Math.sqrt(Math.pow(point1X - point2X, 2) + Math.pow(point1Y - point2Y, 2));
		
		return distance;
	}

	// method for converting number in a string format to double format
	private static double stringToDouble(String input)
	{
		int i = 0; // variable to pinpoint location of char in String
		double output = 0; // the output in double format
		boolean isNegative = false; // test if input is a negative number
		// convert until float point encountered
		for (; i < input.length(); i++)
		{
			if (input.charAt(i) == '-') 
			{
				isNegative = true;
				i++;
			}
			
			if (input.charAt(i) != '.')
				{
				String numeral = "" + input.charAt(i);
				output = output * 10 + Integer.parseInt(numeral);
				}
			else
				break;

		}

		int j = i;
		
		i++; // jump over float point
		// convert after float point
		for (; i < input.length(); i++)
		{
			String numeral = "" + input.charAt(i);
			output = output + (double)Integer.parseInt(numeral) /
					Math.pow(10,(i - j));
		}

		if(isNegative)		output = 0 - output;
		return output;
	}

	// method to split input string of (X,Y)(X,Y) format - where X or Y might be float point
	// into 4 strings for later conversion to double
	private static void splitInput(String input)
	{
		int charLocation = 1; // variable to pinpoint location of char in String
							  // offset by 1 because input string contains useless char at 0;

		// read input and copy to first string until encountering first ','
		for (; charLocation < input.length(); charLocation ++)
		{
			if (input.charAt(charLocation) != ',')
				X1  += input.charAt(charLocation);  // first output string
			else
				break;
		}

		charLocation ++; // jump ',' char in input string

		// read input and copy to second string until encountering first ')'
		for (; charLocation < input.length(); charLocation ++)
		{
			if (input.charAt(charLocation) != ')')
				Y1  += input.charAt(charLocation); // second output string
			else
				break;
		}

		charLocation += 2; // jump next 2 useless chars in input string

		// read input and copy to third string until encountering second ','
		for (; charLocation < input.length(); charLocation ++)
		{
			if (input.charAt(charLocation) != ',')
				X2  += input.charAt(charLocation); // third output string
			else
				break;
		}

		charLocation ++; // jump second ','

		// read input and copy to fourth string until end of input string
		for (; charLocation < input.length(); charLocation ++)
		{
			if (input.charAt(charLocation) != ')')
				Y2  += input.charAt(charLocation); // fourth output string
			else
				break;
		}



	}

	// method for testing input string to conform to required (X,Y)(X,Y)format
	static boolean testInput(String input)
	{
		boolean isCorrect = true; // assume string is in correct format

		while (isCorrect) // run tests until first false case or end of test
		{
			// test string length
			if(input.length()<10)
			{
				isCorrect = false;
				break;
			}

			// first test of pattern if first and last char are '(' and ')'
			if (input.charAt(0) != '(' || input.charAt(input.length()-1) != ')')
			{
				isCorrect = false;
				break;
			}

			int firstLimit = 0; // local variable for first ')' limit character position
			int secondLimit = 0; // local variable for second '(' limit character position

			// second test of pattern - check for ")(" between the 2 numbers
			for (int i = 1; i < input.length() - 2; i++)
				if (input.charAt(i) == ')')
				{
					firstLimit = i;
					secondLimit = i+1;
					break;
				}
			if (input.charAt(secondLimit) != '(')
			{
				isCorrect = false;
				break;
			}

			//test length of first (X,Y) group
			if(firstLimit < 3)
			{
				isCorrect = false;
				break;
			}

			// test length of second (X,Y) group
			if(secondLimit > input.length() - 5)
			{
				isCorrect = false;
				break;
			}

			int firstSemicolon = 0; // local variable for first ',' limit character position
			int secondSemicolon = 0; // local variable for second ',' limit character position

			// test first group (X,Y) for at least one number for X and for Y
			for (int i = 1; i< firstLimit; i++)
			{
				if (input.charAt(i) == ',')
				{
					firstSemicolon = i;
					break;
				}
			}

			if (firstSemicolon < 1  | input.charAt(firstSemicolon+1) == ')')
			{
				isCorrect = false;
				break;
			}

			// test second group (X,Y) for at least one number for X and for Y
			for (int i = secondLimit; i< input.length() - 1; i++)
			{
				if (input.charAt(i) == ',')
				{
					secondSemicolon = i;
					break;
				}
			}

			if (secondSemicolon > input.length()-3 | input.charAt(secondSemicolon-1) == '(')
			{
				isCorrect = false;
				break;
			}

			//test whole string for invalid chars
			for (int i = 0; i< input.length() ;  i++)
			{
				// if char is valid jump to next char, otherwise stop test
				switch(input.charAt(i))
				{
				case '(':
				case ')':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
				case ',':
				case '.':
				case '-':	
					break;
				default:
					isCorrect = false;
				}

				if(!isCorrect) break;
			}
			break;
		}
		
		return isCorrect;
	}
}
