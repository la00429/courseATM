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
			loadDataCourse();
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
			showData(Message.HELP);

		}

		if (source.equals("Us")) {
			showData(Message.ABOUT_US);
		}
	}

	public void logOutSystem() {
		view.accessLogin();
	}

	public void changeToCreateUser() {
		view.accessCreate();
	}

	public void updatePanelChangePasswaord() {
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
		view.accessLoginChange();
		view.getFrameApp().getChangePassword().cleanPanel();
	}

	private void changeDataUser(String codeUser) {
		sPrincipal.changePassword(codeUser, view.getFrameApp().getChangePassword().getPasswordInput());
		loadData.writeUsersJSON(sPrincipal.getUsers());
	}

	public void loadDataCourse() {
		getDataCourse();
		getDataUser();
		cleanDataPanel();
	}

	private void getDataCourse() {
		String courseSelect = view.getFrameApp().selectCourse();
		String nameUser = view.getFrameApp().getCreateUser().getName();
		loadCourse(courseSelect, nameUser);
	}

	private void loadCourse(String courseSelect, String nameUser) {
		view.getFrameApp().setCourse(sPrincipal.selectCourse(courseSelect));
		view.getFrameApp().setNameUser(nameUser);
		view.accessCourseCreate();
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

	public void createUserData() {
		String name = view.getFrameApp().getCreateUser().getName();
		String code = view.getFrameApp().getCreateUser().getCode();
		String gender = view.getFrameApp().getCreateUser().getSelectedGender();
		String password = view.getFrameApp().getCreateUser().getPasswordInput();
		createUserMessage(name, code, gender, password);
	}

	private void createUserMessage(String name, String code, String gender, String password) {
		if (name.isEmpty() || code.isEmpty() || gender.isEmpty() || password.isEmpty()) {
			showData(Message.ERROR_NULL);
		} else {
			if (sPrincipal.getUsers().containsKey(code)) {
				showData(Message.ERROR_TWIN);
			} else {
				createUserNext();
			}
		}
	}

	private void createUserNext() {
		view.accessForm();
	}

	public void forgotPassword() {
		view.accessChange();
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
		selectCourse(codeUser);
		showName(codeUser);
		view.accessCourseCreate();
		view.getFrameApp().getLoginUser().cleanPanel();
	}

	private void loginMessage(String codeUser, String passwordUser) {
		if (codeUser.isEmpty() || passwordUser.isEmpty()) {
			showData(Message.ERROR_NULL);
		} else {
			showData(Message.ERROR_NO_FOUND);
		}
	}

	private void selectCourse(String codeUser) {
		view.setCourse(sPrincipal.selectCourse(sPrincipal.showUser(codeUser).getStyleLearning()));

	}

	private void showName(String codeUser) {
		view.getFrameApp().getCourse().setNameUser(sPrincipal.showUser(codeUser).getName());
	}

	public void showData(String message) {
		view.showData(message);
	}

}
