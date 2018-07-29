public class StoreCustomer
{
	//instance variables
	private int accountNo
	,balance /* balance at 1st of the month*/
	,totalItemCharged /* amount charged to account over the month */
	,totalCreditApplied /*credit applied to account over the month - payments */
	,allowedCredit /* max credit limit*/;

	//constructor with allowed credit validation
	public StoreCustomer(int accountNo, int balance, int totalItemCharged, int totalCreditApplied, int allowedCredit)
	{
		this.accountNo = accountNo;
		this.balance = balance;
		this.totalItemCharged = totalItemCharged;
		this.totalCreditApplied = totalCreditApplied;

		if (allowedCredit >= 0)
			this.allowedCredit = allowedCredit;
		else this.allowedCredit = 0;
	}

	// method for accountNo return
	public int getAccountNo()
	{
		return accountNo;
	}

	//method to change accountNo
	public void setAccountNo(int accountNo)
	{
		this.accountNo = accountNo;
	}


	// method for balance return
	public int getBalance()
	{
		return balance;
	}

	//method to change balance
	public void setBalance(int balance)
	{
		this.balance = balance;
	}

	// method for total charge return
	public int getTotalCharged()
	{
		return totalItemCharged;
	}

	//method to change total charge
	public void setTotalCharged(int totalItemCharged)
	{
		if (totalItemCharged >= 0)
		this.totalItemCharged = totalItemCharged;
	}

	//method to charge purchase with validation for positive
	public void addCharge(int charge)
	{
		if (charge > 0)
		this.totalItemCharged += charge;
	}

	// method for total credit return
	public int getTotalCredit()
	{
		return totalCreditApplied;
	}

	//method to change total applied credit
	public void setTotalCredit(int totalCreditApplied)
	{
		if (totalCreditApplied >= 0)
		this.totalCreditApplied = totalCreditApplied;
	}

	//method to add credit with validation for positive
	public void addCredit(int credit)
	{
		if (credit > 0)
		this.totalCreditApplied += credit;
	}

	// method for credit limit return
	public int getAllowedCredit()
	{
		return allowedCredit;
	}

	//method to change credit limit
	public void setAllowedCredit(int allowedCredit)
	{
		if (allowedCredit > 0)
		this.allowedCredit = allowedCredit;
	}

	public int computeBalance()
	{
		balance = balance - totalItemCharged + totalCreditApplied;
		totalItemCharged = 0;
		totalCreditApplied = 0;
		return balance;
	}

}
