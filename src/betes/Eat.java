package betes;

public class Eat {
	
	private Food f;
	private Beast s;
	
	public Eat() {
		Food f = new Food();
		Beast s = new Beast();
	}
	
	public void evolution(Beast s, Food f) {
		
		if(f.getTypeFood() == "Spider") {
			s.getCharacteristic().setStrength(s.getCharacteristic().getStrength() +1);
		}
		
		else if(f.getTypeFood() == "Mouse") {
			s.getCharacteristic().setIntelligence(s.getCharacteristic().getIntelligence() +1);
		}
		
		else if(f.getTypeFood() == "Lizard") {
			s.getCharacteristic().setAgility(s.getCharacteristic().getAgility() + 1);
		}
		
		else if(f.getTypeFood() == "Snake") {
			s.getCharacteristic().setMadness(s.getCharacteristic().getMadness() + 1);
		}
		
		else if(f.getTypeFood() == "Mosquito") {
			s.getCharacteristic().setVelocity(s.getCharacteristic().getVelocity() + 1);
		}
		
		else if(f.getTypeFood() == "Bay") {
			s.getCharacteristic().setStrength(s.getCharacteristic().getStrength() - 1);
			s.getCharacteristic().setIntelligence(s.getCharacteristic().getIntelligence() - 1);
			s.getCharacteristic().setAgility(s.getCharacteristic().getAgility() - 1);
			s.getCharacteristic().setMadness(s.getCharacteristic().getMadness() - 1);
			s.getCharacteristic().setVelocity(s.getCharacteristic().getVelocity() - 1);
		}
		
	}
	
	public static void main (String[] args) {
		Eat e = new Eat();
		Beast s = new Beast();
		Food f = new Food();
		
		Beast.initName();
		s.randomName();
		System.out.println(s.toString());
		
		f.initFood();
		f.randomFood();
		
		e.evolution(s, f );
		
		System.out.println("La nourriture est : " + f.getTypeFood());
		System.out.println(s.toString());
	}

}
