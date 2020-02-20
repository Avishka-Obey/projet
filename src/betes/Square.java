package betes;

public class Square {
	private Position pos;
	private Environment env;
	private Element elt1;
	private Element elt2;
	private int nbElt;
	private int nbEltMax;

	public Square(Position pos, int nbEltMax) {
		this.pos = pos;
		this.nbEltMax = nbEltMax;
		this.env = new Environment();
		this.elt1 = null;
		this.elt2= null;
		nbElt = 0 ;
	}
	public int getnbEltMax() {
		return nbEltMax;
	}
	public int getnbElt() {
		return nbElt;
	}
	

	public String toString() {
		String text = "";
		text += "Position : \n" + pos.toString() + "\n\nEltMax : " + nbEltMax + "\nEnvironnement :"+ env.toString() + "\nnbElt:" + nbElt + "\nElement1 : " + elt1 + "\nElement2" + elt2;
		return text;
	}
	public static void main(String[] args) {
		Position p = new Position(3,4);
		Square s = new Square(p, 3);
		Beast r = new Beast();
		
		System.out.println(s.toString());

	}
	
	

}
