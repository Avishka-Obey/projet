package betes;

public class Characteristic {

	private int agility;
	private int velocity;
	private int madness;
	private int intelligence;
	private int strength;
	
	public Characteristic() {
		agility =(int)(Math.random() * 10);
		velocity=(int)(Math.random() * 10);
		madness=(int)(Math.random() * 10);
		intelligence=(int)(Math.random() * 10);
		strength = (int)(Math.random() * 10);
	}
	
	public int getAgility() {
		return agility;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public int getMadness() {
		return madness;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void boostCharacteristic() {
		
	}
	
	public String toString() {
		String text = "";
		text = "Agility = " + getAgility() + "\nVelocity = " + getVelocity() + "\nMadness = " + getMadness() + "\nIntelligence = " + getIntelligence() + "\nStrength = " + getStrength();
		return text;
	}
	
	public static void main (String[] args) {
		Characteristic at = new Characteristic();
		System.out.println(at.toString());
	}
}
