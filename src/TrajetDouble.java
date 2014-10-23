

/**
 * les attributs supplémentaires d'un trajet double
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public abstract class TrajetDouble extends Trajet{

	protected String proprio2; // le nom du 2ème propriétaire de la route double
	protected String couleur2; // la couleur de la 2ème branche de la route.
	
	/**
	 * constructeur d'un trajet double
	 * @param couleur la couleur du 1er trajet
	 * @param nbcases le nombre de cases du trajet
	 * @param proprio2 le propriétaire du 2ème trajet
	 * @param couleur2 la couleur du 2ème trajet
	 */
	public TrajetDouble(String couleur, int nbcases, String couleur2) {
		super(couleur, nbcases, true);
		this.proprio2 = "libre";
		this.couleur2 = couleur2;
	}

	/**
	 * récupérer le propriétaire du 1ère trajet
	 * @return le propriétaire du 1ère trajet
	 */
	public String getProprio2() {
		return proprio2;
	}

	/**
	 * modifier le propriétaire du 1ère trajet
	 * @param proprio2 le propriétaire du 1ère trajet
	 */
	public void setProprio2(String proprio2) {
		this.proprio2 = proprio2;
	}
	public String toString(){
		return nbcases + " " + couleur  + " " + prise + " " + couleur2 + " " + proprio2  + "\n";
	}

	/**
	 * récupérer la couleur du 1er trajet
	 * @return la couleur du 1ère trajet
	 */
	public String getCouleur2() {
		return couleur2;
	}

	/**
	 * modifier la couleur du 1ère trajet
	 * @param couleur2 la couleur du 1ère trajet
	 */
	public void setCouleur2(String couleur2) {
		this.couleur2 = couleur2;
	}
}
