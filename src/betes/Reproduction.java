package betes;

public class Reproduction {

	private Beast scorpio1;
	private Beast scorpio2;
	private Beast scorpio3;
	private Wedding w;
	
	public Reproduction(Beast scorpio1, Beast scorpio2) {
		this.scorpio1 = scorpio1;
		this.scorpio2 = scorpio2;
		this.w = new Wedding();
	}
	
	public void reproduce() {
		if(w.mariage(scorpio1, scorpio2)) {
			Beast scorpio3 = new Beast();
		}
	}
}
