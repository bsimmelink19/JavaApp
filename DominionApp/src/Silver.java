import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this class only has a value
 * @see Card
 * @see TreasureCard
 * @author Brady Simmelink
 *
 */
public class Silver extends Card implements TreasureCard{
	public Silver()
	{	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl4 = getClass().getResource("/resources/silver.png"); 
		Image img4 = toolkit.getImage(imgUrl4); 
		img4 = img4.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon silverIcon = new ImageIcon(img4);
		img = silverIcon; 
		cost = 3; 
		value = 2; 
		vPoints = 0; 
		name = "Silver"; 
	}
}
