package layer;

import static org.mockito.Mockito.*;
import java.awt.Graphics2D;
import org.junit.Test;
import event.LayerStateUpdatedEvent;


public class RectangleLayerTest {
	
	@Test
	public void drawMethodDrawsRecangleWithSpecifiedCoordinates() throws Exception {
		RectangleLayer layer = new RectangleLayer();
		Graphics2D gr = mock(Graphics2D.class);
		int x1 = 10;
		int y1 = 15;
		int width = 15;
		int height = 56;
		layer.setCoordinates(x1, y1, width, height);
		layer.draw(gr);
		verify(gr).drawRect(x1, y1, width, height);
	}
	
	@Test
	public void drawMethodDoNothingWhenCoordinatesIncorrect() throws Exception {
		RectangleLayer layer = new RectangleLayer();
		Graphics2D gr = mock(Graphics2D.class);
		int x1 = 10;
		int y1 = 15;
		int width = -2;//incorrect, lower then 0
		int height = -12;//incorrect, lower then 0
		layer.setCoordinates(x1, y1, width, height);
		layer.draw(gr);
		verify(gr, times(0)).drawRect(anyInt(), anyInt(), anyInt(), anyInt());
	}
	
	@Test
	public void setCoordinatesMethodMustFireEvent() throws Exception {
		RectangleLayer layer = spy(new RectangleLayer());
		layer.setCoordinates(0, 0, 0, 0);
		verify(layer).fireLayerStateUpdatedEvent(any(LayerStateUpdatedEvent.class));
	}

}
