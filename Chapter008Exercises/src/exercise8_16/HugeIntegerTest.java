package exercise8_16;

import java.util.Scanner;

public class HugeIntegerTest
{
	public static void main (String[] args)

	{
		Scanner keyboard = new Scanner(System.in);
		HugeInteger hi1 = new HugeInteger("12345678912345678912");
		HugeInteger hi2 = new HugeInteger("703646546785");
		//System.out.println(hi1);
		//System.out.println(hi1.isZero());
		//System.out.println("Isequal test:\n" + hi1 +"\n"  + hi1.isEqualTo(new HugeInteger ("123")));
		//System.out.println("Is " + hi1 +" greaterThan 124 test:\n" + hi1.isGreaterThan(new HugeInteger ("124")));
		//System.out.println("Is " + hi1 +" lessThan 124 test:\n" + hi1.isLessThan(new HugeInteger ("124")));
		//hi1.add(hi2);
		//System.out.println(hi1);
		//hi1.substract(hi2);
		//System.out.println(hi1);
		//hi1.multiply(hi2);
		//System.out.println(hi1);

		System.out.println(hi1.toFormatedString());
		System.out.println(hi2.toFormatedString());

		System.out.println(hi1.remainder(hi2).toFormatedString());
		System.out.println(hi1.toFormatedString());
		System.out.println();


	}
}

class HugeInteger
{
	public final int arrayLength = 40;
	public int[] integerArray = new int[arrayLength];
	private boolean positive = true;


	// no argument constructor
	HugeInteger()
	{
		this("");
	}

	// constructor with String representing the numbers(including '-' sign) as argument
	HugeInteger(String input)
	{
		if(input.length()>0)
			if(input.charAt(0) == '-')
				{
				positive = false;

				for (int index = integerArray.length - input.length() + 1; index < integerArray.length; index++)
					{
						String temp = "" + input.charAt(index - integerArray.length + input.length());

						try
						{
							integerArray[index] = Integer.parseInt(temp);
						}

						catch (NumberFormatException e)
						{
							throw new IllegalArgumentException("Please input only valid digits.");
						}
					}
				}

			else
				for (int index = integerArray.length - input.length(); index < integerArray.length; index++)
				{
					String temp = "" + input.charAt(index - integerArray.length + input.length());

					try
					{
						integerArray[index] = Integer.parseInt(temp);
					}

					catch (NumberFormatException e)
					{
						throw new IllegalArgumentException("Please input only valid digits.");
					}
				}
	}

	// constructor with HugeInteger object as argument
	HugeInteger(HugeInteger number)
	{
		this.positive = number.positive;
		for (int index = 0; index < integerArray.length; index ++)
			this.integerArray[index] = number.integerArray[index];
	}

	// constructor with HugeInteger object and char denoting positive or negative number as argument
	HugeInteger(HugeInteger number, char sign)
		{

			if (sign != '-' && sign != '+')
				throw new IllegalArgumentException("Char argument must be either '+' or '-'.");
			if (sign == '-')
				this.positive = false;
			if (sign == '+')
				this.positive = true;
			for (int index = 0; index < integerArray.length; index ++)
				this.integerArray[index] = number.integerArray[index];
		}

	// predicate methods
	// is Zero - predicate method to test if the number is zero
	public boolean isZero()
	{
		if (getFirstDigitIndex() == 39)
			return true;
		else
			return false;
	}

	// isEqualTo - predicate method with HugeInteger object as argument that tests if the two numbers coincide
	// returns true in case of equality
	public boolean isEqualTo(HugeInteger number)
	{
		boolean isEqual = true; // assume both numbers are equal

		if(positive != number.positive) // if the numbers do not have the same 'positive' variable value
			isEqual = false;
		else
			if(getFirstDigitIndex() != number.getFirstDigitIndex()) // if the numbers are not the same length
				isEqual = false;
			else
				for (int index = getFirstDigitIndex(); index < integerArray.length; index ++) // if the digits do not coincide
					if (integerArray[index]!= number.integerArray[index])
						isEqual = false;

		return isEqual;
	}

	//isNotEqual to - predicate method with HugeInteger object as argument that tests if the two numbers coincide
	// returns true in case of inequality
	public boolean isNotEqualTo(HugeInteger number)
	{
		return !isEqualTo(number);
	}

