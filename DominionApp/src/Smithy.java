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
 * @author bsimmelink19
 *
 */
public class Smithy extends Card implements ActionCard{
	/**
	 * constructor
	 */
	public Smithy()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl12 = getClass().getResource("/resources/smithy.png"); 
		Image img12 = toolkit.getImage(imgUrl12); 
		img12 = img12.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon smithyIcon = new ImageIcon(img12);	
		details = String.format("+3 cards"); 
		img = smithyIcon; 
		cost = 4; 
		value = 0; 
		vPoints = 0; 
		name = "Smithy"; 
	
	}
/**
 * adds three cards to the player's hand
 */
	@Override
	public void play(Player p1,Player p2, JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		p1.handValue = 0; 
		p1.handSize = p1.handSize = 3; 
		p1.hand.add(new cardButton(p1.deck.get(5), 0)); 
		p1.hand.add(new cardButton(p1.deck.get(6), 0)); 
		p1.hand.add(new cardButton(p1.deck.get(7), 0)); 
		panel.add(p1.hand.get(5)); 
		panel.add(p1.hand.get(6));
		panel.add(p1.hand.get(7)); 
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
