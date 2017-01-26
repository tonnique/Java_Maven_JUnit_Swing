import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {
	public final static Point DEFAULT_LOCATION_POINT = new Point(550, 150);
	public final static Dimension DEFAULT_SIZE = new Dimension(400, 400);
	
	DrawPanel panel;

	public PaintFrame() {
		init();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void init() {
		setLocation(DEFAULT_LOCATION_POINT);
		setSize(DEFAULT_SIZE);
		panel = new DrawPanel();
		
		Container c = getContentPane();
		c.add(panel);
	}
	
	/**
	 * @return the draw panel
	 */
	public DrawPanel getDrawPanel() {
		return panel;
	}
}
