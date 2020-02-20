package betes;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Interface extends JFrame{
	
	private JPanel pan = new JPanel();
	private JPanel panNord = new JPanel();
	private JPanel panSud = new JPanel();
	private JPanel panCenter = new JPanel();
	private JPanel panEst = new JPanel();
	private JPanel panOuest = new JPanel();
	
	public int setMainWindowVisible() {
		setVisible(true);
		return 1;
	}
	
	public static void main (String[]args) {
		new Interface();
	}
	
	public Interface() {
		build();
	}
	
	void build(){
		
		this.setTitle("Betes : simulation");
		setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
		this.setSize(800, 400);
		setResizable(true) ;
		setVisible(true) ;
		
		pan.setLayout(new BorderLayout());
		
		pan.add(panCenter, BorderLayout.CENTER);
		panCenter.setBackground(Color.red) ;
		
		panNord.setMinimumSize(new Dimension(100,50));
		panNord.setPreferredSize(new Dimension(100,50));
		panNord.setMaximumSize(new Dimension(100,50));
		pan.add(panNord, BorderLayout.NORTH);
		panNord.setBackground(Color.black);
		
		panSud.setMinimumSize(new Dimension(100,50));
		panSud.setPreferredSize(new Dimension(100,50));
		panSud.setMaximumSize(new Dimension(100,50));
		pan.add(panSud, BorderLayout.SOUTH);
		panSud.setBackground(Color.black);
		
		panEst.setMinimumSize(new Dimension(100,50));
		panEst.setPreferredSize(new Dimension(100,50));
		panEst.setMaximumSize(new Dimension(100,50));
		pan.add(panEst, BorderLayout.EAST);
		panEst.setBackground(Color.black);
		
		panOuest.setMinimumSize(new Dimension(100,50));
		panOuest.setPreferredSize(new Dimension(100,50));
		panOuest.setMaximumSize(new Dimension(100,50));
		pan.add(panOuest, BorderLayout.WEST);
		panOuest.setBackground(Color.black);
		
		    
		
		    
		this.setContentPane(pan);
		
	}

}
