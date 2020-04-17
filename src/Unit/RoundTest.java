package Unit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.Beast;
import gui.GridPanel;
import gui.Interface;
import process.GridConstructor;
import process.Round;

class RoundTest {
	private ArrayList<Beast> beasts;
	private final int PAUSE = 2500;
	public static int actuel = 0;
	private int compteurRound ;
	public static String str;
	public static String atc;
	public static Round round;
	
	public int getCompteurRound() {
		return compteurRound;
	}
	
	public String getStr() {
		return str;
	}
	
	public String getAtc() {
		return atc;
	}
	
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(PAUSE);
				if(!GridPanel.stop && getCompteurRound()>0) {
					this.compteurRound--;
					this.actuel++;
					for(int p = 0; p<beasts.size();p++) {
						beasts.get(p).getEnergy().decrement();//barre d'enrgie decremente tous les 2 tours
						str = "Tours restants : " +this.compteurRound;
						atc = "Tours actuel : " + actuel;
						Interface.tr.setText(str);
						Interface.ta.setText(atc);
						if(actuel%2==0) {
							beasts.get(p).ageIncrement(); //age incremente tous les 2 tours
						}
					}
					
					
				}
			}
			catch(InterruptedException e) {
				
			}
		}
	
	}



	@Test
	void test() {
		GridConstructor grid = new GridConstructor();
		round = new Round(Interface.nbRound,grid.getBeasts());
	}

}
