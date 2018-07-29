package Exercise10_015;

final public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary;

	public BasePlusCommissionEmployee (String firstName, String lastName, String socialSecurityNumber, Date birthDate,
			double grossSales,	double commissionRate, double baseSalary)
	{
		super(firstName, lastName, socialSecurityNumber, birthDate, grossSales, commissionRate);

		// check and set baseSalary
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be positive.");

		this.baseSalary = baseSalary;
	}

	// accesor methods
	// accesor for baseSalary
	final public double getBaseSalary()
	{
		return baseSalary;
	}

	// compute earnings
	@Override
	final public double getPaymentAmount()
	{
		return baseSalary + super.getPaymentAmount();
	}

	@Override
	final public double getPaymentAmount(double bonus)
	{
		return this.getPaymentAmount() + bonus;
	}

	// mutator methods
	// mutator for baseSalary
	final public void setBaseSalary(double baseSalary)
	{
		// check and set baseSalary
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be positive.");

		this.baseSalary = baseSalary;
	}

	// toString methods
	// default toString
	@Override
	final public String toString()
	{
		return String.format("%s %s%n%s: %.2f", "base-salaried", super.toString(),
				"base salary", getBaseSalary());
	}
}
