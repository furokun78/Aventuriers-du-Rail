import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;




public class EcouteurBoutonWagon implements ActionListener{
	
	private Bouton4 bouton1;
	private Bouton4 bouton2;
	private Bouton4 bouton3;
	private Bouton4 bouton4;
	private Bouton4 bouton5;
	private Bouton5 dosCarte;
	private Animation animation;
	private Pan pan;
	//private int rejouer = 0;
	private CartesVisible piocheVisible;
	private PiocheWagon piocheCarteWagon;
	private ArrayList<CarteWagon> mainJoueur;
	private Fenetre fenetre;
	private ArrayList<MainJoueur> tabJoueur;
	private AfficherMainJoueur afficherMainJoueur;

	
	public EcouteurBoutonWagon(Bouton4 bouton1, Bouton4 bouton2, Bouton4 bouton3, Bouton4 bouton4, Bouton4 bouton5,Bouton5 dosCarte, Animation animation, Pan pan,PiocheWagon piocheCarteWagon, CartesVisible piocheVisible, ArrayList<CarteWagon> mainJoueur,Fenetre fenetre,ArrayList<MainJoueur> tabJoueur,AfficherMainJoueur afficherMainJoueur )
	{
		for(int i = 0; i < mainJoueur.size() ; i++){
		mainJoueur.get(i).getCouleur();
		}
		this.bouton1 = bouton1;
		this.bouton2 = bouton2;
		this.bouton3 = bouton3;
		this.bouton4 = bouton4;
		this.bouton5 = bouton5;
		this.animation = animation;
		this.pan = pan;
		this.piocheVisible = piocheVisible;
		this.piocheCarteWagon = piocheCarteWagon;
		this.dosCarte = dosCarte;
		System.out.println("On est dans le tour du joueur : "+fenetre.getNumeroJoueur());
		this.mainJoueur = tabJoueur.get(fenetre.getNumeroJoueur()).getA();
		System.out.println("Constructeur, Main du joueur "+fenetre.getNumeroJoueur()+" : "+this.mainJoueur);
		this.fenetre = fenetre;
		this.tabJoueur = tabJoueur;
		this.afficherMainJoueur =  afficherMainJoueur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.mainJoueur = tabJoueur.get(fenetre.getNumeroJoueur()).getA();
		if(e.getSource() == bouton1)
		{
			if(fenetre.getRejouer() < 2)
			{
				if(!(fenetre.getRejouer()  == 1 && bouton1.getCouleur().equals("locomotive")))
				{
					if(bouton1.getCouleur().equals("locomotive"))
					{
						fenetre.setRejouer(2);
					}
					else{fenetre.setRejouer(fenetre.getRejouer() +1);}
					
				mainJoueur.add(piocheVisible.getA().get(0));
				System.out.println("actionPerformed du bouton 1, Main du joueur "+fenetre.getNumeroJoueur()+" : "+this.mainJoueur);
				piocheVisible.getA().set(0, piocheCarteWagon.PiocherCarte());
				piocheVisible.gestNbTrain();
				bouton1.setCouleur(piocheVisible.getA().get(0).getCouleur());
				bouton1.modifCarte();
				bouton1.repaint();
				fenetre.getPannel().repaint(358,566,628,149);
				if(fenetre.getRejouer() == 2)this.finTour();
			}
			}
		}
		if(e.getSource() == bouton2)
		{
			if(fenetre.getRejouer() < 2)
			{
				if(!(fenetre.getRejouer()  == 1 && bouton2.getCouleur().equals("locomotive")))
				{
					if(bouton2.getCouleur().equals("locomotive"))
					{
						fenetre.setRejouer(2);
					}
					else{fenetre.setRejouer(fenetre.getRejouer()+1);}
					mainJoueur.add(piocheVisible.getA().get(1));
					System.out.println("actionPerformed du bouton 2, Main du joueur "+fenetre.getNumeroJoueur()+" : "+this.mainJoueur);
					piocheVisible.getA().set(1, piocheCarteWagon.PiocherCarte());
				piocheVisible.gestNbTrain();
				bouton2.setCouleur(piocheVisible.getA().get(1).getCouleur());
				bouton2.modifCarte();
				bouton2.repaint();
				fenetre.getPannel().repaint(358,566,628,149);
				if(fenetre.getRejouer() == 2)this.finTour();
			}
			}
				
			
		}
		if(e.getSource() == bouton3)
		{
			if(fenetre.getRejouer() < 2)
			{
				if(!(fenetre.getRejouer()  == 1 && bouton3.getCouleur().equals("locomotive")))
				{
					if(bouton3.getCouleur().equals("locomotive"))
					{
						fenetre.setRejouer(2);
					}
					else{fenetre.setRejouer(fenetre.getRejouer()+1);}
					mainJoueur.add(piocheVisible.getA().get(2));
					System.out.println("actionPerformed du bouton 3, Main du joueur "+fenetre.getNumeroJoueur()+" : "+this.mainJoueur);
					piocheVisible.getA().set(2, piocheCarteWagon.PiocherCarte());
				piocheVisible.gestNbTrain();
				bouton3.setCouleur(piocheVisible.getA().get(2).getCouleur());
				bouton3.modifCarte();
				bouton3.repaint();
				fenetre.getPannel().repaint(358,566,628,149);
				if(fenetre.getRejouer() == 2)this.finTour();
			}
			}
			
		}
		if(e.getSource() == bouton4)
		{
			if(fenetre.getRejouer() < 2)
			{
				if(!(fenetre.getRejouer()  == 1 && bouton4.getCouleur().equals("locomotive")))
				{
					if(bouton4.getCouleur().equals("locomotive"))
					{
						fenetre.setRejouer(2);
					}
					else{fenetre.setRejouer(fenetre.getRejouer()+1);}
				mainJoueur.add(piocheVisible.getA().get(3));
				System.out.println("actionPerformed du bouton 4, Main du joueur "+fenetre.getNumeroJoueur()+" : "+this.mainJoueur);
	
				piocheVisible.getA().set(3, piocheCarteWagon.PiocherCarte());
				piocheVisible.gestNbTrain();
				bouton4.setCouleur(piocheVisible.getA().get(3).getCouleur());
				bouton4.modifCarte();
				bouton4.repaint();
				fenetre.getPannel().repaint(358,566,628,149);
				if(fenetre.getRejouer() == 2)this.finTour();
				}
				
			}
			
		}
		if(e.getSource() == bouton5)
		{
			if(fenetre.getRejouer() < 2)
			{
				if(!(fenetre.getRejouer()  == 1 && bouton5.getCouleur().equals("locomotive")))
				{
					if(bouton5.getCouleur().equals("locomotive"))
					{
						fenetre.setRejouer(2);
					}
					else{fenetre.setRejouer(fenetre.getRejouer()+1);}
					mainJoueur.add(piocheVisible.getA().get(4));
					System.out.println("actionPerformed du bouton 5, Main du joueur "+fenetre.getNumeroJoueur()+" : "+this.mainJoueur);

					piocheVisible.getA().set(4, piocheCarteWagon.PiocherCarte());
					piocheVisible.gestNbTrain();
					bouton5.setCouleur(piocheVisible.getA().get(4).getCouleur());
					bouton5.modifCarte();
					bouton5.repaint();
					fenetre.getPannel().repaint(358,566,628,149);
					if(fenetre.getRejouer() == 2)this.finTour();
				}
			}
			
		}
		if(e.getSource() == dosCarte)
		{
			if(fenetre.getRejouer() < 2)
			{
				fenetre.setRejouer(fenetre.getRejouer()+1);
				mainJoueur.add(piocheCarteWagon.PiocherCarte());
				System.out.println("actionPerformed du bouton dosCarte, Main du joueur "+fenetre.getNumeroJoueur()+" : "+this.mainJoueur);
				if(fenetre.getRejouer() == 2)this.finTour();
			}
		}
			
	}

