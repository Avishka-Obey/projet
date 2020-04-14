package betes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.imageio.ImageIO;




public class Simulation {
	private ArrayList<Beast> beasts; 
	public static ArrayList<Food> foods;
	public static ArrayList<Position> marriedPos;
	public static ArrayList<Position> fightPos;
	private HashMap<String,Item> items;
	public static boolean isMarried ;
	public static boolean isFighting;
	

	public Simulation(HashMap<String,Item> items,ArrayList<Beast>beasts, ArrayList<Food> foods) {
		this.items = items;
		this.beasts=beasts;
		this.foods = foods;
		Simulation.marriedPos = new ArrayList<Position>();
		Simulation.fightPos = new ArrayList<Position>();
		this.isMarried = false ;
		this.isFighting = false;
	}
	
	public void update() {
		
		for(int i = 0; i<beasts.size();i++) {
			Position currentposBeast = beasts.get(i).getPosition();
			for(int j =0;j<foods.size();j++) {
				Position currentposFood = foods.get(j).getPosition();
				if(currentposFood.equals(currentposBeast)) {
					Eating.evolution(beasts.get(i),foods.get(j));
//					System.out.println(beasts.get(i));
					items.remove(foods.get(j).getPosition().toString());
					foods.remove(foods.get(j));
					Interface.nbfood--;
					Interface.nsub.setText("Nombre de subsistances : " + Interface.nbfood);
//					System.out.println(Eating.evolution(beasts.get(i),foods.get(j);
				}
			}
		}
		
		
		for(int p = 0; p<beasts.size();p++) {
			Position currentposBeast1 = beasts.get(p).getPosition();
			for(int q = 0; q<beasts.size(); q++) {
				Position currentposBeast2 = beasts.get(q).getPosition();
				 if(currentposBeast2.equals(currentposBeast1)&& beasts.get(q)!=beasts.get(p)) {
					 if(beasts.get(p).getGender().equals(beasts.get(q).getGender())) {
						Fight f = new Fight();
						Beast perdante =f.combat(beasts.get(p), beasts.get(q));
						items.remove(perdante.getInitPosition().toString());	
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
		
		for(int p = 0; p<beasts.size();p++) {
			Position currentposBeast1 = beasts.get(p).getPosition();
			for(int q = 0; q<beasts.size(); q++) {
				Position currentposBeast2 = beasts.get(q).getPosition();
				 if(currentposBeast2.equals(currentposBeast1)&& beasts.get(q)!=beasts.get(p)) {
					if(Wedding.mariage(beasts.get(p),beasts.get(q))) {
						Beast naissance = beasts.get(p).reproduce(beasts.get(q));
						beasts.add(naissance);
						items.put(naissance.getInitPosition().toString(), naissance);
						GridConstructor.nbScorpion++;
						System.out.println(naissance);
						System.out.println("nouveau né "+naissance.getName());
						Interface.numberAlive++;
						marriedPos.add(currentposBeast2);
						isMarried = true ;
						Interface.bv.setText("Nombre de bêtes vivante : " + Interface.numberAlive);
						
						
					}
				 }
			}
		}
		
		
		for(int p = 0; p<beasts.size();p++) {
			 if(beasts.get(p).getAge()==8 || beasts.get(p).getEnergy().getEnergy()<=0) {
//				 System.out.println(beasts.get(p));
				 items.remove(beasts.get(p).getInitPosition().toString());	
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
	
	

	

	