package process;


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
	public static ArrayList<Position> marriedPos;
	public static ArrayList<Position> fightPos;
	private HashMap<String,Item> items;
	public static boolean isMarried ;
	public static boolean isFighting;
	public static HashMap<String,String> mort = new HashMap<String,String>();
	private String str;
	private String eat;
	

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
							mort.put(beasts.get(i).getName(), str + beasts.get(i).getName() + " a manger un(e) "  + eat + " au tour n�" + Round.actuel + "\n\n");
						}
						
						else {
							mort.put(beasts.get(i).getName(), beasts.get(i).toString() + "\n\n" + beasts.get(i).getName() + " a manger un(e) "  + eat + " au tour n�" + Round.actuel + "\n\n");
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
							mort.put(beasts.get(p).getName(), str + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont battu au tour n�" + Round.actuel + " et " + perdante.getName() + " a perdu\n\n");
						}
						else {
							mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\n" + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont battu au tour n�" + Round.actuel + " et " + perdante.getName() + " a perdu\n\n");
						}
					
						if(mort.containsKey(beasts.get(q).getName())) {
							str = mort.get(beasts.get(q).getName());
							mort.put(beasts.get(q).getName(), str + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont battu au tour n�" + Round.actuel + " et " + perdante.getName() + " a perdu\n\n");
						}
						else {
							mort.put(beasts.get(q).getName(), beasts.get(q).toString() + "\n\n" + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont battu au tour n�" + Round.actuel + " et " + perdante.getName() + " a perdu\n\n");
						}
						beasts.remove(perdante);
						Interface.numberDead++;
						GridConstructor.nbScorpion--;
						Interface.numberAlive--;
						fightPos.add(currentposBeast2);
						isFighting = true;
						Interface.bv.setText("Nombre de b�tes vivante : " + Interface.numberAlive);
						Interface.bm.setText("Nombre de b�tes morte : " + Interface.numberDead);
						
						
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
						Beast naissance  = beasts.get(p).reproduce(beasts.get(q)); 
						beasts.add(naissance);
						items.put(naissance.getName(), naissance);
						GridConstructor.nbScorpion++;
						
						if(mort.containsKey(beasts.get(p).getName())) {
							str = mort.get(beasts.get(p).getName());
							mort.put(beasts.get(p).getName(), str + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont mari�s au tour n�" + Round.actuel + " et " + naissance.getName() + " est n�(e)\n\n");
						}
						else {
							mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\n" + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont mari�s au tour n�" + Round.actuel + " et " + naissance.getName() + " est n�(e)\n\n");
						}
						
						if(mort.containsKey(beasts.get(q).getName())) {
							str = mort.get(beasts.get(q).getName());
							mort.put(beasts.get(q).getName(), str + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont mari�s au tour n�" + Round.actuel + " et " + naissance.getName() + " est n�(e) de leurs union\n\n");
						}
						else {
							mort.put(beasts.get(q).getName(), beasts.get(q).toString() + "\n\n" + beasts.get(p).getName() + " et " + beasts.get(q).getName() + " se sont mari�s au tour n�" + Round.actuel + " et " + naissance.getName() + " est n�(e) de leur union\n\n");
						}
						
						
						System.out.println(naissance);
						System.out.println("nouveau n� "+naissance.getName());
						mort.put(naissance.getName(), naissance.toString() + "\n\n" + naissance.getName() +  " est n�e au tour n�" + Round.actuel + "\nEnfant de " + beasts.get(q).getName() + " et " + beasts.get(p).getName() + "\n\n");
						Interface.numberAlive++;
						marriedPos.add(currentposBeast2);
						isMarried = true ;
						Interface.bv.setText("Nombre de b�tes vivante : " + Interface.numberAlive);
					}
				 }
			}
		}
		
		
		for(int p = 0; p<beasts.size();p++) {
			 if(beasts.get(p).getAge()==8 || beasts.get(p).getEnergy().getEnergy()<=0) {
//				System.out.println(beasts.get(p));
				items.remove(beasts.get(p).getName());
				Interface.js.addItem(new String(beasts.get(p).getName()));
				
				if(beasts.get(p).getAge()==8) {
					if(mort.containsKey(beasts.get(p).getName())) {
						str = mort.get(beasts.get(p).getName());
						mort.put(beasts.get(p).getName(), str + beasts.get(p).getName() + " est mort de vieillesse au tour n�" + Round.actuel);
					}
					else {
						mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\n" + beasts.get(p).getName() + " est mort de vieillesse au tour n�" + Round.actuel);
					}
				}
				
				else {
					if(mort.containsKey(beasts.get(p).getName())) {
						str = mort.get(beasts.get(p).getName());
						mort.put(beasts.get(p).getName(), str + beasts.get(p).getName() + " est mort par manque d'�nergie au tour n�" + Round.actuel);
					}
					else {
						mort.put(beasts.get(p).getName(), beasts.get(p).toString() + "\n\n" + beasts.get(p).getName() + " est mort par manque d'�nergie au tour n�" + Round.actuel);
					}
				}
				beasts.remove(beasts.get(p));
				GridConstructor.nbScorpion--;
				Interface.numberDead++;
				Interface.numberAlive--;
				Interface.bv.setText("Nombre de b�tes vivante : " + Interface.numberAlive);
				Interface.bm.setText("Nombre de b�tes morte : " + Interface.numberDead);
				
				 
			 }
			 

		}
	}
}