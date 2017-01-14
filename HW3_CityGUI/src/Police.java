/**
 * this class models a police officer, with ID, Role, pay, and savings
 * @see Person 
 * @see Employee 
 * @author Brady Simmelink
 */
public class Police extends Person implements Employee{
		static int ID = 1000; 
		static int PN = 1111111;
		public enum Role{Patrol, Sargent, Captain}; 
		private Role role; 
		private double pay; 
		private double savings; 
		private int id; 
		/**
		 * pays this police by incrementing their savings by their pay
		 */
		public void Pay()
		{
			this.savings += this.pay; 
		}
		/**
		 * returns the id
		 * @return this id
		 */
		public int askID()
		{
			return this.id; 
		}
		/**
		 * returns the pay
		 * @return this pay
		 */
		public double getPay()
		{
			return this.pay; 
		}
		/**
		 * return the savings 
		 * @return this savings
		 */
		public double getSavings()
		{
			return this.savings; 
		}
		/**
		 * return the role of the officer
		 * @return this role 
		 */
		public Role getRole()
		{
			return this.role; 
		}
		/**
		 * sets the pay to the desired value 
		 * @param the new pay
		 */
		public void setPay(Double p)
		{
			this.pay = p; 
		}
		/**
		 * sets the role of the police 
		 * @param the new role 
		 */
		public void setRole(Role r){
			this.role = r; 
		}
		/**
		 * Constructor 
		 * @param role
		 * @param pay
		 * @param name
		 * @param age
		 * @param phone number 
		 */
		public Police(Role r, Double p, String n, int a, String pn)
		{
			this.role = r;  
			this.pay = p;
			this.name = n; 
			this.age = a; 
			this.id = ID; 
			this.phoneNumber = pn; 
			ID++; 
		}
	
}
