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
//		this.pos = new Position(Position.randomX(), Position.randomY());
	}
	
	public static void move(Item b,int code) {
		if(code==1 && b.getPosition().getX()>0) {  // a gauche
			b.getPosition().setX(b.getPosition().getX()-1);
		}
		else if(code==2 && b.getPosition().getX()<12) { // a droite
			b.getPosition().setX(b.getPosition().getX()+1);
		}
		
		else if(code==3 && b.getPosition().getY()>0) { // haut
			b.getPosition().setY(b.getPosition().getY()-1);
		}
		else if(code==4 && b.getPosition().getY()<12) { // bas
			b.getPosition().setY(b.getPosition().getY()+1);
		}
	}
	
	public Position getPos() {
		return pos;
	}
	
	public Beast haut(Beast b) {
		
		if(b.getPosition().getY()<551) {
			b.getPosition().setY(b.getPosition().getX()+50);
		}
		return b;
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
		System.out.println(m.getPos().toString() + "\n");
		m.gauche(m.getPos());
		System.out.println(m.toString());
	}
	
}
