package process;

/**
 * Cette classe permet la construction de tous les objets ainsi que la grille
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import data.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class GridConstructor {
	
	
	private ArrayList<String> al = new ArrayList<String>(20);
	private ArrayList<String> array = new ArrayList<String>(30);
	private ArrayList<String> env = new ArrayList<String>(20);
	private HashMap<String,Item> items;
	private HashMap <Integer,String> fm = new HashMap<Integer,String>();
	private HashMap <Integer,String> em = new HashMap<Integer,String>();
	public static int nbScorpion=0;
	private int nbFood=0;
	private int nbEnvironment;
	private ArrayList<Beast> beasts;
	private ArrayList<Food> foods;
	private ArrayList<String> positions;
	
	
	public GridConstructor() {
		items = new HashMap<String,Item>();
		positions = new ArrayList<String>();
		nbEnvironment=0;
		beasts = new ArrayList<Beast>();
		foods = new ArrayList<Food>();
		showBeast();
		showFood();
		showEnvironment();
		selectFood();
		selectEnvironment();
		Beast.initName();		
	}
	
	/**
	 * Initialisation des images des b�tes dans une ArrayList
	 */
	
	public void showBeast() {
		al.add("src/images/scorpion.png");
		al.add("src/images/blue.png");
		al.add("src/images/brown.png");
		al.add("src/images/burgundy.png");
		al.add("src/images/darkb.png");
		al.add("src/images/gray.png");
		al.add("src/images/green.png");
		al.add("src/images/greenblue.png");
		al.add("src/images/lightb.png");
		al.add("src/images/nude.png");
		al.add("src/images/orange.png");
		al.add("src/images/pastelblue.png");
		al.add("src/images/pi.png");
		al.add("src/images/pink.png");
		al.add("src/images/purple.png");
		al.add("src/images/purplelight.png");
		al.add("src/images/red.png");
		al.add("src/images/salmon.png");
		al.add("src/images/turquoise.png");
		al.add("src/images/yellow.png");
	}
	
	/**
	 * Initialisation des images des environnements dans une ArrayList
	 */
	
	public void showEnvironment() {
		env.add("src/images/desert.png");
		env.add("src/images/mountain.png");
		env.add("src/images/forest.png");
	}
	public void selectEnvironment() {
		em.put(0, "Desert");
		em.put(1, "Mountain");
		em.put(2, "Forest");
	}
	
	/**
	 * Initialisation des images des nourritures dans une ArrayList
	 */
	
	public void showFood() {
		array.add("src/images/spider.png");
		array.add("src/images/mouse.png");
		array.add("src/images/lezard.png");
		array.add("src/images/snake.png");
		array.add("src/images/mosquito.png");
		array.add("src/images/berries.png");
	}
	public void selectFood() {
		fm.put(0, "Spider");
		fm.put(1, "Mouse");
		fm.put(2, "Lizard");
		fm.put(3, "Snake");
		fm.put(4, "Mosquito");
		fm.put(5, "Bay");
	}
	
	/**
	 * Cr�ation des b�tes
	 */
	
	public void initBeasts(int i, int rdm) {
	
		while(nbScorpion< i) {
			Position pos = new Position((int)(Math.random() * rdm),(int)(Math.random() * rdm));
			
			if( !positions.contains(pos.toString()) ) {
				/////A corriger//////
				int rnd = (int) (Math.random() * al.size());
				String imgPath = al.get(rnd);
				al.remove(rnd);
				///////
				beasts.add(new Beast(readImage(imgPath),pos));
				items.put(beasts.get(nbScorpion).getName(),beasts.get(nbScorpion));
				positions.add(pos.toString());
				//System.out.println(beasts.get(nbScorpion));
				nbScorpion++;
			}
			
		}
	}
		
	public HashMap<String,Item> getItems(){
		return this.items;
	}
	
	public ArrayList<Beast> getBeasts(){
		return this.beasts;
	}

	/**
	 * Lit une image � partir d'un fichier image
	 * filePath est le chemin (depuis"src") du fichier image
	 * retourne le fichier image
	 */
	
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}
	
	/**
	 * Cr�ation des nourritures
	 */
									
	public void initFoods(int i, int rdm) {
		while(nbFood<i) {
			Position pos = new Position((int)(Math.random() * rdm),(int)(Math.random() * rdm));
			if( !items.containsKey(pos.toString()) && !positions.contains(pos.toString())) {
				int random = (int) (Math.random() * fm.size());
				String typefood = fm.get(random);
				foods.add(new Food(typefood,readImage(array.get(random)), pos));
				items.put(foods.get(nbFood).getPosition().toString(), foods.get(nbFood));
				nbFood++;
			//	System.out.println(f);
			}
		}
	}
	
	public ArrayList<Food> getFoods(){
		return this.foods;
	}

	/**
	 * Cr�ation des environnements
	 */
	
	public void initEnvironments(int i, int rdm) {
		while(nbEnvironment<i) {
			Position pos = new Position((int)(Math.random() * rdm),(int)(Math.random() * rdm));
			if( !items.containsKey(pos.toString()) && !positions.contains(pos.toString()) ) {
				int rnds = (int) (Math.random() * em.size());
				String type = em.get(rnds);
			//	System.out.println(type);
				Environment	e = new Environment(type,readImage(env.get(rnds)), pos);
				items.put(e.getPosition().toString(), e);
				nbEnvironment++;
			//	System.out.println(e);
			}	
		}	
	}
}




