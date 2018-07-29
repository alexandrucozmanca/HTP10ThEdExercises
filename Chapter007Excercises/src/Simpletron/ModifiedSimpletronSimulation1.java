package Simpletron;
import java.util.Scanner;


// modified Simpletron simulation for a 1000 element memory array
// .1
// added Remainder operation with code 34
// Exponential operation with code 35
// New line operation with code 50
public class ModifiedSimpletronSimulation1 {

	static int accumulator = 0;
	static int memoryIndex = 0;
	static int operationCode = 0;
	static int operand = 0;
	static int instructionRegister = 0;
	static int [] simpletron = new int[1000];
	static Scanner keyboardReader = new Scanner(System.in);


	public static void main(String[] args)
	{

		// sample commands
		simpletron[0] =  10007;
		simpletron[1] =  10008;
		simpletron[2] =  20007;
		simpletron[3] =  35008;
		simpletron[4] =  21009;
		simpletron[5] =  11009;
		simpletron[6] =  43000;



		//inputCode();
		displayCode();
		executeInstructions();

		displayCode(7);


	}

	// method to input commands into simpletron memory
	static void inputCode()
	{

		int memoryIndex = 0;
		String input;

		System.out.printf("*** Welcome to Simpletron!                       ***%n" +
						  "*** Please enter your program one instruction    ***%n" +
						  "*** (or data word) at a time. I will display     ***%n" +
						  "*** the location number and a question mark (?). ***%n" +
						  "*** You then type the word for that location.    ***%n" +
						  "*** Type -99999 to stop entering your program.   ***%n%n");

		String pattern = "\\+\\d\\d\\d\\d\\d";

		do
		{
			System.out.printf("%03d ?: ",memoryIndex);
			input = keyboardReader.next();

			if (input.matches(pattern))
				simpletron[memoryIndex] = Integer.parseInt(input);

			else
				simpletron[memoryIndex] = 0;

			memoryIndex++;

		}
		while (!(input.matches("-99999")));

		for (;memoryIndex < simpletron.length; memoryIndex ++)
			simpletron[memoryIndex] = 0;

	}


	// method for simpletron memory dump
	static void displayCode ()
	{
		System.out.printf("%n%-22s%n"
						+ "%-22s+%05d%n"
						+ "%-22s   %03d%n"
						+ "%-22s+%05d%n"
						+ "%-22s   %02d%n"
						+ "%-22s   %03d%n",
						"REGISTERS:",
						"accumulator",accumulator,
						"memoryIndex", memoryIndex,
						"instructionRegister", instructionRegister,
						"operationCode", operationCode,
						"operand", operand);

		System.out.printf("%nMEMORY%n");
		System.out.printf("    ");

		for (int i = 0; i < 10; i++)
			System.out.printf("%6d ",i);

		System.out.println();

		for (int i = 0; i < simpletron.length; i++)
		{
			if (i % 10 == 0)
				System.out.printf("%03d ",i);

			System.out.printf("+%05d ",simpletron[i]);

			if (i % 10 == 9)
				System.out.println();

		}
	}


	// method for simpletron memory dump up to a given memoryIndex
	static void displayCode (int maxMemoryIndex)
	{
		System.out.printf("%n%-22s%n"
						+ "%-22s%05d%n"
						+ "%-22s   %03d%n"
						+ "%-22s%05d%n"
						+ "%-22s   %02d%n"
						+ "%-22s   %03d%n",
						"REGISTERS:",
						"accumulator",accumulator,
						"memoryIndex", memoryIndex,
						"instructionRegister", instructionRegister,
						"operationCode", operationCode,
						"operand", operand);

		System.out.printf("MEMORY%n");
		System.out.printf("    ");

		for (int i = 0; i < 10; i++)
			System.out.printf(" %5d ",i);

		System.out.println();

		for (int i = 0; i < maxMemoryIndex; i++)
		{
			if (i % 10 == 0)
				System.out.printf("%03d ",i);

			System.out.printf("+%04d ",simpletron[i]);

			if (i % 10 == 9)
				System.out.println();

		}
	}

