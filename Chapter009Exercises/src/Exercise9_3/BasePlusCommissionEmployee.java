package Exercise9_3;
public class BasePlusCommissionEmployee
{
	private CommissionEmployee employee;
	private double baseSalary;

	public BasePlusCommissionEmployee (String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary)
	{
		employee = new CommissionEmployee(firstName, lastName, socialSecurityNumber,
				grossSales, commissionRate);

		// check and set baseSalary
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be positive.");

		this.baseSalary = baseSalary;
	}

	public BasePlusCommissionEmployee(CommissionEmployee employee, double baseSalary)
	{
		this.employee = employee;

		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be positive.");

		this.baseSalary = baseSalary;
	}

	// accesor methods
	// accesor for baseSalary
	public double getBaseSalary()
	{
		return baseSalary;
	}

	public String getFirstName()
	{
		return employee.getFirstName();
	}

	// accesor for lastName
	public String getLastName()
	{
		return employee.getLastName();
	}

	// accesor for socialSecurityNumber
	public String getSocialSecurityNumber()
	{
		return employee.getSocialSecurityNumber();
	}

	// accesor for grossSales
	public double getGrossSales()
	{
		return employee.getGrossSales();
	}

	// accesor for commissionRate
	public double getCommissionRate()
	{
		return employee.getCommissionRate();
	}

	// mutator methods
	// mutator for grossSales
	public void setGrossSales(double grossSales)
	{
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be positive or zero.");

		employee.setGrossSales(grossSales);
	}

	// mutator for commissionRate
	public void setCommissionRate(double commissionRate)
	{
		// validate and assign commissionRate
		if(commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be between 0.0 and 1.0.");

		employee.setCommissionRate(commissionRate);
	}



	// compute earnings
	public double earnings()
	{
		return baseSalary + employee.earnings();
	}

	// mutator methods
	// mutator for baseSalary
	public void setBaseSalary(double baseSalary)
	{
		// check and set baseSalary
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be positive.");

		this.baseSalary = baseSalary;
	}



	// toString methods
	// default toString
	public String toString()
	{
		return String.format("%s %s%n%s: %.2f", "base-salaried", employee,
				"base salary", getBaseSalary());
	}
}
