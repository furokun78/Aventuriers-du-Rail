import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class EcouteurBoutonRegles implements ActionListener {
	
	private JButton Quitter;
	private JFrame frame;

	public EcouteurBoutonRegles(JButton Quitter, JFrame frame){
		this.Quitter = Quitter;
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource() == Quitter){
		try {
			 
			java.awt.Desktop.getDesktop().open(new File("the_rules.pdf"));
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 }

		//frame.dispose();
	}
		
	}

}
