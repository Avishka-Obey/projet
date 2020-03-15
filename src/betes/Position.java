package betes;

public class Position {
	private static int x;
	private static int y;
	
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
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public static int randomX() {
		x = (int)(Math.random() * 12);
		return x; 
	}
	
	public static int randomY() {
		y = (int)(Math.random() * 12);
		return y;
	}
	
	public String toString() {
		String text = "";
		text += "L'abscisse est : " + getX() + "\nEt l'ordonnée est : " + getY() + "\n";
		return text;
	}
	
	public static void main(String[] args) {
		Position pos = new Position(Position.randomX(), Position.randomY());
		System.out.println(pos.toString());
		pos.setX(3);
	}

}
