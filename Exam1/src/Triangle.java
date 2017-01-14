
public class Triangle implements Shape{
	private int id; 
	private int side1; 
	private int side2;
	private int side3;
	private String name = "Triangle";
	String color; 
	Triangle(int i, int s1, int s2, int s3, String c)
	{
		id = i; 
		side1 = s1;
		side2 = s2; 
		side3 = s3;
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
	public int getSide1()
	{
		return this.side1; 
	}
	public int getSide2()
	{
		return this.side2; 
	}
	public int getSide3()
	{
		return this.side3; 
	}
	
}
