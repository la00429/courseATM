package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import co.edu.uptc.config.Config;
import co.edu.uptc.config.Message;
import co.edu.uptc.model.SystemPrincipal;
import co.edu.uptc.model.User;
import co.edu.uptc.persistence.LoadData;
import co.edu.uptc.view.View;

public class Presenter extends MouseAdapter implements ActionListener, Contracts.IPresenter {
	private View view;
	private SystemPrincipal sPrincipal;
	private LoadData loadData;

	public Presenter() {
		this.loadData = new LoadData();
		this.sPrincipal = new SystemPrincipal();
		this.view = new View(this, this);
	}

	public void loadData() {
		loadProperties();
		loadJSON();
		loadSystem();

	}

	private void loadProperties() {
		Config config = new Config();
		config.loadMessages();
		this.view.getFrameApp().revalidate();
		this.view.getFrameApp().repaint();
	}

	private void loadJSON() {
		sPrincipal.setUsers(loadData.readUsersJSON());
	}

	private void loadSystem() {
		loadUsers();
		loadGender();
		loadStyles();
	}

	private void loadStyles() {
		view.getFrameApp().loadComboStyles(loadData.readTxt(Message.PATH_STYLES));
	}

	private void loadGender() {
		view.getFrameApp().loadComboGender(loadData.readTxt(Message.PATH_GENDER));
	}

