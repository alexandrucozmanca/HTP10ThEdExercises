package Exercise12_015;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class AllEventsHandler
{
	public static void main(String[] args)
	{
		AllEventsFrame frame = new AllEventsFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(400, 670);
		Dimension d = frame.getPreferredSize();
		frame.setMinimumSize(d);


	}
}

class AllEventsFrame extends JFrame
{
	private final JLabel printer;
	private final JLabel color;

	private final JTextArea firstArea;
	private final JTextArea secondArea;
	private final JTextArea thirdArea;

	private final JCheckBox image;
	private final JCheckBox text;
	private final JCheckBox code;
	private final JCheckBox apply;

	private final JRadioButton selection;
	private final JRadioButton all;
	private final JRadioButton applet;
	private final ButtonGroup radioGrup;

	private final JButton ok;
	private final JButton cancel;
	private final JButton setup;
	private final JButton help;

	private final Color [] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
	private final String[] colorsOptions = {"Red", "Yellow", "Green", "Blue"};

	private final JComboBox<String> colorJCombo;

	private String[] pages;
	private final JList<String> pagesList;
	private final JList<String> printPagesList;
	private final JButton selectPages;

	//private final JPanel drawPanel;
	private final JLabel infoLabel1;
	private final JLabel infoLabel2;

	private final JPanel drawPanel;
	private int comboCounter = 0;

