package event;

import java.awt.Component;
import java.awt.Rectangle;


/**
 * Default realization of {@link ILayerStateUpdatedListener}. Just call repaint
 * method of component that registered on creation of listener. Repaint called
 * for all component or for rectangle inside component in depends of given
 * {@link LayerStateUpdatedEvent}.
 */
public class DefaultLayerStateUpdatedListener implements ILayerStateUpdatedListener {

	private Component parent;

	public DefaultLayerStateUpdatedListener(Component parent) {
		this.parent = parent;
	}

	public void stateUpdated(LayerStateUpdatedEvent event) {
		Rectangle rect = event.getChangedRect();
		if (rect != null) {
			parent.repaint(rect.x, rect.y, rect.width, rect.height);
		} else {
			parent.repaint();
		}
	}

}
