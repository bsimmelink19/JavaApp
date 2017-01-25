import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * this class only has a victory point value
 * @see Card
 * @see VictoryCard
 * @author bsimmelink19
 *
 */
public class Province extends Card implements VictoryCard{
	/**
	 * constructor
	 */
	public Province()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		java.net.URL imgUrl = getClass().getResource("/resources/province.png"); 
		Image img1 = toolkit.getImage(imgUrl); 
		img1 = img1.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon provinceIcon = new ImageIcon(img1);
		img = provinceIcon;
		cost = 8; 
		value = 0; 
		vPoints = 6; 
		name = "Province"; 
		 
	}
}
