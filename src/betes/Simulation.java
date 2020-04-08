package betes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class Simulation {
	private ArrayList<Beast> beasts; 
	public static ArrayList<Food> foods;
	private HashMap<String,Item> items;
	

	public Simulation(HashMap<String,Item> items,ArrayList<Beast>beasts, ArrayList<Food> foods) {
		this.items = items;
		this.beasts=beasts;
		this.foods = foods;
	}
	
	public void update() {
		
		
//		for(Iterator<Item> it = items.values().iterator();it.hasNext(); ) {
//			Item i = it.next();
//			if(i.getStringType().equals("beast")) {
//				beasts.add((Beast)i);
//			}
//			else if (i.getStringType().equals("food")) {
//				foods.add((Food)i);
//			}
//		}
		
		for(int i = 0; i<beasts.size();i++) {
			Position currentposBeast = beasts.get(i).getPosition();
			for(int j =0;j<foods.size();j++) {
				Position currentposFood = foods.get(j).getPosition();
				if(currentposFood.equals(currentposBeast)) {
					Eating.evolution(beasts.get(i),foods.get(j));
//					System.out.println(beasts.get(i));
					items.remove(foods.get(j).getPosition().toString());
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
					Fight f = new Fight();
					Beast perdante =f.combat(beasts.get(p), beasts.get(q));
					items.remove(perdante.getInitPosition().toString());	
					beasts.remove(perdante);
					Interface.numberDead++;
					GridConstructor.nbScorpion--;
					Interface.numberAlive--;
					Interface.bv.setText("Nombre de bêtes vivante : " + Interface.numberAlive);
					Interface.bm.setText("Nombre de bêtes morte : " + Interface.numberDead);
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
			 
//			 else if(beasts.get(p).getEnergy().getEnergy()<=0) {
////				 System.out.println(beasts.get(p));
//				 items.remove(beasts.get(p).getInitPosition().toString());	
//				 beasts.remove(p);
//				 Interface.numberDead++;
//				 Interface.numberAlive--;
//				 Interface.bv.setText("Nombre de bêtes vivante : " + Interface.numberAlive);
//				 Interface.bm.setText("Nombre de bêtes morte : " + Interface.numberDead);
//				 
//			 }
		}
//		for(int p = 0; p<beasts.size();p++) {
//			if(Round.actuel>1 ) {
//				beasts.get(p).getEnergy().decrement(); 	
//				
//				System.out.println(beasts.get(p));
//			}
//			
//			if(Round.actuel%16 == 0) {
//				beasts.get(p).ageIncrement(); 	
//			}
//		
//		}
//		
	}
}
	
	

	

	