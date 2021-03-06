package gui;

/**
 * Cette classe represente la cr�ation de la fen�tre d'ouverture du jeu
 * O� l'utilisateur pourra entrer les param�tres choisit
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OpenGame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -541698616292452515L;
	private JPanel pan  = new JPanel();
	private JPanel panCenter = new JPanel();
	private JLabel bienvenue = new JLabel("Bienvenue dans notre simulation B�tes");
	private JLabel taille = new JLabel("Quelle taille de grille voulez-vous ?");
	private JLabel bete = new JLabel("Combien de b�tes voulez vous ?");
	private JLabel nourriture = new JLabel("Combien de nourritures voulez vous ?");
	private JLabel environnement = new JLabel("Combien d'environnements voulez vous ?    ");
	private JLabel tour = new JLabel("Combien de tours voulez vous ?");

	JComboBox tour1 = new JComboBox();
	JComboBox taille1 = new JComboBox();
	JComboBox bete1 = new JComboBox();
	JComboBox nourriture1 = new JComboBox();
	JComboBox environnement1 = new JComboBox();
	private JButton start = new JButton("Start");
	
	public OpenGame() {
		build();
	}
	
	
	private void build() {
		
		this.setTitle("Welcome");
		setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
		this.setSize(600, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		pan.setLayout(new BorderLayout());
		
		start.addActionListener(this);
			
		taille1.addActionListener(new ItemAction1());
		bete1.addActionListener(new ItemAction2());
		nourriture1.addActionListener(new ItemAction3());
		environnement1.addActionListener(new ItemAction4());
		tour1.addActionListener(new ItemAction5());
		
		for(int p = 5; p<=100; p = p+5) {
			tour1.addItem(p);
		}
		
		for(int f = 4; f<13; f++) {
			taille1.addItem(f);
		}
		
		for(int i = 2; i<21; i++) {
			bete1.addItem(i);
		}
		
		for(int k = 1; k<31; k++) {
			nourriture1.addItem(k);
		}
		
		for(int l = 1; l<31; l++) {
			environnement1.addItem(l);
		}
		
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(5,2));
		container.add(taille);
		container.add(taille1);
		container.add(bete);
		container.add(bete1);
		container.add(nourriture);
		container.add(nourriture1);
		container.add(environnement);
		container.add(environnement1);
		container.add(tour);
		container.add(tour1);
		container.setBackground(Color.PINK);
		
		JPanel squette = new JPanel();
		squette.setLayout(new GridLayout(2,1));
		squette.add(container);
		squette.add(start);
		
		JPanel titre = new JPanel();
		titre.add(bienvenue);
		titre.setBackground(Color.pink);
		pan.add(titre, BorderLayout.NORTH);
		
		panCenter.setBackground(Color.pink) ;
		panCenter.setSize(1200,700);
		panCenter.add(squette);
		pan.add(panCenter, BorderLayout.CENTER);
		
		this.setContentPane(pan);
		setVisible(true) ;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object Button = e.getSource();
		if (Button == start) {
//			System.out.println("Start");
			if((int)bete1.getSelectedItem() + (int)nourriture1.getSelectedItem() + (int)environnement1.getSelectedItem() <= (int)taille1.getSelectedItem()*(int)taille1.getSelectedItem() ) {
				Interface.p.width = 600-(600%(int)taille1.getSelectedItem());
				Interface.p.taille = 600/(int)taille1.getSelectedItem();
				Interface.p.rdm = (int)taille1.getSelectedItem();
				Interface.nbRound = (int)tour1.getSelectedItem();
				Interface.tt = new JLabel("Nombre tour total : " + (int)tour1.getSelectedItem());
				Interface.nsub = new JLabel("Nombre de subsistances : " + (int)nourriture1.getSelectedItem());
				Interface.nbfood = (int)nourriture1.getSelectedItem();
				Interface.numberAlive = (int)bete1.getSelectedItem();
				Interface.bv = new JLabel("Nombre de bete vivante : " + Interface.numberAlive);
				Interface.numberDead = 0;
				Interface.bm = new JLabel("Nombre de bete morte : " + Interface.numberDead);
				Interface.p = new GridPanel((int)bete1.getSelectedItem(), (int)nourriture1.getSelectedItem(), (int)environnement1.getSelectedItem(), (int)taille1.getSelectedItem());
				new Interface();
				dispose();
			}
			else {
				JFrame jf = new JFrame();
				JLabel error = new JLabel("TROP D'�L�MENTS DANS LA GRILLE !!!");
				JLabel again = new JLabel("VEUILLEZ R�ESSAYER AVEC MOINS D'�L�MENTS");
				error.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
				again.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
				
				JPanel container = new JPanel();
				container.setLayout(new GridLayout(2,1));
				container.add(error);
				container.add(again);
				
				jf.add(container);
				jf.setSize(625, 200) ;
				jf.setVisible(true);
				jf.setResizable(false);
				jf.setLocationRelativeTo(null);
				jf.setLocationRelativeTo(null);
			}
		}
	}
	
	class ItemState implements ItemListener{
	    public void itemStateChanged(ItemEvent e) {
	    	
	    }               
	  }
	
	class ItemAction1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
//		     	System.out.println("La taille est : " + (int)taille1.getSelectedItem());
		    }
	}

	class ItemAction2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
//			System.out.println("Le nombre de b�te est : " + (int)bete1.getSelectedItem());
		}
	}
	
	class ItemAction3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		      
		    }
	}
	
	class ItemAction4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
		}
	}
	
	class ItemAction5 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
		}
	}

	
	
	
}