package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class JPanelCourse extends JPanelStart {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel optionsMenu;
	private JLabel name;
	private JTextPane subTitle;
	private JPanel panelCourse;
	private WebPageDisplay webCourse;

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
		gbc.insets = new Insets(0, 0, 0, 0);
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

	}

	private void thirdLine(GridBagConstraints gbc) {
		this.subTitle = new JTextPaneUPTC();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 133, 0, 133);
		getInfoPanel().add(this.subTitle, gbc);
	}

	private void fourLine(GridBagConstraints gbc) {
		configurationPanelStyles();
		addTextPane();
		this.panelCourse.add(subTitle, BorderLayout.CENTER);

	}

	private void configurationPanelStyles() {
		this.panelCourse = new JPanel();
		this.panelCourse.setLayout(new BorderLayout());
		this.panelCourse.setOpaque(false);
	}

	private void addTextPane() {
		this.subTitle = new JTextPaneUPTC();
		String paragraph = "<html><p style='font-family:Arial; font-size:20px;'> Este es el curso de acuerdo al estilo de aprendizaje que m�s se acomoda a ti. Gracias por estar aqu�. </p></html>";
		this.subTitle.setText(paragraph);

	}

	public void setNameUser(String text) {
		// TODO Auto-generated method stub
		this.name.setText(text);
	}
}
