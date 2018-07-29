package Exercise013_24;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GraphicKnight 
{

	public static void main (String[] args)
	{
		KnightRun app = new KnightRun();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		app.setResizable(false);
		app.setSize(408, 445);
	}
}	

class KnightRun extends JFrame implements ActionListener
{
	HeuristicKnightsTour game;
	JPanel gameGrid;
	int[][] gridArray;
	int move;
	Timer timer;
	public JLabel infoLabel;
	
	KnightRun()
	{
		super("A Knights Run");
		game = new HeuristicKnightsTour();
		gridArray = game.runBoard();
		move = 0;
		infoLabel = new JLabel("");
		
		gameGrid = new JPanel()
		{
					@Override
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				setBackground(Color.WHITE);
												
				g.setColor(Color.BLACK);
				for (int x = 2; x < 402; x += 100)
					for (int y = 2; y < 402 ; y += 100)
						g.fillRect(x, y, 50, 50);
				
				for (int x = 52; x < 402; x += 100)
					for (int y = 52; y < 402 ; y += 100)
						g.fillRect(x, y, 50, 50);
				
				Graphics2D g2d = (Graphics2D) g;
				
				
				g2d.setColor(Color.RED);
				g2d.setFont(new Font("TimesRoman", Font.BOLD, 15));
				for (int i = -1; i < move; i ++)
					for (int row = 0; row < gridArray.length; row ++)
						for (int column = 0; column < gridArray[row].length; column ++)
							if(i == gridArray[row][column])
							{	
								if (i == -1 )
									g2d.drawString(String.format("%2d", 0), 20 + 50 * row, 30 + 50 * column);
								else
									g2d.drawString(String.format("%2d", gridArray[row][column]), 20 + 50 * row, 31 + 50 * column);
								if (i == move - 1)
								infoLabel.setText(String.format("  Knight jumps at %d,%d", row + 1, column + 1));		
							}
				setSize(400, 400);
				
			}
					
		};
		
		add(gameGrid, BorderLayout.CENTER);
		add(infoLabel, BorderLayout.SOUTH);
				
		timer = new Timer(500, this);
		timer.start();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (move <= 63)
			move ++;
		else 
			infoLabel.setText("Run over!");
		gameGrid.repaint();
	}
	
}
	
	

