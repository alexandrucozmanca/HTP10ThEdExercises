
public class Diamond {

	public static void main(String[] args) 
	{
		for (int row = 1; row <= 9; row ++)
		{
			if ( row <= 5)
			{
				for (int space = 0; space < 5 - row; space++) System.out.print(" ");
				for (int column = 0; column < row - 1 ; column ++) System.out.print("*");
				System.out.print("*");
				for (int column = 0; column < row - 1; column ++) System.out.print("*");
				for (int space = 0; space < 5 - row; space++) System.out.print(" ");
				System.out.println();
			}
			else 			
			{
				for (int space = 0; space < row - 5; space++) System.out.print(" ");
				for (int column = 0; column < 9 - row ; column ++) System.out.print("*");
				System.out.print("*");
				for (int column = 0; column < 9 - row ; column ++) System.out.print("*");
				for (int space = 0; space < row - 5;  space++) System.out.print(" ");
				System.out.println();
			}
		}
		
	}

}
