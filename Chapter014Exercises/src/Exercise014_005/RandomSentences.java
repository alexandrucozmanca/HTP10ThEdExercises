package Exercise014_005;

import java.util.Random;

public class RandomSentences {

	public static void main(String[] args) {
		
		final String[] article = {"the", "a", "one", "some", "any"};
		final String[] noun = {"boy", "girl", "dog", "town", "car"};
		final String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
		final String[] preposition = {"to", "from", "over", "under", "on"};
		
		Random random = new Random();
		
		for (int count = 0; count < 20; count ++)
		{
			String sentence = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + " " + 
					verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] + " " + 
					article[random.nextInt(5)] + " " + noun[random.nextInt(5)]+ ".";
			sentence = sentence.replaceFirst("\\w", String.format("%s",Character.toUpperCase(sentence.charAt(0))));
			System.out.println(sentence);
		}
		
	}

}
