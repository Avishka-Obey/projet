package process;

/**
 * Cette classe permet aux bêtes de se déplacer
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import data.*;

public class Move {

	public Move() {

	}
	
	public static void move(Item b,int code, int rdm) {
		if(code==1 && b.getPosition().getX()>0) {  // a gauche
			b.getPosition().setX(b.getPosition().getX()-1);
		}
		else if(code==2 && b.getPosition().getX()<rdm-1) { // a droite
			b.getPosition().setX(b.getPosition().getX()+1);
		}
		
		else if(code==3 && b.getPosition().getY()>0) { // haut
			b.getPosition().setY(b.getPosition().getY()-1);
		}
		else if(code==4 && b.getPosition().getY()<rdm-1) { // bas
			b.getPosition().setY(b.getPosition().getY()+1);
		}
	}
	
}
