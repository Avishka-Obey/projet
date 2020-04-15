package data;

/**
 * Cette classe represente les charactéristique constituant l'attaque et la défense de la bête (scorpion)
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import java.util.Arrays;

public class Characteristic {

	private int agility;
	private int velocity;
	private int madness;
	private int intelligence;
	private int strength;
	
	/** 
	 * Ce constructeur permet d'attribuer aléatoirement les charactéristiques de la bête entre 0 et 10
	 */
	
	public Characteristic() {
		agility =(int)(Math.random() * 10);
		velocity=(int)(Math.random() * 10);
		madness=(int)(Math.random() * 10);
		intelligence=(int)(Math.random() * 10);
		strength = (int)(Math.random() * 10);
	}
	public Characteristic(int agility,int velocity, int madness, int intelligence,int strength) {
		this.agility = agility ;
		this.velocity = velocity;
		this.madness = madness ;
		this.intelligence = intelligence;
		this.strength = strength;
		
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
				System.out.println("\nAgility has been changed");
			}
		}
		
		else if(mini == getVelocity()) {
			if(getVelocity()<7) {
				mini += 3;
				setVelocity(mini);
				System.out.println("\nVelocity has been changed");
			}
		}
		
		else if(mini == getMadness()) {
			if(getMadness()<7) {
				mini += 3;
				setMadness(mini);
				System.out.println("\nMadness has been changed");
			}
		}
		
		else if(mini == getIntelligence()) {
			if(getIntelligence()<7) {
				mini += 3;
				setIntelligence(mini);
				System.out.println("\nIntelligence has been changed");
			}
		}
		
		else if(mini == getStrength()) {
			if(getStrength()<7) {
				mini += 3;
				setStrength(mini);
				System.out.println("\nStrength has been changed");
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
	
	/**
	 * Ce main est présent afin de tester dans la console que les charactéristiques sont générés aléatoirement
	 * et que la méthode bonus modifie bien la charactérisque la plus faible
	 */
	
	public static void main (String[] args) {
		Characteristic at = new Characteristic();
		System.out.println("\n" + at.toString());
		at.bonus();
		System.out.println("\n\n" + at.toString());
	}
}
