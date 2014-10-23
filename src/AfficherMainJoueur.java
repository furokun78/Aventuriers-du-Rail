import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



/**
 * la classe permettant d'afficher la main du joueur (en bas à droite de la fenêtre
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class AfficherMainJoueur extends JPanel implements ImageAfficher{

	private ArrayList<CarteWagon> tabJoueur;
	private String resultat, ville1="",ville2="";
	private String nomJoueur;

	/**
	 * le constructeur de l'affichage de la main du joueur
	 * @param pTabJoueur arraylist de cartes wagons représentant la main du joueur
	 * @param nomJoueur le nom du joueur
	 */
	public AfficherMainJoueur(ArrayList<CarteWagon> pTabJoueur, String nomJoueur)
	{
		tabJoueur = pTabJoueur;
		this.nomJoueur = nomJoueur;
	}
/**
 * la méthode permettant de dessiner sur le panel 
 * @param g le graphics 
 */
	public void dessiner(Graphics g){
	
        try {
                Image bleu = ImageIO.read(new File("wagon bleu.jpg"));
                Image rouge = ImageIO.read(new File("wagon rouge.jpg"));
                Image violet = ImageIO.read(new File("wagon violet.jpg"));
                Image blanc = ImageIO.read(new File("wagon blanc.jpg"));
                Image vert = ImageIO.read(new File("wagon vert.jpg"));
                Image noir = ImageIO.read(new File("wagon noir.jpg"));
                Image jaune = ImageIO.read(new File("wagon jaune.jpg"));
                Image orange = ImageIO.read(new File("wagon orange.jpg"));
                Image locomotive = ImageIO.read(new File("locomotive.jpg"));
               
                //On affiche le nom du Joueur
            	g.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        		g.setColor(Color.BLACK);
        		g.drawString("C'est au tour de: " +nomJoueur, 560, 589);
        		
                
                ArrayList<CarteWagon> copietab = new ArrayList<CarteWagon>();
                //comptage du nombres de cartes identiques dans la main du joueur et création d'un nouveau tableau
                // ne comptenant qu'une seul fois chaque type de carte
                int cartesbleu = 0;
                int cartesrouge = 0;
                int cartesviolet = 0;
                int cartesblanc = 0;
                int cartesvert = 0;
                int cartesnoir= 0;
                int cartesjaune = 0;
                int cartesorange = 0;
                int cartesloco = 0;
                
	           for (int x = 0; x < tabJoueur.size(); x++){
	                if (tabJoueur.get(x).getCouleur().equals("bleu")){cartesbleu++;}
	                else if(tabJoueur.get(x).getCouleur().equals("rouge")){cartesrouge++;}
	                else if(tabJoueur.get(x).getCouleur().equals("violet")){cartesviolet++;}
	                else  if(tabJoueur.get(x).getCouleur().equals("blanc")){cartesblanc++;}
	                else   if(tabJoueur.get(x).getCouleur().equals("vert")){cartesvert++;}
	                else  if(tabJoueur.get(x).getCouleur().equals("noir")){cartesnoir++;}
	                else   if(tabJoueur.get(x).getCouleur().equals("jaune")){cartesjaune++;}
	                else  if(tabJoueur.get(x).getCouleur().equals("orange")){cartesorange++;}
	                else   if(tabJoueur.get(x).getCouleur().equals("locomotive")){cartesloco++;}
	            }	

                    if (cartesbleu > 0){copietab.add(new CarteWagon("bleu"));}
                    if(cartesjaune > 0){copietab.add(new CarteWagon("jaune"));}
                    if(cartesrouge > 0){copietab.add(new CarteWagon("rouge")); }
                    if(cartesvert > 0){copietab.add(new CarteWagon("vert"));}
                    if(cartesorange > 0){copietab.add(new CarteWagon("orange"));}
                    if(cartesloco > 0){copietab.add(new CarteWagon("locomotive"));}
                    if(cartesblanc > 0){copietab.add(new CarteWagon("blanc"));}
                    if(cartesnoir > 0){copietab.add(new CarteWagon("noir"));}
                    if(cartesviolet > 0){copietab.add(new CarteWagon("violet"));}
                    
                
        
                int i = 375;
                if (tabJoueur.size()<= 5){// affichage normal si le nombre de cartes ne dépasse pas 5
                	
                for(int j = 0 ; j < tabJoueur.size() ; j ++)
                {
                	if(tabJoueur.get(j).getCouleur().equals("bleu")){ g.drawImage(bleu, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("rouge")){g.drawImage(rouge, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("jaune")){g.drawImage(jaune, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("vert")){g.drawImage(vert, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("blanc")){;g.drawImage(blanc, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("orange")){g.drawImage(orange, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("violet")){g.drawImage(violet, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("noir")) {g.drawImage(noir, i, 750-135, this);}
                	if(tabJoueur.get(j).getCouleur().equals("locomotive")){g.drawImage(locomotive, i,750-135, this);}
                	i = i + 103;
                }
               }
                else { // on superpose les cartes pour gagner de la place. et on écrit combien il y en a de la mm couleur
                	g.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 15));
                	 for(int j = 0 ; j < copietab.size() ; j ++)
                     {
                     	if(copietab.get(j).getCouleur().equals("bleu")){ 
                     		g.drawImage(bleu, i, 750-135, this);
                     		g.drawString("x" + cartesbleu +"",i+5, 675);
                     	 }
                     	if(copietab.get(j).getCouleur().equals("rouge")){
                     		g.drawImage(rouge, i, 750-135, this);
                     		g.drawString("x" + cartesrouge +"",i+5, 675);
                     		
                     		}
                     	if(copietab.get(j).getCouleur().equals("jaune")){
                     		g.drawImage(jaune, i, 750-135, this);
                     		g.drawString("x" + cartesjaune +"",i+5, 675);
                     		
                     	}
                     	if(copietab.get(j).getCouleur().equals("vert")){
                     		g.drawImage(vert, i, 750-135, this);
                     		g.drawString("x" + cartesvert +"",i+5, 675);
                     		
                     	}
                     	if(copietab.get(j).getCouleur().equals("blanc")){
                     		g.drawImage(blanc, i, 750-135, this);
                     		g.drawString("x" + cartesblanc +"",i+5, 675);
                     	}
                     	if(copietab.get(j).getCouleur().equals("orange")){
                     		g.drawImage(orange, i, 750-135, this);
                     		g.drawString("x" + cartesorange +"",i+5, 675);
                     	}
                     	if(copietab.get(j).getCouleur().equals("violet")){
                     		g.drawImage(violet, i, 750-135, this);
                     		g.drawString("x" + cartesviolet+"",i+5, 675);
                     	}
                     	if(copietab.get(j).getCouleur().equals("noir")) {
                     		g.drawImage(noir, i, 750-135, this);
                     		g.drawString("x" + cartesnoir +"",i+5, 675);
                     	}
                     	if(copietab.get(j).getCouleur().equals("locomotive")){
                     		g.drawImage(locomotive, i,750-135, this);
                     		g.drawString("x" + cartesloco +"",i+5, 675);               
                     	}
                     	i = i +  (103 - (copietab.size() *5));
                     }
                }
        } catch (IOException e) {e.printStackTrace();}
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public ArrayList<CarteWagon> getTabJoueur() {
		return tabJoueur;
	}

	public void setTabJoueur(ArrayList<CarteWagon> tabJoueur) {
		this.tabJoueur = tabJoueur;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getVille1() {
		return ville1;
	}

	public void setVille1(String ville1) {
		this.ville1 = ville1;
	}

	public String getVille2() {
		return ville2;
	}

	public void setVille2(String ville2) {
		this.ville2 = ville2;
	}

}

