import javax.swing.JFrame;

public class DrawShapesTest
{

	public static void main(String[] args)
	{
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawRainbow panel = new DrawRainbow();
	
		application.setSize(400, 400);
		application.setVisible(true);

		for (int i = 0; i < 650; i ++)
			{
			
			application.remove(panel);
			
			application.setSize(2*i, i+50);
						
			application.add(panel);
			
			try        
			{
			    Thread.sleep(5);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
			
			
							
			}
	}

	
}
