package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelStart extends JPanel {
	private JPanelStartLeft imgUser;
	private JPanel infoPanel;
	private JButtonUPTC button;

	public JPanelStart(ActionListener listener) {
		this.setSize(getMaximumSize());
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		initComponents(listener, gbc);
		this.setVisible(true);

	}

	private void initComponents(ActionListener listener, GridBagConstraints gbc) {
		partLeft(gbc);
		partRight(listener, gbc);
	}

	private void partLeft(GridBagConstraints gbc) {
		this.imgUser = new JPanelStartLeft();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(imgUser, gbc);

	}

	private void partRight(ActionListener listener, GridBagConstraints gbc) {
		infoPanel = new JPanel();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5; // Ajusta el tamaño relativo del panel derecho
		gbc.fill = GridBagConstraints.BOTH;
		this.add(infoPanel, gbc);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Ejemplo de JPanelStart");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1800, 1600);

			JPanelStart panelStart = new JPanelStart(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Manejar eventos del botón u otros componentes aquí
				}
			});

			frame.add(panelStart);
			frame.setVisible(true);
		});
	}

}
