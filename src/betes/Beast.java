package betes;

import java.util.HashMap;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class Beast implements Item{
	private String name;
	private Integer age;
	private String gender;
	private Antenna choice;
	private EnergyBar energybar;
	private Characteristic charater;
	private Environment env;
	private Position pos;
	private HashMap <Integer,String> hm;
	private static ArrayList <String> nm;
	private Image image;
	private InterfaceChoice ic ;
	
	

	
	public Beast() {
		this.name = getName();
		this.age = 0; 
		this.gender = randomGender();
		this.energybar = new EnergyBar(20);
		this.charater = new Characteristic();
		this.env = new Environment();
		this.choice = new Antenna();
		
	}
	
	public Beast(Image image, Position pos) {
		this.name = getName();
		this.age = 0; 
		this.gender = randomGender();
		this.energybar = new EnergyBar(20);
		this.charater = new Characteristic();
		this.env = new Environment();
		this.choice = new Antenna();
		this.image = image;
		this.pos = pos;
		//this.ic =ic;
	}
	
	public Beast(String name , Integer age , String gender , Antenna choice , EnergyBar energybar , Characteristic charater , Environment env , Position pos) {
		this.name = name;
		this.age = age ;
		this.gender = gender;
		this.choice = choice ;
		this.energybar = energybar;
		this.charater = charater;
		this.env = env;
		this.pos = pos;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public String getStringType() {
		return "beast";
	}

	
	public static void initName() {
		nm = new ArrayList <String> ();
		nm.add("Georges");
		nm.add("Michel");
		nm.add("Gertrude");
		nm.add("Morcef");
		nm.add("Plot");
		nm.add("Baba");
		nm.add("Mr Propre");
		nm.add("Da uz");
		nm.add("Ave le A");
		nm.add("Nana");
		nm.add("Biche biche");
		nm.add("Double bosse");
		nm.add("Freezer");
		nm.add("Lak");
		nm.add("Front");
		nm.add("Captain");
		nm.add("Jentra");
		nm.add("Haktai");
		nm.add("Jackie");
		nm.add("Coto");
		nm.add("Travis");
		nm.add("Truth");
		nm.add("Oklm");
		nm.add("Huka");
		nm.add("Lady Killer");
		nm.add("Liberty");
		nm.add("Fanta");
		
		nm.add("Jacquline");
		nm.add("Issaq");
		nm.add("Antoine");
		nm.add("Benjamin");
		nm.add("Lou");
		nm.add("Logane");
		nm.add("Mattieu");
		nm.add("Christophe");
		nm.add("Ad");
		nm.add("Vivi");
		nm.add("Charlie");
		nm.add("Vanessa");
		nm.add("Julie");
		nm.add("Megane");
		
		
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
		randomName();
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
	
	public Position getPosition() {
		return pos;
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
	
	public void destroy() {
		this.name = null;
		this.age = null; 
		this.gender = null;
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
			s.getEnvironment();
			return s;
		
		
		
	}
//	public void move(Beast,Map) {
//		this.ic.move(this, Map);
//	}
	
	public String toString() {
		String text = "";
		text += "\n\nName : " + getName() + "\nAge : " + getAge() + "\nGender : " + randomGender() + "\nCharacteristic : \n" + getCharacteristic().toString() + "\n\nEnvironment : " + getEnvironment() + "\n\nAntenna : \n" + getAnt().toString() + "\n\nEnergy Bar : " + getEnergy().getEnergy() + "\n\nPosition : " + getPosition() ;
		return text;
	}
	

	public static void main (String[] args) {
		
		Beast.initName();
		
		for(int i = 0; i<14; i++) {
			Beast s = new Beast();

			System.out.println(s.toString());
		
		}
		
	}
}
