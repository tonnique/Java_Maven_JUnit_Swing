package behavior;

import static org.mockito.Mockito.*;
import org.junit.Test;
import layer.RectangleLayer;


public class MoveRectangleBehaviorTest {
	
	@Test
	public void first300IterationMoveRectToTheRight() throws Exception {
		RectangleLayer layer = spy(new RectangleLayer());
		MoveRectangleBehavior behavior = new MoveRectangleBehavior(layer);
		int x = 10;
		int y = 10;
		int width = 20;
		int height = 20;
		layer.setCoordinates(x, y, width, height);
		for (int i = 0; i < 300; i++) {
			x = layer.getX();
			behavior.moveRectForIteration(i);
			verify(layer).setCoordinates(x + 1, y, width, height);
		}
	}

	@Test
	public void second300IterationMoveRectToTheBottom() throws Exception {
		RectangleLayer layer = spy(new RectangleLayer());
		MoveRectangleBehavior behavior = new MoveRectangleBehavior(layer);
		int x = 10;
		int y = 10;
		int width = 20;
		int height = 20;
		layer.setCoordinates(x, y, width, height);
		for (int i = 300; i < 600; i++) {
			x = layer.getX();
			behavior.moveRectForIteration(i);
			verify(layer).setCoordinates(x, y + 1, width, height);
		}
	}

	@Test
	public void third300IterationMoveRectToTheLeft() throws Exception {
		RectangleLayer layer = spy(new RectangleLayer());
		MoveRectangleBehavior behavior = new MoveRectangleBehavior(layer);
		int x = 10;
		int y = 10;
		int width = 20;
		int height = 20;
		layer.setCoordinates(x, y, width, height);
		for (int i = 600; i < 900; i++) {
			x = layer.getX();
			behavior.moveRectForIteration(i);
			verify(layer).setCoordinates(x - 1, y, width, height);
		}
	}
	
	@Test
	public void fourth300IterationMoveRectToTheTop() throws Exception {
		RectangleLayer layer = spy(new RectangleLayer());
		MoveRectangleBehavior behavior = new MoveRectangleBehavior(layer);
		int x = 10;
		int y = 10;
		int width = 20;
		int height = 20;
		layer.setCoordinates(x, y, width, height);
		for (int i = 900; i < 1200; i++) {
			x = layer.getX();
			behavior.moveRectForIteration(i);
			verify(layer).setCoordinates(x, y - 1, width, height);
		}
	}
	
}
