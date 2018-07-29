package Exercise014_006;

import java.util.Random;

public class Limericks {
	
	public static void main (String [] args)
	{

	
		final String[] article = {"the", "a", "one", "some", "any"};
		final String[] noun = {"boy", "bar", "toy", "tar", "car"};
		final String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
		final String[] preposition = {"to", "from", "over", "under", "on"};
		
		Random random = new Random();
		
		
		String sentence1 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
					verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
					article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
		
		String regex1 = new String(String.format("%s%s",sentence1.charAt(sentence1.length()-3),
					sentence1.charAt(sentence1.length()-2)));
			
		String sentence2 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
					verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
					article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			
		while(!sentence2.regionMatches(true, sentence2.length()-3 , regex1, 0, 2))	
				sentence2 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
				verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
				article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
	
		String sentence5 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
					verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
					article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			
		while(!sentence5.regionMatches(true, sentence5.length()-3 , regex1, 0, 2))	
				sentence5 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
				verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
				article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			
		String sentence3 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
					verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
					article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			
		while(sentence3.regionMatches(true, sentence3.length()-3 , regex1, 0, 2))	
				sentence3 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
				verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
				article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			
			
		String regex2 = new String(String.format("%s%s",sentence3.charAt(sentence3.length()-3),
					sentence3.charAt(sentence3.length()-2)));
		
		String sentence4 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
					verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
					article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			
		while(!sentence4.regionMatches(true, sentence4.length()-3 , regex2, 0, 2))	
				sentence4 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
				verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
				article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			
			sentence1 = capitalise(sentence1);
			System.out.println(sentence1);
			sentence2 = capitalise(sentence2);
			System.out.println(sentence2);
			sentence3 = capitalise(sentence3);
			System.out.println(sentence3);
			sentence4 = capitalise(sentence4);
			System.out.println(sentence4);
			sentence5 = capitalise(sentence5);
			System.out.println(sentence5);
	
			
	}
	
	static public String capitalise(String string)
	{
			string = string.replaceFirst("\\w", String.format("%s",Character.toUpperCase(string.charAt(0))));
			return string;
	}
	
	
}
