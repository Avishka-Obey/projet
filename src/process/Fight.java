package process;

/**
 * Cette classe represente le combat entre 2 scorpions
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import data.*;
import java.util.HashMap;

public class Fight {
	private Beast scorpio1;
	private Beast scorpio2;
	private Beast s;
	private HashMap<Integer, Beast> hm;
	
	public Fight () {
		this.scorpio1 = scorpio1;
		this.scorpio2 = scorpio2;
	}
	
	/**
	 * Cette méthode permet de faire une comparaison des attaques et des défenses deux deux bêtes afin qu'il puisse y avoir 
	 * un vainqueur et un vaincu
	 */
	
	public Beast combat(Beast scorpio1, Beast scorpio2) {
		int n;
		int m;


		hm = new HashMap<Integer, Beast> ();
		hm.put(0, scorpio1);
		hm.put(1, scorpio2);
		
		int rnd = (int) (Math.random() * hm.size());
		s = hm.get(rnd);
		s.getCharacteristic().bonus();
		System.out.println("for " + s.getName());
		
		
		n = ((scorpio1.getCharacteristic().somDefense()/5) + ((3*scorpio1.getCharacteristic().somAttaque() + 2*scorpio1.getCharacteristic().somDefense())/120) + (scorpio1.getAge()/2));
		m = ((scorpio2.getCharacteristic().somDefense()/5) + ((3*scorpio2.getCharacteristic().somAttaque() + 2*scorpio2.getCharacteristic().somDefense())/120) + (scorpio2.getAge()/2));
		
		System.out.println("\nCombat entre : " + scorpio1.getName() + " + " + scorpio2.getName());
		System.out.println(scorpio1.getName() + " a " + n + " points");
		System.out.println(scorpio2.getName() + " a " + m + " points");
		
		if(n<m) {
			System.out.println(scorpio1.getName() + " est mort");
			scorpio2.getEnergy().decrement();
			scorpio2.getEnergy().decrement();
			scorpio2.getEnergy().decrement();
			scorpio2.getEnergy().decrement();
			return scorpio1;
		}
		else {
			System.out.println(scorpio2.getName() + " est mort");
			scorpio1.getEnergy().decrement();
			scorpio1.getEnergy().decrement();
			scorpio1.getEnergy().decrement();
			scorpio1.getEnergy().decrement();
			return scorpio2;
		}
	}
	
	/**
	 * Ce main est présent afin de tester dans la console que le combat a bien lieu et que le bonus est bien distribué
	 */
	
	public static void main(String[] args) {
		Fight f = new Fight();
		
		Beast.initName();
		Beast s = new Beast();
		Beast q = new Beast();
		System.out.println(s.toString());
		System.out.println(q.toString());

		f.combat(s, q);
	}
	
	
	
	
}
