import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this card only has a value
 * @see TreasureCard
 * @see Card
 * @author Brady Simmelink
 *
 */
public class Gold extends Card implements TreasureCard{
	/**
	 * constructor
	 */
	public Gold()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl5 = getClass().getResource("/resources/gold.png"); 
		Image img5 = toolkit.getImage(imgUrl5); 
		img5 = img5.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon goldIcon = new ImageIcon(img5);
		img = goldIcon;
		cost = 6; 
		value = 3; 
		vPoints = 0; 
		name = "Gold"; 
		 
	}
}
