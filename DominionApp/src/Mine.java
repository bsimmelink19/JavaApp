import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * this is an action card
 * implements its own play function
 * @see Card
 * @see ActionCard
 * @author Brady Simmelink
 *
 */
public class Mine extends Card implements ActionCard{
	/**
	 * constructor
	 */
	public Mine()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl15 = getClass().getResource("/resources/mine.png"); 
		Image img15 = toolkit.getImage(imgUrl15); 
		img15 = img15.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon mineIcon = new ImageIcon(img15);
		details = String.format("<html>Upgrades treaure to <br> next value </html>"); 
		img = mineIcon; 
		cost = 5; 
		value = 0; 
		vPoints = 0; 
		name = "Mine"; 
		
	}
	/**
	 * allows user to select a treasure card from their hand to upgrade to next 
	 * Treasure Card
	 */
	@Override
	public void play(Player p1, Player p2,JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame(); 
		frame.setBounds(150,150,550,250); 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JLabel label1 = new JLabel("Choose cards to mine"); 
		label1.setForeground(Color.BLACK);
		label1.setHorizontalAlignment(SwingConstants.CENTER); 
		label1.setFont(new Font("Stencil", Font.PLAIN, 20));
		frame.add(label1, BorderLayout.NORTH); 
		JButton done = new JButton("Done"); 
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); 
			}
		});
		JPanel spanel = new JPanel();
		spanel.add(done); 
		frame.add(spanel, BorderLayout.SOUTH); 
		JPanel panel1 = new JPanel(); 
		for (int i = 0; i < p1.handSize; i++)
		{
			if (p1.deck.get(i) instanceof TreasureCard)
			{
			cardButton c = new cardButton(p1.deck.get(i),0); 
			c.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					cardButton b = (cardButton)e.getSource();
					if (b.getCard() instanceof Copper)
					{
						p1.deck.remove(b.getCard()); 
						p1.deck.add(new Silver()); 
						String d = String.format("<html>Silver Added!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",p1.buys, p1.plays, p1.handValue); 
					label.setText(d);  
					frame.dispose(); 
					}
					else if (b.getCard() instanceof Silver)
					{
						p1.deck.remove(b.getCard()); 
						p1.deck.add(new Gold()); 
						String d = String.format("<html>Gold Added!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",p1.buys, p1.plays, p1.handValue); 
					label.setText(d); 
					frame.dispose(); 
					}
					
					else if (b.getCard() instanceof Gold)
					{
						p1.deck.add(new Silver()); 
						p1.deck.add(new Gold()); 
						String d = String.format("<html>Silver and Gold Added!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",p1.buys, p1.plays, p1.handValue); 
					label.setText(d); 
					frame.dispose(); 
					}
					b.setEnabled(false);
					
					p1.deck.remove(b.getCard()); 
				}
			}
			);
			panel1.add(c); 
		}
		
		frame.add(panel1, BorderLayout.CENTER); 
	}
		p1.plays--;  

}
}
