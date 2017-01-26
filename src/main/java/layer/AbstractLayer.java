package layer;

import java.awt.Graphics2D;

import javax.swing.event.EventListenerList;

import event.ILayerStateUpdatedListener;
import event.LayerStateUpdatedEvent;

/**
 * Common class for all layers. Support event listener registereng and method
 * for fire events.
 */
public abstract class AbstractLayer implements Comparable<AbstractLayer> {
	
	private int weight;
	private EventListenerList listenerList = new EventListenerList();
	
	public AbstractLayer() {
		this(0);
	}

	public AbstractLayer(int weight) {
		this.weight = weight;
	}
	
	public int compareTo(AbstractLayer o) {
		return weight - o.getWeight();
	}
	
	public abstract void draw(Graphics2D gr);
	
	
	   /**
	   * @param weight
	   * the weight to set
	   */
	   public void setWeight(int weight) {
	     this.weight = weight;
	   }

	   /**
	   * @return the weight
	   */
	   public int getWeight() {
	      return weight;
	   }

	   
	   /**
		 * Adds new listener to layer.
		 * 
		 * @param listener listener to add.
		 */
		public void addLayerStateUpdatedListener(ILayerStateUpdatedListener listener) {
			listenerList.add(ILayerStateUpdatedListener.class, listener);
		}

		/**
		 * Removes listener from layer.
		 * 
		 * @param listener listener to remove.
		 */
		public void removeLayerStateUpdatedListener(ILayerStateUpdatedListener listener) {
			listenerList.remove(ILayerStateUpdatedListener.class, listener);
		}

		/**
		 * Remove all listeners from layer.
		 */
		public void removeAllLayerStateUpdatedListeners() {
			listenerList = new EventListenerList();
		}

		protected void fireLayerStateUpdatedEvent(LayerStateUpdatedEvent evt) {
			Object[] listeners = listenerList.getListenerList();
			
			for (int i = 0; i < listeners.length; i += 2) {
				if (listeners[i] == ILayerStateUpdatedListener.class) {
					((ILayerStateUpdatedListener) listeners[i+1]) // !!!
							.stateUpdated(evt);
				}
			}
		}

	   
}
