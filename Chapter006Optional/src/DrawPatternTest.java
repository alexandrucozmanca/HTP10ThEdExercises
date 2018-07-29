// Application to draw a predetermined pattern
import javax.swing.JFrame;

public class DrawPatternTest 
{
	public static void main(String[] args) 
	{
		DrawPattern checkerBoard = new DrawPattern();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(checkerBoard);
		application.setSize(100, 200);
		application.setVisible(true);
	}

}
