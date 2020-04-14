package data;

/**
 * Cette classe represente l'environnement qui est un objet de la grille
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */
import java.awt.Image;
import java.util.HashMap;
import java.util.Random;

public class Environment implements Item{

	private String type;
	private HashMap <Integer,String> hm;
	private Image image;
	private Position pos;
	
	/**
	 * Ce constructeur a été créer uniquement pour les tests en console
	 */
	
	public Environment() {
		hm = new HashMap<Integer, String> ();
		initEnvironment();
		randomEnvironment();
		
	}
	
	/**
	 *Dans l'Interface graphique chaque objet sera déterminé par une image ainsi qu'une position
	 *Ce constructeur attribue un type d'environnement, une image et une position à l'objet
	 */
	
	public Environment(String type,Image image, Position pos) {
		hm = new HashMap<Integer, String> ();
		initEnvironment();
		randomEnvironment();
		this.type=type;
		this.image = image;
		this.pos=pos;
	}
	
	public Environment(String type) {
		this.type = type;
		
	}
	
	public String getStringType() {
		return "environnement";
	}
	
	/**
	 *Initialisation des différents environnements dans une HashMap
	 */
	
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
	
	/**
	 *Cette méthode renvoie un environnement aléatoirement
	 */
	
	public void randomEnvironment() {
		type = hm.get(Random());
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
}
