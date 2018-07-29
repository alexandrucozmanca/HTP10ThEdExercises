package Exercise9_3;
public class CommissionEmployee extends Object
{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate)
	{
		// validate and assign gross sales
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be positive or zero.");

		// validate and assign commissionRate
		if(commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be between 0.0 and 1.0.");

		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	// accesor methods
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

	// accesor for socialSecurityNumber
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}

	// accesor for grossSales
	public double getGrossSales()
	{
		return grossSales;
	}

	// accesor for commissionRate
	public double getCommissionRate()
	{
		return commissionRate;
	}

	// mutator methods
	// mutator for grossSales
	public void setGrossSales(double grossSales)
	{
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be positive or zero.");

		this.grossSales = grossSales;
	}

	// mutator for commissionRate
	public void setCommissionRate(double commissionRate)
	{
		// validate and assign commissionRate
		if(commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be between 0.0 and 1.0.");

		this.commissionRate = commissionRate;
	}

	// method to compute earnings
	public double earnings()
	{
		return getGrossSales() * getCommissionRate();
	}

	// tostring methods
	@Override
	public String toString()
	{
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
				"commission employee", getFirstName(), getLastName(),
				"social security number", getSocialSecurityNumber(),
				"gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}
