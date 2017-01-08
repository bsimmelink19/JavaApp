
public class Kid extends Person {
			private String favCandy; 
			Kid(String n, int a, String phone, String c)
			{
				this.name = n; 
				this.age = a; 
				this.phoneNumber = phone; 
				this.favCandy = c; 
				
			}
			void setfavCandy(String fc)
			{
				this.favCandy = fc; 
			}
			String getFavCandy()
			{
				return this.favCandy; 
			}
}
