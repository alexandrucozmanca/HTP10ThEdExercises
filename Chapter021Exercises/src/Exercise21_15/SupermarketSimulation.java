package Exercise21_15;

import java.util.Random;

import com.deitel.datastructures.EmptyListException;
import com.deitel.datastructures.Queue;

public class SupermarketSimulation 
{
	public static void main(String[] args)
	{
		simulateClients();
	}
	
	public static void simulateClients()
	{
		Queue <Customer> checkout = new Queue<>(); // create checkout queue containing the customers
		
		// initialize first customer and assign service time
		Customer first = new Customer(1 + new Random().nextInt(4));
		
		
		// enqueue first customer
		checkout.enqueue(first);
		
		int nextService = 1; // next possible service time 
		int maxWait = 0; // maximum wait time;
		int maxQueue = 0;
				
		for (int minute = 1; minute <= 720; minute ++)
		{	
			// check if a client arrives at the checkout
			if(checkout.peekAtBack().getArrivalTime() == minute)
			{
				// notify arrival
				System.out.printf("**Customer arrived at minute: %d.%n", minute);
											
				//create next customer, determine arrival time and service time and enqueue next customer
				Customer next = new Customer (minute + arrivalTime());
				checkout.enqueue(next);
			}
			
			// check if a client can be serviced and is present
			if (minute >= nextService && checkout.peek().getArrivalTime() <= minute)
			{
				try
				{
					System.out.printf("Customer serviced at minute: %d.%n%n", minute);
					checkout.peek().setServiceTime(serviceTime());
					nextService = minute + checkout.peek().getServiceTime();
					checkout.peek().setDepartureTime(nextService - 1);
									
					if (maxWait < checkout.peek().getWaitTime())
						maxWait = checkout.peek().getWaitTime();
					checkout.dequeue();
				}
				catch(EmptyListException emptyListException)
				{
					System.out.printf("At minute %d, checkout was free.", minute);
				}
			}
			
			if (maxQueue < checkout.length())
				maxQueue = checkout.length();
		}
		
		System.out.printf("At end of 720 minutes a maximum number or %d customers were in the queue and the longest wait time was: %d.%n",
				maxQueue, maxWait);
		
	}
	
	// randomly assign service time length
	public static Integer serviceTime()
	{
		return 1+ new Random().nextInt(4);
	}
	
	// randomly determine next client arrival time
	public static Integer arrivalTime()
	{
		return 1+ new Random().nextInt(4);
	}
}

class Customer
{
	private int arrivalTime;
	private int serviceTime;
	private int departureTime;
	
	
	Customer(int arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}
	
	public int getArrivalTime()
	{
		return arrivalTime;
	}
			
	public void setServiceTime(int serviceTime)
	{
		this.serviceTime = serviceTime;
	}
	
	public int getServiceTime()
	{
		return serviceTime;
	}
	
	public void setDepartureTime(int departureTime)
	{
		this.departureTime = departureTime;
	}
	
	public int getWaitTime()
	{
		return departureTime - arrivalTime - serviceTime + 1;
	}

}
