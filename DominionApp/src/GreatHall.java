import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * this card has a victory point value
 * and its own implementation of play
 * @see VictoryCard
 * @see ActionCard
 * @see Card
 * @author Brady Simmelink
 *
 */
public class GreatHall extends Card implements ActionCard, VictoryCard{
/**
 * constructor
 */
	public GreatHall()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl14 = getClass().getResource("/resources/greathall.png"); 
		details = String.format("<html>+1 card<br> +1 buy<br>1 victory point</html>"); 
		Image img14 = toolkit.getImage(imgUrl14); 
		img14 = img14.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon greatHallIcon = new ImageIcon(img14);
		img = greatHallIcon;
		cost = 3; 
		value = 0; 
		vPoints = 1; 
		name = "Great Hall"; 
		 
	}
	/**
	 * adds one card to the player's hand
	 * adds one play 
	 */
	@Override
	public void play(Player p1,Player p2,JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		p1.handValue = 0; 
		p1.plays = p1.plays + 1; 
		p1.hand.add(new cardButton(p1.deck.get(5), 0)); 
		panel.add(p1.hand.get(5)); 
		try{
			for (int i = 0; i < p1.hand.size(); i++)
			{
				p1.handValue += p1.hand.get(i).getCard().getValue(); 
			}
		} catch(IndexOutOfBoundsException e){}; 
		p1.plays--; 
			String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
			label.setText(d);
	}
	
}
