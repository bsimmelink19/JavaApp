import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * this class is a Jbutton that holds its own Card
 * @see JButton
 * @author Brady Simmelink
 */
public class cardButton extends JButton{
	private Card card; 
	private int totalNum; 
	/**
	 * constructor
	 * @param card associated
	 * @param total number of possible clicks
	 */
	public cardButton(Card c, int tn)
	{
		super(c.getImage());  
		this.totalNum = tn; 
		String s = String.format("<html>%s<br> Cost: %s</html>", c.getName(), c.getCost()); 
		this.setText(s);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		card = c; 
	}
	
	/**
	 * 
	 * @param name
	 * @param image
	 */
	public cardButton(String n, ImageIcon i)
	{
		super(n, i); 
	}
	
	/**
	 * 
	 * @return card associated
	 */
	public Card getCard()
	{
		return this.card; 
	}
	
	/**
	 * decrement the number of times left to be clicked
	 */
	public void decTotalNum()
	{
		this.totalNum--; 
	}
	/**
	 * 
	 * @return number of clicks left
	 */
	public int getTotalNum()
	{
		return this.totalNum; 
	}
	

}
