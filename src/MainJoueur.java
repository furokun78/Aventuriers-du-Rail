



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainJoueur {
	
	protected ArrayList<CarteWagon> a;
	protected ArrayList<CarteDest> b;
	protected int nbGare;
	protected String nomJoueur;
	protected int nbWagon;
	protected CalculScores score;
	

	

	public MainJoueur(String nom, PiocheWagon piocheCarteWagon)
	{
		a = new ArrayList<CarteWagon>();
		for(int i = 0 ; i < 4 ; i++)
		{
			int nombre = (int)(Math.random() * piocheCarteWagon.getA().size());
			CarteWagon autre = piocheCarteWagon.getA().get(nombre);
			piocheCarteWagon.getA().remove(nombre);
			a.add(autre);
		}
		b = new ArrayList<CarteDest>();
		nbGare = 3;
		this.nomJoueur = nom;
		this.nbWagon = 3;
		score = new CalculScores(0);
	}
	
	
	public CalculScores getScore() {
		return score;
	}

	public void setScore(CalculScores score) {
		this.score = score;
	}

	public int getNbWagon() {
		return nbWagon;
	}

	public void setNbWagon(int nbWagon) {
		this.nbWagon = nbWagon;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public int getNbGare() {
		return nbGare;
	}

	public void setNbGare(int nbGare) {
		this.nbGare = nbGare;
	}

	public ArrayList<CarteWagon> getA() {
		return a;
	}

	public ArrayList<CarteDest> getB() {
		return b;
	}

	public void ajoutCarteDest(PiocheDest pioche){
		ArrayList<CarteDest> cartes = new ArrayList<CarteDest>();
		System.out.println("Veuillez choisir 1 ou plusieurs carte(s) destination");
		int j = 0;
			while( j < 3 && !pioche.getA().isEmpty() )
			{
				cartes.add(pioche.PiocherCarte());
				j++;
			}
			for(int z = 0 ; z < 3 && z < cartes.size() ; z++) {
				System.out.println(z+1+")"+cartes.get(z));
			}
			
			
			Scanner sc = new Scanner (System.in);
			String nombre = sc.nextLine();
			Scanner autre = new Scanner (nombre);
			int valeur;
			boolean []tableau = {false,false,false};
			while(autre.hasNextInt())
			{
				valeur = autre.nextInt();
				try {
					switch(valeur)
					{
					
						case 1 :
							b.add(cartes.get(0));
							tableau[0] = true;
							break;
						case 2 :
							b.add(cartes.get(1));
							tableau[1] = true;
							break;
						case 3 :
							b.add(cartes.get(2));
							tableau[2] = true;
							break;
					
					}
				}catch(IndexOutOfBoundsException e){System.out.println("La valeur entrée ne correspond a aucune carte");}
			}
			for(int i = 0 ; i < 3 && i < cartes.size() ; i++)
			{
				if(tableau[i] == false) pioche.getA().add(cartes.get(i));
			}
			
			
			System.out.println("Le joueur a pris les cartes : ");
			for(int i = 0 ; i < b.size() ; i++)
			{
				System.out.println(b.get(i));

			}
			System.out.println();
		}
}