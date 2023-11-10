package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener, Contracts.IPresenter {

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
