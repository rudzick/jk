package zeichnen;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Linie extends Figur {
	private List<Point> l = new ArrayList<>();

	public List<Point> getL() {
		return l;
	}
	
	public void add(Point p){
		l.add(p);
	}
}
