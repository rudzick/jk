package de.cimdata.imageviewer.ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DescriptionView extends JPanel {
	private JTextArea textfield = new JTextArea();
	
	public DescriptionView(){
		setBackground(Color.BLUE);
		add(textfield);
		textfield.setLineWrap(true);
		textfield.setWrapStyleWord(true);
	}
	
	public void setDescription(String txt){
		textfield.setText(txt);
	}

}
