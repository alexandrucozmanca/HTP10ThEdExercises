import java.util.Random;

public class ArraySalesCommission {

	public static void main(String[] args) 
	{
		// instance variables
		int commission, sales=0, earnings=0;
		int[] earningsRange = new int[12]; 
		
		// generate random instance for input
		Random rndmInt = new Random();
		
		//run test for 30 people 
		
		for (int i = 1; i <= 30; i++)
		{
		
			commission = 200; // reset commission value
			sales = rndmInt.nextInt(5000); // generate random sale
			
			commission += sales * 9 / 100; // compute commission
		
			
			// distribute sales in range Array according to hundredth increments
			if(commission >= 1000) 
				earningsRange[11]++; // for commissions above $1000 distribute to same increment 
			else 
				earningsRange[commission/100]++;
			
		}		
		
		// printout sales increment
		toString(earningsRange);
	}

	// method to display the range of sales revenue
	public static void toString (int[] earningsRange)
	{
		for (int i = 2; i < earningsRange.length-2; i++)
			System.out.printf("$%d00-%d99      : %d%n", i, i, earningsRange[i]);
			System.out.printf("$1.000 or more: %d",earningsRange[earningsRange.length-1]);
	}
	
	
}


