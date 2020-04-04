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
	private JLabel tx = new JLabel("Journal du scorpion :");
	private JLabel bv = new JLabel("Nombre de bêtes vivantes :");
	private JLabel bm = new JLabel("Nombre de bêtes mortes :");
	private JLabel n = new JLabel("Nombre de subsistances :");
	private JLabel tt = new JLabel("Nombre total de tours :      ");
	private JLabel ta = new JLabel("Nombre de tours actuel :    ");
	private JLabel tr = new JLabel("Nombre de tours restants :");
	private JLabel ok1 = new JLabel("ok");
	private JLabel ok2 = new JLabel("okok");
	private JLabel ok3 = new JLabel("okokok");
	private JLabel oe1 = new JLabel("oe");
	private JLabel oe2 = new JLabel("oeoe");
	private JLabel oe3 = new JLabel("oeoeoe");
	private JButton start;
	private JButton stop;
	public static GridPanel p;
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
		panSud.add(tx);
		pan.add(panSud, BorderLayout.SOUTH);
		
		
		panEst.setLayout(new GridLayout(3,1));
		panEst.setMinimumSize(new Dimension(100,50));
		panEst.setPreferredSize(new Dimension(300,150));
		panEst.setMaximumSize(new Dimension(100,50));
		panEst.setBackground(Color.gray);
		panEst.add(tr);
		panEst.add(oe1);
		panEst.add(tt);
		panEst.add(oe2);
		panEst.add(ta);
		panEst.add(oe3);
		pan.add(panEst, BorderLayout.EAST);
		
		
		
		
		panOuest.setLayout(new GridLayout(3,1));
		panOuest.setMinimumSize(new Dimension(100,50));
		panOuest.setPreferredSize(new Dimension(300,150));
		panOuest.setMaximumSize(new Dimension(100,50));
		panOuest.setBackground(Color.gray);
		panOuest.add(bv);
		panOuest.add(ok1);
		panOuest.add(bm);
		panOuest.add(ok2);
		panOuest.add(n);
		panOuest.add(ok3);
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
			System.out.println("start");
			
			GridPanel.stop = false;
			
		}
		
		if (Button==stop) {
			System.out.println("stop");
//			Thread.currentThread().interrupt();
			GridPanel.stop = true;
		}
	}
}


	
	

