import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates a frame containing a 
 * cardButton for each of the ActionCards
 * in order to view a description  
 * @see JComponent
 * @see ActionListener
 * @author Brady Simmelink
 */
public class detailsFrame extends JComponent implements ActionListener{
	JLabel label; 
	/**
	 * Constructor
	 */
	detailsFrame()
	{
	JFrame detailsFrame = new JFrame(); 
	detailsFrame.setBounds(350,350,550,350); 
	detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	detailsFrame.setVisible(true);
	label = new JLabel(); 
	
	JPanel p = new JPanel(); 
	Forge forge = new Forge(); 
	
	cardButton forgeb = new cardButton(forge, 0); 
	forgeb.addActionListener(this); 
	GreatHall greathall = new GreatHall();
	cardButton greathallb = new cardButton(greathall,0); 
	Harem harem = new Harem(); 
	cardButton haremb = new cardButton(harem, 0); 
	haremb.addActionListener(this); 
	Ironworks ironworks = new Ironworks(); 
	cardButton ironworksb = new cardButton(ironworks, 0); 
	ironworksb.addActionListener(this); 
	Mine mine = new Mine(); 
	cardButton mineb = new cardButton(mine, 0); 
	mineb.addActionListener(this); 
	Pawn pawn = new Pawn();
	cardButton pawnb = new cardButton(pawn, 0); 
	pawnb.addActionListener(this); 
	Saboteur saboteur = new Saboteur(); 
	cardButton saboteurb = new cardButton(saboteur, 0); 
	saboteurb.addActionListener(this); 
	Smithy smithy = new Smithy(); 
	cardButton smithyb = new cardButton(smithy, 0); 
	smithyb.addActionListener(this); 
	ThroneRoom throneRoom = new ThroneRoom();
	cardButton throneRoomb = new cardButton(throneRoom, 0); 
	throneRoomb.addActionListener(this); 
	Witch witch = new Witch(); 
	cardButton witchb = new cardButton(witch, 0); 
	witchb.addActionListener(this); 
	JPanel p1 = new JPanel(); 
	p.add(forgeb); 
	p.add(greathallb); 
	p.add(haremb);
	p.add(ironworksb);
	p.add(mineb);
	p.add(pawnb);
	p.add(saboteurb);
	p.add(smithyb); 
	p.add(throneRoomb);
	p.add(witchb);
	p1.add(label);
	detailsFrame.add(p, BorderLayout.CENTER); 
	detailsFrame.add(p1, BorderLayout.SOUTH); 
	}
	
	/**
	 * displays the details of the card 
	 * in the button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cardButton b = (cardButton)e.getSource(); 
		label.setText(b.getCard().details); 
	}
}
