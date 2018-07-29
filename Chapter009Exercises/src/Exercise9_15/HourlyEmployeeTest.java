package Exercise9_15;

public class HourlyEmployeeTest
{
	public static void main (String[] args)
	{
		HourlyEmployee sue = new HourlyEmployee(
				"Sue", "First", "1841206375485", 30, 3);

		System.out.println(
		"Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", sue.getFirstName());
		System.out.printf("%s %s%n", "Last name is", sue.getLastName());
		System.out.printf("%s %s%n", "Social security number is", sue.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is", sue.getHours());
		System.out.printf("%s %.2f%n", "Commission rate is", sue.getWage());
		System.out.printf("%s %.2f%n", "Earnings is", sue.earnings());

		sue.setHours(50);
		sue.setWage(3.3);



		System.out.printf("%n%s:%n%n%s%n",
		"Updated employee information obtained by toString", sue);

	}

}
