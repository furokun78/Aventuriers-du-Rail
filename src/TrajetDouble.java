

/**
 * les attributs suppl�mentaires d'un trajet double
 * @author Fr�d�ric Torcheux & Florian Chaulet
 * @version 1.0
 */
public abstract class TrajetDouble extends Trajet{

	protected String proprio2; // le nom du 2�me propri�taire de la route double
	protected String couleur2; // la couleur de la 2�me branche de la route.
	
	/**
	 * constructeur d'un trajet double
	 * @param couleur la couleur du 1er trajet
	 * @param nbcases le nombre de cases du trajet
	 * @param proprio2 le propri�taire du 2�me trajet
	 * @param couleur2 la couleur du 2�me trajet
	 */
	public TrajetDouble(String couleur, int nbcases, String couleur2) {
		super(couleur, nbcases, true);
		this.proprio2 = "libre";
		this.couleur2 = couleur2;
	}

	/**
	 * r�cup�rer le propri�taire du 1�re trajet
	 * @return le propri�taire du 1�re trajet
	 */
	public String getProprio2() {
		return proprio2;
	}

	/**
	 * modifier le propri�taire du 1�re trajet
	 * @param proprio2 le propri�taire du 1�re trajet
	 */
	public void setProprio2(String proprio2) {
		this.proprio2 = proprio2;
	}
	public String toString(){
		return nbcases + " " + couleur  + " " + prise + " " + couleur2 + " " + proprio2  + "\n";
	}

	/**
	 * r�cup�rer la couleur du 1er trajet
	 * @return la couleur du 1�re trajet
	 */
	public String getCouleur2() {
		return couleur2;
	}

	/**
	 * modifier la couleur du 1�re trajet
	 * @param couleur2 la couleur du 1�re trajet
	 */
	public void setCouleur2(String couleur2) {
		this.couleur2 = couleur2;
	}
}
