package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class JPanelForm extends JPanelStart {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelStyles;
	private JTextPane paneDataStyles;
	private JComboBoxUPTC styles;

	public JPanelForm(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
		this.setVisible(true);
		initComponents2(listener, listenerMouse);
	}

	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		GridBagConstraints gbc = new GridBagConstraints();
		getDimensionPanelLeft(gbc);
		firstLine(gbc);
		secondLine(gbc);
		thirdLine(listener, gbc);
	}

	private void getDimensionPanelLeft(GridBagConstraints gbc) {
		getImgUser().removeAll();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 1.0; // Peso para la fila
	    gbc.weightx = 0; // Peso para la columna
	    gbc.fill = GridBagConstraints.BOTH;
	    add(getImgUser(), gbc);

	    gbc.gridx = 1;
	    gbc.weightx = 1; // Peso para la columna
	    add(getInfoPanel(), gbc);

	    getImgUser().firstLineUser(96, 88);
	    revalidate();
	    repaint();
	}

	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Elije tu estilo de aprendizaje");
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH; // Alinear el componente en la parte superior del �rea asignada
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(100,0,40,0);
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	private void secondLine(GridBagConstraints gbc) {
		configurationPanelStyles();
		paneDataStyles = new JTextPaneUPTC();
		String paragraph = "<html><p style='font-family:Arial; font-size:20px;'> <b>Adaptador:</b> Es el estilo de aprendizaje que se basa en la experiencia concreta y la experimentaci�n activa. Las personas con este estilo son pr�cticas, flexibles, intuitivas y orientadas a la acci�n. Les gusta resolver problemas, asumir riesgos y aprender haciendo.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Asimilador:</b> Es el estilo de aprendizaje que se basa en la observaci�n reflexiva y la conceptualizaci�n abstracta. Las personas con este estilo son l�gicas, racionales, anal�ticas y te�ricas. Les gusta estudiar, investigar, planificar y crear modelos.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Divergente:</b> Es el estilo de aprendizaje que se basa en la experiencia concreta y la observaci�n reflexiva. Las personas con este estilo son creativas, imaginativas, emocionales y sensibles. Les gusta explorar, generar ideas, trabajar en grupo y expresarse.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Convergente:</b> Es el estilo de aprendizaje que se basa en la conceptualizaci�n abstracta y la experimentaci�n activa. Las personas con este estilo son pr�cticas, eficientes, objetivas y orientadas a los resultados. Les gusta aplicar lo que saben, tomar decisiones, resolver problemas y encontrar soluciones.</p></html>";
		paneDataStyles.setText(paragraph);
		this.panelStyles.add(paneDataStyles, BorderLayout.CENTER);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(5, 5, 5, 5);
		getInfoPanel().add(this.panelStyles, gbc);
	}

	private void configurationPanelStyles() {
		this.panelStyles = new JPanel();
		this.panelStyles.setLayout(new BorderLayout());
		this.panelStyles.setOpaque(false);

	}

	private void thirdLine(ActionListener listener, GridBagConstraints gbc) {
		this.styles = new JComboBoxUPTC();
		gbc.insets = new Insets(60, 0, 5, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		getInfoPanel().add(styles, gbc);

		getInfoPanel().getButton().setText("Registrarme");
		getInfoPanel().getButton().setActionCommand("Record");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.insets = new Insets(60, 0, 5, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}

	public void loadComboBoxStyles(ArrayList<Object> items) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Select level");
		for (Object object : items) {
			model.addElement(object.toString());

		}
		this.styles.setModel(model);
	}

	public String getSelectStyle() {
		return (String) styles.getSelectedItem();

	}

}
