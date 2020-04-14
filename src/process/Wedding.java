package process;

import data.*;
import java.util.ArrayList;


	public class Wedding {
	
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
		
		//aucune faute dans l'execution
	
		
		public static void main(String [] args) {
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
			
			Wedding.mariage(s,q);
			
			
			
				System.out.println(Wedding.alreadymaried(s,q));
				System.out.println(Wedding.alreadymaried(s,r));
				System.out.println(Wedding.alreadymaried(r,t));
				
			}
			
			
	//		if(Wedding.mariage(q, r)) {
	//			System.out.println(q.getName() + " et " + r.getName() + " se sont marié");
	//		}
	//		else {
	//			System.out.println("Impossible pour " + q.getName() + " et " + r.getName() + " de se marier");
	//		}
	//		
	//		if(Wedding.mariage(t, r)) {
	//			System.out.println(t.getName() + " et " + r.getName() + " se sont marié");
	//		}
	//		else {
	//			System.out.println("Impossible pour " + t.getName() + " et " + r.getName() + " de se marier");
	//		}
		
	
		

	}