
public class ModifiedTrianglePatern {

	public static void main(String[] args) 
	{
		
		System.out.printf("%-10s\t%-10s\t%-10s\t%-10s%n", "(a)", "(b)", "(c)", "(d)");
		for (int row = 1; row <= 10; row++)
		{
			for (int column = 1; column <= row; column ++) System.out.print("*");
			for (int column = 1; column <= 10 - row; column ++) System.out.print(" ");
			System.out.printf("\t");
			
			for (int column = 1; column <= 11 - row; column ++) System.out.print("*");
			for (int column = 1; column <= row - 1; column ++) System.out.print(" ");
			System.out.printf("\t");
			
			for (int column = 1; column <= row - 1; column ++) System.out.print(" ");
			for (int column = 1; column <= 11 - row; column ++) System.out.print("*");
			System.out.printf("\t");
			
			for (int column = 1; column <= 10 - row; column ++) System.out.print(" ");
			for (int column = 1; column <= row; column ++) System.out.print("*");
			System.out.printf("%n");
		}
	}

}
