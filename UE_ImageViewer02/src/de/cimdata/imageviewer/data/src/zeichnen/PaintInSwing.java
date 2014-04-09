package zeichnen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintInSwing {
	// unsere frisch gebackene Komponente
	private PaintingComponent paintingComponent = new PaintingComponent();

	/**
	 * Im Konstrukor wird die übliche Arbeit erledigt um den JFrame zu öffnen
	 * und die Komponenten zu initialisieren
	 */
	public PaintInSwing() {
		// einen JFrame erzeugen
		JFrame frame = new JFrame("Selbst Zeichnen mit Swing");
		// ein hübsches Layout setzen
		frame.setLayout(new BorderLayout());
		// dafür sorgen das das Programm beendet wird wenn man das 'X' anklickt
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// eine JComponent hat keine Ahnung davon was man auf ihr zeichnen
		// möchte.
		// Der LayoutManager hat also keine Möglichkeit die passende Größe für
		// unser
		// Objekt festzustellen und würde von (0,0) ausgehen.
		// Daher helfen wir etwas nach und setzen die gewünschte Größe händisch
		paintingComponent.setPreferredSize(new Dimension(300, 300));
		// unsere Komponente wird mittig im JFrame plaziert
		frame.add(paintingComponent, BorderLayout.CENTER);

		// in den unteren Bereich des Frames packen wir einige
		// Steuerelemente die wir der Übersicht wegen in einer
		// eigenen Methode erstellen und initialisieren
		frame.add(createControls(), BorderLayout.SOUTH);

		// der Frame enthält nun alle benötigten Komponenten
		// und kann nun seine minimale Größe berechnen
		frame.pack();
		// und noch den Frame sichtbar machen und zentrieren
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * hier wird ein JPanel erzeugt auf das wir alle Steuerelemente legen
	 * 
	 * @return ein JPanel das alle Steuerelemente enthält
	 */
	private Component createControls() {
		// ein einfaches FlowLayout soll für unser Beispiel genügen
		JPanel panel = new JPanel(new FlowLayout());

		// Ein Array mit den 3 Grundfarben wird erstellt und in
		// eine Combobox übergeben.
		// damit können wir später die Farbe der Zeichnung bestimmen
		Object[] colors = { Color.RED, Color.BLUE, Color.GREEN };
		final JComboBox colorBox = new JComboBox(colors);
		panel.add(colorBox);

		// Als nächstes ein Array mit Shapes (Figuren).
		// Der Einfachheit halber setzen wir die Position und Größe
		// für alle Objekte fest.
		// Die toString Methode wird hier überschrieben damit die Auswahl
		// in der Combobox besser lesbar ist.
		Object[] shapes = { new Ellipse2D.Float(10f, 10f, 100f, 100f) {
			public String toString() {
				return "Ellipse";
			}
		}, new RoundRectangle2D.Float(10f, 10f, 100f, 100f, 20f, 20f) {
			public String toString() {
				return "Abgerundetes Rechteck";
			}
		}, new Rectangle2D.Float(10f, 10f, 100f, 100f) {
			public String toString() {
				return "Rechteck";
			}
		} };
		// Mit der ComboBox können wir bestimmen welche Figur gezeichnet werden
		// soll
		final JComboBox shapeBox = new JComboBox(shapes);
		panel.add(shapeBox);

		// als letztes noch ein Button mit dem die gewählte Figur gezeichnet
		// wird
		JButton paintNow = new JButton("Zeichnen");
		panel.add(paintNow);
		paintNow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// wir teilen unserer Zeichenkomponente die gewählte Farbe mit
				paintingComponent.setColor((Color) colorBox.getSelectedItem());
				// wir teilen unserer Zeichenkomponente mit welche Figur wir
				// haben möchten
				paintingComponent.setShape((Shape) shapeBox.getSelectedItem());
				// jetzt soll gezeichnet werden
				paintingComponent.repaint();
			}

		});

		return panel;
	}

	public static void main(String[] args) {
		new PaintInSwing();
	}
}

class PaintingComponent extends JComponent {
	private Shape shape;
	private Color c;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (shape != null && c != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(c);
			g2d.draw(shape);
		}
	}

	public void setColor(Color c) {
		this.c = c;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
}