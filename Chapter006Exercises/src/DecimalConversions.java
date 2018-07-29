// Application for conversions from decimal to binary, octal and hexadecimal
public class DecimalConversions 
{
	
	public static void main (String[] args)
	{
		System.out.printf("Number\tBinary\t\tOctal\tHexidecimal%n");
		
		for (int i = 0; i < 256; i++)
			System.out.printf("%d\t%s\t%s\t%s%n",
					i,toBinary(i),toOctal(i),toHexadecimal(i));
		
	}

	// method to convert to Binary
	static String toBinary(int number)
	{
		String binaryNumber = "";
		
		while (number != 0)
		{
			binaryNumber = (number % 2) + binaryNumber;
			number /= 2;
		}
		
		while(binaryNumber.length()<8)
			binaryNumber = '0' + binaryNumber;
		
		return binaryNumber;
	}
	
	// method to convert to Octal
	static String toOctal(int number)
	{
		String octalNumber = "";
		
		while (number != 0)
		{
			octalNumber = (number % 8) + octalNumber;
			number /= 8;
		}
		
		while(octalNumber.length()<3)
			octalNumber = '0' + octalNumber;
		
		return octalNumber;
	}
	
	// method to convert to hexadecimal
	static String toHexadecimal(int number)
	{
		String hexadecimalNumber = "";
		
		while (number != 0)
		{
			switch ((number % 16))
			{
			case 15:
				hexadecimalNumber = "F" + hexadecimalNumber;
				break;
				
			case 14:
				hexadecimalNumber = "E" + hexadecimalNumber;
				break;
				
			case 13:
				hexadecimalNumber = "D" + hexadecimalNumber;
				break;
				
			case 12:
				hexadecimalNumber = "C" + hexadecimalNumber;
				break;
				
			case 11:
				hexadecimalNumber = "B" + hexadecimalNumber;
				break;
				
			case 10:
				hexadecimalNumber = "A" + hexadecimalNumber;
				break;
				
			default:
				hexadecimalNumber = (number % 16) + hexadecimalNumber;
			}
			
			number /= 16;
		}
		
		while(hexadecimalNumber.length()<2)
			hexadecimalNumber = '0' + hexadecimalNumber;
		
		return hexadecimalNumber;
	}
	
	
}

