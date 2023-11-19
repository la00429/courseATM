package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class JComboBoxUI extends BasicComboBoxUI {
	private static final int ROUNDNESS = 15; // Radio de redondez de los bordes

	@Override
	protected JButton createArrowButton() {
		super.configureArrowButton();
		JButton arrowButton = new BasicArrowButton(BasicArrowButton.SOUTH);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setBorder(BorderFactory.createEmptyBorder());
		arrowButton.setForeground(Color.BLACK); // Cambia el color de la flecha
		arrowButton.setBackground(new Color(0, 0, 0, 0)); // Establece el fondo del botón a transparente
		return arrowButton;
	}

	@Override
	protected void installDefaults() {
		super.installDefaults();
		JComboBoxBorder roundBorder = new JComboBoxBorder(ROUNDNESS); // Utiliza el radio que necesites
		comboBox.setBorder(roundBorder);
		comboBox.setOpaque(false); // Establece el JComboBox como no opaco para ver el fondo detrás del borde
	}

	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
		if (comboBox.isEnabled() && !comboBox.isEditable()) {
			g.setColor(Color.WHITE);
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		} else if (hasFocus) {
			g.setColor(comboBox.getBackground());
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
	}
	
	
}
