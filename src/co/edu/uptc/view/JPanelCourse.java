package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelCourse extends JPanelStart {
	private static final long serialVersionUID = 1L;
	private JPanel optionsMenu;
	private JButtonTraspUPTC logout;
	private JLabel name;
	private JTextPaneUPTC subTitle;
	private JPanel panelCourse;
	private WebCourse webCourse;
	private String pathCouse;

	public JPanelCourse(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
		initComponents2(listener, listenerMouse);
		this.setVisible(false);
	}

	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		getDimensionPanelLeft(listener, gbc);
		firstLine(gbc, listener);
		secondLine(gbc);
		thirdLine(gbc);
		fourLine(gbc);
	}

	private void getDimensionPanelLeft(ActionListener listener, GridBagConstraints gbc) {
		panelLeft(gbc);
		panelRight(gbc);
		addNewComponents(listener);
	}

	private void panelRight(GridBagConstraints gbc) {
		gbc.gridx = 1;
		gbc.weightx = 1;
		add(getInfoPanel(), gbc);
	}

	private void panelLeft(GridBagConstraints gbc) {
		getImgUser().remove(getImgUser().getImgUserGrey());
		getImgUser().remove(getImgUser().getImgUPTC());
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0; // Peso para la fila
		gbc.weightx = 0; // Peso para la columna
		gbc.fill = GridBagConstraints.BOTH;
		add(getImgUser(), gbc);
	}

	private void addNewComponents(ActionListener listener) {
		getImgUser().firstLineUser(96, 88);
		getImgUser().setInfo("Ayuda");
		revalidate();
		repaint();
	}

	private void firstLine(GridBagConstraints gbc, ActionListener listener) {
		this.optionsMenu = new JPanel();
		this.optionsMenu.setPreferredSize(new Dimension(getWidth(), 94));
		this.optionsMenu.setLayout(new GridBagLayout());
		this.optionsMenu.setBackground(new Color(248, 203, 46));
		addButton(gbc,listener);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(this.optionsMenu, gbc);

	}

	private void addButton(GridBagConstraints gbc,ActionListener listener) {
		this.logout = new JButtonTraspUPTC("");
		this.logout.setIcon(modiImage());
		this.logout.setActionCommand("Logout");
		this.logout.addActionListener(listener);
		gbc.insets = new Insets(16, 0, 10, 80);
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.fill = GridBagConstraints.NONE;
		this.optionsMenu.add(logout, gbc);
	}

	private ImageIcon modiImage() {
		ImageIcon imageIcon = new ImageIcon("img/logout.png");
		Image originalImage = imageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(52, 65, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	private void secondLine(GridBagConstraints gbc) {
		this.name = new JLabel();
	}

	private void thirdLine(GridBagConstraints gbc) {
		this.subTitle = new JTextPaneUPTC();
		this.subTitle.setColorBack(Color.white);
		configurationPanelStyles();
		addTextPane();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 133, 0, 133);
		getInfoPanel().add(subTitle, gbc);
	}
	private void configurationPanelStyles() {
		this.panelCourse = new JPanel();
		this.panelCourse.setLayout(new BorderLayout());
		this.panelCourse.setOpaque(false);
	}

	private void addTextPane() {
		String paragraph = "<html><p style='font-family:Arial; font-size:24px;'> Este es el curso de acuerdo al estilo de aprendizaje que más se acomoda a ti. Gracias por estar aquí. </p></html>";
		this.subTitle.setText(paragraph);

	}

	private void fourLine(GridBagConstraints gbc) {
		this.panelCourse = new JPanel();
		this.webCourse = new WebCourse();
		this.panelCourse.add(webCourse);
		gbc.gridy = 4;
		getInfoPanel().add(panelCourse, gbc);
		;
	}

	

	public void setNameUser(String text) {
		GridBagConstraints gbc = new GridBagConstraints();
		this.name = new JLabel();
		this.name.setText(text);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(36, 250, 0, 126);
		getInfoPanel().getTitle().setText("Hola " + this.name.getText());
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	public void setPathCourse(String pathCouse) {
		this.webCourse.loadPage(pathCouse);
	}

}
