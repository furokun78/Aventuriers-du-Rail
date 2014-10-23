

import java.util.ArrayList;

/**
 * la pioche de cartes Wagon
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class PiocheWagon{
	
	private ArrayList<CarteWagon> a;
	
	/**
	 * piocher une carte du deck
	 * @return la carte Wagon de la pioche
	 */
	public CarteWagon PiocherCarte()
	{
		int nombre = (int)(Math.random() * a.size());
		CarteWagon autre = a.get(nombre);
		a.remove(nombre);
		return autre;
	}
	
	/**
	 * méthode d'affichage de la pioche Wagon
	 */
	public void afficher()
	{
		int i = 0;
		for(i = 0 ; i < a.size(); i ++)
			System.out.print(a.get(i).getCouleur()+" ");

			
	}
	
	/**
	 * constructeur qui initialise les cartes de la pioche Wagon
	 */
	public PiocheWagon()
	{
		a = new ArrayList<CarteWagon>();
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("bleu"));
		}
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("violet"));
		}
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("blanc"));
		}
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("jaune"));
		}
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("orange"));
		}
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("vert"));
		}
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("noir"));
		}
		for(int i = 0 ; i < 12 ; i++)
		{
			a.add(new CarteWagon("rouge"));
		}
		for(int i = 0 ; i < 14 ; i++)
		{
			a.add(new CarteWagon("locomotive"));
		}
	}

	/**
	 * récupérer l'arraylist de cartes Wagon
	 * @return l'arraylist de cartes Wagon
	 */
	public ArrayList<CarteWagon> getA() {
		return a;
	}

	/**
	 * modifier l'arraylist de cartes Wagon
	 * @param l'arraylist de cartes Wagon
	 */
	public void setA(ArrayList<CarteWagon> a) {
		this.a = a;
	}
}