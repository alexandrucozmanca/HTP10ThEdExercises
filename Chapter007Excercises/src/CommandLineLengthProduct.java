/*
Write an application that calculates the product of a series
of integers that are passed to method product using a variable-length argument list. Test your method
with several calls, each with a different number of arguments.
 *
 */

import javax.swing.JOptionPane;

public class CommandLineLengthProduct
{
	public static void main (String [] arg)
	{

		int currentNumber = 0;
		String input;
		System.out.print(arg.length);

		if(arg.length == 1)
		{
			int arrayLength = 0; // array length

			int counter = 0; // sentinel variable / array index


			try // use command line arg as array length
			{
				arrayLength = Integer.parseInt(arg[0]);
			}

				catch (NumberFormatException e)
			{

			// 	in case of non-int. value reset default value 10
			JOptionPane.showMessageDialog(null, e + "\nYou have inputed an incorect argument.\n"
					+ "Array initialised with the default value 10.");

			arrayLength = 10;
			}


			int[] intArray = new int[arrayLength];

			// user info
			JOptionPane.showMessageDialog(null, "This computes the product of several\n"
				+ "numbers with a command line defined array.");



			do  // request user input and test for validity
			{
				input = JOptionPane.showInputDialog("Input number:");

				try
				{
					// transform input in usable int value
					currentNumber = Integer.parseInt(input);
					intArray[counter] = currentNumber ; // assign valid input to array
					counter++; // advance 1 index
				}

				catch (NumberFormatException e)
				{
					// in case of non-int. value reset input to a non-valid sentinel condition
					JOptionPane.showMessageDialog(null, e + "\nPlease input a number.");

				}

				// user info in case of non-valid user input

			} while (counter < arrayLength); // validity range

			//output product
			JOptionPane.showMessageDialog(null,"The product of the numbers is: " + computeProduct(intArray));
		}

		else
			JOptionPane.showMessageDialog(null, "Please provide initial lenght of array as command line argument.");

	}

	// method to multiply values of a variable length array
	public static int computeProduct(int[] array)
	{
		int product = 1;

		for(int number : array)
			product *= number;

		return product;

	}

}
