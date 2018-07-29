import java.util.Random;

public class SalesCommission {

	public static void main(String[] args) 
	{
		// instance variables
		int commission=200, sales=0, earnings=0;
		// generate random instance for input
		Random rdmInt = new Random();
		
		//run test for 12 weeks 
		int i = 0;
		
		while (i < 12)
		{
			System.out.printf("Week %d.%n",i+1);
			
			// add random sales with 20% chance to stop
			int sale = rdmInt.nextInt(100);
			if (sale < 20) sale = 0;
			while (sale > 0)
			{
				System.out.printf("Sale: $%d.%n",sale);
				sales += sale;
				sale = rdmInt.nextInt(100);
				if (sale < 40) sale = 0;
			}
		// compute and display commission
		commission += (int) (sales * 0.09);
		System.out.printf("Sales this week: $%d.%n",sales);
		System.out.printf("Commission for this week: $%d.%n%n",commission);
		
		earnings += commission;
		sales = 0; // reset sales
		commission = 200; // reset commission
		
		i++;
		}
		
		System.out.printf("Total earninings after %d weeks: $%d.%n",i,earnings);
	}

}