	//isGreater than - predicate method with HugeInteger object as argument that tests if current number is greater than arg number
	public boolean isGreaterThan(HugeInteger number)
	{
		boolean isGreater = false; // assume current number is smaller

		if(positive && !number.positive) // if the first no is positive and second in negative
			isGreater = true;

		if(!positive && !number.positive)
			{
				if (getFirstDigitIndex() > number.getFirstDigitIndex())
					isGreater = true;
				else
					if (getFirstDigitIndex() == number.getFirstDigitIndex())
					{
						int index = getFirstDigitIndex();
						while (index < integerArray.length)
						{
							if(integerArray[index] < number.integerArray[index])
							{
								isGreater = true;
								break;
							}

							if (integerArray[index] > number.integerArray[index])
								break;

							index++;
						}
					}
			}
		else
			{
			if(positive && number.positive)
				{
					if (getFirstDigitIndex() < number.getFirstDigitIndex())
						isGreater = true;
					else
						if (getFirstDigitIndex() == number.getFirstDigitIndex())
						{
							int index = getFirstDigitIndex();
							while (index < integerArray.length)
							{
								if(integerArray[index] > number.integerArray[index])
								{
									isGreater = true;
									break;
								}

								if (integerArray[index] < number.integerArray[index])
									break;

								index++;
							}
						}
				}
			}
		return isGreater;
	}

	//isLesser than - predicate method with HugeInteger object as argument that tests if current number is lesser than arg number
	public boolean isLessThan(HugeInteger number)
		{
			if(!isEqualTo(number))
				return (!isGreaterThan(number));
			else
				return false;

		}

	//isGreaterThanOrEqual - predicate method with HugeInteger object as argument that tests if current number is lesser than arg number
	public boolean isGreaterThanOrEqual(HugeInteger number)
	{
		return(isEqualTo(number) || isGreaterThan(number));
	}

	//isLessThanOrEqual - predicate method with HugeInteger object as argument that tests if current number is lesser than arg number
	public boolean isLessThanOrEqual(HugeInteger number)
	{
		return (isEqualTo(number) || isLessThan(number));
	}

	// mutator methods
	// mutator method to assign to this object the characteristics of another HugeInteger object
	public void setNumber(HugeInteger number)
	{
		this.positive = number.positive;
		for (int index = 0; index < integerArray.length; index ++)
			integerArray[index] = number.integerArray[index];

	}

	// mutator method to assign to this object the boolean positive characteristic
	public void setPositive(Boolean positive)
	{
		this.positive = positive;
	}

