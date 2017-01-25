import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * this class creates a JFrame in which the game is played
 * contains the buttons for action cards, victory cards, and treasure cards to be bought
 * contains the current players hand as buttons to be played
 * @author Brady Simmelink
 *
 */
public class Window extends JComponent implements ActionListener{
	JFrame startFrame;
	JFrame frame; 
	JFrame endFrame; 
	JLabel startLabel;
	JLabel dominionLabel; 
	JButton startButton; 
	cardButton provinceStack; 
	cardButton duchyStack; 
	cardButton estateStack; 
	cardButton copperStack;
	cardButton silverStack; 
	cardButton goldStack; 
	cardButton ironworksStack; 
	cardButton forgeStack; 
	cardButton haremStack; 
	cardButton pawnStack; 
	cardButton witchStack; 
	cardButton throneRoomStack; 
	cardButton smithyStack; 
	cardButton saboteurStack; 
	cardButton greatHallStack;
	cardButton mineStack; 
	ArrayList<cardButton>hand = new ArrayList<cardButton>(); 
	JButton endTurn; 
	JButton start; 
	JButton cardDetails; 
	JButton endGame; 
	Player player1; 
	Player player2; 
	Player currentPlayer; 
	Player previousPlayer; 
	JLabel display; 
	JPanel southPanel; 
	int numDisabled; 
	/**
	 * constructor
	 * @param player1
	 * @param player2
	 */
	public Window(String p1, String p2)
	{
		//////////create the frame/////////////////
		frame = new JFrame(); 
		frame.setBounds(350,350,650,650); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		////////////setup players/////////////////
		player1 = new Player(p1); 
		player2 = new Player(p2); 
		//used to determin whose turn it is
		currentPlayer = new Player("");
		
		
		
		///////////Create buttons for victory cards/////////////////////////
		Province province = new Province(); 
		provinceStack = new cardButton(province,9); 
		provinceStack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//checks if the user can buy the card
				cardButton b = (cardButton)e.getSource();  
				if (currentPlayer.buys > 0 && currentPlayer.handValue >= b.getCard().getCost())
				{
					currentPlayer.deck.add(b.getCard()); 
					currentPlayer.buys--; 
					String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", currentPlayer.name, currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
					display.setText(d); 	
					b.decTotalNum(); 
				}
				else 
				{
					String d = String.format("<html>Can't be done!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
					display.setText(d); 
				}
				//ends the game when provinces are gone
				if (b.getTotalNum() == 0)
				{
					b.setEnabled(false);
					frame.dispose(); 
					endMenu em = new endMenu(player1, player2); 
				}
			}
		});
		
		Duchy duchy = new Duchy(); 
		duchyStack = new cardButton(duchy, 12); 
		duchyStack.addActionListener(this); 
		
		Estate estate = new Estate(); 
		estateStack = new cardButton(estate, 15); 
		estateStack.addActionListener(this); 
		
		Box eastBox = Box.createVerticalBox();  
		eastBox.add(estateStack); 
		eastBox.add(Box.createVerticalStrut(15)); 
		eastBox.add(duchyStack);
		eastBox.add(Box.createVerticalStrut(15));
		eastBox.add(provinceStack); 
		
		frame.add(eastBox, BorderLayout.EAST); 
		
		///////////create buttons for economy cards/////////////////////
	
		Copper copper = new Copper(); 
		copperStack = new cardButton(copper, 25); 
		copperStack.addActionListener(this); 
		
		Silver silver = new Silver(); 
		silverStack = new cardButton(silver, 20); 
		silverStack.addActionListener(this); 
	
		Gold gold = new Gold(); 
		goldStack = new cardButton(gold, 15); 
		goldStack.addActionListener(this); 
		
		Box westBox = Box.createVerticalBox(); 
		westBox.add(copperStack); 
		westBox.add(Box.createVerticalStrut(15)); 
		westBox.add(silverStack);
		westBox.add(Box.createVerticalStrut(15));
		westBox.add(goldStack); 
		
		frame.add(westBox, BorderLayout.WEST); 
	
		/////////////////create buttons for action cards////////////////
	
		Ironworks ironworks = new Ironworks(); 
		ironworksStack = new cardButton(ironworks, 10); 
		ironworksStack.addActionListener(this); 
		
		Forge forge = new Forge(); 
		forgeStack = new cardButton(forge, 10); 
		forgeStack.addActionListener(this); 
		
		Harem harem = new Harem(); 
		haremStack = new cardButton(harem, 10); 
		haremStack.addActionListener(this); 

		Pawn pawn = new Pawn(); 
		pawnStack = new cardButton(pawn, 10); 
		pawnStack.addActionListener(this);
			
		Witch witch = new Witch(); 
		witchStack = new cardButton(witch, 10); 
		witchStack.addActionListener(this);
		
		ThroneRoom throneRoom= new ThroneRoom(); 
		throneRoomStack = new cardButton(throneRoom, 10); 
		throneRoomStack.addActionListener(this);
		
		Smithy smithy= new Smithy(); 
		smithyStack = new cardButton(smithy, 10); 
		smithyStack.addActionListener(this);

		Saboteur saboteur = new Saboteur(); 
		saboteurStack = new cardButton(saboteur, 10); 
		saboteurStack.addActionListener(this);
		
		GreatHall greatHall = new GreatHall(); 
		greatHallStack = new cardButton(greatHall, 10); 
		greatHallStack.addActionListener(this);
		
		Mine mine = new Mine(); 
		mineStack = new cardButton(mine, 10);
		mineStack.addActionListener(this); 
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());

		centerPanel.add(forgeStack); 
		centerPanel.add(ironworksStack); 
		centerPanel.add(haremStack); 
		centerPanel.add(pawnStack); 
		centerPanel.add(witchStack); 
		centerPanel.add(throneRoomStack); 
		centerPanel.add(smithyStack); 
		centerPanel.add(saboteurStack); 
		centerPanel.add(greatHallStack); 
		centerPanel.add(mineStack); 
		display = new JLabel();
		centerPanel.add(display);
		frame.add(centerPanel, BorderLayout.CENTER); 
		


		/////////////////create buttons for ending turn, viewing card details, 
		//viewing rules/////////////
		southPanel = new JPanel(); 
		start = new JButton("Start"); 
		start.addActionListener(new ActionListener(){
			//starts the game by creating the initial hand for player one and activating the cards
			public void actionPerformed(ActionEvent e)
			{
				JButton b = (JButton)e.getSource(); 
				b.setEnabled(false);
				currentPlayer = player1; 
				currentPlayer.hand.clear(); 
				currentPlayer.handValue = 0; 
				currentPlayer.handSize = 5; 
				currentPlayer.buys = 1; 
				currentPlayer.plays = 1; 
				southPanel.removeAll(); 
			
				Collections.shuffle(currentPlayer.deck);
				for (int i = 0; i < 5; i++)
				{
					cardButton c = new cardButton(currentPlayer.deck.get(i), 0);
					c.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							cardButton b = (cardButton)e.getSource();
							//checks if the current player can play anything else
							if (currentPlayer.plays > 0)
							{
							if (b.getCard() instanceof ActionCard)
							{
								((ActionCard)b.getCard()).play(currentPlayer,previousPlayer, southPanel, display); 
								frame.repaint(); 
								frame.revalidate(); 
								b.setEnabled(false); 
							}
							}
							else
							{
								String d = String.format("<html>Can't be done!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
								display.setText(d); 
							}
						}
					});
					currentPlayer.hand.add(c); 
				}
				//adds cards from the deck to the players hand 
				for (int i = 0; i < currentPlayer.hand.size(); i++)
				{
					currentPlayer.handValue += currentPlayer.hand.get(i).getCard().getValue(); 
				}
				for (int i = 0; i < 5; i++)
				{
					southPanel.add(currentPlayer.hand.get(i)); 
				}
				frame.add(southPanel, BorderLayout.SOUTH); 	
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", currentPlayer.name, currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
				display.setText(d); 
				frame.repaint(); 
				frame.revalidate(); 
			}
		});
		endTurn = new JButton("End Turn"); 
		endTurn.addActionListener(new ActionListener(){
			//switches between players
			//resets all values to initial values for a turn 
			public void actionPerformed(ActionEvent e)
			{
				//resets for new turn 
				currentPlayer.hand.clear(); 
				currentPlayer.handValue = 0; 
				currentPlayer.handSize = 5; 
				currentPlayer.buys = 1; 
				currentPlayer.plays = 1; 
				southPanel.removeAll(); 
				//switches players 
				if (currentPlayer == player1)
				{
					currentPlayer = player2; 
					previousPlayer = player1; 
				}
				else 
					{
						currentPlayer = player1; 
						previousPlayer = player2; 
					}
			//shuffles deck 
				Collections.shuffle(currentPlayer.deck);
				//adds cards to player's hand from deck 
				for (int i = 0; i < 5; i++)
				{
					cardButton c = new cardButton(currentPlayer.deck.get(i), 0);
					c.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							cardButton b = (cardButton)e.getSource();
							if (currentPlayer.plays > 0)
							{
							if (b.getCard() instanceof ActionCard)
							{
								((ActionCard)b.getCard()).play(currentPlayer,previousPlayer, southPanel, display); 
								frame.repaint(); 
								frame.revalidate(); 
								b.setEnabled(false); 
							}
							}
							else
							{
								String d = String.format("<html>Can't be done!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
								display.setText(d); 
							}
						}
					});
					currentPlayer.hand.add(c); 
				}
				//determines hand value 
				for (int i = 0; i < currentPlayer.hand.size(); i++)
				{
					currentPlayer.handValue += currentPlayer.hand.get(i).getCard().getValue(); 
				}
				for (int i = 0; i < 5; i++)
				{
					southPanel.add(currentPlayer.hand.get(i)); 
				}
				frame.add(southPanel, BorderLayout.SOUTH); 	
				String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", currentPlayer.name, currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
				display.setText(d); 
				frame.repaint(); 
				frame.revalidate(); 
			}
		});
		
		endGame = new JButton("End Game"); 
		endGame.addActionListener(new ActionListener(){
			//closes the game window and opens a new window displaying the winner
			//and score
			public void actionPerformed(ActionEvent e){
				endMenu ew = new endMenu(player1, player2); 
				frame.dispose(); 
			}
		}); 
		cardDetails = new JButton("Card Details");
		cardDetails.addActionListener(new ActionListener(){
			//opens a window with buttons to displays the details of the card
			public void actionPerformed(ActionEvent e){
				detailsFrame df = new detailsFrame(); 
			}
		}); 
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(start); 
		panel.add(endTurn); 
		panel.add(cardDetails);  
		panel.add(endGame); 
		frame.add(panel, BorderLayout.NORTH); 
		}
	
	//the action listener for cards on the board
	//checks if the current player can buy it,
	//if so the card is added to that player's deck 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cardButton b = (cardButton)e.getSource();  
		//checks if player can buy the card
		if (currentPlayer.buys > 0 && currentPlayer.handValue >= b.getCard().getCost())
		{
			currentPlayer.deck.add(b.getCard()); 
			currentPlayer.buys--; 
			currentPlayer.handValue = currentPlayer.handValue - b.getCard().getCost(); 
			String d = String.format("<html>%s's Turn!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>", currentPlayer.name, currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
			display.setText(d); 	
			b.decTotalNum(); 
		}
		else 
		{
			String d = String.format("<html>Can't be done!<br> Buys: %d<br> Plays: %d<br> Hand Value: %d</html>",currentPlayer.buys, currentPlayer.plays, currentPlayer.handValue); 
			display.setText(d); 
		}
		//checks if the number remaining is 0
		//disables the button if so
		if (b.getTotalNum() == 0)
		{
			b.setEnabled(false);
			numDisabled++; 
		}
		//checks if three cards are gone
		//ends the game if so
		if (numDisabled > 2)
		{
			frame.dispose(); 
			b.setEnabled(false);
			frame.dispose(); 
			endMenu em = new endMenu(player1, player2); 
		}
	}
	

}
