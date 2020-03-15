package betes;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GridConstructor extends JPanel {
	
	private static final long serialVersionUID = -541698616292452515L;
	private ArrayList<String> al = new ArrayList<String>(20);
	private ArrayList<String> array = new ArrayList<String>(6);
	private ArrayList<String> env = new ArrayList<String>(3);
	private ArrayList<Beast> po = new ArrayList<Beast>();
	private int fin = 20;
	private Food[] f = new Food[30];
	private Beast[] b = new Beast[fin+1];
	private Environment[] e = new Environment[50];
	private int p = 0;
	
	public GridConstructor() {
//		int windowWidth = 500;
		setPreferredSize(new Dimension(601,601));
//		getAll();
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawDebugGrid(g);
		Graphics2D g2 = (Graphics2D) g;
//		printEnv(g2);
		printBeast(g2);
//		printFood(g2);
	}
	
	private void drawDebugGrid(Graphics g) {
		int width = 600; //getWidth();
		int height = 600; //getHeight();
		
		g.drawLine(600, 0, 600, 600);
		g.drawLine(0, 600, 600, 600);
		g.drawLine(0, 0, 0, 600);
		g.drawLine(0, 0, 600, 0);
		g.setColor(Color.GRAY);

		for (int i = 0; i <= width; i += 50) {
			g.drawLine(i, 0, i, height);
		}

		for (int i = 0; i <= height; i += 50) {
			g.drawLine(1, i, width, i);
		}
	}
	
	
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}
	
	
	public void initEnvironment() {
		env.add("src/images/mountain.png");
		env.add("src/images/desert.png");
		env.add("src/images/forest.png");
	}
	
	public void initImage() {
		al.add("src/images/scorpion.png");
		al.add("src/images/blue.png");
		al.add("src/images/brown.png");
		al.add("src/images/burgundy.png");
		al.add("src/images/darkb.png");
		al.add("src/images/gray.png");
		al.add("src/images/green.png");
		al.add("src/images/greenblue.png");
		al.add("src/images/lightb.png");
		al.add("src/images/nude.png");
		al.add("src/images/orange.png");
		al.add("src/images/pastelblue.png");
		al.add("src/images/pi.png");
		al.add("src/images/pink.png");
		al.add("src/images/purple.png");
		al.add("src/images/purplelight.png");
		al.add("src/images/red.png");
		al.add("src/images/salmon.png");
		al.add("src/images/turquoise.png");
		al.add("src/images/yellow.png");
	}
	
	public void initFood() {
		array.add("src/images/snake.png");
		array.add("src/images/spider.png");
		array.add("src/images/lezard.png");
		array.add("src/images/mouse.png");
		array.add("src/images/mosquito.png");
		array.add("src/images/berries.png");
	}

	private void printBeast(Graphics g2) {
		
		
		String img;
		initImage();
		
		for(int i = 0; i<20; i++) {
			int n = (int)(Math.random() * 12) * 50 + 1;
			int m = (int)(Math.random() * 12) * 50 + 1;
			Position pos = new Position(n,m);
			int rnd = (int) (Math.random() * al.size());
			img = al.get(rnd);
//			System.out.println(img);
			al.remove(rnd);
			Beast.initName();
			b[i] = new Beast(readImage(img),pos);
			b[i].randomName();
//			System.out.println(b[i].getPosition());
			
			if(i==0) {
				po.add(b[i]);
			}
			else  {
				for(int a=0; a<=po.size();a++) {
					
						if ((b[i].getPosition().getX() == b[a].getPosition().getX()) && (b[i].getPosition().getY() == b[a].getPosition().getY())) {
						
							b[a].getPosition().setX((int)(Math.random() * 12)*50+1);
							b[a].getPosition().setY((int)(Math.random() * 12)*50+1);
							
//							b[a].getPosition().setY(b[i].getPosition().getY()*(int)(Math.random() * 12)*50+1);
						}
									
				}
				po.add(b[i]);
				
			}
			
			System.out.println(b[i].getPosition());
			
			g2.drawImage(b[i].getImage(),b[i].getPosition().getX(), b[i].getPosition().getY(), null, null);
		}
		
	}
	
	
	

