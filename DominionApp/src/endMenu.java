import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * this class creates a JFrame to be displayed at the end of the game
 * determines the winner of the game
 * outputs winner and scores to the frame
 * @author Brady Simmelink
 *
 */
public class endMenu extends JComponent{
	JFrame frame; 
	JLabel endLabel;
	JLabel scoreLabel; 
	/**
	 * constructor
	 * @param player1 
	 * @param player2
	 */
	endMenu(Player p1, Player p2)
	{
		frame = new JFrame(); 
		frame.setBounds(300, 300, 220, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		endLabel = new JLabel(); 
		endLabel.setForeground(Color.BLACK);
		endLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		endLabel.setFont(new Font("Stencil", Font.PLAIN, 20));
		frame.add(endLabel, BorderLayout.CENTER); 
		
		scoreLabel = new JLabel(); 
		JPanel centerPanel = new JPanel(); 
		centerPanel.add(scoreLabel); 
		frame.add(centerPanel, BorderLayout.SOUTH); 
		calcWinner(p1,p2); 
	
	}
	
	/**
	 * calculates the winner of the game
	 * displays the winner and scores to the JFrame
	 * @param player1
	 * @param player2
	 */
	private void calcWinner(Player p1, Player p2)
	{
		//determine player1 score
		int p1Score = 0; 
		for (int i = 0; i < p1.deck.size(); i++)
		{
			if(p1.deck.get(i) instanceof VictoryCard)
			{
				p1Score += p1.deck.get(i).vPoints; 
			}
		}
		//determine player2 score
		int p2Score = 0; 
		for (int i = 0; i < p2.deck.size(); i++)
		{
			if(p2.deck.get(i) instanceof VictoryCard)
			{
				p2Score += p2.deck.get(i).vPoints; 
			}
		}
		
		//output winner depending on whose score was higher
		if (p1Score > p2Score)
		{
			String s = String.format("%s Wins!", p1.name); 
			endLabel.setText(s);
		}
		else if (p2Score > p1Score)
		{
			String s = String.format("%s Wins!", p2.name); 
			endLabel.setText(s);
		}
		else endLabel.setText("It's a draw!");
		
		String d = String.format("<html>%s Score: %d <br> %s Score: %d</html>", p1.name, p1Score, p2.name, p2Score); 
		scoreLabel.setText(d);
	}

}
