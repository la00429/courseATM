package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelStartLeft extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel imgUserGrey;
	private JLabel imgUPTC;

	public JPanelStartLeft() {
		this.setSize(getMaximumSize());
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(248, 203, 46));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 30, 20, 0);
		initComponents(gbc);
		this.setVisible(true);
	}

	private void initComponents(GridBagConstraints gbc) {
		firstLineUser();
	}

	private void firstLineUser() {
		ImageIcon imageIcon = new ImageIcon("img/logoUPTC.png");
		imgUserGrey = new JLabel(imageIcon);
		this.add(imgUserGrey);
	}

}
