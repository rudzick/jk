package de.cimdata.imageviewer.ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoView extends JPanel {
	private JLabel infolabel = new JLabel();
	
	public InfoView(){
		setBackground(Color.YELLOW);
		add(infolabel);
	}
	
	public void setInfoText(String text){
		infolabel.setText(text);
	}

}
