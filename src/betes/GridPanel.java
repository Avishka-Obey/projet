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
	

		
	private static final long serialVersionUID = -541698616292452515L;
	Simulation sim ;
	private HashMap<String,Item> items;
	private GridConstructor grid;
	
		public GridPanel() {
			setPreferredSize(new Dimension(601,601));
			this.setSize(1200,700);
			grid = new GridConstructor();
			grid.initBeasts();
			grid.initFoods();
			grid.initEnvironments();
			items = grid.getItems();
			
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			drawDebugGrid(g);
			printEnv(g2);
			printBeast(g2);
			printFood(g2);			
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
		
		private void printBeast(Graphics g2) {
			for(Iterator<Item> it= items.values().iterator();it.hasNext(); ) {
				Item val = it.next();
				g2.drawImage(val.getImage(),val.getPosition().getX()*50,val.getPosition().getY()*50, null);
			}
		}
		private void printFood(Graphics g2) {
				for(Iterator<Item> it= items.values().iterator();it.hasNext(); ) {
						Item val2 = it.next();
						g2.drawImage(val2.getImage(),val2.getPosition().getX()*50,val2.getPosition().getY()*50, null);
				}
			}
			private void printEnv(Graphics g2) {
				for(Iterator<Item> it= items.values().iterator();it.hasNext(); ) {
						Item val3 = it.next();
						g2.drawImage(val3.getImage(),val3.getPosition().getX()*50,val3.getPosition().getY()*50, null);
				}
			}
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					try {
						for(int j=0;j<20;j++) {
							int i =(int)(Math.random()*4+1);
							Move.move(grid.getBeasts().get(j), i);
						}
						this.repaint() ;
						Thread.sleep(3000);
						
					}
					catch(InterruptedException e) {
						System.out.println("erreur");
					}
					//Thread.currentThread().interrupt();
				}	
				
				
			}

}
			
				







