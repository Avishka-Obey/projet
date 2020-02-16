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
//		randomChance().bonus();
		n= ((3*scorpio1.somAttaque() + 2*scorpio1.somDefense())/20)+scorpio1.getAge();
		m = ((3*scorpio2.somAttaque() + 2*scorpio2.somDefense())/20)+scorpio2.getAge();
		
		System.out.println("\nCombat entre : " + scorpio1.getName() + " + " + scorpio2.getName());
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
		Beast s;
		hm = new HashMap<Integer, Beast> ();
		hm.put(0, scorpio1);
		hm.put(1, scorpio2);
		
		int rnd = (int) (Math.random() * hm.size());
		return hm.get(rnd);
	}
	
	public static void main(String[] args) {
		Fight f = new Fight();
		
		Beast.initName();
		Beast q = new Beast();
		Beast s = new Beast();
		s.randomName();
		q.randomName();
		System.out.println(s.toString());
		System.out.println(q.toString());
		
		f.combat(s, q);
		
	}
	
	
	
	
}
