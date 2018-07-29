package exercise8_18;
//Create and manipulate an Account object
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

import java.math.BigDecimal;

public class AccountTestExcercise
{

	public static void main(String[] args)
	{
		/** Creates a Scanner object to obtain input from command window */
		Scanner input = new Scanner(in);

		/** create an Account object and assign it to myAccount */
		Account myAccount1 = new Account("Tod Green", new BigDecimal("50"));
		Account myAccount2 = new Account("Jeb Kerman", new BigDecimal("87.48"));
		Account myAccount3 = new Account("Nille Kerboss", new BigDecimal("421.47"));

		/** display initial balance of accounts */
		out.printf("Initial %s account balance is: %s.%n%n",myAccount1.getName(),myAccount1.getBalance());

		// display initial balance using instance specific method
		out.println("Output of instance specific method.");
		Account.displayAccount(myAccount1);
		Account.displayAccount(myAccount2);
		Account.displayAccount(myAccount3);

		/** Prompt user to deposit new amounts */
		out.printf("Please deposit for %s account: ",myAccount1.getName());
		BigDecimal tempAmount = new BigDecimal(input.nextLine());
		myAccount1.deposit(tempAmount);



		/** display updated value of account*/
		out.printf("%n%s account balance is: %s.%n",myAccount1.getName(),myAccount1.getBalance());


		/** withdraw ammount from account */
		out.printf("%nPlease specify amount to be withdrawn from %s account. ",myAccount1.getName());
		myAccount1.withdrawal(new BigDecimal(input.nextLine()));

		/** display updated value of account*/
		out.printf("%n%s account balance is: %s.%n",myAccount1.getName(),myAccount1.getBalance());


		input.close(); /** closes input scanner */

	}

}
