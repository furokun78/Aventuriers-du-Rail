

/**
 * la carte wagon et sa couleur
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class CarteWagon {
	protected String couleur;
	
	/**
	 * constructeur sans paramètres
	 */
	public CarteWagon()
	{
		couleur = "";
	}
	
	/**
	 * constructeur d'une carte wagon
	 * @param couleur  la couleur que l'on veut donner au wagon 
	 */
	public CarteWagon(String couleur)
	{
		this.couleur = couleur;
	}
	
	/**
	 * obtenir la couleur de la carte wagon
	 * @return la couleur de la carte
	 */
	
	public String getCouleur() {
		return couleur;
	}
	
	public String toString(){
		return couleur;
	}

	
}
