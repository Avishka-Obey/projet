package betes;

import java.util.HashMap;

public class Fight {
	private int chance;
	private Beast scorpio1;
	private Beast scorpio2;
	private HashMap<Integer, Beast> hm;
	
	public Fight () {
		this.scorpio1 = scorpio1;
		this.scorpio2 = scorpio2;
	}
	
	public void combat(Beast scorpio1, Beast scorpio2) {
		int n;
		int m;
//		scorpio1.bonus();
		n = ((scorpio1.somDefense()/5) + ((3*scorpio1.somAttaque() + 2*scorpio1.somDefense())/120) + (scorpio1.getAge()/2));
		m = ((scorpio2.somDefense()/5) + ((3*scorpio2.somAttaque() + 2*scorpio2.somDefense())/120) + (scorpio2.getAge()/2));
		
		System.out.println("\nCombat entre : " + scorpio1.getName() + " + " + scorpio2.getName());
		System.out.println(scorpio1.getName() + " a " + n);
		System.out.println(scorpio2.getName() + " a " + m);
		if(n<m) {
			System.out.println(scorpio1.getName() + " est mort");
			scorpio1.destroy();
		}
		else {
			System.out.println(scorpio2.getName() + " est mort");
			scorpio2.destroy();
		}
	}
	
	public Beast randomChance() {
//		Beast s;
		hm = new HashMap<Integer, Beast> ();
		hm.put(0, scorpio1);
		hm.put(1, scorpio2);
		
		int rnd = (int) (Math.random() * hm.size());
		return hm.get(rnd);
	}
	
	public static void main(String[] args) {
		Fight f = new Fight();
		
		Beast.initName();
		Beast s = new Beast();
		Beast q = new Beast();
		s.randomName();
		q.randomName();
		System.out.println(s.toString());
		System.out.println(q.toString());
		
		f.combat(s, q);
		
	}
	
	
	
	
}
