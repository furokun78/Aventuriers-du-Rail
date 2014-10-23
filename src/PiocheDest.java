

import java.util.ArrayList;
import java.util.Scanner;

/**
 * la pioche de cartes destination
 * @author Frédéric Torcheux & Florian Chaulet
 *@version 1.0
 */
public class PiocheDest{
	
	private ArrayList<CarteDest> a;
	private ArrayList<CarteDest> b;
	
	/** 
	 * constructeur initialisant les cartes destinations du plateau
	 */
	public PiocheDest()
	{
		a = new ArrayList<CarteDest>();
		b = new ArrayList<CarteDest>();
		  a.add(new CarteDest("Riga", "Bucuresti", 10, true));
		  a.add(new CarteDest("Paris", "Wien", 8, true));
		  a.add(new CarteDest("Madrid", "Zurich", 8, true));
		  a.add(new CarteDest("Berlin", "Roma", 9, true));
		  a.add(new CarteDest("Marseille", "Essen", 8, true));
		  a.add(new CarteDest("Frankfurt", "Kobenhavn", 5, true));//dessin
		  a.add(new CarteDest("Essen", "Kyiv", 10, true));
		  a.add(new CarteDest("Bruxelles", "Danzig", 9, true));
		  a.add(new CarteDest("Berlin", "Bucuresti", 8, true));
		  a.add(new CarteDest("Amsterdam", "Pamplona", 7, true));
		  a.add(new CarteDest("Athina", "Wilno", 8, true));
		  a.add(new CarteDest("Paris", "Zagrab", 7, true));
		  a.add(new CarteDest("Angora", "Kharkov", 10, true));
		  a.add(new CarteDest("Frankfurt", "Smolensk", 13, true));
		  a.add(new CarteDest("Kostov", "Erzurum", 5, true));
		  a.add(new CarteDest("London", "Wien", 10, true));
		  a.add(new CarteDest("Roma", "Smyrna", 8, true));
		  a.add(new CarteDest("Zurich", "Brindisi", 6, true));
		  a.add(new CarteDest("Brest", "Marseille", 7, true));
		  a.add(new CarteDest("London", "Berlin", 8, true));
		  a.add(new CarteDest("Budapest", "Sophia", 8, true));
		  a.add(new CarteDest("Zurich", "Budapest", 6, true));
		  a.add(new CarteDest("Amsterdam", "Wilno", 12, true));
		  a.add(new CarteDest("Berlin", "Moskva", 12, true));
		  a.add(new CarteDest("Barcelona", "Bruxelles", 8, true));
		  a.add(new CarteDest("Stockholm", "Wien", 11, true));
		  a.add(new CarteDest("Brest", "Venezia", 8, true));
		  a.add(new CarteDest("Madrid", "Dieppe", 8, true));
		  a.add(new CarteDest("Kyiv", "Sochi", 8, true));
		  a.add(new CarteDest("Kyiv", "Petrograd", 6, true));
		  a.add(new CarteDest("Sofia", "Smyrna", 5, true));
		  a.add(new CarteDest("Athina", "Angora", 5, true));
		  a.add(new CarteDest("Sarajevo", "Sebastopol", 8, true));
		  a.add(new CarteDest("Palermo", "Constantinople", 8, true));
		  a.add(new CarteDest("Zagrab", "Brindisi", 6, true));
		  a.add(new CarteDest("Barcelona", "Berlin", 8, true));
		  a.add(new CarteDest("Venezia", "Constantinople", 10, true));
		  a.add(new CarteDest("Smolensk", "Kostov", 8, true));
		  a.add(new CarteDest("Edimburgh", "Paris", 7, true));
		  //carte dest routes longues
		  b.add(new CarteDest("Kobenhavn", "Erzurum", 21, false));
		  b.add(new CarteDest("Brest", "Petrograd", 20, false));
		  b.add(new CarteDest("Edimburgh", "Athina", 21, false));
		  b.add(new CarteDest("Cadiz", "Stockholm", 21, false));
		  b.add(new CarteDest("Lisboa", "Danzig", 20, false));
		  b.add(new CarteDest("Palermo", "Moskva", 20, false));
		 
	}
	
	public ArrayList<CarteDest> getB() {
		return b;
	}

	public void setB(ArrayList<CarteDest> b) {
		this.b = b;
	}

	/**
	 * récupérer l'arraylist de cartes destination
	 * @return l'arraylist de cartes destination
	 */
	public ArrayList<CarteDest> getA() {
		return a;
	}

	/**
	 * modifier l'arraylist de cartes destination
	 * @param l'arraylist de cartes destination
	 */
	public void setA(ArrayList<CarteDest> a) {
		this.a = a;
	}

	/**
	 * piocher une carte du deck
	 * @return la carte destination qui ressort de la pioche
	 */
	public CarteDest PiocherCarte()
	{
		int nombre = (int)(Math.random() * a.size());
		CarteDest autre = a.get(nombre);
		a.remove(nombre);
		return autre;
	}
	
	

}
