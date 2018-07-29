public class Account 
{
	
	private String name; /** instance variable - account name */
	private double balance; /** instance variable - balance value */
	
	/** constructor with parameter name */
	
	public Account(String name, double balance)
	{
		this.name = name; /** assign name to instance variable name */
		
		if (balance > 0 ) /** assign balance to instance variable balance only if balance is greater that 0.0 */
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
	public void deposit(double depositAmount)
	{
		if(depositAmount > 0) //if depositAmount is positive
			balance = balance + depositAmount;
	}
	
	/** method to withdraw amout from the account balance */
	public void withdrawal(double withdrawalAmount)
	{
		if (balance >= withdrawalAmount) // allow withdraws only if balance equals or excedes withdraw amount
			{balance = balance - withdrawalAmount;
			System.out.printf("%.2f has been withdrawn from %s account.%n",withdrawalAmount,name);
			}
			else System.out.println("Withdrawal amount excedes account balance");
	}
	
	/** method to return de deposit balance */
	public double getBalance()
	{
		return balance;
	}
	
	public static void displayAccount(Account accountToDisplay)
	{
		System.out.printf("Account %s has a total balance of %.2f.%n",
				accountToDisplay.name,accountToDisplay.balance);
	}
	
}
