
public class Police extends Person implements Employee{
		static int ID = 1000; 
		static int PN = 1111111;
		public enum Role{Patrol, Sargent, Captain}; 
		private Role role; 
		private double pay; 
		private double savings; 
		private int id; 
		public void Pay()
		{
			this.savings += this.pay; 
		}
		public int askID()
		{
			return this.id; 
		}
		public double getPay()
		{
			return this.pay; 
		}
		public double getSavings()
		{
			return this.savings; 
		}
		public Role getRole()
		{
			return this.role; 
		}
		public void setPay(Double p)
		{
			this.pay = p; 
		}
		public void setRole(Role r){
			this.role = r; 
		}
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
