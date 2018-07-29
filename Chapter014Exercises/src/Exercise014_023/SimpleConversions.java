package Exercise014_023;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SimpleConversions
{

	public static void main(String[] args)
	{
		try
		{
			ImperialMetricConvertor convertor = new ImperialMetricConvertor("How many liters are there in 10.45 cups");

			try
			{
				convertor.answerQuestion();
			}

			catch(Exception e)
			{
				System.out.println(e.getLocalizedMessage());
			}
		}

		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}




	}
}

class ImperialMetricConvertor
{
	// fixed instance variables denoting conversion MODES
	final static int imperialToImperial = 0;
	final static int imperialToMetric = 1;
	final static int metricToImperial = 2;
	final static int metricToMetric = 3;

	// base values conversions
	final static double baseImperialToMetricLengthConversion = 25.4; // milimeters in a inch
	final static double baseImperialToMetricVolumeConversion = 5.91936; // mililiters in a teaspoon
	final static double baseImperialToMetricWeightConversion = 28349.5; // miligrams in an ounce

	// accepted imperial length units and values compared to base value inch
	final static String[] imperialLength = new String[] {"mile", "furlong", "chain", "yard", "foot", "feet", "inch", "inches"};
	final static int[] imperialLengthValues = new int[] {63360, 7920, 792, 36, 12, 12, 1, 1}; // inches in each length unit

	// accepted imperial volume units and values compared to base value teaspoon
	final static String[] imperialVolume = new String[] {"gallon", "quart", "pint", "cup", "ounce", "tablespoon", "teaspoon"};
	final static double[] imperialVolumeValues = new double[] {768, 192, 96, 48, 4.8, 3, 1}; // teaspoons in each volume unit

	// accepted imperial weight units and values compared to base value ounce
	final static String[] imperialWeight = new String[] {"ton", "stone", "pound", "ounce"};
	final static int[] imperialWeightValues = new int[] {35840, 224, 16, 1}; // ounces in each weight unit

	// accepted metric units and values compared to base value
	final static String[] metricLength = new String[] {"kilometer", "hectometer", "decameter", "meter", "decimeter", "centimeter", "milimeter"};
	final static String[] metricVolume = new String[] {"kiloliter", "hectoliter", "decaliter", "liter", "deciliter", "centiliter", "mililiter"};
	final static String[] metricWeight = new String[] {"kilogram", "hectogram", "decagram", "gram", "decigram", "centigram", "miligram"};
	// base unit (milimeter, mililiter or miligram in each respective unit
	final static int[] metricValues = new int[] {1000000, 100000, 10000, 1000, 100, 10, 1};

	// formating for answer double
	NumberFormat nf = new DecimalFormat("##.####");

	private String question;

	static enum ConversionType
	{
		LENGTH, VOLUME, WEIGHT, NULL;
	}

	// no argument constructor
	ImperialMetricConvertor()
	{
		this("");
	}

	ImperialMetricConvertor(String question)
	{
		setQuestion(question);
	}


	// mutator method for question variable
	public void setQuestion(String question) throws IllegalArgumentException
	{
		if (question == null || question.length() == 0)
			throw new IllegalArgumentException("Question string is null or contains no characters");
		this.question = question;
	}

