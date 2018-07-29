import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TurtleGraphics
{
	static int currentRow, // local variable for row position
			   currentColumn; // local variable for column position;

	static String [][] board = new String[20][20];

	public static void main(String[] args) throws IOException
	{
		buildBoard();

		currentRow = 0; currentColumn = 0;
		board[currentRow][currentColumn] = " @ ";

		int action, length = 0, direction;
		String input;
		Boolean showMap = false;

		JOptionPane.showMessageDialog(null, "Bella este o pisica murdara.\n\n"
										  + "Tu decizi pe unde va umbla pisica, cat de\n"
										  + "mult se deplaseaza si daca sare sau merge.\n\n"
										  + "Pisica va incepe in coltul din stanga sus a camerei",
				"Pisica murdara.", JOptionPane.PLAIN_MESSAGE);


		JOptionPane.showMessageDialog(null, showBoard(), "Camera.", JOptionPane.PLAIN_MESSAGE);

		boolean keepGoing = true;

		while (keepGoing)
			{
			// YES/NO
			Object[] actionOptions = {"Merge","Sare"};
			action = JOptionPane.showOptionDialog(null,
					"Ce face Bella?", "",
					JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null,
					actionOptions, actionOptions[0]);

			boolean validInput = false;
			do
			{

				input = JOptionPane.showInputDialog("Cati metri se deplaseaza pisica?");

				try
				{
					length = Integer.parseInt(input);
					if (length != 0 ) validInput = true;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,"Trebuie sa introduci un numar.");
				}

			} while (!validInput);


			// 	YES/NO Dialog to keep playing
			Object[] directionOptions = {"In fata","In sus", "In spate","In jos"};
			direction = JOptionPane.showOptionDialog(null,
			"In ce directie merge Bella?", "",
			JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null,
			directionOptions, directionOptions[0]);

			switch (action)
			{
				case 0:
					if(validateMove(direction,length))
						{
						moveWrite(direction,length);
						showMap = true;
						}
					else
						{
						JOptionPane.showMessageDialog(null,
								"Bella ar intra in perete dace merge acolo.\n"
							  + "Urat din partea ta Ramona :)");
						showMap = false;
						}


					break;
				case 1:

					if(validateMove(direction,length))
						{
						move(direction,length);
						showMap = true;
						}
					else
						{
						JOptionPane.showMessageDialog(null,
								"Bella ar intra in perete dace merge acolo.\n"
							  + "Urat din partea ta Ramona :)");
						showMap = false;
						}
			}

			if (showMap)
				JOptionPane.showMessageDialog(null, showBoard(), "Camera.", JOptionPane.PLAIN_MESSAGE);

			Object[] continueOptions = {"Da","Nu"};
			int meh = JOptionPane.showOptionDialog(null,
					"Continua", "",
					JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null,
					continueOptions,continueOptions[0]);

			if (meh == 1) keepGoing = false;
		}


		String path = "\\\\192.168.1.10\\DEPARTAMENTE\\SALES\\UNIT 13\\matza.jpg";
		BufferedImage myPicture = ImageIO.read(new File (path));
		JLabel picLabel = new JLabel (new ImageIcon(myPicture));

		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(picLabel);
		application.pack();
		application.setVisible(true);




	}

	public static void buildBoard()
	{
		for (int row = 0; row < board.length; row ++)
			for (int column = 0; column < board[row].length; column ++)
				board[row][column] = "      ";
	}

	public static String showBoard()
	{
		String display = "";
		for (int row = 0; row < board.length; row ++)
		{	for (int column = 0; column < board[row].length; column ++)
				display = display + String.format("%s",board[row][column]);
			display = display + String.format("%n");
		}

		return display;

	}

	// method to move and write
	public static void moveWrite(int direction, int lenght)
	{

		switch (direction)
		{
			// move to the right
			case 0:
				board[currentRow][currentColumn] = " :  : ";
				for (int column = currentColumn + 1; column < currentColumn + lenght + 1; column ++)
				{
					board[currentRow][column] = " :  : ";
				}
				board[currentRow][currentColumn + lenght] = " @ ";
				currentColumn = currentColumn + lenght;
				break;

			// move up
			case 1:
				board[currentRow][currentColumn] = " :  : ";
				for (int row = currentRow - 1; row > currentRow - lenght - 1; row --)
				{
					board[row][currentColumn] = " :  : ";
				}
				board[currentRow - lenght][currentColumn] = " @ ";
				currentRow = currentRow - lenght;
				break;

			// move to the left
			case 2:
				board[currentRow][currentColumn] = " :  : ";
				for (int column = currentColumn - 1; column > currentColumn - lenght - 1; column --)
				{
					board[currentRow][column] = " :  : ";
				}
				board[currentRow][currentColumn - lenght] = " @ ";
				currentColumn = currentColumn - lenght;
				break;

			// move down
			case 3:
				board[currentRow][currentColumn] = " :  : ";
				for (int row = currentRow + 1; row < currentRow + lenght + 1; row ++)
				{
					board[row][currentColumn] = " :  : ";
				}
				board[currentRow + lenght][currentColumn] = " @ ";
				currentRow = currentRow + lenght;
				break;

		} // end switch
	} // end moveWrite method


	// method to move
	public static void move(int direction, int lenght)
	{

		switch (direction)
		{
			// move to the right
			case 0:
				board[currentRow][currentColumn] = " :  : ";
				board[currentRow][currentColumn + lenght] = " @ ";
				currentColumn = currentColumn + lenght;
				break;

			// move up
			case 1:
				board[currentRow][currentColumn] = " :  : ";
				board[currentRow - lenght][currentColumn] = " @ ";
				currentRow = currentRow - lenght;
				break;

			// move to the left
			case 2:
				board[currentRow][currentColumn] = " :  : ";
				board[currentRow][currentColumn - lenght] = " @ ";
				currentColumn = currentColumn - lenght;
				break;

			// move down
			case 3:
				board[currentRow][currentColumn] = " :  : ";
				board[currentRow + lenght][currentColumn] = " @ ";
				currentRow = currentRow + lenght;
				break;
		} // end switch

	} // end move method


	// method to move
	public static boolean validateMove(int direction, int lenght)
	{
		boolean validMove = false; // assume move is false
		switch (direction)
		{
			// move to the right
			case 0:
				if (currentColumn + lenght < board.length)
					validMove = true;
				break;

			// move up
			case 1:
				if (currentRow - lenght >= 0)
					validMove = true;
				break;

			// move to the left
			case 2:
				if (currentColumn - lenght >= 0)
					validMove = true;
				break;

			// move down
			case 3:
				if (currentRow + lenght < board[0].length)
					validMove = true;
				break;

		} // end switch
			return validMove;
	} // end move method


}
