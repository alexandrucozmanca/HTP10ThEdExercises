import javax.swing.JOptionPane;


public class Ch03_Optional_Addition
{
	public static void main(String[] args)
	{
		int number1, number2;

		String temp = JOptionPane.showInputDialog("What is the first number?");
		number1 = Integer.parseInt(temp);

		temp = JOptionPane.showInputDialog("What is the second number?");
		number2 = Integer.parseInt(temp);

		temp = String.format("The sum of %d and %d is %d.%n"
				+ "The product of %d and %d is %d.%n"
				+ "The difference of %d and %d is %d.%n"
				+ "The quotient of %d and %d is %d.%n",
				number1, number2,(number1 + number2),
				number1, number2,(number1 * number2),
				number1, number2,(number1 - number2),
				number1, number2,(number1 % number2));
		JOptionPane.showMessageDialog(null, temp);

	}

}
