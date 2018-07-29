public class CompoundInterest
{

	public static void main(String[] args)
	{	
		// instance variables
		int initialAmount, EOYAmount; 
		double interestRate;
				
		
			interestRate = 0.05;
			initialAmount = 100000;
			System.out.printf("%n%nFor interest at value %4.2f values are the folowing:%n",interestRate);
			System.out.printf("Year%20s%n","Amount on deposit");
			
			for (int year = 1; year <= 10; year++)
			{
				EOYAmount = (int)(initialAmount * Math.pow(1 + interestRate, year));
				System.out.printf("%-4d   $ %d and cents %d%n",year,EOYAmount/100,EOYAmount%100);
			}

		
	}	
}
