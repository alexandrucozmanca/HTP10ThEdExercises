package exercise8_13;

public class IntegerSetTest
{

	public static void main (String [] args)
	{
		int [] test = {3, 5, 8};
		int [] test1 = {2, 5, 7};
		IntegerSet set = new IntegerSet(10,test);
		IntegerSet set1 = new IntegerSet(9,test);

		System.out.println(set.isEqualTo(set1));
		System.out.println(set);
		System.out.println(set1);
	}

}

class IntegerSet
{
	public final int setLength;
	public boolean[] integerSet;

	//constructors
	// no argument constructor
	IntegerSet()
	{
		setLength = 100;
		integerSet = new boolean[setLength];
	}

	// constructor with set length argument
	IntegerSet(int setLength)
	{
		this.setLength = setLength;
		integerSet = new boolean[this.setLength];
	}

	// constructor with variable length arguments - representing which integers are present in the set
	IntegerSet(int... indexes)

	{
		int setLength = 0;

		for (int i: indexes)
			if (i > setLength)
				setLength = i;

		this.setLength = setLength + 1 ;

		integerSet = new boolean[setLength + 1];
		for (int i : indexes)
			integerSet[i] = true;
	}

	// constructor with set length argument and variable length arguments - representing which integers are present in the set
	IntegerSet(int setLength, int[] indexes)
	{
		int maxValue = 0;
		for (int i = 0; i < indexes.length; i ++)
			if (indexes[i] > maxValue)
				maxValue = indexes[i];
		if (setLength < maxValue - 1)
			throw new IllegalArgumentException("Set length is smaller that no of arguments");

		this.setLength = setLength;
		integerSet = new boolean[setLength];
		for (int i : indexes)
			integerSet[i] = true;
	}

	// constructor with an IntegerSet object as argument
	IntegerSet(IntegerSet set)

	{
		this.setLength = set.setLength;
		integerSet = new boolean[setLength];

		for(int index = 0; index < setLength; index ++)
			integerSet[index] = set.integerSet[index];
	}

	// method to insert element in the set
	public void insertElement(int number)
	{
		if (number < 0 || number + 1 > setLength )
			throw new IllegalArgumentException("Argument is out of bounds of integer set");
		integerSet[number] = true;
	}

	// method to delete element from the set
	public void deleteElement(int number)
	{
		if (number < 0 || number + 1 > setLength )
			throw new IllegalArgumentException("Argument is out of bounds of integer set");
		integerSet[number] = false;
	}

	// method to create a new IntegerSet object representing the union of two other IntegerSet objects
	public static IntegerSet union(IntegerSet set1, IntegerSet set2)
	{
		int unionLength = set1.setLength;
		if (unionLength < set2.setLength)
			unionLength = set2.setLength;

		IntegerSet unionSet = new IntegerSet(unionLength);

		for (int index = 0; index < unionLength; index ++)
		{
			try
			{
				if (set1.integerSet[index] == true)
					unionSet.integerSet[index] = true;
			}

			catch (IndexOutOfBoundsException e)
			{

			}

			try
			{
				if (set2.integerSet[index] == true)
					unionSet.integerSet[index] = true;
			}

			catch (IndexOutOfBoundsException e)
			{

			}
		}

		return unionSet;
	}

	// method to create a new IntegerSet object representing the intersection of two other IntegerSet objects
	public static IntegerSet intersection(IntegerSet set1, IntegerSet set2)
	{
		int unionLength = set1.setLength;
		int testLength = set2.setLength;
		if (unionLength < set2.setLength)
			{
			unionLength = set2.setLength;
			testLength = set1.setLength;
			}

		IntegerSet intersectionSet = new IntegerSet(unionLength);

		for (int index = 0; index < testLength; index ++)
			if (set1.integerSet[index] == true && set2.integerSet[index] == true)
				intersectionSet.integerSet[index] = true;

		return intersectionSet;
	}

	// method to compare a IntegerSet object and determine if the two sets coincide
	public boolean isEqualTo(IntegerSet compare)
	{
		boolean isEqualTo = true;

		if (setLength != compare.setLength)
			isEqualTo = false;
		else
			for (int index = 0; index < setLength; index++)
				if (integerSet[index] != compare.integerSet[index])
					isEqualTo = false;

		return isEqualTo;
	}

	// toString method
	public String toString()
	{
		String toString = "";
		for(int index = 0; index < setLength; index++)
			if (integerSet[index] == true)
				toString = toString + String.format("%d",index);
			else
				toString = toString + "-";
		toString = toString + String.format("%n");
		return toString;
	}
}