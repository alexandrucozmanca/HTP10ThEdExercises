package Exercise15_06;
import java.io.Serializable;

public class Account implements Serializable 
{
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	// no argument constructor
	public Account()
	{
		this (0, "", "", 0.0);
	}
	
	// constructor with values provided
	public Account (int account, String firstName, String lastName, double balance)
	{
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	// mutator methods
	// mutator for account no
	public void setAccount (int account)
	{
		this.account = account;
	}
	
	//mutator for firstName
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	// mutator for lastName
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	// mutator for balance
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	// accesor methods
	// accesor for account
	public int getAccount()
	{
		return account;
	}
	
	// accesor for firstName
	public String getFirstName()
	{
		return firstName;
	}
	
	// accesor for lastName
	public String getLastName()
	{
		return lastName;
	}
	
	// accesor for balance
	public double getBalance()
	{
		return balance;
	}

	// combine method - inputs a TransactionRecord object and combines Account object`s balance variable with TransactionRecord object`s 
	// transaction variable
	public void combine (TransactionRecord transactionRecord)
	{
		if(this.account == transactionRecord.getAccount())
			this.setBalance(this.getBalance() + transactionRecord.getTransaction());
	}
}

