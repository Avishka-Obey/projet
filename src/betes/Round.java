package betes;

import java.util.ArrayList;
import java.util.HashMap;

public class Round implements Runnable {

	private ArrayList<Beast> beasts; 
	//VARIABLES
	private final int PAUSE = 2500;
	public  int actuel = 0;
	private int compteurRound ;
	public static String str;
	public static String atc;
	
	public Round(int i,ArrayList<Beast> beasts){
		this.compteurRound =i;
		this.beasts = beasts;
		this.str = "Tours restants : " + i;
		this.atc = "Tours actuel : " + actuel;
		Interface.tr.setText(str);
		Interface.ta.setText(atc);
		Thread compteurRound = new Thread(this);
		compteurRound.start();
		
	}
	
	public int getCompteurRound() {
		return compteurRound;
	}
	
	public String getStr() {
		return str;
	}
	
	public String getAtc() {
		return atc;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(PAUSE);
				if(!GridPanel.stop && getCompteurRound()>0) {
					this.compteurRound --;
					this.actuel++;
					for(int p = 0; p<beasts.size();p++) {
						beasts.get(p).getEnergy().decrement();
						str = "Tours restants : " +this.compteurRound;
						atc = "Tours actuel : " + actuel;
						Interface.tr.setText(str);
						Interface.ta.setText(atc);
						if(actuel%2==0) {
							beasts.get(p).ageIncrement(); 
						}
					}
					
					
				}
			}
			catch(InterruptedException e) {
				
			}
		}
	
	}
}
