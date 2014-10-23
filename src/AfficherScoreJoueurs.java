import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * la classe permettant d'afficher le score des joueurs 
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class AfficherScoreJoueurs extends JPanel implements ImageAfficher{
	
	private ArrayList<MainJoueur> tab;

	/**
	 * constructeur de la classe
	 * @param pTab l'arraylist de mainjoueur contenant tous les attirubts du joueur y compris son score
	 */
	public AfficherScoreJoueurs(ArrayList<MainJoueur> pTab){
		tab = pTab;
	}
	
	public ArrayList<MainJoueur> getTab() {
		return tab;
	}

	public void setTab(ArrayList<MainJoueur> tab) {
		this.tab = tab;
	}
/**
 * la méthode qui dessine sur le panel les scores en fonction de chaque joueur
 */
	public void dessiner(Graphics g) {
		int y = 595;
            Font font = new Font("AR BERKLEY", Font.CENTER_BASELINE, 15);
            g.setFont(font);
            g.setColor(Color.black);
    	 	g.drawString("Score :", 20, y);
    	 	for(int i = 0 ; i < tab.size() ; i++)
    	 	{
    	 		y = y + 20;
    	 		g.drawString("    "+tab.get(i).getNomJoueur() + " : " + tab.get(i).getScore().getScoreCourant(), 20, y);
    	 	}
	}
}