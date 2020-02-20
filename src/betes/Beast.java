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
		nm.add("Biche biche");
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
	
	public String getGender() {
		return this.gender ;
	}
	

	
	
	public EnergyBar getEnergy() {
		return energybar;
	}
	
	
	public Characteristic getCharacteristic() {
		return charater;
	}
	
	
	public String getEnvironment() {
		env.initEnvironment();
		env.randomEnvironment();
		return env.getType();
	}
	
	public Environment getEnv() {
		return env;
	}
	
	
	
	public Antenna getAnt() {
		return choice;
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
		
//		Normalement il  y a destruction de la bête
	}
	
	public Beast reproduce(Beast scorpio1) {
		Beast s = new Beast();
		s.getCharacteristic().setAgility(scorpio1.getCharacteristic().getAgility());
		s.getCharacteristic().setIntelligence(this.getCharacteristic().getIntelligence());
		s.getCharacteristic().setMadness(scorpio1.getCharacteristic().getMadness());
		s.getCharacteristic().setStrength(this.getCharacteristic().getStrength());
		s.getCharacteristic().setVelocity(scorpio1.getCharacteristic().getVelocity());
		s.getAnt().setLove(this.getAnt().getLove());
		s.getAnt().setSmell(scorpio1.getAnt().getSmell());
		s.getAnt().setVision(this.getAnt().getVision());
		s.getEnv().setType(this.getEnvironment()); //Seule ligne qui marche pas
		return s;
	}
	
	public String toString() {
		String text = "";
		text += "\n\nName : " + getName() + "\nColor : " + getColor() + "\nAge : " + getAge() + "\nGender : " + randomGender() + "\nCharacteristic : \n" + getCharacteristic().toString() + "\n\nEnvironment : " + getEnvironment() + "\n\nAntenna : \n" + getAnt().toString() + "\n\nEnergy Bar : " + getEnergy().getEnergy();
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
