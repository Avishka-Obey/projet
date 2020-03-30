package betes;

import java.awt.Image;
import java.util.HashMap;
import java.util.Random;

public class Environment implements Item{

	private String type;
	private HashMap <Integer,String> hm;
	private Image image;
	private Position pos;
	
	public Environment() {
		hm = new HashMap<Integer, String> ();
		initEnvironment();
		type = randomEnvironment();
	}
	
	public Environment(String type,Image image, Position pos) {
		hm = new HashMap<Integer, String> ();
		initEnvironment();
		type = randomEnvironment();
		this.type=type;
		this.image = image;
		this.pos=pos;
	}
	
	public Environment(String type) {
		this.type = type;
		
	}
	
	public void initEnvironment() {
		hm.put(0, "Desert");
		hm.put(1, "Mountain");
		hm.put(2, "Forest");
	}
	
	public int Random() {
		Random rm = new Random();
		int n;
		n = rm.nextInt(3);
		return n;
	}
	
	public String randomEnvironment() {
		type = hm.get(Random());
		return type;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public String toString() {
		String texte="";
		texte+=" type: " + getType() + " Position :" + getPosition();
		return texte;
	}
	
	
	
	public static void main(String [] args) {
		Environment env = new Environment();
		env.initEnvironment();
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
		
		env.randomEnvironment();
		System.out.println(env.getType());
	}
}
