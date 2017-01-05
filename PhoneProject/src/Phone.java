import java.util.Random; 
public abstract class Phone {
	private static int lastnumber = 1111111; 
	private int number; 
	public Phone()
	{
		number = lastnumber; 
		lastnumber++; 
	}
	public Phone(int number)
	{
		this.number = number; 
	}
	public String toString()
	{
		return String.format("%d-%d",number / 10000, number % 10000); 
	}
	abstract public Object clone(); 

	public int getNumber()
	{
		return this.number; 
	}
	public boolean equals(Phone p)
	{
		if (this.number == p.getNumber())
			return true; 
		else 
			return false; 
	}
	public boolean call(Phone dest)
	{
		return dest.receive(this); 
	}
	public boolean receive(Phone src)
	{
		Random r = new Random(); 
		boolean answered = (r.nextInt()%2 == 1); 
		if (answered)
			answer(src); 
		else
			ignore(src); 
		
		return answered; 
	}
	abstract void answer(Phone src);
	abstract void ignore(Phone src);  
}
