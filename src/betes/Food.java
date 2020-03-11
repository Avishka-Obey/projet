package betes;

import java.awt.Image;
import java.util.HashMap;
import java.util.Random;

public class Food implements Element{

	private String typefood;
	private Position pos;
	private static HashMap <Integer,String> hm;
	private Image image;
	
	public Food() {
		hm = new HashMap<Integer, String> ();
		initFood();
		typefood = randomFood();
	}
	
	public Food(Image image,Position pos) {
		hm = new HashMap<Integer, String> ();
		initFood();
		typefood = randomFood();
		this.image = image;
		this.pos=pos;
	}
	
	public Food(String typefood,Position pos) {
		this.typefood = typefood;
		this.pos = pos;
		
	}
	
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
	
//	Faut dire que araignée c'est cette image en gros etc .. Il faut faire correspondre chaque nourriture au image puis justement les afficher
	
	public static void main(String [] args) {
		Food f = new Food();
		Food.initFood();
		
		f.randomFood();
		System.out.println(f.toString());
		f.randomFood();
		System.out.println(f.getTypeFood());
		f.randomFood();
		System.out.println(f.getTypeFood());
		f.randomFood();
		System.out.println(f.getTypeFood());
		f.randomFood();
		System.out.println(f.getTypeFood());
		f.randomFood();
		System.out.println(f.getTypeFood());
		f.randomFood();
		System.out.println(f.getTypeFood());
		f.randomFood();
		System.out.println(f.getTypeFood());
		f.randomFood();
		System.out.println(f.getTypeFood());
		
	}
}
