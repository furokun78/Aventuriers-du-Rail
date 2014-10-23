import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;


public class EcouteurFin implements MouseListener {

	private JFrame frame;
	private JDialog popup;
	private JPanel panquit;
	private JPanel panrejouer;
	public EcouteurFin(JFrame frame, JDialog popup, JPanel panquit, JPanel panrejouer){
		this.frame = frame;
		this.panquit = panquit;
		this.popup = popup;
		this.panrejouer = panrejouer;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	if (arg0.getSource() == panquit){
			System.out.println("Fermeture du programme, en espérant que vous avez apprécié notre jeu. " +
					"\n Frédéric Torcheux \n Florian Chaulet");
			popup.dispose();
			frame.dispose();
			System.exit(1);
			
		}
		if (arg0.getSource() == panrejouer){
				popup.dispose();
				frame.dispose();
				new Jeu();
				Jeu.main(null);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
}
