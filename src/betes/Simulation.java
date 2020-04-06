package betes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class Simulation {
	private ArrayList<Beast> beasts; 
	public static ArrayList<Food> foods;
	private HashMap<String,Item> items;
	

	public Simulation(HashMap<String,Item> items ) {
		this.items = items;
	}
	
	public void update() {
		beasts = new ArrayList<Beast>();
		foods = new ArrayList<Food>();
		
		for(Iterator<Item> it = items.values().iterator();it.hasNext(); ) {
			Item i = it.next();
			if(i.getStringType().equals("beast")) {
				beasts.add((Beast)i);
			}
			else if (i.getStringType().equals("food")) {
				foods.add((Food)i);
			}
		}
		
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
				 if(currentposBeast2.equals(currentposBeast1)&&p!=q) {
					Fight f = new Fight();
					Beast perdante =f.combat(beasts.get(p), beasts.get(q));
					items.remove(perdante.getPosition().toString());	
					
				}
				
			}
		}
		
		
		}
	
	
	/*@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				if(!stop) {
					
					for(int j=0;j<GridConstructor.nbScorpion;j++) {
						int i =(int)(Math.random()*4+1);
						Move.move(grid.getBeasts().get(j), i, rdm);
						
						for(int p = 0; p<grid.getFoods().size(); p++) {
//							if(grid.getBeasts().get(j).getPosition() == grid.getFoods().get(p).getPosition()) {
							Position currentposBeast = grid.getBeasts().get(j).getPosition();
							Position currentposFood = grid.getFoods().get(p).getPosition();
							if(currentposBeast.equals(currentposFood)) {
								Eating eat = new Eating();
								eat.evolution(grid.getBeasts().get(j), grid.getFoods().get(p));
								grid.getFoods().remove(p);
								System.out.println(grid.getBeasts().get(j));
							}
						}
						
					}
					this.repaint() ;
					Thread.sleep(500);
				}
				
			}
			catch(InterruptedException e) {
				System.out.println("erreur");
			}
//			Thread.currentThread().interrupt();
		}	
		
		
	}
	
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				if(!stop) {
					
					for(int j=0;j<GridConstructor.nbScorpion;j++) {
						int i =(int)(Math.random()*4+1);
						Move.move(grid.getBeasts().get(j), i, rdm);
						
						for(int p = 0; p<grid.getFoods().size(); p++) {
//							if(grid.getBeasts().get(j).getPosition() == grid.getFoods().get(p).getPosition()) {
							Position currentposBeast = grid.getBeasts().get(j).getPosition();
							Position currentposFood = grid.getFoods().get(p).getPosition();
							if(currentposBeast.equals(currentposFood)) {
								Simulation sim = new Simulation();
								sim.evolution(grid.getBeasts().get(j), grid.getFoods().get(p));
								grid.getFoods().remove(p);
								System.out.println(grid.getBeasts().get(j));
							}
						}
						
					}
					this.repaint() ;
					Thread.sleep(500);
				}
				
			}
			catch(InterruptedException e) {
				System.out.println("erreur");
			}
//			Thread.currentThread().interrupt();
		}	
		
		
	}
	
	*/
	
	
		
	}

	