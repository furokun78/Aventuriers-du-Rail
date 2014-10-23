import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * la classe qui permet de savoir si un bouton carte destination est sélectionné ou pas 
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class PrisOuPas implements ActionListener {

	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;
	private int nb1 = 0, nb2 = 0, nb3 = 0,nb4 = 0;

	/**
	 * constructeur de la classe
	 * @param bouton1 le bouton symbolisant la première carte 
	 * @param bouton2 le bouton symbolisant la deuxième carte
	 * @param bouton3 le bouton symbolisant la troisième carte
	 * @param bouton4 le bouton symbolisant la quatrième carte
	 */
	public PrisOuPas(JButton bouton1,JButton bouton2,JButton bouton3,JButton bouton4)
	{
		this.bouton1 = bouton1;
		this.bouton2 = bouton2;
		this.bouton3 = bouton3;
		this.bouton4 = bouton4;
	}
	/**
	 * gestion du clic de la souris
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bouton1)
		{
			if(nb1 == 0)nb1 = 1;
			else nb1 = 0;
			
			if(nb1 == 0)  bouton1.setBorder(null);
			else bouton1.setBorder(BorderFactory.createLineBorder(Color.blue,2));
				
		}
		else if(arg0.getSource() == bouton2)
		{
			if(nb2 == 0)nb2 = 1;
			else nb2 = 0;
			
			if(nb2 == 0)  bouton2.setBorder(null);
			else bouton2.setBorder(BorderFactory.createLineBorder(Color.blue,2));
		}
		else if(arg0.getSource() == bouton3)
		{
			if(nb3 == 0)nb3 = 1;
			else nb3 = 0;
			
			if(nb3 == 0)  bouton3.setBorder(null);
			else bouton3.setBorder(BorderFactory.createLineBorder(Color.blue,2));
		}
		else if(arg0.getSource() == bouton4)
		{
			if(nb4 == 0)nb4 = 1;
			else nb4 = 0;
			
			if(nb4 == 0)  bouton4.setBorder(null);
			else bouton4.setBorder(BorderFactory.createLineBorder(Color.blue,2));
		}

	}
	public int getNb1() {
		return nb1;
	}
	public void setNb1(int nb1) {
		this.nb1 = nb1;
	}
	public int getNb2() {
		return nb2;
	}
	public void setNb2(int nb2) {
		this.nb2 = nb2;
	}
	public int getNb3() {
		return nb3;
	}
	public void setNb3(int nb3) {
		this.nb3 = nb3;
	}
	public int getNb4() {
		return nb4;
	}
	public void setNb4(int nb4) {
		this.nb4 = nb4;
	}
}
