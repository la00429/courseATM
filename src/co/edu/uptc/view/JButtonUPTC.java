package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class JButtonUPTC extends JButton {
	private static final long serialVersionUID = 1L;

	public JButtonUPTC(String text) {
		super(text);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setFocusPainted(false);
		setFont(new Font("Arial", Font.BOLD, 16));
		setBorderPainted(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
	}
}
