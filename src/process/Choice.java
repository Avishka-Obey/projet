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
			}
			else if(aX>bX && a.getPosition().getX()>0) {
				a.getPosition().setX(a.getPosition().getX()-1);
			}
		
			else if(aY<bY &&  a.getPosition().getY()<rdm-1) {
				a.getPosition().setY(a.getPosition().getY()+1);
			}
			else if (aY>bY && a.getPosition().getY()>0) {
				a.getPosition().setY(a.getPosition().getY()-1);
			}
		}
	}
		
}
