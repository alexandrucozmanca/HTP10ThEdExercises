package exercise8_6;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class SavingsAccountTest 
{

	public static void main(String[] args) 
	{
		SavingsAccount sA1 = new SavingsAccount(BigDecimal.valueOf(2000));
		SavingsAccount sA2 = new SavingsAccount(BigDecimal.valueOf(3000)); 
		
		System.out.printf("Initial value of account1: %s.%n",sA1);
		System.out.printf("Initial value of account1: %s.%n",sA2);
		
		SavingsAccount.setAnnualInterestRate(BigDecimal.valueOf(4.8));
		
		System.out.printf("%-6s%13s%13s%n","month","Acc1 savings", "Acc2 savings");
		
		for (int month = 1; month <= 12; month ++)
		{
			sA1.calculateMonthlyInterest();
			sA2.calculateMonthlyInterest();
			System.out.printf("%-6d%13s%13s%n",month,sA1,sA2);
			
		}
		
		SavingsAccount.setAnnualInterestRate(BigDecimal.valueOf(6.0));
		
		System.out.printf("%-6s%13s%13s%n","month","Acc1 savings", "Acc2 savings");
		
		for (int month = 1; month <= 12; month ++)
		{
			sA1.calculateMonthlyInterest();
			sA2.calculateMonthlyInterest();
			System.out.printf("%-6d%13s%13s%n",month,sA1,sA2);
			
		}
	}

}

class SavingsAccount
{
	static private BigDecimal annualInterestRate = BigDecimal.ZERO;
	private BigDecimal savingsBalance;
	
	public SavingsAccount()
	{
		this(BigDecimal.ZERO);
	}
	
	public SavingsAccount(BigDecimal savingsBalance)
	{
		setSavingsBalance(savingsBalance);
	}
	
	
	public void setSavingsBalance(BigDecimal savingsBalance)
	{
		this.savingsBalance = savingsBalance;
	}
	
	static public void setAnnualInterestRate(BigDecimal newAnnualInterestRate)
	{
		annualInterestRate = newAnnualInterestRate;
		
	}
	
	
	public void calculateMonthlyInterest()
	{
		setSavingsBalance(savingsBalance
				.add(savingsBalance
						.multiply(annualInterestRate
								.divide(BigDecimal.valueOf(12.00)
										.multiply(BigDecimal.valueOf(100))))));
	}
	
	public String toString()
	{
		return String.format("%s",NumberFormat.getCurrencyInstance().format(savingsBalance));
	}
	
	public BigDecimal getAnnualInterestRate()
	{
		return annualInterestRate;
	}
}