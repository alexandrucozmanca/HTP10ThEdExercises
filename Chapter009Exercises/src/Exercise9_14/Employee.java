package Exercise9_14;

public class Employee {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;


	public Employee(String firstName, String lastName, String socialSecurityNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

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

	public String toString()
	{
		return String.format("%s: %s %s%n%s: %s",
				"employee", getFirstName(), getLastName(),
				"social security number", getSocialSecurityNumber());
	}

}
