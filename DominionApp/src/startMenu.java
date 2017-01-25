import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * this class creates a JFrame with a button to begin the game
 * and stores the player's names 
 * @see JComponent
 * @see ActionListener
 * @author bsimmelink19
 *
 */
public class startMenu extends JComponent implements ActionListener{
	JFrame frame; 
	Player player1; 
	Player player2; 
	JLabel startLabel; 
	JLabel dominionLabel; 
	JButton startButton; 
	/**
	 * constructor
	 */
	startMenu()
	{
		frame = new JFrame(); 
		player1 = new Player(""); 
		player2 = new Player("");
		frame.setBounds(300, 300, 270, 270);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		startLabel = new JLabel("Welcome to Dominion!");
		startLabel.setForeground(Color.BLACK);
		startLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		startLabel.setFont(new Font("Stencil", Font.PLAIN, 20));
		frame.add(startLabel, BorderLayout.NORTH); 
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		java.net.URL imgUrl0 = getClass().getResource("/resources/dominion.png"); 
		Image img0 = toolkit.getImage(imgUrl0); 
		img0 = img0.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
		ImageIcon dominionIcon = new ImageIcon(img0);
		dominionLabel = new JLabel(dominionIcon); 
		
		startButton = new JButton("Start!"); 
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String s = "Enter Player one's name: "; 
				player1.name = JOptionPane.showInputDialog(null, s); 
			
				
				String s1 = "Enter Player two's name: "; 
				player2.name = JOptionPane.showInputDialog(null, s1); 
				
				frame.dispose(); 
				Window w = new Window(player1.name, player2.name); 
			}
		});

		JPanel p = new JPanel(); 
		frame.add(dominionLabel, BorderLayout.CENTER); 
		p.add(startButton); 
		frame.add(p, BorderLayout.SOUTH); 
		frame.add(startLabel, BorderLayout.NORTH); 
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
