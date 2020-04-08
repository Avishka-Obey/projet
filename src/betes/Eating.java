package betes;


public class Eating {
	
	public static void evolution(Beast s, Food f) {
		
		if(f.getTypeFood() == "Spider") {
			System.out.println(s);
			s.getCharacteristic().setStrength(s.getCharacteristic().getStrength() +1);
			System.out.println("Strength has changed");
			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
			System.out.println(s);
		}
		
		else if(f.getTypeFood() == "Mouse") {
			System.out.println(s);
			s.getCharacteristic().setIntelligence(s.getCharacteristic().getIntelligence() +1);
			System.out.println("Intelligence has changed");

			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
			System.out.println(s);
		}
		
		else if(f.getTypeFood() == "Lizard") {
			System.out.println(s);
			s.getCharacteristic().setAgility(s.getCharacteristic().getAgility() + 1);
			System.out.println("Agility has changed");

			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
			System.out.println(s);
		}
		
		else if(f.getTypeFood() == "Snake") {
			System.out.println(s);
			s.getCharacteristic().setMadness(s.getCharacteristic().getMadness() + 1);
			System.out.println("Madness has changed");

			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
			System.out.println(s);
		}
		
		else if(f.getTypeFood() == "Mosquito") {
			System.out.println(s);
			s.getCharacteristic().setVelocity(s.getCharacteristic().getVelocity() + 1);
			System.out.println("Velocity has changed");

			if(s.getEnergy().getEnergy() <= 19) {
				s.getEnergy().increment();
			}
			System.out.println(s);
		}
		
		else if(f.getTypeFood() == "Bay") {
			System.out.println(s);
			System.out.println("Bay has been eat");
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
			
			
			System.out.println(s);
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
