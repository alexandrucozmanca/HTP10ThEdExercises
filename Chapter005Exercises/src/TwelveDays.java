
public class TwelveDays {

	public static void main(String[] args) 
	{
		String dayString="";
		
		for (int day = 1 ; day <= 12 ; day ++ )
		{
			switch(day)
			{ 
			case 1:
				dayString = "First";
				break;
			
			case 2:
				dayString = "Second";
				break;
				
			case 3:
				dayString = "Third";
				break;
			
			case 4:
				dayString = "Fourth";
				break;
				
			case 5:
				dayString = "Fifth";
				break;
				
			case 6:
				dayString = "Sixth";
				break;
				
			case 7:
				dayString = "Seventh";
				break;
				
			case 8:
				dayString = "Eighth";
				break;
				
			case 9:
				dayString = "Nineth";
				break;
				
			case 10:
				dayString = "Tenth";
				break;
				
			case 11:
				dayString = "Eleventh";
				break;
				
			case 12:
				dayString = "Twelft";
				break;
			}
		
		System.out.printf("On the %s day of Christmas my true love sent to me:%n", dayString);	
		
		       switch(day)
				{
					case 12:
						System.out.println("Twelve Drummers Drumming");
					case 11:
						System.out.println("Eleven Pipers Piping");
					case 10:
						System.out.println("Ten Lords a-Leaping");
					case 9:
						System.out.println("Nine Ladies Dancing");
					case 8:
						System.out.println("Eight Maids a-Milking");
					case 7:
						System.out.println("Seven Swans a-Swimming");
					case 6:
						System.out.println("Six Geese a-Laying");
					case 5:
						System.out.println("Five Gold Rings");
					case 4:
						System.out.println("Four Calling Birds");
					case 3:
						System.out.println("Three French Hens");
					case 2:
						System.out.println("Two Turtle Doves");
					case 1:				
						System.out.println("a Partridge in a Pear Tree.");
				}
			
		
		System.out.println();
		
		}
			

	}

}
