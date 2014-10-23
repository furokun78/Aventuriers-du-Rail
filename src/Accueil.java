import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

/**
 * la classe permettant de créer la fenêtre d'accueil avec le choix des paramètres de jeu
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class Accueil extends JFrame
{

	PiocheWagon piocheCarteWagon;
	PiocheDest piocheCarteDest; 
	CartesVisible piocheCarteVisible;
	ArrayList<MainJoueur> tabJoueur; 
	Plateau terrain;

	/**
	 * le constructeur de la fenêtre
	 * @param titre titre de la fenêtre
	 * @param mode le mode de la fenêtre
	 * @param piocheCarteWagon la pioche de cartes Wagon
	 * @param piocheCarteDest la pioche de cartes destinations
	 * @param piocheCarteVisible la pioche de cartes visibles
	 * @param tabJoueur une arraylist contenant tous les joueurs
	 * @param terrain le plateau de jeu (HashMap de Hashmap
	 */
	Accueil(String titre, int mode, PiocheWagon piocheCarteWagon, PiocheDest piocheCarteDest, 
			CartesVisible piocheCarteVisible, ArrayList<MainJoueur> tabJoueur, Plateau terrain)
	{	
		
		super(titre);
		this.piocheCarteDest = piocheCarteDest;
		this.piocheCarteVisible = piocheCarteVisible;
		this.piocheCarteWagon = piocheCarteWagon;
		this.tabJoueur = tabJoueur;
		this.terrain = terrain;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,750);
		this.setLocationRelativeTo(null);
		JPanel jp = new imageFond("accueil final.jpg");
		this.setContentPane(jp);
		
		//Le nom
		JPanel panNom = new JPanel();
		panNom.setOpaque(false);
		panNom.setPreferredSize(new Dimension(220, 60));
		JTextField nom = new JTextField("");
		nom.setPreferredSize(new Dimension(100, 25));
		panNom.setBorder(BorderFactory.createTitledBorder("Nom du joueur"));
		JLabel nomLabel = new JLabel("Saisir un nom :");
		panNom.add(nomLabel);
		panNom.add(nom);
		panNom.setBounds(280, 100, 210, 70);
		
		//La couleur
		JPanel pancouleur = new JPanel();
		pancouleur.setOpaque(false);
		pancouleur.setPreferredSize(new Dimension(220, 60));
		pancouleur.setBorder(BorderFactory.createTitledBorder("couleur du joueur"));
		JComboBox couleur = new JComboBox();
		couleur.addItem("jaune");
		couleur.addItem("vert");
		couleur.addItem("orange");
		couleur.addItem("noir");
		couleur.addItem("blanc");
		couleur.addItem("violet");
		couleur.addItem("rouge");
		couleur.addItem("bleu");
		JLabel couleurLabel = new JLabel("couleur : ");
		pancouleur.add(couleurLabel);
		pancouleur.add(couleur);
		pancouleur.setBounds(500, 100, 200, 70);
		
		
		// Le JPanel contenant la box le nom la couleur
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(panNom);
		content.add(pancouleur);
		
		// Les JButton du bas de la fenêtre
		Color orange = new Color(232,158,110);
		Color black = new Color (0,0,0);
		JButton Ajouter= new JButton("Ajouter un joueur");
		Ajouter.setForeground(black);
		Ajouter.setBackground(orange);
		Ajouter.addActionListener(new EcouteurBoutonAjouter(this, Ajouter, couleur, nom, tabJoueur, piocheCarteWagon,piocheCarteDest));
		JButton Lancer = new JButton("Lancer la partie");
		Lancer.setForeground(black);
		Lancer.setBackground(orange);
		Lancer.addActionListener(new EcouteurBoutonLancer(this, Lancer, piocheCarteWagon, piocheCarteDest, 
				 piocheCarteVisible, tabJoueur, terrain ));
		JButton Quitter = new JButton("  Règles du Jeu   ");
		Quitter.setBackground(orange);
		Quitter.setForeground(black);
		Quitter.addActionListener(new EcouteurBoutonRegles(Quitter, this));
		
		JPanel controler = new JPanel();
		controler.setLayout(new FlowLayout());
		controler.add(Ajouter);
		controler.add(Lancer);
		controler.add(Quitter);
		controler.setOpaque(false);
		controler.setBounds(290, 300, 400,100);
		
	
		this.setLayout(null);
		this.add(panNom);
		this.add(pancouleur);
		this.add(controler);
		
		
		this.setVisible(true);
	}



}