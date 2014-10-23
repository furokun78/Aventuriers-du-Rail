import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

/**
 * la classe qui dessine sur le plateau les rectangles symbolisant les wagons du joueur
 * @author Frédéric Torcheux & Florian Chaulet
 * @version 1.0
 */

public class DessinerRectangle implements ImageAfficher {

	String ville1;
	String ville2;
	String couleurjoueur;
	String crd; // la couleur de la route double que l'on veut prendre
	
	/**
	 * constructeur du rectancgle 
	 * @param ville1 la ville de départ du chemin sélectionné
	 * @param ville2 la ville d'arrivé du chemin
	 * @param couleurjoueur la couleur que l'on doit déposé sur le terrain
	 * @param crd la couleur de la route que l'on veut prendre si le chemin est double
	 */
	public DessinerRectangle(String ville1, String ville2, String couleurjoueur, String crd){
		this.ville1 = ville1; 
		this.ville2 = ville2;
		this.couleurjoueur = couleurjoueur;
		this.crd = crd;
	}
	
	public DessinerRectangle(){
		
	}
	
	
	
private Shape creerRectangle (Rectangle REC){
		
		Shape rect =  new Rectangle2D.Double (REC.getAx(), REC.getAy(), REC.getLongeur(), REC.getHeuteur()) ;
		//REC.afficherInfos();
		
		AffineTransform t = AffineTransform.getRotateInstance (REC.getAngle (), REC.getAx (), REC.getAy ()) ;
		Shape rectFinal = t.createTransformedShape (rect) ;
		return rectFinal ;
}
	
