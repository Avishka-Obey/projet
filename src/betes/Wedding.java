package betes;

public class Wedding {

	private Beast scorpio1;
	private Beast scorpio2;
	
	public Wedding(Beast scorpio1, Beast scorpio2) {
		this.scorpio1 = scorpio1;
		this.scorpio2 = scorpio2;
	}
	
	public boolean mariage() {
		if((scorpio1.getGender().equals("male") && scorpio2.getGender().equals("female")) || (scorpio1.getGender().equals("female") && scorpio2.getGender().equals("male"))) {
			return true;
		}
		return false;
	}
}