	// method for simpletron command execution
	static void executeInstructions()
	{
		Boolean endProgram = false;
		String readPattern = "(\\+|\\-)\\d\\d\\d\\d\\d";

		do
		{
			instructionRegister = simpletron[memoryIndex];
			operationCode = instructionRegister / 1000;
			operand = instructionRegister % 1000;

			System.out.printf("%nExecuting command line %03d:%n", memoryIndex);

			switch(operationCode)
			{

				// read from keyboard
				case 10:
					System.out.printf("*** Command Read. ***%n"
							+ "Please enter a 5 digit value, add '0' for small values: ");
					String input = keyboardReader.next();
					if (input.matches(readPattern))
						{
						simpletron[operand] = Integer.parseInt(input);
						System.out.printf("Valid  value, memory at index %03d has been updated to: %d.%n",operand, simpletron[operand]);
						}
					else
						System.out.print("Invalid value, memory will not be updated.\n");
					break;

				// write to screen from memory
				case 11:
					System.out.printf("*** Command write ***%n"
							+ "Value stored at %03d memoryIndex: %d.%n", operand, simpletron[operand]);
					break;

				// 	load from memory
				case 20:
					System.out.printf("*** Command load ***%n"
							+ "Value stored at memoryIndex %03d: %d loaded to accumulator.%n", operand, simpletron[operand]);
					accumulator = simpletron[operand];
					break;

				// store to memory
				case 21:
					System.out.printf("*** Command store ***%n"
							+ "Accumulator value: %d stored at memoryIndex %03d.%n", accumulator, operand);
					simpletron[operand] = accumulator;
					break;

				// add to accumulator
				case 30:
					System.out.printf("*** Command add ***%n"
							+ "Value: %d stored at memoryIndex %03d added to accumulator.%n", simpletron[operand], operand);
				accumulator += simpletron[operand];
				if (accumulator > 99999)
				{
					System.out.printf("*** Accumulator overflow at line: %d *** %n", memoryIndex);
					System.out.printf("*** Simpletron execution abnormally terminated ***%n");
					displayCode();
					System.exit(0);
				}
				break;

				// subtract from accumulator
				case 31:
					System.out.printf("*** Command substract ***%n"
							+ "Value: %d stored at memoryIndex %03d substracted from accumulator.%n", simpletron[operand], operand);
					accumulator -= simpletron[operand];
					if (accumulator < -99999)
					{
						System.out.printf("*** Accumulator overflow at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					break;

				// divide accumulator
				case 32:
					System.out.printf("*** Command divide ***%n"
							+ " Accumulator divided by value: %d stored at memoryIndex %03d.%n", simpletron[operand], operand);
					if (simpletron[operand] == 0)
					{
						System.out.printf("*** Attempt to divide by zero at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					else
						accumulator /= simpletron[operand];
					break;

				// multiply accumulator
				case 33:
					System.out.printf("*** Command multiply ***%n"
							+ " Accumulator multiplied by value: %d stored at memoryIndex %03d.%n", simpletron[operand], operand);
					accumulator *= simpletron[operand];
					if (accumulator > 99999 || accumulator < -99999)
					{
						System.out.printf("*** Accumulator overflow at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					break;

				// remainder operation
				case 34:
					System.out.printf("*** Command multiply ***%n"
							+ "Remainder operation on accumulator by value: %d stored at memoryIndex %03d.%n", simpletron[operand], operand);
					if (simpletron[operand] == 0)
					{
						System.out.printf("*** Attempt to divide by zero at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					else
						accumulator = accumulator % simpletron[operand];

					if (accumulator > 99999 || accumulator < -99999)
					{
						System.out.printf("*** Accumulator overflow at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					break;

					// Exponential operation
				case 35:
					System.out.printf("*** Command exponential ***%n"
							+ "Exponential operation on accumulator by value: %d stored at memoryIndex %03d.%n", simpletron[operand], operand);
					accumulator = (int) Math.pow(accumulator, simpletron[operand]);

					if (accumulator > 99999 || accumulator < -99999)
					{
						System.out.printf("*** Accumulator overflow at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					break;



				// branch
				case 40:
					System.out.printf("*** Command branch ***%n");
					if (accumulator > 0)
						memoryIndex = operand - 1;
					break;

				// branch negative
				case 41:
					System.out.printf("*** Command negative branch ***%n");
					if (accumulator < 0)
						memoryIndex = operand -1;
					break;

				// branch zero
				case 42:
					System.out.printf("*** Command zero branch ***%n");
					if (accumulator == 0)
						memoryIndex = operand - 1;
					break;

				// halt
				case 43:
					System.out.printf("*** Command end of program ***%n");
					System.out.printf("*** Simpletron execution terminated ***%n");
					memoryIndex --;
					endProgram = true;
					break;

				// New line code
				case 50:
					System.out.println();
					break;

				// default - used to invalid command codes
				default:
					System.out.printf("*** Invalid command code at line: %d. ***%n", memoryIndex);
					System.out.printf("*** Simpletron execution abnormally terminated ***%n");
					displayCode();
					System.exit(0);

			}// end switch

			memoryIndex++;
			if (memoryIndex == 999)
				endProgram = true;
		}// end do/while

		while (!endProgram);

	}

}
