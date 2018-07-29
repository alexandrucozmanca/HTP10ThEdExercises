package Simpletron;

import java.util.Scanner;

public class SimpletronSimulation {

	static int accumulator = 0;
	static int memoryIndex = 0;
	static int operationCode = 0;
	static int operand = 0;
	static int instructionRegister = 0;
	static int [] simpletron = new int[100];
	static Scanner keyboardReader = new Scanner(System.in);


	public static void main(String[] args)
	{
		/*
		// sample commands
		simpletron[0] =  1007;
		simpletron[1] =  1008;
		simpletron[2] =  2007;
		simpletron[3] =  3110;
		simpletron[4] =  4107;
		simpletron[5] =  1109;
		simpletron[6] =  4300;
		simpletron[7] =  1110;
		simpletron[8] =  4300;
		simpletron[9] =  0000;
		simpletron[10] = 0000;
		*/

		inputCode();
		displayCode();
		executeInstructions();

		displayCode();


	}

	// method to input commands into simpletron memory
	static void inputCode()
	{

		int memoryIndex = 0;
		String input;

		String pattern = "\\+\\d\\d\\d\\d";

		System.out.printf("*** Welcome to Simpletron!                       ***%n" +
						  "*** Please enter your program one instruction    ***%n" +
						  "*** (or data word) at a time. I will display     ***%n" +
						  "*** the location number and a question mark (?). ***%n" +
						  "*** You then type the word for that location.    ***%n" +
						  "*** Type -99999 to stop entering your program.   ***%n%n");

		do
		{
			System.out.printf("%02d ?: ",memoryIndex);
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
		System.out.printf("%n%-22s%n%"
						+ "-22s+%04d%n%"
						+ "-22s   %02d%n%"
						+ "-22s+%04d%n%"
						+ "-22s   %02d%n%"
						+ "-22s   %02d%n",
						"REGISTERS:",
						"accumulator",accumulator,
						"memoryIndex", memoryIndex,
						"instructionRegister", instructionRegister,
						"operationCode", operationCode,
						"operand", operand);

		System.out.printf("%nMEMORY%n");
		System.out.printf("   ");

		for (int i = 0; i < 10; i++)
			System.out.printf(" %4d ",i);

		System.out.println();

		for (int i = 0; i < simpletron.length; i++)
		{
			if (i % 10 == 0)
				System.out.printf("%02d ",i);

			System.out.printf("+%04d ",simpletron[i]);

			if (i % 10 == 9)
				System.out.println();

		}
	}


	// method for simpletron memory dump up to a given memoryIndex
	static void displayCode (int memoryIndex)
	{
		System.out.printf("%n%-22s%n%"
						+ "-22s+%04d%n%"
						+ "-22s%   02d%n%"
						+ "-22s+%04d%n%"
						+ "-22s%   02d%n%"
						+ "-22s%   02d%n",
						"REGISTERS:",
						"accumulator",accumulator,
						"memoryIndex", memoryIndex,
						"instructionRegister", instructionRegister,
						"operationCode", operationCode,
						"operand", operand);

		System.out.printf("MEMORY%n");
		System.out.printf("   ");

		for (int i = 0; i < 10; i++)
			System.out.printf(" %4d ",i);

		System.out.println();

		for (int i = 0; i < memoryIndex; i++)
		{
			if (i % 10 == 0)
				System.out.printf("%02d ",i);

			System.out.printf("+%04d ",simpletron[i]);

			if (i % 10 == 9)
				System.out.println();

		}
	}

	// method for simpletron command execution
	static void executeInstructions()
	{
		Boolean endProgram = false;
		String readPattern = "\\d\\d";

		do
		{
			instructionRegister = simpletron[memoryIndex];
			operationCode = instructionRegister / 100;
			operand = instructionRegister % 100;

			System.out.printf("Executing command line %02d:%n", memoryIndex);

			switch(operationCode)
			{

				// read from keyboard
				case 10:
					System.out.printf("Command Read.%nPlease enter a value: ");
					String input = keyboardReader.next();
					if (input.matches(readPattern))
						{
						simpletron[operand] = Integer.parseInt(input);
						System.out.printf("Valid  value, memory at index %02d has been updated.%n",operand);
						}
					else
						System.out.print("Invalid value, memory will not be updated.\n");
					break;

				// write to screen from memory
				case 11:
					System.out.printf("Command write%nValue stored at %02d memoryIndex: +%02d.%n", memoryIndex, simpletron[operand]);


				// 	load from memory
				case 20:
					accumulator = simpletron[operand];
					break;

				// store to memory
				case 21:
					simpletron[operand] = accumulator;
					break;

				// add to accumulator
				case 30:
				accumulator += simpletron[operand];
				if (accumulator > 9999)
				{
					System.out.printf("*** Accumulator overflow at line: %d *** %n", memoryIndex);
					System.out.printf("*** Simpletron execution abnormally terminated ***%n");
					displayCode();
					System.exit(0);
				}
				break;

				// subtract from accumulator
				case 31:
					accumulator -= simpletron[operand];
					if (accumulator < -9999)
					{
						System.out.printf("*** Accumulator overflow at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					break;

				// divide accumulator
				case 32:
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
					accumulator *= simpletron[operand];
					if (accumulator > 9999 || accumulator < -9999)
					{
						System.out.printf("*** Accumulator overflow at line: %d. ***%n", memoryIndex);
						System.out.printf("*** Simpletron execution abnormally terminated ***%n");
						displayCode();
						System.exit(0);
					}
					break;

				// branch
				case 40:
					if (accumulator > 0)
						memoryIndex = operand - 1;
					break;

				// branch negative
				case 41:
					if (accumulator < 0)
						memoryIndex = operand -1;
					break;

				// branch zero
				case 42:
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
