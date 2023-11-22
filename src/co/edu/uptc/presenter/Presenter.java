package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import co.edu.uptc.config.Config;
import co.edu.uptc.config.Message;
import co.edu.uptc.model.SystemPrincipal;
import co.edu.uptc.persistence.LoadData;
import co.edu.uptc.view.View;

public class Presenter extends MouseAdapter implements ActionListener, Contracts.IPresenter {
	private View view;
	private SystemPrincipal sPrincipal;
	private LoadData loadData;

	public Presenter() {
		this.view = new View(this, this);
		this.sPrincipal = new SystemPrincipal();
		this.loadData = new LoadData();
	}

	public void loadData() {
		loadProperties();
		loadJSON();
		loadSystem();
	}

	private void loadProperties() {
		Config config = new Config();
		config.loadMessages();
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
			if (true) {
				view.getFrameApp().stateLoginUser(false);
				view.getFrameApp().stateCourse(true);
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
				view.getFrameApp().stateFormStyleLearning(true);
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
