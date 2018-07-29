package Exercise014_024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SpellChecker {

	private String checkedWord; // word to be checked
	private String possibleWord; // permutation for checkedWord that has been found in the dictionary


	// constructor
	public SpellChecker(String checkedWord) throws IllegalArgumentException
	{
		if(checkedWord == null || checkedWord.length() == 0)
			throw new IllegalArgumentException("String representing Word is null or contains no characters");

		this.checkedWord = checkedWord;
	}


	// accesor for checkedWord
	public String getCheckedWord()
	{
		return checkedWord;
	}

	// mutator for checkedWord
	public void setCheckedWord(String checkedWord) throws IllegalArgumentException
	{
		if(checkedWord == null || checkedWord.length() == 0)
			throw new IllegalArgumentException("String representing Word is null or contains no characters");

		this.checkedWord = checkedWord;
	}


	// method that compares checked word to provided dictionary
	public boolean checkWord()
	{	// eliminate possible mismatch
		try
		{
			// read dictionary
			BufferedReader dictionary = new BufferedReader(new FileReader("src/Exercise014_024/dictionary.txt"));

			// test line by line until no more lines exist
			String line;
			while ((line = dictionary.readLine()) != null)
			{
				//split line in order to compare each word individually
				String[] lineArray = line.split(" ");
				for (int i = 0; i < lineArray.length; i++)
				{
					// compare tested word to each element in the array
					if(checkedWord.equalsIgnoreCase(lineArray[i]))
					{
						// if true close file containing dictionary and return true
						dictionary.close();
						return true;
					}
				}
			}

			// if no matches found close file
			dictionary.close();
		}

		catch (IOException e)
		{
			System.err.println(e.getLocalizedMessage());
		}

		// default return value
		return false;
	}

	/// method that compares an array of words to the provided dictionary
	public boolean checkArray(String[] wordArray)
	{
		// local variable for method return value, by default assume no match will be found
		boolean wordFound = false;

		// check only if array is not null or has length greater than 0
		if (wordArray != null && wordArray.length > 0)
		{
			try
			{
				// compare all words
				for (int word = 0; word < wordArray.length; word++)
				{
					// read dictionary file
					BufferedReader dictionary = new BufferedReader(new FileReader("src/Exercise014_024/dictionary.txt"));


					// test line by line
					String line;
					while ((line = dictionary.readLine()) != null)
					{
						// split line into words to compare each individual word
						String[] lineArray = line.split(" ");
						for (int i = 0; i < lineArray.length; i++)
						{
							// if a match has been found break for loop
							if (wordFound)
								break;

							if(wordArray[word].equalsIgnoreCase(lineArray[i]))
							{
								possibleWord = wordArray[word]; // assign value to possible match
								wordFound = true; // update value
								break; // break for loop
							}
						}

						// if a match has been found break while loop
						if (wordFound)
							break;

					}

					// if match found close dictionary file and break for loop
					if (wordFound)
					{
						dictionary.close();
						break;
					}

					// if all words were tested and no match found close dictionary file
					if(word == wordArray.length - 1)
						dictionary.close();
				}


			}
			catch (IOException e)
			{
				System.err.println(e.getLocalizedMessage());
			}
		}

		return wordFound;
	}

	// method that generates an array of words by switching each letter with each other - this is meant to reverse a
	// writing error by which the user transposes two letters
	private String[] transposeWord()
	{
		//local variable containing all possible switches
		String[] transposeArray = new String[checkedWord.length() - 1];

		// do for each letter but for the last one
		for (int i = 0; i < checkedWord.length() - 1; i++)
		{
			// transform string into char Array
			char[] charArray = checkedWord.toCharArray();

			// switch chars
			char tempChar = charArray[i];
			charArray[i] = charArray[i + 1];
			charArray[i + 1] = tempChar;

			// build new word and assign it to the word array
			String tempString = "";
			for (int j = 0; j < charArray.length; j++)
				tempString += String.format("%c", charArray[j]);

			transposeArray[i] = tempString;
		}

		return transposeArray;
	}

	// method that generates an array of words by eliminating doubled letters - this is meant to reverse a writing error
	// by which the user double taps a key
	private String[] eliminateDoubledChars()
	{
		// assume word word contains no doubled chars
		String[] eliminationArray = null;
		ArrayList<String> tempArrayList = new ArrayList<String>(); // instance variable that will contain the new words

		int doubledChars = 0; // index for double char occurrence

		char[] charArray; //  instance variable for word editing


		// first level of editing - check the word and eliminate only one occurrence of doubled characters
		for (int i = 0; i < checkedWord.length() - 1; i++)
		{
			charArray = checkedWord.toCharArray(); // reset char array
			if(charArray[i] == charArray[i + 1])
			{
				doubledChars ++; // increase index for later usage

				// if doubled character found move all following chars one index down
				for (int j = i; j < checkedWord.length() - 1; j++)
					charArray[j] = charArray[j + 1];

				// build new word and assign it to the Array list
				String tempString = "";
				for (int a = 0; a < checkedWord.length() - 1; a++)
					tempString += String.format("%c", charArray[a]);

				tempArrayList.add(tempString);
			}

		}

		// second level of editing
		// if more than one occurrence exists eliminate all doubled characters
		if(doubledChars >= 2)
		{
			charArray = checkedWord.toCharArray(); // reset char array
			int offset = 0; // offset for array index

			// check the char array for double chars
			for (int i = 0; i < checkedWord.length() - 1 - offset; i++)
			{
				if(charArray[i] == charArray[i + 1])
				{
					offset++; // increase offset
					//move one index down if occurrence found
					for (int j = i ; j< checkedWord.length() - offset; j++)
						charArray[j] = charArray[j + 1];
				}
			}

			// build new word and assign it to the Array list
			String tempString2 = "";
			for (int a = 0; a < checkedWord.length() - offset; a++)
				tempString2 += String.format("%c", charArray[a]);

			tempArrayList.add(tempString2);
		}

		// trim Array list to minimum size
		tempArrayList.trimToSize();


		// initialize result array if any matches found so far
		if (tempArrayList.size() != 0)
		{
			eliminationArray = new String[tempArrayList.size()];
			for(int i = 0; i < tempArrayList.size(); i++)
				eliminationArray[i] = tempArrayList.get(i);
		}



		return eliminationArray;
	}

	// method that generates an array of words by doubling each letter - this is meant to reverse a writing error by which
	// the user omits a double letter
	private String[] doubleChars()
	{
		// local variable array that contains all possible words
		String[] doubledWords = new String[checkedWord.length()];

		char[] charArray; // local variable for word editing

		for(int i = 0; i < checkedWord.length(); i++)
		{
			charArray = checkedWord.toCharArray(); // reset char array

			String tempString = ""; // local variable containing the new word
			for(int j = 0; j< charArray.length; j++)
			{
				if (j == i)
					tempString += String.format("%c%c",charArray[j], charArray[j]);
				else
					tempString += String.format("%c",charArray[j]);
			}

			doubledWords[i] = tempString;
		}

		return doubledWords;
	}

	// TO DO: method that generates all possible approximations by replacing each letter with adjacent letters on the
	// keyboard

	// method to check possible approximations of inputed word using several String arrays
	public String checkAproximation()
	{
		// default response if no valid approximations were found
		String output = "The input \"" + checkedWord + "\" is not a valid English word.";

		// run each check successively and stop if correct approximation found
		if(checkArray(transposeWord()))
			output = String.format("Did you mean \"%s\"?%n", possibleWord);
		else
			if(checkArray(eliminateDoubledChars()))
				output = String.format("Did you mean \"%s\"?%n", possibleWord);
			else
				if(checkArray(doubleChars()))
					output = String.format("Did you mean \"%s\"?%n", possibleWord);

		return output;
	}


}
