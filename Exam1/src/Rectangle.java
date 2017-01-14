
public class Rectangle implements Shape{
	private int id; 
	private int length;
	private int width; 
	private String color; 
	private String name = "Rectangle";
	Rectangle(int i, int l, int w, String c)
	{
		id = i;
		length = l;
		width = w;
		color = c; 
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
	
	public int getLenth()
	{
		return this.length; 
	}
	
	public int getWidth()
	{
		return this.width; 
	}
	public int getArea() 
	{
		return this.length * this.width; 
	}
}
