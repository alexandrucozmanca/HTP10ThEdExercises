import java.util.Random;
import static java.lang.System.out;

public class StoreCustomerTest {

	public static void main(String[] args)
	{
		//create random generator object for test
		Random randomInt = new Random();
		
		// create and display StoreCustomer object with for test
		StoreCustomer test1 = new StoreCustomer(randomInt.nextInt(900),0,0,0,randomInt.nextInt(9000));
		out.printf("Store customer ID: %d has a balance of %d and max allowed store credit of %d.%n",test1.getAccountNo(),test1.getBalance(),test1.getAllowedCredit());

		
		// run test for 10 months
		int j = 0;
		while (j < 10)
		{
			//	run test on charge method for 4 random purchases and one credit
			out.printf ("%nMonth %d.%n%n",j+1);
			
			int i = 0;
			while (i < 4)
			{	int temp = randomInt.nextInt(3000);
				test1.addCharge(temp); // charge item
				out.printf("$%d charged.%n",temp); // display charge
				if (test1.getTotalCharged() > test1.getAllowedCredit()) // check for over spending 
				{
					out.println("Credit limit exceeded, no more purchases this month.");
					break;
				}
				i++;
			}
			
			out.printf("%nTotal purchases this month: $%d.%n%n",test1.getTotalCharged()); // display total charges
			int temp = randomInt.nextInt(10000);
			test1.addCredit(temp); // credit account 
			out.printf("$%d credited to account.%n",temp); // display credited amount 
			test1.computeBalance(); // compute balance at EOM
			out.printf("Balance at end of month: $%d.%n", test1.getBalance()); // display balance at EOM
			
			if (test1.getBalance() < -test1.getAllowedCredit()) // check store credit limit 
			{
				out.println("Credit limit exceeded, no more purchases.");
				break;
			}
			
			j++;
		}
	}

}
