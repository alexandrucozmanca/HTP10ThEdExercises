import java.util.Scanner;

 class Fct
 {
	public int computeFactorial(int n)
	 {
		int factorial = 1;
		while (n != 0)
		{
			factorial *= n;
			n--;
		}
		return factorial;
	 }
}

public class Factorial
{

	public static void main(String[] args)
	{
		//instance variables
		int factorial = 1 , i , n;
		String output="";

		// generate Scanner object for user input
		Scanner input = new Scanner(System.in);

		// compute value of n!
		// -----------------------------------------------------------------------------------
		System.out.print("Please input value of n for n!. ");
		i = input.nextInt();
		n = i;

		while  (i != 0)
		{
			factorial *= i;
			String temp = String.format("%d * ",i);
			output = output.concat(temp);
			i--;
		}

		output = output.substring(0, output.length()-2);
		System.out.printf("%n%d! factorial is %n%s%nand has a value of %d.%n",n,output,factorial);
		// -----------------------------------------------------------------------------------


		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println();

		// compute value of e
		// ------------------------------------------------------------------------------------

		double e = 1;
		i++;
		Fct fValue = new Fct();
		String eOutput = "e = 1";

		while (i <= n)
		{
			e += ((double)1/fValue.computeFactorial(i));
			String temp = String.format(" + 1/%d!",i);
			eOutput = eOutput.concat(temp);
			i++;
		}

		System.out.printf("Value of constant \"e\" computed up to term %d is:%n"
				+ "%s%nand has the value: %.9f%n",n,eOutput,e);
		// ------------------------------------------------------------------------------------


		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println();

		// compute value of e^x - method 1 (values are almost correct versus tabular data
		// (possible creeping errors because I compute to a very approximate value of e
		// ------------------------------------------------------------------------------------
		/*
		double eX = 1;
		int j = 1, x;

		Fct fExValue = new Fct();
		System.out.print("Input the value of x for e^x: ");
		x = input.nextInt();
		String eXOutput = String.format("e^%d = 1",x);
		String eXTest = String.format("e^%d = 1",x);

		while (j <= n)
		{
			// compute x^n in e^x formula
			// -------------------------------------
			int powerX = x;
			int k = 1;
			while (k < j)
			{
				powerX *= x;
				k++;
			}
			// --------------------------------------

			// add x^j/j! to previous value of e for given j up to value of n
			eX += ((double)powerX/fExValue.computeFactorial(j));
			String temp = String.format(" + %d^%d/%d!",x,j,j);
			eXOutput = eXOutput.concat(temp);
			String temp1 = String.format(" + %d/%d!",powerX,j);
			eXTest = eXTest.concat(temp1);

			j++;
		}

		System.out.printf("Value of \"e^%d\" computed up to term %d is:%n"
				+ "%s%n%s%nand has the value: %.9f%n",x,n,eXOutput,eXTest,eX);
		*/

		// ----------------------------------------------------------------------------------

		// compute value of e^x - method 2 (values are almost correct versus tabular data,
		// better aproximation versus method 1
		// ----------------------------------------------------------------------------------

		int y = 0,x;
		double eX = 1;
		System.out.print("Input the value of x for e^x: ");
		x = input.nextInt();
		while (y < x)
		{
			eX *= e;
			y++;
		}
		System.out.printf("Value of \"e^%d\" computed up to term %d has the value: %.9f%n",
				x,n,eX);



		input.close();
	}

}
