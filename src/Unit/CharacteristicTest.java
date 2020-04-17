package Unit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import data.Characteristic;

class CharacteristicTest {
	private int agility;
	private int velocity;
	private int madness;
	private int intelligence;
	private int strength;
	
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
	
	/** 
	 * Cette méthode permettra de conféré un bonus de 3 point à une bête sur sa charatéristique la plus faible lors d'un combat
	 */
	
	public void bonus() {
		int tab[] = {getAgility(), getVelocity(), getMadness(), getIntelligence(), getStrength()};
		Arrays.sort(tab);
		int mini = tab[0];
		
		if(mini == getAgility()) {
			if(getAgility()<7) {
				mini += 3;
				setAgility(mini);
//				System.out.println("\nAgility has been changed");
			}
		}
		
		else if(mini == getVelocity()) {
			if(getVelocity()<7) {
				mini += 3;
				setVelocity(mini);
//				System.out.println("\nVelocity has been changed");
			}
		}
		
		else if(mini == getMadness()) {
			if(getMadness()<7) {
				mini += 3;
				setMadness(mini);
//				System.out.println("\nMadness has been changed");
			}
		}
		
		else if(mini == getIntelligence()) {
			if(getIntelligence()<7) {
				mini += 3;
				setIntelligence(mini);
//				System.out.println("\nIntelligence has been changed");
			}
		}
		
		else if(mini == getStrength()) {
			if(getStrength()<7) {
				mini += 3;
				setStrength(mini);
//				System.out.println("\nStrength has been changed");
			}
		}
	}
	
	/** 
	 * Cette méthode fait la somme des charatéristiques constituant l'attaque de la bête
	 */
	
	public int somAttaque() {
		int n;
		n= getMadness() + getStrength();
		return n;
	}
	
	/** 
	 * Cette méthode fait la somme des charatéristiques constituant la défense de la bête
	 */
	
	public int somDefense() {
		int n;
		n = getAgility() + getIntelligence() + getVelocity();
		return n;
	}
	
	public String toString() {
		String text = "";
		text = "Agility = " + getAgility() + "\nVelocity = " + getVelocity() + "\nMadness = " + getMadness() + "\nIntelligence = " + getIntelligence() + "\nStrength = " + getStrength();
		return text;
	}
	
	@Test
	void test() {
		CharacteristicTest at = new CharacteristicTest();
		System.out.println("\n" + at.toString());
		at.bonus();
		System.out.println("\n\n" + at.toString());
	}

}
