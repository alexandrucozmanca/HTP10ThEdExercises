import java.util.Random;

public class DoubleArraySalesStore 
{

	public static void main(String[] args) 
	{
	DoubleArraySales sales = new DoubleArraySales();
	int[] sale = new int[3];
	
	Random tester = new Random();
	
	for (int i = 0; i < 10; i ++)
	{
		sale[0] = tester.nextInt(4);
		sale[1] = tester.nextInt(5);
		sale[2] = tester.nextInt(5)+1;		
		sales.addSale(sale);
		System.out.printf("Added to seller %d at item %d %d.%n",sale[0]+1, sale[1]+1, sale[2]);		
	}
	System.out.println();
	sales.displayLedger();
		
	}

}
