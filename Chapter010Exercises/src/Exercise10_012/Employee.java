package Exercise10_012;

public abstract class Employee {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final Date birthDate;


	public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = birthDate;
	}

	final public String getFirstName()
	{
		return firstName;
	}

	// accesor for lastName
	final public String getLastName()
	{
		return lastName;
	}

	// accesor for socialSecurityNumber
	final public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}

	// accesor for birthDate
	final public Date getBirthDate()
	{
		return birthDate;
	}

	// return weekly earnings
	public abstract double earnings();

	// return weekly earnings + specified bonus
	public abstract double earnings(double bonus);

	// toString method
	@Override
	public String toString()
	{
		return String.format("%s: %s %s%n%s: %s%n%s %s",
				"employee:", getFirstName(), getLastName(),
				"social security number", getSocialSecurityNumber(),
				"Born on: ", getBirthDate());
	}

}
