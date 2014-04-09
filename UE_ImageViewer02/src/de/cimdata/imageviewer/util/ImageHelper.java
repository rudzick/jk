package de.cimdata.imageviewer.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;

public class ImageHelper {
	public static ImageIcon getImageIcon(String path)
			throws FileNotFoundException {
		String imgPath = path.toLowerCase();
		if (!imgPath.endsWith(".jpg") && !imgPath.endsWith(".bmp")
				&& !imgPath.endsWith(".gif") && !imgPath.endsWith(".png")) {
			throw new IllegalArgumentException();
		}

		File f = new File(path);
		if (!f.isFile()) {
			throw new FileNotFoundException();
		}
		return new ImageIcon(path);
	}

	public static Image getResizeImage(Image img, int w, int h) {
		BufferedImage resImg = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();
		return resImg;
	}
	
	public static ImageIcon getResizeImage(ImageIcon ic, int w, int h) {
		Image tmpImage = getResizeImage(ic.getImage() , w, h);
		return new ImageIcon(tmpImage);
	}
	

}
