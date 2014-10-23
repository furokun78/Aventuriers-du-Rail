import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class EcouteurBoutonLancer implements ActionListener {

	JFrame frame;
	JButton Lancer;
	PiocheWagon piocheCarteWagon;
	PiocheDest piocheCarteDest; 
	CartesVisible piocheCarteVisible;
	ArrayList<MainJoueur> tabJoueur; 
	Plateau terrain; 
	
	public EcouteurBoutonLancer(JFrame frame, JButton Lancer, PiocheWagon piocheCarteWagon, PiocheDest piocheCarteDest, 
			CartesVisible piocheCarteVisible, ArrayList<MainJoueur> tabJoueur, Plateau terrain ){
		this.frame = frame;
		this.Lancer = Lancer;
		this.piocheCarteDest = piocheCarteDest;
		this.tabJoueur = tabJoueur;
		this.piocheCarteWagon = piocheCarteWagon;
		this.piocheCarteVisible = piocheCarteVisible;
		this.terrain = terrain;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Lancer){
			if (tabJoueur.size()<2){
				JOptionPane.showConfirmDialog(frame,

			            "Il ne peut y avoir moins de 2 joueurs", "erreur",

			            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				frame.setVisible(false);
				Fenetre fenetre = new Fenetre(piocheCarteVisible,tabJoueur,piocheCarteDest,piocheCarteWagon,terrain);
			}
		}
		
	}

}
