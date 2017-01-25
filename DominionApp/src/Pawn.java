import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * this is an action card
 * implements its own play function
 * @see Card
 * @see ActionCard
 * @author Brady Simmelink
 *
 */
public class Pawn extends Card implements ActionCard{
	/**
	 * constructor
	 */
	public Pawn()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl9 = getClass().getResource("/resources/pawn.png"); 
		Image img9 = toolkit.getImage(imgUrl9); 
		img9 = img9.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon pawnIcon = new ImageIcon(img9);
		details = String.format("<html>+1 buy  <br> +1 play<br> +1 treasure</html>"); 
		img = pawnIcon; 
		cost = 2; 
		value = 0; 
		vPoints = 0; 
		name = "Pawn"; 
		
	}
	/**
	 * adds one buy
	 * adds one card
	 * adds one treasure
	 */
	@Override
	public void play(Player p1, Player p2,JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		p1.buys = p1.buys + 1; 
		p1.plays = p1.plays + 1; 
		p1.handValue = p1.handValue + 1; 
			p1.plays--; 
			String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
			label.setText(d);  
	}

}