	// mutator method to add to the object another HugeInteger object provided as an argument
	public void add(HugeInteger number)
	{
		// if both numbers are either positive or negative
		if ((positive && number.positive) || (!positive && !number.positive))
			for (int index = integerArray.length - 1; index >= Math.min(getFirstDigitIndex(), number.getFirstDigitIndex());
				index --)
			{
				if((integerArray[index] + number.integerArray[index]) > 9)
					{
					integerArray[index] += (number.integerArray[index] - 10);
					integerArray[index - 1] ++;
					}
				else
					integerArray[index] += number.integerArray[index];
			}
		else
		{

			if (positive && !number.positive)
			{
				int testCase = 0;
				if (getFirstDigitIndex() == number.getFirstDigitIndex())
					testCase = 1;
				if (getFirstDigitIndex() > number.getFirstDigitIndex())
					testCase = 2;
				if (getFirstDigitIndex() < number.getFirstDigitIndex())
					testCase = 3;

				switch (testCase)
				{
				case 1:
					if (this.isGreaterThanOrEqual(new HugeInteger(number, '+')))
						for (int index = integerArray.length - 1; index >= getFirstDigitIndex(); index --)
						{
							if((integerArray[index] - number.integerArray[index]) < 0)
							{
								integerArray[index] = (integerArray[index] + 10 - number.integerArray[index]);
								integerArray[index - 1] --;
							}
							else
								integerArray[index] = integerArray[index] - number.integerArray[index];
						}
					else
					{
						this.positive = false;
						for (int index = integerArray.length - 1; index >= getFirstDigitIndex(); index --)
						{
							if((number.integerArray[index] - integerArray[index]) < 0)
							{
								integerArray[index] = (number.integerArray[index] + 10 - integerArray[index]);
								integerArray[index - 1] ++;
							}
							else
								integerArray[index] = number.integerArray[index] - integerArray[index];
						}
					}
					break;
					// end case 1

				case 2:
					positive = false;
					for (int index = integerArray.length - 1; index >= number.getFirstDigitIndex(); index --)
					{

						if((number.integerArray[index] - integerArray[index]) < 0)
						{
							this.integerArray[index] = (number.integerArray[index] + 10 - this.integerArray[index]);
							this.integerArray[index - 1] ++;

						}
						else
						{

							this.integerArray[index] = (number.integerArray[index] - this.integerArray[index]);
						}

					}
					break;
					// end case 2

				case 3:
					for (int index = integerArray.length - 1; index >= number.getFirstDigitIndex(); index --)
					{
						if((integerArray[index] - number.integerArray[index]) < 0)
						{
							integerArray[index] = (integerArray[index] + 10 - number.integerArray[index]);
							integerArray[index - 1] --;
						}
						else
							integerArray[index] = integerArray[index] - number.integerArray[index];
					}
					break;
					// end case 3
				} // end switch

			}// end if (positive && !number.positive)

			else
			if (!positive && number.positive)
			{
				int testCase = 0;
				if (getFirstDigitIndex() == number.getFirstDigitIndex())
					testCase = 1;
				if (getFirstDigitIndex() < number.getFirstDigitIndex())
					testCase = 2;
				if (getFirstDigitIndex() > number.getFirstDigitIndex())
					testCase = 3;


				switch (testCase)
				{
				case 1:
					if (number.isLessThan(new HugeInteger(this, '+')))
					{

						for (int index = integerArray.length - 1; index >= getFirstDigitIndex(); index --)
						{
							if((integerArray[index] - number.integerArray[index]) < 0)
							{
								integerArray[index] = (integerArray[index] + 10 - number.integerArray[index]);
								integerArray[index - 1] --;
							}
							else
								integerArray[index] = integerArray[index] - number.integerArray[index];
						}
					}
					else
					{
						this.positive = true;
						for (int index = integerArray.length - 1; index >= getFirstDigitIndex(); index --)
						{
							if((number.integerArray[index] - integerArray[index]) < 0)
							{
								integerArray[index] = (number.integerArray[index] + 10 - integerArray[index]);
								integerArray[index - 1] ++;
							}
							else
								integerArray[index] = number.integerArray[index] - integerArray[index];
						}
					}
					break;
					// end case 1

				case 2:
					for (int index = integerArray.length - 1; index >= number.getFirstDigitIndex(); index --)
					{

						if((number.integerArray[index] - integerArray[index]) < 0)
						{
							this.integerArray[index] = (number.integerArray[index] + 10 - this.integerArray[index]);
							this.integerArray[index - 1] ++;

						}
						else
						{

							this.integerArray[index] = (number.integerArray[index] - this.integerArray[index]);
						}

					}
					break;
					// end case 2

				case 3:
					positive = true;
					for (int index = integerArray.length - 1; index >= number.getFirstDigitIndex(); index --)
					{
						if((number.integerArray[index] - integerArray[index]) < 0)
						{
							integerArray[index] = (number.integerArray[index] + 10 - integerArray[index]);
							integerArray[index - 1] ++;
						}
						else
							integerArray[index] = number.integerArray[index] - integerArray[index];
					}
					break;
					// end case 3
				} // end switch

			}
		} // end else
	}// end add method

	// mutator method to substract from this object another HugeInteger object provided as argument
	public void substract (HugeInteger number)
	{
		if (number.positive == false)
			this.add(new HugeInteger(number,'+'));
		else
			this.add(new HugeInteger(number,'-'));
	}

