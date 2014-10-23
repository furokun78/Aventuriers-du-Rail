import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * classe permettant de rehcarger les cartes lorsqu'on en enlève une 
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class Animation extends JPanel implements ImageAfficher{

	private String couleur = "";
	private int position = 0, x, y;
	private Image carte;
	private JFrame panneau;
	Fenetre fenetre;
	
	/**
	 * le constructeur
	 * @param pan la JFrame parente du panel i.e la fenêtre principale
	 * @param fenetre la "fenetre" qui distribue les actions
	 */
	public Animation(JFrame pan, Fenetre fenetre)
	{
		this.panneau = panneau;
		this.fenetre = fenetre;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setPosition(int position) {
		this.position = position;
	}
/**
 * dessiner les cartes sur le plateau
 */
	public void dessiner(Graphics g)
	{
		try{
        if(couleur.equals("bleu")) carte = ImageIO.read(new File("wagon bleu.jpg"));
        if(couleur.equals("rouge"))carte = ImageIO.read(new File("wagon rouge.jpg"));
        if(couleur.equals("violet"))carte = ImageIO.read(new File("wagon violet.jpg"));
        if(couleur.equals("blanc"))carte = ImageIO.read(new File("wagon blanc.jpg"));
        if(couleur.equals("vert"))carte = ImageIO.read(new File("wagon vert.jpg"));
        if(couleur.equals("noir"))carte = ImageIO.read(new File("wagon noir.jpg"));
        if(couleur.equals("jaune"))carte = ImageIO.read(new File("wagon jaune.jpg"));
        if(couleur.equals("orange"))carte = ImageIO.read(new File("wagon orange.jpg"));
        if(couleur.equals("locomotive"))carte = ImageIO.read(new File("locomotive.jpg"));
		}catch(IOException e) {e.printStackTrace();}
		
		if(position == 1)
		{
			for(int i = 0 ; i < 50 ; i++)
			{
                    x = i;
                    y = i;
                    g.drawImage(carte, x, y, panneau);
			}
		}
		
	}

}
