package betes;

import java.util.HashMap;
import java.util.Random;

public class Food implements Element{

	private String typefood;
	private Position pos;
	private HashMap <Integer,String> hm;
	
	public Food() {
		hm = new HashMap<Integer, String> ();
		initFood();
		typefood = randomFood();
	}
	public Food(String typefood,Position pos) {
		this.typefood = typefood;
		this.pos = pos;
	}
	
	public void initFood() {
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
	public String toString() {
		String texte = "";
		texte +="Food : "+ typefood + "Position :" + pos;
		return texte;
	}
	
	public static void main(String [] args) {
		Food f = new Food();
		f.initFood();
		
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
		f.randomFood();
		System.out.println(f.getTypeFood());
		
	}
}
