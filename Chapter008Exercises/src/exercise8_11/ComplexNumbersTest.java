package exercise8_11;

public class ComplexNumbersTest
{

	public static void main(String[] args)
	{
		ComplexNumber n1 = new ComplexNumber();
		ComplexNumber n2 = new ComplexNumber(1.2,2.3);
		ComplexNumber n3 = new ComplexNumber(0.2,0.3);

		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);

		n1.add(n3);
		n2.substract(n3);

		System.out.println(n1);
		System.out.println(n2);
	}
}

class ComplexNumber
{
	private double realPart;
	private double imaginaryPart;

	// constructors
	// no argument constructor
	ComplexNumber()
	{
		this(0,0);
	}

	// constructor with given values
	ComplexNumber(double realPart, double imaginaryPart)
	{
		setRealPart(realPart);
		setImaginaryPart(imaginaryPart);
	}

	// constructor with object provided
	ComplexNumber(ComplexNumber number)
	{
		this(number.getRealPart(), number.getImaginaryPart());
	}

	// accesor methods
	// accesor for realPart
	public double getRealPart()
	{
		return realPart;
	}

	// accesor for imaginary part
	public double getImaginaryPart()
	{
		return imaginaryPart;
	}

	// mutator methods
	// mutator for realPart
	private void setRealPart(double realPart)
	{
		this.realPart = realPart;
	}

	// mutator for imaginaryPart
	private void setImaginaryPart(double imaginaryPart)
	{
		this.imaginaryPart = imaginaryPart;
	}

	// add a given complex number
	public void add(ComplexNumber number)
	{
		setRealPart(getRealPart() + number.getRealPart());
		setImaginaryPart(getImaginaryPart() + number.getImaginaryPart());
	}

	// substract a given complex number
	public void substract(ComplexNumber number)
	{
		setRealPart(getRealPart() - number.getRealPart());
		setImaginaryPart(getImaginaryPart() - number.getImaginaryPart());
	}

	// to string
	public String toString()
	{
		return String.format("(%.2f,%.2f)",getRealPart(),getImaginaryPart());
	}

}