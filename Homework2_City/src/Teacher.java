
public class Teacher extends Person implements Employee{
		static int teachID = 5000; 
		private int gradeLevel; 
		private String certification; 
		private double savings; 
		private double pay; 
		private int ID; 
		public void setGradeLevel(int gl)
		{
			this.gradeLevel = gl; 
		}
		public void setCert(String c)
		{
			this.certification = c; 
		}
		public void setPay(int p)
		{
			this.pay = p; 
		}
		public void Pay()
		{
			this.savings += this.pay; 
		}
		public int getGradeLevel()
		{
			return this.gradeLevel;
		}
		public String getCert()
		{
			return this.certification; 
		}
		public double getSavings()
		{
			return this.savings; 
		}
		public double getPay()
		{
			return this.pay; 
		}
		public int askID()
		{
			return this.ID; 
		}
		public Teacher(int gl, String cert, double p, String n, int a, String pn)
		{
			this.gradeLevel = gl; 
			this.certification = cert; 
			this.pay = p;
			this.ID = teachID; 
			teachID++; 
			this.name = n; 
			this.age = a; 
			this.phoneNumber = pn; 
		}
}
