

/**
 * le Ferry avec les attributs d'une route double
 * @author Fr�d�ric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class FerryDouble extends TrajetDouble {
	
	protected int nblocomotives;// nombre de locomotives n�cessaires pour l'achat d'une route de type ferry
	
	/**
	 * constructeur d'une route de type ferry et double
	 * @param couleur la couleur de la premi�re route
	 * @param nbcases le nombre de cases de la route
	 * @param nbloco le nombre de locomotives n�cessaires � l'achat de cette route
	 * @param proprio2 le nom du joueur poss�dant la 2�me route
	 * @param couleur2 la couleur de la 2�me route
	 */
	public FerryDouble(String couleur, int nbcases, int nbloco, String couleur2) {
		super(couleur, nbcases, couleur2);
		this.nblocomotives = nbloco;
	}
	
	public String toString(){
		
		return nblocomotives + " locomotives " + " " + nbcases + " " + " " + couleur + " " + prise + " " + couleur2 + " " + proprio2 + "\n";
	}
	
	/**
	 * obtenir le nombre de locomotives n�cessaires � l'achat d'un ferry
	 * @return le nombre de locomotives n�cessaires � l'achat d'un ferry
	 */
	public int getNblocomotives() {
		return nblocomotives;
	}

	/**
	 * modifier le nombre de locomotives n�cessaires � l'achat d'un ferry
	 * @param nblocomotives le nombre de locomotives n�cessaires � l'achat d'un ferry
	 */
	public void setNblocomotives(int nblocomotives) {
		this.nblocomotives = nblocomotives;
	}
}

