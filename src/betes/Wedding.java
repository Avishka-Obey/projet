package betes;

import java.util.HashMap;

public class Wedding {


	private static HashMap <String,String> hm;
	
	
	public Wedding() {
		hm = new HashMap<String,String> ();
		
	}
	
	public boolean alreadymaried(Beast scorpio1, Beast scorpio2) {
		if(hm.containsKey(scorpio1.getName())&& hm.containsKey(scorpio2.getName())) {
			hm.put(scorpio1.getName(), scorpio2.getName());
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	
	public boolean mariage(Beast scorpio1, Beast scorpio2) {
		if(!alreadymaried(scorpio1, scorpio2)) {
			if(( (scorpio1.getGender().equals("male") && scorpio2.getGender().equals("female")  ) || ((scorpio1.getGender().equals("female") && scorpio2.getGender().equals("male"))))) {
				hm.put(scorpio1.getName(), scorpio2.getName());
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
//	public static void nettoyer()  {
//		hm.clear();
//	}
	
	public static void main(String [] args) {
		
		Beast s = new Beast();
		Beast q = new Beast();
		Beast r = new Beast();
		Beast t = new Beast();
		Beast.initName();
		
		s.randomName();
		q.randomName();
		r.randomName();
		t.randomName();
		
		
		Wedding w = new Wedding();

		System.out.println(s.toString());
		System.out.println(q.toString());
		System.out.println(r.toString());
		System.out.println(t.toString());
		
		if(w.mariage(s, q)) {
			System.out.println(s.getName() + " et " + q.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + s.getName() + " et " + q.getName() + " de se marier");
		}
		
		
		if(w.mariage(q, r)) {
			System.out.println(q.getName() + " et " + r.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + q.getName() + " et " + r.getName() + " de se marier");
		}
		
		if(w.mariage(t, r)) {
			System.out.println(t.getName() + " et " + r.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + t.getName() + " et " + r.getName() + " de se marier");
		}
		
		
		
//		Wedding.nettoyer();
	}
	
	
	
	
}
