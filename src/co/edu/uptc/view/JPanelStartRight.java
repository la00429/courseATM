package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelStartRight extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JButtonUPTC button;

	public JPanelStartRight() {
		this.setSize(getMaximumSize());
		initComponents();
		this.setBackground(new Color(255, 255, 255));
		this.setVisible(true);
	}

	private void initComponents() {
		title = new JLabel();
		button = new JButtonUPTC(null);
	}

	public JLabel getTitle() {
		return title;
	}

	public JButtonUPTC getButton() {
		return button;
	}

}
