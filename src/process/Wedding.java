package process;
/**
 * Cette classe représente le mariage entre 2 bêtes 
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */
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
		

	}