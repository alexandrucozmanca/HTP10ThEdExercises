
public class DoubleArraySales
{

	int [][] sales = new int[6][5];

	// method to add sale base on: array [1] - item, array[1] - sales person, array [2] - amount to add
	public void addSale(int[] sale)
	{
		try
		{
			sales[sale[1]][sale[0]] += sale[2];
		}

		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.printf("%s",e);
			System.out.printf("Invalid sale input.%n");
		}
	}

	// method to display store total sales
	public void displayLedger()
	{
		int itemTotal = 0, // local variable for total sales of one type
			personTotal = 0, // local variable for total sales of one person
			total = 0; // local variable for total store sales
		
		// print header
		System.out.printf("%6s%6s%6s%6s%6s%6s%n",
				"","Tom","Tim","Ted","Tam","Total");
		
		// print individual sales
		for (int i = 0; i < sales.length-1; i++)
		{
			itemTotal = 0; // reset total 
			System.out.printf("Item %d",i+1);
			
			for (int j = 0; j < sales[i].length; j++)
			{
				if(j < sales[i].length-1)
				{
					itemTotal += sales[i][j]; // compute total item sales
					System.out.printf("%6d",sales[i][j]); // print item sale
					
				}
				else 
					System.out.printf("%6d%n", itemTotal); // print total item sales
			}
			
		}
		
		// print personal total
		System.out.printf("%6s","Total");
		for (int j = 0; j < sales[4].length - 1; j++)
		{
			personTotal = 0; // reset personal total
			for (int i = 0; i < sales.length - 1; i++ )
			{
				personTotal += sales[i][j]; // compute personal Total 
				
			}
			
			System.out.printf("%6d", personTotal); // print personal sales
			total += personTotal; // compute total store sales
		}
		
		// print store total
		System.out.printf("%6d", total);
		
	}



} // end of class

