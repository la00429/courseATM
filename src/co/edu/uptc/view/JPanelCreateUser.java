package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * Panel para crear un nuevo usuario con campos como nombre, código, sexo,
 * contraseña, etc. Extiende JPanelStart para agregar funcionalidades
 * adicionales y mostrar información.
 */
public class JPanelCreateUser extends JPanelStart {

	private static final long serialVersionUID = 1L;
	private JLabel name;
	private JTextFieldUPTC nameInput;
	private JLabel code;
	private JTextFieldUPTC codeInput;
	private JLabel gender;
	private JComboBox<String> genderInput;
	private JLabel password;
	private JPasswordUPTC passwordInput;

	/**
	 * Constructor de JPanelCreateUser.
	 *
	 * @param listener      ActionListener para manejar eventos del botón.
	 * @param listenerMouse MouseAdapter para manejar eventos del mouse.
	 */
	public JPanelCreateUser(ActionListener listener, MouseAdapter listenerMouse) {
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
		sixLine(gbc);
		sevenLine(gbc);
		eightLine(gbc);
		nineLine(gbc);
		tenLine(listener, gbc);
	}

	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Crear Usuario");
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 20, 0);
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	private void secondLine(GridBagConstraints gbc) {
		this.name = new JLabel("Nombre");
		this.name.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(name, gbc);

	}

	private void thirdLine(GridBagConstraints gbc) {
		this.nameInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(nameInput, gbc);
	}

	private void fourLine(GridBagConstraints gbc) {
		this.code = new JLabel("Código");
		this.code.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(code, gbc);

	}

	private void fiveLine(GridBagConstraints gbc) {
		this.codeInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(codeInput, gbc);
	}

	private void sixLine(GridBagConstraints gbc) {
		this.gender = new JLabel("Sexo");
		this.gender.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(gender, gbc);

	}

	private void sevenLine(GridBagConstraints gbc) {
		this.genderInput = new JComboBoxUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(genderInput, gbc);
	}

	private void eightLine(GridBagConstraints gbc) {
		this.password = new JLabel("Contraseña");
		this.password.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(password, gbc);

	}

	private void nineLine(GridBagConstraints gbc) {
		this.passwordInput = new JPasswordUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(passwordInput, gbc);
	}

	private void tenLine(ActionListener listener, GridBagConstraints gbc) {
		getInfoPanel().getButton().setText("Siguiente");
		getInfoPanel().getButton().setActionCommand("Next");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.insets = new Insets(30, 30, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}

	public void loadComboBoxGender(ArrayList<Object> items) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Select level");
		for (Object object : items) {
			model.addElement(object.toString());

		}
		this.genderInput.setModel(model);
	}

	public String getName() {
		return nameInput.getText();
	}
	
	public String getCode() {
		return codeInput.getText();
	}
	
	public String getSelectedGender() {
	    return (String) genderInput.getSelectedItem();
	}

	public String getPasswordInput() {
		char[] passwordChars = passwordInput.getPassword();
		return new String(passwordChars);
	}

}
