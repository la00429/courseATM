package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;

public class JFrameSystem extends JFrame {
	private JPanelLogin loginUser;
	private JPanelCreateUser createUser;

	public JFrameSystem(ActionListener listener, MouseAdapter listenerMouse) {
//		this.setLayout(new GridLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
		this.setTitle("Aprendamos Juntos");
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height - 18);
		this.setBackground(new Color(255, 255, 255));
		startLogin(listener, listenerMouse);
		this.setVisible(true);
	}

	private void startLogin(ActionListener listener, MouseAdapter listenerMouse) {
		loginUser = new JPanelLogin(listener, listenerMouse);
		this.add(loginUser);
	}

}
