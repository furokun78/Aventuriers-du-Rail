

import java.util.ArrayList;

/**
 * la main de cartes Wagon visibles sur le tapis de jeu
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class CartesVisible{
	private ArrayList<CarteWagon> a;
	PiocheWagon piocheCarteWagon;
	

	
	
	
	/**
	 * constructeur de la main visible de cartes Wagon
	 * @param piocheCarteWagon la pioche de cartes Wagon
	 */
	public CartesVisible(PiocheWagon piocheCarteWagon)
	{
		this.piocheCarteWagon = piocheCarteWagon;
		a = new ArrayList<CarteWagon>();

		for(int i = 0 ; i < 5 ; i ++)
		{
			a.add(piocheCarteWagon.PiocherCarte());
		}
		this.gestNbTrain();
	}
	
	public void gestNbTrain()
	{
		int compteur;
		compteur = 0;
		do{
		for(int i = 0 ; i < 5 ; i ++)
		{
			if(a.get(i).getCouleur().equals("locomotive")) compteur++;
			//System.out.println("Il y a : " +compteur + " locomotives");
		}
		if(compteur >= 3)
		{
			for(int i = 0 ; i < 5 ; i ++)
				piocheCarteWagon.getA().add(a.get(i));
			for(int i = 0 ; i < 5 ; i++)
				a.remove(0);
			for(int i = 0 ; i < 5 ; i++)
				a.add(piocheCarteWagon.PiocherCarte());
			compteur = 0;
		}
		for(int i = 0 ; i < 5 ; i ++)
		{
			if(a.get(i).getCouleur().equals("locomotive")) compteur++;
		}
		}while(compteur >= 3);
	}

	/**
	 * obtenir l'arraylist de cartes Wagon de la main visible
	 * @return l'arraylist de cartes Wagon
	 */
	public ArrayList<CarteWagon> getA() {
		return a;
	}

	/**
	 * modifier l'arraylist de cartes Wagon de la main visible
	 * @param a l'arraylist de cartes Wagon de la main visible
	 */
	public void setA(ArrayList<CarteWagon> a) {
		this.a = a;
	}

	/**
	 * méthode d'affichage de la main visible sur le tapis
	 */
	public String toString()
	{
		String chaine ="";
		for(int i = 0 ; i < 5 ; i ++)
		{
			chaine += i+1 +") "+ a.get(i).getCouleur();
			chaine += " ";
		}
		return chaine;
	}
}
