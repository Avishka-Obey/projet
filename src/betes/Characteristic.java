package betes;

import java.util.Arrays;

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
	
	public void setAgility(int agility) {
		this.agility = agility;
	}
	
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	public void setMadness(int madness) {
		this.madness = madness;
	}
	
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	

	
	public void bonus() {
		int tab[] = {getAgility(), getVelocity(), getMadness(), getIntelligence(), getStrength()};
		Arrays.sort(tab);
		int mini = tab[0];
		
		if(mini == getAgility()) {
			mini += 3;
			setAgility(mini);
			System.out.println("\nAgility has changed");
		}
		
		else if(mini == getVelocity()) {
			mini += 3;
			setVelocity(mini);
			System.out.println("\nVelocity has changed");
		}
		
		else if(mini == getMadness()) {
			mini += 3;
			setMadness(mini);
			System.out.println("\nMadness has changed");
		}
		
		else if(mini == getIntelligence()) {
			mini += 3;
			setIntelligence(mini);
			System.out.println("\nIntelligence has changed");
		}
		
		else if(mini == getStrength()) {
			mini += 3;
			setStrength(mini);
			System.out.println("\nStrength has changed");
		}
	}
	
	public String toString() {
		String text = "";
		text = "Agility = " + getAgility() + "\nVelocity = " + getVelocity() + "\nMadness = " + getMadness() + "\nIntelligence = " + getIntelligence() + "\nStrength = " + getStrength();
		return text;
	}
	
	public static void main (String[] args) {
		Characteristic at = new Characteristic();
		System.out.println("\n" + at.toString());
		at.bonus();
		System.out.println("\n\n" + at.toString());
	}
}
