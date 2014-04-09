package app;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Zeichnen1 extends JFrame {
	private JPanel zeichenflaeche = new JPanel();
	private int xStart, yStart;
	public Zeichnen1(){
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
		add(zeichenflaeche);
		setVisible(true);
	}
	
	
	class MyMouseListener extends  MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println(e.getX()+" "+e.getY());
			xStart = e.getX();
			yStart = e.getY();
		}
	}
	
	class MyMouseMotionListener extends MouseMotionAdapter{

		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println(e.getX()+" "+e.getY());
			Graphics2D g2 = (Graphics2D) getGraphics();
			g2.setColor(Color.BLUE);
			
			g2.drawLine(xStart, yStart, e.getX(), e.getY());
			xStart = e.getX();
			yStart = e.getY();
		}
			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Zeichnen1();

	}

}
