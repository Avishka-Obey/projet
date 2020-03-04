package betes;

public class Start {
	private Beast b ;
	private Eating e ;
	private Fight f ;
	private Wedding w ;
	private Move m ;
	private int nbroundMax;
	
	public Start(int nbroundMax, Beast b ,Eating e, Fight f, Wedding w , Move m ){
		this.nbroundMax = nbroundMax;
		this.b = new Beast();
		this.e = new Eating();
		this.f = new Fight();
		this.w = new Wedding();
		this.m = new Move();
		
		
	}
	public void launch() {
		b = new Beast();
		e = new Eating();
		f = new Fight();
		w = new Wedding();
		m = new Move();
		for (int i =0 ; i<nbroundMax ; i++) {
		
			
			
			
			
		}
	}
	
}
