package Exercise10_015;

final public class SalariedEmployee extends Employee
{
	private double salary;

	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double salary)
	{
		super(firstName, lastName, socialSecurityNumber, birthDate);

		// validate and add Salary
		if(salary <= 0.0)
			throw new IllegalArgumentException("Salary must be greater than 0");

		this.salary = salary;

	}


	// accesor methods
	// accesor for salary
	final public double getSalary()
	{
		return salary;
	}

	// mutator methods
	// mutator for salary
	final public void setSalary(double salary)
	{
		if(salary <= 0.0)
			throw new IllegalArgumentException("Salary must be greater than 0");

		this.salary = salary;
	}


	// method to compute earnings
	@Override
	final public double getPaymentAmount()
	{
		return salary;
	}

	final public double getPaymentAmount(double bonus)
	{
		return getPaymentAmount() + bonus;
	}

	// tostring method of SalaryEmployee object
	@Override
	final public String toString()
	{
		return String.format("%s %s%n%s: %s", "Salaried", super.toString(),
				"weekly salary", getSalary());
	}

}// end class SalariedEmployee
