import java.util.concurrent.Executors;

import behavior.MoveRectangleBehavior;
import layer.RectangleLayer;

public class Main {

	private PaintFrame frame;
	private RectangleLayer layer = new RectangleLayer();

	public Main() {
		this.frame = new PaintFrame();
		layer.setCoordinates(10, 10, 20, 20);
	}

	public void start() {
		frame.getDrawPanel().addLayer(layer);
		Executors.newSingleThreadExecutor().execute(new MoveRectangleBehavior(layer));
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main().start();
	}
}
