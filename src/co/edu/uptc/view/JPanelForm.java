package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

public class JPanelForm extends JPanelStart {

	public JPanelForm(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
		this.setVisible(true);
		initComponents2(listener, listenerMouse);
	}

	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		getDimensionPanel(listener, gbc);
//		secondLine(gbc);
//		thirdLine(gbc);
//		fourLine(gbc);
//		fiveLine(gbc);
//		sixLine(gbc);
//		sevenLine(gbc);
//		eightLine(gbc);
//		nineLine(gbc);
//		tenLine(listener, gbc);
//		
	}

	private void getDimensionPanel(ActionListener listener, GridBagConstraints gbc) {
		getImgUser().removeAll();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0; 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.1;
		add(getImgUser(), gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.9;
		add(getInfoPanel(), gbc);
		getImgUser().firstLineUser(96, 88);
		revalidate();
		repaint();
	}

}
