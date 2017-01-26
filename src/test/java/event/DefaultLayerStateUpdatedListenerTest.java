package event;

import static org.mockito.Mockito.*;
import java.awt.Component;
import java.awt.Rectangle;

import org.junit.Test;


public class DefaultLayerStateUpdatedListenerTest {
	
	@Test
	public void stateUpdatedMethodRepaintAllParentWhenRectOfChangesUndefined() throws Exception {
		Component parent = mock(Component.class);
		DefaultLayerStateUpdatedListener listener = new DefaultLayerStateUpdatedListener(parent);
		LayerStateUpdatedEvent event = new LayerStateUpdatedEvent(this);
		listener.stateUpdated(event);
		verify(parent).repaint();
	}
	
	@Test
	public void stateUpdatedMethodUpdateRectFromEventIfItIsDefined() throws Exception {
		Component parent = mock(Component.class);
		Rectangle rect = new Rectangle(10, 9, 8, 7);
		DefaultLayerStateUpdatedListener listener = new DefaultLayerStateUpdatedListener(parent);
		LayerStateUpdatedEvent event = new LayerStateUpdatedEvent(this, rect);
		listener.stateUpdated(event);
		verify(parent).repaint(rect.x, rect.y, rect.width, rect.height);
		
	}

}
