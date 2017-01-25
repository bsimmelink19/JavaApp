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
public class ThroneRoom extends Card implements ActionCard{
	public ThroneRoom()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl11 = getClass().getResource("/resources/throneRoom.png"); 
		Image img11 = toolkit.getImage(imgUrl11); 
		img11 = img11.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon throneRoomIcon = new ImageIcon(img11);
		img = throneRoomIcon;
		details = String.format("<html> +1 play <br> if played after an action <br> allows that action<br> to be replayed</html>"); 
		cost = 4; 
		value = 0; 
		vPoints = 0; 
		name = "Throne"; 
		 
	}
/**
 * adds one play
 * makes any card already played available to be played again
 */
	@Override
	public void play(Player p1,Player p2, JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		for (int i = 0; i < p1.handSize; i++)
		{
			p1.hand.get(i).setEnabled(true);
		}
		p1.plays++; 
	}
}