	public void dessiner(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (couleurjoueur == "jaune"){ g.setColor(new Color(247,226,47));}
		if (couleurjoueur == "orange"){ g.setColor(new Color(243,106,7));}
		if (couleurjoueur == "noir"){ g.setColor(new Color(0,0,0));}
		if (couleurjoueur == "blanc"){ g.setColor(new Color(255,255,255));}
		if (couleurjoueur == "vert"){ g.setColor(new Color(1,198,0));}
		if (couleurjoueur == "violet"){ g.setColor(new Color(128,0,128));}
		if (couleurjoueur == "rouge"){ g.setColor(new Color(255,0,0));}
		if (couleurjoueur == "bleu"){ g.setColor(new Color(0,0,192));}
		int hauteur = 10;
		int largeur = 28;
		if (ville1 == "Palermo"){
			if (ville2 == "Smyrna"){
				g2.fill( creerRectangle(new Rectangle(598 ,541,627,541)));
				g2.fill( creerRectangle(new Rectangle(628 ,541,656,541)));
				g2.fill( creerRectangle(new Rectangle(658 ,541,686 ,541)));
				g2.fill( creerRectangle(new Rectangle(689 ,541,717,541)));
				g2.fill( creerRectangle(new Rectangle(719 ,542,747,541)));
				g2.fill( creerRectangle(new Rectangle(750 ,542,776,541)));
			}
			else if(ville2 == "Roma"){
				g2.fill( creerRectangle(new Rectangle(572 ,536,588,514)));
				g2.fill( creerRectangle(new Rectangle(589 ,511,589,482)));
				g2.fill( creerRectangle(new Rectangle(590 ,479,573,457)));
				g2.fill( creerRectangle(new Rectangle(571 ,456,550,441)));
			}
			else if(ville2 == "Brindisi"){
				g2.fill( creerRectangle(new Rectangle(581 ,543,597,521)));
				g2.fill( creerRectangle(new Rectangle(601 ,518,619,497)));
				g2.fill( creerRectangle(new Rectangle(619 ,495,609,468)));
			}
		}
		if (ville1 == "Smyrna"){
			if (ville2 == "Angora"){
				g2.fill( creerRectangle(new Rectangle(794 ,544,818,545)));
				g2.fill( creerRectangle(new Rectangle(824 ,546,849,544)));
				g2.fill( creerRectangle(new Rectangle(854 ,542,875,529)));
			}
			else if(ville2 == "Athina"){
				g2.fill( creerRectangle(new Rectangle(775 ,540,751,529)));
				g2.fill( creerRectangle(new Rectangle(749 ,528,721,527)));
			}
			else if(ville2 == "Constantinople"){
				g2.fill( creerRectangle(new Rectangle(783 ,534,795,511)));
				g2.fill( creerRectangle(new Rectangle(797 , 506, 809, 483))); 
			}
		}
		if (ville1 == "Angora"){
			if (ville2 == "Constantinople"){
				g2.fill( creerRectangle(new Rectangle(871 , 522, 851, 506)));
				g2.fill( creerRectangle(new Rectangle(847 , 502, 827, 487)));
			}
			else if (ville2 == "Erzurum"){
				g2.fill( creerRectangle(new Rectangle(895 , 525, 917, 539)));
				g2.fill( creerRectangle(new Rectangle(920 , 539, 946, 536)));
				g2.fill( creerRectangle(new Rectangle(949 , 543, 945, 514)));	
			}
		}
		if (ville1 == "Erzurum"){
			if (ville2 == "Sochi"){
				g2.fill( creerRectangle(new Rectangle(946 , 495, 949, 468)));
				g2.fill( creerRectangle(new Rectangle(950 , 463, 953, 436)));
				g2.fill( creerRectangle(new Rectangle(954 , 430, 958, 405)));
			}
			else if (ville2 == "Sevastopol"){
				g2.fill( creerRectangle(new Rectangle(939 , 503, 915, 487)));
				g2.fill( creerRectangle(new Rectangle(911 , 483, 896, 458)));
				g2.fill( creerRectangle(new Rectangle(894 , 452, 890, 423)));
				g2.fill( creerRectangle(new Rectangle(890 , 419, 890, 390)));	
			}
		}
		if (ville1 == "Sochi"){
			if (ville2 == "Sevastopol"){
				g2.fill( creerRectangle(new Rectangle(956 , 398, 928, 393)));
				g2.fill( creerRectangle(new Rectangle(926 , 393, 900, 388)));
			}
			else if (ville2 == "Rostov"){
				g2.fill( creerRectangle(new Rectangle(960, 384, 961, 357)));
				g2.fill( creerRectangle(new Rectangle(962 , 354, 963, 327))); 
			}
		}
		if (ville1 == "Rostov"){
			if (ville2 == "Kharkov"){
				g2.fill( creerRectangle(new Rectangle(964, 306, 964, 278)));
				g2.fill( creerRectangle(new Rectangle(973 , 276, 946, 276)));
			}
			else if(ville2 == "Sevastopol"){
				g2.fill( creerRectangle(new Rectangle(959, 319, 933, 314)));
				g2.fill( creerRectangle(new Rectangle(930 , 314, 902, 309)));
				g2.fill( creerRectangle(new Rectangle(910, 313, 906, 342)));
				g2.fill( creerRectangle(new Rectangle(905 , 345, 902, 373))); 
			}
		}
		if (ville1 == "Sevastopol"){
			if (ville2 == "Bucuresti"){
				g2.fill( creerRectangle(new Rectangle(883, 375, 867, 353)));
				g2.fill( creerRectangle(new Rectangle(864 , 351, 840, 339)));
				g2.fill( creerRectangle(new Rectangle(837, 338, 811, 345)));
				g2.fill( creerRectangle(new Rectangle(809 , 347, 789, 367)));
			}
			else if(ville2 == "Constantinople"){
				g2.fill( creerRectangle(new Rectangle(887, 391, 887, 419)));
				g2.fill( creerRectangle(new Rectangle(886 , 427, 868, 451)));
				g2.fill( creerRectangle(new Rectangle(861, 460, 839, 442)));
				g2.fill( creerRectangle(new Rectangle(846 , 451, 829, 472)));	
			}
		}
		if (ville1 == "Constantinople"){
			if (ville2 == "Bucuresti"){
				g2.fill( creerRectangle(new Rectangle(812 , 465, 802, 439)));
				g2.fill( creerRectangle(new Rectangle(801, 436, 790, 410)));
				g2.fill( creerRectangle(new Rectangle(789 , 407, 778, 381)));
			}
			else if (ville2 == "Sofia"){
				g2.fill( creerRectangle(new Rectangle(809 , 478, 788, 465)));
				g2.fill( creerRectangle(new Rectangle(784, 463, 762, 449)));
				g2.fill( creerRectangle(new Rectangle(757 , 447, 735, 433)));	
			}
		}
		if (ville1 == "Sofia"){
			if (ville2 == "Bucuresti"){
				g2.fill( creerRectangle(new Rectangle(737 , 413, 760, 406)));
				g2.fill( creerRectangle(new Rectangle(763, 401, 764, 376)));
			}
			else if (ville2 == "Sarajevo"){
				g2.fill( creerRectangle(new Rectangle(720 , 420, 708, 394)));
				g2.fill( creerRectangle(new Rectangle(708, 404, 686, 416)));	
			}
			else if (ville2 == "Athina"){
				g2.fill( creerRectangle(new Rectangle(727 , 433, 709, 454)));
				g2.fill( creerRectangle(new Rectangle(707, 456, 705, 486)));
				g2.fill( creerRectangle(new Rectangle(705 , 488, 719, 512)));	
			}
		}
		if (ville1 == "Athina"){
			if (ville2 == "Sarajevo"){
				g2.fill( creerRectangle(new Rectangle(704 , 520, 677, 519)));
				g2.fill( creerRectangle(new Rectangle(667, 519, 667, 490)));
				g2.fill( creerRectangle(new Rectangle(668 , 486, 668, 457)));
				g2.fill( creerRectangle(new Rectangle(669 , 454, 670, 424)));
			}
			else if(ville2 == "Brindisi"){
				g2.fill( creerRectangle(new Rectangle(709 , 533, 680, 536)));
				g2.fill( creerRectangle(new Rectangle(674 , 536, 648, 527)));
				g2.fill( creerRectangle(new Rectangle(641, 520, 631, 493)));
				g2.fill( creerRectangle(new Rectangle(630 , 490, 619, 464)));	
			}
		}
		if (ville1 == "Sarajevo"){
			if (ville2 == "Zagrab"){
				g2.fill( creerRectangle(new Rectangle(667 , 422, 641, 432)));
				g2.fill( creerRectangle(new Rectangle(632, 430, 610, 414)));
				g2.fill( creerRectangle(new Rectangle(605 , 404, 602, 377)));
			}
			else if (ville2 == "Budapest"){
				g2.fill( creerRectangle(new Rectangle(667 , 409, 663, 380)));
				g2.fill( creerRectangle(new Rectangle(663, 376, 659, 348)));
				g2.fill( creerRectangle(new Rectangle(658 , 345, 656, 318)));	
			}
		}
		if (ville1 == "Bucuresti"){
			if (ville2 == "Kyiv"){
				g2.fill( creerRectangle(new Rectangle(773 , 356, 781, 329)));
				g2.fill( creerRectangle(new Rectangle(782, 325, 791, 299)));
				g2.fill( creerRectangle(new Rectangle(792, 295, 800, 268)));
				g2.fill( creerRectangle(new Rectangle(801 , 264, 810, 237)));
			}
			else if (ville2 == "Budapest"){
				g2.fill( creerRectangle(new Rectangle(766 , 369, 744, 358)));
				g2.fill( creerRectangle(new Rectangle(740, 355, 717, 342)));
				g2.fill( creerRectangle(new Rectangle(713, 339, 690, 327)));
				g2.fill( creerRectangle(new Rectangle(686 , 325, 664, 312)));	
			}
		}
		if (ville1 == "Zagrab"){
			if (ville2 == "Budapest"){
				g2.fill( creerRectangle(new Rectangle(612 , 358, 630, 340)));
				g2.fill( creerRectangle(new Rectangle(632, 337, 646, 313)));
			}
			else if (ville2 == "Wien"){
				g2.fill( creerRectangle(new Rectangle(602 , 353, 604, 327)));
				g2.fill( creerRectangle(new Rectangle(603, 322, 605, 295)));
			}
			else if (ville2 == "Venezia"){
				g2.fill( creerRectangle(new Rectangle(595 , 365, 574, 349)));
				g2.fill( creerRectangle(new Rectangle(571, 349, 545, 356)));	
			}
		}
		if (ville1 == "Roma"){
			if (ville2 == "Venezia"){
				g2.fill( creerRectangle(new Rectangle(544 , 425, 538, 397)));
				g2.fill( creerRectangle(new Rectangle(539, 393, 533, 366)));
			}
			else if (ville2 == "Marseille"){
				g2.fill( creerRectangle(new Rectangle(533 , 429, 519, 408)));
				g2.fill( creerRectangle(new Rectangle(514, 403, 502, 383)));
				g2.fill( creerRectangle(new Rectangle(504, 374, 486, 390)));
				g2.fill( creerRectangle(new Rectangle(481, 395, 460, 410)));
			}
			else if (ville2 == "Brindisi"){
				g2.fill( creerRectangle(new Rectangle(556 , 422, 584, 421)));
				g2.fill( creerRectangle(new Rectangle(592, 424, 611, 445)));	
			}
		}
		if (ville1 == "Venezia"){
			if (ville2 == "Munchen"){
				g2.fill( creerRectangle(new Rectangle(530 , 346, 525, 320)));
				g2.fill( creerRectangle(new Rectangle(525, 315, 520, 290)));
			}
			else if (ville2 == "Zurich"){
				g2.fill( creerRectangle(new Rectangle(524 , 364, 503, 349)));
				g2.fill( creerRectangle(new Rectangle(498, 348, 477, 334)));	
			}
		}
		if (ville1 == "Marseille"){
			if (ville2 == "Zurich"){
				g2.fill( creerRectangle(new Rectangle(451 , 391,458, 367)));
				g2.fill( creerRectangle(new Rectangle(460, 363, 465, 336)));
			}
			else if (ville2 == "Paris"){
				g2.fill( creerRectangle(new Rectangle(440 , 400, 425, 378)));
				g2.fill( creerRectangle(new Rectangle(423, 376, 398, 361)));
				g2.fill( creerRectangle(new Rectangle(394 , 357, 379, 333)));
				g2.fill( creerRectangle(new Rectangle(375, 327, 376, 297)));	
			}
			else if (ville2 == "Pamplona"){
				g2.fill( creerRectangle(new Rectangle(429 , 405, 405, 392)));
				g2.fill( creerRectangle(new Rectangle(402, 392, 375, 391)));
				g2.fill( creerRectangle(new Rectangle(372 , 393, 363, 419)));
				g2.fill( creerRectangle(new Rectangle(358, 431, 334, 420)));
			}
			else if (ville2 == "Barcelona"){
				g2.fill( creerRectangle(new Rectangle(438 , 417, 411, 427)));
				g2.fill( creerRectangle(new Rectangle(408, 429, 386, 443)));
				g2.fill( creerRectangle(new Rectangle(383 , 445, 363, 464)));
				g2.fill( creerRectangle(new Rectangle(361, 466, 343, 488)));	
			}
		}
		if (ville1 == "Zurich"){
			if (ville2 == "Paris"){
				g2.fill( creerRectangle(new Rectangle(460, 337, 435, 337)));
				g2.fill( creerRectangle(new Rectangle(428 , 335, 405, 322)));
				g2.fill( creerRectangle(new Rectangle(399, 318, 386, 294)));
			}
			else if (ville2 == "Munchen"){
				g2.fill( creerRectangle(new Rectangle(474, 315, 492, 299)));
				g2.fill( creerRectangle(new Rectangle(496, 295, 514, 277)));
			}
		}
		if (ville1 == "Barcelona"){
			if (ville2 == "Pamplona"){
				g2.fill( creerRectangle(new Rectangle(326, 483, 324, 457)));
				g2.fill( creerRectangle(new Rectangle(323, 451, 321, 424)));
			}
			else if (ville2 == "Madrid"){
				g2.fill( creerRectangle(new Rectangle(322 , 496, 295, 495)));
				g2.fill( creerRectangle(new Rectangle(292, 494, 265, 493)));	
			}
		}
		if (ville1 == "Pamplona"){
			if (ville2 == "Brest"){
				g2.fill( creerRectangle(new Rectangle(313 , 381, 313, 351)));
				g2.fill( creerRectangle(new Rectangle(313, 349, 311, 320)));
				g2.fill( creerRectangle(new Rectangle(309 , 317, 294, 293)));
				g2.fill( creerRectangle(new Rectangle(292, 292, 268, 282)));
			}
			else if (ville2 == "Paris"){
				if (crd == "bleu"){
					g2.fill( creerRectangle(new Rectangle(312, 397, 329, 375)));
					g2.fill( creerRectangle(new Rectangle(330, 373, 341, 346)));
					g2.fill( creerRectangle(new Rectangle(342 , 344, 350, 315)));
					g2.fill( creerRectangle(new Rectangle(350, 313, 353, 283)));
				}
				else{ // crd == vert
					g2.fill( creerRectangle(new Rectangle(325 , 403, 341, 379)));
					g2.fill( creerRectangle(new Rectangle(342, 377, 353, 350)));
					g2.fill( creerRectangle(new Rectangle(354 , 348, 362, 319)));
					g2.fill( creerRectangle(new Rectangle(362, 317, 365, 287)));	
				}
			}
			else if (ville2 == "Madrid"){
				if (crd == "blanc"){
					g2.fill( creerRectangle(new Rectangle(317 , 423, 298, 438)));
					g2.fill( creerRectangle(new Rectangle(293, 441, 274, 460)));
					g2.fill( creerRectangle(new Rectangle(272 , 464, 257, 484)));
				}
				else{ // crd == noir
					g2.fill( creerRectangle(new Rectangle(309 , 415, 290, 429)));
					g2.fill( creerRectangle(new Rectangle(285, 432, 267, 451)));
					g2.fill( creerRectangle(new Rectangle(264 , 455, 250, 475)));	
				}
			}
		}
		if (ville1 == "Madrid"){
			if (ville2 == "Lisboa"){
				g2.fill( creerRectangle(new Rectangle(233, 481, 211, 465)));
				g2.fill( creerRectangle(new Rectangle(209 , 464, 181, 464)));
				g2.fill( creerRectangle(new Rectangle(191 , 466, 191, 496)));
			}
			else if (ville2 == "Cadiz"){
				g2.fill( creerRectangle(new Rectangle(254 , 486, 274, 505)));
				g2.fill( creerRectangle(new Rectangle(277 , 510, 288, 539)));
				g2.fill( creerRectangle(new Rectangle(276 , 543, 251, 551)));	
			}
		}
		if (ville1 == "Cadiz"){
			if (ville2 == "Lisboa"){
				g2.fill( creerRectangle(new Rectangle(233 , 552, 205, 546)));
				g2.fill( creerRectangle(new Rectangle(197 , 539, 186, 513)));	
			}
		}
		if (ville1 == "Budapest"){
			if (ville2 == "Wien"){
				if (crd == "rouge"){
					g2.fill( creerRectangle(new Rectangle(645, 308, 623, 294)));
				}
				else{ // crd == blanc
					g2.fill( creerRectangle(new Rectangle(639 , 318, 616, 301)));	
				}
			}
			else if (ville2 == "Kyiv"){
				g2.fill( creerRectangle(new Rectangle(656 , 291, 673, 273)));
				g2.fill( creerRectangle(new Rectangle(677 , 268, 697, 253)));
				g2.fill( creerRectangle(new Rectangle(702 , 250, 725, 239)));	
				g2.fill( creerRectangle(new Rectangle(731 , 235, 753, 226)));
				g2.fill( creerRectangle(new Rectangle(761 , 225, 786, 224)));
				g2.fill( creerRectangle(new Rectangle(790 , 225, 816, 225)));	
			}
		}
		if (ville1 == "Kharkov"){
			if (ville2 == "Moskva"){
				g2.fill( creerRectangle(new Rectangle(936 , 258, 955, 238)));
				g2.fill( creerRectangle(new Rectangle(956, 235, 964, 209)));
				g2.fill( creerRectangle(new Rectangle(964, 204, 960, 175)));	
				g2.fill( creerRectangle(new Rectangle(959, 173, 947, 149)));
			}
			else if (ville2 == "Kyiv"){
				g2.fill( creerRectangle(new Rectangle(928, 277, 902, 286)));
				g2.fill( creerRectangle(new Rectangle(897, 287, 868, 287)));
				g2.fill( creerRectangle(new Rectangle(863, 283, 839, 268)));	
				g2.fill( creerRectangle(new Rectangle(834, 261,825, 235)));	
			}
		}
		if (ville1 == "Moskva"){
			if (ville2 == "Petrograd"){
				g2.fill( creerRectangle(new Rectangle(940, 129, 939, 101)));
				g2.fill( creerRectangle(new Rectangle(937, 98, 925, 72)));
				g2.fill( creerRectangle(new Rectangle(924, 70, 903, 52)));	
				g2.fill( creerRectangle(new Rectangle(901, 50, 875, 42)));
			}
			else if (ville2 == "Smolensk"){
				g2.fill( creerRectangle(new Rectangle(943, 146, 921, 164)));	
				g2.fill( creerRectangle(new Rectangle(914, 168, 887, 164)));	
			}
		}
		if (ville1 == "Smolensk"){
			if (ville2 == "Kyiv"){
				g2.fill( creerRectangle(new Rectangle(885, 168, 893, 195)));	
				g2.fill( creerRectangle(new Rectangle(890, 206, 871, 228)));
				g2.fill( creerRectangle(new Rectangle(863, 232, 836, 229)));	
			}
			else if (ville2 == "Wilno"){
				g2.fill( creerRectangle(new Rectangle(865, 159, 844, 142)));	
				g2.fill( creerRectangle(new Rectangle(841, 141, 821, 125)));
				g2.fill( creerRectangle(new Rectangle(825, 132, 809, 155)));	
			}
		}
		if (ville1 == "Kyiv"){
			if (ville2 == "Wilno"){
				g2.fill( creerRectangle(new Rectangle(821, 213, 821, 184)));
				g2.fill( creerRectangle(new Rectangle(821, 182, 798, 165)));
			}
			else if (ville2== "Warszawa"){
				g2.fill( creerRectangle(new Rectangle(816, 222, 789, 221)));
				g2.fill( creerRectangle(new Rectangle(786, 221, 759, 221)));
				g2.fill( creerRectangle(new Rectangle(754, 221, 728, 210)));
				g2.fill( creerRectangle(new Rectangle(723, 206, 706, 186)));	
			}
		}
		if (ville1 == "Wilno"){
			if (ville2 == "Petrograd"){
				g2.fill( creerRectangle(new Rectangle(793, 142, 808, 119)));
				g2.fill( creerRectangle(new Rectangle(810, 117, 826, 93)));
				g2.fill( creerRectangle(new Rectangle(828, 91, 844, 67)));
				g2.fill( creerRectangle(new Rectangle(846, 64, 862, 41)));
			}
			else if (ville2 == "Riga"){
				g2.fill( creerRectangle(new Rectangle(786, 147, 764, 132)));
				g2.fill( creerRectangle(new Rectangle(762, 131, 738, 114)));
				g2.fill( creerRectangle(new Rectangle(734, 109, 722, 81)));
				g2.fill( creerRectangle(new Rectangle(722, 75, 727, 46)));	
			}
			else if (ville2 == "Warszawa"){
				g2.fill( creerRectangle(new Rectangle(781, 158, 759, 143)));
				g2.fill( creerRectangle(new Rectangle(756, 142, 729, 146)));
				g2.fill( creerRectangle(new Rectangle(727, 149, 715, 175)));
			}
		}
		if (ville1 == "Petrograd"){
			if (ville2 == "Stockholm"){
				g2.fill( creerRectangle(new Rectangle(856, 30, 835, 21)));
				g2.fill( creerRectangle(new Rectangle(830, 18, 806, 18)));
				g2.fill( creerRectangle(new Rectangle(799, 18, 775, 18)));
				g2.fill( creerRectangle(new Rectangle(770, 18, 745, 18)));
				g2.fill( creerRectangle(new Rectangle(740, 18, 715, 18)));
				g2.fill( creerRectangle(new Rectangle(710, 18, 685, 18)));
				g2.fill( creerRectangle(new Rectangle(680, 20, 662, 36)));
				g2.fill( creerRectangle(new Rectangle(651, 44, 635, 21)));	
			}
			else if (ville2 == "Riga"){
				g2.fill( creerRectangle(new Rectangle(857, 42, 830, 42)));
				g2.fill( creerRectangle(new Rectangle(827, 42, 800, 42)));
				g2.fill( creerRectangle(new Rectangle(797, 42, 770, 42)));
				g2.fill( creerRectangle(new Rectangle(767, 42, 739, 42)));
			}
		}
		if (ville1 == "Warszawa"){
			if (ville2 == "Danzig"){
				g2.fill( creerRectangle(new Rectangle(697, 169, 691, 139)));
				g2.fill( creerRectangle(new Rectangle(690, 138, 669, 123)));
			}
			else if (ville2 == "Berlin"){
				if (crd == "jaune"){
					g2.fill( creerRectangle(new Rectangle(694, 188, 667, 183)));
					g2.fill( creerRectangle(new Rectangle(664, 183, 637, 183)));
					g2.fill( creerRectangle(new Rectangle(634, 184, 607, 187)));
					g2.fill( creerRectangle(new Rectangle(606, 188, 580, 197)));	
				}
				else{ //crd == violet
					g2.fill( creerRectangle(new Rectangle(694, 176, 667, 171)));
					g2.fill( creerRectangle(new Rectangle(664, 170, 637, 170)));
					g2.fill( creerRectangle(new Rectangle(634, 170, 607, 174)));
					g2.fill( creerRectangle(new Rectangle(604, 175, 577, 184)));
				}
			}
			else if (ville2 == "Wien"){
				g2.fill( creerRectangle(new Rectangle(706, 190, 691, 216)));
				g2.fill( creerRectangle(new Rectangle(689, 219, 673, 243)));
				g2.fill( creerRectangle(new Rectangle(670, 245, 649, 266)));
				g2.fill( creerRectangle(new Rectangle(648, 267, 624, 282)));	
			}
		}
		if (ville1 == "Danzig"){
			if (ville2 == "Riga"){
				g2.fill( creerRectangle(new Rectangle(660, 106, 669, 77)));
				g2.fill( creerRectangle(new Rectangle(671, 74, 689, 50)));
				g2.fill( creerRectangle(new Rectangle(693, 46, 720, 36)));
			}
			else if (ville2 == "Berlin"){
				g2.fill( creerRectangle(new Rectangle(656, 116, 629, 109)));
				g2.fill( creerRectangle(new Rectangle(626, 109, 599, 115)));
				g2.fill( creerRectangle(new Rectangle(597, 117, 582, 140)));
				g2.fill( creerRectangle(new Rectangle(581, 143, 577, 172)));	
			}
		}
		if (ville1 == "Stockholm"){
			if (ville2 == "Kobenhavn"){
				if (crd == "jaune"){
					g2.fill( creerRectangle(new Rectangle(621, 15, 596, 30)));
					g2.fill( creerRectangle(new Rectangle(594, 31, 573, 50)));
					g2.fill( creerRectangle(new Rectangle(571, 52, 553, 72)));
				}
				else{ // crd == blanc
				g2.fill( creerRectangle(new Rectangle(628, 25, 603, 39)));
				g2.fill( creerRectangle(new Rectangle(602, 41, 581, 59)));
				g2.fill( creerRectangle(new Rectangle(579, 60, 560, 82)));	
				}
			}
		}
		if (ville1 == "Kobenhavn"){
			if (ville2 == "Essen"){
				if (crd == "1"){ // attenton on ne peut pas utiliser la couleur pour les différencier
					g2.fill( creerRectangle(new Rectangle(541, 85,525, 109)));
					g2.fill( creerRectangle(new Rectangle(523, 111, 507, 135)));
					g2.fill( creerRectangle(new Rectangle(506, 137, 491, 162)));
				}
				else{ // on prend la route la plus au sud
					g2.fill( creerRectangle(new Rectangle(550, 91,534, 115)));
					g2.fill( creerRectangle(new Rectangle(533, 117, 517, 141)));
					g2.fill( creerRectangle(new Rectangle(516, 143, 500, 168)));	
				}
			}
		}
		if (ville1 == "Essen"){
			if (ville2 == "Berlin"){
				g2.fill( creerRectangle(new Rectangle(504, 162, 532, 166)));
				g2.fill( creerRectangle(new Rectangle(534, 166, 562, 170)));
			}
			else if (ville2 == "Amsterdam"){
				g2.fill( creerRectangle(new Rectangle(477, 168, 460, 145)));
				g2.fill( creerRectangle(new Rectangle(459, 144, 433, 138)));
				g2.fill( creerRectangle(new Rectangle(432, 129, 426, 156)));	
			}
			else if (ville2 == "Frankfurt"){
				g2.fill( creerRectangle(new Rectangle(503, 175, 515, 203)));
				g2.fill( creerRectangle(new Rectangle(505, 209, 480, 220)));
			}
		}
		if (ville1 == "Amsterdam"){
			if (ville2 == "London"){
				g2.fill( creerRectangle(new Rectangle(411, 165, 381, 165)));
				g2.fill( creerRectangle(new Rectangle(380, 165, 352, 165)));
			}
			else if (ville2 == "Bruxelles"){
				g2.fill( creerRectangle(new Rectangle(423, 174, 412, 200)));	
			}
		}
		if (ville1 == "London"){
			if (ville2 == "Edinburgh"){
				if (crd == "orange"){
					g2.fill( creerRectangle(new Rectangle(339, 152, 329, 126)));
					g2.fill( creerRectangle(new Rectangle(329, 123, 318, 96)));
					g2.fill( creerRectangle(new Rectangle(317, 94, 307, 68)));
					g2.fill( creerRectangle(new Rectangle(306, 66, 294, 38)));	
				}
				else{ // crd == noir
					g2.fill( creerRectangle(new Rectangle(330, 157, 318, 130)));
					g2.fill( creerRectangle(new Rectangle(317, 127, 307, 100)));
					g2.fill( creerRectangle(new Rectangle(306, 98, 296, 72)));
					g2.fill( creerRectangle(new Rectangle(295, 70, 284, 43)));	
				}
			}
			else if (ville2 == "Dieppe"){
				if (crd == "1"){
					g2.fill( creerRectangle(new Rectangle(350, 170, 347, 200)));
					g2.fill( creerRectangle(new Rectangle(347, 202, 345, 231)));
				}
				else{ //crd == route de l'Ouest
					g2.fill( creerRectangle(new Rectangle(338, 170, 337, 198)));
					g2.fill( creerRectangle(new Rectangle(335, 201, 334, 230)));	
				}	
			}
		}
		if (ville1 == "Dieppe"){
			if (ville2 == "Brest"){
				g2.fill( creerRectangle(new Rectangle(324, 243,295, 243)));
				g2.fill( creerRectangle(new Rectangle(294, 244, 271, 258)));
			}
			else if (ville2 == "Bruxelles"){
				g2.fill( creerRectangle(new Rectangle(343, 233, 366, 217)));
				g2.fill( creerRectangle(new Rectangle(368, 215, 390, 199)));	
			}
			else if (ville2 == "Paris"){
				g2.fill( creerRectangle(new Rectangle(347, 242, 365, 263)));
			}
		}
		if (ville1 == "Paris"){
			if (ville2 == "Brest"){
				g2.fill( creerRectangle(new Rectangle(357, 281, 330, 278)));
				g2.fill( creerRectangle(new Rectangle(328, 277, 300, 273)));
				g2.fill( creerRectangle(new Rectangle(298, 273, 271, 271)));	
			}
			else if (ville2 == "Bruxelles"){
				if (crd == "rouge"){
					g2.fill( creerRectangle(new Rectangle(378, 270, 391, 244)));
					g2.fill( creerRectangle(new Rectangle(392, 242, 405, 215)));
				}
				else{ // crd == jaune
					g2.fill( creerRectangle(new Rectangle(368, 263, 381, 238)));
					g2.fill( creerRectangle(new Rectangle(381, 236, 394, 210)));	
				}
			}
			else if (ville2 == "Frankfurt"){
				if (crd == "orange"){
					g2.fill( creerRectangle(new Rectangle(393, 283, 420, 274)));
					g2.fill( creerRectangle(new Rectangle(422, 273, 446, 258)));
					g2.fill( creerRectangle(new Rectangle(448, 256, 469, 240)));
				}
				else{ //crd == blanc
					g2.fill( creerRectangle(new Rectangle(388, 272,416, 262)));
					g2.fill( creerRectangle(new Rectangle(416, 263, 440, 247)));
					g2.fill( creerRectangle(new Rectangle(442, 246, 464, 229)));	
				}
			}
		}
		if (ville1 == "Frankfurt"){
			if (ville2 == "Berlin"){
				if (crd == "rouge"){
					g2.fill( creerRectangle(new Rectangle(486, 233, 510, 221)));
					g2.fill( creerRectangle(new Rectangle(512, 220,537, 207)));
					g2.fill( creerRectangle(new Rectangle(540, 206, 564, 194)));
				}
				else{ //crd == blanc
					g2.fill( creerRectangle(new Rectangle(482, 222, 505, 211)));
					g2.fill( creerRectangle(new Rectangle(507, 210, 533, 196)));
					g2.fill( creerRectangle(new Rectangle(535, 195, 558, 183)));	
				}
			}
			else if (ville2 == "Amsterdam"){
				g2.fill( creerRectangle(new Rectangle(468, 220, 449, 200)));
				g2.fill( creerRectangle(new Rectangle(447, 198, 428, 177)));
			}
			else if (ville2 == "Bruxelles"){
				g2.fill( creerRectangle(new Rectangle(461, 228, 442, 209)));
				g2.fill( creerRectangle(new Rectangle(437, 207, 412, 215)));	
			}
			else if (ville2 == "Munchen"){
				g2.fill( creerRectangle(new Rectangle(485, 240, 493, 268)));
				g2.fill( creerRectangle(new Rectangle(484, 272, 510, 266)));
			}
		}
		if (ville1 == "Munchen"){
			if (ville2 == "Wien"){
				g2.fill( creerRectangle(new Rectangle(535, 276, 550, 298)));
				g2.fill( creerRectangle(new Rectangle(553, 299, 580, 301)));
				g2.fill( creerRectangle(new Rectangle(582, 300, 603, 282)));	//ok
			}
		}
		if (ville1 == "Wien"){
			if (ville2 == "Berlin"){
				g2.fill( creerRectangle(new Rectangle(609, 280, 593, 258)));
				g2.fill( creerRectangle(new Rectangle(591, 254, 577, 228)));
				g2.fill( creerRectangle(new Rectangle(576, 224, 569, 196)));
			}
		}
		
	}

	
	//// yeah c'est finii //////

}
