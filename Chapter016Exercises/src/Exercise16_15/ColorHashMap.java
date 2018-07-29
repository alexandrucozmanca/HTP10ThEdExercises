package Exercise16_15;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorHashMap 
{
	final private String[] colors = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
			"Orange", "Pink", "Red", "White", "Yellow"};
	private Map <String, Color> colorMap;
	
	public ColorHashMap()
	{
		colorMap = new HashMap<String, Color>();
		
		for (String color : colors)
		{
			switch(color)
			{
				case "Black":
					colorMap.put(color, Color.BLACK);
					break;
			
				case "Blue":
					colorMap.put(color, Color.BLUE);
					break;
					
				case "Cyan":
					colorMap.put(color, Color.CYAN);
					break;
					
				case "Dark Gray":
					colorMap.put(color, Color.DARK_GRAY);
					break;
					
				case "Gray":
					colorMap.put(color, Color.GRAY);
					break;
					
				case "Green":
					colorMap.put(color, Color.GREEN);
					break;
					
				case "Light Gray":
					colorMap.put(color, Color.LIGHT_GRAY);
					break;
					
				case "Magenta":
					colorMap.put(color, Color.MAGENTA);
					break;
					
				case "Orange":
					colorMap.put(color, Color.ORANGE);
					break;
					
				case "Pink":
					colorMap.put(color, Color.PINK);
					break;
					
				case "Red":
					colorMap.put(color, Color.RED);
					break;
					
				case "White":
					colorMap.put(color, Color.WHITE);
					break;
					
				case "Yellow":
					colorMap.put(color, Color.YELLOW);
					break;
			}
		}
		
	}
	
	public Map<String, Color> getColorHashMap()
	{
		return colorMap;
	}
	
}
