
public class Circle implements Shape{
	private int id; 
	private int radius;
	private String color; 
	private String name = "Circle";
	Circle(int i, int r, String c)
	{
		id = i; 
		radius = r; 
		color = c; 
	}

	int getRadius()
	{
		return this.radius; 
	}
	@Override
	public String getDetailString() {
		// TODO Auto-generated method stub
		String s = String.format("Kind: %s\n ID: %d\n Radius: %d\n Color: %s", this.name, this.id, this.radius, this.color); 
		return s; 
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
	public int getArea() 
	{
		return (int) (3.14 * this.radius * this.radius); 
	}
}
