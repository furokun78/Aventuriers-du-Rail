import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * la classe qui permet de prendre une carte destination
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class Prendre implements ActionListener {

	private PrisOuPas prisoupas;
	private ArrayList<CarteDest> cartes;
	private ArrayList<CarteDest> tabDestJoueur;
	private PiocheDest pioche;
	private JDialog popup;
	private Fenetre fenetre;
	private ArrayList<MainJoueur> tabJoueur;
	private AfficherMainJoueur afficherMainJoueur;
	
	/**
	 * constructeur de la classe 
	 * @param prisoupas le bouton est il sélectionné
	 * @param cartes l'arraylist de cartes destination que l'on peut prendre
	 * @param mainJoueur la main actuelle du joueur
	 * @param pioche la pioche de cartes destinations
	 * @param popup la popup demandant le choix des cartes
	 * @param fenetre la gestion du jeu
	 */
	public Prendre(PrisOuPas prisoupas, ArrayList<CarteDest> cartes,MainJoueur mainJoueur,PiocheDest pioche,JDialog popup,Fenetre fenetre)
	{
		this.prisoupas = prisoupas;
		this.cartes = cartes;
		this.tabDestJoueur= mainJoueur.getB();
		this.pioche = pioche;
		this.popup = popup;
		this.fenetre= fenetre;
		this.tabJoueur = tabJoueur;
	}

	public Prendre(PrisOuPas prisoupas, ArrayList<CarteDest> cartes,ArrayList<MainJoueur> tabJoueur,PiocheDest pioche,JDialog popup,Fenetre fenetre,AfficherMainJoueur afficherMainJoueur)
	{
		this.prisoupas = prisoupas;
		this.cartes = cartes;
		this.tabDestJoueur= tabJoueur.get(fenetre.getNumeroJoueur()).getB();
		this.pioche = pioche;
		this.popup = popup;
		this.fenetre= fenetre;
		this.tabJoueur = tabJoueur;
		this.afficherMainJoueur = afficherMainJoueur;
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		if(prisoupas.getNb1() == 0 && prisoupas.getNb2() == 0 && prisoupas.getNb3() == 0){
			JOptionPane.showConfirmDialog(popup,

		            "Vous devez au moins sélectionner une carte", "erreur",

		            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			if(prisoupas.getNb1() == 1) {tabDestJoueur.add(cartes.get(0));}
			else{pioche.getA().add(cartes.get(0));}
			
			if(prisoupas.getNb2() == 1) {
				tabDestJoueur.add(cartes.get(1));
			}
			else{pioche.getA().add(cartes.get(1));}
			
			if(prisoupas.getNb3() == 1) {
				tabDestJoueur.add(cartes.get(2));
			}
			else{pioche.getA().add(cartes.get(2));}
	
			if(fenetre != null){
				if(fenetre.getNumeroJoueur() < tabJoueur.size() -1)
				{
					fenetre.setNumeroJoueur(fenetre.getNumeroJoueur() + 1);
				}
				else{fenetre.setNumeroJoueur(0);}
				fenetre.getPannel().repaint(358,566,628,149);
				fenetre.getCarteDest().setCarteDest(tabJoueur.get(fenetre.getNumeroJoueur()).getB());
				fenetre.getCarteDest().modifListeVille(tabJoueur.get(fenetre.getNumeroJoueur()).getB());
				if(afficherMainJoueur != null){afficherMainJoueur.setTabJoueur(tabJoueur.get(fenetre.getNumeroJoueur()).getA());afficherMainJoueur.setNomJoueur(tabJoueur.get(fenetre.getNumeroJoueur()).getNomJoueur());}
				fenetre.getCarteDest().repaint();
				
			}
			popup.setVisible(false);
		}
	}

}
