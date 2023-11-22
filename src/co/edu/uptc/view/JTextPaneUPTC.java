package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextPane;

public class JTextPaneUPTC extends JTextPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color colorBack;

	public JTextPaneUPTC() {
		super();
		setOpaque(false); // Establecer la opacidad en falso para que el fondo sea transparente
		setEditable(false);
		setContentType("text/html");
		setSize(new Dimension(930, 380));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Dibuja un rect�ngulo con esquinas redondeadas
		g2d.setColor(getColorBack());
		g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 16, 16));

		// Llama al m�todo paintComponent de la clase padre para dibujar el contenido
		super.paintComponent(g2d);

		g2d.dispose();
	}

	public void setColorBack(Color colorBack) {
		this.colorBack = colorBack;
	}

	public Color getColorBack() {
		return colorBack;
	}
}