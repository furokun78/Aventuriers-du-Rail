import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * la popup de fin de partie
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class Final extends JDialog {

	private JFrame frame;
	private ArrayList<MainJoueur> tabJoueur;
	private Plateau terrain;
	
	/**
	 * constructeur de la popup
	 * @param frame la frame principale
	 * @param tabJoueur l'arraylist de mainjoueur représentant les joueurs
	 * @param terrain le plateau actuel 
	 */
	public Final(JFrame frame, ArrayList<MainJoueur> tabJoueur, Plateau terrain){
		super(frame,"Partie terminée", false);
		this.frame = frame;
		this.tabJoueur = tabJoueur;
		this.terrain = terrain;
		this.setSize(600,600);
			this.repaint();
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
			this.setLayout(null);
			
			
	}
	public void paint(Graphics g){
		paintComponent(g);
	}
	/**
	 * la méthode pour dessiner le nom des joueurs avec leurs scores respectifs les uns en dessous des autres
	 * @param g le graphics
	 */
	public void paintComponent(Graphics g){
		
		// les JPanel contenant les images rejouer et quiter
		JPanel panquit = new JPanel();
		panquit.setLayout(null);
		panquit.setBounds(350, 475, 150, 45);
		this.add(panquit);
		JPanel panrejouer = new JPanel();
		panrejouer.setLayout(null);
		panrejouer.setBounds(100, 475, 150, 45);
		this.add(panrejouer);
		// Les écouteurs liés à ces JPanel
		panquit.addMouseListener(new EcouteurFin(frame, this, panquit, panrejouer));
		panrejouer.addMouseListener(new EcouteurFin(frame, this, panquit, panrejouer));
		
		//chargement et affichage des images
		try{
			 Image feux = ImageIO.read(new File("feuxt.jpg"));
			 Image quitter = ImageIO.read(new File ("quitter.jpg"));
			 Image rejouer = ImageIO.read(new File ("rejouer.jpg"));
			 g.drawImage(feux, 0, 0,this);
			 g.drawImage(quitter, 350, 500, this);
			 g.drawImage(rejouer, 100, 500, this);
			 
		} catch (IOException e){ 
			 e.printStackTrace();
		 	}

		// on affiche les scores respectifs de chaque joueur. les uns en dessous des autres
		for (int i=0; i<tabJoueur.size();i++){
			int score = tabJoueur.get(i).getScore().scorefinal(tabJoueur.get(i), terrain);
			g.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 40));
			g.setColor(Color.WHITE);
			g.drawString(tabJoueur.get(i).getNomJoueur() + " : " + score, 150, 200+(50*i));
		}
		
			
		
	}
}
