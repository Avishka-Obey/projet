package betes;

public class Test {
	public static void main(String[]args) {
		Beast b1 = new Beast();
		Beast b2 = new Beast();
		Beast.initName();
		b1.randomName();
		b2.randomName();
		Wedding w = new Wedding();
		if(w.mariage(b1, b2)) {
			if((b1.getEnergy().getEnergy()>10)&&(b2.getEnergy().getEnergy()>10)){{
			Beast enfant = b1.reproduce(b2) ;
			enfant.randomName();
			System.out.println(b1.toString());
			System.out.println(b2.toString());
			System.out.println(b1.getName() + " et " + b2.getName() + " se sont marié et on donner naissance " + enfant.getName());
			System.out.println(enfant) ;
		}
			}
		else if (!(b1.getEnergy().getEnergy()>10)||(b2.getEnergy().getEnergy()>10)){
			System.out.println("Impossible pour " + b1.getName() + " et " + b2.getName() + " de se marier ou de donner naissance");
			System.out.println(b1.toString());
			System.out.println(b2.toString());
		}
		
	}
}
	}
