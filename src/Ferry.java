

/**
 * le Ferry en tant que route particulière 
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class Ferry extends Trajet{

	protected int nblocomotives;// nombre de locomotives nécessaires pour l'achat d'une route de type ferry

	/**
	 * constructeur d'une route de type ferry
	 * @param couleur couleur de la route 
	 * @param nbcases nombre de cases de la route
	 * @param nblocomotives nombre de locomotives nécessaires pour l'achat d'un Ferry
	 * @param Double le Ferry est il une route double?
	 */
	public Ferry(String couleur, int nbcases, int nblocomotives, boolean Double) {
		super(couleur, nbcases, Double);
		this.nblocomotives = nblocomotives;
	}

	/**
	 * obtenir le nombre de locomotives nécessaires à l'achat d'un ferry
	 * @return le nombre de locomotives nécessaires à l'achat d'un ferry
	 */
	public int getNblocomotives() {
		return nblocomotives;
	}

	/**
	 * modifier le nombre de locomotives nécessaires à l'achat d'un ferry
	 * @param nblocomotives le nombre de locomotives nécessaires à l'achat d'un ferry
	 */
	public void setNblocomotives(int nblocomotives) {
		this.nblocomotives = nblocomotives;
	}
	
	/**
	 * méthode d'affichage d'une route de type ferry
	 */
	public String toString(){
		
		return nblocomotives + " locomotives " + " " + couleur + " " + " " + nbcases + " " + prise + "\n";
	}
	
	
	
}
