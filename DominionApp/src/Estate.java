import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this class only has a victory point value 
 * @see VictoryCard
 * @see Card
 * @author Brady Simmelink
 *
 */
public class Estate extends Card implements VictoryCard{
	public Estate()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl2 = getClass().getResource("/resources/estate.png"); 
		Image img2 = toolkit.getImage(imgUrl2); 
		img2 = img2.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon estateIcon = new ImageIcon(img2);	
		img = estateIcon;
		cost = 2; 
		value = 0; 
		vPoints = 1; 
		name = "Estate"; 
	 
	}
}
