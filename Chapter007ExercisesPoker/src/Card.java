public class Card
{

	private final String face; // (value of card: 2-10, Ace, Deuce, ...
	private final String suit; // suit of card: Heart, Diamond, ...


	// constructor
	public Card(String face, String suit)
	{
		this.face = face;
		this.suit = suit;
	}

	// return a String representation of Card
	public String toString()
	{
		return face + " of " + suit;
	}

	public String getFace()
	{
		return face;
	}

	public String getSuit()
	{
		return suit;
	}
}
