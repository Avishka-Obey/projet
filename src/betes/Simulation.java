package betes;

import java.util.ArrayList;



public class Simulation {
	private int nbScorpion=0;
	private int nbFood = 0 ;
	private ArrayList<Beast> beasts; 
	private ArrayList<Food> foods;
	
	
	public void update() {
		Position currentposBeast = beasts.get(nbScorpion).getPosition();
		Position currentposFood = foods.get(nbFood).getPosition();
		if(currentposBeast.getPosition().equals(currentposFood.getPosition())) {
			Eating eating = new Eating();
			eating.start();
		}
	}
	
	
	
	public void play() {
		simulation.update();
		if(Simulation.Evoultion) {
			array.remove();
		}
		
	}
}
	