package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class JPanelStartLeft extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel imgUserGrey;
	private JLabel imgUPTC;
	public final int radio = 5;

	public JPanelStartLeft() {
		this.setSize(getMaximumSize());
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(248, 203, 46));
		GridBagConstraints gbc = new GridBagConstraints();
		borderPanel();
		initComponents(gbc);
		this.setVisible(true);
	}

	private void borderPanel() {
		Border bordeVacio = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.setOpaque(false);
		setBorder(null);
//		this.setBorder(bordeVacio);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Dibujar un rectángulo redondeado con las esquinas redondeadas
        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRect);

        g2d.dispose();

	}

	@Override
	public Insets getInsets() {
		return new Insets(radio + 1, radio + 1, radio + 2, radio);
	}

	private void initComponents(GridBagConstraints gbc) {
		firstLineUser(gbc);
		secondLineUser(gbc);
	}

	private void firstLineUser(GridBagConstraints gbc) {
		ImageIcon imageIcon = new ImageIcon("img/user.png");
		Image originalImage = imageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		imgUserGrey = new JLabel(resizedIcon);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(imgUserGrey, gbc);
	}

	private void secondLineUser(GridBagConstraints gbc) {
		ImageIcon imageIcon = new ImageIcon("img/logoUPTC.png");
		imgUserGrey = new JLabel(imageIcon);
		this.add(imgUserGrey, gbc);
	}

}
