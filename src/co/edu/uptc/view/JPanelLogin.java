package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

public class JPanelLogin extends JPanelStart {

	private static final long serialVersionUID = 1L;
	private JLabel user;
	private JTextFieldUPTC userInput;
	private JLabel password;
	private JTextFieldUPTC passwordInput;
	private JLabelUPTC forgetPassword;
	private JLabelUPTC createCount;

	public JPanelLogin(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
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
		sevenLine(listenerMouse, gbc);
		eightLine(listenerMouse, gbc);
	}

	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Iniciar sesión");
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	private void secondLine(GridBagConstraints gbc) {
		this.user = new JLabel("User");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(user, gbc);

	}

	private void thirdLine(GridBagConstraints gbc) {
		this.userInput = new JTextFieldUPTC();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(userInput, gbc);

	}

	private void fourLine(GridBagConstraints gbc) {
		this.password = new JLabel("Contraseña");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(password,gbc);

	}

	private void fiveLine(GridBagConstraints gbc) {
		this.passwordInput = new JTextFieldUPTC();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(passwordInput,gbc);
	}

	private void sixLine(ActionListener listener, GridBagConstraints gbc) {
		getInfoPanel().getButton().setText("Iniciar sesión");
		getInfoPanel().getButton().setActionCommand("Login");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}

	private void sevenLine(MouseAdapter listenerMouse, GridBagConstraints gbc) {
		this.forgetPassword = new JLabelUPTC("Olvidé mi contraseña");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(forgetPassword,gbc);

	}

	private void eightLine(MouseAdapter listenerMouse, GridBagConstraints gbc) {
		this.createCount = new JLabelUPTC("Crear una cuenta");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(createCount,gbc);

	}

}
