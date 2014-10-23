import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * la popup qui permet le choix des cartes destinations
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class ChoixDest extends JDialog{
	
	private Bouton3 bouton1;
	private Bouton3 bouton2;
	private Bouton3 bouton3;
	private Bouton3 bouton4;
	private JButton bouton = new JButton("ok");
	private JPanel pan = new JPanel();
	private PiocheDest tab;
	private String ville1 = "";
	private String ville2 ="";
	private ArrayList<CarteDest> cartes;
	private PrisOuPas prisoupas;
	
	/**
	 * le constructeur de la classe 
	 * @param panneau la fenêtre principale
	 * @param pTab la pioche de cartes destinations
	 * @param mainJoueur la main du joueur actuel
	 * @param fenetre la "fenetre" qui gère les tours de jeu
	 */
	public ChoixDest(JFrame panneau,PiocheDest pTab, MainJoueur mainJoueur, Fenetre fenetre)
	{
		super(panneau, "Veuillez choisir vos cartes destinations " + mainJoueur.getNomJoueur(), false);
		this.setSize(1030, 240);
		tab = pTab;
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (57,167,194));
		pan.setBounds(0, 100,900, 200);
		this.ajoutCarteDestIHM(tab);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		pan.add(bouton1 = new Bouton3(cartes.get(0).getVille1(),cartes.get(0).getVille2(),cartes.get(0).getScore()));
		pan.add(bouton2 = new Bouton3(cartes.get(1).getVille1(),cartes.get(1).getVille2(),cartes.get(1).getScore()));
		pan.add(bouton3 = new Bouton3(cartes.get(2).getVille1(),cartes.get(2).getVille2(),cartes.get(2).getScore()));
		int nombre = (int)(Math.random() * 5);
		pan.add(bouton4 = new Bouton3(tab.getB().get(nombre).getVille1(),tab.getB().get(nombre).getVille2(),tab.getB().get(nombre).getScore()));
		
		prisoupas = new PrisOuPas(bouton1,bouton2,bouton3,bouton4);
		
		bouton1.addActionListener(prisoupas);
		bouton2.addActionListener(prisoupas);
		bouton3.addActionListener(prisoupas);
		bouton4.addActionListener(prisoupas);
		
		this.add(pan);
		this.add(bouton);
		
		bouton.addActionListener(new Prendre(prisoupas,cartes,mainJoueur,pTab,this,fenetre));
		
		this.setVisible(true);
	}
	/**
	 * constructeur 2
	 * @param panneau la fenêtre principale
	 * @param pTab la pioche de cartes destinations
	 * @param tabJoueur l'arraylist de mainjoueurs représentant les joueurs 
	 * @param fenetre gestion des interactions de jeu
	 * @param afficherMainJoueur affichage de la main du joueur
	 */
	public ChoixDest(JFrame panneau,PiocheDest pTab, ArrayList<MainJoueur> tabJoueur, Fenetre fenetre,AfficherMainJoueur afficherMainJoueur)//main joueur
	{
		super(panneau, "Veuillez choisir vos cartes destinations " + tabJoueur.get(fenetre.getNumeroJoueur()).getNomJoueur(), false);
		this.setSize(765, 240);
		tab = pTab;
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (57,167,194));
		pan.setBounds(0, 100,700, 200);
		this.ajoutCarteDestIHM(tab);
		
		this.setLayout(new FlowLayout());
		
		pan.add(bouton1 = new Bouton3(cartes.get(0).getVille1(),cartes.get(0).getVille2(),cartes.get(0).getScore()));
		pan.add(bouton2 = new Bouton3(cartes.get(1).getVille1(),cartes.get(1).getVille2(),cartes.get(1).getScore()));
		pan.add(bouton3 = new Bouton3(cartes.get(2).getVille1(),cartes.get(2).getVille2(),cartes.get(2).getScore()));

		
		prisoupas = new PrisOuPas(bouton1,bouton2,bouton3,null);
		
		bouton1.addActionListener(prisoupas);
		bouton2.addActionListener(prisoupas);
		bouton3.addActionListener(prisoupas);
		
		
		this.add(pan);
		this.add(bouton);
		
		bouton.addActionListener(new Prendre(prisoupas,cartes,tabJoueur,pTab,this,fenetre,afficherMainJoueur));
		
		this.setVisible(true);
	}

	/**
	 * méthode d'ajout d'une carte destination à l'affichage  
	 * @param pioche la pioche de cartes destinations
	 */
	public void ajoutCarteDestIHM(PiocheDest pioche){
		cartes = new ArrayList<CarteDest>();
		int j = 0;
			while( j < 3 && !pioche.getA().isEmpty() )
			{
				cartes.add(pioche.PiocherCarte());
				j++;
			}		
		}
}
