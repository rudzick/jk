package de.cimdata.imageviewer.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.cimdata.imageviewer.data.Picture;
import de.cimdata.imageviewer.data.PictureList;

public class MainFrame extends JFrame{
	
	private PictureList pics = new PictureList();
	//Testdaten---------------
//	private Picture[] pics = {new Picture(),new Picture("D**","La2","img/La2.jpg"),new Picture(),new Picture(),new Picture()};//
	//----------------------------------------
	private ImageView imageview = new ImageView();
	private DescriptionView descriptionView = new DescriptionView();
	private InfoView infoview = new InfoView();
	private ThumbnailView thumbnailview = new ThumbnailView(pics.getPics(),new ThumbnailAction());
	
	
	public MainFrame(){
		setSize(400,400);
		createComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void createComponents(){
		setJMenuBar(createMenu());
		add(imageview,BorderLayout.CENTER);
		add(descriptionView,BorderLayout.EAST);
		add(infoview,BorderLayout.NORTH);
		add(thumbnailview,BorderLayout.SOUTH);	
	}
	
	private class ThumbnailAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			System.out.println("command: "+command);
			imageview.setPicture(command);
			Picture currentPicture = pics.getPictureByPath(command);
			System.out.println("currentPicture: "+currentPicture);
			descriptionView.setDescription(currentPicture.getDescription());
			infoview.setInfoText(currentPicture.getTitle());
	
		}
		

	}
	
	private JMenuBar createMenu(){
		JMenuBar mb = new JMenuBar();
		JMenu filemenu = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Open...");
				// Filechooser
				openFilechooser();
				
			}
			
		});
		
		JMenuItem exit = new JMenuItem("Exit");
		filemenu.add(open);
		filemenu.add(exit);
		mb.add(filemenu);
		
		return mb;
	}
	
	private void openFilechooser(){
		JFileChooser jf = new JFileChooser();
		jf.setDialogTitle("Wähle ein Bilderverzeichnis...");
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jf.showOpenDialog(null);
		
		String path = jf.getSelectedFile().getAbsolutePath();
		System.out.println(path);
		//Bilder einlesen
		String[] imPaths = FileHandler.getImageFileNames(path);
		thumbnailview.removeThumbnails();
		pics.createNewPictures(imPaths);
		thumbnailview.create(pics.getPics(), new ThumbnailAction());
	}

}