	public void answerQuestion() throws IllegalArgumentException
	{
		// split sentence into words
		String[] questionArray = question.split(" ");

		final int unitsAreLength = 0;
		final int unitsAreVolume = 1;
		final int unitsAreWeight = 2;

		// string 2D array containing all possible metric units
		String[][] metricUnits = new String[3][];
		metricUnits[unitsAreLength] = metricLength;
		metricUnits[unitsAreVolume] = metricVolume;
		metricUnits[unitsAreWeight] = metricWeight;

		// string 2D array containing all possible imperial units
		String[][] imperialUnits = new String[3][];
		imperialUnits[unitsAreLength] = imperialLength;
		imperialUnits[unitsAreVolume] = imperialVolume;
		imperialUnits[unitsAreWeight] = imperialWeight;

		// instance variables used as arguments for class methods
		String firstUnit = "";
		String secondUnit = "";
		double secondUnitQuantity; // instance variable used as argument for class methods

		boolean firstUnitIdentified = false; // gatekeeper variable to denote that the firstunit has been identified
		boolean secondUnitIdentified = false;// gatekeeper variable to denote that the secondunit has been identified

		int conversionMode = 0; // instance variable used as argument for class methods
		ConversionType conversion = ConversionType.NULL; // local variable to determine which method will be invoked for the conversion process

		// we assume that the user poses the question in such a way that the last word is a unit of measurement
		//and the next to last word is a quantity of that unit of measurement

		// test last word
		String tempString = questionArray[questionArray.length - 1];


		// edit last word to eliminate any extra characters (punctuation, numbers, etc)
		while (!Character.isLetter(tempString.charAt(tempString.length() - 1)))
		{
			//trim string to exclude last character
			tempString = tempString.substring(0, tempString.length() - 2);


			//if string becomes empty
			if (tempString.length() == 0)
			{
				throw new IllegalArgumentException("Last word is invalid - contains no letters");
			}

		}

		// test last word against 2D Unit Arrays
		for (int unitType = 0; unitType < metricUnits.length; unitType++)
		{
			for(int unit = 0; unit < metricUnits[unitType].length; unit++)
			{

				// test if last word in sentence is a metric unit
				if(tempString.equals(metricUnits[unitType][unit]) ||
					tempString.equals(String.format("%ss", metricUnits[unitType][unit])))
				{

					secondUnit = tempString; // assign value to instance variable for later use
					secondUnitIdentified = true; // update gatekeeper

					conversionMode = 2; // intermediary value to denote that last unit is metric

					// update instance variable based on unit type
					switch(unitType)
					{
					case 0:
						conversion = ConversionType.LENGTH;
						break;

					case 1:
						conversion = ConversionType.VOLUME;
						break;

					case 2:
						conversion = ConversionType.WEIGHT;
						break;
					}

					break;
				}
			}

			if(secondUnitIdentified == true)
				break;

		}

		// test last word against 2D Unit Arrays
		for (int unitType = 0; unitType < imperialUnits.length; unitType++)
		{
			for(int unit = 0; unit < imperialUnits[unitType].length; unit++)
			{

				// test if last word in sentence is an Imperial unit
				if(tempString.equals(imperialUnits[unitType][unit]) ||
					tempString.equals(String.format("%ss", imperialUnits[unitType][unit])))
				{
					secondUnit = tempString; // assign value to instance variable for later use
					secondUnitIdentified = true; // update gatekeeper

					conversionMode = 0; // intermediary value to denote that last unit is imperial

					// initialize instance variable based on unit type
					switch(unitType)
					{
						case 0:
							conversion = ConversionType.LENGTH;
							break;

						case 1:
							conversion = ConversionType.VOLUME;
							break;

						case 2:
						conversion = ConversionType.WEIGHT;
						break;
					}

					break;

				}

			}
			// break loop if secondunit identified
			if(secondUnitIdentified)
				break;
		}



		// if last word is neither metric nor imperial
		if(!secondUnitIdentified)
			throw new IllegalArgumentException("Last word is not a valid metric or Imperial unit!");

		// check quantity of secondUnit and initialize variable
		// check for non numeric values "a" or "an"
		if (questionArray[questionArray.length - 2].equals("a") ||
		       questionArray[questionArray.length - 2].equals("an"))
			secondUnitQuantity = 1; // update instance variable for particular case

		else
		{
			try
			{
				secondUnitQuantity = Double.parseDouble(questionArray[questionArray.length - 2]); //update instance variable
			}

			catch(NumberFormatException e)
			{	// throw exception if no quantity can be identified
				throw new IllegalArgumentException("Next to last word does not contain a valid quantity");
			}
		}

		// accept even extremely short questions of type "unit quantity unit"
		// check all words but the last two in order to identify firstUnit word (if any) and assign unitArray
		for (int word = 0; word < questionArray.length - 2; word++)
		{
			// test each word
			tempString = questionArray[word];


			// edit each word to eliminate any extra characters (punctuation, numbers, etc)
			while (!Character.isLetter(tempString.charAt(tempString.length() - 1)))
			{
				tempString = tempString.substring(0, tempString.length() - 2);
				if (tempString.length() == 0)
					break;
			}



			// skip words invalidated by character elimination
			if(tempString.length() == 0)
				continue;

			for (int unitType = 0; unitType < metricUnits.length; unitType++)
			{
				for(int unit = 0; unit < metricUnits[unitType].length; unit++)

				{
					// test if current word in sentence is a metric unit
					if(tempString.equals(metricUnits[unitType][unit]) ||
						tempString.equals(String.format("%ss", metricUnits[unitType][unit])))
					{
						firstUnit = tempString; // assign value to instance variable for later use
						firstUnitIdentified = true; // update gatekeeper

						conversionMode += 1; // final value to be used as argument for class methods

						// test match between the two unit types
						switch(conversion)
						{
						case LENGTH:
							if(unitType != unitsAreLength)
								throw new IllegalArgumentException(
										"First unit(" + firstUnit +") can not convert to second unit(" + secondUnit +
										"), it is not a Length unit.");
							break;

						case VOLUME:
							if(unitType != unitsAreVolume)
								throw new IllegalArgumentException(
										"First unit(" + firstUnit +") can not convert to second unit(" + secondUnit +
										"), it is not a Volume unit.");
							break;

						case WEIGHT:
							if(unitType != unitsAreWeight)
								throw new IllegalArgumentException(
										"First unit(" + firstUnit +") can not convert to second unit(" + secondUnit +
										"), it is not a Weight unit.");
							break;
						}

						break;
					}


				}

				if (firstUnitIdentified)
					break;
			}


			for (int unitType = 0; unitType < imperialUnits.length; unitType++)
			{
				for(int unit = 0; unit < imperialUnits[unitType].length; unit++)
				{
					// test if current word in sentence is an Imperial unit
					if(tempString.equals(imperialUnits[unitType][unit]) ||
							tempString.equals(String.format("%ss", imperialUnits[unitType][unit])))
					{
						firstUnit = tempString; // assign value to instance variable for later use
						firstUnitIdentified = true; // update gatekeeper

						conversionMode += 0; // final value to be used as argument for class methods

						// test match between the two unit types
						switch(conversion)
						{
							case LENGTH:
								if(unitType != unitsAreLength)
									throw new IllegalArgumentException(
											"First unit(" + firstUnit +") can not convert to second unit(" + secondUnit +
										"), it is not a Length unit.");
								break;

							case VOLUME:
								if(unitType != unitsAreVolume)
									throw new IllegalArgumentException(
											"First unit(" + firstUnit +") can not convert to second unit(" + secondUnit +
										"), it is not a Volume unit.");
								break;

							case WEIGHT:
								if(unitType != unitsAreWeight)
									throw new IllegalArgumentException(
											"First unit(" + firstUnit +") can not convert to second unit(" + secondUnit +
										"), it is not a Weight unit.");
								break;
						}

						break;
					}


				}
					// break loop if firstunit found
					if(firstUnitIdentified)
						break;
			}
		}


		if(!firstUnitIdentified)
			throw new IllegalArgumentException("Sentence does not contain an identifiable first unit.");

		switch(conversion)
		{
		case LENGTH:
			System.out.println(convertLength(firstUnit, secondUnitQuantity, secondUnit, conversionMode));
			break;

		case VOLUME:
			System.out.println(convertVolume(firstUnit, secondUnitQuantity, secondUnit, conversionMode));
			break;

		case WEIGHT:
			System.out.println(convertWeight(firstUnit, secondUnitQuantity, secondUnit, conversionMode));
			break;
		}




	}

