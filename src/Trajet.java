

/**
 * classe abstraite qui represente les routes simples
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public abstract class Trajet {

	protected String couleur;// couleur de la route
	protected int nbcases; // le nombre de cases que contient la route
	protected String prise; // si la route est occupé par un joueur =>  le nom du joueur, sinon "libre"
	protected boolean Double; // la route est elle double?
	protected String gare; // le nom du joueur qui a posé une gare
	
	/**
	 * constructeur d'un trajet
	 * @param couleur la couleur du trajet
	 * @param nbcases le nombres de cases de cet trajet
	 * @param Double la route est elle double?
	 */
	public Trajet(String couleur, int nbcases, boolean Double) {
		this.couleur = couleur;
		this.nbcases = nbcases;
		this.prise = "libre";
		this.Double = Double;
		this.gare = "libre";
	}

/**
 * récupérer le nom du joueur qui a posé une gare
 * @return le nom du joueur 
 */
	public String getGare() {
		return gare;
	}

/**
 * modifier le nom du joueur qui a posé une gare
 * @param  le nom du joueur qui a posé une gare
 */
	public void setGare(String gare) {
		this.gare = gare;
	}

/**
 * un trajet est elle double?
 * @return vrai si la route est double sinon faux
 */
	public boolean isDouble() {
		return Double;
	}

	/**
	 * modifier l'attribut double d'un trajet
	 * @param l'attribut double d'un trajet
	 */
	public void setDouble(boolean d) {
		Double = d;
	}

	/**
	 * obtenir la couleur d'un trajet
	 * @return la couleur du trajet
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * modifier la couleur d'un trajet
	 * @param couleur la couleur du trajet
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/** 
	 * obtenir le nombre de cases d'un trajet
	 * @return le nombre de cases d'un trajet
	 */
	public int getNbcases() {
		return nbcases;
	}

	/**
	 * modifier le nombre de cases d'un trajet
	 * @param nbcases le nombre de cases du trajet
	 */
	public void setNbcases(int nbcases) {
		this.nbcases = nbcases;
	}

	/**
	 * obtenir le nom du joueur qui possède le trajet
	 * @return le nom du joueur qui possède le  trajet
	 */
	public String getPrise() {
		return prise;
	}

	/**
	 * modifier le nom du joueur qui possède le trajet
	 * @param prise le nom du joueur qui possède le trajet
	 */
	public void setPrise(String prise) {
		this.prise = prise;
	}

	/**
	 * méthode d'affichage des attributs d'un trajet
	 */
	public String toString(){
		return couleur + " " +  nbcases + " " + prise + "\n";
	}
	
	
}
