package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelStart extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanelStartLeft imgUser;
	private JPanelStartRight infoPanel;

	public JPanelStart(ActionListener listener, MouseAdapter listenerMouse) {
		this.setSize(getMaximumSize());
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(new GridLayout(1, 2));
		initComponents(listener, listenerMouse);
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener, MouseAdapter listenerMouse) {
		partLeft(listener);
		partRight(listener);
	}

	private void partLeft(ActionListener listener) {
		this.imgUser = new JPanelStartLeft(listener);
		this.add(imgUser);

	}

	private void partRight(ActionListener listener) {
		infoPanel = new JPanelStartRight();
		this.add(infoPanel);
	}

	public JPanelStartLeft getImgUser() {
		return imgUser;
	}

	public JPanelStartRight getInfoPanel() {
		return infoPanel;
	}

}
