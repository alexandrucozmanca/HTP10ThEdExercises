import java.security.SecureRandom;

public class DeckOfCards
{
	private Card[] deck;
	public int currentCard;
	private static final int NUMBER_OF_CARDS = 52;

	private static final SecureRandom random = new SecureRandom();

	// constructor
	public DeckOfCards()
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six","Seven", "Eight", "Nine",
						  "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;

		for (int count = 0; count < deck.length; count++)
			deck[count] = new Card(faces[count % 13], suits[count / 13]);

	}

	// method to shuffle deck
	public void shuffle()
	{
		currentCard = 0;

		for (int firstCard = 0 ; firstCard < deck.length ; firstCard++)
		{

			int shuffle = firstCard + random.nextInt(NUMBER_OF_CARDS - firstCard);

			Card temp = deck[firstCard];
			deck[firstCard] = deck[shuffle];
			deck[shuffle] = temp;

		}
	}

	//method to deal top card, or return null if deck exhausted
	public Card dealCard()
	{
		if (currentCard < deck.length)
			return deck[currentCard++];
		else
			return null;
	}

	// method to deal a 5 card Hand or return null if deck has less that 5 card remaining
	public Card[] dealHand()
	{
		Card[] hand = new Card[5];

		int firstCard = this.currentCard;

		if (deck.length - firstCard > 4)
		{
			for (int card = firstCard; card < hand.length + firstCard; card++)
				hand[card - firstCard] = dealCard();

			return hand;
		}

		else
			return null;
	}

}
