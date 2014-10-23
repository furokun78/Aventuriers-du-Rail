import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * la popup qui demande les couleurs des joueurs
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class DemanderCouleur extends JDialog{
	
	private JComboBox combo = new JComboBox();
	private String couleur = "";

	/**
	 * le constructeur de la classe 
	 * @param parent la JFrame principale
	 */
	public DemanderCouleur(JFrame parent){

		super(parent, "Demande couleur", true);
		this.setSize(200, 80);
		this.setLocationRelativeTo(null);

		this.setResizable(false);

		combo.addItem("Bleu");
		combo.addItem("Jaune");
		combo.addItem("Rouge");
		combo.addItem("Orange");
		combo.addItem("Vert");
		combo.addItem("Violet");
		combo.addItem("Noir");
		combo.addItem("Blanc");
		combo.addItem("Locomotive");
		
		this.add(combo);

		combo.addActionListener(new EcouteCouleur(this,combo));

		this.setVisible(true);

	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}
