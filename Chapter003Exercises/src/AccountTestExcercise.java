
//Create and manipulate an Account object
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class AccountTestExcercise 
{

	public static void main(String[] args) 
	{
		/** Creates a Scanner object to obtain input from command window */
		Scanner input = new Scanner(in);
		
		/** create an Account object and assign it to myAccount */
		Account myAccount1 = new Account("Tod Green",50.0);
		Account myAccount2 = new Account("Jeb Kerman",87.48);
		Account myAccount3 = new Account("Nille Kerboss",421.47);
				
		/** display initial balance of accounts */
		out.printf("Initial %s account balance is: %.2f.%n%n",myAccount1.getName(),myAccount1.getBalance());
		
		// display initial balance using instance specific method
		out.println("Output of instance specific method.");
		Account.displayAccount(myAccount1);
		Account.displayAccount(myAccount2);
		Account.displayAccount(myAccount3);
		
		/** Prompt user to deposit new amounts */
		out.printf("Please deposit for %s account: ",myAccount1.getName());
		double tempAmount = input.nextDouble();
		myAccount1.deposit(tempAmount);
		out.printf("Adding %.2f to %s account.%n%n",tempAmount,myAccount1.getName());
	
	
		/** display updated value of account*/
		out.printf("%n%s account balance is: %.2f.%n",myAccount1.getName(),myAccount1.getBalance());

		
		/** withdraw ammount from account */
		out.printf("%nPlease specify amount to be withdrawn from %s account. ",myAccount1.getName());
		myAccount1.withdrawal(input.nextDouble());
		
		/** display updated value of account*/
		out.printf("%n%s account balance is: %.2f.%n",myAccount1.getName(),myAccount1.getBalance());

		
		input.close(); /** closes input scanner */
		
	}

}
