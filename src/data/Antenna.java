package data;

/**
 * Cette classe represente le système d'antenne qui est un attribut de la bete (scorpion)
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

public class Antenna {
	private int vision;
	private int smell;
	private int love;
	

	/** 
	 * Ce constructeur permet d'attribuer aléatoirement le système d'antenne de la bête entre 0 et 10
	 */
	public Antenna() {
		vision = (int)(Math.random() * 10);
		smell = (int)(Math.random() * 10) ;
		love  = (int)(Math.random() * 10);
	}
	
	public Antenna(int vision , int smell, int love) {
		this.vision = vision;
		this.smell = smell;
		this.love = love;
		
	}
	
	public int getVision() {
		return vision;
	}
	
	public int getSmell() {
		return smell;
	}
	
	public int getLove() {
		return love;
	}
	
	public void setVision(int vision) {
		this.vision = vision;
	}
	
	public void setSmell(int smell) {
		this.smell = smell;
	}
	
	public void setLove(int love) {
		this.love = love;
	}
	
	public String toString() {
		String text = "";
		text = "Vision = " + getVision() + "\nSmell = " + getSmell() + "\nLove = " + getLove();
		return text;
	}
	/**
	 * Ce main est présent afin de tester dans la console 
	 * que les caractéristiques constituant le système sont attribués alèatoirement(entre 0 et 10)
	 * 
	 */
	
	public static void main (String[] args) {
		Antenna at = new Antenna();
		System.out.println(at.toString());
	}

}
