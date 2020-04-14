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
	 * Ces méthodes permettent d'incrémenter et décrémenter la barre d'énergie de la bête 
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
