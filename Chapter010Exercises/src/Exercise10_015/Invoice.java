package Exercise10_015;

public class Invoice implements Payable
{

	private final String partNumber;
	private final String partDescription;
	private int quantity;
	private double pricePerItem;


	// constructor
	public Invoice (String partNumber, String partDescription, int quantity, double pricePerItem)
	{
		// validate and assign quantity
		if (quantity < 0)
			throw new IllegalArgumentException ("Quantity must be positive.");

		// validate and assign pricePerItem
		if (pricePerItem < 0.0)
			throw new IllegalArgumentException ("Item price must be positive.");

		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;

	}// end constructor


	// accesor methods
	// accesor for partNumber

	public String getPartNumber()
	{
		return partNumber;
	}

	// accesor for partDescription
	public String getPartDescription()
	{
		return partDescription;
	}

	// accesor for quantity
	public int getQuantity()
	{
		return quantity;
	}

	// accesor for pricePerItem
	public double getPricePerItem()
	{
		return pricePerItem;
	}

	// mutator methods
	// mutator for quantity
	public void setQuantity(int quantity)
	{
		if (quantity < 0)
			throw new IllegalArgumentException ("Quantity must be positive.");

		this.quantity = quantity;
	}

	// mutator for pricePerItem
	public void setPricePerItem(double pricePerItem)
	{
		if (pricePerItem < 0.0)
			throw new IllegalArgumentException ("Item price must be positive.");

		this.pricePerItem = pricePerItem;
	}

	//toString method
	@Override
	public String toString()
	{
		return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
				"invoice", "part number", getPartNumber(), getPartDescription(),
				"quantity", getQuantity(), "price per item", getPricePerItem());
	}

	// method compliant with interface Payable to compute amount to be paid for the parts
	@Override
	public double getPaymentAmount()
	{
		return getQuantity() * getPricePerItem();
	}

}
