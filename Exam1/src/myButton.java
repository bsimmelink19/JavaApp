import javax.swing.JButton;

public class myButton extends JButton{
	private Shape shape; 
	myButton(String l,Shape s)
	{
		super(l);
		shape = s; 
	}
	public Shape getShape()
	{
		return this.shape; 
	}
}
