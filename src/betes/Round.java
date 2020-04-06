package betes;

public class Round implements Runnable {

	//VARIABLES
	private final int PAUSE =2500;
	private int actuel = 0;
	private int compteurRound ;
	public static String str;
	public static String atc;
	
	public Round(int i){
		this.compteurRound =i;
		this.str = "Tours restants : " + i;
		this.atc = "Tours actuel : " + actuel;
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
					str = "Tours restants : " +this.compteurRound;
					atc = "Tours actuel : " + actuel;
					Interface.tr.setText(str);
					Interface.ta.setText(atc);
				}
			}
			catch(InterruptedException e) {
				
			}
		}
	}
}
