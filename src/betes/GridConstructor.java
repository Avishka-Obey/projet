package betes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GridConstructor extends JPanel {
	
	private static final long serialVersionUID = -541698616292452515L;
	private boolean debugGrid = true;
	public GridConstructor() {
		int windowWidth = 500;
		setPreferredSize(new Dimension(601,601));
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawDebugGrid(g);
		Graphics2D g2 = (Graphics2D) g;
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
	
	
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}
	
	private void printBeast(Graphics g2) {
		g2.drawImage(readImage("src/images/scorpio.png"),51, 101, null, null);
		g2.drawImage(readImage("src/images/blue.png"),51, 151, null, null);
		g2.drawImage(readImage("src/images/brown.png"),51, 201, null, null);
		g2.drawImage(readImage("src/images/burgundy.png"),51, 251, null, null);
		g2.drawImage(readImage("src/images/darkb.png"),51, 301, null, null);
		g2.drawImage(readImage("src/images/gray.png"),51, 351, null, null);
		g2.drawImage(readImage("src/images/green.png"),51, 401, null, null);
		g2.drawImage(readImage("src/images/greenblue.png"),51, 451, null, null);
		g2.drawImage(readImage("src/images/lightb.png"),51, 501, null, null);
		g2.drawImage(readImage("src/images/nude.png"),51, 551, null, null);
		g2.drawImage(readImage("src/images/orange.png"),1, 1, null, null);
		g2.drawImage(readImage("src/images/pastelblue.png"),251, 51, null, null);
		g2.drawImage(readImage("src/images/pi.png"),251, 101, null, null);
		g2.drawImage(readImage("src/images/pink.png"),251, 151, null, null);
		g2.drawImage(readImage("src/images/purple.png"),251, 201, null, null);
		g2.drawImage(readImage("src/images/purplelight.png"),251, 251, null, null);
		g2.drawImage(readImage("src/images/red.png"),251, 301, null, null);
		g2.drawImage(readImage("src/images/salmon.png"),251, 351, null, null);
		g2.drawImage(readImage("src/images/turquoise.png"),251, 401, null, null);
		g2.drawImage(readImage("src/images/yellow.png"),251, 451, null, null);
		
		
		
	}
	
	private void printFood(Graphics g2) {
		g2.drawImage(readImage("src/images/snake.png"),601, 201, null, null);
		g2.drawImage(readImage("src/images/spider.png"),101, 101, null, null);
		g2.drawImage(readImage("src/images/lezard.png"),201, 201, null, null);
		g2.drawImage(readImage("src/images/mouse.png"),301, 301, null, null);
		g2.drawImage(readImage("src/images/mosquito.png"),401, 401, null, null);
		g2.drawImage(readImage("src/images/berries.png"),501, 501, null, null);
	
	}
	
	

}
