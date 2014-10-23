import javax.swing.*; 
import java.awt.*; 
import java.awt.image.*; 

/**
 * la classe permettant d'afficher l'image de fond de la fenêtre d'accueil
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */
public class imageFond extends JPanel
{
	private TexturePaint texture; 
	private BufferedImage bufferedImage; 

	public static final int CENTRE = 0;
	public static final int TEXTURE = 1;

	/**
	 * le constructeur 
	 * @param fileName le nom de l'image à charger
	 */
	imageFond(String fileName)
	{
		this.bufferedImage = this.toBufferedImage(Toolkit.getDefaultToolkit().getImage(fileName));
		//this.texture = new TexturePaint(bufferedImage,new Rectangle(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight())); 
	} 

	public void paintComponent(Graphics g)
	{	
		g.setColor(this.getBackground());
		g.fillRect(0,0,getWidth(), getHeight() );
		g.drawImage(bufferedImage,(getWidth()-bufferedImage.getWidth())/2,(getHeight()-bufferedImage.getHeight())/2,null);
	}


	private BufferedImage toBufferedImage(Image image)
	{	image = new ImageIcon(image).getImage(); 

		BufferedImage bufferedImage = new BufferedImage( image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB); 
		Graphics g = bufferedImage.createGraphics(); 

		g.setColor(Color.white); 
		g.fillRect(0, 0, image.getWidth(null), 
		image.getHeight(null)); 
		g.drawImage(image, 0, 0, null); 
		g.dispose(); 
		return bufferedImage; 
	}

}

