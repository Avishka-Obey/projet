package data;


/**
 * Cette classe represente la barre d'energie du scorpion
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

public class EnergyBar {

	private int energy;
	
	public EnergyBar(int energy) {
		this.energy = energy;
	}
	
	/**
	 * Ces m�thodes permettent d'incr�menter et d�cr�menter la barre d'�nergie de la b�te 
	 */
	
	public int increment() {
		energy++;
		return energy;
	}
	
	public int decrement() {
		energy--;
		return energy;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public String toString() {
		String text = "";
		text += "" + getEnergy();
		return text;
	}
	
	
}
