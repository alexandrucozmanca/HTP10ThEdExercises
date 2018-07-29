package Exercise9_15;

import Exercise9_14.Employee;

public class HourlyEmployee extends Employee
{
	double hours;
	double wage;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours,
			double wage)
	{
		super(firstName, lastName, socialSecurityNumber);

		// check and assign hours worked
		if (hours <0.0)
			throw new IllegalArgumentException ("Hours worked must be positive.");

		// check and assign hourly wage
		if (wage < 0.0)
			throw new IllegalArgumentException ("Hourly wage must be positive.");

		this.hours = hours;
		this.wage = wage;

	}

	// accesor methods
	// accesor for hours
	public double getHours()
	{
		return hours;
	}

	// accesor for wage
	public double getWage()
	{
		return wage;
	}

	// mutator methods
	// mutator for hours
	public void setHours (double hours)
	{
		if (hours <0.0)
			throw new IllegalArgumentException ("Hours worked must be positive.");
		this.hours = hours;
	}

	// mutator for wage
	public void setWage (double wage)
	{
		if (wage < 0.0 || wage > 168)
			throw new IllegalArgumentException ("Hourly wage must be positive and below 168h per week.");
		this.wage = wage;
	}


	public double earnings()
	{
		if (getWage() < 40.0)
			return getWage() * getHours();
		else
			return getWage() * getHours() * 1.5;
	}

	@Override
	public String toString()
	{
		return String.format("%s %s%n%s: %s%n%s: %s%n%s:%s ",
				"Hourly", super.toString(),
				"Hours worked", getHours(),
				"Wage per hour", getWage(),
				"Earnings:",earnings());
	}

}
