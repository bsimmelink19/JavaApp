import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this card has a victory point value
 * and a treasure value
 * @see Card 
 * @see VictoryCard
 * @author Brady Simmelink
 *
 */
public class Harem extends Card implements VictoryCard{
	/**
	 * constructor
	 */
	public Harem()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl8 = getClass().getResource("/resources/harem.png"); 
		Image img8 = toolkit.getImage(imgUrl8); 
		details = String.format("<html>+2 treasure <br>2 victory points</html>"); 
		img8 = img8.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon haremIcon = new ImageIcon(img8);
		img = haremIcon; 
		cost = 6; 
		value = 2; 
		vPoints = 2; 
		name = "Harem"; 
		
	}

}
