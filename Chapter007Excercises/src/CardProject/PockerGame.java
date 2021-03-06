package CardProject;

import java.util.Random;
import javax.swing.JOptionPane;

public class PockerGame
{
	static DeckOfCards myDeck = new DeckOfCards();
	static int cardsChanged;

	public static void main (String[] arg)
	{


		myDeck.shuffle();

		Card[] myHand = new Card[5];
		Card[] dealerHand = new Card[5];

		myHand = myDeck.dealHand();
		dealerHand = myDeck.dealHand();

		Boolean dealAgain =  true;

		while (dealAgain)
		{

			exchangeCards(dealerHand, evaluateCards(dealerHand, evaluateHand(dealerHand)));
			
			String answer =	JOptionPane.showInputDialog(
							String.format("My hand:%n%s%n",printHand(myHand)) +
							String.format("Dealer examines his hand!%n") +
							cardsChanged +" card(s) exchanged!" +
							String.format("%n%nEvaluate your hand and decide which cards to exchange:%n%n"));

			if (answer == null)
				answer = "";
			
			exchangeCards(myHand, evaluateAnswer(answer));

			String message = "";
			if (evaluateHand(myHand) == evaluateHand(dealerHand))
				message = "It`s a draw, playing another round.";


			else
				if(evaluateHand(myHand) > evaluateHand(dealerHand))
				{
					message = "I won!";
					dealAgain = false;
				}
				else
				{
					message = "I lost.";
					dealAgain = false;
				}

			JOptionPane.showMessageDialog(null, String.format("%s%n", printHands(myHand,dealerHand)) +
				String.format("My hand has a value of %d and adversary`s hand has a value of %d.%n",
						evaluateHand(myHand), evaluateHand(dealerHand)) +
				message);
		}

	}



	// 1. method to sort by card Faces
	static void sortFaces(Card[] hand)
	{
		// array with possible values
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six","Seven", "Eight", "Nine",
				  "Ten", "Jack", "Queen", "King"};

		// array to store a given cards position regarding the total possible face values
		int[] placeArray = new int[hand.length];

		// assign positions to all the cards
		for (int card = 0; card < hand.length; card ++)
			for (int face = 0; face < faces.length; face ++)
				if (hand[card].getFace().equals(faces[face]))
					placeArray[card] = face;

