package data;

/**
 * Cette classe represente notre objet principale qui est une bete (scorpion)
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import process.*;
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
//	private InterfaceChoice ic ;
	private Position initPosition ;
	private String marriedWith;
	public static ArrayList<String> img = new ArrayList<String>();
	private String str;
	
	/**
	 * Ce constructeur ne prend aucun argument en paramètre car il est
	 * seulement utiliser pour tester nos méthodes dans la console
	 */
	
	public Beast() {
		randomName();
		this.age = 0; 
		randomGender();
		this.energybar = new EnergyBar(20);
		this.charater = new Characteristic();
		this.env = new Environment();
		this.choice = new Antenna();
		this.marriedWith = null;
		
	}
	
	/**
	 *Dans l'Interface graphique chaque objet sera déterminé 
	 * par une image ainsi qu'une position
	 */
	
	public Beast(Image image, Position pos) {
		randomName();
		initPosition = new Position(pos.getX(),pos.getY());
		this.age = 0; 
		randomGender();
		this.energybar = new EnergyBar(20);
		this.charater = new Characteristic();
		this.env = new Environment();
		this.choice = new Antenna();
		this.image = image;
		this.pos = pos;
		this.marriedWith = null;
		//this.ic =ic;
	}
	
	public Position getInitPosition(){
		return this.initPosition;
	}
	
	public String getMarriedWith() {
		return this.marriedWith;
	}
	
	public void setMarriedWith(String marriedWith) {
		this.marriedWith = marriedWith;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	/**
	 *Methode redefinit de l'interface item permettant de determiner 
	 *que l'objet est de type "beast"
	 */

	public String getStringType() {
		return "beast";
	}
	
	/**
	 * Cette méthode permet d'ajouter dans une arraylist des prénoms
	 * que l'on attribura par la suite aux scorpions
	 */

	public static void initName() {
		nm = new ArrayList <String> ();
		nm.add("Tieks");
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
		
		nm.add("Mg");
		nm.add("Zozo");
		nm.add("Slavisky");
		nm.add("Firat");
		nm.add("Crousty");
		nm.add("King");
		nm.add("Bengalawa");
		nm.add("Dengala");
		nm.add("Ad");
		nm.add("Vivi");
		nm.add("Pums");
		nm.add("Faco");
		nm.add("Moudji");
		nm.add("Grizzly");
		
		nm.add("Brasco");
		nm.add("Fox");
		nm.add("Trunk");
		nm.add("Binks");
		nm.add("Perche");
		nm.add("Boms");
		nm.add("Karel");
		nm.add("Sose");
		nm.add("Bulls");
		nm.add("Medusa");
		nm.add("Bousko");
		nm.add("Wolf");
		nm.add("Ous");
		nm.add("Issou");
		
		
	}
	
	
	/**
	 * methode selectionnant un nom au hasard dans l'arraylist
	 * une fois selectionné il est supprimé
	 */

	public void randomName() {
		int rnd = (int) (Math.random() * nm.size());
		this.name = nm.get(rnd);
		nm.remove(rnd);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	public static void initBaby() {
		img.add("src/images/bludeaux.png");
		img.add("src/images/blurange.png");
		img.add("src/images/browdeaux.png");
		img.add("src/images/gred.png");
		img.add("src/images/grink.png");
		img.add("src/images/liblue.png");
		img.add("src/images/librown.png");
		img.add("src/images/ligray.png");
		img.add("src/images/ligreen.png");
		img.add("src/images/pirange.png");
		img.add("src/images/purnude.png");
		img.add("src/images/purpblue.png");
		img.add("src/images/purpeen.png");
		img.add("src/images/purpink.png");
		img.add("src/images/roudeaux.png");
		img.add("src/images/yellown.png");
		img.add("src/images/yelrange.png");
		img.add("src/images/yelray.png");
		img.add("src/images/yelred.png");
		img.add("src/images/yewleen.png");
	}
	
	public String randomBaby() {
		int rnd = (int) (Math.random() * img.size());
		str = img.get(rnd);
		img.remove(rnd);
		return str;
	}
		
	
	public int getAge() {
		return age;
	}
	
	/**
	 * methode permettant d'incrementer l'âge de la bête 
	 */

	public int ageIncrement() {
		age++;
		return age;
	}

	
	
	public void initGender() {
		hm = new HashMap<Integer, String> ();
		hm.put(0, "male");
		hm.put(1, "female");
	} 
	
	/**
	 * methode retournant le sexe de la bête
	 * attribuer aléatoirement
	 */

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
		return env.getType();
	}
	
	
	public Antenna getAnt() {
		return choice;
	}
	
	/**
	 * Cette méthode créer une nouvelle bête ayant ses caracteristiques 
	 * héritant de sa mere et de son pere (probabilité de 50%) 
	 */
	
	public Beast reproduce(Beast scorpio1) {
		Beast s = new Beast(GridConstructor.readImage(randomBaby()), new Position(pos.getX(),pos.getY())) ;
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
		text += "Name : " + getName() + "\nAge : " + getAge() + "\nGender : " + gender + "\nCharacteristic : \n" + getCharacteristic().toString() + "\n\nEnvironment : " + getEnvironment() + "\n\nAntenna : \n" + getAnt().toString() + "\n\nEnergy Bar : " + getEnergy().getEnergy() + "\n\nPosition : " + getPosition() ;
		return text;
	}
	
	/**
	 * Ce main est présent afin de tester dans la console que notre bête possède 
	 * toutes les attributs nécessaires (age, sexe, nom ...)
	 * Les seuls attributs manquant sont la position et l'image car nous utilisons 
	 * le constructeur sans paramètres
	 */

	public static void main (String[] args) {
		
		Beast.initName();
		
		for(int i = 0; i<14; i++) {
			Beast s = new Beast();

			System.out.println(s.toString());
		
		}
		
	}
}
