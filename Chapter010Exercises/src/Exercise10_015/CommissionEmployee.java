package Exercise10_015;

public class CommissionEmployee extends Employee
{
	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate,
			double grossSales, double commissionRate)
	{
		super(firstName, lastName, socialSecurityNumber, birthDate);
		// validate and assign gross sales
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be positive or zero.");

		// validate and assign commissionRate
		if(commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be between 0.0 and 1.0.");

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	// accesor methods
	// accesor for firstName

	// accesor for grossSales
	final public double getGrossSales()
	{
		return grossSales;
	}

	// accesor for commissionRate
	final public double getCommissionRate()
	{
		return commissionRate;
	}

	// mutator methods
	// mutator for grossSales
	final public void setGrossSales(double grossSales)
	{
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be positive or zero.");

		this.grossSales = grossSales;
	}

	// mutator for commissionRate
	final public void setCommissionRate(double commissionRate)
	{
		// validate and assign commissionRate
		if(commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be between 0.0 and 1.0.");

		this.commissionRate = commissionRate;
	}

	// method to compute earnings
	@Override
	public double getPaymentAmount()
	{
		return getGrossSales() * getCommissionRate();
	}

	public double getPaymentAmount(double bonus)
	{
		return getPaymentAmount() + bonus;
	}

	// tostring methods
	@Override
	public String toString()
	{
		return String.format("%s %s%n%s: %,.2f%n%s: %,.2f",
				"commission", super.toString(),
				"gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}
