import java.util.Scanner;

public class SalesCalculator 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double totalSales = 0, product1Total = 0, product2Total = 0,product3Total = 0, 
				product4Total = 0, product5Total = 0;
		int product1Sales = 0, product2Sales = 0, product3Sales = 0, product4Sales = 0,
				product5Sales = 0;
		
		System.out.printf("Please input sales as follows:%n"
				+ "product ID followed by no. of products + Enter."
				+ " To stop input End of File character.%n");
		
		while(input.hasNext())
		{	
			int productID = input.nextInt();
			int saleAmount = input.nextInt();
			if (productID >= 1 && productID <= 5)
				{switch(productID)
				{
					case 1:
						totalSales += 2.98 * saleAmount;
						product1Total += 2.98 * saleAmount;
						product1Sales += saleAmount;
					break;
					
					case 2:
						totalSales += 4.5 * saleAmount;
						product2Total += 4.5 * saleAmount;
						product2Sales += saleAmount;
					break;

					case 3:
						totalSales += 9.98 * saleAmount;
						product3Total += 9.98 * saleAmount;
						product3Sales += saleAmount;
					break;

					case 4:
						totalSales += 4.49 * saleAmount;
						product4Total += 4.49 * saleAmount;
						product4Sales += saleAmount;
					break;

					case 5:
						totalSales += 6.87 * saleAmount;
						product5Total += 6.87 * saleAmount;
						product5Sales += saleAmount;
					break;			
				}}
			else continue; 
		}
		
		
		System.out.printf("%nTotal sales amounted to %.2f.%n",totalSales);
		System.out.printf("Product 1 was sold %d times and amounted to: %.2f.%n",
				product1Sales,product1Total);
		System.out.printf("Product 2 was sold %d times and amounted to: %.2f.%n",
				product2Sales,product2Total);
		System.out.printf("Product 3 was sold %d times and amounted to: %.2f.%n",
				product3Sales,product3Total);
		System.out.printf("Product 4 was sold %d times and amounted to: %.2f.%n",
				product4Sales,product4Total);
		System.out.printf("Product 5 was sold %d times and amounted to: %.2f.%n",
				product5Sales,product5Total);
		input.close();
	}
	
}