	// method for length conversion
	public String convertLength(String firstUnit, double secondUnitQuantity, String secondUnit, int conversionMode)
	{
		String answer = ""; // initialize string variable containing the answer

		// initialize basevalue variables
		double firstUnitBaseValue = 0;
		double secondUnitBaseValue = 0;

		switch(conversionMode)
		{

			case imperialToImperial:

				for (int i = 0; i< imperialLength.length; i ++)
				{
					if(firstUnit.equals(imperialLength[i]) || firstUnit.equals(String.format("%ss", imperialLength[i])))
						firstUnitBaseValue = imperialLengthValues[i];
					if(secondUnit.equals(imperialLength[i]) || secondUnit.equals(String.format("%ss", imperialLength[i])))
						secondUnitBaseValue = imperialLengthValues[i] * secondUnitQuantity;
				}

				answer = String.format("There are %s %s in %.2f %s.", nf.format((secondUnitBaseValue / firstUnitBaseValue)),
						firstUnit, secondUnitQuantity, secondUnit);
				break;


			case imperialToMetric:

				for (int i = 0; i< metricLength.length; i ++)
					if(firstUnit.equals(metricLength[i]) || firstUnit.equals(String.format("%ss", metricLength[i])))
						firstUnitBaseValue = metricValues[i];
				for (int i = 0; i < imperialLength.length; i++)
					if(secondUnit.equals(imperialLength[i]) || secondUnit.equals(String.format("%ss", imperialLength[i])))
						secondUnitBaseValue = imperialLengthValues[i] * secondUnitQuantity;

				answer = String.format("There are %s %s in %.2f %s.",
						nf.format((secondUnitBaseValue * baseImperialToMetricLengthConversion / firstUnitBaseValue)),
						firstUnit, secondUnitQuantity, secondUnit);
				break;

			case metricToImperial:
				for (int i = 0; i< imperialLength.length; i ++)
					if(firstUnit.equals(imperialLength[i]) || firstUnit.equals(String.format("%ss", imperialLength[i])))
						firstUnitBaseValue = imperialLengthValues[i];
				for (int i = 0; i < metricLength.length; i++)
					if(secondUnit.equals(metricLength[i]) || secondUnit.equals(String.format("%ss", metricLength[i])))
						secondUnitBaseValue = metricValues[i] * secondUnitQuantity;

				answer = String.format("There are %s %s in %.2f %s.",
						nf.format((secondUnitBaseValue / (firstUnitBaseValue * baseImperialToMetricLengthConversion))),
						firstUnit, secondUnitQuantity, secondUnit);
				break;

			case metricToMetric:
				for (int i = 0; i< metricLength.length; i ++)
				{
					if(firstUnit.equals(metricLength[i]) || firstUnit.equals(String.format("%ss", metricLength[i])))
						firstUnitBaseValue = metricValues[i];
					if(secondUnit.equals(metricLength[i]) || secondUnit.equals(String.format("%ss", metricLength[i])))
						secondUnitBaseValue = metricValues[i] * secondUnitQuantity;
				}

				answer = String.format("There are %s %s in %.2f %s.", nf.format((secondUnitBaseValue / firstUnitBaseValue)), 
						firstUnit, secondUnitQuantity, secondUnit);
				break;

		}

		return answer;
	}

