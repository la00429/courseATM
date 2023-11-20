package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
        this.setBackground(new Color(255, 255, 255));
        this.setLayout(new GridBagLayout());
        initComponents(listener, listenerMouse);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener, MouseAdapter listenerMouse) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // Cada panel ocupará la mitad del ancho
        gbc.weighty = 1.0; // Para llenar verticalmente
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        imgUser = new JPanelStartLeft(listener);
        add(imgUser, gbc);

        gbc.gridx = 1;
        infoPanel = new JPanelStartRight();
        add(infoPanel, gbc);
    }

    public JPanelStartLeft getImgUser() {
        return imgUser;
    }

    public JPanelStartRight getInfoPanel() {
        return infoPanel;
    }

}
