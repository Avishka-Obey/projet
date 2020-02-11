package betes;

public class Antenna {
	private int vision;
	private int smell;
	private int love;
	
	
	public Antenna() {
		vision = (int)(Math.random() * 10);
		smell = (int)(Math.random() * 10) ;
		love  = (int)(Math.random() * 10);
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
