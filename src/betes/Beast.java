package betes;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class Beast {
	private String name;
	private Integer age;
	private String gender;
	private Color color;
	private Antenna choice;
	private EnergyBar energybar;
	private Characteristic charater;
	private Environment env;
	private HashMap <Integer,String> hm;
	private static ArrayList <String> nm;

	
	public Beast() {
		this.name = getName();
		this.age = 0; 
		this.gender = randomGender();
		this.color = getColor();
		this.energybar = new EnergyBar(20);
		this.charater = new Characteristic();
		this.env = new Environment();
		this.choice = new Antenna();
	}
	
	
	public static void initName() {
		nm = new ArrayList <String> ();
		nm.add("Georges");
		nm.add("Michel");
		nm.add("Gertrude");
		nm.add("Morcef");
		nm.add("Plot");
		nm.add("Baltringue");
		nm.add("Mr Propre");
		nm.add("La Iech");
		nm.add("Ave le A");
		nm.add("Oueeeesh");
		nm.add("Caillement");
		nm.add("Double bosse");
		nm.add("Freezer");
		nm.add("Lak");
		nm.add("Front");
		nm.add("Chauve");
		nm.add("Jentra");
		nm.add("Haktai");
		nm.add("Jackie");
		nm.add("Chang");
		nm.add("Tram");
		nm.add("Trousse");
		nm.add("Oklm");
		nm.add("Huka");
		nm.add("Lady Killer");
		nm.add("Amnesia");
		nm.add("Fanta");
	}
	
	public String randomName() {
		int rnd = (int) (Math.random() * nm.size());
		name = nm.get(rnd);
		nm.remove(rnd);
		setName(name);
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	
	
	public int getAge() {
		return age;
	}
	
	public int incrementAge() {
		age++;
		return age;
	}
	
	
	public void initGender() {
		hm = new HashMap<Integer, String> ();
		hm.put(0, "male");
		hm.put(1, "female");
	} 
	
	public String randomGender() {
		Random rm = new Random();
		int n;
		n = rm.nextInt(2);
		initGender();
		gender = hm.get(n);
		return gender;
	}
	
	
	public int energy() {
		return energybar.getEnergy();
	}
	
	public String charact() {
		int a;
		int b;
		int c;
		int d;
		int e;
		
		a = charater.getAgility();
		b = charater.getIntelligence();
		c = charater.getMadness();
		d = charater.getStrength();
		e = charater.getVelocity();
		
		String text = "";
		text = "Agility = " + a + "\nVelocity = " + e + "\nMadness = " + c + "\nIntelligence = " + b + "\nStrength = " + d;
		return text;
	}
	
	public void bonus() {
		charater.bonus();
	}
	
	public int somAttaque() {
		int n;
		n= charater.getMadness() + charater.getStrength();
		return n;
	}
	
	public int somDefense() {
		int n;
		n = charater.getAgility() + charater.getIntelligence() + charater.getVelocity();
		return n;
	}
	
	
	public String getEnvironment() {
		env.initEnvironment();
		env.randomEnvironment();
		return env.getType();
	}
	
	
	
	public String ant() {
		return choice.toString();
	}
	
	public Color randomColor() {
		Random rm = new Random();
		int n;
		int m;
		int o;
		n = rm.nextInt(250);
		m = rm.nextInt(250);
		o = rm.nextInt(250);
		
		Color z = new Color(n,m,o);
		return z;
	}
	
	public Color getColor() {
		color = randomColor();		
		return color;
	}
	
	public void destroy() {
		this.name = null;
		this.age = null; 
		this.gender = null;
		this.color = null;
		this.energybar = null;
		this.charater = null;
		this.choice = null;
	}
	
	public String toString() {
		String text = "";
		text += "\n\nName : " + getName() + "\nColor : " + getColor() + "\nAge : " + getAge() + "\nGender : " + randomGender() + "\nCharacteristic : \n" + charact() + "\n\nEnvironment : " + getEnvironment() + "\n\nAntenna : \n" + ant() + "\n\nEnergy Bar : " + energy();
		return text;
	}
	

	public static void main (String[] args) {
		
		Beast.initName();
		
		for(int i = 0; i<10; i++) {
			Beast s = new Beast();
			s.randomName();
			System.out.println(s.toString());
		}
		
	}
}
