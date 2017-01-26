package event;

import java.awt.Rectangle;
import java.util.EventObject;

/**
 * Event, that contains information about changes state of observable layer. May
 * contains information about part of component, where changes occurred.
 */
public class LayerStateUpdatedEvent extends EventObject {

	private static final long serialVersionUID = 4991231823740877420L;
	private long time;
	private Rectangle changedRect;

	public LayerStateUpdatedEvent(Object source) {
		this(source, null);
	}

	public LayerStateUpdatedEvent(Object source, Rectangle rect) {
		super(source);
		this.time = System.currentTimeMillis();
		this.changedRect = rect;
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @param changedRect the changedRect to set
	 */
	public void setChangedRect(Rectangle changedRect) {
		this.changedRect = changedRect;
	}

	/**
	 * @return the changedRect
	 */
	public Rectangle getChangedRect() {
		return changedRect;
	}

}
