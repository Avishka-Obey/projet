package betes;

import java.util.HashMap;

public class Wedding {

	private Beast scorpio1;
	private Beast scorpio2;
	private static HashMap <String,String> hm;
	
	public Wedding(Beast scorpio1, Beast scorpio2) {
		hm = new HashMap<String,String> ();
		this.scorpio1 = scorpio1;
		this.scorpio2 = scorpio2;
	}
	
	public boolean alreadymaried(Beast scorpio1, Beast scorpio2) {
		if(hm.isEmpty()) {
			return false;
		}
		else {
			if(hm.containsKey(scorpio1.getName()) || hm.containsKey(scorpio2.getName())) {
				return true;
			}
			
			else {
				return false;
			}
		}
	}
	
	
	public boolean mariage(Beast scorpio1, Beast scorpio2) {
		if(alreadymaried(scorpio1, scorpio2)) {
			if((scorpio1.randomGender().equals("male") && scorpio2.randomGender().equals("female")) || (scorpio1.randomGender().equals("female") && scorpio2.randomGender().equals("male"))) {
				hm.put(scorpio1.getName(), scorpio2.getName());
				return true;
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	
	public static void nettoyer()  {
		hm.clear();
	}
	
	public static void main(String [] args) {
		
		Beast s = new Beast();
		Beast q = new Beast();
		Beast r = new Beast();
		
		Beast.initName();
		
		s.randomName();
		q.randomName();
		r.randomName();
		
		
		Wedding w = new Wedding(s, q);
		Wedding x = new Wedding(q, r);

		System.out.println(s.toString());
		System.out.println(q.toString());
		System.out.println(r.toString());
		
		if(w.mariage(s, q)) {
			System.out.println(s.getName() + " et " + q.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + s.getName() + " et " + q.getName() + " de se marier");
		}
		
		
		if(x.mariage(q, r)) {
			System.out.println(q.getName() + " et " + r.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + q.getName() + " et " + r.getName() + " de se marier");
		}
		
		Wedding.nettoyer();
	}
	
	
	
	
}