	// method for volume conversion
	public String convertVolume(String firstUnit, double secondUnitQuantity, String secondUnit, int conversionMode)
	{
		String answer = ""; // initialize string variable containing the answer

		double firstUnitBaseValue = 0;
		double secondUnitBaseValue = 0;

		switch(conversionMode)
		{

			case imperialToImperial:
				for (int i = 0; i< imperialVolume.length; i ++)
				{
					if(firstUnit.equals(imperialVolume[i]) || firstUnit.equals(String.format("%ss", imperialVolume[i])))
						firstUnitBaseValue = imperialVolumeValues[i];
					if(secondUnit.equals(imperialVolume[i]) || secondUnit.equals(String.format("%ss", imperialVolume[i])))
						secondUnitBaseValue = imperialVolumeValues[i] * secondUnitQuantity;
				}

				answer = String.format("There are %s %s in %.2f %s.", nf.format((secondUnitBaseValue / firstUnitBaseValue)), 
						firstUnit, secondUnitQuantity, secondUnit);
				break;


			case imperialToMetric:
				for (int i = 0; i< metricVolume.length; i ++)
					if(firstUnit.equals(metricVolume[i]) || firstUnit.equals(String.format("%ss", metricVolume[i])))
						firstUnitBaseValue = metricValues[i];
				for (int i = 0; i < imperialVolume.length; i++)
					if(secondUnit.equals(imperialVolume[i]) || secondUnit.equals(String.format("%ss", imperialVolume[i])))
						secondUnitBaseValue = imperialVolumeValues[i] * secondUnitQuantity;

				answer = String.format("There are %s %s in %.2f %s.",
						(secondUnitBaseValue * baseImperialToMetricVolumeConversion / firstUnitBaseValue),
						firstUnit, secondUnitQuantity, secondUnit);
				break;

			case metricToImperial:
				for (int i = 0; i< imperialVolume.length; i ++)
					if(firstUnit.equals(imperialVolume[i]) || firstUnit.equals(String.format("%ss", imperialVolume[i])))
						firstUnitBaseValue = imperialVolumeValues[i];
				for (int i = 0; i < metricVolume.length; i++)
					if(secondUnit.equals(metricVolume[i]) || secondUnit.equals(String.format("%ss", metricVolume[i])))
						secondUnitBaseValue = metricValues[i] * secondUnitQuantity;

				answer = String.format("There are %s %s in %.2f %s.",
						nf.format((secondUnitBaseValue / (firstUnitBaseValue * baseImperialToMetricVolumeConversion))),
						firstUnit, secondUnitQuantity, secondUnit);
				break;

			case metricToMetric:
				for (int i = 0; i< metricVolume.length; i ++)
				{
					if(firstUnit.equals(metricVolume[i]) || firstUnit.equals(String.format("%ss", metricVolume[i])))
						firstUnitBaseValue = metricValues[i];
					if(secondUnit.equals(metricVolume[i]) || secondUnit.equals(String.format("%ss", metricVolume[i])))
						secondUnitBaseValue = metricValues[i] * secondUnitQuantity;
				}

				answer = String.format("There are %s %s in %.2f %s.", nf.format((secondUnitBaseValue / firstUnitBaseValue)), 
						firstUnit, secondUnitQuantity, secondUnit);
				break;

			}
			return answer;
		}

