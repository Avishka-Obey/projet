package betes;

import java.util.HashMap;

public class Grid {
	
	private HashMap<Position,Square> ca;
	private int nbCaseX;
	private int nbCaseY;
	private Square tab[][];
	
	public Grid(int n) {
		tab = new Square[n][n];
		
		
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
			Position pos = new Position(nbCaseX, nbCaseY);
			Food fo = new Food();
//			fo.setPosition(new Position (fo.getPosition().randomX(), 5)) ;
			tab[fo.getPosition().randomX()][fo.getPosition().randomY()] = new Square(pos,3);
		}
		
	}
	
	
	public void initBeast() {
		for (int i=0 ; i<20 ; i++) {
			Position pos = new Position(nbCaseX, nbCaseY);
			Beast be = new Beast();
			tab[be.getPosition().randomX()][be.getPosition().randomX()] = new Square(pos,5);
			
		}
	}

}
