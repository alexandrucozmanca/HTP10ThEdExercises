import javax.swing.JOptionPane;

public class FibonaciSeries
{

	public static void main(String[] args)
	{
		Integer N = null;
		String output;

		while (N == null)
		{


			output = String.format("This application computes the Fibonacci sequence to the Nth value.\n"
				+ "An int variable can contain at most the " + maxIntFibonacci() +
				"th value of the series.\n");
			//	+ "An double variable can contain at most the "
			//	+ maxDoubleFibonacci() + "th value of the series."
			//	+ "Please input the desired N value.", maxIntFibonacci());

			String input = JOptionPane.showInputDialog(output);
			try
			{
				N = Integer.parseInt(input);
			}

			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "That is not a valid number.");
			}
		}


		if (N <= maxIntFibonacci())
			output = String.format("The %dth Fibonacci number is: %d.",N,fibonacci(N));
		else
			output = String.format("The %dth Fibonacci number is: %.0f.",N,doubleFibonacci(N));

		JOptionPane.showMessageDialog(null,output);

		

	}

	static int maxIntFibonacci()
	{
		int maxN = 2;
		boolean valid = true;

		while (valid)
		{
			if (fibonacci(maxN) > 0)
				maxN ++;
			else
				{
				valid = false;
				maxN --;
				}
				
		}

		return maxN;
	}

	/*
	static int maxDoubleFibonacci()
	{
		int maxN = 2;
		boolean valid = true;

		while (valid)
		{
			if (doubleFibonacci(maxN) > 0)
				maxN ++;
			else
				valid = false;
				maxN --;
		}

		return maxN;
	}
	*/


	static int fibonacci(int n)
	{
		int fibonaciAtN = 0;
		int firstNumber = 0;
		int secondNumber = 1;

		if (n == 2)
			fibonaciAtN = 1;

		for (int counter = 2; counter < n; counter++)
		{
			fibonaciAtN = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = fibonaciAtN;
		}


		return fibonaciAtN;

	}

	static double doubleFibonacci(int n)
	{
		double fibonaciAtN = 0;
		double firstNumber = 0;
		double secondNumber = 1;

		if (n == 2)
			fibonaciAtN = 1;

		for (int counter = 2; counter < n; counter++)
		{
			fibonaciAtN = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = fibonaciAtN;
		}


		return fibonaciAtN;

	}

}
