package CardProject;

public class HandOfCards
{

	public static void main (String[] arg)
	{

		DeckOfCards myDeck = new DeckOfCards();
		myDeck.shuffle();

			
		Card[] myHand = new Card[5];
		myHand = myDeck.dealHand();

		/*
		// a test hand for checking particular conditions
		Card[] testHand = new Card[5];
		testHand[0] = new Card("Three","Hearts");
		testHand[1] = new Card("Four","Diamonds");
		testHand[2] = new Card("Deuce","Diamons");
		testHand[3] = new Card("Three","Clubs");
		testHand[4] = new Card("Four","Spades");
		*/

		// output for test hand
		/*
		sortFaces(testHand);

		System.out.println("\nAfter face sort:");
		for (int card = 0; card < testHand.length; card ++)
			System.out.println(testHand[card]);


		System.out.println("\nHas pair? " + hasAPair(testHand));
		System.out.println("Has two pairs? " + hasTwoPair(testHand));
		System.out.println("Has triple? " + hasATriple(testHand));
		System.out.println("Has quadruple? " + hasAQuadruple(testHand));
		System.out.println("Has flush? " + hasFlush(testHand));
		System.out.println("Has straight? " + hasStraight(testHand));
		System.out.println("Has full? " + hasFull(testHand));

		//sortSuits(testHand);
		//System.out.println("\nAfter suit sort");

		//for (int card = 0; card <testHand.length; card ++)
		//	System.out.println(testHand[card]);
		*/

		System.out.println(printHand(myHand));

		sortFaces(myHand);
		System.out.println("After face sort:");
		System.out.println(printHand(myHand));

		System.out.println("1. Has pair? " + hasAPair(myHand));
		System.out.println("2. Has two pairs? " + hasTwoPair(myHand));
		System.out.println("3. Has triple? " + hasATriple(myHand));
		System.out.println("4. Has quadruple? " + hasAQuadruple(myHand));
		System.out.println("5. Has flush? " + hasFlush(myHand));
		System.out.println("6. Has straight? " + hasStraight(myHand));
		System.out.println("7. Has full? " + hasFull(myHand));


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
			String output = "";
			for (int card = 0; card < hand.length; card ++)
				output += String.format("%s%n",hand[card]);

			return output;
		}

}
