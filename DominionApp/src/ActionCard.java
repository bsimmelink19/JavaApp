import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * used to determine if a card is playable
 * contains a play function 
 * determined within action cards individual classes
 * @author Brady Simmelink
 *
 */
public interface ActionCard {
	/**
	 * cards individual action
	 * @param player playing the card
	 * @param opponent
	 * @param panel
	 * @param label
	 */
	public void play(Player p1, Player p2, JPanel panel, JLabel label); 
}