	private void finTour() {
		System.out.println("Fin du tour pour le joueur : "+fenetre.getNumeroJoueur());
		if(fenetre.getNumeroJoueur() < tabJoueur.size() - 1)
		{
			fenetre.setNumeroJoueur(fenetre.getNumeroJoueur() + 1);
		}
		else{fenetre.setNumeroJoueur(0);}
		System.out.println("Joueur suivant : "+fenetre.getNumeroJoueur());
		fenetre.getCarteDest().setCarteDest(tabJoueur.get(fenetre.getNumeroJoueur()).getB());
		fenetre.getCarteDest().modifListeVille(tabJoueur.get(fenetre.getNumeroJoueur()).getB());
		fenetre.getCarteDest().repaint();
		fenetre.setRejouer(0);
		afficherMainJoueur.setTabJoueur(tabJoueur.get(fenetre.getNumeroJoueur()).getA());
		afficherMainJoueur.setNomJoueur(tabJoueur.get(fenetre.getNumeroJoueur()).getNomJoueur());
		fenetre.getPannel().repaint(358,566,628,149);
		
		for(int i = 0 ; i < tabJoueur.get(fenetre.getNumeroJoueur()).getA().size() ; i++)
		{
			System.out.println(tabJoueur.get(fenetre.getNumeroJoueur()).getA().get(i).getCouleur());
		}
		System.out.println();
	}
}

