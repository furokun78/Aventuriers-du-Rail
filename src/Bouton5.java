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
 * classe qui affiche la cartes vus de dos symbolisant la pioche cachée
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class Bouton5 extends JButton{
 
     private Image carte;
         
     public Bouton5(){

             try {
        		carte = ImageIO.read(new File("doscarte.jpg"));
                } catch (IOException e) {e.printStackTrace();}
     }
    
     public void paintComponent(Graphics g){
             g.drawImage(carte, 0, 0, this);        
     }
 
}