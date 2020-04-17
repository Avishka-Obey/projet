package Unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Beast;
import data.Food;
import data.Position;
import process.Choice;

class ChoiceTest {
	private static Beast a  ;
	private static Food b;
	private static int aX;
	private static int aY;
	private static int bX;
	private static int bY;
	

	/**
	 * Cette méthode permet le déplacement de la bête vers la nourriture
	 */
	public static void choice(Beast a, Food b ,int rdm) {
		
		aX = a.getPosition().getX();
		aY = a.getPosition().getY();
		bX = b.getPosition().getX();
		bY = b.getPosition().getY();
		
	
		if((aX!=bX)||(aY!=bY)) {
			if(aX<bX && a.getPosition().getX()<rdm-1) {
				a.getPosition().setX(a.getPosition().getX()+1);
//				System.out.println("Droite\nX = " + a.getPosition().getX() + "\nY = " + a.getPosition().getY() + "\n");
			}
			else if(aX>bX && a.getPosition().getX()>0) {
				a.getPosition().setX(a.getPosition().getX()-1);
//				System.out.println("Gauche\nX = " + a.getPosition().getX() + "\nY = "  + a.getPosition().getY() + "\n");
			}
		
			else if(aY<bY &&  a.getPosition().getY()<rdm-1) {
				a.getPosition().setY(a.getPosition().getY()+1);
//				System.out.println("Bas\nX = " + a.getPosition().getX() + "\nY = "  + a.getPosition().getY() + "\n");
			}
			else if (aY>bY && a.getPosition().getY()>0) {
				a.getPosition().setY(a.getPosition().getY()-1);
//				System.out.println("Haut\nX = "  + a.getPosition().getX() + "\nY = "  + a.getPosition().getY() + "\n");
			}
		}
	}
	

	
	@Test
	void test() {
		Beast.initName();
		Position pos1 = new Position(3,4);
		Position pos2 = new Position(6,9);
		Beast s = new Beast(pos1);
		Food f = new Food(pos2);
		
		while(s.getPosition()!=f.getPosition()) {
			Choice.choice(s, f, 12);
		}
		
	}
	}


