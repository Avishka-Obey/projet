package betes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GridPanel extends JPanel implements Runnable {
	
	public static int taille;
	public static int width =600;
	public static int rdm;
	private Simulation sim ;
		
	private static final long serialVersionUID = -541698616292452515L;
	private HashMap<String,Item> items;
	private GridConstructor grid;
	public static boolean stop =true;
	private Round round = new Round();
	
	public GridPanel(int i, int j, int k, int rdm) {
		setPreferredSize(new Dimension(601,601));
		this.setSize(1200,700);
		grid = new GridConstructor();
		items = grid.getItems();
		sim = new Simulation(items);
		grid.initFoods(j, rdm);
		grid.initEnvironments(k, rdm);
		grid.initBeasts(i, rdm);
		
	}
	
	@Override
	public void paint(Graphics g) {
		sim.update();
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		drawDebugGrid(g, width,  taille);
		printEnv(g2, taille);
		printFood(g2, taille);
		printBeast(g2, taille);
		printResultat(g2);
	}
	
	private void drawDebugGrid(Graphics g, int width, int taille) {
		
		g.drawLine(width, 0, width, width);
		g.drawLine(0, width, width, width);
		g.drawLine(0, 0, 0, width);
		g.drawLine(0, 0, width, 0);
		g.setColor(Color.BLACK);

		for (int i = 0; i <= width; i += taille) {
			g.drawLine(i, 0, i, width);
		}

		for (int i = 0; i <= width; i += taille) {
			g.drawLine(1, i, width, i);
		}
	}
	
	private void printBeast(Graphics g2, int taille) {
		for(Iterator<Item> it= items.values().iterator();it.hasNext(); ) {
			Item val = it.next();
			g2.drawImage(val.getImage(),val.getPosition().getX()*taille+1,val.getPosition().getY()*taille+1, taille-1, taille-1, null);
		}
	}
	
	private void printFood(Graphics g2, int taille) {
		for(Iterator<Item> it= items.values().iterator();it.hasNext(); ) {
				Item val2 = it.next();
				g2.drawImage(val2.getImage(),val2.getPosition().getX()*taille+1,val2.getPosition().getY()*taille+1, taille-1, taille-1, null);
		}
	}
	
	private void printEnv(Graphics g2, int taille) {
		for(Iterator<Item> it= items.values().iterator();it.hasNext(); ) {
				Item val3 = it.next();
				g2.drawImage(val3.getImage(),val3.getPosition().getX()*taille+1,val3.getPosition().getY()*taille+1,taille-1, taille-1, null);
		}
	}
	private void printResultat(Graphics g2) {
		g2.drawString(this.round.getStr(),5 ,25 );
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				if(!stop && this.round.getCompteurRound()>=0) {
					for(int j=0;j<GridConstructor.nbScorpion;j++) {
						int i =(int)(Math.random()*4+1);
						Move.move(grid.getBeasts().get(j), i, rdm);
					}
					this.repaint() ;
					Thread.sleep(500);
				}
				
			}
			catch(InterruptedException e) {
				System.out.println("erreur");
			}
//			Thread.currentThread().interrupt();
		}	
		
		
	}
	

}
			
				







