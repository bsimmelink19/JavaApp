
public class Square implements Shape{
	private int id; 
	private int side; 
	private String color; 
	private String name = "Square";
	Square(int i, int s, String c)
	{
		id = i; 
		side = s;
		color = c; 
	}
	public int getSide()
	{
		return this.side; 
	}

	@Override
	public String getDetailString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public String getColor()
	{
		return this.color; 
	}
	public String getName()
	{
		return this.name; 
	}

}
