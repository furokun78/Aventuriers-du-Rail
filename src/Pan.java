import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


/**
 * la classe qui gère principalement le tour de jeu et qui permet les interactions plateau clic de la souris
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class Pan extends JPanel implements MouseListener{
	private ArrayList<ImageAfficher> tab;
	private String ville1 = "";
	private String ville2 = "";
	private int pVille1 = 0;
	private int pVille2 = 0;
	private MainJoueur mainJoueur;
	private Plateau plateau;
	private PiocheWagon pioche;
	private Fenetre fenetre;
	private ArrayList<MainJoueur> tabJoueur;
	private AfficherMainJoueur afficherMainJoueur;
	private DessinerRectangle dessinerRectangle;
	private int jouer = 0;
	
	/**
	 * constructeur de la classe 
	 * @param pTab liste des différents éléments à afficher
	 * @param main la main du joueur 
	 * @param plateau le plateau de jeu
	 * @param pioche la pioche de cartes wagons
	 * @param fenetre la classe fenetre gérant les interactions autour du plateau
	 * @param tabJoueur l'arraylist de mainjoueur représentant les joueurs avec leurs caractéristiques
	 * @param afficherMainJoueur l'affichage de la main du joueur
	 * @param dessinerRectangle le paramètre permettant de dessiner des rectangle sur le plateau
	 */
	public Pan(ArrayList<ImageAfficher> pTab, MainJoueur main, Plateau plateau, PiocheWagon pioche,Fenetre fenetre,ArrayList<MainJoueur> tabJoueur,AfficherMainJoueur afficherMainJoueur,DessinerRectangle dessinerRectangle)
	{
		tab = pTab;
		mainJoueur = main;
		this.plateau = plateau;
		this.pioche = pioche;
		this.addMouseListener(this);
		this.fenetre = fenetre;
		this.tabJoueur = tabJoueur;
		this.afficherMainJoueur = afficherMainJoueur;
		this.dessinerRectangle = dessinerRectangle;
	}
	
    protected void paintComponent(Graphics gr)
    {
        for (int i=0;i<tab.size();i++)
        {

            tab.get(i).dessiner(gr);
        }
    }
    
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getX() > 305 && arg0.getX() < 360 && arg0.getY() > 280 && arg0.getY() < 294){
			if(pVille1 == 0)
			{
				ville1 = "Paris";
				pVille1 = 1;
			}
			else{
				ville2 = "Paris";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 230 && arg0.getX() < 315 && arg0.getY() > 385 && arg0.getY() < 410){
			if(pVille1 == 0)
			{
				ville1 = "Pamplona";
				pVille1 = 1;
			}
			else{
				ville2 = "Pamplona";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		

		
		if(arg0.getX() > 190 && arg0.getX() < 251 && arg0.getY() > 440 && arg0.getY() < 458){
			if(pVille1 == 0)
			{
				ville1 = "Madrid";
				pVille1 = 1;
			}
			else{
				ville2 = "Madrid";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}

		
		if(arg0.getX() > 195 && arg0.getX() < 250 && arg0.getY() > 495 && arg0.getY() < 510){
			if(pVille1 == 0)
			{
				ville1 = "Lisboa";
				pVille1 = 1;
			}
			else{
				ville2 = "Lisboa";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 215 && arg0.getX() < 265 && arg0.getY() > 525 && arg0.getY() < 540){
			if(pVille1 == 0)
			{
				ville1 = "Cadiz";
				pVille1 = 1;
			}
			else{
				ville2 = "Cadiz";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		
		
		
		
		if(arg0.getX() > 325 && arg0.getX() < 405 && arg0.getY() > 500 && arg0.getY() < 515){
			if(pVille1 == 0)
			{
				ville1 = "Barcelona";
				pVille1 = 1;
			}
			else{
				ville2 = "Barcelona";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 205 && arg0.getX() < 255 && arg0.getY() > 255 && arg0.getY() < 270){
			if(pVille1 == 0)
			{
				ville1 = "Brest";
				pVille1 = 1;
			}
			else{
				ville2 = "Brest";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 265 && arg0.getX() < 325 && arg0.getY() > 215 && arg0.getY() < 230){
			if(pVille1 == 0)
			{
				ville1 = "Dieppe";
				pVille1 = 1;
			}
			else{
				ville2 = "Dieppe";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 265 && arg0.getX() < 332 && arg0.getY() > 155 && arg0.getY() < 170){
			if(pVille1 == 0)
			{
				ville1 = "London";
				pVille1 = 1;
			}
			else{
				ville2 = "London";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 225 && arg0.getX() < 315 && arg0.getY() > 5 && arg0.getY() < 20){
			if(pVille1 == 0)
			{
				ville1 = "Edimburgh";
				pVille1 = 1;
			}
			else{
				ville2 = "Edimburgh";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 435 && arg0.getX() < 515 && arg0.getY() > 415 && arg0.getY() < 432){
			if(pVille1 == 0)
			{
				ville1 = "Marseille";
				pVille1 = 1;
			}
			else{
				ville2 = "Marseille";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 415 && arg0.getX() < 475 && arg0.getY() > 305 && arg0.getY() < 320){
			if(pVille1 == 0)
			{
				ville1 = "Zurich";
				pVille1 = 1;
			}
			else{
				ville2 = "Zurich";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 405 && arg0.getX() < 460 && arg0.getY() > 215 && arg0.getY() < 245){
			if(pVille1 == 0)
			{
				ville1 = "Franckfurt";
				pVille1 = 1;
			}
			else{
				ville2 = "Franckfurt";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 355 && arg0.getX() < 405 && arg0.getY() > 170 && arg0.getY() < 200){
			if(pVille1 == 0)
			{
				ville1 = "Bruxelles";
				pVille1 = 1;
			}
			else{
				ville2 = "Bruxelles";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 450 && arg0.getX() < 500 && arg0.getY() > 175 && arg0.getY() < 190){
			if(pVille1 == 0)
			{
				ville1 = "Essen";
				pVille1 = 1;
			}
			else{
				ville2 = "Essen";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 355 && arg0.getX() < 420 && arg0.getY() > 130 && arg0.getY() < 155){
			if(pVille1 == 0)
			{
				ville1 = "Amsterdam";
				pVille1 = 1;
			}
			else{
				ville2 = "Amsterdam";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 510 && arg0.getX() < 570 && arg0.getY() > 150 && arg0.getY() < 165){
			if(pVille1 == 0)
			{
				ville1 = "Berlin";
				pVille1 = 1;
			}
			else{
				ville2 = "Berlin";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 510 && arg0.getX() < 590 && arg0.getY() > 250 && arg0.getY() < 265){
			if(pVille1 == 0)
			{
				ville1 = "Munchen";
				pVille1 = 1;
			}
			else{
				ville2 = "Munchen";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 535 && arg0.getX() < 600 && arg0.getY() > 325 && arg0.getY() < 340){
			if(pVille1 == 0)
			{
				ville1 = "Venezia";
				pVille1 = 1;
			}
			else{
				ville2 = "Venezia";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 610 && arg0.getX() < 665 && arg0.getY() > 364 && arg0.getY() < 379){
			if(pVille1 == 0)
			{
				ville1 = "Zagrab";
				pVille1 = 1;
			}
			else{
				ville2 = "Zagrab";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 620 && arg0.getX() < 670 && arg0.getY() > 387 && arg0.getY() < 416){
			if(pVille1 == 0)
			{
				ville1 = "Sarajevo";
				pVille1 = 1;
			}
			else{
				ville2 = "Sarajevo";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 610 && arg0.getX() < 670 && arg0.getY() > 435 && arg0.getY() < 450){
			if(pVille1 == 0)
			{
				ville1 = "Brindisi";
				pVille1 = 1;
			}
			else{
				ville2 = "Brindisi";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 500 && arg0.getX() < 570 && arg0.getY() > 545 && arg0.getY() < 560){
			if(pVille1 == 0)
			{
				ville1 = "Palermo";
				pVille1 = 1;
			}
			else{
				ville2 = "Palermo";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 510 && arg0.getX() < 550 && arg0.getY() > 440 && arg0.getY() < 455){
			if(pVille1 == 0)
			{
				ville1 = "Roma";
				pVille1 = 1;
			}
			else{
				ville2 = "Roma";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 668 && arg0.getX() < 750 && arg0.getY() > 290 && arg0.getY() < 305){
			if(pVille1 == 0)
			{
				ville1 = "Budapest";
				pVille1 = 1;
			}
			else{
				ville2 = "Budapest";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 600 && arg0.getX() < 645 && arg0.getY() > 248 && arg0.getY() < 263){
			if(pVille1 == 0)
			{
				ville1 = "Wien";
				pVille1 = 1;
			}
			else{
				ville2 = "Wien";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 612 && arg0.getX() < 670 && arg0.getY() > 120 && arg0.getY() < 135){
			if(pVille1 == 0)
			{
				ville1 = "Danzig";
				pVille1 = 1;
			}
			else{
				ville2 = "Danzig";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 550 && arg0.getX() < 640 && arg0.getY() > 80 && arg0.getY() < 95){
			if(pVille1 == 0)
			{
				ville1 = "Kobenhavn";
				pVille1 = 1;
			}
			else{
				ville2 = "Kobenhavn";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 518 && arg0.getX() < 605 && arg0.getY() > 0&& arg0.getY() < 15){
			if(pVille1 == 0)
			{
				ville1 = "Stockholm";
				pVille1 = 1;
			}
			else{
				ville2 = "Stockholm";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		
		
		
		if(arg0.getX() > 735 && arg0.getX() < 775 && arg0.getY() > 40 && arg0.getY() < 55){
			if(pVille1 == 0)
			{
				ville1 = "Riga";
				pVille1 = 1;
			}
			else{
				ville2 = "Riga";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 870 && arg0.getX() < 960 && arg0.getY() > 15 && arg0.getY() < 30){
			if(pVille1 == 0)
			{
				ville1 = "Petrograd";
				pVille1 = 1;
			}
			else{
				ville2 = "Petrograd";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 878 && arg0.getX() < 940 && arg0.getY() > 124 && arg0.getY() < 139){
			if(pVille1 == 0)
			{
				ville1 = "Moskva";
				pVille1 = 1;
			}
			else{
				ville2 = "Moskva";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 810 && arg0.getX() < 860 && arg0.getY() > 150 && arg0.getY() < 165){
			if(pVille1 == 0)
			{
				ville1 = "Wilno";
				pVille1 = 1;
			}
			else{
				ville2 = "Wilno";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 715 && arg0.getX() < 790 && arg0.getY() > 170 && arg0.getY() < 185){
			if(pVille1 == 0)
			{
				ville1 = "Warszawa";
				pVille1 = 1;
			}
			else{
				ville2 = "Warszawa";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 830 && arg0.getX() < 865 && arg0.getY() > 200 && arg0.getY() < 215){
			if(pVille1 == 0)
			{
				ville1 = "Kyiv";
				pVille1 = 1;
			}
			else{
				ville2 = "Kyiv";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 890 && arg0.getX() < 945 && arg0.getY() > 165 && arg0.getY() < 200){
			if(pVille1 == 0)
			{
				ville1 = "Smolensk";
				pVille1 = 1;
			}
			else{
				ville2 = "Smolensk";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 860 && arg0.getX() < 940 && arg0.getY() > 250 && arg0.getY() < 265){
			if(pVille1 == 0)
			{
				ville1 = "Kharkov";
				pVille1 = 1;
			}
			else{
				ville2 = "Kharkov";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 905 && arg0.getX() < 965 && arg0.getY() > 315 && arg0.getY() < 330){
			if(pVille1 == 0)
			{
				ville1 = "Rostov";
				pVille1 = 1;
			}
			else{
				ville2 = "Rostov";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 680 && arg0.getX() < 770 && arg0.getY() > 370 && arg0.getY() < 385){
			if(pVille1 == 0)
			{
				ville1 = "Bucuresti";
				pVille1 = 1;
			}
			else{
				ville2 = "Bucuresti";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 750 && arg0.getX() < 890 && arg0.getY() > 375 && arg0.getY() < 390){
			if(pVille1 == 0)
			{
				ville1 = "Sevastopol";
				pVille1 = 1;
			}
			else{
				ville2 = "Sevastopol";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 905 && arg0.getX() < 960 && arg0.getY() > 395 && arg0.getY() < 415){
			if(pVille1 == 0)
			{
				ville1 = "Sochi";
				pVille1 = 1;
			}
			else{
				ville2 = "Sochi";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 750 && arg0.getX() < 795 && arg0.getY() > 415 && arg0.getY() < 430){
			if(pVille1 == 0)
			{
				ville1 = "Sofia";
				pVille1 = 1;
			}
			else{
				ville2 = "Sofia";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 718 && arg0.getX() < 775 && arg0.getY() > 500 && arg0.getY() < 515){
			if(pVille1 == 0)
			{
				ville1 = "Athena";
				pVille1 = 1;
			}
			else{
				ville2 = "Athena";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 795 && arg0.getX() < 855 && arg0.getY() > 525 && arg0.getY() < 540){
			if(pVille1 == 0)
			{
				ville1 = "Smyrna";
				pVille1 = 1;
			}
			else{
				ville2 = "Smyrna";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 867 && arg0.getX() < 930 && arg0.getY() > 546 && arg0.getY() < 561){
			if(pVille1 == 0)
			{
				ville1 = "Angora";
				pVille1 = 1;
			}
			else{
				ville2 = "Angora";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 875 && arg0.getX() < 945 && arg0.getY() > 502 && arg0.getY() < 517){
			if(pVille1 == 0)
			{
				ville1 = "Erzurum";
				pVille1 = 1;
			}
			else{
				ville2 = "Erzurum";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}
		if(arg0.getX() > 828 && arg0.getX() < 910 && arg0.getY() > 465 && arg0.getY() < 492){
			if(pVille1 == 0)
			{
				ville1 = "Constantinople";
				pVille2 = 1;
			}
			else{
				ville2 = "Constantinople";
				pVille2 = 1;
			}
			System.out.println(ville1);
			System.out.println(ville2);
		}	
		
		if(pVille1 == 1 && pVille2 == 1)
		{
			if(ville1.equals(ville2))
			{
				plateau.construireGare(ville1, ville2, mainJoueur);
			}
			else{
				plateau.setDessinerRectangle(dessinerRectangle);
				plateau.acheter(ville1, ville2, mainJoueur, pioche);
				plateau.acheter(ville2, ville1, mainJoueur, pioche);
			}
			if(fenetre.getNumeroJoueur() < tabJoueur.size() -1)
			{
				fenetre.setNumeroJoueur(fenetre.getNumeroJoueur() + 1);
			}
			if(fenetre.getNumeroJoueur() < tabJoueur.size() -1)
			{
				fenetre.setNumeroJoueur(fenetre.getNumeroJoueur() + 1);
			}
			else{fenetre.setNumeroJoueur(0);}
			fenetre.getCarteDest().setCarteDest(tabJoueur.get(fenetre.getNumeroJoueur()).getB());
			fenetre.getCarteDest().modifListeVille(tabJoueur.get(fenetre.getNumeroJoueur()).getB());
			fenetre.getCarteDest().repaint();
			fenetre.setRejouer(0);
			afficherMainJoueur.setTabJoueur(tabJoueur.get(fenetre.getNumeroJoueur()).getA());
			afficherMainJoueur.setNomJoueur(tabJoueur.get(fenetre.getNumeroJoueur()).getNomJoueur());
			fenetre.getPannel().repaint(358,566,628,149);
			
			tabJoueur.get(fenetre.getNumeroJoueur()).getScore().scoreCourant(tabJoueur.get(fenetre.getNumeroJoueur()).getNomJoueur(), plateau);
			fenetre.getPannel().repaint(172,0,815,565);
		}
		for (int i=0; i<tabJoueur.size(); i++){
			if (tabJoueur.get(i).getA().size() < 1){
				jouer = -1;
			}
		}
		if (jouer == -1){
			new Final(fenetre.getPanneau(), tabJoueur, plateau);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
