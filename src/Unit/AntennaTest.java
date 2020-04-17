package Unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Antenna;

class AntennaTest {
	private int vision;
	private int smell;
	private int love;
	
	public int getVision() {
		return vision;
	}
	
	public int getSmell() {
		return smell;
	}
	
	public int getLove() {
		return love;
	}
	
	public void setVision(int vision) {
		this.vision = vision;
	}
	
	public void setSmell(int smell) {
		this.smell = smell;
	}
	
	public void setLove(int love) {
		this.love = love;
	}
	
	public String toString() {
		String text = "";
		text = "Vision = " + getVision() + "\nSmell = " + getSmell() + "\nLove = " + getLove();
		return text;
	}
	
	
		



	@Test
	void test() {

		Antenna at = new Antenna();
		System.out.println(at.toString());
	
	}

}
