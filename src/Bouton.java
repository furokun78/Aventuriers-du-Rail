import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
 
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * la classe controlant le bouton dans la main du joueur représentant les cartes destinations possédées par celui-ci
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
 
 
public class Bouton extends JButton{

	private String resultat = "", ville1 = "", ville2 = "";
	private Image ville;
	private ArrayList<CarteDest> carteDest;
	private int points;
         
	/**
	 * le constructeur de la classe 
	 * @param pCarteDest l'arraylist de cartes destinations possédée par le joueur
	 */
     public Bouton(ArrayList<CarteDest> pCarteDest){
    	carteDest = pCarteDest;
    	this.modifListeVille(carteDest);
        this.setPreferredSize(new Dimension(150,101));
     }
     
     /**
      * méthode de modification de la liste des villes apparaissant sur la carte
      * @param pCarteDest l'arraylist de cartes destinations
      */
     public void modifListeVille(ArrayList<CarteDest> pCarteDest)
     {
     	points = carteDest.get(0).getScore();
        ville1 = carteDest.get(0).getVille1();
        ville2 = carteDest.get(0).getVille2();
        this.modifVille(ville1,ville2,points);
     }

     /**
      * méthode de modification sur une carte destination
      * @param ville1 la première ville
      * @param ville2 la deuxième ville
      * @param points le nombre de points qu'elle rapporte
      */
     public void modifVille(String ville1, String ville2, int points){
    	 try {
    	ville = ImageIO.read(new File("carte2.jpg"));
    	 } catch (IOException e) {e.printStackTrace();}
     }
    
     public void setVille1(String ville1) {
		this.ville1 = ville1;
	}

	public void setVille2(String ville2) {
		this.ville2 = ville2;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * La méthode qui "peint" sur la carte destination
	 * @param g le graphics 
	 */
	public void paintComponent(Graphics g){
    	 String score = points + ""; 
    	 g.drawImage(ville, 0, 0, this);
    	 Font font = new Font("Arial", Font.CENTER_BASELINE, 9);
    	 g.setFont(font);
    	 g.setColor(Color.black);
    	 g.drawString(ville1 + " - " + ville2, 20, 80);
    	 Font police = new Font("Times New Roman", Font.CENTER_BASELINE, 20);
    	 g.setFont(police);
    	 g.drawString(score, 195, 125);
     }
     
     public ArrayList<CarteDest> getCarteDest() {
 		return carteDest;
 	}

 	public void setCarteDest(ArrayList<CarteDest> carteDest) {
 		this.carteDest = carteDest;
 	}
}
