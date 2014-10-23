

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * classe qui permet de calculer les scores d'un joueur (� la fin de la partie mais aussi � la fin de chaque tour de jeu
 * @author Fr�d�ric Torcheux & Florian Chaulet
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
	 * score en fonction des gares pr�sentes dans la main du joueur
	 * @param main main du joueur en fin de partie
	 * @param plateau plateau tel qu'il est � la fin de la partie
	 * @return le score d'un joueur en fonction des gares
	 */
	public int scoreGare(MainJoueur main, Plateau plateau){
		return main.getNbGare() * 4;
		}

	/**
	 * r�cup�rer le score courant
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
	 * score que l'on calcule � chaque tour de jeu
	 * @param nomJoueur le nom du joueur concern� par le score
	 * @param plateau le plateau de jeu � l'�tat actuel
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
						else System.out.println( "il y a une couille dans le pat�");
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
						else System.out.println( "il y a une couille dans le pat�");
					}
				}
			}
		}
		scoreCourant = cpt;
	}
	
	
	/**
	 * v�rifie si 2 ville ont �t� reli�es par un m�me joueur
	 * @param main les cartes actuelles que poss�de le joueur
	 * @param ville1 la premi�re ville de la carte destination
	 * @param ville2 la ville � rejoindre pour r�aliser l'objectif
	 * @param plateau le plateau de jeu actuel
	 * @param tab arraylist contenant les villes d�j� parcourues par la r�cursivit� de la fonction 
	 * @return vrai si les 2 villes sont li�es sinon faux.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean estLiee(MainJoueur main, String ville1, String ville2, Plateau plateau, ArrayList<String> tab){ // on cherche � savoir si les 2 villes de la carte dest sont reli�es ou non
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
	 * @return le score obetenue pas le joueur (si score n�gatif -> zero)
	 */
	public int ScoreCarteDest(MainJoueur main, Plateau plateau){
		int scoredest=0;
		ArrayList<CarteDest> cartesDest = main.getB();
		ArrayList tab = new ArrayList();
		int i=0;
		while (cartesDest.size() != 0){
		CarteDest cartedest = cartesDest.get(i);
			if (estLiee(main, cartedest.getVille1(), cartedest.getVille2(), plateau, tab)) scoredest += cartedest.getScore();
		// scoreCourant += score de la carte dest ssi on a r�ussi � �tablir un chemin entre les 2 villes de la carte dest.
			else scoredest -= cartedest.getScore();
		// sinon on soustrait le score de la carte dest au score courant.
			cartesDest.remove(i);
			i++;
		}
		if (scoredest<0) return 0;
		else return scoredest;
	}
	

	
	/**
	 *  calcule final du score pour un joueur donn�
	 * @param main main qui caract�rise un joueur en fin de partie
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
	 * calcul du chemin le plus long r�alis� par un joueur sur le plateau
	 * @param ville1 on sp�cifie une ville de d�part (obligatoire pour la r�cursivit�)
	 * @param main la main du joueur qui le caract�rise
	 * @param plateau le plateau en fin de partie 
	 * @return le nombre de cases du chemin le plus long effectu� par le joueur
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



