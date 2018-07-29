import java.util.Random;

public class DiamondEnhanced {

	public static void main(String[] args) 
	{
		Random rnd = new Random();
		int test = rnd.nextInt(9)*2 + 1;
		System.out.println(test);
				
		for (int row = 1; row <= test; row ++)
		{
			if ( row <= test/2 + 1)
			{
				for (int space = 0; space < test/2 + 1 - row; space++) System.out.print(" ");
				for (int column = 1; column <= 2*(row - 1) + 1 ; column ++) System.out.print("*");
				for (int space = 0; space < test/2 + 1 - row; space++) System.out.print(" ");
				System.out.println();
			}
			else 			
			{
				for (int space = 0; space < row - test/2 - 1; space++) System.out.print(" ");
				for (int column = 1; column <= 2*(test - row) + 1 ; column ++) System.out.print("*");
				for (int space = 0; space < row - test/2 - 1;  space++) System.out.print(" ");
				System.out.println();
			}
		}
		
	}

}