	// mutator method to multiply the object with another HugeInteger object provided as an argument
	public void multiply(HugeInteger number)
	{
		// determine if new number is greater than max no that can be stored into a HugeInteger object
		if(integerArray.length - this.getFirstDigitIndex() + number.integerArray.length - number.getFirstDigitIndex() >
		integerArray.length)
			System.out.println("Unable to multiply the two HugeInteger objects. "
					+ "Result would be bigger than the maximum number storable in a HugeInteger object.");
		else
		{
			HugeInteger result = new HugeInteger();

			int offset = 0;
			//multiply the two numbers
			for(int index1 = number.arrayLength - 1;
					index1 >=  Math.min(number.getFirstDigitIndex(),getFirstDigitIndex()); index1 --)
				{
				HugeInteger temp = new HugeInteger();

				for(int index2 = arrayLength - 1;
						index2 >= Math.min(number.getFirstDigitIndex(),getFirstDigitIndex()); index2 --)
					{

						if(number.integerArray[index1] * integerArray[index2] >= 10)
						{
							temp.integerArray[index2 - offset - 1] +=
									(number.integerArray[index2] * integerArray[index1]) / 10;
							temp.integerArray[index2 - offset] +=
									(number.integerArray[index2] * integerArray[index1]) % 10;

							if (temp.integerArray[index2 - offset] >= 10)
							{
								temp.integerArray[index2 - offset - 1] +=
										temp.integerArray[index2 - offset] / 10;
								temp.integerArray[index2 - offset] =
										temp.integerArray[index2 - offset] % 10;
							}


						}
						else
						{
							temp.integerArray[index2 - offset] +=
								(number.integerArray[index2] * integerArray[index1]);

							if (temp.integerArray[index2 - offset] >= 10)
							{
								temp.integerArray[index2 - offset - 1] +=
										temp.integerArray[index2 - offset] / 10;
								temp.integerArray[index2 - offset] =
										temp.integerArray[index2 - offset] % 10;
							}
						}

					}

				result.add(temp);
				offset ++;
				}

			// assign the positive characteristic of the result
			if((this.positive && number.positive) || (!this.positive && !number.positive))
				this.setNumber(result);
			else
				{
				result.setPositive(false);
				this.setNumber(result);
				}

		}

	}

	// mutator method to divide the object by another HugeInteger object provided as an argument
	public void divide(HugeInteger number)
	{
		int testCase = 0;
		if (absoluteValue(this).isGreaterThan(absoluteValue(number)))
			testCase = 1;
		if (absoluteValue(this).isEqualTo(absoluteValue(number)))
			testCase = 2;
		if (absoluteValue(this).isLessThan(absoluteValue(number)))
			testCase = 3;

		HugeInteger remainder = new HugeInteger();

		switch(testCase)
		{


		case 1:
			boolean keepDividing = true;

			HugeInteger dividend = new HugeInteger(this,'+');
			HugeInteger divisor = new HugeInteger(number,'+');
			HugeInteger resultInteger = new HugeInteger();
			int offset = 0;

			while (keepDividing)
			{
				if(this.getFirstDigitIndex() == number.getFirstDigitIndex())
				{
					int result = 1;
					while (keepDividing)
					{
						dividend.substract(divisor);
						if(dividend.positive == true)
							result++;
						else
						{
							dividend.add(divisor);
							result --;
							keepDividing = false;
						}

					}

					remainder.setNumber(dividend);
					remainder.setPositive(this.positive);
					if ((this.positive && number.positive) || (!this.positive && !number.positive))
						this.setNumber(new HugeInteger(String.format("%d", result)));
					else
						this.setNumber(new HugeInteger(String.format("-%d", result)));
				}

				else
				{

					for (int i = 0; i < number.getFirstDigitIndex() - this.getFirstDigitIndex() - offset; i++)
					divisor.multiply(new HugeInteger("10"));

					if(dividend.isGreaterThanOrEqual(divisor))
					{

						boolean keepDividingStep = true;
						int result = 1;
						while (keepDividingStep)
						{
							dividend.substract(divisor);
							if(dividend.positive == true)
								result++;
							else
							{
								dividend.add(divisor);
								result --;
								keepDividingStep = false;
							}


						}

						HugeInteger stepInteger = new HugeInteger(String.format("%d",result));

						for (int i = 0; i < number.getFirstDigitIndex() - this.getFirstDigitIndex() - offset; i++)
						stepInteger.multiply(new HugeInteger("10"));

						resultInteger.add(stepInteger);
						divisor.setNumber(new HugeInteger(number,'+'));
						offset++;

					}

					else
						{

						offset ++;
						divisor.setNumber(new HugeInteger(number,'+'));
						}

					if (offset > number.getFirstDigitIndex() - this.getFirstDigitIndex())
						{
						keepDividing = false;

						if ((this.positive && number.positive) || (!this.positive && !number.positive))
							this.setNumber(resultInteger);
						else
							{
							resultInteger.setPositive(false);
							this.setNumber(resultInteger);
							}

						remainder.setNumber(dividend);
						remainder.setPositive(this.positive);

						}
				}

			}


			break;

		// if current number has the same absolute value as the divisor`s absolute value
		case 2:
			if((this.positive == true && number.positive == true) || (!this.positive && !number.positive))
				this.setNumber(new HugeInteger(new HugeInteger("1"),'+'));
			else
				this.setNumber(new HugeInteger(new HugeInteger("1"),'-'));
			break;

		// if current number`s absolute value is smaller than the divisor`s absolute value, result is 0
		case 3:
			remainder.setNumber(this);
			this.setNumber(new HugeInteger());
			break;

		}
	}

