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
public class Witch extends Card implements ActionCard{
	/**
	 * constructor
	 */
	public Witch()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl10 = getClass().getResource("/resources/witch.png"); 
		Image img10 = toolkit.getImage(imgUrl10); 
		img10 = img10.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon witchIcon = new ImageIcon(img10);
		img = witchIcon; 
		cost = 5; 
		details = String.format("<html>adds curse to <br> opponents deck</html>"); 
		value = 0; 
		vPoints = 0; 
		name = "Witch"; 
		
	}
	/**
	 * adds a curse card to the opponent's deck
	 */
	@Override
	public void play(Player p1,Player p2, JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		p2.deck.add(new Curse()); 
		p1.plays--; 
		String d = String.format("<html>A curse has been added!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",p1.buys, p1.plays, p1.handValue); 
		label.setText(d); 
	}

}
