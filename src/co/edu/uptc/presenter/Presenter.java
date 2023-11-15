package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import co.edu.uptc.model.SystemPrincipal;
import co.edu.uptc.view.View;

public class Presenter extends MouseAdapter implements ActionListener, Contracts.IPresenter {
	private View view;
	private SystemPrincipal sPrincipal;

	public Presenter() {

		this.view = new View(this, this);
		this.sPrincipal = new SystemPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source.equals("Login")) {

		}

	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub

	}

}
