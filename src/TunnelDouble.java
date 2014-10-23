

/**
 * le tunnel muni des propriétés d'une route double
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class TunnelDouble extends TrajetDouble {

	
	/**
	 * le constructeur d'un tunnel double
	 * @param couleur la couleur de la 1ère route
	 * @param nbcases le nombre de cases de la route
	 * @param couleur2 la couleur de la 2ème route
	 */
	public TunnelDouble(String couleur, int nbcases, String couleur2){
		super(couleur, nbcases, couleur2);
	}

	public String toString(){
		return nbcases + " " + couleur  + " " + prise + " " + couleur2 + " " + proprio2  + "\n";
	}
}
