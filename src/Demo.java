import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo extends JPanel
{
	/** The game of this game panel **/
	private static Platform platform;
	
    public static JFrame frame = new JFrame();
	
    public Demo()
    {
    	super();
    }
    
	public static void main(String[] args) throws IOException
	{
		platform = new Platform();
		
        frame.setTitle("Train Station Simulation");
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Demo panel = new Demo();
        panel.setPreferredSize(new Dimension(500, 300));
        frame.add(panel);
        frame.setVisible(true);
        frame.setLocation(new Point(500, 100));
        frame.pack();
        
        while(true)
        {   
        	try
			{
				Thread.sleep(1000);
			} 
        	catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
            frame.repaint();
        	platform.update();
        }
	}
	
	public void paintComponent(Graphics graphics)
	{
		platform.draw(graphics);
	}
}