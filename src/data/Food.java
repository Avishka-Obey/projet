package data;

/**
 * Cette classe represente la nourriture qui est un objet de la grille
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */
import java.awt.Image;

import java.util.HashMap;
import java.util.Random;

public class Food implements Item{

	private String typefood;
	private Position pos;
	private static HashMap <Integer,String> hm;
	private Image image;
	
	/**
	 * Ce constructeur a été créer uniquement pour les tests en console
	 */
	
	public Food() {
		hm = new HashMap<Integer, String> ();
		initFood();
	}
	
	/**
	 *Dans l'Interface graphique chaque objet sera déterminé par une image ainsi qu'une position
	 *Ce constructeur attribue un type de nourriture, une image et une position à l'objet
	 */
	
	public Food(String typefood,Image image,Position pos) {
		hm = new HashMap<Integer, String> ();
		initFood();
		this.typefood=typefood;
		this.image = image;
		this.pos=pos;
	}
	
	/**
	 *Methode redefinit de l'interface item permettant de determiner que l'objet est de type "food"
	 */
	
	public String getStringType() {
		return "food";
	}
	
	/**
	 *Initialisation des différentes nourritures dans une HashMap
	 */
	
	public static void initFood() {
		hm.put(0, "Spider");
		hm.put(1, "Mouse");
		hm.put(2, "Lizard");
		hm.put(3, "Snake");
		hm.put(4, "Mosquito");
		hm.put(5, "Bay");
	}
	
	public int Random() {
		Random rm = new Random();
		int n;
		n = rm.nextInt(6);
		return n;
	}
	
	/**
	 *Cette méthode renvoie une nourriture aléatoirement
	 */
	
	public String randomFood() {
		typefood = hm.get(Random());
		return typefood;
	}
	
	public String getTypeFood() {
		return typefood;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public void setPosition(Position pos) {
		this.pos = pos;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public String toString() {
		String texte = "";
		texte +="Food : "+ getTypeFood() + "\n\nPosition :" + getPosition();
		return texte;
	}
	

}
