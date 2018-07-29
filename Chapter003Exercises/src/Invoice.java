
public class Invoice 
{
	private String partNumber;  //instance variable for part number
	private String description; //instance variable for part description
	private int partQuantity;   //instance variable for no. of parts
	private double partPrice;   //instance variable for part price

	
	// constructor
	public Invoice (String partNumber, String description, int partQuantity, double partPrice)
	{
		this.partNumber = partNumber;    //asign name to instance variable
		this.description = description;  // asign description to instance variable
		
		// asign quantity to instance variable only if quantity is positive
		if (partQuantity > 0) this.partQuantity = partQuantity; 
			else this.partQuantity = 0;
		
		// asign price to instance variable only if price is positive
		if (partPrice > 0) this.partPrice = partPrice;
			else this.partPrice = 0; 
	}
	
	// method to output part number
	public String getNumber()
	{
		return partNumber;
	}
	
	// method to modify part number
	public void setNumber(String tempString)
	{
		partNumber = tempString;
	}
	
	// method to output part description
	public String getDescription()
	{
		return description;
	}
	
	// method to modify part description
	public void setDescription(String tempString)
	{
		description = tempString;
	}
	
	// method to output part quantity
	public int getPartQuantity()
	{
		return partQuantity;
	}
		
	// method to modify part number, only if new quantity is positive
	public void setPartQuantity(int tempInt)
	{
		if (tempInt >0 ) partQuantity = tempInt;
	}
	
	// method to output part price
	public double getPartPrice()
	{
		return partPrice;
	}
		
	// method to modify part price, only if new quantity is positive
	public void setPartPrice(double tempDouble)
	{
		if (tempDouble >0 ) partPrice = tempDouble;
	}
	
	// method to calculate the invoice
	public double calculateInvoice()
	{
		return partPrice * partQuantity;
	}		
	
}
