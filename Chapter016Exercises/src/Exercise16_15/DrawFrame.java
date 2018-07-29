package Exercise16_15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DrawFrame extends JFrame
{
	JMenuBar menuBar;
	JMenu file;
	JMenuItem fileSave, fileOpen, fileQuit;
	
	private final JButton undoJButton;
	private final JButton clearJButton;
	
	/*
	private final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray",
			"Gray", "Green", "Light Gray", "Magenta", "Orange",
			"Pink", "Red", "White", "Yellow"};

	private final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
			Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
			Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	*/
	
	private final ColorHashMap colorMap;
 	private final JComboBox<String> colorJCombo;

	private final String[] shapeNames = {"Line", "Oval", "Rectangle"};
	private final JComboBox<String> shapeJCombo;
	private final JCheckBox filledJCheck;
	private final DrawPanel drawPanel;
	private JLabel statusBar;

	public DrawFrame()
	{
		super("Java Drawings");
		
		MenuHandler menuHandler = new MenuHandler();
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		file.addSeparator();
		file.setMnemonic(KeyEvent.VK_F);
		
			fileSave = new JMenuItem("Save");
			fileSave.addActionListener(menuHandler);
			file.add(fileSave);
			
			fileOpen = new JMenuItem("Open");
			fileOpen.addActionListener(menuHandler);
			file.add(fileOpen);
			
			fileQuit = new JMenuItem("Quit");
			fileQuit.addActionListener(menuHandler);
			file.add(fileQuit);
		menuBar.add(file);
		
		this.setJMenuBar(menuBar);

		ButtonHandler handler = new ButtonHandler();
		JPanel northPanel = new JPanel();
			northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			undoJButton = new JButton("Undo");
			undoJButton.addActionListener(handler);
			northPanel.add(undoJButton);

			clearJButton = new JButton("Clear");
			clearJButton.addActionListener(handler);
			northPanel.add(clearJButton);

			colorMap = new ColorHashMap();
			
			Set<String> colorNamesSet = colorMap.getColorHashMap().keySet();
			final String[] colorNames = new String[colorNamesSet.size()];
			Iterator<String> iterator = colorNamesSet.iterator();
			
			int i = 0;
			while(iterator.hasNext()) 
			{
				colorNames[i] = iterator.next();
				i ++;
			}
								
			colorJCombo = new JComboBox<String>(colorNames);
			colorJCombo.addItemListener(new ItemListener()
					{
						@Override
						public void itemStateChanged(ItemEvent event)
						{
							drawPanel.setCurrentColor(colorMap.getColorHashMap().get(colorNames[colorJCombo.getSelectedIndex()]));
						}
					});
			northPanel.add(colorJCombo);

			shapeJCombo = new JComboBox<String>(shapeNames);
			shapeJCombo.addItemListener(new ItemListener()
					{
						@Override
						public void itemStateChanged(ItemEvent event)
						{
							drawPanel.setShape(shapeJCombo.getSelectedIndex());
						}
					});
			northPanel.add(shapeJCombo);

			filledJCheck = new JCheckBox ("Filled", false);
			filledJCheck.addActionListener(handler);
			northPanel.add(filledJCheck);

		statusBar = new JLabel("Start drawing a shape.");

		drawPanel = new DrawPanel(statusBar);
		Border padding = BorderFactory.createLineBorder(this.getBackground(), 4);
		drawPanel.setBorder(padding);
		statusBar = drawPanel.getStatusLabel();

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(northPanel, BorderLayout.NORTH);
		pane.add(drawPanel, BorderLayout.CENTER);
		pane.add(statusBar, BorderLayout.SOUTH);
	}

	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent actionEvent)
		{

			JComponent component = (JComponent) actionEvent.getSource();

			if (component instanceof JButton)
			{
				JButton tempButton = (JButton) component;

				if (tempButton == undoJButton)
					drawPanel.clearLastShape();

				if (tempButton == clearJButton)
					drawPanel.clearDrawing();
			}

			if (component instanceof JCheckBox)
			{
				JCheckBox tempCheckBox = (JCheckBox) component;

				if (tempCheckBox.isSelected())
					drawPanel.setFilledShape(true);
				if (!tempCheckBox.isSelected())
					drawPanel.setFilledShape(false);
			}

		}
	}

	private class MenuHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent menuEvent)
		{
			JMenuItem actionMenu = (JMenuItem) menuEvent.getSource();
			
			if (actionMenu == fileSave)
			{
				
				try
				{
					new File("src/Exercise15_09/Drawings").mkdirs();
				}
				
				catch(SecurityException securityException)
				{
					statusBar.setText("Unable to create Folder");
				}
								
				JFileChooser fileChooser = new JFileChooser("src/Exercise15_09/Drawings");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showSaveDialog(drawPanel);
				
				if(result != JFileChooser.CANCEL_OPTION)
				{
					Path object = fileChooser.getSelectedFile().toPath();
					saveShapesObject(object);					
					
				}
				
			}
			
			if (actionMenu == fileOpen)
			{
				JFileChooser fileChooser = new JFileChooser("src/Exercise15_09/Drawings");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(drawPanel);
				
				
				if(result != JFileChooser.CANCEL_OPTION)
				{
					Path object = fileChooser.getSelectedFile().toPath();
					MyShape[] shapes = openShapesObject(object);
					drawPanel.setShapes(shapes);
					
					int shapesCount = 0;
					
					while (shapes[shapesCount]!=null)
						shapesCount++;
										
					drawPanel.setShapesCount(shapesCount);
					drawPanel.repaint();
				}
				
			}
			
			if (actionMenu == fileQuit)
			{
				System.exit(0);
			}
		}
	}
	
	private MyShape[] openShapesObject(Path object)
	{
		MyShape[] shapes = null;
		
		ObjectInputStream input = null;
		try // open file
		{
			input = new ObjectInputStream(Files.newInputStream(object));
		}
		catch (IOException ioException)
		{
			statusBar.setText("Unable to open desired file.");
		}
						
		try
		{
			shapes = (MyShape[]) input.readObject(); 
			input.close();
		}
		catch (ClassNotFoundException classNotFoundException)
		{
			statusBar.setText("File does not contain valid data.");
		}
		catch (IOException ioException)
		{
			statusBar.setText("Unable to open desired file.");
		}
				
		return shapes;
	}
	
	private void saveShapesObject(Path object)
	{
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(object));
			
			MyShape[] temp = drawPanel.getShapes();
	
			output.writeObject(temp);
			
			try
			{
				if (output != null)
					output.close();
			}
			catch (IOException ioException)
			{
			}
			
		}
		catch (IOException ioException)
		{
			statusBar.setText("Unable to create desired file.");
		}
		
		
	}
	

}
