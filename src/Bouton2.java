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
 
import javax.imageio.ImageIO;
import javax.swing.JButton;
 
/**
 * la carte destination de dos affiché en dessous de la pioche (milieu gauche de la fenêtre)
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
 
public class Bouton2 extends JButton{
 
     private Image carte;
   /**
    * constructeur sans paramètres qui charge l'image nécessaire      
    */
     public Bouton2(){
    	 //this.setPreferredSize(new Dimension(142,94));
             try {
        		carte = ImageIO.read(new File("doscartedest.jpg"));
                } catch (IOException e) {e.printStackTrace();}
     }
    /**
     * méthode peignant sur le bouton l'image désirée
     */
     public void paintComponent(Graphics g){
             g.drawImage(carte, 0, 0, this);        
     }
 
}