package com;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	//Sends button action back to main application class 
	public void actionPerformed(ActionEvent e) {
		Application.ProcessListener(e);
	}

}
