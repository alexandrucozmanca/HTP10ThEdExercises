package Exercise12_018;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class VirtualKeyBoard extends JFrame
{

	private JTextArea textArea;
	private JButton[] firstRow;
	private JButton[] secondRow;
	private final String[] firstRowNames = new String[14];
	{
		firstRowNames[0] = "~";
	
		for (int i = 1 ; i <= 10; i ++)
		{
			if (i != 10)
				firstRowNames[i] = String.format("%d",i);
			else 
				firstRowNames[i] = "0";
		}
	
		firstRowNames[11] = "-";
		firstRowNames[12] = "+";
		firstRowNames[13] = "Backspace";
	}
	
	private final String[] secondRowNames = {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\""};
	
	
	private int xLength;
	private int yLength = 50;
	
	public VirtualKeyBoard()
	{
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
	
		firstRow = new JButton[14];
		int inset = 1;
	
		for (int i = 0; i < firstRow.length; i ++)
		{
			c.fill = GridBagConstraints.CENTER;
			firstRow[i] = new JButton(firstRowNames[i]);
			firstRow[i].setBorder(BorderFactory.createRaisedBevelBorder());
		
			c.gridx = i * 2;
			c.gridy = 0;
			c.gridwidth = 2;
			c.ipadx = 20;
			c.ipady = 10;
					
			if (i == 13)
				{
				c.gridwidth = 4;
				}
			
			add(firstRow[i], c);
			xLength += c.ipadx * 1.45 + inset * 2;
		}
		
		secondRow = new JButton[secondRowNames.length];
	
		for (int i = 0; i < secondRow.length; i ++)
		{
			secondRow[i] = new JButton(secondRowNames[i]);
			secondRow[i].setBorder(BorderFactory.createRaisedBevelBorder());
							
			c.gridx = 1 + i * 2;
			c.gridy = 1;
			c.gridwidth = 2;
			c.ipadx = 20;
			c.ipady = 10;
			if(i == 0)
			{
				c.gridx = 0;
				c.gridwidth = 3;	
			}
			
			add(secondRow[i], c);
			
		}
	
}
	

	
	public int GetXLength()
	{			
		return xLength;
	}

	public int GetYLength()
	{
		return yLength;
	}
	
}