	public AllEventsFrame()
	{
		super("Printer");

		setLayout(new FlowLayout());

		JPanel northPanel = new JPanel();

			Container optionsPanel = new Container();

				optionsPanel.setLayout(new BorderLayout());
				printer = new JLabel("Printer: MyPrinter");
				optionsPanel.add(printer, BorderLayout.NORTH);


				Container centerOptionsPanel = new Container();

					centerOptionsPanel.setLayout(new FlowLayout());
					firstArea = new JTextArea(4, 4);
					firstArea.setEditable(false);
					centerOptionsPanel.add(firstArea);

					Box boxCheckBox = Box.createVerticalBox();

						CheckBoxHandler checkHandler = new CheckBoxHandler();
						image = new JCheckBox("Image");
						image.addActionListener(checkHandler);
						boxCheckBox.add(image);
						text = new JCheckBox("Text");
						text.addActionListener(checkHandler);
						boxCheckBox.add(text);
						code = new JCheckBox("Code");
						code.addActionListener(checkHandler);
						boxCheckBox.add(code);


					centerOptionsPanel.add(boxCheckBox);

					secondArea = new JTextArea(4, 3);
					secondArea.setLineWrap(true);
					secondArea.setWrapStyleWord(false);

					centerOptionsPanel.add(secondArea);

					Box radioBox = Box.createVerticalBox();

						RadioButtonHandler radioHandler = new RadioButtonHandler();

						selection = new JRadioButton("Selection");
						selection.addItemListener(radioHandler);
						all = new JRadioButton("All");
						all.addItemListener(radioHandler);
						applet = new JRadioButton("Applet");
						applet.addItemListener(radioHandler);

						radioGrup = new ButtonGroup();
						radioGrup.add(selection);
						radioGrup.add(all);
						radioGrup.add(applet);

						radioBox.add(selection);
						radioBox.add(all);
						radioBox.add(applet);


					centerOptionsPanel.add(radioBox);

					thirdArea = new JTextArea(4, 4);
					thirdArea.setEditable(false);
					thirdArea.setLineWrap(true);
					thirdArea.setWrapStyleWord(false);
					centerOptionsPanel.add(thirdArea);


				optionsPanel.add(centerOptionsPanel, BorderLayout.CENTER);


				Container southOptionsPanel = new Container();

					southOptionsPanel.setLayout(new FlowLayout());

					color = new JLabel("Color:");
					southOptionsPanel.add(color);

					colorJCombo = new JComboBox<String>(colorsOptions);
					colorJCombo.addItemListener(
							new ItemListener()
							{
								@Override
								public void itemStateChanged(ItemEvent event)
								{
									apply.setSelected(false);
									if (comboCounter % 2 == 1)
									{
										infoLabel2.setText(infoLabel1.getText());
										infoLabel1.setText(String.format("You selected %s.", event.getItem()));

									}

									comboCounter++;
								}


							});
					southOptionsPanel.add(colorJCombo);

					apply = new JCheckBox("Apply");
					apply.addActionListener(checkHandler);
					southOptionsPanel.add(apply);

				optionsPanel.add(southOptionsPanel, BorderLayout.SOUTH);

			northPanel.add(optionsPanel);


			JPanel buttonsPanel = new JPanel();

				ButtonHandler buttonHandler = new ButtonHandler();
				buttonsPanel.setLayout(new GridLayout(4, 1, 6, 6));
				ok = new JButton("OK");
				ok.addActionListener(buttonHandler);
				buttonsPanel.add(ok);
				cancel = new JButton("Cancel");
				cancel.addActionListener(buttonHandler);
				buttonsPanel.add(cancel);
				setup = new JButton("Setup...");
				setup.addActionListener(buttonHandler);
				buttonsPanel.add(setup);
				help = new JButton("Help");
				help.addActionListener(buttonHandler);
				buttonsPanel.add(help);

			northPanel.add(buttonsPanel);


		JPanel centerPanel = new JPanel();

			centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

			pages = new String[20];
			for (int i = 1; i <= pages.length; i++)
				pages[i - 1] = String.format("%d", i);

			pagesList = new JList<String>(pages);
			pagesList.setVisibleRowCount(5);
			pagesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			centerPanel.add(new JScrollPane(pagesList));

			selectPages = new JButton("Select Pages >>>");
			selectPages.addActionListener(buttonHandler);
			centerPanel.add(selectPages);

			printPagesList = new JList<String>();
			printPagesList.setVisibleRowCount(5);
			printPagesList.setFixedCellWidth(15);
			printPagesList.setFixedCellHeight(18);
			JScrollPane scrollPrintPagesList = new JScrollPane(printPagesList);
			scrollPrintPagesList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			centerPanel.add(scrollPrintPagesList);




		JPanel southPanel = new JPanel();

			southPanel.setLayout(new BorderLayout());
			Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			southPanel.setBorder(padding);

			drawPanel = new JPanel();
			drawPanel.setBackground(Color.WHITE);
			Dimension d = drawPanel.getPreferredSize();
			drawPanel.setPreferredSize(new Dimension(d.width, d.height + 300));
			MouseHandler mouseHandler = new MouseHandler();
			drawPanel.addMouseListener(mouseHandler);
			drawPanel.addMouseMotionListener(mouseHandler);

			southPanel.add(drawPanel, BorderLayout.NORTH);

			JPanel localCenter = new JPanel();

				localCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
				JLabel curentAction = new JLabel("Current action:");
				localCenter.add(curentAction);
				infoLabel1 = new JLabel();
				localCenter.add(infoLabel1);



			southPanel.add(localCenter, BorderLayout.CENTER);

			JPanel localSouth = new JPanel();

				localSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
				JLabel previousAction = new JLabel("Previous action:");
				localSouth.add(previousAction);
				infoLabel2 = new JLabel();
				localSouth.add(infoLabel2);


			southPanel.add(localSouth, BorderLayout.SOUTH);



		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		contentPane.setFocusable(true);

		KeyHandler keyHandler = new KeyHandler();
		contentPane.addKeyListener(keyHandler);

	}

	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent buttonEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("You pressed: %s", buttonEvent.getActionCommand()));

			JButton temp = (JButton) buttonEvent.getSource();
			if (temp == selectPages)
				{
				printPagesList.setListData(pagesList.getSelectedValuesList().toArray(new String[0]));
				infoLabel1.setText(infoLabel1.getText() + " and selected from pagesList.");
				}

		}



	}

	private class CheckBoxHandler implements ActionListener
	{
		String imageString = "", codeString = "", textString = "";
		@Override
		public void actionPerformed(ActionEvent checkEvent)
		{
			infoLabel2.setText(infoLabel1.getText());

			JCheckBox temp = (JCheckBox) checkEvent.getSource();

			if(temp.isSelected())
				infoLabel1.setText(String.format("You checked: %s", checkEvent.getActionCommand()));
			else
				{
				infoLabel1.setText(String.format("You unchecked: %s", checkEvent.getActionCommand()));
				}


			if (temp == image)
				if (temp.isSelected())
					imageString = "image\n";
				else
					imageString = "";

			if (temp == text)
				if(temp.isSelected())
					textString = "text\n";
				else
					textString = "";

			if (temp == code)
				if(temp.isSelected())
					codeString = "code\n";
				else
					codeString = "";

			if(temp == apply)
				if(temp.isSelected())
				{
					drawPanel.setBackground(colors[colorJCombo.getSelectedIndex()]);
				}
				else
					drawPanel.setBackground(Color.WHITE);

			String output = imageString + textString + codeString;

			firstArea.setText(output);
		}
	}

	private class RadioButtonHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent radioEvent)
		{


			JRadioButton temp = (JRadioButton) radioEvent.getItem();
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("You pressed radioButton: %s", temp.getActionCommand()));


			if (temp == selection)
				if (temp.isEnabled())
					thirdArea.setText(String.format("%s%s", firstArea.getText(),
							(secondArea.getSelectedText() == null ? "" :secondArea.getSelectedText())));
			if (temp == all)
				thirdArea.setText(firstArea.getText() + secondArea.getText());

			if (temp == applet)
				thirdArea.setText(firstArea.getText() + "Applet");

		}

	}

	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		@Override
		public void mouseClicked(MouseEvent mouseEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Mouse clicked at [%d,%d]",mouseEvent.getX(), mouseEvent.getY()));
		}

		@Override
		public void mousePressed(MouseEvent mouseEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Mouse pressed at [%d,%d]",mouseEvent.getX(), mouseEvent.getY()));
		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Mouse released at [%d,%d]",mouseEvent.getX(), mouseEvent.getY()));
		}

		@Override
		public void mouseEntered(MouseEvent mouseEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Mouse entered at [%d,%d]",mouseEvent.getX(), mouseEvent.getY()));
			drawPanel.setBackground(drawPanel.getBackground().darker());
		}

		@Override
		public void mouseExited(MouseEvent mouseEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Mouse exited at [%d,%d]",mouseEvent.getX(), mouseEvent.getY()));
			drawPanel.setBackground(drawPanel.getBackground().brighter());
		}

		@Override
		public void mouseDragged(MouseEvent mouseEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Mouse dragged at [%d,%d]",mouseEvent.getX(), mouseEvent.getY()));
		}

		@Override
		public void mouseMoved(MouseEvent mouseEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Mouse moved at [%d,%d]",mouseEvent.getX(), mouseEvent.getY()));
		}


	}

	private class KeyHandler extends KeyAdapter
	{
		@Override
		public void keyTyped(KeyEvent keyEvent)
		{
			infoLabel2.setText(infoLabel1.getText());
			infoLabel1.setText(String.format("Key Typed: %s", keyEvent.getKeyChar()));
			secondArea.setText(secondArea.getText() + String.format("%s", keyEvent.getKeyChar()));

		}
	}

}

