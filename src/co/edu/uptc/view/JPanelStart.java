package co.edu.uptc.view;

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
	private JLabel imgUserGrey;
	private JLabel imgUPTC;
	private JPanel imgUser;
	private JPanel infoPanel;
	private JButtonUPTC button;

	public JPanelStart(ActionListener listener) {
		this.setSize(getMaximumSize());
		initComponents(listener);
		this.setVisible(true);

	}

	private void initComponents(ActionListener listener) {
		partLeft();
		partRight(listener);
	}

	private void partLeft() {
		this.imgUser = new JPanel();
		this.imgUser.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		firstLineUser();
		gbc.insets = new Insets(20, 30, 20, 0);
		this.add(this.imgUser);
		this.imgUser.setVisible(true);
	}

	private void firstLineUser() {
		ImageIcon imageIcon = new ImageIcon("img/logoUPTC.png");
		imgUserGrey = new JLabel(imageIcon);
		this.imgUser.add(imgUserGrey);

	}

	private void partRight(ActionListener listener) {
		// TODO Auto-generated method stub

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
