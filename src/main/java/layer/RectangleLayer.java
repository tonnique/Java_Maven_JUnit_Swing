package layer;

import java.awt.Graphics2D;

import event.LayerStateUpdatedEvent;

/**
 * Simple draw rectangle on layer with configured coordinates.
 */
public class RectangleLayer extends AbstractLayer {

	private int x;
	private int y;
	private int width;
	private int height;

	@Override
	public void draw(Graphics2D gr) {
		if (width > 0 && height > 0) {
			gr.drawRect(x, y, width, height);
		}
	}

	/**
	 * Method set coordinates for painted rectangle. This method change the
	 * state of layer and must notify event part of layers about changes.
	 * 
	 * @param x1 x coordinate of painted rectangle.
	 * @param y1 y coordinate of painted rectangle.
	 * @param width width of painted rectangle.
	 * @param height height of painted rectangle.
	 */
	public void setCoordinates(int x1, int y1, int width, int height) {
		this.x = x1;
		this.y = y1;
		this.width = width;
		this.height = height;
		fireLayerStateUpdatedEvent(new LayerStateUpdatedEvent(this));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
