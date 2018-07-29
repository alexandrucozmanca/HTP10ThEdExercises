package exercise8_18;

import java.math.BigDecimal;

public class Account
{

	private String name; /** instance variable - account name */
	private BigDecimal balance; /** instance variable - balance value */

	/** constructor with parameter name */

	public Account(String name, BigDecimal balance)
	{
		this.name = name; /** assign name to instance variable name */

		if (balance.compareTo(BigDecimal.ZERO) == 1 ) /** assign balance to instance variable balance only if balance is greater that 0.0 */
			this.balance = balance;
	}

	/** method to set the name in the object */
	public void setName(String name)
	{
		this.name = name;
	}

	/** method to retrieve the name from the object */
	public String getName()
	{
		return name;
	}

	/** method to add a valid amount to the account balance */
	public void deposit(BigDecimal depositAmount)
	{
		if(depositAmount.compareTo(BigDecimal.ZERO) >= 1) //if depositAmount is positive
			{
			balance = balance.add(depositAmount);
			System.out.printf("Adding %s to account %s", depositAmount, name);
			}
	}

	/** method to withdraw amount from the account balance */
	public void withdrawal(BigDecimal withdrawalAmount)
	{
		if (balance.compareTo(withdrawalAmount) >= 0 ) // allow withdraws only if balance equals or excedes withdraw amount
			{
			balance = balance.subtract(withdrawalAmount);
			System.out.printf("%s has been withdrawn from %s account.%n",withdrawalAmount,name);
			}
			else System.out.println("Withdrawal amount excedes account balance");
	}

	/** method to return the deposit balance */
	public BigDecimal getBalance()
	{
		return balance;
	}

	public static void displayAccount(Account accountToDisplay)
	{
		System.out.printf("Account %s has a total balance of %s.%n",
				accountToDisplay.name,accountToDisplay.balance);
	}

}
