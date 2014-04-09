package de.cimdata.imageviewer.ui;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

// import app.FileTest.TextFilter;

public class FileHandler {
	public static String[] getImageFileNames(String path) {
		File dir = new File(path);
		
		String[] entries = dir.list(new TextFilter());
		for( int i =0 ; i < entries.length ; i++) {
			System.out.println("Eingelesene Bilder : " + path + "\\"  + entries[i]);
			entries[i] = path + "\\" + entries[i];
		}
		return entries;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getImageFileNames("c:/bilder")));
	}
	
	static class TextFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			
			return name.endsWith(".jpg") ||
				   name.endsWith(".jpeg") ||
				   name.endsWith(".gif") ||
				   name.endsWith(".png"); 
		}
		
	}
}
