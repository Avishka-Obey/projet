package process;

/**
 * Cette classe permet aux b�tes de se d�placer
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
	
	/**
	 * Ce main est pr�sent afin de tester dans la console que selon le code transmis aleatoirement
	 *  la b�te se deplace bien vers la direction choisit.
	 */

	
	public static void main(String[] args) {
		Beast.initName();
		int random;
		Position pos = new Position(3, 4);
		Beast s = new Beast(pos);
		
		for(int i=0; i<10; i++) {
			random = (int)(Math.random()*4+1);
			Move.move(s, random, 12);
			
			if(random == 1) {
				System.out.println(random);
				System.out.println("Gauche\n\n");
			}
			
			else if(random == 2) {
				System.out.println(random);
				System.out.println("Droite\n\n");
			}
			
			else if(random == 3) {
				System.out.println(random);
				System.out.println("Haut\n\n");
			}
			
			else if(random == 4) {
				System.out.println(random);
				System.out.println("Bas\n\n");
			}
			
		}
	}
	
}
