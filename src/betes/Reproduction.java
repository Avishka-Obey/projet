package betes;

public class Reproduction {
	private Beast scorpio1;
	private Beast scorpio2;
	private Beast scorpio3;
	private Wedding w;
	private Reproduction r;
	
	public Reproduction(Beast scorpio1, Beast scorpio2) {
		this.scorpio1 = scorpio1;
		this.scorpio2 = scorpio2;
		this.r= new Reproduction(scorpio1, scorpio2);
	}
	
	public Beast reproduce() {
		if(w.mariage(scorpio1, scorpio2)) {
			Beast scorpio3 = new Beast();
			
		}
		return scorpio3;
	}
	public String toString() {
		String texte="";
		texte="scorpio1:"+ scorpio1.getName() + "scorpio2:"+ scorpio2.getName() + "donne naissance au Scorpio3"+scorpio3.getName();
		return texte;
	}

	

	public static void main(String[]args) {
		Beast scorpio1 = new Beast();
		Beast scorpio2= new Beast();
		Beast scorpio3 = new Beast();
		Beast.initName();
		 scorpio1.randomName();
		 scorpio2.randomName();
		 scorpio3.randomName();
		 Wedding w = new Wedding();
		 if(w.mariage(scorpio1, scorpio2)) {
			 Reproduction r = new Reproduction(scorpio1, scorpio2) ;
			 r.toString() ;
			 
		 }
		 else if((w.mariage(scorpio2, scorpio1))){
			 Reproduction r = new Reproduction(scorpio2, scorpio1) ;
			 r.toString() ;
			 
		 }
		 else {
			 System.out.println("Impossible pour " + scorpio1.getName() + " et " + scorpio2.getName() + " de se marier donc pas de mariage") ;
		 }
	}
}