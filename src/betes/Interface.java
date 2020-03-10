package betes;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Interface extends JFrame{
	
	private static final long serialVersionUID = -541698616292452515L;
	
	private JPanel pan = new JPanel();
	private JPanel panNord = new JPanel();
	private JPanel panSud = new JPanel();
	private JPanel panCenter = new JPanel();
	private JPanel panEst = new JPanel();
	private JPanel panOuest = new JPanel();
	private JLabel tx = new JLabel("Journal du scorpion :");
	private JLabel env = new JLabel("Environnements :");
	private JLabel tr = new JLabel("Nombre de tours :");
	
	private GridConstructor grid;
	
	public int setMainWindowVisible() {
		setVisible(true);
		return 1;
	}
	
	public static void main (String[]args) {
		new Interface();
	}
	
	public Interface() {
		grid = new GridConstructor();
		grid.setSize(1200,700);
		build();
	}
	
	private void build(){
		
		this.setTitle("Betes : simulation");
		setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
		this.setSize(1500, 750);
		setResizable(true) ;
		setVisible(true) ;
		
		pan.setLayout(new BorderLayout());
		
		pan.add(panCenter, BorderLayout.CENTER);
		panCenter.setBackground(Color.pink) ;
		panCenter.setSize(1200,700);
		panCenter.add(grid);
//		C'est la qu'on ajoute la grille
		
		
		panNord.setMinimumSize(new Dimension(0,0));
		panNord.setPreferredSize(new Dimension(0,0));
		panNord.setMaximumSize(new Dimension(0,0));
		pan.add(panNord, BorderLayout.NORTH);
		panNord.setBackground(Color.gray);
		
		panSud.setMinimumSize(new Dimension(200,100));
		panSud.setPreferredSize(new Dimension(200,100));
		panSud.setMaximumSize(new Dimension(200,100));
		pan.add(panSud, BorderLayout.SOUTH);
		panSud.setBackground(Color.gray);
		panSud.add(tx);
		
		panEst.setMinimumSize(new Dimension(100,50));
		panEst.setPreferredSize(new Dimension(300,150));
		panEst.setMaximumSize(new Dimension(100,50));
		pan.add(panEst, BorderLayout.EAST);
		panEst.setBackground(Color.gray);
		panEst.add(tr);
		
		panOuest.setMinimumSize(new Dimension(100,50));
		panOuest.setPreferredSize(new Dimension(300,150));
		panOuest.setMaximumSize(new Dimension(100,50));
		pan.add(panOuest, BorderLayout.WEST);
		panOuest.setBackground(Color.gray);
		panOuest.add(env);
		
		    
		this.setContentPane(pan);
	
	}
}
