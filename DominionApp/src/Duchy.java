import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this card only has a victory point value
 * @see VictoryCard
 * @see Card
 * @author bsimmelink19
 *
 */
public class Duchy extends Card implements VictoryCard{
	/**
	 * constructor
	 */
	public Duchy()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl1 = getClass().getResource("/resources/Duchy.png"); 
		Image img1 = toolkit.getImage(imgUrl1); 
		img1 = img1.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon DuchyIcon = new ImageIcon(img1);
		img = DuchyIcon; 
		cost = 5; 
		value = 0; 
		vPoints = 3; 
		name = "Duchy"; 
		
	}
}
