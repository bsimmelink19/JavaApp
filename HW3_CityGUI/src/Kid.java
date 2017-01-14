/**
 * This class models a kid with name, age, phone number and favorite candy
 * @see Person
 * @author Brady Simmelink
 */
public class Kid extends Person {
			private String favCandy; 
			/**
			 * Constructor
			 * @param name
			 * @param age
			 * @param phone number
			 * @param favorite candy
			 */
			Kid(String n, int a, String phone, String c)
			{
				this.name = n; 
				this.age = a; 
				this.phoneNumber = phone; 
				this.favCandy = c; 
				
			}
			/**
			 * Sets the favorite candy of this kid 
			 * @param the name of the favorite candy
			 */
			void setfavCandy(String fc)
			{
				this.favCandy = fc; 
			}
			/**
			 * returns the favorite candy
			 * @return this favorite candy
			 */
			String getFavCandy()
			{
				return this.favCandy; 
			}
}
