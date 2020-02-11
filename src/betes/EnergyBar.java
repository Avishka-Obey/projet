package betes;

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
	
	public static void main(String[] args) {
		
		EnergyBar eb = new EnergyBar(20);
		System.out.println(eb.getEnergy());
		
		while(eb.getEnergy() != 15) {
			eb.decrement();
		}
		System.out.println(eb.getEnergy());
		
		while(eb.getEnergy() != 18) {
			eb.increment();
		}
		System.out.println(eb.getEnergy());
		
	}
}