//	public void getAll() {
//		String img;
//		initImage();
//		for(int i = 0; i<20; i++) {
//			int n = (int)(Math.random() * 12)*50+1;
//			int m = (int)(Math.random() * 12) * 50 + 1;
//			Position pos = new Position(n,m);
//			int rnd = (int) (Math.random() * al.size());
//			img = al.get(rnd);
//	//		System.out.println(img);
//			al.remove(rnd);
//			Beast.initName();
//			b[i] = new Beast(readImage(img),pos);
//			System.out.println(b[i]);
//		}
//		
//	}
	
	private void printFood(Graphics g2) {
		
		initFood();

	
		for(int i = 0; i<30; i++) {
			int n = (int)(Math.random() * 12) * 50 + 1;
			int m = (int)(Math.random() * 12) * 50 + 1;
			Position pos = new Position(n,m);
			int rnd = (int) (Math.random() * array.size());
			
			f[i] = new Food(readImage(array.get(rnd)), pos);
			System.out.println(f[i]);
			
			if (f[i].getTypeFood().equals("Spider")) {
				g2.drawImage(readImage("src/images/spider.png"),f[i].getPosition().getX(), f[i].getPosition().getY(), null, null);
			}
			
			else if (f[i].getTypeFood().equals("Mouse")) {
				g2.drawImage(readImage("src/images/mouse.png"),f[i].getPosition().getX(), f[i].getPosition().getY(), null, null);
			}
			
			else if (f[i].getTypeFood().equals("Mosquito")) {
				g2.drawImage(readImage("src/images/Mosquito.png"),f[i].getPosition().getX(), f[i].getPosition().getY(), null, null);
			}
			
			else if (f[i].getTypeFood().equals("Snake")) {
				g2.drawImage(readImage("src/images/snake.png"),f[i].getPosition().getX(), f[i].getPosition().getY(), null, null);
			}
			
			else if (f[i].getTypeFood().equals("Bay")) {
				g2.drawImage(readImage("src/images/berries.png"),f[i].getPosition().getX(), f[i].getPosition().getY(), null, null);
			}
			
			else if (f[i].getTypeFood().equals("Lizard")) {
				g2.drawImage(readImage("src/images/lezard.png"),f[i].getPosition().getX(), f[i].getPosition().getY(), null, null);
			}
		}
	}
//			g2.drawImage(f[i].getImage(),n, m, null, null);
//		}
//		
		
//		g2.drawImage(readImage("src/images/snake.png"),551, 551, null, null);
//		g2.drawImage(readImage("src/images/spider.png"),101, 101, null, null);
//		g2.drawImage(readImage("src/images/lezard.png"),201, 201, null, null);
//		g2.drawImage(readImage("src/images/mouse.png"),301, 301, null, null);
//		g2.drawImage(readImage("src/images/mosquito.png"),401, 401, null, null);
//		g2.drawImage(readImage("src/images/berries.png"),501, 501, null, null);
	
//	}
	
	
	
//	private void printEnv(Graphics g2) {
//		
//		initEnvironment();
//		
//		for(int i = 0; i<3; i++) {
//			int n = (int)(Math.random() * 9) * 50 + 1;
//			int m = (int)(Math.random() * 9) * 50 + 1;
//			
//			Position pos = new Position(n,m);
//			int rnd = (int) (Math.random() * env.size());
//			e[i] = new Environment(readImage(env.get(rnd)), pos);
////			System.out.println(e[i]);
//			
//			
////			for(int j = n; j<=(n+(50*3+1)); j += 51) {
////				for(int k = m; k<=(m+(50*3+1)); k += 51) {
//					
////					pos.setX(j);
////					pos.setY(k);
//					if (e[i].getType().equals("Mountain")) {
//						e[p] = new Environment(readImage(env.get(rnd)), pos);
//						g2.drawImage(readImage("src/images/mountain.png"),e[p].getPosition().getX(), e[p].getPosition().getY(), null, null);
//					}
//					
//					else if (e[i].getType().equals("Desert")) {
//						e[p] = new Environment(readImage(env.get(rnd)), pos);
//						g2.drawImage(readImage("src/images/desert.png"),e[p].getPosition().getX(), e[p].getPosition().getY(), null, null);
//					}
//					
//					else  if (e[i].getType().equals("Forest")) {
//						e[p] = new Environment(readImage(env.get(rnd)), pos);
//						g2.drawImage(readImage("src/images/forest.png"),e[p].getPosition().getX(), e[p].getPosition().getY(), null, null);
//					}
//					
//					System.out.println(e[i].toString());
//					
//				}
//			}
////		}
////	}
	private void printEnv(Graphics g2) {
		initEnvironment();
		
		
		for(int i = 0; i<30; i++) {
			int n = (int)(Math.random() * 12) * 50 + 1;
			int m = (int)(Math.random() * 12) * 50 + 1;
			Position pos = new Position(n,m);
			int rnd = (int) (Math.random() * env.size());
			
			e[i] = new Environment(readImage(env.get(rnd)), pos);

			
			if (e[i].getType().equals("Moutain")) {
				g2.drawImage(readImage("src/images/mountain.png"),e[i].getPosition().getX(), e[i].getPosition().getY(), null, null);
			}
			
			else if (e[i].getType().equals("Desert")) {
				g2.drawImage(readImage("src/images/desert.png"),e[i].getPosition().getX(), e[i].getPosition().getY(), null, null);
			}
			
			else if (e[i].getType().equals("Forest")) {
				g2.drawImage(readImage("src/images/forest.png"),e[i].getPosition().getX(), e[i].getPosition().getY(), null, null);
			}
			
			System.out.println(e[i].toString());
	}
		}
	}



