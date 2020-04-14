package data;

public class Antenna {
	private int vision;
	private int smell;
	private int love;
	
	public Antenna() {
		vision = (int)(Math.random() * 10);
		smell = (int)(Math.random() * 10) ;
		love  = (int)(Math.random() * 10);
	}
	public Antenna(int vision , int smell, int love) {
		this.vision = vision;
		this.smell = smell;
		this.love = love;
		
	}
	
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
	
	public static void main (String[] args) {
		Antenna at = new Antenna();
		System.out.println(at.toString());
	}

}
