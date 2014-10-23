

/**
 * les attributs supplémentaires d'une route double
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class RouteDouble extends TrajetDouble{

	
	/**
	 * constructeur d'une route double
	 * @param couleur la couleur de la 1ère route
	 * @param nbcases le nombre de cases de la route
	 * @param proprio2 le propriétaire de la 2ème route
	 * @param couleur2 la couleur de la 2ème route
	 */
	public RouteDouble(String couleur, int nbcases, String couleur2) {
		super(couleur, nbcases, couleur2);
	}
}
