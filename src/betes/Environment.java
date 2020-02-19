package betes;

import java.util.HashMap;
import java.util.Random;

public class Environment {

	private String type;
	private HashMap <Integer,String> hm;
	
	public Environment() {
		hm = new HashMap<Integer, String> ();
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
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
