/*
Write an application that calculates the product of a series
of integers that are passed to method product using a variable-length argument list. Test your method
with several calls, each with a different number of arguments.
 *
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VariableLenghtProduct
{
	public static void main (String [] arg)
	{

		int currentNumber = 0;
		String input;

		if(arg.length > 0)
		{

			int arrayLenght = Integer.parseInt(arg[0]);

			ArrayList<Integer> intArray = new ArrayList<>(arrayLenght);


			JOptionPane.showMessageDialog(null, "This computes the product of several\n"
				+ "numbers with a variable length array.");

			do  // request user input and test for validity
			{
				input = JOptionPane.showInputDialog("Input number or 0 to stop:");

				try
				{
					// transform input in usable int value
					currentNumber = Integer.parseInt(input);
					if(currentNumber != 0)
					intArray.add(currentNumber);
				}

				catch (NumberFormatException e)
				{
					// in case of non-int. value reset input to a non-valid sentinel condition
					System.out.println(e);

				}

				// user info in case of non-valid user input

			} while (currentNumber != 0); // validity range

			//output product
			JOptionPane.showMessageDialog(null,"The product of the numbers is: " + computeProduct(intArray));
		}

		else
			JOptionPane.showMessageDialog(null, "Please provide initial lenght of variable array as arg command line.");

	}

	// method to multiply values of a variable length array
	public static int computeProduct(ArrayList<Integer> array)
	{
		int product = 1;

		for(int number : array)
			product *= number;

		return product;

	}

}
