

/**
 * la carte destination avec ses objectifs
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class CarteDest {
	
	protected String ville1;//ville de départ
	protected String ville2;// ville à relier (objectif)
	protected int score;//le nombre de points que la carte rapporte
	protected boolean routeReg; //true si la route est reguliere, false si elle est longue
	
	/**
	 * constructeur sans paramètres
	 */
	public CarteDest()
	{
		ville1 = "";
		ville2 = "";
		score = 0;
		routeReg = false;
	}
	/**
	 * constructeur d'une carte destination
	 * @param ville1 la ville de départ
	 * @param ville2 la ville à relier
	 * @param valeur le score que rapporte cette carte
	 * @param routeReg la route est elle longue?
	 */
	public CarteDest(String ville1, String ville2, int valeur, boolean routeReg)
	{
		this.ville1 = ville1;
		this.ville2 = ville2;
		this.score = valeur;
		this.routeReg = routeReg;
	}
	
	/**
	 * obtenir la ville de départ
	 * @return la ville de départ
	 */
	public String getVille1() {
		return ville1;
	}
	
	/**
	 * modifier la ville de départ
	 * @param ville1 la ville de départ
	 */
	public void setVille1(String ville1) {
		this.ville1 = ville1;
	}
	
	/**
	 * obtenir la ville à relier
	 * @return la ville à relier
	 */
	public String getVille2() {
		return ville2;
	}
	
	/**
	 * modifier la ville à relier
	 * @param ville2 la ville à relier
	 */
	public void setVille2(String ville2) {
		this.ville2 = ville2;
	}
	
	/**
	 * obtenir le score de la carte
	 * @return le score de la carte
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * modifier le score de la carte
	 * @param score le score de la carte
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * la route est elle régulière
	 * @return vrai si régulière faux si longue
	 */
	public boolean isRouteReg() {
		return routeReg;
	}
	
	/**
	 * modifier la régularité de la route
	 * @param routeReg la régularité de la route
	 */
	public void setRouteReg(boolean routeReg) {
		this.routeReg = routeReg;
	}
	
	/**
	 * méthode d'affichage d'une carte destination
	 */
	public String toString(){
		String str = "";
		str = ville1 + ", "+ville2+", score : "+score;

		return str;
	}
}
