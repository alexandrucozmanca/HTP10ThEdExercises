import java.util.Scanner;

public class Triangle 
{

	public static void main(String[] args)
	{
		//instance variables 
		int a, b, c;
		
		//generate Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		
		// querry user input
		System.out.print("Input lenghts: ");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		
		if ((a + b > c) && (a + c > b) && (b + c > a))
			{
			System.out.println("Those values can form a triangle.");
			if (a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a )
				System.out.println("Once more these values can form a right triangle.");
			}
		
		else System.out.println("These values can not form a triangle.");
		
		input.close();		
	}
	
}
