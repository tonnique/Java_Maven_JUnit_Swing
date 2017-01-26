package behavior;

import layer.RectangleLayer;

/**
 * Behavior of the moving rectangle. Rectangle moves by square trajectory with
 * size 300x300.
 */
public class MoveRectangleBehavior implements Runnable {

	private static final int MOVING_TRAJECTORY_SIZE = 300;
	private RectangleLayer layer;

	/**
	 * Constract behavior runnable.
	 * 
	 * @param layer
	 *            layer with rectangle. Its state will be changed throw
	 *            execution of behavior.
	 */
	public MoveRectangleBehavior(RectangleLayer layer) {
		this.layer = layer;
	}

	public void run() {
		int i = 0;
		while (true) {
			try {
				Thread.sleep(5);
				moveRectForIteration(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

	/**
	 * Move rectangle on one pixel in dependencies on given param.
	 * 
	 * @param numberOfIteration
	 *            number of moving action in thread.
	 */
	public void moveRectForIteration(int numberOfIteration) {
		switch ((numberOfIteration / MOVING_TRAJECTORY_SIZE) % 4) {
		case 0:
			moveRight();
			break;
		case 1:
			moveBottom();
			break;
		case 2:
			moveLeft();
			break;
		case 3:
			moveTop();
			break;
		default:
			moveRight();
			break;
		}
	}

	private void moveTop() {
		layer.setCoordinates(layer.getX(), layer.getY() - 1, layer.getWidth(),
				layer.getHeight());
	}

	private void moveLeft() {
		layer.setCoordinates(layer.getX() - 1, layer.getY(), layer.getWidth(),
				layer.getHeight());
	}

	private void moveBottom() {
		layer.setCoordinates(layer.getX(), layer.getY() + 1, layer.getWidth(),
				layer.getHeight());
	}

	private void moveRight() {
		layer.setCoordinates(layer.getX() + 1, layer.getY(), layer.getWidth(),
				layer.getHeight());
	}
}