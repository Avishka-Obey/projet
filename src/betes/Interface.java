package betes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;


public class Interface extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -541698616292452515L;
	
	private JPanel pan = new JPanel();
	private JPanel panNord = new JPanel();
	private JPanel panSud = new JPanel();
	private JPanel panCenter = new JPanel();
	private JPanel panEst = new JPanel();
	private JPanel panOuest = new JPanel();
	private JLabel jds = new JLabel("Journal du scorpion : ");
	public static JLabel bv;
	public static JLabel bm;
	public static JLabel nsub;
	public static JLabel tt;
	public static JLabel ta= new JLabel(Round.atc);
	public static JLabel tr = new JLabel(Round.str);
	
	private JButton start;
	private JButton stop;
	public static GridPanel p;
	public static int nbfood;
	public static int numberAlive;
	public static int numberDead;
	Thread tred;
	
		
	public static void main (String[]args) {
		 new Interface();	
	}
	
	public Interface() {
		build();
	}
	
	private void build(){
		
		this.setTitle("Betes : simulation");
		setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
		this.setSize(1500, 750);
		setResizable(false) ;
		setLocationRelativeTo(null);
		pan.setLayout(new BorderLayout());
		
		stop  = new JButton ("Stop");
		stop.addActionListener(this);
		start = new JButton("Start");
		start.addActionListener(this);

		panCenter.setBackground(Color.pink) ;
		panCenter.setSize(1200,700);
		panCenter.add(p);
		panCenter.add(start);
		panCenter.add(stop);
		pan.add(panCenter, BorderLayout.CENTER);
		
		panNord.setMinimumSize(new Dimension(0,0));
		panNord.setPreferredSize(new Dimension(0,0));
		panNord.setMaximumSize(new Dimension(0,0));
		panNord.setBackground(Color.gray);
		pan.add(panNord, BorderLayout.NORTH);
		
		panSud.setMinimumSize(new Dimension(200,100));
		panSud.setPreferredSize(new Dimension(200,100));
		panSud.setMaximumSize(new Dimension(200,100));
		panSud.setBackground(Color.gray);
		panSud.add(jds);
		pan.add(panSud, BorderLayout.SOUTH);
		
		
		panEst.setLayout(new GridLayout(3,1));
		panEst.setMinimumSize(new Dimension(100,50));
		panEst.setPreferredSize(new Dimension(300,150));
		panEst.setMaximumSize(new Dimension(100,50));
		panEst.setBackground(Color.gray);
		panEst.add(tt);
		panEst.add(ta);
		panEst.add(tr);
		pan.add(panEst, BorderLayout.EAST);
		
		
		
		
		panOuest.setLayout(new GridLayout(3,1));
		panOuest.setMinimumSize(new Dimension(100,50));
		panOuest.setPreferredSize(new Dimension(300,150));
		panOuest.setMaximumSize(new Dimension(100,50));
		panOuest.setBackground(Color.gray);
		panOuest.add(bv);
		panOuest.add(bm);
		panOuest.add(nsub);
//		panOuest.add(tecG);
		pan.add(panOuest, BorderLayout.WEST);
		
		this.setContentPane(pan);
		setVisible(true) ;
		
		tred = new Thread(p);
		tred.start();	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object Button = e.getSource() ;
		if (Button == start) {
//			System.out.println("start");
			
			GridPanel.stop = false;
			
		}
		
		if (Button==stop) {
//			System.out.println("stop");
//			Thread.currentThread().interrupt();
			GridPanel.stop = true;
		}
	}
}


	
	

