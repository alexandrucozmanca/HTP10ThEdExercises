import java.util.Scanner;


public class BinaryToDecimal 
{
	public static void main(String[] args) 
	{
		// instance variables
		int binary, initialBinary, decimal = 0, power = 1;
		
		// generate Scanner object for user input
		Scanner input = new Scanner(System.in);
				
		
		// query user for binary number
		System.out.print("Input binary number: ");
		binary = input.nextInt();
		
		// store initial value for later output
		initialBinary = binary;
				
		
		// conversion from binary to decimal
		while (binary != 0)
		{
			decimal += (binary % 2 * power);
			binary /= 10;
			power *= 2;
			
		}
		System.out.printf("Binary no. %d is equivalent to decimal no. %d.%n",initialBinary,decimal);
		
		input.close();
	}

}
