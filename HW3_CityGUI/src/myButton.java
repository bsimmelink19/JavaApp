
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class myButton extends JButton {
	private Person pers; 
	private Building build; 
	public myButton(Person p, ImageIcon img)
	{
		super(p.getName(), img); 
		pers = p; 
	}
	public myButton(Building b, ImageIcon img, int x, int y, int w, int h)
	{
		super(b.name, img); 
		build = b; 
		this.setBounds(x, y, w, h);
	}
	public Person getPerson()
	{
		return this.pers; 
	}
	public Building getBuilding()
	{
		return this.build; 
	}
}
