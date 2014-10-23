import java.util.ArrayList;
import java.util.Scanner;



/**
 * la classe principal comprenant le main
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class Jeu {

	public static void main(String[] args) {
		PiocheWagon piocheCarteWagon = new PiocheWagon(); 
		PiocheDest piocheCarteDest = new PiocheDest(); 
		CartesVisible piocheCarteVisible = new CartesVisible(piocheCarteWagon);
		ArrayList<MainJoueur> tabJoueur = new ArrayList<MainJoueur>();
		Plateau terrain = new Plateau(null);
		terrain.initialisation(terrain);
		new Accueil("Les aventuriers du rail",imageFond.CENTRE, piocheCarteWagon, piocheCarteDest, piocheCarteVisible, tabJoueur, terrain);

		
		
		/*Scanner sc = new Scanner(System.in);
		int reponse;
		do{
		System.out.println("Combien de joueur y a-t-il ?");
		 reponse = sc.nextInt();
		}while(reponse < 2 || reponse > 5);
		String nom = "";
		for(int i = 0 ; i < reponse ; i++)
		{
			System.out.println("Quel est le nom du joueur : " +(i+1));
			Scanner sc2 = new Scanner(System.in);
			nom = sc2.nextLine();
			tabJoueur.add(new MainJoueur(nom,piocheCarteWagon));
			tabJoueur.get(i).ajoutCarteDest(piocheCarteDest);
		}
		
		//Fenetre fenetre = new Fenetre(piocheCarteVisible,tabJoueur,piocheCarteDest,piocheCarteWagon);
		
		int i = 0;
		while(tabJoueur.get(i).getNbWagon() > 1)
		{
			int reponse2 = 0;

			System.out.println("La main de "+tabJoueur.get(i).getNomJoueur()+" est composé de : "+tabJoueur.get(i));
			System.out.println("Quel action voulez vous réaliser "+tabJoueur.get(i).getNomJoueur());
			System.out.println("1) Poser un wagon ");
			System.out.println("2) Piocher carte wagon");
			System.out.println("3) Piocher carte destination");
			System.out.println("4) Poser gare");
			Scanner sc3 = new Scanner(System.in);
				do{
					reponse2 = sc3.nextInt();
				}while(reponse2 < 1 || reponse2 >4);



			switch(reponse2)
			{
				case 1:
					String ville1 ="", ville2 ="";
					Scanner sc4 = new Scanner(System.in);
					Scanner sc5 = new Scanner(System.in);
					System.out.println("Veuillez entrer votre ville de départ");
					ville1 = sc4.nextLine();
					System.out.println("Veuillez entrer votre ville d'arrivée");
					ville2 = sc5.nextLine();
					terrain.acheter(ville1, ville2, tabJoueur.get(i), piocheCarteWagon);
					System.out.println("La main du joueur est maintenant composé de : " +tabJoueur.get(i));
					break;
				case 2:
					//tabJoueur.get(i).ajoutCarteWagon(piocheCarteVisible, piocheCarteWagon);
					System.out.println("Main du joueur est : "+tabJoueur.get(i));
					break;
				case 3:
					tabJoueur.get(i).ajoutCarteDest(piocheCarteDest);
					break;
				case 4:
					String ville3 ="", ville4 ="";
					Scanner sc6 = new Scanner(System.in);
					Scanner sc7 = new Scanner(System.in);
					System.out.println("Veuillez entrer votre ville de départ");
					ville3 = sc6.nextLine();
					System.out.println("Veuillez entrer votre ville d'arrivée");
					ville4 = sc7.nextLine();
					terrain.construireGare(ville3, ville4, tabJoueur.get(i));
					break;
			}
			 //calcul du score courant à chaque fin de tour 
			tabJoueur.get(i).getScore().scoreCourant(tabJoueur.get(i).getNomJoueur(), terrain);
			System.out.println("Score : "+tabJoueur.get(i).getScore().getScoreCourant()+"\n");
			if(i == 1) i = 0;
			else i++;
		}
		// calcul et affichage du score final de chaque joueur.
		for (int j=0; j<tabJoueur.size();j++){
			int scorefinal = 0;
			scorefinal = tabJoueur.get(j).getScore().scorefinal(tabJoueur.get(j), terrain);
			System.out.println("le joueur " + tabJoueur.get(j).getNomJoueur() + " obtient le score  de " + scorefinal + "\n");
		}*/
	}
}
