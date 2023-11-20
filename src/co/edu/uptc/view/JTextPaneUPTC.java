package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public class JTextPaneUPTC extends JTextPane {
	private int arcWidth = 20; // Radio para esquinas redondeadas
    private Color backgroundColor = Color.LIGHT_GRAY; // Color de fondo

    public JTextPaneUPTC() {
        super();
        setOpaque(false); // Establecer la opacidad en falso para que el fondo sea transparente
        setEditable(false);
        setContentType("text/html");
        setPreferredSize(new Dimension(930, 560));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja un rectángulo con esquinas redondeadas
        g2d.setColor(backgroundColor);
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcWidth));

        // Llama al método paintComponent de la clase padre para dibujar el contenido
        super.paintComponent(g2d);

        g2d.dispose();
    }
}