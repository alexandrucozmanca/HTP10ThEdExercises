import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;

public class EmployeeTest 
{

	public static void main(String[] args) 
	{
		// create Employee objects and asign to respective instances
		 Employee testEmployee1 = new Employee("Jane","Smith",1530.85);
		 Employee testEmployee2 = new Employee("John","Tom",1850.85);
		 
		 // display Employee details and yearly salary		 
		 out.printf("Your employee %s %s has a yearly salary of %.2f.%n",
				 testEmployee1.getLastName(),testEmployee1.getFirstName(),12*testEmployee1.getSalary());
		 out.printf("Your employee %s %s has a yearly salary of %.2f.%n%n",
				 testEmployee2.getLastName(),testEmployee2.getFirstName(),12*testEmployee2.getSalary());

		 // create Scanner object for user input
		 Scanner input = new Scanner(in);
		 
		 
		 //update names
		 out.printf("Update employee %s %s`s name:%n",
				 testEmployee1.getLastName(),testEmployee1.getFirstName());
		 testEmployee1.setLastName(input.next());
		 testEmployee1.setFirstName(input.next());
		 input.nextLine();
		 
		 //update salaries
		 testEmployee1.setSalary(testEmployee1.getSalary()*1.1);
		 testEmployee2.setSalary(testEmployee2.getSalary()*1.1);
		 
		 // display Employee details and yearly salary		 
		 out.printf("Your employee %s %s has a yearly salary of %.2f.%n",
				 testEmployee1.getLastName(),testEmployee1.getFirstName(),12*testEmployee1.getSalary());
		 out.printf("Your employee %s %s has a yearly salary of %.2f.%n%n",
				 testEmployee2.getLastName(),testEmployee2.getFirstName(),12*testEmployee2.getSalary());
		 
		 input.close();
		 
	}

}
