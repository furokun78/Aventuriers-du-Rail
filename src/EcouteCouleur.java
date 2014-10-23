import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;


public class EcouteCouleur implements ActionListener {

	private DemanderCouleur dial;
	private JComboBox combo;
	
	public EcouteCouleur(DemanderCouleur dial,JComboBox combo)
	{
		this.dial = dial;
		this.combo = combo;
	}
	
	public void actionPerformed(ActionEvent e) {
		dial.setCouleur((String)combo.getSelectedItem());
		dial.setVisible(false);

	}

}
