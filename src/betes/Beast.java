package betes;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.awt.Color;

public class Beast {
	private String name;
	private int age;
	private String gender;
	private Color color;
	private Antenna choice;
	private EnergyBar energybar;
	private Characteristic charater;
	private HashMap <Integer,String> hm;
	private static ArrayList <String> nm;

	
	public Beast() {
		this.name = name;
		this.age = 0;
		this.gender = randomGender();
		this.color = getColor();
		this.energybar = new EnergyBar(20);
		this.charater = new Characteristic();
		this.choice = new Antenna();
	}
	
	
	public static void initName() {
		nm = new ArrayList <String> ();
		nm.add("Georges");
		nm.add("Michel");
		nm.add("Gertrude");
		nm.add("Moncef");
		nm.add("Salma");
		nm.add("Enzo");
		nm.add("Farah");
		nm.add("Rayane");
		nm.add("Avishka");
		nm.add("Yannis");
	}
	
	public String randomName() {
		int rnd = (int) (Math.random() * nm.size());
		name = nm.get(rnd);
		nm.remove(rnd);
		setName(name);
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	
	
	public int getAge() {
		return age;
	}
	
	public int incrementAge() {
		age++;
		return age;
	}
	
	
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
		gender = hm.get(n);
		return gender;
	}
	
	
	public int energy() {
		return energybar.getEnergy();
	}
	
	public String charact() {
		int a;
		int b;
		int c;
		int d;
		int e;
		
		a = charater.getAgility();
		b = charater.getIntelligence();
		c = charater.getMadness();
		d = charater.getStrength();
		e = charater.getVelocity();
		
		String text = "";
		text = "Agility = " + a + "\nVelocity = " + e + "\nMadness = " + c + "\nIntelligence = " + b + "\nStrength = " + d;
		return text;
	}
	
	public String ant() {
		return choice.toString();
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
	
	public String toString() {
		String text = "";
		text += "\n\nName : " + getName() + "\nColor : " + getColor() + "\nAge : " + getAge() + "\nGender : " + randomGender() + "\nCharacteristic : \n" + charact() + "\n\nAntenna : \n" + ant() + "\n\nEnergy Bar : " + energy();
		return text;
	}
	

	public static void main (String[] args) {
		
		Beast.initName();
		
		for(int i = 0; i<10; i++) {
			Beast s = new Beast();
			s.randomName();
			System.out.println(s.toString());
		}
		
	}
}
