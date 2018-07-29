package Exercise10_012;

public class PayrollSystemTest
{

	public static void main(String[] args)
	{
		Date currentDate = new Date(2, 5, 2018);

		// create subclass objects
		SalariedEmployee salariedEmployee =
		new SalariedEmployee("John", "Smith", "111-11-1111", new Date(11, 6, 1984), 800.00);

		HourlyEmployee hourlyEmployee =
		new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(6, 20, 1976), 16.75, 40);

		CommissionEmployee commissionEmployee =
		new CommissionEmployee(
		"Sue", "Jones", "333-33-3333", new Date(8, 14, 1992), 10000, .06);

		BasePlusCommissionEmployee basePlusCommissionEmployee =
		new BasePlusCommissionEmployee(
		"Bob", "Lewis", "444-44-4444", new Date(2, 28, 1976), 5000, .04, 300);

		PieceWorker pieceWorker =
				new PieceWorker(
				"Tom", "Lewis", "555-55-5555", new Date(2, 5, 1976), 40, 15.0);


		//create four-element Employee array
		Employee[] employees = new Employee[5];

		// initialize array with Employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		employees[4] = pieceWorker;

		System.out.printf("Employees processed polymorphically:%n%n");

		// generically process each element in array employees
		for (Employee currentEmployee : employees)
		{
			double bonus = 0.0;
			System.out.println(currentEmployee); // invokes toString

			// determine whether element is a BasePlusCommissionEmployee
			if (currentEmployee.getBirthDate().getMonth() == currentDate.getMonth())
			{
				bonus = 100.0;
				System.out.printf(
						"Bonus of $%.2f added, Happy Birthday!%n",bonus);

			} // end if

			System.out.printf(
				"earned $%,.2f%n%n", currentEmployee.earnings(bonus) );
		} // emd for

		// get type name of each object in employees array
		for (int j = 0; j < employees.length; j++)
		System.out.printf("Employee %d is a %s%n", j,
		employees[j].getClass().getName());

	}

}
