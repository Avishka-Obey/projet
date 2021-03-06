package process;
/**
 * Cette classe represente le systeme d'antenne
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */
import data.*;

public class Choice {
	private static Beast a  ;
	private static Food b;
	private static int aX;
	private static int aY;
	private static int bX;
	private static int bY;
	
	public Choice(Beast a, Food b ) {
		this.a = a ;
		this.b =  b;	
	}
	
	/**
	 * Cette m�thode permet le d�placement de la b�te vers la nourriture
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
	/**
	 * Ce main est pr�sent afin de tester dans la console que notre b�te
	 * se deplace bien vers une nourriture precise
	 */
	
	public static void main(String[] args) {
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
