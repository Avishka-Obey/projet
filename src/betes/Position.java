package betes;

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
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		String text = "";
		text += "L'abscisse est : " + getX() + "\nEt l'ordonn�e est : " + getY() + "\n";
		return text;
	}
	
	/*public static void main(String[] args) {
		Position pos = new Position(Position.randomX(), Position.randomY());
		System.out.println(pos.toString());
		pos.setX(3);
	}*/

}
