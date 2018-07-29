package Exercise17_11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ManipulatingInvoices 
{
	public static void main (String[] args)
	{
		Invoice[] invoices = {
			new Invoice("83", "Electric sander", 7, 57.98),
			new Invoice("24", "Power saw", 18, 99.99),
			new Invoice("7", "Sledge hammer", 11, 21.50),
			new Invoice("77", "Hammer", 79, 11.90),
			new Invoice("39", "Lawn Mower", 3, 79.50),
			new Invoice("68", "Screwdriver", 106, 6.99),
			new Invoice("56", "Jig saw", 21, 11.00),
			new Invoice("1", "Wrench", 34, 7.5)
			};
		
		System.out.println("Invoices sorted by Partdescription");
		Arrays.asList(invoices).stream()
			.sorted(Comparator.comparing(Invoice::getPartDescription))
			.forEach(System.out::println);
				
		
		System.out.println("\nInvoices sorted by Price");
		Arrays.asList(invoices).stream()
			.sorted(Comparator.comparing(Invoice::getPricePerItem))
			.forEach(System.out::println);
		
		System.out.println();
		
		Map<String, List<Invoice>> mapDescription = 
				Arrays.asList(invoices).stream()
				.collect(Collectors.groupingBy
						(Invoice::getPartDescription));
		
		Map<Integer,List<Invoice>> mapQuantity = 
				Arrays.asList(invoices).stream()
				.sorted(Comparator.comparing
						(Invoice::getQuantity))
				.collect(Collectors.groupingBy
						(Invoice::getQuantity));
		
		mapQuantity.forEach((quantity, invoiceList) -> 
				{	
					System.out.println(quantity);
					invoiceList.forEach(invoice -> System.out.printf("  %s%n", invoice));
						
				});
		
		
		
		
	}

}
