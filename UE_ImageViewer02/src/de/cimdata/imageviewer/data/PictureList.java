package de.cimdata.imageviewer.data;

import java.io.File;

import de.cimdata.imageviewer.ui.FileHandler;

public class PictureList {
	
	private Picture[] pics = {new Picture(),new Picture("D**","La2","img/La2.jpg"),new Picture(),new Picture(),new Picture()};//

	public Picture[] getPics() {
		return pics;
	}

	public void setPics(Picture[] pics) {
		this.pics = pics;
	}
	
	/**
	 * findet Bild nach übergeben Pfad
	 * @param path
	 * @return
	 */
	public Picture getPictureByPath(String path){
		Picture pic = null;
		
		for (Picture picture : pics) {
			if(picture.getPath().equals(path)){
				pic = picture;
			}
		}
		
		return pic;
	}
	
	public void createNewPictures(String path){
		String[] imgPaths = FileHandler.getImageFileNames(path);
		pics = new Picture[imgPaths.length];
		
		for(int i = 0; i < imgPaths.length; i++) {
			File f = new File(imgPaths[i]);
			String pathNew = path + "/" + imgPaths[i];
			Picture p = new Picture("***", f.getName(), patNew[i]);
			pics[i]=p;
		}
		
	}
	
	
}
