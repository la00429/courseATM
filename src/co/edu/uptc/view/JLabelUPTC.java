package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelUPTC extends JLabel {

	public JLabelUPTC(String text) {
		setText(text);
		setFont(new Font("Arial", Font.BOLD, 20));
		setForeground(new Color(113, 117, 117));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}
