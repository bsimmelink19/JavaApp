import java.util.ArrayList;

/**
 * this class models a dominion player
 * @author Brady Simmelink
 *
 */
public class Player {
		public String name; 
		public int buys; 
		public int plays; 
		public int handValue; 
		public int handSize; 
		public ArrayList<Card> deck = new ArrayList<Card>(); 
		public ArrayList<cardButton> hand = new ArrayList<cardButton>();
		/**
		 * constructor
		 * @param name
		 */
		Player(String n)
		{
			this.name = n; 
			for (int i = 0; i < 4; i++)
			{
				deck.add(new Copper()); 
			}
			for (int i = 0; i < 3; i++)
			{
				deck.add(new Estate()); 
			}
			this.buys = 1; 
			this.plays = 1; 
		}
		/**
		 * sets name
		 * @param name
		 */
		public void setName(String n)
		{
			this.name = n; 
		}
		
	
}
