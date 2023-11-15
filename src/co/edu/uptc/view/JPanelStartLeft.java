package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		int width = getWidth();
		int height = getHeight();
		RoundRectangle2D roundedRect = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 30, 30);
		g2d.setColor(getBackground());
		g2d.fill(roundedRect);
		g2d.dispose();
	}

	private void initComponents(GridBagConstraints gbc) {
		firstLineUser(gbc);
		secondLineUser(gbc);
	}

	/**
	 * 
	 * @param gbc
	 */
	private void firstLineUser(GridBagConstraints gbc) {
		ImageIcon imageIcon = new ImageIcon("img/user.png");
		Image originalImage = imageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(469, 465, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		imgUserGrey = new JLabel(resizedIcon);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		this.add(imgUserGrey, gbc);
	}

	private void secondLineUser(GridBagConstraints gbc) {
	    ImageIcon imageIcon = new ImageIcon("img/logoUPTC.png");
	    Image originalImage = imageIcon.getImage();
	    Image resizedImage = originalImage.getScaledInstance(308, 132, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
	    JLabel imgUserGrey = new JLabel(resizedIcon);

	    // Configuración de GridBagConstraints para ubicar en la esquina inferior izquierda
	    gbc.anchor = GridBagConstraints.SOUTHWEST; // Esquina inferior izquierda
	    gbc.fill = GridBagConstraints.NONE; // Sin relleno
	    gbc.weightx = 0.0; // No expandir en el eje X
	    gbc.weighty = 0.0; // No expandir en el eje Y
	    gbc.gridx = 0; // Posición en la columna cero
	    gbc.gridy = 1; // Posición en la fila uno
	    gbc.insets = new Insets(0, 5, 20, 5); // Relleno para separación

	    this.add(imgUserGrey, gbc);
	}


}