		// sort hand by bubble sorting the placeArray and mimicking the sort on the deck array
		int step = 0;
		while (step < placeArray.length)
		{
			for (int place = step; place < placeArray.length-1; place++)

				if(placeArray[place + 1] < placeArray[step])
				{
					int temp = placeArray[place + 1];
					placeArray[place + 1]  = placeArray[step];
					placeArray[step] = temp;

					Card tempCard = hand[place + 1];
					hand[place + 1] = hand[step];
					hand[step] = tempCard;
				}
			step++;
		}


	}

	// 2. method to sort by card Suit
	static void sortSuits(Card[] hand)
	{
		// array with possible values
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

		// array to store a given cards position regarding the total possible suit values
		int[] placeArray = new int[hand.length];

		// assign positions to all the cards
		for (int card = 0; card < hand.length; card ++)
			for (int suit = 0; suit < suits.length; suit ++)
				if (hand[card].getSuit().equals(suits[suit]))
					placeArray[card] = suit;


		// sort hand by bubble sorting the placeArray and mimicking the sort on the deck array
		int step = 0;
		while (step < placeArray.length)
		{
			for (int place = step; place < placeArray.length-1; place++)

				if(placeArray[place + 1] < placeArray[step])
				{
					int temp = placeArray[place + 1];
					placeArray[place + 1]  = placeArray[step];
					placeArray[step] = temp;

					Card tempCard = hand[place + 1];
					hand[place + 1] = hand[step];
					hand[step] = tempCard;
				}
			step++;
		}


	}



	// 3. method to determine if deck has at least a pair
	static Boolean hasAPair(Card[] hand)
	{
		boolean hasPair = false;

		// if two cards have the same Face value condition is true
		for (int firstCard = 0; firstCard < hand.length - 1; firstCard ++)
			for (int secondCard = firstCard + 1; secondCard < hand.length; secondCard ++)
				if (hand[firstCard].getFace().equals(hand[secondCard].getFace()))
					hasPair = true;
		return hasPair;
	}


	// 4. method to determine if deck has two Pairs
	static Boolean hasTwoPair(Card[] hand)
	{
		boolean hasTwoPair = false;

		// test the 3 possible configurations for same Face value condition
		if(hand[1].getFace().equals(hand[2].getFace()) &&
		   hand[3].getFace().equals(hand[4].getFace()))
				hasTwoPair = true;

		if(hand[0].getFace().equals(hand[1].getFace()) &&
		   hand[3].getFace().equals(hand[4].getFace()))
				hasTwoPair = true;

		if(hand[0].getFace().equals(hand[1].getFace()) &&
		   hand[2].getFace().equals(hand[3].getFace()))
						hasTwoPair = true;

		return hasTwoPair;
	}



	// 5. method to determine if deck has a triple
	static Boolean hasATriple(Card[] hand)
	{
		boolean hasTriple = false;

		// if three cards have the same Face value condition is true
		for (int firstCard = 0; firstCard < hand.length - 2; firstCard ++)
			for (int secondCard = firstCard + 1; secondCard < hand.length - 1; secondCard ++)
				for (int thirdCard = secondCard + 1; thirdCard< hand.length ; thirdCard++)
					if (hand[firstCard].getFace().equals(hand[secondCard].getFace()) &&
						hand[secondCard].getFace().equals(hand[thirdCard].getFace()))
							hasTriple = true;

		return hasTriple;
	}


	// 6. method to determine if deck has a quadruple
	static Boolean hasAQuadruple(Card[] hand)
	{
		boolean hasQuadruple = false;

		// if three cards have the same Face value condition is true
		for (int firstCard = 0; firstCard < hand.length - 3; firstCard ++)
			for (int secondCard = firstCard + 1; secondCard < hand.length - 2; secondCard ++)
				for (int thirdCard = secondCard + 1; thirdCard< hand.length - 1; thirdCard++)
					for (int fourthCard = thirdCard + 1; fourthCard <hand.length; fourthCard ++)
					if (hand[firstCard].getFace().equals(hand[secondCard].getFace()) &&
						hand[secondCard].getFace().equals(hand[thirdCard].getFace()) &&
						hand[thirdCard].getFace().equals(hand[fourthCard].getFace()))
							hasQuadruple = true;

		return hasQuadruple;
	}

	// 7. method to determine if hand has a flush
	static Boolean hasFlush(Card[] hand)
	{
		// consider test to be true by default
		boolean hasFlush = true;

		// if any card has a Suit value different from the first card test is false
		for (int card = 1; card < hand.length; card ++)
			if(!hand[0].getSuit().equals(hand[card].getSuit()))
				hasFlush = false;

		return hasFlush;
	}

	// 8. method to determine if hand has straight

	static Boolean hasStraight(Card[] hand)
	{
		// assume test is true
		boolean hasStraight = true;

		// array with possible values
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six","Seven", "Eight", "Nine",
				  "Ten", "Jack", "Queen", "King"};

		// array to store a given cards position regarding the total possible suit values
		int[] placeArray = new int[5];

		// assign positions to all the cards
		for (int card = 0; card < hand.length; card ++)
			for (int face = 0; face < faces.length; face ++)
				if (hand[card].getFace().equals(faces[face]))
					placeArray[card] = face;

		// test if two sequential cards have a +1 difference in face value
		for (int place = 0; place < placeArray.length - 1; place++)
			if (placeArray[place] + 1 != placeArray[place + 1])
				hasStraight = false;  // if condition is not true the test is not true


		return hasStraight;
	}

	// 9. method to determine if hand has full
	static Boolean hasFull(Card[] hand)
	{
		boolean hasFull = false;

		// test the 2 possible configurations for same Face value condition
		if (hand[0].getFace().equals(hand[1].getFace()) &&
			hand[2].getFace().equals(hand[3].getFace()) &&
			hand[2].getFace().equals(hand[4].getFace()))
				hasFull = true;

		if (hand[3].getFace().equals(hand[4].getFace()) &&
			hand[0].getFace().equals(hand[1].getFace()) &&
			hand[0].getFace().equals(hand[2].getFace()))
				hasFull = true;

		return hasFull;
	}

	// 10. method to print hand
	static String printHand(Card[] hand)
	{
		sortFaces(hand);
		String output = "";
		for (int card = 0; card < hand.length; card ++)
			output += String.format("%s%n",hand[card]);

		return output;
	}

	// 11. method to assign a numeric value to the deck
	static int evaluateHand(Card[] hand)
	{
		int test = -1; // initial value of tests (primed for while)
		int handValue = 0; // initial value of the hand
		sortFaces(hand); // sort the hand


		// run tests in descending order of hand "value"
		while (test < 0)
		{
			if (hasAQuadruple(hand))
			{
				handValue = 7;
				test = 0;
				break;
			}

			if (hasFull(hand))
			{
				handValue = 6;
				test = 0;
				break;
			}

			if (hasFlush(hand))
			{
				handValue = 5;
				test = 0;
				break;
			}

			if (hasStraight(hand))
			{
				handValue = 4;
				test = 0;
				break;
			}

			if (hasATriple(hand))
			{
				handValue = 3;
				test = 0;
				break;
			}

			if (hasTwoPair(hand))
			{
				handValue = 2;
				test = 0;
				break;
			}

			if (hasAPair(hand))
			{
				handValue = 1;
				test = 0;
				break;
			}

			test = 0; // stop while loop even if no tests were positive
		}

		return handValue;
	}

	// 12. method to create a Value Array which assigns a value index to each card of the deck
	// (in order to decide which ones to change)
	static int[] evaluateCards(Card[] hand, int handValue)
	{
		int[] cardValueArray = new int[hand.length]; // initial Value Array - all cards should be e
		switch (handValue)
		{
			// in case of four of a kind
			case 7:
			{
				for (int firstCard = 0; firstCard < hand.length - 3; firstCard ++)
					for (int secondCard = firstCard + 1; secondCard < hand.length - 2; secondCard ++)
						for (int thirdCard = secondCard + 1; thirdCard< hand.length - 1; thirdCard++)
							for (int fourthCard = thirdCard + 1; fourthCard <hand.length; fourthCard ++)
							if (hand[firstCard].getFace().equals(hand[secondCard].getFace()) &&
								hand[secondCard].getFace().equals(hand[thirdCard].getFace()) &&
								hand[thirdCard].getFace().equals(hand[fourthCard].getFace()))
									{
										cardValueArray[firstCard] = 1;
										cardValueArray[secondCard] = 1;
										cardValueArray[thirdCard] = 1;
										cardValueArray[fourthCard] = 1;
									}
				break;
			}

			// in case of a full
			case 6:
			{
				for (int card = 0; card < cardValueArray.length; card++)
					cardValueArray[card] = 1;
				break;
			}

			// in case of a flush
			case 5:
			{
				for (int card = 0; card < cardValueArray.length; card++)
					cardValueArray[card] = 1;
				break;
			}

			// in case of a straight
			case 4:
			{
				for (int card = 0; card < cardValueArray.length; card++)
					cardValueArray[card] = 1;
				break;
			}


			// in case of three of a kind
			case 3:
			{
				for (int firstCard = 0; firstCard < hand.length - 2; firstCard ++)
					for (int secondCard = firstCard + 1; secondCard < hand.length - 1; secondCard ++)
						for (int thirdCard = secondCard + 1; thirdCard< hand.length ; thirdCard++)
							if (hand[firstCard].getFace().equals(hand[secondCard].getFace()) &&
								hand[secondCard].getFace().equals(hand[thirdCard].getFace()))
									{
										cardValueArray[firstCard] = 1;
										cardValueArray[secondCard] = 1;
										cardValueArray[thirdCard] = 1;
									}
				break;
			}

			// in case of two pairs:
			case 2:
			{
				if(hand[1].getFace().equals(hand[2].getFace()) &&
				   hand[3].getFace().equals(hand[4].getFace()))
				{
					cardValueArray[1] = 1;
					cardValueArray[2] = 1;
					cardValueArray[3] = 1;
					cardValueArray[4] = 1;
				}

				if(hand[0].getFace().equals(hand[1].getFace()) &&
				   hand[3].getFace().equals(hand[4].getFace()))
				{
					cardValueArray[0] = 1;
					cardValueArray[1] = 1;
					cardValueArray[3] = 1;
					cardValueArray[4] = 1;
				}

				if(hand[0].getFace().equals(hand[1].getFace()) &&
				   hand[2].getFace().equals(hand[3].getFace()))
				{
					cardValueArray[0] = 1;
					cardValueArray[1] = 1;
					cardValueArray[2] = 1;
					cardValueArray[3] = 1;
				}


				break;
			}

			// in case of one pair
			case 1:
			{
				for (int firstCard = 0; firstCard < hand.length - 1; firstCard ++)
					for (int secondCard = firstCard + 1; secondCard < hand.length; secondCard ++)
						if (hand[firstCard].getFace().equals(hand[secondCard].getFace()))
							{
								cardValueArray[firstCard] = 1;
								cardValueArray[secondCard] = 1;
							}
				break;
			}

			// if hand has no valuable pairing assign 2 random cards to keep and exchange the other 3
			default:
			{
				Random randomInt = new Random();
				int card = randomInt.nextInt(5);
				cardValueArray[card] = 1;
				cardValueArray[(card + 1) % 5] = 1;
			}

		}


		return cardValueArray;
	}


	// 13. method to exchange cards from a hand based on a card value Array
	static void exchangeCards(Card[] hand, int [] cardValueArray)
	{
		cardsChanged = 0;
		for (int card = 0; card < cardValueArray.length; card ++)
			if (cardValueArray[card] == 0)
			{
				hand[card] = myDeck.dealCard();
				cardsChanged++;
			}

	}

	// 14 method to evaluate user answer to generate a value Array
	static int [] evaluateAnswer(String answer)
	{
		int[] cardValueArray = new int[5]; // Initialize array

		// assume all cards should be kept
		for (int card = 0; card < cardValueArray.length; card ++)
			cardValueArray[card] = 1;

		String card = "";
		int cardIndex = -1;

		// test each character of the answer string for existence of a number
		// if that number is between 1 and 5
		for (int i = 0; i < answer.length(); i++)
		{
			card = String.format("%s",answer.charAt(i));
			try
			{
				cardIndex = Integer.parseInt(card);
			}

			catch (NumberFormatException e)
			{

			}

			// if number is within array bounds assign O to that index - meaning that card will be exchanged
			if (cardIndex > 0 || cardIndex < 6)
				cardValueArray[cardIndex-1] = 0;

		}

		return cardValueArray;
	}

	// 15 method to print hands side by side - this is meant for JOptionPane as the " " is offset twice
	static String printHands(Card[] hand1, Card[]hand2)
	{
		String output = "";
		output = output + "My Hand";
		for (int space = "My Hand".length(); space < 18; space ++)
			output = output + "  ";

		for (int space = 0; space < 7; space ++)
			output = output + " ";

		output = output + "Dealers Hand";
		for (int space = "Dealers Hand".length(); space < 18; space ++)
			output = output + "  ";

		output = output + String.format("%n");

		for (int card = 0; card < hand1.length; card ++)
		{
			output = output + String.format("%s",hand1[card]);
			for (int space = String.format("%s",hand1[card]).length(); space < 18; space ++)
				output = output + "  ";

			for (int space = 0; space < 5; space ++)
				output = output + "  ";


			output = output + String.format("%s",hand2[card]);
			for (int space = String.format("%s",hand2[card]).length(); space < 18; space ++)
				output = output + "  ";

			output = output + String.format("%n");
		}

		return output;
	}

}
