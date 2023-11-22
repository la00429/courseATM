package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
			// Si el usuario se encuentra en el sistema y los credenciales son los
			// correctos.
			if (sPrincipal.searchUser(view.getFrameApp().getLoginUser().getUserInput(),
					view.getFrameApp().getLoginUser().getPasswordInput()) == true) {
				view.getFrameApp().stateLoginUser(false);
				view.getFrameApp().setCourse(sPrincipal.selectCourse(sPrincipal.getUsers()
						.get(view.getFrameApp().getLoginUser().getUserInput()).getStyleLearning()));
				view.getFrameApp().getCourse().setNameUser(
						sPrincipal.getUsers().get(view.getFrameApp().getLoginUser().getUserInput()).getName());
				view.getFrameApp().revalidate();
				view.getFrameApp().repaint();
				view.getFrameApp().stateCourse(true);
			}else {
				view.getFrameApp().showMessageInfo(Message.HELP);
			}
		}

		if (source.equals("Forgot")) {
			if (true) {
				view.getFrameApp().stateLoginUser(false);
				view.getFrameApp().stateChangePassword(true);
			}
		}

		if (source.equals("Next")) {
			// si el código es diferente a los de los almacenados dentro del hastable de los
			// usuarios y ningún campo está vacio.
			if (true) {
				view.getFrameApp().stateCreateUser(false);
				view.getFrameApp().stateFormStyleLearning(true);
			}
		}

		if (source.equals("Record")) {
			// confirma si eligió un estilo de aprendizaje.
			// guardar toda la información del usuario y persistirla
			if (true) {
				view.getFrameApp().stateFormStyleLearning(false);
				view.getFrameApp().setCourse(sPrincipal.selectCourse(view.getFrameApp().selectCourse()));
				view.getFrameApp().setNameUser(view.getFrameApp().getCreateUser().getName());
				view.getFrameApp().stateCourse(true);
				sPrincipal.addUser(view.getFrameApp().getCreateUser().getCode(),
						view.getFrameApp().getCreateUser().getName(),
						view.getFrameApp().getCreateUser().getSelectedGender(),
						view.getFrameApp().getCreateUser().getPasswordInput(),
						view.getFrameApp().getFormStyleLearning().getSelectStyle());
				loadData.writeUsersJSON(sPrincipal.getUsers());
			}

		}

		if (source.equals("Accept")) {
			// diferente a la que ya estaba y no es nullo el campo,
			if (true) {
				view.getFrameApp().stateChangePassword(false);
				view.getFrameApp().stateLoginUser(true);
			}

		}

		if (source.equals("Create")) {
			view.getFrameApp().stateLoginUser(false);
			view.getFrameApp().stateCreateUser(true);
		}

		if (source.equals("Logout")) {
			view.getFrameApp().stateCourse(false);
			view.getFrameApp().stateLoginUser(true);

		}

		if (source.equals("Help")) {
			view.getFrameApp().showMessageInfo(Message.HELP);
			;
		}

		if (source.equals("Us")) {
			view.getFrameApp().showMessageInfo(Message.ABOUT_US);
		}

	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub

	}

}
