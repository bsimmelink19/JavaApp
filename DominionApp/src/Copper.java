import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this card only has a value to be spent in the game
 * @see TreasureCard
 * @see Card
 * @author Brady Simmelink
 *
 */
public class Copper extends Card implements TreasureCard{
	/**
	 * constructor
	 */
	public Copper()
	{	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl3 = getClass().getResource("/resources/copper.png"); 
		Image img3 = toolkit.getImage(imgUrl3); 
		img3 = img3.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon copperIcon = new ImageIcon(img3);
		img = copperIcon; 
		cost = 0; 
		value = 1; 
		vPoints = 0;  
		name = "Copper"; 
	
	}
}
