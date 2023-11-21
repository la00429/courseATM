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
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class JPanelCourse extends JPanelStart {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel optionsMenu;
	private JLabel name;
	private JLabel subTitle;
	private JPanel panelStyles;
	private JTextPane paneDataStyles;
	private JComboBoxUPTC styles;

	public JPanelCourse(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);

		initComponents2(listener, listenerMouse);
		this.setVisible(false);
	}

	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		getDimensionPanelLeft(listener, gbc);
		firstLine(gbc);
		secondLine(gbc);
		

	}

	private void getDimensionPanelLeft(ActionListener listener, GridBagConstraints gbc) {
		panelLeft(gbc);
		panelRight(gbc);
		addNewComponents(listener);
	}

	private void panelRight(GridBagConstraints gbc) {
		gbc.gridx = 1;
		gbc.weightx = 1; // Peso para la columna
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
		getImgUser().setInfo(listener, "Ayuda");
		revalidate();
		repaint();
	}

	private void firstLine(GridBagConstraints gbc) {
		this.optionsMenu = new JPanel();
		this.optionsMenu.setLayout(new GridBagLayout());
//		this.optionsMenu.setPreferredSize(getMaximumSize());
		this.optionsMenu.setBackground(new Color(248, 203, 46));

		ImageIcon imageIcon = new ImageIcon("img/logout.png");
		Image originalImage = imageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(52, 65, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JLabel out = new JLabel(resizedIcon);
		gbc.insets = new Insets(16, 0, 10, 80);
		gbc.anchor = GridBagConstraints.LAST_LINE_END; // Esquina inferior izquierda
		gbc.fill = GridBagConstraints.NONE; // Sin relleno
		this.optionsMenu.add(out, gbc);
		gbc.gridx = 0;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(this.optionsMenu, gbc);

	}

	private void secondLine(GridBagConstraints gbc) {
		this.name = new JLabel();
		getInfoPanel().getTitle().setText("Hola " + this.name.getText());
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(36, 250, 0, 126);
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);

		configurationPanelStyles();
		addTextPane();
		this.panelStyles.add(paneDataStyles, BorderLayout.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 133, 0, 133);
		getInfoPanel().add(this.paneDataStyles, gbc);
	}

	private void addTextPane() {
		this.paneDataStyles = new JTextPaneUPTC();
		String paragraph = "<html><p style='font-family:Arial; font-size:20px;'> Este es el curso de acuerdo al estilo de aprendizaje que más se acomoda a ti. Gracias por estar aquí. </p></html>";
		this.paneDataStyles.setText(paragraph);

	}

	private void configurationPanelStyles() {
		this.panelStyles = new JPanel();
		this.panelStyles.setLayout(new BorderLayout());
		this.panelStyles.setOpaque(false);
	}

}
