package betes;

public class Move {
	private int up;
	private int down;
	private int right;
	private int left;
	private Position pos;
	
	public Move() {
		this.up=up;
		this.down=down;
		this.right=right;
		this.left=left;
		this.pos = new Position(Position.randomX(), Position.randomY());
	}
	
	public Position getPos() {
		return pos;
	}
	
	public Position haut(Position pos) {
		
		if(getPos().getY()<12) {
			up = getPos().getY() + 1;
			pos = new Position(getPos().getX(), up);
		}
		
		return pos;
	}
	
	public Position bas(Position pos) {
		if(getPos().getY()>0) {
			down = getPos().getY() -1;
			pos = new Position(getPos().getX(), down);
		}
		return pos;
	}
	
	public Position gauche(Position pos) {
		if(getPos().getX()>0) {
			left = getPos().getX() -1;
			pos = new Position(left, getPos().getY());
		}
		return pos;
	}
	
	public Position droite(Position pos) {
		if(getPos().getX()<12) {
			right = getPos().getX() +1;
			pos = new Position(right, getPos().getY());
		}
		return pos;
	}
	
	public String toString() {
		String text = "";
		text += "Abscisse : " + getPos().getX() + "\nOrdonnée : " + getPos().getY(); 
		return text;
	}
	
	public static void main(String[] args) {
		Move m = new Move();
		
		System.out.println(m.getPos().toString());
		
		
		m.gauche(m.getPos());
		System.out.println("\n" + m.toString());
	}
	
}
