import java.awt.Point ;

/**
 * création d'un rectangle avec rotation en fonction des coordonnées de ses 2 points supèrieurs
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class Rectangle
{

	// Attributs
	
	private Point A ;
	private Point B ;
	private Point C ;
	private Point D ;
	
	private double longeur ;
	private double hauteur ;
	private double angle ;
	private String couleur;
	
	// Constructeur
	
	public Rectangle ( double Ax, double Ay, double Bx, double By)
	{
		this.A = new Point ( ) ;
		this.B = new Point ( ) ;
		this.C = new Point ( ) ;
		this.D = new Point ( ) ;
		
		this.A.setLocation ( Ax, Ay ) ;
		this.B.setLocation ( Bx, By ) ;
		
		this.hauteur = 11;
		this.longeur = Math.sqrt ( Math.pow ( this.B.getX ( ) - this.A.getX ( ), 2 ) + Math.pow ( this.B.getY( ) - this.A.getY ( ), 2 ) ) ; // Pythagore for ever !
		this.angle = Math.acos ( ( this.B.getX ( ) - this.A.getX ( ) ) / this.longeur ) ;
		
		if ( this.B.getY ( ) > this.A.getY ( ) )
		{
			
			double OMEGA = Math.PI / 2 - this.angle ;
			this.C.setLocation ( this.B.getX ( ) - this.hauteur * Math.cos ( OMEGA ), this.B.getY ( ) + this.hauteur * Math.sin ( OMEGA ) ) ;
			this.D.setLocation ( this.A.getX ( ) - this.hauteur * Math.cos ( OMEGA ), this.A.getY ( ) + this.hauteur * Math.sin ( OMEGA ) ) ;
			
		}
		
		else
		{
			
			this.angle = - this.angle ;
			double OMEGA = this.angle - Math.PI / 2 ;
			this.C.setLocation ( this.B.getX ( ) - this.hauteur * Math.cos ( OMEGA ), this.B.getY ( ) - this.hauteur * Math.sin ( OMEGA ) ) ;
			this.D.setLocation ( this.A.getX ( ) - this.hauteur * Math.cos ( OMEGA ), this.A.getY ( ) - this.hauteur * Math.sin ( OMEGA ) ) ;
			
		}
		
	}
	
	// Getters & Setters
	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public double getAx ( )
	{
		
		return this.A.getX ( ) ;
		
	}
	
	public double getAy ( )
	{
		
		return this.A.getY ( ) ;
		
	}
	
	public double getAngle ( )
	{
		
		return this.angle ;
		
	}
	
	public double getLongeur ( )
	{
		
		return this.longeur ;
		
	}
	
	public double getHeuteur ( )
	{
		
		return hauteur ;
		
	}
	
	// Fonctions
	
	public void afficherInfos ( )
	{
		
		System.out.println ( " A ( " + this.A.getX ( ) + ", " + this.A.getY ( ) +" ) B ( " + this.B.getX ( ) + ", " + this.B.getY ( ) + " )" ) ;
		System.out.println ( " C ( " + this.C.getX ( ) + ", " + this.C.getY ( ) +" ) D ( " + this.D.getX ( ) + ", " + this.D.getY ( ) + " )" ) ;
		System.out.println ( " Angle (rad) : " + this.angle ) ;
		System.out.println ( " Longeur : " + this.longeur + "\n Hauteur : " + this.hauteur ) ;
		
	}

}
