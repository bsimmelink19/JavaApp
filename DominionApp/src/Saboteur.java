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
public class Saboteur extends Card implements ActionCard{
	/**
	 * constructor
	 */
	public Saboteur()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl13 = getClass().getResource("/resources/saboteur.png"); 
		Image img13 = toolkit.getImage(imgUrl13); 
		img13 = img13.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		details = String.format("<html>destroys a radom card<br> from opponent's deck</html>"); 
		ImageIcon saboteurIcon = new ImageIcon(img13);
		img = saboteurIcon; 
		cost = 5; 
		value = 0; 
		vPoints = 0; 
		name = "Saboteur"; 
		
	}
	/**
	 * deletes a random card from the opponents deck
	 */
	@Override
	public void play(Player p1,Player p2, JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		p1.plays--; 
		String d = String.format("<html>Sabateur Removed a %s!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p2.deck.get(1).name,p1.buys, p1.plays, p1.handValue); 
		label.setText(d);  
		p2.deck.remove(1); 
	}
}
