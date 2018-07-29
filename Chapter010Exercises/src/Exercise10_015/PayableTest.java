package Exercise10_015;

public class PayableTest
{

	public static void main(String[] args)
	{
		// create four-element Payable array
		Payable[] payableObjects = new Payable[7];

		// populate array with objects that implement Payable
		payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
		payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);

		payableObjects[2] =
				new SalariedEmployee("John", "Smith", "111-11-1111", new Date(11, 6, 1984), 800.00);

		payableObjects[3] =
				new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(6, 20, 1976), 16.75, 40);

		payableObjects[4] =
				new CommissionEmployee(
						"Sue", "Jones", "333-33-3333", new Date(8, 14, 1992), 10000, .06);

		payableObjects[5] =
				new BasePlusCommissionEmployee(
						"Bob", "Lewis", "444-44-4444", new Date(2, 28, 1976), 5000, .04, 300);

		payableObjects[6] =
				new PieceWorker(
						"Tom", "Lewis", "555-55-5555", new Date(2, 5, 1976), 40, 15.0);



		System.out.println(
		"Invoices and Employees processed polymorphically:");

		// generically process each element in array payableObjects
		for (Payable currentPayable : payableObjects)
		{

			// output currentPayable and its appropriate payment amount
			System.out.printf("%n%s %n", currentPayable); // could invoke implicitly


			if (currentPayable instanceof BasePlusCommissionEmployee)
			{
				// downcast to Employee object
				Employee employee = (Employee) currentPayable;

				// downcast to BasePlusCommissionEmployee object
				BasePlusCommissionEmployee basePlus = (BasePlusCommissionEmployee) employee;

				basePlus.setBaseSalary(1.10 * basePlus.getBaseSalary());

				System.out.printf(
						"new base salary with 10%% increase is: $%,.2f%n",
						basePlus.getBaseSalary());

			}


			System.out.printf("%s: $%,.2f%n","payment due",currentPayable.getPaymentAmount());
		}
	}// end main

} // end class PayableTest
