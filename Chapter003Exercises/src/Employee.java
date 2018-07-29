
public class Employee 
{
	private String firstName, lastName; // instance variable for first and resp. last name
	private double monthlySalary; // instance variable for salary
	
	//constructor
	public Employee(String firstName, String lastName, double monthlySalary)
	{
		this.firstName = firstName; // asign firstName to instance variable
		this.lastName = lastName;
		
		if (monthlySalary > 0) this.monthlySalary = monthlySalary;
		else monthlySalary = 0;
	}
	
	
	// method for retrieving first name
	public String getFirstName()
	{
		return firstName;
	}

	// method for modifing first name
	public void setFirstName(String tempString)
	{
		firstName = tempString;
	}
		
	// method for retrieving last name
	public String getLastName()
	{
		return lastName;
	}

	// method for modifing first name
	public void setLastName(String tempString)
	{
		lastName = tempString;
	}
	
	// method for retrieving salary
	public double getSalary()
		{
			return monthlySalary;
		}

	// method for modifing salary
	public void setSalary(Double tempDouble)
	{
		if (tempDouble > 0) monthlySalary = tempDouble;
	}
	
	
}
