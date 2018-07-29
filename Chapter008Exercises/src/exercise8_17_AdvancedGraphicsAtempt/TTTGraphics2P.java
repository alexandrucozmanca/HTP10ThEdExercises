package exercise8_17_AdvancedGraphicsAtempt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import exercise8_17_AdvancedGraphicsAtempt.TicTacToe.boardCell;

@SuppressWarnings("serial")
public class TTTGraphics2P extends JFrame
{
		// mouselistner on/off switch
		boolean enable = true;

		// Constants for game board
		public static final int rows = 3;
		public static final int columns = 3;
		private static int turn = 0;

		// dimensions constants
		public static final int cellSize = 100; // cell width and height for each square
		public static final int appWidth = cellSize * columns; // app window width
		public static final int appHeight = cellSize * rows; // app window height
		public static final int gridWidth = 8; // width of the grid that will separate the cells
		public static final int gridWidthHalf = gridWidth / 2; // grid line half-width
		public static final int cellPadding = cellSize / 6; // cell padding for border delineation
		public static final int symbolSize = cellSize - cellPadding * 2; // symbol size inside the cell
		public static final int symbolStroke = 8; // size oh pen for symbol drawing

		// graphics variables
		private DrawCanvas app;
		private JLabel statusBar;
		private JLabel warningBar;

		// game variables
		TicTacToe game = new TicTacToe(); // new game board
		static final int player1 = 0; // variable denoting player1 move
		static final int player2 = 1; // variable denoting player2 move



		public TTTGraphics2P()
		{
			app = new DrawCanvas(); // construct a new canvas to paint the graphics
			app.setPreferredSize(new Dimension(appWidth, appHeight));
			app.addMouseListener(new MouseAdapter()
			{	@Override
				public void mouseClicked(MouseEvent mouseClick) //mouse-click handler
				{
					if (enable)
					{	int mouseX = mouseClick.getX();
						int mouseY = mouseClick.getY();

						//determine game row and column based on mouse position
						int rowSelected = mouseY / cellSize;
						int columnSelected = mouseX / cellSize;

						if (turn %2 == 0)
						{
							try
							{
								game.occupyCell(rowSelected, columnSelected, player1);
								warningBar.setText("  ");
								turn++;
							}

							catch(IllegalArgumentException e)
							{
								warningBar.setForeground(Color.BLACK);
								warningBar.setText("Cell already taken, try again");
								repaint();
							}

						}

						else
							if (turn %2 == 1)
							{
								try
								{
									game.occupyCell(rowSelected, columnSelected, player2);
									warningBar.setText("  ");
									turn++;
								}

								catch(IllegalArgumentException e)
								{
									warningBar.setForeground(Color.BLACK);
									warningBar.setText("Cell already taken, try again");
									repaint();
								}

							}
						repaint(); // repaint canvas
					}
				}
			});


			statusBar = new JLabel("  ");
			statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
			statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));

			warningBar = new JLabel("  ");
			warningBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
			warningBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));



			Container cp = getContentPane();
			cp.setLayout(new BorderLayout());
			cp.add(app, BorderLayout.CENTER);
			cp.add(warningBar, BorderLayout.PAGE_START);
			cp.add(statusBar, BorderLayout.PAGE_END);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();// pack all components in this JFrame
			setTitle("Tic Tac Toe");
			setVisible(true);

		} // end TTTGraphics2P class

		class DrawCanvas extends JPanel
		{
			@Override
			public void paintComponent(Graphics g) // invoke via repaint()
			{
				super.paintComponent(g); // fill background
				setBackground(Color.WHITE); // set background to white

				// draw grid-lines
				g.setColor(Color.LIGHT_GRAY);

				for (int row = 1; row < rows; row ++)
				{
					g.fillRoundRect(0, cellSize * row - gridWidthHalf,
							appWidth - 1, gridWidth, gridWidth, gridWidth);
				}

				for (int column = 1; column < columns; column ++)
				{
					g.fillRoundRect(cellSize * column - gridWidthHalf, 0,
							gridWidth, appHeight - 1 , gridWidth, gridWidth);
				}

				// draw all cells if they are not empty
				// use Graphics 2D
				Graphics2D g2d = (Graphics2D)g;
				g2d.setStroke(new BasicStroke(symbolStroke, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND));

				for (int row = 0; row < rows; row ++)
				{
					for (int column = 0; column < columns; column ++)
					{
						int x1 = column * cellSize + cellPadding;
						int y1 = row * cellSize + cellPadding;

						if (game.getCell(row, column) == boardCell.X)
						{
							g2d.setColor(Color.RED);
							int x2 = (column + 1) * cellSize - cellPadding;
							int y2 = (row + 1) * cellSize - cellPadding;
							g2d.drawLine(x1, y1, x2, y2);
							g2d.drawLine(x2, y1, x1, y2);
						}

						else
							if (game.getCell(row, column) == boardCell.O)
							{
								g2d.setColor(Color.BLUE);
								g2d.drawOval(x1, y1, symbolSize, symbolSize);
							}
					}
				}

				//Print status-bar message

				if(!game.boardFull())
				{
					if (game.winX())
					{
						statusBar.setForeground(Color.RED);
						statusBar.setText("Player1 has WON - congrats");
						enable = false;
					}
					else
						if (game.winO())
						{
							statusBar.setForeground(Color.BLUE);
							statusBar.setText("Player2 has WON - congrats");
							enable = false;
						}
						else
						{
							statusBar.setForeground(Color.BLACK);
							if (turn %2 == player1)
							{
								statusBar.setText("Player1`s turn");
							}

							else
							{
								statusBar.setText("Player2`s turn");
							}
						}
				}
				else
				{
					statusBar.setForeground(Color.BLACK);
					statusBar.setText("It`s a DRAW, try again");
					enable = false;
				}

			}

		}



		public static void main(String[] args)
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				@Override
				public void run()
				{
					new TTTGraphics2P();
				}
			});
		}

}
