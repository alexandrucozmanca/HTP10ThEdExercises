import java.util.Scanner;
public class BarChart2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numbers in range 1 to 30:");
		for (int  i = 1; i <= 5; i++)
		{
			int number = input.nextInt();
			if (number > 30 || number < 1)
			{
				System.out.println("Invalid number.");
				number = input.nextInt();
			}
			
			for (int j = 1; j <= number; j++)
				System.out.print("*");
			System.out.println();
			
		}
	
		input.close();
	}
		
}
