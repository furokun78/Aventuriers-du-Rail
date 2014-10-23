

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * classe qui permet de calculer les scores d'un joueur (à la fin de la partie mais aussi à la fin de chaque tour de jeu
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class CalculScores {

	protected int scoreCourant;
	protected static int cheminPlusLong = 0;
	protected  static String joueuracheminPlusLong;
	
	
	/**
	 * constructeur du calcul du score
	 * @param scoreCourant le score au bout de chaque tour
	 */
	public CalculScores(int scoreCourant) {
		this.scoreCourant = scoreCourant;
	}
	
	/**
	 * score en fonction des gares présentes dans la main du joueur
	 * @param main main du joueur en fin de partie
	 * @param plateau plateau tel qu'il est à la fin de la partie
	 * @return le score d'un joueur en fonction des gares
	 */
	public int scoreGare(MainJoueur main, Plateau plateau){
		return main.getNbGare() * 4;
		}

	/**
	 * récupérer le score courant
	 * @return le score courant du joueur
	 */
	public int getScoreCourant() {
		return scoreCourant;
	}

	/**
	 * modifier le score courant d'un joueur
	 */
	public void setScoreCourant(int scoreCourant) {
		this.scoreCourant = scoreCourant;
	}

	/**
	 * score que l'on calcule à chaque tour de jeu
	 * @param nomJoueur le nom du joueur concerné par le score
	 * @param plateau le plateau de jeu à l'état actuel
	 */
	
	@SuppressWarnings({ "unused", "unchecked"})
	public void scoreCourant(String nomJoueur, Plateau plateau){
		int cpt = 0;
		Iterator iter1 = plateau.getChemin().entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry <String, HashMap<String, Trajet>>ent = (Map.Entry) iter1.next();	//on parcours le plateau 
			Object cle = ent.getKey();
			HashMap<String, Trajet> chemin1 = plateau.getChemin().get(cle);
			Iterator iter2 = chemin1.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry <String, Trajet> ent1 = (Map.Entry <String, Trajet>) iter2.next();
				String cle1 = ent1.getKey();
				if(ent1.getValue().isDouble()){
					TrajetDouble ab = (TrajetDouble)ent1.getValue();
					if(nomJoueur.equals(ab.getPrise()) || nomJoueur.equals(ab.getProprio2())){
						if (ab.getNbcases() == 1) cpt++;
						else if (ab.getNbcases() == 2) cpt+=2;
						else if (ab.getNbcases() == 3) cpt += 4;
						else if (ab.getNbcases() == 4) cpt += 7;
						else if (ab.getNbcases() == 6) cpt += 15;
						else if (ab.getNbcases() == 8) cpt += 21;
						else System.out.println( "il y a une couille dans le paté");
					}
				}
				else{
					Trajet ab2 = ent1.getValue();
					if(nomJoueur.equals(ab2.getPrise())){
						if (ab2.getNbcases() == 1) cpt++;
						else if (ab2.getNbcases() == 2) cpt+=2;
						else if (ab2.getNbcases() == 3) cpt += 4;
						else if (ab2.getNbcases() == 4) cpt += 7;
						else if (ab2.getNbcases() == 6) cpt += 15;
						else if (ab2.getNbcases() == 8) cpt += 21;
						else System.out.println( "il y a une couille dans le paté");
					}
				}
			}
		}
		scoreCourant = cpt;
	}
	
	
	/**
	 * vérifie si 2 ville ont été reliées par un même joueur
	 * @param main les cartes actuelles que possède le joueur
	 * @param ville1 la première ville de la carte destination
	 * @param ville2 la ville à rejoindre pour réaliser l'objectif
	 * @param plateau le plateau de jeu actuel
	 * @param tab arraylist contenant les villes déjà parcourues par la récursivité de la fonction 
	 * @return vrai si les 2 villes sont liées sinon faux.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean estLiee(MainJoueur main, String ville1, String ville2, Plateau plateau, ArrayList<String> tab){ // on cherche à savoir si les 2 villes de la carte dest sont reliées ou non
		ArrayList<String> tableau = new ArrayList<String>();
		boolean compteur = false;
		String nomJoueur = main.getNomJoueur();
		Iterator iter1 = plateau.getChemin().entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry <String, HashMap<String, Trajet>> ent = (Map.Entry) iter1.next();	//on parcours le plateau 
			Object cle = ent.getKey();
			HashMap<String, Trajet> chemin1 = plateau.getChemin().get(cle);
			Iterator iter2 = chemin1.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry <String, Trajet> ent1 = (Map.Entry <String, Trajet>) iter2.next();
				String cle1 = ent1.getKey();
				if(ent1.getValue().isDouble())
				{
					TrajetDouble ab = (TrajetDouble)ent1.getValue();
					if ((ab.getPrise().equals(nomJoueur)) || (ab.getProprio2().equals(nomJoueur)) || (ab.getGare().equals(nomJoueur)))
					{
						tableau.add(cle+" "+cle1);
						tableau.add(cle1+" "+cle);
					}
				}
				else
				{
					Trajet ab2 = ent1.getValue();
					if((nomJoueur.equals(ab2.getPrise())) || (ab2.getGare().equals(nomJoueur)))
					{
						tableau.add(cle+" "+cle1);
						tableau.add(cle1+" "+cle);
					}
				}
		}
	}
	return test(tableau, ville1, ville2, main, tab);
	
}
	
	public static boolean test(ArrayList<String> tableau, String ville1, String ville2, MainJoueur main, ArrayList tab)
	{
		for(int i = 0 ; i < tableau.size() ; i++)
		{
			String chaine = tableau.get(i);
		     StringTokenizer st = new StringTokenizer(chaine);

			String premier = st.nextToken();
			String deuxieme = st.nextToken();
			
			if(deuxieme.equals(ville2))
			{
				return true;
			}
			else if(premier.equals(ville1))
			{
				for(int j = 0 ; j < tab.size(); j++)
				{
					if(!deuxieme.equals(tab.get(i)))
					{
						tab.add(deuxieme);
						test(tableau, deuxieme, ville2, main, tab);
					}
				}
			}
		}
		return false;
	}

	
	/**
	 * cacule du score en fonction des objectifs de la carte destination
	 * @param main main courante du joueur
	 * @param plateau plateau de jeu actuel
	 * @return le score obetenue pas le joueur (si score négatif -> zero)
	 */
	public int ScoreCarteDest(MainJoueur main, Plateau plateau){
		int scoredest=0;
		ArrayList<CarteDest> cartesDest = main.getB();
		ArrayList tab = new ArrayList();
		int i=0;
		while (cartesDest.size() != 0){
		CarteDest cartedest = cartesDest.get(i);
			if (estLiee(main, cartedest.getVille1(), cartedest.getVille2(), plateau, tab)) scoredest += cartedest.getScore();
		// scoreCourant += score de la carte dest ssi on a réussi à établir un chemin entre les 2 villes de la carte dest.
			else scoredest -= cartedest.getScore();
		// sinon on soustrait le score de la carte dest au score courant.
			cartesDest.remove(i);
			i++;
		}
		if (scoredest<0) return 0;
		else return scoredest;
	}
	

	
	/**
	 *  calcule final du score pour un joueur donné
	 * @param main main qui caractérise un joueur en fin de partie
	 * @param plateau le plateau de jeu en fin de partie
	 * @return le score final d'un joueur
	 */
	public int scorefinal(MainJoueur main, Plateau plateau){
		String nomJoueur = main.getNomJoueur();
		 int score = this.scoreGare(main, plateau) + this.ScoreCarteDest(main, plateau)+ scoreCourant;
		// this.cheminPlusLong(main, plateau);
		 System.out.println(joueuracheminPlusLong);
		 if (nomJoueur.equals(joueuracheminPlusLong)){
			 score = score + 10;//+ 10 point pour le plus long chemin

		 } 
		 return score;
	}
	
	/*/**
	 * calcul du chemin le plus long réalisé par un joueur sur le plateau
	 * @param ville1 on spécifie une ville de départ (obligatoire pour la récursivité)
	 * @param main la main du joueur qui le caractérise
	 * @param plateau le plateau en fin de partie 
	 * @return le nombre de cases du chemin le plus long effectué par le joueur
	 */
	/*public int cheminPlusLong(MainJoueur main, Plateau plateau){
		String nomJoueur = main.getNomJoueur();
		int cpt = 0, max = 0;
		ArrayList<String> tableau = new ArrayList<String>();
		ArrayList<String> tab = new ArrayList<String>();
		ArrayList<String> tab2 = new ArrayList<String>();
		Iterator iter1 = plateau.getChemin().entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry <String, HashMap<String, Trajet>> ent = (Map.Entry) iter1.next();	//on parcours le plateau 
			String cle = ent.getKey();
			HashMap<String, Trajet> chemin1 = plateau.getChemin().get(cle);
			Iterator iter2 = chemin1.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry <String, Trajet> ent1 = (Map.Entry <String, Trajet>) iter2.next();
				String cle1 = ent1.getKey();
				if(ent1.getValue().isDouble())
				{
					TrajetDouble ab = (TrajetDouble)ent1.getValue();
					if ((ab.getPrise().equals(nomJoueur)) || (ab.getProprio2().equals(nomJoueur)) || (ab.getGare().equals(nomJoueur)))
					{
						tableau.add(cle+" "+cle1);
						tableau.add(cle1+" "+cle);
						tab2.add(cle);
						tab2.add(cle1);
					}
				}
				else
				{
					Trajet ab2 = ent1.getValue();
					if((nomJoueur.equals(ab2.getPrise())) || (ab2.getGare().equals(nomJoueur)))
					{
						tableau.add(cle+" "+cle1);
						tableau.add(cle1+" "+cle);
						tab2.add(cle);
						tab2.add(cle1);

					}
				}
		}
	}
		for(int i = 0 ; i < tab2.size() ; i++)
		{
			String chaine = tableau.get(i);
		    StringTokenizer st = new StringTokenizer(chaine);
			String premier = st.nextToken();
			
			cpt = test2(tableau, premier, tab, plateau, 0);
			if(cpt > max) max = cpt;
		}
		for(int i = 0 ; i < tab2.size() ; i++)
		{
			String chaine = tableau.get(i);
		    StringTokenizer st = new StringTokenizer(chaine);
			String premier = st.nextToken();
			premier = st.nextToken();
			
			cpt = test2(tableau, premier, tab, plateau, 0);
			if(cpt > max) max = cpt;
		}
		System.out.println(max);
	if (max > cheminPlusLong){
		joueuracheminPlusLong = nomJoueur;
	cheminPlusLong = cpt;
	}
	return max;
}

public static int test2(ArrayList<String> tableau, String ville1,  ArrayList tab, Plateau plateau, int compteur)
{
	for(int i = 0 ; i < tableau.size() ; i++)
	{
		String chaine = tableau.get(i);
	    StringTokenizer st = new StringTokenizer(chaine);

		String premier = st.nextToken();
		String deuxieme = st.nextToken();
		if(premier.equals(ville1))
		{
System.out.println("bou");
							tab.add(deuxieme);
							compteur += plateau.getChemin().get(premier).get(deuxieme).getNbcases();
							test2(tableau, deuxieme, tab, plateau, compteur);

		}
		else{
			System.out.println("aaaaaaaaaaaa");
			return compteur;
		}
	}
	return 0;
}*/
}



