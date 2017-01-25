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
public class Ironworks extends Card implements ActionCard{
	/**
	 * constructor
	 */
	public Ironworks()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		java.net.URL imgUrl6 = getClass().getResource("/resources/ironworks.png"); 
		Image img6 = toolkit.getImage(imgUrl6); 
		details = String.format("<html>select any card <br>worth less than 4<br> if treasure +1 treasure<bt> if action +1 play<br> if victory +1 buy</html>"); 
		img6 = img6.getScaledInstance(50, 70, Image.SCALE_SMOOTH); 
		ImageIcon ironworksIcon = new ImageIcon(img6);
		img = ironworksIcon; 
		cost = 4; 
		value = 0; 
		vPoints = 0; 
		name = "IronWorks"; 
		
	}
	/**
	 * allows the player to choose a card with a cost of 4 or less
	 * adds either one treasure, one play, or one buy depending on card type chosen 
	 */
	@Override
	public void play(Player p1,Player p2, JPanel panel, JLabel label) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame(); 
		frame.setBounds(150,150,600,250); 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JLabel label1 = new JLabel("Choose card to gain"); 
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
		
		JPanel p = new JPanel();
		
		cardButton pawn = new cardButton(new Pawn(), 0); 
		pawn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardButton b = (cardButton)e.getSource();  
				p1.deck.add(b.getCard()); 
				p1.plays++; 
				frame.dispose(); 
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
				label.setText(d);  
			}
		});
		p.add(pawn);
		
		cardButton throne = new cardButton(new ThroneRoom(), 0);
		throne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardButton b = (cardButton)e.getSource();  
				p1.deck.add(b.getCard()); 
				p1.plays++; 
				frame.dispose(); 
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
				label.setText(d);  
			}
		});
		p.add(throne); 
		
		cardButton smithy = new cardButton(new Smithy(), 0); 
		smithy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardButton b = (cardButton)e.getSource();  
				p1.deck.add(b.getCard()); 
				p1.plays++; 
				frame.dispose(); 
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
				label.setText(d);  
			}
		});
		p.add(smithy); 
		
		cardButton greathall = new cardButton(new GreatHall(), 0); 
		greathall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardButton b = (cardButton)e.getSource();  
			p1.buys++; 
				frame.dispose(); 
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
				label.setText(d);  
			}
		});
		p.add(greathall); 
		
		cardButton silver = new cardButton(new Silver(), 0); 
		silver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardButton b = (cardButton)e.getSource();  
				p1.deck.add(b.getCard()); 
				p1.handValue++; 
				frame.dispose(); 
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
				label.setText(d);  
			}
		});
		p.add(silver); 
		
		cardButton estate = new cardButton(new Estate(), 0);
		estate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardButton b = (cardButton)e.getSource();  
				p1.buys++; 
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", p1.name, p1.buys, p1.plays, p1.handValue); 
				label.setText(d);  
			}
		});
		p.add(estate); 
		
		frame.add(p, BorderLayout.CENTER); 
		p1.plays--; 
	}

}
