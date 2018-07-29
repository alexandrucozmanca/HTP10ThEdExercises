package Exercise12_011;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Exercise12_11 
{
	public static void main(String[] args)
	{
		PrintFrame frame = new PrintFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

	}
}

	class PrintFrame extends JFrame
	{
		private final JLabel printer;
		private final JLabel quality;
		
		private final JTextArea firstArea;
		private final JTextArea secondArea;
		private final JTextArea thirdArea;
		
		private final JCheckBox image;
		private final JCheckBox text;
		private final JCheckBox code;
		private final JCheckBox printToFile;
		
		private final JRadioButton selection;
		private final JRadioButton all;
		private final JRadioButton applet;
		private final ButtonGroup radioGrup;
		
		private final JButton ok;
		private final JButton cancel;
		private final JButton setup;
		private final JButton help;
		
		private final JComboBox<String> printQuality;
		
		
		public PrintFrame()
		{
			super("Printer");
			setLayout(new FlowLayout());
			
			Container optionsPanel = new Container();
			optionsPanel.setLayout(new BorderLayout());
			
			printer = new JLabel("Printer: MyPrinter");
			optionsPanel.add(printer, BorderLayout.NORTH);
			
			Container centerOptionsPanel = new Container();
			centerOptionsPanel.setLayout(new FlowLayout());
			firstArea = new JTextArea(4, 4);
			centerOptionsPanel.add(firstArea);
			
			Box boxCheckBox = Box.createVerticalBox();
			image = new JCheckBox("Image");
			boxCheckBox.add(image);
			text = new JCheckBox("Text");
			boxCheckBox.add(text);
			code = new JCheckBox("Code");
			boxCheckBox.add(code);
			centerOptionsPanel.add(boxCheckBox);
			
			secondArea = new JTextArea(4, 3);
			centerOptionsPanel.add(secondArea);
			
			Box radioBox = Box.createVerticalBox();
			selection = new JRadioButton("Selection",true); 
			all = new JRadioButton("All");
			applet = new JRadioButton("Applet");
			radioGrup = new ButtonGroup();
			radioGrup.add(selection);
			radioGrup.add(all);
			radioGrup.add(applet);
			radioBox.add(selection);
			radioBox.add(all);
			radioBox.add(applet);
			
			centerOptionsPanel.add(radioBox);
			
			thirdArea = new JTextArea(4, 4);
			centerOptionsPanel.add(thirdArea);
			
			optionsPanel.add(centerOptionsPanel, BorderLayout.CENTER);
			
			
			Container southOptionsPanel = new Container();
			southOptionsPanel.setLayout(new FlowLayout());
			quality = new JLabel("Print Quality");
			southOptionsPanel.add(quality);
			String[] qualityOptions = {"High", "Medium", "Low"};
			printQuality = new JComboBox<String>(qualityOptions);
			southOptionsPanel.add(printQuality);
			printToFile = new JCheckBox("Print to File");
			southOptionsPanel.add(printToFile);
			
			optionsPanel.add(southOptionsPanel, BorderLayout.SOUTH);
			
			add(optionsPanel);
			
			
			
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new GridLayout(4, 1, 6, 6));
			ok = new JButton("OK");
			buttonsPanel.add(ok);
			cancel = new JButton("Cancel");
			buttonsPanel.add(cancel);
			setup = new JButton("Setup...");
			buttonsPanel.add(setup);
			help = new JButton("Help");
			buttonsPanel.add(help);
			
			
			add(buttonsPanel);
		}
		
	}
	
