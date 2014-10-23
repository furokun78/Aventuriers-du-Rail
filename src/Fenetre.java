import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * la classe qui gère les interactions entre les différents éléments de la fenêtre et le tour de jeu
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */


public class Fenetre {

	private AfficherEurope afficherEurope;
	private AfficherScoreJoueurs afficherScoreJoueurs;
	private AfficherMainJoueur afficherMainJoueur;
	private ArrayList<ImageAfficher> image = new ArrayList<ImageAfficher>();
	private int numeroJoueur = 0;
	private int rejouer = 0;
	private Pan pannel;
	private Bouton4 bouton1;
	private Bouton4 bouton2;
	private Bouton4 bouton3;
	private Bouton4 bouton4;
	private Bouton4 bouton5;
	private Bouton5 dosCarte;
	private Bouton2 dosCarteDest;
	private Bouton carteDest;
	private Plateau terrain;
	private Animation animation;
	private DessinerRectangle dessinerRectangle;
	private JFrame panneau;
	
	
	public JFrame getPanneau() {
		return panneau;
	}

	public void setPanneau(JFrame panneau) {
		this.panneau = panneau;
	}
/**
 * constructeur de la classe fenêtre
 * @param tabVisible les cartes visibles que l'on peut afficher
 * @param tabJoueur l'arraylist de main joueur contenant tous les joueurs 
 * @param tabDest la pioche de cartes destinations
 * @param piocheCarteWagon la pioche de cartes wagons
 * @param terrain le terrain de jeu (HashMap de Hashmap) muni de toutes les propriétés
 */
	public Fenetre(CartesVisible tabVisible, ArrayList<MainJoueur> tabJoueur, PiocheDest tabDest, PiocheWagon piocheCarteWagon, Plateau terrain)
	{
		panneau = new JFrame();
		panneau.setTitle("Les aventuriers du rail");
		panneau.setSize(1000, 750);
		panneau.setLocationRelativeTo(null);
		panneau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.terrain = terrain;
		
		afficherEurope = new AfficherEurope();
		afficherScoreJoueurs = new AfficherScoreJoueurs(tabJoueur);
		afficherMainJoueur = new AfficherMainJoueur(tabJoueur.get(numeroJoueur).getA(),tabJoueur.get(numeroJoueur).getNomJoueur());
		panneau.setLayout(null);
		
		bouton1 = new Bouton4(tabVisible.getA().get(0).getCouleur());
		bouton2 = new Bouton4(tabVisible.getA().get(1).getCouleur());
		bouton3 = new Bouton4(tabVisible.getA().get(2).getCouleur());
		bouton4 = new Bouton4(tabVisible.getA().get(3).getCouleur());
		bouton5 = new Bouton4(tabVisible.getA().get(4).getCouleur());
		dosCarte = new Bouton5();
		dosCarteDest = new Bouton2();
		carteDest = new Bouton(tabJoueur.get(numeroJoueur).getB());
		animation = new Animation(panneau,this);
		dessinerRectangle = new DessinerRectangle();

		
		
		bouton1.setBounds(30, 20, 104, 68);
		bouton2.setBounds(30, 88, 104, 68);
		bouton3.setBounds(30, 156, 104, 68);
		bouton4.setBounds(30, 224, 104, 68);
		bouton5.setBounds(30, 292, 104, 68);
		dosCarte.setBounds(30, 360, 104, 68);
		dosCarteDest.setBounds(13, 440,142,94);
		carteDest.setBounds(195,589,150,101);
		
		panneau.add(bouton1);
		panneau.add(bouton2);
		panneau.add(bouton3);
		panneau.add(bouton4);
		panneau.add(bouton5);
		panneau.add(dosCarte);
		panneau.add(dosCarteDest);
		panneau.add(carteDest);
		
		dosCarteDest.addActionListener(new EcouteurBouton(panneau, tabDest, tabJoueur,carteDest,dosCarteDest,this,afficherMainJoueur));
		carteDest.addActionListener(new EcouteurBouton(panneau, tabDest, tabJoueur,carteDest,dosCarteDest,this,afficherMainJoueur));

		image.add(afficherEurope);
		image.add(afficherScoreJoueurs);
		image.add(animation);
		image.add(afficherMainJoueur);
		image.add(dessinerRectangle);

		
		pannel = new Pan(image,tabJoueur.get(numeroJoueur),terrain,piocheCarteWagon,this,tabJoueur,afficherMainJoueur,dessinerRectangle);

		pannel.setBounds(0,0,1000,750);

		bouton1.addActionListener(new EcouteurBoutonWagon(bouton1,bouton2,bouton3,bouton4,bouton5,dosCarte,animation,pannel,piocheCarteWagon, tabVisible,tabJoueur.get(numeroJoueur).getA(), this,tabJoueur,afficherMainJoueur));
		bouton2.addActionListener(new EcouteurBoutonWagon(bouton1,bouton2,bouton3,bouton4,bouton5,dosCarte,animation,pannel,piocheCarteWagon, tabVisible,tabJoueur.get(numeroJoueur).getA(), this,tabJoueur,afficherMainJoueur));
		bouton3.addActionListener(new EcouteurBoutonWagon(bouton1,bouton2,bouton3,bouton4,bouton5,dosCarte,animation,pannel,piocheCarteWagon, tabVisible,tabJoueur.get(numeroJoueur).getA(), this,tabJoueur,afficherMainJoueur));
		bouton4.addActionListener(new EcouteurBoutonWagon(bouton1,bouton2,bouton3,bouton4,bouton5,dosCarte,animation,pannel,piocheCarteWagon, tabVisible,tabJoueur.get(numeroJoueur).getA(), this,tabJoueur,afficherMainJoueur));
		bouton5.addActionListener(new EcouteurBoutonWagon(bouton1,bouton2,bouton3,bouton4,bouton5,dosCarte,animation,pannel,piocheCarteWagon, tabVisible,tabJoueur.get(numeroJoueur).getA(), this,tabJoueur,afficherMainJoueur));
		dosCarte.addActionListener(new EcouteurBoutonWagon(bouton1,bouton2,bouton3,bouton4,bouton5,dosCarte,animation,pannel,piocheCarteWagon, tabVisible,tabJoueur.get(numeroJoueur).getA(), this,tabJoueur,afficherMainJoueur));
		
		panneau.add(pannel);
		panneau.add(animation);
		
		terrain.setFenetre(this);

		panneau.setVisible(true);
	}

	public int getRejouer() {
		return rejouer;
	}

	public void setRejouer(int rejouer) {
		this.rejouer = rejouer;
	}

	public int getNumeroJoueur() {
		return numeroJoueur;
	}

	public Pan getPannel() {
		return pannel;
	}

	public void setPannel(Pan pannel) {
		this.pannel = pannel;
	}
	
	public Bouton getCarteDest() {
		return carteDest;
	}

	public AfficherMainJoueur getAfficherMainJoueur() {
		return afficherMainJoueur;
	}

	public void setAfficherMainJoueur(AfficherMainJoueur afficherMainJoueur) {
		this.afficherMainJoueur = afficherMainJoueur;
	}

	public void setCarteDest(Bouton carteDest) {
		this.carteDest = carteDest;
	}
	
	public void setNumeroJoueur(int numeroJoueur) {
		this.numeroJoueur = numeroJoueur;
	}

	
}
