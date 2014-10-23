import java.awt.Color;
import java.awt.Dimension;
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
 * classe permettant d'afficher les cartes de la pioche
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class Bouton4 extends JButton{
 
     private Image carte;
     private String couleur;
         
/**
 * constructeur du Bouton4
 * @param couleur la couleur de la carte wagon
 */
	public Bouton4(String couleur){	 
    	 this.couleur = couleur;  
    	 this.modifCarte();
     }
     
     public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void paintComponent(Graphics g){  
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(carte, 0, 0, 104, 68, this);
     }
     /**
      * méthode pour charger une carte en fonction de la couleur annoncée
      */
     public void modifCarte()
     {
    	 try {
              carte = ImageIO.read(new File("wagon "+couleur+".jpg"));
          } catch (IOException e) {e.printStackTrace();}
     }
     public String getCouleur() {
 		return couleur;
 	}

}