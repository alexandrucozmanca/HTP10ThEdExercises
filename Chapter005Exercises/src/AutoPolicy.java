public class AutoPolicy
{
	private int accountNumber; // instance variable for account ID number
	private String makeAndModel; // instance variable for car model and manufacturer
	private String state; // instance variable for state policy - abreviated to two letters

	// constructor
	AutoPolicy (int accountNumber, String makeAndModel, String state)
	{
		this.accountNumber = accountNumber;
		this.makeAndModel = makeAndModel;
		this.state = state;
	}

	// method to set account number
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	// method to retrieve account number
	public int getAccountNumber()
	{
		return accountNumber;
	}

	// method to set make and model
	public void setMakeAndModel(String makeAndModel)
	{
		this.makeAndModel = makeAndModel;
	}

	// method to retrieve make and model
	public String getMakeAndModel()
	{
		return makeAndModel;
	}

	// method to set State
	public void setState(String state)
	{
		if (state == "CT" || state == "MA" || state == "ME" || state == "NH" || state == "NJ" ||
				state == "NY" || state == "PA" || state == "VT")
			this.state = state;
		else
			System.out.println("Incorect state.");
	}

	// method to retrieve State
	public String getState()
	{
		return state;
	}

	// method to determine if policy is in no fault state

	public boolean isNoFaultState ()
	{
		boolean noFaultState;
		switch (getState())
		{
			case "MA":
			case "NJ":
			case "NY":
			case "PA":
				noFaultState = true;
				break;
			default:
				noFaultState = false;
				break;
		}

		return noFaultState;
	}

}



