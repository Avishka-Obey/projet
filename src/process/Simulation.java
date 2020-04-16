package process;

/**
 * Cette classe represente la simulation de l'interface
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import data.*;
import gui.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.imageio.ImageIO;

public class Simulation {
	public static ArrayList<Beast> beasts; 
	public static ArrayList<Food> foods;
	public static ArrayList<Environment> environments;
	public static ArrayList<Position> marriedPos;
	public static ArrayList<Position> fightPos;
	private HashMap<String,Item> items;
	public static boolean isMarried ;
	public static boolean isFighting;
	public static HashMap<String,String> mort = new HashMap<String,String>();
	private String str;
	private String eat;
	

	public Simulation(HashMap<String,Item> items,ArrayList<Beast>beasts, ArrayList<Food> foods, ArrayList<Environment> environments) {
		this.items = items;
		this.beasts=beasts;
		this.environments=environments;
		this.foods = foods;
		Simulation.marriedPos = new ArrayList<Position>();
		Simulation.fightPos = new ArrayList<Position>();
		this.isMarried = false ;
		this.isFighting = false;
	}
	
	public void update() {
		
		//Une fois que la bête a manger suppression de la nourriture
		for(int i = 0; i<beasts.size();i++) {
			try {
				Position currentposBeast = beasts.get(i).getPosition();
				for(int j =0;j<foods.size();j++) {
					Position currentposFood = foods.get(j).getPosition();
					if(currentposFood.equals(currentposBeast)) {
						eat = Eating.evolution(beasts.get(i),foods.get(j));
						items.remove(foods.get(j).getPosition().toString());
						foods.remove(j); 
						if(mort.containsKey(beasts.get(i).getName())) {
							str = mort.get(beasts.get(i).getName());
							mort.put(beasts.get(i).getName(), str + "J'ai manger un(e) "  + eat + " au tour n°" + Round.actuel + "\n\n");
						}
						
						else {
							mort.put(beasts.get(i).getName(), beasts.get(i).toString() + "\n\nBonjour je m'appelle " + beasts.get(i).getName() + "!\n\n" + "J'ai manger un(e) "  + eat + " au tour n°" + Round.actuel + "\n\n");
						}
						
						Interface.nbfood--;
						Interface.nsub.setText("Nombre de subsistances : " + Interface.nbfood);
					}
				}
			}
			catch (Exception e) {
			      e.printStackTrace();
			}
		}
		
		
		for(int i = 0; i<beasts.size();i++) {
			try {
				Position currentposBeast = beasts.get(i).getPosition();
				for(int j =0;j<environments.size();j++) {
					Position currentposFood = environments.get(j).getPosition();
					if(currentposFood.equals(currentposBeast)) {
						if(beasts.get(i).getEnvironment().equals(environments.get(j).getType())) {
							beasts.get(i).getCharacteristic().bonus();
						}
					}
				}
			}
			catch (Exception e) {
			      e.printStackTrace();
			}
		}
		
		//Suppresion de la bete perdante du combat
		
		for(int p = 0; p<beasts.size();p++) {
			Position currentposBeast1 = beasts.get(p).getPosition();
			for(int q = 0; q<beasts.size(); q++) {
				Position currentposBeast2 = beasts.get(q).getPosition();
				 if(currentposBeast2.equals(currentposBeast1)&& beasts.get(q)!=beasts.get(p)) {
					 if(beasts.get(p).getGender().equals(beasts.get(q).getGender())) {
						Fight f = new Fight();
						Beast perdante =f.combat(beasts.get(p), beasts.get(q));
						items.remove(perdante.getName());
						Interface.js.addItem(new String(perdante.getName()));
						
						if(mort.containsKey(beasts.get(p).getName())) {
							str = mort.get(beasts.get(p).getName());
							mort.put(beasts.get(p).getName(), str + beasts.get(q).getName() + " et moi nous sommes battu au tour n°" + Round.actuel + " et le perdant du combat est " + perdante.getName() + "\n\n");
						}
						else {
							mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\nBonjour je m'appelle " + beasts.get(p).getName() + " !\n\n" + beasts.get(q).getName() + " et moi nous sommes battu au tour n°" + Round.actuel + " et le perdant du combat est " + perdante.getName() + "\n\n");
						}
					
						if(mort.containsKey(beasts.get(q).getName())) {
							str = mort.get(beasts.get(q).getName());
							mort.put(beasts.get(q).getName(), str + beasts.get(p).getName() + " et moi nous sommes battu au tour n°" + Round.actuel + " et le perdant du combat est " + perdante.getName() + "\n\n");
						}
						else {
							mort.put(beasts.get(q).getName(), beasts.get(q).toString() + "\n\nBonjour je m'appelle " + beasts.get(q).getName() + " !\n\n" + beasts.get(p).getName() + " et moi nous sommes battu au tour n°" + Round.actuel + " et le perdant du combat est " + perdante.getName() + " \n\n");
						}
						beasts.remove(perdante);
						Interface.numberDead++;
						GridConstructor.nbScorpion--;
						Interface.numberAlive--;
						fightPos.add(currentposBeast2);
						isFighting = true;
						Interface.bv.setText("Nombre de bêtes vivante : " + Interface.numberAlive);
						Interface.bm.setText("Nombre de bêtes morte : " + Interface.numberDead);
						
						
					 	}
					 
				 } 
		
			}
		}
		//Après le mariage vient la reproduction
		for(int p = 0; p<beasts.size();p++) {
			Position currentposBeast1 = beasts.get(p).getPosition();
			for(int q = 0; q<beasts.size(); q++) {
				Position currentposBeast2 = beasts.get(q).getPosition();
				 if(currentposBeast2.equals(currentposBeast1)&& beasts.get(q)!=beasts.get(p)) {
					if(Wedding.mariage(beasts.get(p),beasts.get(q))) {
						Beast naissance  = beasts.get(p).reproduce(beasts.get(q)); 
						beasts.add(naissance);
						items.put(naissance.getName(), naissance);
						GridConstructor.nbScorpion++;
						
						if(mort.containsKey(beasts.get(p).getName())) {
							str = mort.get(beasts.get(p).getName());
							mort.put(beasts.get(p).getName(), str + beasts.get(q).getName() + " et moi nous sommes mariés au tour n°" + Round.actuel + " et " + naissance.getName() + " est né(e) de notre union\n\n");
						}
						else {
							mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\n" + "Bonjour je m'appelle " + beasts.get(p).getName() + " ! " + "\n\n" + beasts.get(q).getName() + " et moi nous sommes mariés au tour n°" + Round.actuel + " et " + naissance.getName() + " est né(e) de notre union\n\n");
						}
						
						if(mort.containsKey(beasts.get(q).getName())) {
							str = mort.get(beasts.get(q).getName());
							mort.put(beasts.get(q).getName(), str + beasts.get(p).getName() + " et moi nous sommes mariés au tour n°" + Round.actuel + " et " + naissance.getName() + " est né(e) de notre union\n\n");
						}
						else {
							mort.put(beasts.get(q).getName(), beasts.get(q).toString() + "\n\n" + "Bonjour je m'appelle " + beasts.get(q).getName() + " ! " + "\n\n" + beasts.get(p).getName() + " et moi nous sommes mariés au tour n°" + Round.actuel + " et " + naissance.getName() + " est né(e) de notre union\n\n");
						}
						
						
//						System.out.println(naissance);
//						System.out.println("nouveau né "+naissance.getName());
						mort.put(naissance.getName(), naissance.toString() + "\n\nBonjour ! Je m'appelle " + naissance.getName() +  " et je suis né(e) au tour n°" + Round.actuel + "\nJe suis l'enfant de " + beasts.get(q).getName() + " et " + beasts.get(p).getName() + "\n\n");
						Interface.numberAlive++;
						marriedPos.add(currentposBeast2);
						isMarried = true ;
						Interface.bv.setText("Nombre de bêtes vivante : " + Interface.numberAlive);
					}
				 }
			}
		}
		//Mort de la bête si l'âge est egale à 8 ou si son énergie est inférieur ou égale à 0
		for(int p = 0; p<beasts.size();p++) {
			 if(beasts.get(p).getAge()==8 || beasts.get(p).getEnergy().getEnergy()<=0) {
//				System.out.println(beasts.get(p));
				items.remove(beasts.get(p).getName());
				Interface.js.addItem(new String(beasts.get(p).getName()));
				
				if(beasts.get(p).getAge()==8) {
					if(mort.containsKey(beasts.get(p).getName())) {
						str = mort.get(beasts.get(p).getName());
						mort.put(beasts.get(p).getName(), str + "Je suis mort de vieillesse au tour n°" + Round.actuel);
					}
					else {
						mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\nBonjour je m'appelle " + beasts.get(p).getName() + " !\n\nJe suis mort de vieillesse au tour n°" + Round.actuel);
					}
				}
				
				else {
					if(mort.containsKey(beasts.get(p).getName())) {
						str = mort.get(beasts.get(p).getName());
						mort.put(beasts.get(p).getName(), str + "Je suis mort par manque d'énergie au tour n°" + Round.actuel);
					}
					else {
						mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\nJe m'appelle " + beasts.get(p).getName() + " !\n\n" + "Je suis mort par manque d'énergie au tour n°" + Round.actuel);
					}
				}
				beasts.remove(beasts.get(p));
				GridConstructor.nbScorpion--;
				Interface.numberDead++;
				Interface.numberAlive--;
				Interface.bv.setText("Nombre de bêtes vivante : " + Interface.numberAlive);
				Interface.bm.setText("Nombre de bêtes morte : " + Interface.numberDead);				
			 }
		}
	}
	
}