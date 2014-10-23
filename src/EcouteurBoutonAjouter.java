import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class EcouteurBoutonAjouter extends JDialog implements ActionListener{

	JFrame frame;
	JButton Ajouter;
	JComboBox couleur;
	JTextField nom;
	ArrayList<MainJoueur> tabJoueur;
	PiocheWagon piocheCarteWagon;
	PiocheDest cartesdest;
	int cpt = 0;
	
	public EcouteurBoutonAjouter(JFrame frame, JButton Ajouter,JComboBox couleur ,JTextField nom,
			ArrayList<MainJoueur> tabJoueur, PiocheWagon piocheCarteWagon, PiocheDest cartesdest){
		this.Ajouter = Ajouter;
		this.frame = frame;
		this.couleur = couleur;
		this.nom = nom;
		this.tabJoueur = tabJoueur;
		this.piocheCarteWagon = piocheCarteWagon;
		this.cartesdest =cartesdest;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Ajouter){
			if (cpt <= 4){
			String Joueur = nom.getText();
			MainJoueur mainJoueur = new MainJoueur(Joueur,piocheCarteWagon);
			tabJoueur.add(mainJoueur);
			String CouJ = (String) couleur.getSelectedItem().toString();
			couleur.removeItem( couleur.getSelectedItem());
			nom.setText("");
			ChoixDest choixdest = new ChoixDest(frame, cartesdest , mainJoueur,null);
			cpt++;
			}
			else if (cpt > 4) {
				JOptionPane.showConfirmDialog(frame,

			            "Il ne peut y avoir plus de 5 joueurs", "information",

			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}

}