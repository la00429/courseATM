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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelLogin loginUser;
	private JPanelCreateUser createUser;
	private JPanelForm formStyleLearning;

	public JFrameSystem(ActionListener listener, MouseAdapter listenerMouse) {
		this.setTitle("Aprendamos Juntos");
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height - 18);
		this.setBackground(new Color(255, 255, 255));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startLogin(listener, listenerMouse);
		this.setVisible(true);
	}

	private void startLogin(ActionListener listener, MouseAdapter listenerMouse) {
		createUser = new JPanelCreateUser(listener, listenerMouse);
		this.add(createUser);
//		loginUser = new JPanelLogin(listener, listenerMouse);
//		this.add(loginUser);
//		formStyleLearning = new JPanelForm(listener, listenerMouse);
//		this.add(formStyleLearning);

	}

}