	// method for weight conversion
	public String convertWeight(String firstUnit, double secondUnitQuantity, String secondUnit, int conversionMode)
	{
		String answer = ""; // initialize string variable containing the answer

		double firstUnitBaseValue = 0;
		double secondUnitBaseValue = 0;

		switch(conversionMode)
		{

			case imperialToImperial:
				for (int i = 0; i< imperialWeight.length; i ++)
				{
					if(firstUnit.equals(imperialWeight[i]) || firstUnit.equals(String.format("%ss", imperialWeight[i])))
						firstUnitBaseValue = imperialWeightValues[i];
					if(secondUnit.equals(imperialWeight[i]) || secondUnit.equals(String.format("%ss", imperialWeight[i])))
						secondUnitBaseValue = imperialWeightValues[i] * secondUnitQuantity;
				}

				answer = String.format("There are %s %s in %.2f %s.", nf.format((secondUnitBaseValue / firstUnitBaseValue)), 
						firstUnit, secondUnitQuantity, secondUnit);
				break;


			case imperialToMetric:
				for (int i = 0; i< metricWeight.length; i ++)
					if(firstUnit.equals(metricWeight[i]) || firstUnit.equals(String.format("%ss", metricWeight[i])))
						firstUnitBaseValue = metricValues[i];
				for (int i = 0; i < imperialWeight.length; i++)
					if(secondUnit.equals(imperialWeight[i]) || secondUnit.equals(String.format("%ss", imperialWeight[i])))
						secondUnitBaseValue = imperialWeightValues[i] * secondUnitQuantity;

				answer = String.format("There are %s %s in %.2f %s.",
						nf.format((secondUnitBaseValue * baseImperialToMetricWeightConversion / firstUnitBaseValue)),
						firstUnit, secondUnitQuantity, secondUnit);
				break;

			case metricToImperial:
				for (int i = 0; i< imperialWeight.length; i ++)
					if(firstUnit.equals(imperialWeight[i]) || firstUnit.equals(String.format("%ss", imperialWeight[i])))
						firstUnitBaseValue = imperialWeightValues[i];
				for (int i = 0; i < metricWeight.length; i++)
					if(secondUnit.equals(metricWeight[i]) || secondUnit.equals(String.format("%ss", metricWeight[i])))
						secondUnitBaseValue = metricValues[i] * secondUnitQuantity;


				answer = String.format("There are %s %s in %.2f %s.",
						nf.format((secondUnitBaseValue / (firstUnitBaseValue * baseImperialToMetricWeightConversion))),
						firstUnit, secondUnitQuantity, secondUnit);

					break;

			case metricToMetric:
				for (int i = 0; i< metricWeight.length; i ++)
				{
					if(firstUnit.equals(metricWeight[i]) || firstUnit.equals(String.format("%ss", metricWeight[i])))
						firstUnitBaseValue = metricValues[i];
					if(secondUnit.equals(metricWeight[i]) || secondUnit.equals(String.format("%ss", metricWeight[i])))
						secondUnitBaseValue = metricValues[i] * secondUnitQuantity;
				}

				answer = String.format("There are %s %s in %.2f %s.", nf.format((secondUnitBaseValue / firstUnitBaseValue)), 
						firstUnit, secondUnitQuantity, secondUnit);
				break;

			}
			return answer;
		}
}



