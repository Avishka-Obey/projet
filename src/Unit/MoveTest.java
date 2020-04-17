package Unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Beast;
import data.Item;
import data.Position;
import process.Move;

class MoveTest {
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
	@Test
	void test() {
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
