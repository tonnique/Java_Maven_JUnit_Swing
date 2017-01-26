import java.awt.*;
import javax.swing.*;

import event.DefaultLayerStateUpdatedListener;
import layer.AbstractLayer;

import java.util.*;


public class DrawPanel extends JPanel {
	
	private static final long serialVersionUID = -3889212301607059255L;
	
	private SortedSet<AbstractLayer> layers = new TreeSet<AbstractLayer>();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		//configureGraphics(gr);
		drawObjects(gr);
	}
	
	
	protected void configureGraphics(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
	}
	
	protected void drawObjects(Graphics2D gr) {
		for (AbstractLayer layer : layers) {
			layer.draw(gr);
		}
	}

	
	protected void addLayer(AbstractLayer layer) {
		layer.addLayerStateUpdatedListener(new DefaultLayerStateUpdatedListener(this));
		layers.add(layer);
	}
	
	protected void removeLayer(AbstractLayer layer) {
		layer.removeAllLayerStateUpdatedListeners();
		layers.remove(layer);
	}
	
	/**
	 * @param layers the layers to set
	 */
	 void setLayers(SortedSet<AbstractLayer> layers) {
	    this.layers = layers;
	 }

	 /**
	 * @return the layers
	 */
	 SortedSet<AbstractLayer> getLayers() {
	   return layers;
	 }	
}
