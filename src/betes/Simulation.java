package betes;

import java.util.ArrayList;

public class Simulation extends Thread {
	private Beast b ;
	private Eating e ;
	private Fight f ;
	private Wedding w ;
	private static ArrayList<Beast> al ;
	private Move m ;
	private int nbroundMax ;
	private boolean running = false;
	private boolean roundTerminus = false;
	
	public Simulation(int nbroundMax, ArrayList<Beast> al) { //Beast b ,Eating e, Fight f, Wedding w , Move m ){
		this.nbroundMax = nbroundMax;
//		this.b = new Beast();
//		this.e = new Eating();
//		this.f = new Fight();
//		this.w = new Wedding();
//		this.m = new Move();
		this.al=al;
		
		
	}
//	public void launch() {
//		b = new Beast();
//		e = new Eating();
//		f = new Fight();
//		w = new Wedding();
//		m = new Move();
	
//	public void run() {
//		while (!roundTerminus && running) {
//			GridConstructor.unitTime();
//
//			int positionX = b.getPosition().getX();
//			int positionY = b.getPosition().getY();
//		
//			
//				for (int i =0 ; i<nbroundMax ; i++) {
//					GridConstructor .unitTime();
//				}
//			}
	
			
			
			
			
//		
		public static void main(String[] args) {
			Interface simulationGUI  = new Interface();
			Thread guiTread = new Thread(simulationGUI );
//			Simulation a = new Simulation(10, al);
			guiTread.start();
		}
}
	



