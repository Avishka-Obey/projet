package betes;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int randomX() {
		x = (int)(Math.random() * 12);
		return x; 
	}
	
	public int randomY() {
		y = (int)(Math.random() * 12);
		return y;
	}
	
	public String toString() {
		String text = "";
		text += "L'abscisse est : " + getX() + "\nEt l'ordonn�e est : " + getY();
		return text;
	}

}
