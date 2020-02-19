package betes;


public class Eating {
	
	private Food f;
	private Beast s;
	
	public Eating() {
		Food f = new Food();
		Beast s = new Beast();
	}
	
	public void evolution(Beast s, Food f) {
		
		if(f.getTypeFood() == "Spider") {
			s.getCharacteristic().setStrength(s.getCharacteristic().getStrength() +1);
			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
		}
		
		else if(f.getTypeFood() == "Mouse") {
			s.getCharacteristic().setIntelligence(s.getCharacteristic().getIntelligence() +1);
			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
		}
		
		else if(f.getTypeFood() == "Lizard") {
			s.getCharacteristic().setAgility(s.getCharacteristic().getAgility() + 1);
			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
		}
		
		else if(f.getTypeFood() == "Snake") {
			s.getCharacteristic().setMadness(s.getCharacteristic().getMadness() + 1);
			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
		}
		
		else if(f.getTypeFood() == "Mosquito") {
			s.getCharacteristic().setVelocity(s.getCharacteristic().getVelocity() + 1);
			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
		}
		
		else if(f.getTypeFood() == "Bay") {
			if(s.getCharacteristic().getStrength() !=0) {
				s.getCharacteristic().setStrength(s.getCharacteristic().getStrength() - 1);
			}
			
			if(s.getCharacteristic().getIntelligence() !=0) {
				s.getCharacteristic().setIntelligence(s.getCharacteristic().getIntelligence() - 1);
			}
			
			if(s.getCharacteristic().getAgility() !=0) {
				s.getCharacteristic().setAgility(s.getCharacteristic().getAgility() - 1);
			}
			
			if(s.getCharacteristic().getMadness() !=0) {
				s.getCharacteristic().setMadness(s.getCharacteristic().getMadness() - 1);
			}
			
			if(s.getCharacteristic().getVelocity() !=0) {
				s.getCharacteristic().setVelocity(s.getCharacteristic().getVelocity() - 1);
			}
			
			if(s.getEnergy().getEnergy() >= 6) {
				for(int i = 0; i<5; i++) {
					s.getEnergy().decrement();
				}
			}
			
			else {
				s.destroy();
//				Normalement ici ça détruit la bête
			}
		}
		
	}
	
	public static void main (String[] args) {
		
		Beast s = new Beast();
		Food f = new Food();
		Eating e = new Eating();
		
		Beast.initName();
		s.randomName();
		System.out.println(s.toString());
		
		f.initFood();
		f.randomFood();
		
		e.evolution(s, f);
		
		System.out.println("La nourriture est : " + f.getTypeFood());
		System.out.println(s.toString());
	}

}
