package betes;

import java.util.HashMap;

public class Grid {
	
	private HashMap<Position,Square> ca;
	private int nbCaseX;
	private int nbCaseY;
	private Square tab[][];
	
	public Grid() {
		tab = new Square[12][12];
	}
	
	public void ilyaquoidanscettegrille() {
		int i;
		int j;
		
		for(i=0 ; i<nbCaseX ; i++) {
			for(j=0 ; j<nbCaseY ; j++) {
				Position pos = new Position(nbCaseX, nbCaseY);
				Square s = new Square(pos, 2);
				ca.put(pos, s);
			}
		}
	}
	
	public void initFood() {
		for (int i=0 ; i<30 ; i++) {
			Position pos = new Position(Position.randomX(), Position.randomY());
			Food fo = new Food();
			fo.randomFood();
			tab[pos.getX()][pos.getY()] = new Square(pos,fo,3);
		}
		
	}
	
	
	public void initBeast() {
		for (int i=0 ; i<20 ; i++) {
			Beast be = new Beast();
			Beast.initName();
			be.randomName();
			Position pos = new Position(Position.randomX(), Position.randomY());
			tab[pos.getX()][pos.getY()] = new Square(pos,be,3);
		}
	}
	
	
	
	public static void main(String[] args) {
		Grid g = new Grid();
		g.initFood();
//		g.initBeast();
		
		for(int i=0; i<=12; i++ ) {
			for(int j=0; j<=12; j++) {
				System.out.println(g.tab[i][j]);
			}
		}
		
	}

}
