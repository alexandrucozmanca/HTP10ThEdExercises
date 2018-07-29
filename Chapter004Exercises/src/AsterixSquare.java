import java.util.Scanner;
	
public class AsterixSquare 
{
	public static void main(String[] args)
	{
		// instance variables
		int i = 1, j = 1, lenght;
		
		// generate Scanner object for input
		Scanner input = new Scanner(System.in);
		
		// query user for input
		System.out.print("Input square lenght: ");
		lenght = input.nextInt();
		
		System.out.printf("%n%n%n");
		
		while (i <= lenght)
		{
			if (i == 1)
				while (j <= lenght)
				{
					System.out.print("* ");
					j++;
				}
			else 
				if (i == lenght)
					while (j <= lenght)
					{
						System.out.print("* ");
						j++;
					}
				else
				{
					while(j <= lenght)
					{
						if (j == 1)
						{
							System.out.print("*");
							j++;
						}
					
						else 
						{
							System.out.print("  ");
							j++;
						}
					
						if (j == lenght)
						{
							System.out.print(" *");
							j++;
						}
					}
					
				}
				
			
			System.out.println();
			j = 1;
			i++	;
		
		}
		
		input.close();
	}

}
