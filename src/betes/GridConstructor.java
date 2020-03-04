package betes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
	}
	
	private void drawDebugGrid(Graphics g) {
		int width = 600; //getWidth();
		int height = 600; //getHeight();
		
		g.drawLine(0, 0, 0, 600);
		g.drawLine(0, 0, 600, 0);
		g.drawLine(600, 0, 600, 600);
		g.drawLine(0, 600, 600, 600);
		g.setColor(Color.GRAY);

		for (int i = 0; i <= width; i += 50) {
			g.drawLine(i, 0, i, height);
		}

		for (int i = 0; i <= height; i += 50) {
			g.drawLine(1, i, width, i);
		}
	}
	
}
