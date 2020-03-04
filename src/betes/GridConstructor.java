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
		g2.drawImage(readImage("src/images/scorpion.jpg"),50, 100, null, null);
		
	}
	
}
