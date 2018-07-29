package Exercise12_018;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class VirtualKeyBoard2 extends JPanel implements KeyListener
{

	private JTextArea textArea;
	private JButton[] firstRow;
	private JButton[] secondRow;
	private JButton[] thirdRow;
	private JButton[] fourthRow;
	private JButton[] fifthRow;
	private final String[] firstRowNames = new String[14];
	private final Color buttonColor;
	{
		firstRowNames[0] = "`";

		for (int i = 1 ; i <= 10; i ++)
		{
			if (i != 10)
				firstRowNames[i] = String.format("%d",i);
			else
				firstRowNames[i] = "0";
		}

		firstRowNames[11] = "-";
		firstRowNames[12] = "=";
		firstRowNames[13] = "Backspace";
	}

	private final String[] secondRowNames = {"Tab", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "\\"};
	private final String[] thirdRowNames = {"Caps", "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "Enter"};
	private final String[] fourthRowNames = {"Shift", "z", "x", "c", "v", "b", "n", "m", ",", ".", "/","", "▲"};
	private final String[] fifthRowNames = {""," ","", "◄", "▼", "►"};
	
	private final String[] upperFirstRowNames = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "Backspace"};
	private final String[] upperSecondRowNames = {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "{", "}", "|"};
	private final String[] upperThirdRowNames = {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "Enter"};
	private final String[] upperFourthRowNames = {"Shift", "Z", "X", "C", "V", "B", "N", "M", "<", ">", "?","", "▲"};
	
	private final String[][] namesArray = new String[5][];
	{
		namesArray[0] = firstRowNames;
		namesArray[1] = secondRowNames;
		namesArray[2] = thirdRowNames;
		namesArray[3] = fourthRowNames;
		namesArray[4] = fifthRowNames;
	}
	
	private final String[][] upperNamesArray = new String[5][];
	{
		upperNamesArray[0] = upperFirstRowNames;
		upperNamesArray[1] = upperSecondRowNames;
		upperNamesArray[2] = upperThirdRowNames;
		upperNamesArray[3] = upperFourthRowNames;
		upperNamesArray[4] = fifthRowNames;
	}
	
	private final JButton[][] allButtons;
	private int capsLock;
	
	public VirtualKeyBoard2()
	{
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));

		textArea = new JTextArea(8,61);
		add(textArea);
		textArea.addKeyListener(this);
		textArea.setFocusable(true);
		textArea.requestFocusInWindow();
		
		
		firstRow = new JButton[14];

		for (int i = 0; i < firstRow.length; i ++)
		{
			firstRow[i] = new JButton(firstRowNames[i]);
			firstRow[i].setBackground(Color.WHITE);

			Dimension d = new Dimension(40, 40);
			firstRow[i].setPreferredSize(d);

			if(i == 13)
				firstRow[i].setPreferredSize(new Dimension(85, 40));

			firstRow[i].setBorder(BorderFactory.createRaisedBevelBorder());
			add(firstRow[i]);
		}

		secondRow = new JButton[14];

		for (int i = 0; i < secondRow.length; i ++)
		{
			secondRow[i] = new JButton(secondRowNames[i]);
			secondRow[i].setBackground(Color.WHITE);
			
			Dimension d = new Dimension(40, 40);
			secondRow[i].setPreferredSize(d);

			if(i == 0)
				secondRow[i].setPreferredSize(new Dimension(60, 40));

			secondRow[i].setBorder(BorderFactory.createRaisedBevelBorder());
			add(secondRow[i]);

		}

		thirdRow = new JButton[13];

		for (int i = 0; i < thirdRow.length; i ++)
		{
			thirdRow[i] = new JButton(thirdRowNames[i]);

			Dimension d = new Dimension(40, 40);
			thirdRow[i].setPreferredSize(d);
			thirdRow[i].setBackground(Color.WHITE);
			
			if(i == 0)
				thirdRow[i].setPreferredSize(new Dimension(60, 40));


			if(i == 12)
				thirdRow[i].setPreferredSize(new Dimension(85, 40));

			thirdRow[i].setBorder(BorderFactory.createRaisedBevelBorder());
			add(thirdRow[i]);
		}

		fourthRow = new JButton[13];

		for (int i = 0; i < fourthRow.length; i ++)
		{
			fourthRow[i] = new JButton(fourthRowNames[i]);

			
			Dimension d = new Dimension(40, 40);
			fourthRow[i].setPreferredSize(d);
			fourthRow[i].setBackground(Color.WHITE);
			
			if(i == 0)
				fourthRow[i].setPreferredSize(new Dimension(85, 40));

			//disabled button to add padding
			if(i == 11)
			{
				fourthRow[i].setBackground(this.getBackground());
				fourthRow[i].setEnabled(false);
				fourthRow[i].setBorderPainted(false);
				fourthRow[i].setPreferredSize(new Dimension(15, 40));
			}

			fourthRow[i].setBorder(BorderFactory.createRaisedBevelBorder());
			add(fourthRow[i]);
		}

		fifthRow = new JButton[6];

		for (int i = 0; i < fifthRow.length; i ++)
		{
			fifthRow[i] = new JButton(fifthRowNames[i]);

			Dimension d = new Dimension(40, 40);
			fifthRow[i].setPreferredSize(d);
			fifthRow[i].setBackground(Color.WHITE);
			
			// disabled button to add padding
			if(i == 0)
			{
				fifthRow[i].setBackground(this.getBackground());
				fifthRow[i].setEnabled(false);
				fifthRow[i].setBorderPainted(false);
				fifthRow[i].setPreferredSize(new Dimension(175, 40));
			}

			if(i == 1)
				fifthRow[i].setPreferredSize(new Dimension(265, 40));

			//disabled button to add padding
			if(i == 2)
			{
				fifthRow[i].setBackground(this.getBackground());
				fifthRow[i].setEnabled(false);
				fifthRow[i].setBorderPainted(false);
				fifthRow[i].setPreferredSize(new Dimension(60, 40));
				fifthRow[i].requestFocus();
			}

			fifthRow[i].setBorder(BorderFactory.createRaisedBevelBorder());
			
			add(fifthRow[i]);
		
		}
		
		buttonColor = firstRow[0].getBackground();
		
		allButtons = new JButton[5][];
		{
			allButtons[0] = firstRow;
			allButtons[1] = secondRow;
			allButtons[2] = thirdRow;
			allButtons[3] = fourthRow;
			allButtons[4] = fifthRow;
		}
		
		capsLock = 0;
		
		setSize(685, 395);
			
	}

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{

		char key = Character.toUpperCase(keyEvent.getKeyChar());
		String temp = String.format("%s", key);
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE)
			firstRow[13].setBackground(buttonColor.darker());
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_TAB)
			secondRow[0].setBackground(buttonColor.darker());
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_CAPS_LOCK)
			{
			thirdRow[0].setBackground(buttonColor.darker());
			
			if(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK))
				for (int i = 1; i < allButtons.length; i++)
					for (int j = 0; j < allButtons[i].length; j++)
						{
						if (i == 1 && (j == 0 || j> 10))
							continue;
						
						if (i == 2 && (j == 0 || j> 9))
							continue;
						
						if (i == 3 && (j == 0 || j> 7))
							continue;
						
						allButtons[i][j].setText(upperNamesArray[i][j]);
						}
				
				
			
			else
				for (int i = 1; i < allButtons.length; i++)
					for (int j = 0; j < allButtons[i].length; j++)
						allButtons[i][j].setText(namesArray[i][j]);
						
			}
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
			thirdRow[12].setBackground(buttonColor.darker());
							
					
		if(keyEvent.isShiftDown())
		{
			fourthRow[0].setBackground(buttonColor.darker());
		
						
				for (int i = 0; i < allButtons.length; i++)
					for (int j = 0; j < allButtons[i].length; j++)
						allButtons[i][j].setText(upperNamesArray[i][j]);
			
			
		}
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
			fourthRow[12].setBackground(buttonColor.darker());

		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
			fifthRow[3].setBackground(buttonColor.darker());

		if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
			fifthRow[4].setBackground(buttonColor.darker());

		if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
			fifthRow[5].setBackground(buttonColor.darker());
		
		for (int i = 0; i < firstRow.length; i ++)
		if(firstRow[i].getText().equals(temp))
			firstRow[i].setBackground(buttonColor.darker());

		for (int i = 0; i < secondRow.length; i ++)
			if(secondRow[i].getText().equals(temp))
				secondRow[i].setBackground(buttonColor.darker());

		for (int i = 0; i < thirdRow.length; i ++)
			if(thirdRow[i].getText().equals(temp))
				thirdRow[i].setBackground(buttonColor.darker());

		for (int i = 0; i < fourthRow.length; i ++)
			if(fourthRow[i].getText().equals(temp))
				fourthRow[i].setBackground(buttonColor.darker());

		for (int i = 0; i < fifthRow.length; i ++)
			if(fifthRow[i].getText().equals(temp))
				fifthRow[i].setBackground(buttonColor.darker());
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		char key = Character.toUpperCase(keyEvent.getKeyChar());
		String temp = String.format("%s", key);
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE)
			firstRow[13].setBackground(buttonColor.brighter());
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_TAB)
			secondRow[0].setBackground(buttonColor.brighter());
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_CAPS_LOCK)
			thirdRow[0].setBackground(buttonColor.brighter());

		
		if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
			thirdRow[12].setBackground(buttonColor.brighter());
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_SHIFT && !keyEvent.isShiftDown())
		{
			fourthRow[0].setBackground(buttonColor.brighter());
			
			
			for (int i = 0; i < allButtons.length; i++)
				for (int j = 0; j < allButtons[i].length; j++)
					allButtons[i][j].setText(namesArray[i][j]);
			
						
		}
		
				
		if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
			fourthRow[12].setBackground(buttonColor.brighter());

		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
			fifthRow[3].setBackground(buttonColor.brighter());

		if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
			fifthRow[4].setBackground(buttonColor.brighter());

		if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
			fifthRow[5].setBackground(buttonColor.brighter());
		
		
		// to do - add cases for lowerkeys with respect to CAPS and SHIFT
		
		for (int i = 0; i < firstRow.length; i ++)
		if(firstRow[i].getText().equals(temp))
			firstRow[i].setBackground(buttonColor.brighter());

		for (int i = 0; i < secondRow.length; i ++)
			if(secondRow[i].getText().equals(temp))
				secondRow[i].setBackground(buttonColor.brighter());

		for (int i = 0; i < thirdRow.length; i ++)
			if(thirdRow[i].getText().equals(temp))
				thirdRow[i].setBackground(buttonColor.brighter());

		for (int i = 0; i < fourthRow.length; i ++)
			if(fourthRow[i].getText().equals(temp))
				fourthRow[i].setBackground(buttonColor.brighter());

		for (int i = 0; i < fifthRow.length; i ++)
			if(fifthRow[i].getText().equals(temp))
				fifthRow[i].setBackground(buttonColor.brighter());
		
	}


	@Override
	public void keyTyped(KeyEvent keyEvent)
	{
		
	}

}

