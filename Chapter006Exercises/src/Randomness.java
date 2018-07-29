import java.util.Random; //for random numbers 

public class Randomness 
{
	
	public static void main(String[] args) 
	{
		Random output = new Random();
		
		for (int i = 1; i <= 10; i++)
		{	
			System.out.println("New Block");			
			System.out.printf("1 <= %d <= 2%n",1 + output.nextInt(2));
			System.out.printf("1 <= %d <= 100%n",1 + output.nextInt(100));
			System.out.printf("0 <= %d <= 9%n", output.nextInt(10));
			System.out.printf("1000 <= %d <= 1112%n",1000 + output.nextInt(113));
			System.out.printf("-1 <= %d <= 1%n",-1 + output.nextInt(3));
			System.out.printf("-3 <= %d <= 11%n",-3 + output.nextInt(15));
			System.out.println();
			
		}
		
		
		
		
	}

}
