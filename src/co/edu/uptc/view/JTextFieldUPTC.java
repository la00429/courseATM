package co.edu.uptc.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextFieldUPTC extends JTextField {
    private static final long serialVersionUID = 1L;

    public JTextFieldUPTC() {
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setForeground(Color.BLACK);
        setPreferredSize(new Dimension(354, 30));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Guardar los atributos originales del gr�fico
        RenderingHints rh = g2d.getRenderingHints();

        // Configurar renderizaci�n para obtener bordes m�s suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Dibujar el fondo redondeado con transparencia
        g2d.setColor(getBackground());
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));

        // Restaurar la configuraci�n original del gr�fico
        g2d.setRenderingHints(rh);

        // Llamar al m�todo paintComponent del padre para dibujar el texto
        super.paintComponent(g2d);

        // Dibujar el borde redondeado
        g2d.setColor(Color.BLACK);
        g2d.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));

        g2d.dispose();
    }
}
