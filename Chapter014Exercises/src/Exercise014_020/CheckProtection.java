package Exercise014_020;

public class CheckProtection 
{
	public static void main(String[] args)
	{
		final int checkSpaceSize = 10;
		
		System.out.println(protectAmount(521.45, checkSpaceSize));
		System.out.println(amountToText(521.45));
		
		System.out.println(protectAmount(501.45, checkSpaceSize));
		System.out.println(amountToText(501.45));
		
		System.out.println(protectAmount(19.45, checkSpaceSize));
		System.out.println(amountToText(19.45));
		
		System.out.println(protectAmount(3, checkSpaceSize));
		System.out.println(amountToText(3));
		
		
	}

	public static String protectAmount(double amount, int checkSpaceSize)
	{
		String output;
		output = String.format("$%,.2f", amount);
		for(int i = 0; i < checkSpaceSize - output.length(); i ++)
			output = "*" + output;
			
		return output;
	}
	
	public static String amountToText(double amount)
	{
		String output = "";
		
		if (amount >= 100)
		{
			int temp = (int) (amount / 100);
			amount = amount % 100;
			
			switch (temp)
			{
				case 9:
					output = "NINE hundred";
					break;
					
				case 8:
					output = "EIGHT hundred";
					break;
					
				case 7:
					output = "SEVEN hundred";
					break;
					
				case 6:
					output = "SIX hundred";
					break;
					
				case 5:
					output = "FIVE hundred";
					break;
					
				case 4:
					output = "FOUR hundred";
					break;
					
				case 3:
					output = "THREE hundred";
					break;
					
				case 2:
					output = "TWO hundred";
					break;
					
				case 1:
					output = "ONE hundred";
					break;
			}
		}
		
		if (!((int)amount % 100 == 0) && amount > 20 )
			output += " and ";
					
		if(amount > 20 || amount < 9)
		{	
			switch((int)(amount / 10))
			{
				case 9:
					output += "NINETY";
					break;
					
				case 8:
					output += "EIGHTY";
					break;
					
				case 7:
					output += "SEVENTY";
					break;
					
				case 6:
					output += "SIXTY";
					break;
					
				case 5:
					output += "FIFTY";
					break;
					
				case 4:
					output += "FOURTY";
					break;
					
				case 3:
					output += "THIRTY";
					break;
				
				case 2:
					output += "TWENTY";
					break; 	
				
				case 1:
					output += "TEN";
					break; 	
			}
			
			if(!((int)amount % 10 == 0))
				output += " ";
		
			switch((int)amount % 10)
			{
				case 9:
					output += "NINE ";
					break;
					
				case 8:
					output += "EIGHT";
					break;
					
				case 7:
					output += "SEVEN";
					break;
					
				case 6:
					output += "SIX";
					break;
					
				case 5:
					output += "FIVE";
					break;
					
				case 4:
					output += "FOUR";
					break;
					
				case 3:
					output += "THREE";
					break;
					
				case 2:
					output += "TWO";
					break;
					
				case 1:
					output += "ONE";
					break;
			}
		}
		
		else 
		{
			switch ((int)amount)
			{
				case 19:
					output +="nineteen";
					break;
					
				case 18:
					output +="eighteen";
					break;
				
				case 17:
					output +="seventeen";
					break;
				
				case 16:
					output +="sixteen";
					break;
				
				case 15:
					output +="fifthteen";
					break;
					
				case 14:
					output +="fourteen";
					break;
				
				case 13:
					output +="thirteen";
					break;
				
				case 12:
					output +="twelve";
					break;
				
				case 11:
					output +="eleventeen";
					break;
			}
		}
		
		output +=" $";
				
		if(amount % 1 > 0)
			output += " and " + String.format("%.2f",amount%1*100) + "/100";
		
		return output;
	}
}
