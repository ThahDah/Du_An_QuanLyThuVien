package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddBookGUI;
import view.LibraryGUI;

public class ChangeToAddBookGUI implements ActionListener{
	private LibraryGUI libraryGUI;
	
	public ChangeToAddBookGUI(LibraryGUI libraryGUI) {
		this.libraryGUI = libraryGUI;
	}
	
	public void actionPerformed(ActionEvent e) {
			this.libraryGUI.setVisible(false);
			new AddBookGUI(libraryGUI);
	}

}
