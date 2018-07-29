package Exercise9_3;
public class CommissionEmployeeTest {

	public static void main(String[] args)
	{
		BasePlusCommissionEmployee sue = new BasePlusCommissionEmployee(
				"Sue", "First", "1841206375485", 10000.0, 0.6, 300.0);

		System.out.println(
		"Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", sue.getFirstName());
		System.out.printf("%s %s%n", "Last name is", sue.getLastName());
		System.out.printf("%s %s%n", "Social security number is", sue.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is", sue.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is", sue.getCommissionRate());

		sue.setGrossSales(5000.0);
		sue.setCommissionRate(0.1);



		System.out.printf("%n%s:%n%n%s%n",
		"Updated employee information obtained by toString", sue);

		System.out.println(sue.earnings());

	}

}
