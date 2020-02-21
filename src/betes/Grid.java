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

}
