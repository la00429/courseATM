package co.edu.uptc.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextFieldUPTC extends JTextField {
	private static final long serialVersionUID = 1L;

	public JTextFieldUPTC() {
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		setForeground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		setPreferredSize(new Dimension(150, 30));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f)); 
		g2d.setColor(getBackground());
		g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));
		super.paintComponent(g);
		g2d.dispose();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new FlowLayout());

			JTextFieldUPTC textField = new JTextFieldUPTC();
			frame.add(textField);

			frame.setSize(300, 150);
			frame.setVisible(true);
		});
	}
}
