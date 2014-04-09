package zeichnen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Canvas extends JPanel {
	private Figur figur;

	public Canvas(Figur f) {
		this.figur = f;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		if (figur instanceof Linie) {
			List<Point> list = ((Linie) figur).getL();
			for (Point point : list) {
				g2.drawLine(point.x, point.y, point.x, point.y);
			}
		}

	}

	public void setFigur(Figur f) {
		this.figur = f;
	}
}

public class Zeichnen3 extends JFrame {
	Linie linie = new Linie();
	private JPanel zeichenflaeche = new Canvas(linie);

	public Zeichnen3() {
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		zeichenflaeche.addMouseMotionListener(new MouseMover());
		add(zeichenflaeche);
		setVisible(true);
	}

	class MouseMover extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			linie.add(new Point(e.getX(), e.getY()));
			repaint();
		}

	}

	public static void main(String[] args) {
		new Zeichnen3();

	}

}
