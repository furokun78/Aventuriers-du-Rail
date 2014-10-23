

/**
 * les attributs suppl�mentaires d'une route double
 * @author Fr�d�ric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class RouteDouble extends TrajetDouble{

	
	/**
	 * constructeur d'une route double
	 * @param couleur la couleur de la 1�re route
	 * @param nbcases le nombre de cases de la route
	 * @param proprio2 le propri�taire de la 2�me route
	 * @param couleur2 la couleur de la 2�me route
	 */
	public RouteDouble(String couleur, int nbcases, String couleur2) {
		super(couleur, nbcases, couleur2);
	}
}
