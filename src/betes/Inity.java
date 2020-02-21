package betes;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
	
	public class Inity {
		private HashMap <Integer,String> hm;
		private static ArrayList <String> nm;
		private Beast b;
		
		
		
		public Inity(Beast b) throws IOException {
//			String name = initName();
			int age = 0; 
			String gender = randomGender();
			Color color = randomColor();
			EnergyBar energybar = new EnergyBar(20);
			Characteristic charater = new Characteristic();
			Environment env = new Environment();
			Antenna choice = new Antenna();
			Position pos = new Position(0,0);
			b = new Beast(name , age , gender, color, choice,energybar,charater, env, pos  );
		
	}
//	public String initName() throws IOException {
//		FileReader csv = new FileReader("C:\\Users\\Enzo\\Desktop\\nom.csv") ;
//		BufferedReader signature = new BufferedReader(csv) ;
//		String ligneAnalyse;
//		Random n = new Random();
//		int rnd = (int) (Math.random() * nm.size());
//		String name = nm.get(rnd);
//		nm.remove(rnd);
//				while ( (ligneAnalyse= signature.readLine()) != null) {
//				String []tab = ligneAnalyse.split(",");
//				
//				}
//				signature.close();
//			return name;
//		
//	}
//	public String randomName() {
//		Random n = new Random();
//		int rnd = (int) (Math.random() * nm.size());
//		initName();
//		String name = nm.get(rnd);
//		nm.remove(rnd);
//		return name;
//	}
	public void initGender() {
		hm = new HashMap<Integer, String> ();
		hm.put(0, "male");
		hm.put(1, "female");
		
	} 
	public String randomGender() {
		Random rm = new Random();
		int n;
		n = rm.nextInt(2);
		initGender();
		String gender = hm.get(n);
		return gender;
	}
	public Color randomColor() {
		Random rm = new Random();
		int n;
		int m;
		int o;
		n = rm.nextInt(250);
		m = rm.nextInt(250);
		o = rm.nextInt(250);
		
		Color z = new Color(n,m,o);
		return z;
	}
	

	

	public static void main (String[] args)  {
		
		
		
		for(int i = 0; i<10; i++) {
			Beast b = new Beast();
			Inity s = new Inity( b);
			
			System.out.println(s.toString());
		}
	}
	
	
}
