package Exercise10_012;

public class PieceWorker extends Employee
{
	private int pieces;
	private double wage;

	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, Date birthDate,
			int pieces, double wage)
	{
		super(firstName, lastName, socialSecurityNumber, birthDate);

		// check and assign hours worked
		if (pieces <0.0)
			throw new IllegalArgumentException ("Pieces completed must be positive.");

		// check and assign hourly wage
		if (wage < 0.0)
			throw new IllegalArgumentException ("Wage per piece must be positive.");

		this.pieces = pieces;
		this.wage = wage;

	}

	// accesor methods
	// accesor for hours
	final public int getPieces()
	{
		return pieces;
	}

	// accesor for wage
	final public double getWage()
	{
		return wage;
	}

	// mutator methods
	// mutator for hours
	final public void setPieces (int pieces)
	{
		if (pieces <0.0)
			throw new IllegalArgumentException ("Pieces completed must be positive.");

		this.pieces = pieces;
	}

	// mutator for wage
	final public void setWage (double wage)
	{
		if (wage < 0.0)
			throw new IllegalArgumentException ("Hourly wage must be positive.");
		this.wage = wage;
	}

	// method to determine weekly earnings
	@Override
	final public double earnings()
	{
		return getWage() * getPieces();
	}

	@Override
	final public double earnings(double bonus)
	{
		return earnings() + bonus;
	}

	@Override
	final public String toString()
	{
		return String.format("%s %s%n%s: %d%n%s: $%,.2f",
				"Hourly", super.toString(),
				"Pieces completed", getPieces(),
				"Wage per piece", getWage());
	}

}
