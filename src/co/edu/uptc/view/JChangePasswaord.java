package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

public class JChangePasswaord extends JPanelStart {

	private static final long serialVersionUID = 1L;
	private JLabel code;
	private JTextFieldUPTC codeInput;
	private JLabel password;
	private JPasswordUPTC passwordInput;

	public JChangePasswaord(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
		this.setVisible(true);
		initComponents2(listener, listenerMouse);
	}

	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		firstLine(gbc);
		secondLine(gbc);
		thirdLine(gbc);
		fourLine(gbc);
		fiveLine(gbc);
		sixLine(listener, gbc);
	}

	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Cambiar contrase�a");
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 20, 0);
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	private void secondLine(GridBagConstraints gbc) {
		this.code = new JLabel("C�digo");
		this.code.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(70, 126, 0, 0);
		getInfoPanel().add(code, gbc);

	}

	private void thirdLine(GridBagConstraints gbc) {
		this.codeInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 126, 30, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(codeInput, gbc);

	}

	private void fourLine(GridBagConstraints gbc) {
		this.password = new JLabel("Contrase�a");
		this.password.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 126, 0, 0);
		getInfoPanel().add(password, gbc);

	}

	private void fiveLine(GridBagConstraints gbc) {
		this.passwordInput = new JPasswordUPTC();
		gbc.insets = new Insets(0, 126, 70, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(passwordInput, gbc);
	}

	private void sixLine(ActionListener listener, GridBagConstraints gbc) {
		getInfoPanel().getButton().setText("Aceptar");
		getInfoPanel().getButton().setActionCommand("Accept");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.insets = new Insets(70, 30, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}

	public String getUserInput() {
		return codeInput.getText();
	}

	public String getPasswordInput() {
		char[] passwordChars = passwordInput.getPassword();
		return new String(passwordChars);
	}

}
