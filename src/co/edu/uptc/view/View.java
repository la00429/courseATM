package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.SwingUtilities;

import co.edu.uptc.presenter.Contracts;

public class View implements Contracts.IView {
	private JFrameSystem frameApp;

	public View(ActionListener listener, MouseAdapter listenerMouse) {
		frameApp = new JFrameSystem(listener, listenerMouse);
	}

	@Override
	public void showData(String message) {
		this.getFrameApp().showMessageInfo(message);
	}

	public void setCourse(String course) {
		this.getFrameApp().setCourse(course);
	}

	public JFrameSystem getFrameApp() {
		return frameApp;
	}

	@Override
	public void accessLogin() {
		getFrameApp().stateCourse(false);
		getFrameApp().stateLoginUser(true);

	}

	@Override
	public void accessCourse() {
		getFrameApp().stateLoginUser(false);
		getFrameApp().stateCourse(true);

	}

	@Override
	public void accessCreate() {
		getFrameApp().stateLoginUser(false);
		getFrameApp().stateCreateUser(true);

	}

	@Override
	public void accessCourseCreate() {
		getFrameApp().stateFormStyleLearning(false);
		getFrameApp().stateCourse(true);

	}

	@Override
	public void accessChange() {
		getFrameApp().stateLoginUser(false);
		getFrameApp().stateChangePassword(true);

	}

	@Override
	public void accessForm() {
		getFrameApp().stateCreateUser(false);
		getFrameApp().stateFormStyleLearning(true);

	}

	@Override
	public void accessLoginChange() {
		getFrameApp().stateChangePassword(false);
		getFrameApp().stateLoginUser(true);
		
	}

}
