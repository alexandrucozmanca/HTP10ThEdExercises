import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;


public class InvoiceTest {

	public static void main(String[] args)
	{
		//create an Invoice object and asign it to testInvoice
		Invoice testInvoice = new Invoice("10554","SSD Hamatchi",5,52.45);  
		
		//Display testInvoice parameters
		out.printf("You have ordered %d unit(s) of part no. %s (%s) at a price of %.2f per unit.%n",
				testInvoice.getPartQuantity(),testInvoice.getNumber(),testInvoice.getDescription(),testInvoice.getPartPrice());
		out.printf("Your order will ammount to $%.2f.%n",testInvoice.calculateInvoice());
	
		//create a Scanner object for user input
		Scanner input = new Scanner(in);
		
		//Modify and display part number		
		out.println("Input new part number: ");
		testInvoice.setNumber(input.next());
		input.nextLine();
		out.printf("New part number is %s.%n%n",testInvoice.getNumber());
		
		//Modify and display part description		
		out.println("Input new part description: ");
		testInvoice.setDescription(input.nextLine());
		out.printf("New part description is %s.%n%n",testInvoice.getDescription());
		
		//Modify and display part quantity		
		out.println("Input new part quantity: ");
		testInvoice.setPartQuantity(input.nextInt());
		out.printf("New part description is %d.%n%n",testInvoice.getPartQuantity());
		
		//Modify and display part price		
		out.println("Input new part price: ");
		testInvoice.setPartPrice(input.nextDouble());
		out.printf("New part price is %.2f.%n%n",testInvoice.getPartPrice());
		
		//ReDisplay testInvoice parameters
		out.printf("You have ordered %d unit(s) of part no. %s (%s) at a price of %.2f per unit.%n",
					testInvoice.getPartQuantity(),testInvoice.getNumber(),testInvoice.getDescription(),testInvoice.getPartPrice());
		out.printf("Your order will ammount to $%.2f.%n",testInvoice.calculateInvoice());
		
		
		input.close();
		
	}

}
