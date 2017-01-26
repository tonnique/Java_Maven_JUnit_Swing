import static org.junit.Assert.*;

import java.awt.*;
import javax.swing.*;

import org.junit.Test;



public class PaintFrameTest {

	@Test
	public void paintFrameAt50x50Position() throws Exception {
		PaintFrame frame = new PaintFrame();
				
		Point actual = frame.getLocation();
		Point expected = PaintFrame.DEFAULT_LOCATION_POINT;			
		assertEquals("PaintFrame must be at position (50, 50) after creation",
				  actual, expected);		
	}
	
	@Test
	public void paintFrameHas400x400Size() throws Exception {
		PaintFrame frame = new PaintFrame();
		Dimension actual = frame.getSize();
		Dimension expected = PaintFrame.DEFAULT_SIZE;
		assertEquals("PaintFrame must have size 400x400 after creation",
	         expected, actual);
	}
	
	@Test
	public void paintFrameNotResizable() throws Exception {
		PaintFrame frame = new PaintFrame();
		assertFalse("PaintFrame must be non-resizable.", frame.isResizable());
	}
	
	@Test
	public void paintFrameHasBorderLayoutManager() throws Exception {
		PaintFrame frame = new PaintFrame();
		assertTrue("LayoutManager of PaintFrame must be a BorderLayout",
	         frame.getContentPane().getLayout() instanceof BorderLayout);
	}
	
	/*
	@Test
	public void paintFrameContainsOnlyOnePanel() throws Exception {
		PaintFrame frame = new PaintFrame();
		Component[] components = frame.getContentPane().getComponents();
		assertEquals("PaintFrame must contains only one component", 1, components.length);
		assertTrue("PaintFrame contains only one JPanel", components[0] instanceof JPanel);
	}
	*/
	
	@Test
	public void paintFrameContainsOnlyOneLinen() throws Exception {
		PaintFrame frame = new PaintFrame();
		Component [] components = frame.getContentPane().getComponents();
		assertEquals("PaintFrame must contains only one component", 1, components.length);
		assertTrue("PaintFrame contains only one JPanel", components[0] instanceof DrawPanel);
	}
	
	@Test
	public void paintFrameMustExitedOnClose() throws Exception {
		PaintFrame frame = new PaintFrame();
		assertEquals("PaintFrame must exited on close operation.", JFrame.EXIT_ON_CLOSE,
	                     frame.getDefaultCloseOperation());
	}

}
