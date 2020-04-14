package data;

/**
 * Cette classe represente les charact�ristique constituant l'attaque et la d�fense de la b�te (scorpion)
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
	 * Ce constructeur permet d'attribuer al�atoirement les charact�ristiques de la b�te entre 0 et 10
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
	 * Cette m�thode permettra de conf�r� un bonus de 3 point � une b�te sur sa charat�ristique la plus faible lors d'un combat
	 */
	
	public void bonus() {
		int tab[] = {getAgility(), getVelocity(), getMadness(), getIntelligence(), getStrength()};
		Arrays.sort(tab);
		int mini = tab[0];
		
		if(mini == getAgility()) {
			mini += 3;
			setAgility(mini);
			System.out.println("\nAgility has been changed");
		}
		
		else if(mini == getVelocity()) {
			mini += 3;
			setVelocity(mini);
			System.out.println("\nVelocity has been changed");
		}
		
		else if(mini == getMadness()) {
			mini += 3;
			setMadness(mini);
			System.out.println("\nMadness has been changed");
		}
		
		else if(mini == getIntelligence()) {
			mini += 3;
			setIntelligence(mini);
			System.out.println("\nIntelligence has been changed");
		}
		
		else if(mini == getStrength()) {
			mini += 3;
			setStrength(mini);
			System.out.println("\nStrength has been changed");
		}
	}
	
	/** 
	 * Cette m�thode fait la somme des charat�ristiques constituant l'attaque de la b�te
	 */
	
	public int somAttaque() {
		int n;
		n= getMadness() + getStrength();
		return n;
	}
	
	/** 
	 * Cette m�thode fait la somme des charat�ristiques constituant la d�fense de la b�te
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
	 * Ce main est pr�sent afin de tester dans la console que les charact�ristiques sont g�n�r�s al�atoirement
	 * et que la m�thode bonus modifie bien la charact�risque la plus faible
	 */
	
	public static void main (String[] args) {
		Characteristic at = new Characteristic();
		System.out.println("\n" + at.toString());
		at.bonus();
		System.out.println("\n\n" + at.toString());
	}
}