	private void loadUsers() {
		ArrayList<String> sites = loadData.readTxt(Message.PATH_SITES);
		for (String infoCourse : sites) {
			sPrincipal.addCourse(infoCourse);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.getFrameApp().revalidate();
		view.getFrameApp().repaint();
		String source = e.getActionCommand();
		if (source.equals("Login")) {
			verificationLogin();
		}

		if (source.equals("Forgot")) {
			forgotPassword();
		}

		if (source.equals("Next")) {
			createUserData();
		}

		if (source.equals("Record")) {
			getDataCourse();
			getDataUser();
			cleanDataPanel();
		}

		if (source.equals("Accept")) {
			updatePanelChangePasswaord();
		}

		if (source.equals("Create")) {
			changeToCreateUser();
		}

		if (source.equals("Logout")) {
			logOutSystem();
		}

		if (source.equals("Help")) {
			view.getFrameApp().showMessageInfo(Message.HELP);
			;
		}

		if (source.equals("Us")) {
			view.getFrameApp().showMessageInfo(Message.ABOUT_US);
		}
	}

	private void logOutSystem() {
		view.getFrameApp().stateCourse(false);
		view.getFrameApp().stateLoginUser(true);
	}

	private void changeToCreateUser() {
		view.getFrameApp().stateLoginUser(false);
		view.getFrameApp().stateCreateUser(true);
	}

	private void updatePanelChangePasswaord() {
		String codeUser = view.getFrameApp().getChangePassword().getUserInput();
		String passwordUserNew = view.getFrameApp().getChangePassword().getPasswordInput();
		if (!codeUser.isEmpty() && !passwordUserNew.isEmpty()) {
			verificationUser(codeUser);
		} else {
			view.getFrameApp().showMessageInfo(Message.ERROR_NULL);
		}
	}

	private void verificationUser(String codeUser) {
		if (sPrincipal.getUsers().containsKey(codeUser)) {
			updateStatePasword(codeUser);
		} else {
			view.getFrameApp().showMessageInfo(Message.ERROR_NO_FOUND);
		}
	}

	private void updateStatePasword(String codeUser) {
		changeDataUser(codeUser);
		view.getFrameApp().stateChangePassword(false);
		view.getFrameApp().stateLoginUser(true);
		view.getFrameApp().getChangePassword().cleanPanel();
	}

	private void changeDataUser(String codeUser) {
		sPrincipal.getUsers().get(codeUser).setPassword(view.getFrameApp().getChangePassword().getPasswordInput());
		loadData.writeUsersJSON(sPrincipal.getUsers());
	}

	private void getDataCourse() {
		String courseSelect = view.getFrameApp().selectCourse();
		String nameUser = view.getFrameApp().getCreateUser().getName();
		loadCourse(courseSelect, nameUser);
	}

	private void loadCourse(String courseSelect, String nameUser) {
		view.getFrameApp().stateFormStyleLearning(false);
		view.getFrameApp().setCourse(sPrincipal.selectCourse(courseSelect));
		view.getFrameApp().setNameUser(nameUser);
		view.getFrameApp().stateCourse(true);
	}

	private void getDataUser() {
		String name = view.getFrameApp().getCreateUser().getName();
		String code = view.getFrameApp().getCreateUser().getCode();
		String gender = view.getFrameApp().getCreateUser().getSelectedGender();
		String password = view.getFrameApp().getCreateUser().getPasswordInput();
		String styleLearning = view.getFrameApp().getFormStyleLearning().getSelectStyle();
		loadDataUser(name, code, gender, password, styleLearning);
	}

	private void loadDataUser(String name, String code, String gender, String password, String styleLearning) {
		sPrincipal.addUser(code, name, gender, password, styleLearning);
		loadData.writeUsersJSON(sPrincipal.getUsers());
	}

	private void cleanDataPanel() {
		view.getFrameApp().getCreateUser().cleanPanel();
		view.getFrameApp().getFormStyleLearning().cleanPanel();
	}

	private void createUserData() {
		String name = view.getFrameApp().getCreateUser().getName();
		String code = view.getFrameApp().getCreateUser().getCode();
		String gender = view.getFrameApp().getCreateUser().getSelectedGender();
		String password = view.getFrameApp().getCreateUser().getPasswordInput();
		createUserMessage(name, code, gender, password);
	}

	private void createUserMessage(String name, String code, String gender, String password) {
		if (name.isEmpty() || code.isEmpty() || gender.isEmpty() || password.isEmpty()) {
			view.getFrameApp().showMessageInfo(Message.ERROR_NULL);
		} else {
			if (sPrincipal.getUsers().containsKey(code)) {
				view.getFrameApp().showMessageInfo(Message.ERROR_TWIN);
			} else {
				createUserNext();
			}
		}
	}

	private void createUserNext() {
		view.getFrameApp().stateCreateUser(false);
		view.getFrameApp().stateFormStyleLearning(true);
	}

	private void forgotPassword() {
		view.getFrameApp().stateLoginUser(false);
		view.getFrameApp().stateChangePassword(true);
	}

	public void verificationLogin() {
		String codeUser = view.getFrameApp().getLoginUser().getUserInput();
		String passwordUser = view.getFrameApp().getLoginUser().getPasswordInput();
		boolean searchUsers = sPrincipal.verificationUser(codeUser, passwordUser);
		if (searchUsers == true) {
			loginAcess(codeUser);
		} else {
			loginMessage(codeUser, passwordUser);
		}
	}

	private void loginAcess(String codeUser) {
		view.getFrameApp().stateLoginUser(false);
		selectCourse(codeUser);
		showData(codeUser);
		view.getFrameApp().stateCourse(true);
		view.getFrameApp().getLoginUser().cleanPanel();
	}

	private void loginMessage(String codeUser, String passwordUser) {
		if (codeUser.isEmpty() || passwordUser.isEmpty()) {
			view.getFrameApp().showMessageInfo(Message.ERROR_NULL);
		} else {
			view.getFrameApp().showMessageInfo(Message.ERROR_NO_FOUND);
		}
	}

	public void selectCourse(String codeUser) {
		view.getFrameApp().setCourse(sPrincipal.selectCourse(sPrincipal.getUsers().get(codeUser).getStyleLearning()));

	}

	@Override
	public void showData(String codeUser) {
		view.getFrameApp().getCourse().setNameUser(sPrincipal.getUsers().get(codeUser).getName());
	}

}
