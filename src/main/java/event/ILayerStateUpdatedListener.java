package event;

import java.util.EventListener;

/**
 * Listener that registered for receiving events that occurred when state of
 * layer changed and it must be repainted.
 */
public interface ILayerStateUpdatedListener extends EventListener {

	/**
	 * Called when <code>event</code> occurred in layer.
	 * 
	 * @param event occurred event
	 */
	void stateUpdated(LayerStateUpdatedEvent event);

}
