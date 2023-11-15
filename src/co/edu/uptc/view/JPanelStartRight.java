package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelStartRight extends JPanel {
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel title;
	private JButtonUPTC button;

	public JPanelStartRight(ActionListener listener) {
		this.setSize(getMaximumSize());
		this.setLayout(new GridBagLayout());
		initComponents(listener);
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener) {

		gbc = new GridBagConstraints();
		title = new JLabel();
		button = new JButtonUPTC(null);
		button.addActionListener(listener);

	}

	public JLabel getTitle() {
		return title;
	}

	public JButtonUPTC getButton() {
		return button;
	}

}
