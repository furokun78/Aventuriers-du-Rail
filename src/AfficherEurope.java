import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * la classe qui affiche l'image du plateau des aventuriers du rail
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class AfficherEurope extends JPanel implements ImageAfficher{

	/**
	 * la méthode pour dessiner une image dans le fond du panel
	 */
public void dessiner(Graphics g) {
    try {
        Image europe = ImageIO.read(new File("fond.jpg"));
        g.drawImage(europe, 0, 0, this);
    } catch (IOException e) {e.printStackTrace();}
	
	}
}
