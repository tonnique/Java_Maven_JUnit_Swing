import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.*;

import org.junit.Test;
import org.mockito.InOrder;

import layer.AbstractLayer;

public class LinenTest {
	
	// “ребуетс€ библиотека org.mockito.Mockito.*
	@Test
	public void configureGraphicsSetAntializingAndRenderQuality() throws Exception {
		DrawPanel panel = spy(new DrawPanel());
		Graphics2D g = mock(Graphics2D.class);
		panel.configureGraphics(g);
		InOrder order = inOrder(g);
		order.verify(g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		order.verify(g).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}
	
	@Test
	public void drawObjectsDrawsGreenRectangleAndBlueLine() throws Exception {
		DrawPanel panel = spy(new DrawPanel());
		Graphics2D g = mock(Graphics2D.class);
		panel.drawObjects(g);
		InOrder order = inOrder(g);
		order.verify(g).setColor(new Color(0, 255, 0));
		order.verify(g).fillRect(10, 10, 92, 17);
		order.verify(g).setColor(new Color(0, 0, 255));
		order.verify(g).drawLine(32, 17, 250, 320);		
	}
	
	/*
	 * ¬ы только посмотрите кака€ херн€ получилась. “есты практически в точности повтор€ют 
	 * будущий исходный код. ћне показалось это не совсем правильным, но тем не менее € не 
	 * знаю как тестировать подобную отрисовку графики по-другому. ¬ основном такое 
	 * получаетс€ потому, что рисование элементов на доске должно происходить в соответствии 
	 * с их положением по глубине (ось z) относительно друг друга. “ем самым последовательность 
	 * вызовов методов играет большую роль и вли€ет на выполнение функциональных требований.
	 * 
	 * Ќесмотр€ на то, что у нас получилс€ довольно странный тест (точнее два теста), это 
	 * позволило нам фиксировать функциональность отрисовки панели, что, в общем то, не плохо. 
	 */
	
	@Test
	public void addLayerAddsGivenParamIntoInnerLayersField() throws Exception {
		DrawPanel panel = new DrawPanel();
		AbstractLayer layer = new StubLayer(1);
		panel.addLayer(layer);
		assertTrue("addLayer method must adds layer to inner field of linen.",
				panel.getLayers().contains(layer));
	}

	@Test
	public void addLayerThatAlreadyExistIgnored() throws Exception {
		DrawPanel panel = new DrawPanel();
		AbstractLayer layer1 = new StubLayer(1);
		AbstractLayer layer2 = new StubLayer(2);
		panel.addLayer(layer1);
		panel.addLayer(layer2);
		int oldSize = panel.getLayers().size();
		panel.addLayer(layer1);
		assertEquals("addLayer method must ignored when layer already added.",
				oldSize, panel.getLayers().size());
	}

	@Test
	public void removeLayerRemovesGivenParamFromInnerLayersField()
			throws Exception {
		DrawPanel linen = new DrawPanel();
		AbstractLayer layer = new StubLayer(1);
		linen.getLayers().add(layer);
		linen.removeLayer(layer);
		assertFalse("removeLayer method must removes layer from inner "
				+ "field of linen.", linen.getLayers().contains(layer));
	}

	@Test
	public void removingNonExistLayerIgnored() throws Exception {
		DrawPanel panel = new DrawPanel();
		AbstractLayer layer = new StubLayer(1);
		AbstractLayer layer2 = new StubLayer(2);
		panel.getLayers().add(layer);
		int oldSize = panel.getLayers().size();
		panel.removeLayer(layer2);
		assertEquals("removeLayer method must ignored if given layer "
				+ "not exist in inner set.", oldSize, panel.getLayers().size());
	}

	@Test
	public void innerSetSortedByLayerWeight() throws Exception {
		DrawPanel panel = new DrawPanel();
		AbstractLayer layer1 = new StubLayer(1);
		AbstractLayer layer2 = new StubLayer(2);
		AbstractLayer layer3 = new StubLayer(3);
		panel.addLayer(layer2);
		panel.addLayer(layer3);
		panel.addLayer(layer1);
		int old = 4;
		for (AbstractLayer layer : panel.getLayers()) {
			if (old < layer.getWeight()) {
				fail("inner set of layers must be sorted");
			}
			old = layer.getWeight();
		}
	}
	
	@Test
	public void drawObjectsDrawsAllLayersSortedByWeight() throws Exception {
		DrawPanel panel = new DrawPanel();
		Graphics2D gr = mock(Graphics2D.class);
		AbstractLayer layer1 = spy(new StubLayer(1));
		AbstractLayer layer2 = spy(new StubLayer(2));
		AbstractLayer layer3 = spy(new StubLayer(3));
		panel.addLayer(layer2);
		panel.addLayer(layer3);
		panel.addLayer(layer1);
		panel.drawObjects(gr);
		InOrder inOrder = inOrder(layer1, layer2, layer3);
		inOrder.verify(layer3).draw(gr);
		inOrder.verify(layer2).draw(gr);
		inOrder.verify(layer1).draw(gr);
	}

	private class StubLayer extends AbstractLayer {

		public StubLayer(int weight) {
			super(weight);
		}

		@Override
		public void draw(Graphics2D gr) {
			// Nothing
		}
	}
}
