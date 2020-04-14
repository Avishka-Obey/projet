package data;

import gui.*;

public class Position {
	private  int x;
	private  int y;
	
	private static int rx;
	private static int ry;
	
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
	
	public static int randomX() {
		rx = (int)(Math.random()*Interface.p.rdm);
		return rx;
	}
	
	public static int randomY() {
		ry = (int)(Math.random()*Interface.p.rdm);
		return ry;
	}
	
	public String toString() {
		String text = "";
		text += "L'abscisse est : " + getX() + "\nEt l'ordonnée est : " + getY() + "\n";
		return text;
	}
	
	/*public static void main(String[] args) {
		Position pos = new Position(Position.randomX(), Position.randomY());
		System.out.println(pos.toString());
		pos.setX(3);
	}*/

}
