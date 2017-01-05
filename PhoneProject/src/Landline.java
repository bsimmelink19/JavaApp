
public class Landline extends Phone {
		public void answer(Phone src){};
		public void ignore(Phone src){}; 
		public Object clone()
		{
				return new Landline(number); 	
		}
}
