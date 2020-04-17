package gui;

/**
 * Cette classe represente la création de la fenêtre principale
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import process.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;

import data.Food;
import data.Position;


public class Interface extends JFrame implements ActionListener, MouseListener {
	
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
	
	public static JComboBox js = new JComboBox();
	private JButton ok;
	
	private JButton addFood;
	
	private JButton start;
	private JButton stop;
	public static GridPanel p;
	public static int nbfood;
	public static int numberAlive;
	public static int numberDead;
	public static int nbRound;
	private int x;
	private int y;
	private int abs;
	private int ord;
	Thread tred;
	
		
	public static void main (String[]args) {
		 new Interface();	
	}
	
	public Interface() {
		build();
		addMouseListener(this);
	}
	
	private void build(){
		
		this.setTitle("Betes : simulation");
		setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
		this.setSize(1500, 750);
		setResizable(false) ;
		setLocationRelativeTo(null);
		pan.setLayout(new BorderLayout());
		
		addFood = new JButton("add food");	
		addFood.addActionListener(this);
		addFood.setEnabled(false);
		stop  = new JButton ("Stop");
		stop.addActionListener(this);
		start = new JButton("Start");
		start.addActionListener(this);
		
		ok = new JButton("Ok");
		ok.addActionListener(this);
		jds.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(3,1));
		container.add(jds);
		container.add(js);
		container.add(ok);
		container.setBackground(Color.GRAY);

		panCenter.setBackground(Color.pink) ;
		panCenter.setSize(1200,700);
		panCenter.add(p);
		panCenter.add(start);
		panCenter.add(stop);
		panCenter.add(addFood);
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
		panSud.add(container);
		pan.add(panSud, BorderLayout.SOUTH);
		
		
		panEst.setLayout(new GridLayout(3,1));
		panEst.setMinimumSize(new Dimension(100,50));
		panEst.setPreferredSize(new Dimension(300,150));
		panEst.setMaximumSize(new Dimension(100,50));
		panEst.setBackground(Color.gray);
		tt.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		panEst.add(tt);
		ta.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		panEst.add(ta);
		tr.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		panEst.add(tr);
		pan.add(panEst, BorderLayout.EAST);
		
		
		
		panOuest.setLayout(new GridLayout(3,1));
		panOuest.setMinimumSize(new Dimension(100,50));
		panOuest.setPreferredSize(new Dimension(300,150));
		panOuest.setMaximumSize(new Dimension(100,50));
		panOuest.setBackground(Color.gray);
		bv.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		panOuest.add(bv);
		bm.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		panOuest.add(bm);
		nsub.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		panOuest.add(nsub);
//		panOuest.add(tecG);
		pan.add(panOuest, BorderLayout.WEST);
		
		this.setContentPane(pan);
		setVisible(true) ;
		
		tred = new Thread(p);
		tred.start();	
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}
	
	/**
	 * Cette méthode permet d'avoir les informations d'une bête en cliquant dessus 
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX()>384 && e.getX()<984 && e.getY()>36 && e.getY()<636) {
			x = e.getX()-384;
			y = e.getY()-36;
			
			for(int i = 0; i<p.sim.beasts.size();i++) {
				abs = Simulation.beasts.get(i).getPosition().getX()*p.taille;
				ord = Simulation.beasts.get(i).getPosition().getY()*p.taille;
				if(x>abs && x<abs+p.taille && y>ord && y<ord+p.taille) {
					
					JTextArea journal = new JTextArea(Simulation.beasts.get(i).toString());
					JScrollPane scrollPane = new JScrollPane(journal);
					
					
					JFrame jf = new JFrame();
					jf.add(scrollPane);
					jf.setSize(400, 400) ;
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
					jf.setLocationRelativeTo(null);
					
				}
			}
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object Button = e.getSource() ;
		if (Button == start) {
			
			GridPanel.stop = false;
			addFood.setEnabled(true);
			
		}
		
		if (Button==stop) {
			
			GridPanel.stop = true;
			addFood.setEnabled(false);
		}
		
		if(Button==ok) {
			
			JTextArea journal = new JTextArea(Simulation.mort.get(js.getSelectedItem()));
			JScrollPane scrollPane = new JScrollPane(journal);
			JFrame jf = new JFrame();
			jf.add(scrollPane);
			jf.setSize(400, 800) ;
			jf.setVisible(true);
			jf.setLocationRelativeTo(null);
			jf.setLocationRelativeTo(null);
			
		}
		if(Button == addFood) {
			boolean isPut=false;
			while(!isPut && nbfood<(p.rdm*p.rdm)-numberAlive-2) {
				Position pos = new Position((int)(Math.random() * p.rdm),(int)(Math.random() * p.rdm));
				if( !p.grid.getItems().containsKey(pos.toString()) && !p.grid.positions.contains(pos.toString())) {
					int random = (int) (Math.random() * p.grid.fm.size());
					String typefood = p.grid.fm.get(random);
					p.grid.foods.add(new Food(typefood,p.grid.readImage(p.grid.array.get(random)), pos));
					p.grid.getItems().put(p.grid.foods.get(nbfood).getPosition().toString(), p.grid.foods.get(nbfood));
					Interface.nbfood++;
				//	System.out.println(f);
					isPut=true;
				}
			}
		}
	}
}


	
	

