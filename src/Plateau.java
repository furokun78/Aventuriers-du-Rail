


import java.util.*;

import javax.swing.JOptionPane;

/**
 * le plateau de jeu contenant tous les chemins et les méthodes pour les acheter
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class Plateau {

	private HashMap <String, HashMap <String, Trajet>> chemin; // la HashMap contient: la ville1; la ville2; les routes entre ces 2 villes;
	private Fenetre fenetre;
	private DessinerRectangle dessinerRectangle = new DessinerRectangle();
	public DessinerRectangle getDessinerRectangle() {
		return dessinerRectangle;
	}
	public void setDessinerRectangle(DessinerRectangle dessinerRectangle) {
		this.dessinerRectangle = dessinerRectangle;
	}
	public Fenetre getFenetre() {
		return fenetre;
	}
	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	/**
	 * le constructeur vide créant la HashMap de HashMap
	 */
	public Plateau(Fenetre fenetre){
		this.chemin = new HashMap <String, HashMap <String, Trajet>>();
		this.fenetre = fenetre;
	}
	/**
	 * ajouter une route entre 2 villes
	 * @param ville1 ville de départ
	 * @param ville2 ville d'arrivé
	 * @param route toutes les caractéristiques de cette route 
	 */
	public void inserer(String ville1, String ville2, Trajet route){
		if(chemin.containsKey(ville1)){
			HashMap <String, Trajet> map2 = chemin.get(ville1);
			map2.put(ville2, route);
		}
		else{
			HashMap <String, Trajet> map2 = new HashMap<String, Trajet>();
			map2.put(ville2, route);
			chemin.put(ville1, map2);
		}
	}
	/**
	 * récupérer le plateau de jeu
	 * @return le plateau de jeu
	 */
	public HashMap<String, HashMap<String, Trajet>> getChemin() {
		return chemin;
	}
	/**
	 * modifier le plateau de jeu
	 * @param chemin le plateau de jeu
	 */
	public void setChemin(HashMap<String, HashMap<String, Trajet>> chemin) {
		this.chemin = chemin;
	}
	
	/**
	 * construire une gare pour s'approprier le droit de passer par un chemin adverse
	 * @param ville1 la ville de départ 
	 * @param ville2 la ville d'arrivé
	 * @param main la main actuelle du joueur qui veut poser la gare
	 */
	public void construireGare(String ville1, String ville2, MainJoueur main){
		if(chemin.containsKey(ville1)){
			if(chemin.get(ville1).containsKey(ville2)){
				if(chemin.get(ville1).get(ville2).getGare().equals("libre")){
					Scanner sc = new Scanner(System.in);
					String reponse;
					int cpt = 0;
					ArrayList<CarteWagon> tab =	main.getA();
					if(main.getNbGare() == 0)System.out.println("Vous ne pouvez plus créer de gare");
					else if(main.getNbGare() == 1){
						System.out.println(main);
						System.out.println("Veuillez indiquer la couleur des 3 cartes que vous devez jetter pour poser la gare");
						reponse = sc.nextLine();
						for(int i = 0 ; i < tab.size(); i++) if(tab.get(i).getCouleur().equals(reponse)) cpt++;
						if(cpt == 3){
							chemin.get(ville1).get(ville2).setGare(main.getNomJoueur());
							main.setNbGare(0);
							int i = 0;
							while(cpt != 0)
							{
								if(tab.get(i).getCouleur().equals(reponse) || tab.get(i).getCouleur().equals("locomotive"))
								{
									tab.remove(i);
									cpt--;
								}
							}
						}
					}
					else if(main.getNbGare() == 2){
						System.out.println(main);
						System.out.println("Veuillez indiquer la couleur des 2 cartes que vous devez jetter pour poser la gare");
						reponse = sc.nextLine();
						for(int i = 0 ; i < tab.size(); i++) if(tab.get(i).getCouleur().equals(reponse)) cpt++;
						if(cpt == 2){
							chemin.get(ville1).get(ville2).setGare(main.getNomJoueur());
							main.setNbGare(1);
							int i = 0;
							while(cpt != 0)
							{
								if(tab.get(i).getCouleur().equals(reponse) || tab.get(i).getCouleur().equals("locomotive"))
								{
									tab.remove(i);
									cpt--;
								}
							}
						}
					}
					else if(main.getNbGare() == 3){
						System.out.println(main);
						System.out.println("Veuillez indiquer la couleur de 1 carte que vous devez jetter pour poser la gare");
						reponse = sc.nextLine();
						for(int i = 0 ; i < tab.size(); i++)
						{
							if(tab.get(i).getCouleur().equals(reponse))
							{
								tab.remove(i);
								chemin.get(ville1).get(ville2).setGare(main.getNomJoueur());
								main.setNbGare(2);
							}
						}
					}
				}
				else System.out.println("La gare est deja prise");
			}
			else System.out.println("Le chemin n'existe pas");
		}
		else System.out.println("Le chemin n'existe pas");
		System.out.println();
	}
	
	
	
	
	
	/**
	 * méthode d'affichage de la HashMap de HashMap c'est à dire le plateau
	 */
	
	@SuppressWarnings("unchecked")
	public void afficher(){
		Iterator iter1 = chemin.entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry <String, HashMap<String, Trajet>>ent = (Map.Entry) iter1.next();
			Object cle = ent.getKey();
			HashMap<String, Trajet> chemin1 = chemin.get(cle);
			System.out.println(cle);
			Iterator iter2 = chemin1.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry <String, Trajet> ent1 = (Map.Entry <String, Trajet>) iter2.next();
				String cle1 = ent1.getKey();
				Trajet ab = ent1.getValue();
				System.out.print("	"+cle1 + " ");
				System.out.println(ab);
				}
		}
	}	
	
	/** 
	 * méthode générale pour acheter une route quelque soit son type
	 * @param ville1 la ville de départ
	 * @param ville2 la ville d'arivé
	 * @param main la main caractérisant le joueur
	 * @param pioche la pioche Wagon contenant les cartes Wagon
	 */
	public void acheter(String ville1, String ville2, MainJoueur main, PiocheWagon pioche){
		
        try {
    		if(chemin.get(ville1).get(ville2).isDouble()){
    			if(chemin.get(ville1).get(ville2).getClass().getCanonicalName().equals("RouteDouble"))
    			{
    				this.acheterRouteDouble(ville1, ville2, main);
    			}
    			if(chemin.get(ville1).get(ville2).getClass().getCanonicalName().equals("FerryDouble"))
    			{
    				this.acheterFerryDouble(ville1, ville2, main);
    			}
    			if(chemin.get(ville1).get(ville2).getClass().getCanonicalName().equals("TunnelDouble"))
    			{
    				this.acheterTunnelDouble(pioche, ville1, ville2, main);
    			}
    		}
    		else{
    			if(chemin.get(ville1).get(ville2).getClass().getCanonicalName().equals("Route"))
    			{
    				this.acheterRouteSimple(ville1, ville2, main);
    			}
    			if(chemin.get(ville1).get(ville2).getClass().getCanonicalName().equals("Ferry"))
    			{
    				this.acheterFerrySimple(ville1, ville2, main);
    			}
    			if(chemin.get(ville1).get(ville2).getClass().getCanonicalName().equals("Tunnel"))
    			{
    				this.acheterTunnelSimple(pioche, main, ville1, ville2);
    			}
    		}
    } catch (NullPointerException e) {
    	//System.out.println("Désolé mais le chemin demandé n'existe pas");
    }

	}
	
	 /**
	  * acheter la deuxième route d'un Ferry Double
	  * @param route la route en question 
	  * @param main la main du joueur concerné
	  */
	 public void achatDoubleFerryPremier(FerryDouble route, MainJoueur main){// on veut acheter le 2ème chemin d'une route double
	  String couleur = route.getCouleur();// on récupère l'attribut couleur2 de la route
	  String reponse = "";
	  if(couleur.equals("gris"))
	  {
	   System.out.println("Quel couleur de carte voulez vous jouer ? ");
	   Scanner sc = new Scanner(System.in);
	   reponse = sc.nextLine();
	  }
	  int nbcases = route.getNbcases(); // on récupère l'attribut nbcases de la route
	  int nbloco = route.getNblocomotives();
	  ArrayList<CarteWagon> list;
	  list = main.getA(); // on récupère une liste de la main du joueur;
	  int cpt = 0,comparatif = 0;
	   for (int i=0; i<list.size(); i++){
	     if(list.get(i).getCouleur().equals("locomotive") && nbloco != comparatif){
	      comparatif++;
	     }
	     if(list.get(i).getCouleur().equals(couleur) || (list.get(i).getCouleur().equals("locomotive"))){
	      cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
	     }
	   }
	   if (cpt >= nbcases && nbloco == 0){//les conditions sont réunis pour prendre la route.
	    route.setPrise(main.getNomJoueur());
	    int i = 0,nombre = nbcases;;
	    while(nbcases != 0 && nbloco != 0)
	    {
	     if(list.get(i).getCouleur().equals("locomotive") && nbloco != 0){
	      list.remove(i);
	      nbloco--;
	     }
	     else if(list.get(i).getCouleur().equals(reponse)){
	      list.remove(i);
	      nbcases--;
	     }
	     else if(list.get(i).getCouleur().equals(couleur)){
	      list.remove(i);
	      nbcases--;
	     }
	     else if(list.get(i).getCouleur().equals("locomotive")){
	      list.remove(i);
	      nbcases--;
	     }
	     else{
	      i++;}
	    }
	    System.out.println("C'est cool t'as pris la route");
	    main.setNbWagon(main.getNbWagon() - nombre);
	   }
	 }
	
	
	
	/**
	 * acheter une route de type Ferry Double
	 * @param route la route que l'on veut acheter 
	 * @param main la main du joueur qui veut acheter la route
	 */
	public void achatDoubleFerry(FerryDouble route, MainJoueur main){// on veut acheter le 2ème chemin d'une route double
		String couleur2 = route.getCouleur2();// on récupère l'attribut couleur2 de la route
		String reponse = "";
		if(couleur2.equals("gris"))
		{
			System.out.println("Quel couleur de carte voulez vous jouer ? ");
			Scanner sc = new Scanner(System.in);
			reponse = sc.nextLine();
		}
		int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
		int nbloco = route.getNblocomotives();
		ArrayList<CarteWagon> list;
		list = main.getA(); // on récupère une liste de la main du joueur;
		int cpt = 0,comparatif = 0;
			for (int i=0; i<list.size(); i++){
					if(list.get(i).getCouleur().equals("locomotive") && nbloco != comparatif){
						comparatif++;
					}
					if(list.get(i).getCouleur().equals(couleur2) || (list.get(i).getCouleur().equals("locomotive"))){
						cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
					}
			}
			if (cpt >= nbcases && nbloco == 0){//les conditions sont réunis pour prendre la route.
				route.setProprio2(main.getNomJoueur());
				int i = 0,nombre = nbcases;;
				while(nbcases != 0 && nbloco != 0)
				{
					if(list.get(i).getCouleur().equals("locomotive") && nbloco != 0){
						list.remove(i);
						nbloco--;
					}
					else if(list.get(i).getCouleur().equals(reponse)){
						list.remove(i);
						nbcases--;
					}
					else if(list.get(i).getCouleur().equals(couleur2)){
						list.remove(i);
						nbcases--;
					}
					else if(list.get(i).getCouleur().equals("locomotive")){
						list.remove(i);
						nbcases--;
					}
					else{
						i++;}
				}
				System.out.println("C'est cool t'as pris la route");
				main.setNbWagon(main.getNbWagon() - nombre);
			}
	}
	
	
	
	/**
	 * acheter une route de type Ferry avecles attributs d'une route double
	 * @param ville1 ville de départ du Ferry Double
	 * @param ville2 ville d'arrivé du Ferry
	 * @param main la main du joueur concerné
	 */
	public void acheterFerryDouble(String ville1, String ville2, MainJoueur main){
		FerryDouble route = (FerryDouble) chemin.get(ville1).get(ville2); // on récupère la route que l'on veut prendre
		if(!route.getPrise().equals("libre") && (!route.getProprio2().equals("libre"))) System.out.println("espèce de naz la route est déjà prise ");
		if ((route.getProprio2().equals(main.getNomJoueur())) || (route.getPrise().equals(main.getNomJoueur()))) System.out.println("Tu as déjà pris l'une des 2 routes");
		if (route.getProprio2().equals("libre") && (route.getPrise().equals("libre"))){
			System.out.println(" Voulez vous prendre la route " + route.getCouleur() + " (1) ou " + route.getCouleur2() + " (2) \n");
			Scanner sc = new Scanner(System.in);
			int rep;
			rep = sc.nextInt();
			if (rep == 1){
				this.achatDoubleFerryPremier(route, main);
			}
			else this.achatDoubleFerry(route, main);
		}
		if (route.getPrise().equals("libre")) this.achatDoubleFerryPremier(route, main);
		if (route.getProprio2().equals("libre")) this.achatDoubleFerry(route, main);
	}
	
	
	
	/**
	 * méthode pour acheter une route de type Ferry classique 
	 * @param ville1 la ville de départ 
	 * @param ville2 la ville d'arrivé du Ferry
	 * @param main la main caractérisant le joueur voulant prendre le ferry
	 */
	
	public void acheterFerrySimple(String ville1, String ville2, MainJoueur main){

		Ferry route = (Ferry)chemin.get(ville1).get(ville2); // on récupère la route que l'on veut prendre
		if(!route.getPrise().equals("libre")) System.out.println("espèce de naz la route est déjà prise par: " + route.getPrise());
		else{
			String couleur = route.getCouleur();// on récupère l'attribut couleur de la route
			String reponse = "";
			if(couleur.equals("gris"))
			{
				System.out.println("Quel couleur de carte voulez vous jouer ? ");
				Scanner sc = new Scanner(System.in);
				reponse = sc.nextLine();
			}
			int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
			int nbloco = route.getNblocomotives();
			ArrayList<CarteWagon> list;
			list = main.getA(); // on récupère une liste de la main du joueur;
			int cpt = 0,comparatif = 0;
				for (int i=0; i<list.size(); i++){
						if(list.get(i).getCouleur().equals("locomotive") && nbloco != comparatif){
							comparatif++;
						}
						else if(list.get(i).getCouleur().equals(couleur) || (list.get(i).getCouleur().equals("locomotive"))){
							cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
						}
				}

				if (cpt >= nbcases && nbloco == comparatif){//les conditions sont réunis pour prendre la route.
					route.setPrise(main.getNomJoueur());
					int i = 0,nombre = nbcases;;
					while(nbcases != 0 && nbloco != 0)
					{
						if(list.get(i).getCouleur().equals("locomotive") && nbloco != 0){
							list.remove(i);
							nbloco--;
						}
						else if(list.get(i).getCouleur().equals(reponse)){
							list.remove(i);
							nbcases--;
						}
						else if(list.get(i).getCouleur().equals(couleur)){
							list.remove(i);
							nbcases--;
						}
						else if(list.get(i).getCouleur().equals("locomotive")){
							list.remove(i);
							nbcases--;
						}
						else{
							i++;}
					}
					System.out.println("C'est cool t'as pris la route");
					main.setNbWagon(main.getNbWagon() - nombre);
				}
			}
	}
	
	/**
	 * méthode pour acheter une route de type Tunnel avec les attributs d'une route double
	 * @param pioche la pioche de cartes Wagon présente sur le plateau
	 * @param ville1 la ville de départ du Tunnel
	 * @param ville2 la ville d'arrivé du Tunnel
	 * @param main la main courante du joueur
	 */
	public void acheterTunnelDouble(PiocheWagon pioche, String ville1, String ville2, MainJoueur main){
		TunnelDouble route = (TunnelDouble) chemin.get(ville1).get(ville2); // on récupère la route que l'on veut prendre
		if(!route.getPrise().equals("libre") && (!route.getProprio2().equals("libre"))) System.out.println("espèce de naz la route est déjà prise ");
		else if ((route.getProprio2().equals(main.getNomJoueur())) || (route.getPrise().equals(main.getNomJoueur()))) System.out.println("Tu as déjà pris l'une des 2 routes");
		else if (route.getProprio2().equals("libre") && (route.getPrise().equals("libre"))){
			System.out.println(" Voulez vous prendre la route " + route.getCouleur() + " (1) ou " + route.getCouleur2() + " (2) \n");
			Scanner sc = new Scanner(System.in);
			int rep;
			rep = sc.nextInt();
			if (rep == 1){
				this.achatDoubleTunnelPremier(pioche,route, main);
			}
			else this.achatDoubleTunnel(pioche, route, main);
		}
		else if (route.getPrise().equals("libre")) this.achatDoubleTunnelPremier(pioche,route, main);
		else if (route.getProprio2().equals("libre")) this.achatDoubleTunnel(pioche,route, main);
	}

	
	/**
	 * méthode pour acheter une route de type Tunnel classique 
	 * @param pioche la pioche de carte wagon dans laquelle on va pouvoir piocher des cartes afin de respecter les regles du tunnel
	 * @param main la main caractérisant le joueur voulant prendre le ferry
	 * @param ville1 la ville de départ 
	 * @param ville2 la ville d'arrivé du Ferry
	 */
	public void acheterTunnelSimple(PiocheWagon pioche, MainJoueur main, String ville1, String ville2){
		Tunnel route = (Tunnel)chemin.get(ville1).get(ville2); // on récupère la route que l'on veut prendre
		if(!route.getPrise().equals("libre")) System.out.println("espèce de naz la route est déjà prise par: " + route.getPrise());
		else{
			String couleur = route.getCouleur();// on récupère l'attribut couleur de la route
			String reponse = "";
			if(couleur.equals("gris"))
			{
				System.out.println("Quel couleur de carte voulez vous jouer ? ");
				Scanner sc = new Scanner(System.in);
				reponse = sc.nextLine();
				//System.out.println("reponse : "+reponse);
			}
			int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
			ArrayList<CarteWagon> list;
			list = main.getA(); // on récupère une liste de la main du joueur;
			int cpt = 0;
				for (int i=0; i<list.size(); i++){
					if(couleur.equals("gris"))
					{
						if((list.get(i).getCouleur().equals(reponse) || (list.get(i).getCouleur().equals("locomotive")))) cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
					}
					if(!couleur.equals("gris"))
					{
						if((list.get(i).getCouleur().equals(couleur) || (list.get(i).getCouleur().equals("locomotive")))) cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
					}
				}
				//System.out.println("Le compteur est egale a : "+cpt);
				//System.out.println("nbcases : "+nbcases);
				if (cpt >= nbcases){//les conditions sont réunis pour prendre la route.
					ArrayList<CarteWagon> cartes = new ArrayList<CarteWagon>();

					for(int i = 0 ; i < 3 ; i ++)
					{
						cartes.add(pioche.PiocherCarte());
					}
					System.out.println("1)"+cartes.get(0).getCouleur());
					System.out.println("2)"+cartes.get(1).getCouleur());
					System.out.println("3)"+cartes.get(2).getCouleur());

						
					for (int i=0; i<3; i++){
						if(cartes.get(i).getCouleur().equals(reponse) || cartes.get(i).getCouleur().equals(couleur) || cartes.get(i).getCouleur().equals("locomotive") ){
							nbcases++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
						}
					}
					//System.out.println("est maintenant il faut : "+nbcases);
					int comparaison = nbcases;
					if(cpt >= comparaison)//maintenant le nombre de carte qu'il faut mettre a été augmenté, donc on compare de nouveau si on a le bon nombre de carte
					{
						route.setPrise(main.getNomJoueur());
						
						int i = 0;
						while(nbcases != 0)
						{
							if(list.get(i).getCouleur().equals(reponse))
							{

								list.remove(i);
								nbcases--;

								
							}
							else if(list.get(i).getCouleur().equals(couleur))
							{

								list.remove(i);
								nbcases--;
							}
							else if((list.get(i).getCouleur().equals("locomotive")))
							{

								list.remove(i);
								nbcases--;
							}
							else{
							i++;
							}
						}
						System.out.println("C'est cool t'as pris la route");
						main.setNbWagon(main.getNbWagon() - comparaison);
					}
				}
			}
	}
	
	
	/**
	 * on veut acheter la première route d'un tunnel double
	 * @param pioche la pioche de cartes Wagon
	 * @param route la route que l'on veut prendre 
	 * @param main la main du joueur concerné
	 */
	public void achatDoubleTunnelPremier(PiocheWagon pioche, TunnelDouble route, MainJoueur main){// on veut acheter le 2ème chemin d'une route double
		String couleur = route.getCouleur();// on récupère l'attribut couleur de la route
		String reponse = "";
		if(couleur.equals("gris"))
		{
			System.out.println("Quel couleur de carte voulez vous jouer ? ");
			Scanner sc = new Scanner(System.in);
			reponse = sc.nextLine();
		}
		int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
		ArrayList<CarteWagon> list;
		list = main.getA(); // on récupère une liste de la main du joueur;
		int cpt = 0;
			for (int i=0; i<list.size(); i++){
				if(couleur.equals("gris"))
				{
					if((list.get(i).getCouleur().equals(reponse) || (list.get(i).getCouleur().equals("locomotive")))) cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
				if(!couleur.equals("gris"))
				{
					if((list.get(i).getCouleur().equals(couleur) || (list.get(i).getCouleur().equals("locomotive")))) cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
			}
			if (cpt >= nbcases){//les conditions sont réunis pour prendre la route.
				ArrayList<CarteWagon> cartes = new ArrayList<CarteWagon>();

				for(int i = 0 ; i < 3 ; i ++)
				{
					cartes.add(pioche.PiocherCarte());
				}
				System.out.println("1)"+cartes.get(0).getCouleur());
				System.out.println("2)"+cartes.get(1).getCouleur());
				System.out.println("3)"+cartes.get(2).getCouleur());
					
				for (int i=0; i<3; i++){
					if(cartes.get(i).getCouleur().equals(reponse)||cartes.get(i).getCouleur().equals(couleur) || cartes.get(i).getCouleur().equals("locomotive")){
						nbcases++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
					}
				}
				int comparaison = nbcases;
				if(cpt >= comparaison)//maintenant le nombre de carte qu'il faut mettre a été augmenté, donc on compare de nouveau si on a le bon nombre de carte
				{
					route.setPrise(main.getNomJoueur());
					
					int i = 0;
					while(nbcases != 0)
					{
						if(list.get(i).getCouleur().equals(reponse))
						{
							list.remove(i);
							nbcases--;
						}
						else if(list.get(i).getCouleur().equals(couleur))
						{
							list.remove(i);
							nbcases--;
						}
						else if((list.get(i).getCouleur().equals("locomotive")))
						{
							list.remove(i);
							nbcases--;
						}
						else{
							i++;}
					}
					System.out.println("C'est cool t'as pris la route");
					main.setNbWagon(main.getNbWagon() - nbcases);
				}
			}
	}
	
	
	
	
	/**
	 * méthode pour acheter soit la première soit la deuxième route d'un tunnel double
	 * @param pioche la pioche de cartes Wagon présente sur le plateau 
	 * @param route la route de type tunnel double que l'on veut prendre
	 * @param main la main du joueur concerné par l'achat
	 */

	public void achatDoubleTunnel(PiocheWagon pioche, TunnelDouble route, MainJoueur main){// on veut acheter le 2ème chemin d'une route double
		String couleur2 = route.getCouleur2();// on récupère l'attribut couleur de la route
		String reponse = "";
		if(couleur2.equals("gris"))
		{
			System.out.println("Quel couleur de carte voulez vous jouer ? ");
			Scanner sc = new Scanner(System.in);
			reponse = sc.nextLine();
		}
		int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
		ArrayList<CarteWagon> list;
		list = main.getA(); // on récupère une liste de la main du joueur;
		int cpt = 0;
			for (int i=0; i<list.size(); i++){
				if(couleur2.equals("gris"))
				{
					if((list.get(i).getCouleur().equals(reponse) || (list.get(i).getCouleur().equals("locomotive")))) cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
				if(!couleur2.equals("gris"))
				{
					if((list.get(i).getCouleur().equals(couleur2) || (list.get(i).getCouleur().equals("locomotive")))) cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
			}
			if (cpt >= nbcases){//les conditions sont réunis pour prendre la route.
				ArrayList<CarteWagon> cartes = new ArrayList<CarteWagon>();

				for(int i = 0 ; i < 3 ; i ++)
				{
					cartes.add(pioche.PiocherCarte());
				}
				System.out.println("1)"+cartes.get(0).getCouleur());
				System.out.println("2)"+cartes.get(1).getCouleur());
				System.out.println("3)"+cartes.get(2).getCouleur());
					
				for (int i=0; i<3; i++){
					if(cartes.get(i).getCouleur().equals(reponse)||cartes.get(i).getCouleur().equals(couleur2) || cartes.get(i).getCouleur().equals("locomotive")){
						nbcases++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
					}
				}
				int comparaison = nbcases;
				if(cpt >= comparaison)//maintenant le nombre de carte qu'il faut mettre a été augmenté, donc on compare de nouveau si on a le bon nombre de carte
				{
					route.setProprio2(main.getNomJoueur());
					
					int i = 0;
					while(nbcases != 0)
					{
						if(list.get(i).getCouleur().equals(reponse))
						{
							list.remove(i);
							nbcases--;
						}
						else if(list.get(i).getCouleur().equals(couleur2))
						{
							list.remove(i);
							nbcases--;
						}
						else if((list.get(i).getCouleur().equals("locomotive")))
						{
							list.remove(i);
							nbcases--;
						}
						else{
							i++;}
					}
					System.out.println("C'est cool t'as pris la route");
					main.setNbWagon(main.getNbWagon() - nbcases);
				}
			}
	}
	
	/**
	 * acheter une route classique
	 * @param ville1 ville de départ de la route
	 * @param ville2 ville d'arrivé de la route 
	 * @param main la main courante du joueur conerné
	 */
	public void acheterRouteSimple(String ville1, String ville2, MainJoueur main){ // on échète une route simple;
		Route route = (Route)chemin.get(ville1).get(ville2); // on récupère la route que l'on veut prendre
		if(!route.getPrise().equals("libre"))
		{
			JOptionPane.showConfirmDialog(fenetre.getPannel(),

		            "La route est déjà prise", "erreur",

		            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			String couleur = route.getCouleur();// on récupère l'attribut couleur de la route
			String reponse = "";

			if(couleur.equals("gris"))
			{
				System.out.println("gris");
				DemanderCouleur demanderCouleur = new DemanderCouleur(fenetre.getPanneau());
				reponse = demanderCouleur.getCouleur();
				System.out.println("LA reponse est : " +reponse);
				/*System.out.println("Quel couleur de carte voulez vous jouer ? ");
				Scanner sc4 = new Scanner(System.in);
				reponse = sc4.nextLine();*/
			}
			System.out.println("dehors");
			int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
			ArrayList<CarteWagon> list;
			list = main.getA(); // on récupère une liste de la main du joueur;
			int cpt = 0;
				for (int i=0; i<list.size(); i++){
					if(    (couleur.equals("gris") && list.get(i).getCouleur().equals(reponse))     ||      (list.get(i).getCouleur().equals("locomotive")) || (!couleur.equals("gris") && (list.get(i).getCouleur().equals(couleur))))
					{
							cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
					}
				}

				if (cpt >= nbcases){//les conditions sont réunis pour prendre la route.
					route.setPrise(main.getNomJoueur());
					int i = 0, nombre = nbcases, taille = list.size();
					while(nbcases != 0 && i < taille)
					{

						if(list.get(i).getCouleur().equals(reponse))
						{

							list.remove(i);
							nbcases--;
							
						}
						else if(list.get(i).getCouleur().equals(couleur))
						{

							list.remove(i);
							
							nbcases--;
						}
						else if((list.get(i).getCouleur().equals("locomotive")))
						{

							list.remove(i);
							nbcases--;
						}
						else{
							i++;}
					} 
					System.out.println("C'est cool t'as pris la route");
					main.setNbWagon(main.getNbWagon() - nombre);
					fenetre.getPannel().repaint(172,0,815,565);
				}
			}
	}
	
	/**
	 * acheter une route classique de type double
	 * @param ville1 ville de départ de la route double
	 * @param ville2 ville d'arrivée de la route double
	 * @param main la main courante du joueur
	 */
	
	public void acheterRouteDouble(String ville1, String ville2, MainJoueur main){
		RouteDouble route = (RouteDouble) chemin.get(ville1).get(ville2); // on récupère la route que l'on veut prendre
		if(!route.getPrise().equals("libre") && (!route.getProprio2().equals("libre"))) System.out.println("espèce de naz la route est déjà prise ");
		else if ((route.getProprio2().equals(main.getNomJoueur())) || (route.getPrise().equals(main.getNomJoueur()))) System.out.println("Tu as déjà pris l'une des 2 routes");
		else if (route.getProprio2().equals("libre") && (route.getPrise().equals("libre"))){
			System.out.println(" Voulez vous prendre la route " + route.getCouleur() + " (1) ou " + route.getCouleur2() + " (2) \n");
			Scanner sc = new Scanner(System.in);
			int rep;
			rep = sc.nextInt();
			if (rep == 1){
				this.achatDoublePremier(route, main);
			}
			else this.achatDouble(route, main);
		}
		else if (route.getPrise().equals("libre"))  this.achatDoublePremier(route, main);
		else if (route.getProprio2().equals("libre")) this.achatDouble(route, main);
	}
	
	/**
	 * acheter la première route d'une route double
	 * @param route la route en question
	 * @param main la main du joueur concerné
	 */
	public void achatDoublePremier(RouteDouble route, MainJoueur main){// on veut acheter le 1er chemin d'une route double
		String couleur = route.getCouleur();// on récupère l'attribut couleur de la  1ère route
		String reponse = "";
		if(couleur.equals("gris"))
		{
			System.out.println("Quel couleur de carte voulez vous jouer ? ");
			Scanner sc = new Scanner(System.in);
			reponse = sc.nextLine();
		}
		int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
		ArrayList<CarteWagon> list;
		list = main.getA(); // on récupère une liste de la main du joueur;
		int cpt = 0;
			for (int i=0; i<list.size(); i++){
				if(couleur.equals("gris") && (list.get(i).getCouleur().equals(reponse) || (list.get(i).getCouleur().equals("locomotive"))))
				{
						cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
				if(!couleur.equals("gris") && (list.get(i).getCouleur().equals(couleur) || (list.get(i).getCouleur().equals("locomotive"))))
				{
						cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
			}
			if (cpt >= nbcases){//les conditions sont réunis pour prendre la route.
				route.setPrise(main.getNomJoueur());
				int i = 0, nombre = nbcases;
				while(nbcases != 0)
				{
					if(list.get(i).getCouleur().equals(reponse))
					{
						list.remove(i);
						nbcases--;
					}
					else if(list.get(i).getCouleur().equals(couleur))
					{
						list.remove(i);
						nbcases--;
					}
					else if((list.get(i).getCouleur().equals("locomotive")))
					{
						list.remove(i);
						nbcases--;
					}
					else{
					i++;}
				}
				System.out.println("C'est cool t'as pris la route");
				main.setNbWagon(main.getNbWagon() - nombre);
			}
			else{System.out.println("Vous n'êtes pas en mesure de prendre ce chemin");}
	}
	
	
	/**
	 * acheter la 2ème route de la route double
	 * @param route la route double en question
	 * @param main la main courante du joueur concerné
	 */
	public void achatDouble(RouteDouble route, MainJoueur main){// on veut acheter le 2ème chemin d'une route double
		String couleur2 = route.getCouleur2();// on récupère l'attribut couleur2 de la route
		String reponse = "";
		if(couleur2.equals("gris"))
		{
			System.out.println("Quel couleur de carte voulez vous jouer ? ");
			Scanner sc = new Scanner(System.in);
			reponse = sc.nextLine();
		}
		int nbcases = route.getNbcases();	// on récupère l'attribut nbcases de la route
		ArrayList<CarteWagon> list;
		list = main.getA(); // on récupère une liste de la main du joueur;
		int cpt = 0;
			for (int i=0; i<list.size(); i++){
				if(couleur2.equals("gris") && (list.get(i).getCouleur().equals(reponse) || (list.get(i).getCouleur().equals("locomotive"))))
				{
						cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
				if(!couleur2.equals("gris") && (list.get(i).getCouleur().equals(couleur2) || (list.get(i).getCouleur().equals("locomotive"))))
				{
						cpt++;//on comptabilise les cartes couleurs et locomotives contenues dans la main du joueur;
				}
			}
			if (cpt >= nbcases){//les conditions sont réunis pour prendre la route.
				route.setProprio2(main.getNomJoueur());
				int i = 0, nombre = nbcases;
				while(nbcases != 0)
				{
					if(list.get(i).getCouleur().equals(reponse))
					{
						list.remove(i);
						nbcases--;
					}
					else if(list.get(i).getCouleur().equals(couleur2))
					{
						list.remove(i);
						nbcases--;
					}
					else if((list.get(i).getCouleur().equals("locomotive")))
					{
						list.remove(i);
						nbcases--;
					}
					else{
					i++;}
				}
				System.out.println("C'est cool t'as pris la route");
				main.setNbWagon(main.getNbWagon() - nombre);
			}
	}
	
	

	/**
	 * fonction d'initialisation de toutes les routes du plateau de jeu
	 * @param terrain le terrain sur lequel on veut jouer
	 */
	//attention il faut différencier les routes simples des routes doubles!!!
	public void initialisation(Plateau terrain){
		  terrain.inserer("Paris","Dieppe", new Route("violet", 1, false));
		  terrain.inserer("Brest", "Pamplona", new Route("violet", 4, false));
		  terrain.inserer("Paris","Brest", new Route("noir", 3, false));
		  terrain.inserer("Pamplona", "Madrid", new TunnelDouble("noir", 1, "blanc"));
		  terrain.inserer("Dieppe", "London", new Ferry("gris", 2, 1,false));
		  terrain.inserer("Paris", "Pamplona", new RouteDouble("bleu" , 1, "vert"));
		  terrain.inserer("Paris", "Marseille",new Route("gris", 4, false));
		  terrain.inserer("Paris", "Zurich",new Tunnel("gris", 4, false));
		  terrain.inserer("Paris", "Frankfurt",new RouteDouble("blanc" , 3, "orange"));
		  terrain.inserer("Paris", "Bruxelles",new RouteDouble("jaune" , 2,"rouge"));
		  terrain.inserer("Dieppe", "Bruxelles",new Route("rouge", 2, false));
		  terrain.inserer("Dieppe", "Brest",new Route("orange", 2, false));
		  terrain.inserer("Pamplona", "Marseille", new Tunnel("rouge", 4, false));
		  terrain.inserer("Pamplona", "Barcelona", new Tunnel("gris", 2, false));
		  terrain.inserer("Madrid", "Barcelona", new Route("jaune", 2, false));
		  terrain.inserer("Madrid", "Lisboa", new Route("violet", 3, false));
		  terrain.inserer("Madrid", "Cadiz", new Route("orange", 3, false));
		  terrain.inserer("Lisboa", "Cadiz", new Route("bleu", 2, false));
		  terrain.inserer("Barcelona", "Marseille", new Route("gris", 4, false));
		  terrain.inserer("Paris", "Bruxelles",new RouteDouble("jaune" , 2,"rouge"));
		  terrain.inserer("London", "Edimburgh", new RouteDouble("vert", 4, "orange"));
		  terrain.inserer("London", "Amsterdam",new Ferry("gris", 2, 2, false));
		  terrain.inserer("Amsterdam", "Essen", new Route("jaune", 3, false));
		  terrain.inserer("Amsterdam", "Bruxelles", new Route("noir", 1, false));
		  terrain.inserer("Amsterdam", "Frankfurt", new Route("blanc", 2, false));
		  terrain.inserer("Bruxelles", "Frankfurt", new Route("bleu", 2, false));
		  terrain.inserer("Frankfurt", "Munchen", new Route("violet", 2, false));
		  terrain.inserer("Frankfurt", "Berlin", new RouteDouble("noir",3 , "rouge"));
		  terrain.inserer("Frankfurt", "Essen", new Route("vert", 2, false));
		  terrain.inserer("Essen", "Kobenhavn",new FerryDouble("gris", 3, 1, "gris"));
		  terrain.inserer("Essen", "Berlin", new Route("bleu", 2, false));
		  terrain.inserer("Kobenhavn", "Stockholm", new RouteDouble("jaune", 3, "blanc"));
		  terrain.inserer("Stockholm", "Petrograd", new Tunnel("gris", 8, false));
		  terrain.inserer("Berlin", "Danzig", new Route("gris", 4, false));
		  terrain.inserer("Berlin", "Warszawa",new RouteDouble("violet", 4, "jaune"));
		  terrain.inserer("Berlin", "Wien", new Route("vert", 3, false));
		  terrain.inserer("Danzig", "Riga", new Route("noir", 3, false));
		  terrain.inserer("Danzig", "Warszawa", new Route("gris", 2, false));
		  terrain.inserer("Warszawa", "Wilno", new Route("rouge", 3, false));
		  terrain.inserer("Warszawa", "Kyiv", new Route("gris", 4, false));
		  terrain.inserer("Riga", "Petrograd", new Route("gris", 4, false));
		  terrain.inserer("Riga", "Wilno", new Route("vert", 4, false));
		  terrain.inserer("Petrograd", "Moskva", new Route("blanc", 4, false));
		  terrain.inserer("Wilno", "Petrograd", new Route("bleu", 4, false));
		  terrain.inserer("Wilno", "Smolensk", new Route("jaune", 3, false));
		  terrain.inserer("Wilno", "Kyiv", new Route("gris", 2, false));
		  terrain.inserer("Smolensk", "Moskva", new Route("orange", 2, false));
		  terrain.inserer("Smolensk", "Kyiv", new Route("rouge", 3, false));
		  terrain.inserer("Smolensk", "Kharkov", new Route("gris", 4, false));
		  terrain.inserer("Kyiv", "Kharkov", new Route("gris", 4, false));
		  terrain.inserer("Kyiv", "Bucuresti", new Route("gris", 4, false));
		  terrain.inserer("Kharkov", "Kostov", new Route("vert", 2, false));
		  terrain.inserer("Kostov", "Sochi", new Route("gris", 2, false));
		  terrain.inserer("Kostov", "Sevastopol", new Route("gris", 4, false));
		  terrain.inserer("Sochi", "Erzurum", new Tunnel("rouge", 3, false));
		  terrain.inserer("Sochi", "Sevastopol", new Ferry("gris", 2, 1, false));
		  terrain.inserer("Sevastopol", "Bucuresti", new Route("blanc", 4, false));
		  terrain.inserer("Sevastopol", "Erzurum", new Ferry("gris", 4, 2, false));
		  terrain.inserer("Sevastopol", "Constantinople", new Ferry("gris", 4, 2, false));
		  terrain.inserer("Erzurum", "Angora", new Route("noir", 3, false));
		  terrain.inserer("Angora", "Constantinople", new Tunnel("gris", 2, false));
		  terrain.inserer("Angora", "Smyrna", new Tunnel("orange", 3, false));
		  terrain.inserer("Constantinople", "Smyrna", new Tunnel("gris", 2, false));
		  terrain.inserer("Constantinople", "Bucuresti", new Route("jaune", 3, false));
		  terrain.inserer("Constantinople", "Sofia", new Route("bleu", 3, false));
		  terrain.inserer("Smyrna", "Athina", new Ferry("gris", 2, 1, false));
		  terrain.inserer("Smyrna", "Palermo", new Ferry("gris", 6, 2, false));
		  terrain.inserer("Bucuresti", "Budapest", new Tunnel("gris", 4, false));
		  terrain.inserer("Bucuresti", "Sofia", new Tunnel("gris", 2, false));
		  terrain.inserer("Sofia", "Sarajevo", new Tunnel("gris", 2, false));
		  terrain.inserer("Sofia", "Athina", new Route("violet", 3, false));
		  terrain.inserer("Athina", "Sarajevo", new Route("vert", 4, false));
		  terrain.inserer("Athina", "Brindisi", new Route("gris", 4, false));
		  terrain.inserer("Palermo", "Brindisi", new Route("bleue", 3, false));
		  terrain.inserer("Palermo", "Roma", new Route("gris", 4, false));
		  terrain.inserer("Brindisi", "Roma", new Route("noire", 2, false));
		  terrain.inserer("Roma", "Marseille", new Route("gris", 4, false));
		  terrain.inserer("Roma", "Venezia", new Route("noire", 2, false));
		  terrain.inserer("Venezia", "Zagrab", new Route("jaune", 2, false));
		  terrain.inserer("Munchen", "Wien",  new Route("orange", 3, false));
		  terrain.inserer("Sarajevo", "Zagrab", new Route("rouge", 3, false));
		  terrain.inserer("Sarajevo", "Budapest",  new Route("violet", 3, false));
		  terrain.inserer("Zagrab", "Wien", new Route("jaune", 2, false));
		  terrain.inserer("Zagrab", "Budapest", new Route("orange", 2, false));
		  terrain.inserer("Wien", "Budapest", new RouteDouble("blanche", 1, "rouge"));
		  terrain.inserer("Wien", "Warszawa", new Route("bleue", 4, false));
		  terrain.inserer("Marseille", "Zurich",   new Route("violet", 2, false));
		  terrain.inserer("Zurich", "Venezia",  new Tunnel("verte", 2, false));
		  terrain.inserer("Zurich", "Munchen",  new Tunnel("jaune", 2, false));
		  terrain.inserer("Venezia", "Munchen",  new Tunnel("bleue", 2, false));
		  terrain.inserer("Budapest", "Kyiv",  new Tunnel("gris", 6, false));
		 }
	
}
