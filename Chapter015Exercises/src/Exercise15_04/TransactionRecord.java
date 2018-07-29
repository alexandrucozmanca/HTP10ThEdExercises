package Exercise15_04;

public class TransactionRecord 
{
	
	private int account;
	private double transaction;
	
	public TransactionRecord()
	{
		this(0, 0.0);
	}
	
	public TransactionRecord(int account, double transaction)
	{
		setAccount(account);
		setTransaction(transaction);
	}
	
	// methods
	// accesor methods
	// accesor for account
	public int getAccount()
	{
		return account;
	}
	
	//accesor for transaction
	public double getTransaction()
	{
		return transaction;
	}
	
	//mutator methods
	//mutator for account
	public void setAccount(int account)
	{
		this.account = account;
	}
	
	//mutator for transaction
	public void setTransaction(double transaction)
	{
		this.transaction = transaction;
	}

}
