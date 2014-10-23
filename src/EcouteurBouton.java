import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * l'écouteur lié à au bouton
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */


public class EcouteurBouton implements ActionListener{

	private ArrayList<MainJoueur> tabJoueur;
	private PiocheDest tabDest;
	private JFrame panneau;
	private Bouton bouton1;
	private Bouton2 bouton2;
	private int nombre = 0;
	private Fenetre fenetre;
	private AfficherMainJoueur afficherMainJoueur ;
	
	/**
	 * constructeur du Ecouteur Bouton
	 * @param panneau la frame principale
	 * @param tabDest l'arraylist de cartes destinations représentant la pioche
	 * @param tabJoueur l'arraylist de mainjoueur
	 * @param bouton1 le bouton sur lequel on a cliqué
	 * @param bouton2 le bouton sur lequel on a cliqué
	 * @param fenetre la fenêtre gérant toutes les interactions principales
	 * @param afficherMainJoueur afficher la main du joueur
	 */
	public EcouteurBouton(JFrame panneau, PiocheDest tabDest,ArrayList<MainJoueur> tabJoueur,Bouton bouton1,Bouton2 bouton2,Fenetre fenetre,AfficherMainJoueur afficherMainJoueur )
	{
		this.tabJoueur = tabJoueur;
		this.tabDest = tabDest;
		this.panneau = panneau;
		this.bouton1 = bouton1;
		this.bouton2 = bouton2;
		this.fenetre= fenetre;
		this.afficherMainJoueur = afficherMainJoueur;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bouton1)
		{
			if(nombre < tabJoueur.get(fenetre.getNumeroJoueur()).getB().size() -1){
				nombre++;
			}
			else{nombre = 0;}
			bouton1.setVille1(tabJoueur.get(fenetre.getNumeroJoueur()).getB().get(nombre).getVille1());
			bouton1.setVille2(tabJoueur.get(fenetre.getNumeroJoueur()).getB().get(nombre).getVille2());
			bouton1.setPoints(tabJoueur.get(fenetre.getNumeroJoueur()).getB().get(nombre).getScore());
			bouton1.repaint();
		}
		else if(arg0.getSource() == bouton2)
		{
			ChoixDest choix = new ChoixDest(panneau, tabDest,tabJoueur, fenetre,afficherMainJoueur);
		}
		
	}
	
}
