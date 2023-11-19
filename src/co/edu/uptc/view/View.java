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
	public void showData() {
		// TODO Auto-generated method stub

	}
}
