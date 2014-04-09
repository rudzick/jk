package app;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Zeichenflaeche extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("Das ist ein Text", 100, 100);
		g2.drawRect(100,100, 130,200);
		
	
	}
}


public class Zeichnen2 extends JFrame {
	private JPanel zeichenflaeche = new Zeichenflaeche();
	private int xStart, yStart;
	public Zeichnen2(){
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(zeichenflaeche);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Zeichnen2();

	}

}
