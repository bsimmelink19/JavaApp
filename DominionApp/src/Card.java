import javax.swing.ImageIcon;

/**
 * this class models dominion cards
 * @author Brady Simmelink
 */
public class Card {
		protected int cost; 
		protected int value; 
		protected int vPoints; 
		protected String name; 
		protected ImageIcon img;
		protected String details; 
		/**
		 * @return cost
		 */
		public int getCost()
		{
			return this.cost;
		}
		
		/**
		 * @return value
		 */
		public int getValue()
		{
			return this.value; 
		}
		/**
		 * 
		 * @return name 
		 */
		public String getName()
		{
			return this.name;
		}
		
		/**
		 * @return image associated with card
		 */
		public ImageIcon getImage()
		{
			return this.img; 
		}
		
		/**
		 * 
		 * @param cost
		 */
		public void setCost(int c)
		{
			this.cost = c; 
		}
		/**
		 * 
		 * @param value
		 */
		public void setValue(int v)
		{
			this.value = v; 
		}
		/**
		 * 
		 * @param name
		 */
		public void setName(String n)
		{
			this.name = n; 
		}
		/**
		 * 
		 * @param image
		 */
		public void setIcon(ImageIcon i)
		{
			this.img = i; 
		}
		

		
		
}
