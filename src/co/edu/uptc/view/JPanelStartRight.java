package co.edu.uptc.view;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelStartRight extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JButtonUPTC button;
	
	public JPanelStartRight(ActionListener listener) {
		this.setSize(getMaximumSize());
		initComponents(listener);
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		firstLine();
		
	}
	
	
	

}
