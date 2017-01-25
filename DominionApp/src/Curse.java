import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this card only has a negative victory point value
 * @see VictoryCard
 * @see Card
 * @author Brady Simmelink
 */
public class Curse extends Card implements VictoryCard{
	/**
	 * constructor
	 */
	public Curse()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl2 = getClass().getResource("/resources/curse.png"); 
		Image img2 = toolkit.getImage(imgUrl2); 
		img2 = img2.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon curseIcon = new ImageIcon(img2);	
		img = curseIcon;
		cost = 0; 
		value = 0; 
		vPoints = -1; 
		name = "Curse"; 
	}
}
