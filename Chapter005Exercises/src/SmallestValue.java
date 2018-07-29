import java.util.Scanner;
import java.util.Random;
public class SmallestValue 
{
	public static void main(String[] args)
	{
		int smallest;
		
		//Scanner input = new Scanner(System.in);
		Random input = new Random();
		
		
		int counter = input.nextInt(40); 
		smallest = input.nextInt(90);
		System.out.printf("Running test for %d iterations.%n",counter);
		System.out.printf("Testing values: %d",smallest);
		for ( int i = 2 ; i <= counter ; i++)
		{	int temp = input.nextInt(90);
			System.out.printf(" %d",temp);
			if(temp < smallest)
				smallest = temp;
		}
			
		
		System.out.printf("%nSmallest is %d.%n",smallest);
	}
}
