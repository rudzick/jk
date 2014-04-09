package de.cimdata.imageviewer.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageView extends JPanel {
	private JLabel pictureLabel = new JLabel();
	
	public ImageView(){
		setBackground(Color.GREEN);
		add(pictureLabel);
	}
	
	public void setPicture(String path){
		pictureLabel.setIcon(new ImageIcon(path));
//		ImageIcon ic =new ImageIcon(path)
//		pictureLabel.setIcon(ic);
	}

}
