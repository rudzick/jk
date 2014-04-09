package de.cimdata.imageviewer.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.cimdata.imageviewer.data.Picture;
import de.cimdata.imageviewer.util.ImageHelper;

public class ThumbnailView extends JPanel {
	
	public ThumbnailView(){
		setBackground(Color.CYAN);
		
	}
	
	
	public ThumbnailView(Picture[] pictures,ActionListener li){
		create(pictures,li);
		
	}

	void create(Picture[] pictures,  ActionListener li) {
		setLayout(new GridLayout(1,0));
		for (int i = 0; i < pictures.length; i++) {
			ImageIcon ic = new ImageIcon(pictures[i].getPath());
			ic = ImageHelper.getResizeImage(ic, 50, 35);
			JButton tempButton = new JButton(ic);
			tempButton.setActionCommand(pictures[i].getPath());
			tempButton.addActionListener(li);
			add(tempButton);
		}
	}
	
	public void removeThumbnails(){
		
		removeAll();
	}


}
