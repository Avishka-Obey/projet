package Unit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import data.Beast;
import process.Fight;

class FightTest {
	private Beast scorpio1;
	private Beast scorpio2;
	private Beast s;
	private HashMap<Integer, Beast> hm;
	public Beast combat(Beast scorpio1, Beast scorpio2) {
		int n;
		int m;

		hm = new HashMap<Integer, Beast>();
		hm.put(0, scorpio1);
		hm.put(1, scorpio2);

		int rnd = (int) (Math.random() * hm.size());
		s = hm.get(rnd);
		s.getCharacteristic().bonus();
//		System.out.println("for " + s.getName());

		n = ((scorpio1.getCharacteristic().somDefense() / 5)
				+ ((3 * scorpio1.getCharacteristic().somAttaque() + 2 * scorpio1.getCharacteristic().somDefense())
						/ 120)
				+ (scorpio1.getAge() / 2));
		m = ((scorpio2.getCharacteristic().somDefense() / 5)
				+ ((3 * scorpio2.getCharacteristic().somAttaque() + 2 * scorpio2.getCharacteristic().somDefense())
						/ 120)
				+ (scorpio2.getAge() / 2));

//		System.out.println("\nCombat entre : " + scorpio1.getName() + " + " + scorpio2.getName());
//		System.out.println(scorpio1.getName() + " a " + n + " points");
//		System.out.println(scorpio2.getName() + " a " + m + " points");

		if(n<m) {
//			System.out.println(scorpio1.getName() + " est mort");
			for(int i = 0; i<4; i++) {
				scorpio2.getEnergy().decrement();
			}
			return scorpio1;
		}
		else {
//			System.out.println(scorpio2.getName() + " est mort");
			for(int i = 0; i<4; i++) {
				scorpio1.getEnergy().decrement();
			}
			return scorpio2;
		}
	}

	@Test
	void test() {
		Fight f = new Fight();
		
		Beast.initName();
		Beast s = new Beast();
		Beast q = new Beast();
		
		System.out.println(s.toString() + "\n\n");
		System.out.println(q.toString());

		Beast p = f.combat(s, q);
		
		System.out.println("\n\nCombat entre : " + s.getName() + " et " + q.getName());
		System.out.println(p.getName() + " a perdu le combat");
	}

	}


