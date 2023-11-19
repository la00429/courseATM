package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
			System.out.println("Login");
		}
		
		if (source.equals("Next")) {
			System.out.println("Next");
		}

	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub

	}
//	
	@Override
	public void mouseEntered (MouseEvent e) {
		String source = e.getComponent().getName(); // Obtiene el nombre del componente que disparó el evento
	    System.out.println("Mouse entered on: " + source);

	    // Ejecutar super después de realizar las operaciones necesarias
	    super.mouseEntered(e);
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String source = e.getComponent().getName(); // Obtiene el nombre del componente que disparó el evento
	    System.out.println("Mouse entered on: " + source);

	    // Ejecutar super después de realizar las operaciones necesarias
	    super.mouseEntered(e);
	}
//	
//	@Override
//	public void mouseExited(MouseEvent e) {
//	    String source = e.getComponent().getName(); // Obtiene el nombre del componente que disparó el evento
//	    System.out.println("Mouse exited from: " + source);
//
//	    // Ejecutar super después de realizar las operaciones necesarias
//	    super.mouseExited(e);
//	}

}
