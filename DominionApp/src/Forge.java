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
public class Forge extends Card implements ActionCard {
	/**
	 * constructor
	 */
	public Forge()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl7 = getClass().getResource("/resources/forge.png"); 
		Image img7 = toolkit.getImage(imgUrl7); 
		img7 = img7.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon forgeIcon = new ImageIcon(img7);
		details = String.format("<html>trash any card in your hand<br> adding its value to <br>your hand value<br> +1 buy</html>"); 
		img = forgeIcon; 
		cost = 7; 
		value = 0; 
		vPoints = 0; 
		name = "Forge"; 
		
	}
	/**
	 * player can decide to trash cards
	 * adding their value to their current hand value
	 */
	@Override
	public void play(Player p1, Player p2, JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame(); 
		frame.setBounds(150,150,550,250); 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JLabel label1 = new JLabel("Choose cards to forge"); 
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
			cardButton c = new cardButton(p1.deck.get(i),0); 
			c.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					cardButton b = (cardButton)e.getSource();
					p1.handValue = p1.handValue + b.getCard().getCost(); 
					b.setEnabled(false);
					String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
					label.setText(d);  
					p1.deck.remove(b.getCard()); 
				}
			});
			panel1.add(c); 
		}
		p1.buys++; 
		p1.plays--; 
		frame.add(panel1, BorderLayout.CENTER); 
	}
}
