package data;

/**
 * Cette classe represente la position qui est un attribut des 3 objets que nous avons (bête, nourriture, environnement)
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import gui.*;

public class Position {
	private  int x;
	private  int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equals(Position p) {
		if(p.getX()==this.x && p.getY()==this.y) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		String text = "";
		text += "L'abscisse est : " + getX() + "\nEt l'ordonnée est : " + getY() + "\n";
		return text;
	}
}
