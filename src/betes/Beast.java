package betes;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

import java.awt.Color;

public class Beast {
	private int age;
	private String gender;
	private Color color;
	private Antenna choice;
	private EnergyBar energybar;
	private Characteristic charater;
	private HashMap <Integer,String> hm;
	private HashMap <Integer,Color> cl;
	private ArrayList<Integer> al;
	
	public Beast() {
		this.age = 0;
		this.gender = randomGender();
		this.color = getColor();
		this.energybar = new EnergyBar(20);
		this.charater = new Characteristic();
		this.choice = new Antenna();
	}
	
	public int getAge() {
		return age;
	}
	
	public int incrementAge() {
		age++;
		return age;
	}
	
	public int Random() {
		Random rm = new Random();
		int n;
		n = rm.nextInt(2);
		return n;
	}
	
	public void initGender() {
		hm = new HashMap<Integer, String> ();
		hm.put(0, "male");
		hm.put(1, "female");
	} 
	
	public String randomGender() {
		initGender();
		gender = hm.get(Random());
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
	
	
	public Color getColor() {
		color = randomColor();		
		return color;
	}
	

	public static void main (String[] args) {
		Beast s = new Beast();
		Characteristic ct = new Characteristic();
		Antenna nt = new Antenna();
		EnergyBar eb = new EnergyBar(20);
		
		System.out.println("Color : " + s.getColor() + "\nAge : " + s.getAge() + "\nGender : " + s.randomGender() + "\nCharacteristic : \n" + ct.toString() + "\n\nAntenna : \n" + nt.toString() + "\n\nEnergy Bar : " + eb.toString());
		
	}
}
