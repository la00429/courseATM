package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

public class JPanelLogin extends JPanelStart {

	private static final long serialVersionUID = 1L;
	private JLabel user;
	private JTextFieldUPTC userInput;
	private JLabel password;
	private JPasswordUPTC passwordInput;
	private JButtonTraspUPTC forgetPassword;
	private JButtonTraspUPTC createCount;

	public JPanelLogin(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
		this.setVisible(false);
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
		sevenLine(listener, gbc);
		eightLine(listener, gbc);
	}

	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Iniciar sesión");
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 20, 0);
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	private void secondLine(GridBagConstraints gbc) {
		this.user = new JLabel("Usuario");
		this.user.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(70, 30, 0, 0);
		getInfoPanel().add(user, gbc);

	}

	private void thirdLine(GridBagConstraints gbc) {
		this.userInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 30, 30, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(userInput, gbc);

	}

	private void fourLine(GridBagConstraints gbc) {
		this.password = new JLabel("Contraseña");
		this.password.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 0, 0);
		getInfoPanel().add(password, gbc);

	}

	private void fiveLine(GridBagConstraints gbc) {
		this.passwordInput = new JPasswordUPTC();
		gbc.insets = new Insets(0, 30, 70, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(passwordInput, gbc);
	}

	private void sixLine(ActionListener listener, GridBagConstraints gbc) {
		getInfoPanel().getButton().setText("Iniciar sesión");
		getInfoPanel().getButton().setActionCommand("Login");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.insets = new Insets(70, 30, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}

	private void sevenLine(ActionListener listener, GridBagConstraints gbc) {
		this.forgetPassword = new JButtonTraspUPTC("Olvidé mi contraseña");
		this.forgetPassword.setActionCommand("Forgot");
		this.forgetPassword.addActionListener(listener);
		gbc.insets = new Insets(0, 30, 0, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(forgetPassword, gbc);

	}

	private void eightLine(ActionListener listener, GridBagConstraints gbc) {
		this.createCount = new JButtonTraspUPTC("Crear una cuenta");
		this.createCount.setActionCommand("Create");
		this.createCount.addActionListener(listener);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(createCount, gbc);
	}

	public String getUserInput() {
		return userInput.getText();
	}

	public String getPasswordInput() {
		char[] passwordChars = passwordInput.getPassword();
		return new String(passwordChars);
	}

}
