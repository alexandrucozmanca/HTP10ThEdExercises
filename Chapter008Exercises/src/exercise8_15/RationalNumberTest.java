package exercise8_15;

public class RationalNumberTest
{

	public static void main(String[] args)
	{
		RationalNumber rn1 = new RationalNumber();
		RationalNumber rn2 = new RationalNumber(3,9);
		RationalNumber rn3 = new RationalNumber(new RationalNumber(3,6));

		System.out.println(RationalNumber.divide(rn3, rn2));

		System.out.println(rn1);
		System.out.printf("%.2f%n",rn1.toFloatPoint());
		System.out.println(rn2);
		System.out.printf("%.2f%n",rn2.toFloatPoint());
		System.out.println(rn3);
		System.out.printf("%.2f%n",rn3.toFloatPoint());
	}

}


class RationalNumber
{
	// instance variables
	private int numerator; // rational number numerator variable
	private int denominator; // rational number denominator variable

	// no args constructor
	RationalNumber()
	{
		this(0,1);
	}

	// constructor with RationalNumber object as argument
	RationalNumber(RationalNumber number)
	{
		this(number.getNumerator(), number.getDenominator());
	}


	// constructor with int values as arguments
	RationalNumber(int numerator, int denominator)
	{
		setNumerator(numerator);
		setDenominator(denominator);
		reduceFraction();
	}


	// accesor methods
	// accesor for numerator variable
	public int getNumerator()
	{
		return numerator;
	}

	// accesor for denominator variable
	public int getDenominator()
	{
		return denominator;
	}


	// mutator methods
	// mutator for numerator
	public void setNumerator(int numerator)
	{
		this.numerator = numerator;
	}

	//mutator for denominator
	public void setDenominator (int denominator)
	{
		if(denominator != 0)
			{
			this.denominator = denominator;
			}
		else
			throw new IllegalArgumentException("Denominator must be non-zero.");
	}

	// mutator for object with int values as arguments
	public void setNumber(int numerator, int denominator)
	{
		if(denominator != 0)
			{
			this.numerator = numerator;
			this.denominator = denominator;
			reduceFraction();
			}

		else
			throw new IllegalArgumentException("Denominator must be non-zero.");
	}

	// mutator for object with RationalNumber object as argument
	public void setNumber(RationalNumber number)
	{
		this.numerator = number.getNumerator();
		this.denominator = number.getDenominator();
		reduceFraction();
	}


	// object methods
	public void reduceFraction()
	{
		for (int numerator = Math.abs(this.numerator); numerator > 1; numerator --)
			if((this.numerator % numerator) == 0 && (this.denominator % numerator) == 0)
			{
				setNumerator(this.numerator / numerator);
				setDenominator(this.denominator / numerator);
			}
	}

	// method to add a RationalNumber object to this object
	static public RationalNumber add(RationalNumber number1, RationalNumber number2 )
	{
		RationalNumber result = new RationalNumber(number1.getNumerator() * number2.getDenominator() + number1.getDenominator() * number2.getNumerator(),
				number1.getDenominator() * number2.getDenominator());
		result.reduceFraction();
		return result;
	}

	// method to substract a RationalNumber object to this object
	static public RationalNumber substract(RationalNumber number1, RationalNumber number2 )
	{
		RationalNumber result = new RationalNumber(number1.getNumerator() * number2.getDenominator() - number1.getDenominator() * number2.getNumerator(),
				number1.getDenominator() * number2.getDenominator());
		result.reduceFraction();
		return result;
	}

	static public RationalNumber multiply(RationalNumber number1, RationalNumber number2 )
	{
		RationalNumber result = new RationalNumber(number1.getNumerator() * number2.getNumerator(),
				number1.getDenominator() * number2.getDenominator());
		result.reduceFraction();
		return result;
	}

	static public RationalNumber divide(RationalNumber number1, RationalNumber number2 )
	{
		RationalNumber result = new RationalNumber(number1.getNumerator() * number2.getDenominator(),
				number1.getDenominator() * number2.getNumerator());
		result.reduceFraction();
		return result;
	}


	//toSting method
	//standard toString formating %d/%d
	public String toString()
	{
		if (denominator == 1)
			return String.format("%d",getNumerator());
		else
			return String.format("%d/%d",getNumerator(),getDenominator());
	}

	// toString method returning a float point number
	public double toFloatPoint()
	{
		return (double) getNumerator() / getDenominator();
	}
}
