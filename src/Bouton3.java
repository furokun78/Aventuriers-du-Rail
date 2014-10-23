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
 * la carte destination sur laquelle on écrit les renseignements nécessaires
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
 
public class Bouton3 extends JButton{

	private String ville1, ville2;
	private int points;
	private Image ville;
	private ArrayList<CarteDest> carteDest;
        
	/**
	 * le constructeur de la classe
	 * @param ville1 la ville de départ
	 * @param ville2 la ville à relier
	 * @param points le nombre de points que la carte rapporte ou fait perdre...
	 */
     public Bouton3(String ville1, String ville2, int points){

       this.ville1 = ville1; 
        this.ville2 = ville2;
        this.points = points;
        this.setPreferredSize(new Dimension(243,158));
        this.chargerImage(this.ville1, this.ville2, this.points);
     }
     
     /**
      * méthode de chargement de l'image 
      * @param ville1 la ville de départ
      * @param ville2 la ville à relier
      * @param points le nombre de points que la carte rapporte ou fait perdre...
      */
     public void chargerImage(String ville1, String ville2, int points){
    	 try {
    	ville = ImageIO.read(new File("carte1.jpg"));
    	 } catch (IOException e) {e.printStackTrace();}
     }
    
     /**
      * méthode peignant les renseignements sur la carte
      */
     public void paintComponent(Graphics g){
    	 String score = points + ""; 
    	 g.drawImage(ville, 0, 0, this);
    	 Font font = new Font("Arial", Font.CENTER_BASELINE, 11);
    	 g.setFont(font);
    	 g.setColor(Color.black);
    	 g.drawString(ville1 + " - " + ville2, 35, 123);
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