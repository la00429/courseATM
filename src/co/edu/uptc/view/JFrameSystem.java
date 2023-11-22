package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import co.edu.uptc.config.Message;

public class JFrameSystem extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelLogin loginUser;
	private JPanelCreateUser createUser;
	private JPanelForm formStyleLearning;
	private JChangePasswaord changePassword;
	private JPanelCourse course;
	private JDialogUPTC showInfo;

	public JFrameSystem(ActionListener listener, MouseAdapter listenerMouse) {
		super("Aprendamos Juntos");
		this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height));
		this.setBackground(new Color(255, 255, 255));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(listener, listenerMouse);
		pack();
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener, MouseAdapter listenerMouse) {
		createUser = new JPanelCreateUser(listener, listenerMouse);
		formStyleLearning = new JPanelForm(listener, listenerMouse);
		changePassword = new JChangePasswaord(listener, listenerMouse);
		course = new JPanelCourse(listener, listenerMouse);
		loginUser = new JPanelLogin(listener, listenerMouse);
		this.add(loginUser);
	}

	public void showMessageInfo(String message) {
		this.showInfo = new JDialogUPTC(this);
		this.showInfo.getTextPane().setText(message);
		this.showInfo.setVisible(true);
	}

	public void stateLoginUser(boolean state) {
		this.add(loginUser);
		this.loginUser.setVisible(state);
	}

	public void stateCreateUser(boolean state) {
		this.add(createUser);
		this.createUser.setVisible(state);
	}

	public void stateFormStyleLearning(boolean state) {
		this.add(formStyleLearning);
		this.formStyleLearning.setVisible(state);
	}

	public void stateChangePassword(boolean state) {
		this.add(changePassword);
		this.changePassword.setVisible(state);
	}

	public void stateCourse(boolean state) {
		this.add(course);
		this.course.setVisible(state);
	}

	public void loadComboGender(ArrayList<String> items) {
		this.createUser.loadComboBoxGender(items);
	}

	public void loadComboStyles(ArrayList<String> items) {
		this.formStyleLearning.loadComboBoxStyles(items);
	}

	public String selectCourse() {
		return this.formStyleLearning.getSelectStyle();
	}

	public void setNameUser(String name) {
		this.course.setNameUser(name);
	}

	public void setCourse(String path) {
		this.course.setPathCourse(path);
	}

	public JPanelLogin getLoginUser() {
		return loginUser;
	}

	public JPanelCreateUser getCreateUser() {
		return createUser;
	}

	public JPanelForm getFormStyleLearning() {
		return formStyleLearning;
	}

	public JChangePasswaord getChangePassword() {
		return changePassword;
	}

	public JPanelCourse getCourse() {
		return course;
	}
}
