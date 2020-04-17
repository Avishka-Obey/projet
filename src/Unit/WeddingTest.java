package Unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Beast;
import process.Wedding;

class WeddingTest {
	public static boolean alreadymaried(Beast scorpio1, Beast scorpio2) {
		boolean result = false;
		if(scorpio1.getMarriedWith()!=null || scorpio2.getMarriedWith()!=null ) {
			result = true;
		}
		return result;
	}


	public static boolean mariage(Beast scorpio1, Beast scorpio2) {
		if(!alreadymaried(scorpio1, scorpio2)) {
			if(( (scorpio1.getGender().equals("male") && scorpio2.getGender().equals("female")  ) || ((scorpio1.getGender().equals("female") && scorpio2.getGender().equals("male"))))) {

				scorpio1.setMarriedWith(scorpio2.getName());
				scorpio2.setMarriedWith(scorpio1.getName());
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
	@Test
	void test() {
		Beast.initName();
		Beast s = new Beast();
		Beast q = new Beast();
		Beast r = new Beast();
		Beast t = new Beast();

		System.out.println(s.toString());
		System.out.println(q.toString());
		System.out.println(r.toString());
		System.out.println(t.toString());
		
		System.out.println("\n\n" + s.getName() + " est " + s.getGender());
		System.out.println(q.getName() + " est " + q.getGender());
		System.out.println(r.getName() + " est " + r.getGender());
		System.out.println(t.getName() + " est " + t.getGender() + "\n\n");
		
		if(Wedding.mariage(s,q)) {
			System.out.println(s.getName() + " et " + q.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + s.getName() + " et " + q.getName() + " de se marier");
		}
		
		if(Wedding.mariage(q, r)) {
			System.out.println(q.getName() + " et " + r.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + q.getName() + " et " + r.getName() + " de se marier");
		}
		
		if(Wedding.mariage(r, t)) {
			System.out.println(r.getName() + " et " + t.getName() + " se sont marié");
		}
		else {
			System.out.println("Impossible pour " + r.getName() + " et " + t.getName() + " de se marier");
		}
	}
	

	

}
