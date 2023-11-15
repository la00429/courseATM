package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

public class JPanelLogin extends JPanelStart {

	private static final long serialVersionUID = 1L;
	private JLabel user;
	private JTextFieldUPTC userInput;
	private JLabel password;
	private JTextFieldUPTC passwordInput;

	public JPanelLogin(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
		initComponents2(listener, listenerMouse);
	}

	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		getInfoPanel().getTitle().setText("Iniciar sesión");
		this.user = new JLabel("User");
		this.add(user);
	}

}
