package data;

public class EnergyBar {

	private int energy;
	
	public EnergyBar(int energy) {
		this.energy = energy;
	}
	
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
	
	public static void main(String[] args) {
		
		EnergyBar eb = new EnergyBar(20);
		System.out.println(eb.toString());		
	
	}
}