	// method to generate a HugeInteger object representing the remainder operation of this object
	// and another HugeInteger object
	public HugeInteger remainder(HugeInteger number)
	{
		HugeInteger number1 = new HugeInteger(this);
		HugeInteger number2  = new HugeInteger(number);


		int testCase = 0;
		if (absoluteValue(number1).isGreaterThan(absoluteValue(number2)))
			testCase = 1;
		if (absoluteValue(number1).isEqualTo(absoluteValue(number2)))
			testCase = 2;
		if (absoluteValue(number1).isLessThan(absoluteValue(number2)))
			testCase = 3;

		HugeInteger remainder = new HugeInteger();

		switch(testCase)
		{


		case 1:
			boolean keepDividing = true;

			HugeInteger dividend = new HugeInteger(number1,'+');
			HugeInteger divisor = new HugeInteger(number2,'+');
			HugeInteger resultInteger = new HugeInteger();
			int offset = 0;

			while (keepDividing)
			{
				if(number1.getFirstDigitIndex() == number2.getFirstDigitIndex())
				{

					while (keepDividing)
					{
						dividend.substract(divisor);
						if(dividend.positive != true)
						{
							dividend.add(divisor);
							keepDividing = false;
						}

					}

					remainder.setNumber(dividend);
					remainder.setPositive(number1.positive);

				}

				else
				{

					for (int i = 0; i < number2.getFirstDigitIndex() - number1.getFirstDigitIndex() - offset; i++)
					divisor.multiply(new HugeInteger("10"));

					if(dividend.isGreaterThanOrEqual(divisor))
					{

						boolean keepDividingStep = true;
						int result = 1;
						while (keepDividingStep)
						{
							dividend.substract(divisor);
							if(dividend.positive == true)
								result++;
							else
							{
								dividend.add(divisor);
								result --;
								keepDividingStep = false;
							}


						}

						HugeInteger stepInteger = new HugeInteger(String.format("%d",result));

						for (int i = 0; i < number.getFirstDigitIndex() - this.getFirstDigitIndex() - offset; i++)
						stepInteger.multiply(new HugeInteger("10"));

						resultInteger.add(stepInteger);
						divisor.setNumber(new HugeInteger(number,'+'));
						offset++;

					}

					else
						{

						offset ++;
						divisor.setNumber(new HugeInteger(number,'+'));
						}

					if (offset > number.getFirstDigitIndex() - this.getFirstDigitIndex())
						{
						keepDividing = false;

						remainder.setNumber(dividend);
						remainder.setPositive(this.positive);

						}
				}

			}


			break;

		// if current number has the same absolute value as the divisor`s absolute value
		case 2:
			break;

		// if current number`s absolute value is smaller than the divisor`s absolute value, result is 0
		case 3:
			remainder.setNumber(number1);
			break;

		}

		return remainder;

	}


	// accesor methods
	// accesor method to provide the absolute value of a HugeInteger object
	public static HugeInteger absoluteValue(HugeInteger number)
	{
		return new HugeInteger(number,'+');
	}

	// method to return the array index where the first digit was inserted
	public int getFirstDigitIndex()
	{
		int firstIndex = 0;

		while (firstIndex < 39 && integerArray[firstIndex] == 0)
			firstIndex ++;

		return firstIndex;
	}

	// toString method
	public String toString()
	{

		String output = "";

		for (int index = integerArray.length - 1; index >= getFirstDigitIndex(); index--)
			{
				output = this.integerArray[index] + output;
			}

		if (!this.positive)
			output = "-" + output;

		return output;
	}


	// toFormatedString method
	public String toFormatedString()
	{

		String output = "";

		for (int index = integerArray.length - 1; index >= getFirstDigitIndex(); index--)
			{
				if(index != 39 && index % 3 == 0)
					output = "." + output;
				output = this.integerArray[index] + output;
			}

		if (!this.positive)
			output = "-" + output;

		return output;
	}

}