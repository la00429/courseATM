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
		initComponents(gbc);
		this.setVisible(true);
	}

	private void initComponents(GridBagConstraints gbc) {
		firstLineUser(gbc);
		secondLineUser(gbc);
	}

	private void firstLineUser(GridBagConstraints gbc) {
		ImageIcon imageIcon = new ImageIcon("img/user.png");
		imgUserGrey = new JLabel(imageIcon);
		gbc.fill = GridBagConstraints.REMAINDER;
		this.add(imgUserGrey, gbc);
	}

	private void secondLineUser(GridBagConstraints gbc) {
		ImageIcon imageIcon = new ImageIcon("img/logoUPTC.png");
		imgUserGrey = new JLabel(imageIcon);
		this.add(imgUserGrey, gbc);

	}

}
