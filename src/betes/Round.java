package betes;

public class Round implements Runnable {

	//VARIABLES
		private final int PAUSE =1000;
		private int compteurRound ;
		private String str;
		
		
		public Round(){
			this.compteurRound =50;
			this.str = "Temps restant :50";
			Thread compteurRound = new Thread(this);
			compteurRound.start();
			
		}
		public int getCompteurRound() {
			return compteurRound;
		}
		public String getStr() {
			return str;
		}
		@Override
		public void run() {
			while(true) {
				try {
				Thread.sleep(PAUSE);
			}
				catch(InterruptedException e) {
					
				}
				this.compteurRound --;
				this.str = "Temps restant :" +this.compteurRound;
			
		}
		}
	
	
	
}
