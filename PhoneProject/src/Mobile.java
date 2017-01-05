
public class Mobile extends Phone implements Textable{
	public boolean sendText(Textable p)
	{
		return true; 
	}
	public void answer(Phone src){};
	public void ignore(Phone src){}; 
	public Object clone()
	{
			return new Mobile(number); 	
	}
}
