package co.edu.uptc.view;

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
		this.setLayout(new GridLayout(1, 2));
		initComponents(listener, listenerMouse);
		this.setVisible(true);

	}

	private void initComponents(ActionListener listener, MouseAdapter listenerMouse) {
		partLeft(listenerMouse);
		partRight(listener);
	}

	private void partLeft(MouseAdapter listenerMouse) {
		this.imgUser = new JPanelStartLeft(listenerMouse);
		this.add(imgUser);

	}

	private void partRight(ActionListener listener) {
		infoPanel = new JPanelStartRight(listener);
		this.add(infoPanel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Ejemplo de JPanelStart");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
					Toolkit.getDefaultToolkit().getScreenSize().height - 18);

			JPanelStart panelStart = new JPanelStart(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Manejar eventos del botón u otros componentes aquí
				}
			}, null);

			frame.add(panelStart);
			frame.setVisible(true);
		});
	}

}
