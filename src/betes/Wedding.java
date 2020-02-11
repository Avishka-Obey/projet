package betes;

import java.util.HashMap;

public class Wedding {

	private Beast scorpio1;
	private Beast scorpio2;
	private HashMap <String,String> hm;
	
	public Wedding(Beast scorpio1, Beast scorpio2) {
		hm = new HashMap<String, String> ();
		this.scorpio1 = scorpio1;
		this.scorpio2 = scorpio2;
	}
	
	public void mariage(Beast scorpio1, Beast scorpio2) {
		if(!alreadymaried(scorpio1, scorpio2)) {
			if((scorpio1.randomGender().equals("male") && scorpio2.randomGender().equals("female")) || (scorpio1.randomGender().equals("female") && scorpio2.randomGender().equals("male"))) {
				hm.put(scorpio1.getColor(), scorpio2.getColor());
			}
		}
	}
	
	public boolean alreadymaried(Beast scorpio1, Beast scorpio2) {
		if(hm.isEmpty()) {
			return false;
		}
		else {
			if(hm.containsKey(scorpio1.getColor()) || hm.containsKey(scorpio2.getColor())) {
				return true;
			}
			
			else {
				return false;
			}
		}
	}
	
	
}
