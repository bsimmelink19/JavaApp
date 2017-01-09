/**
 * This class models a teacher, with grade level, certification, savings, pay, and ID
 * @see Person 
 * @see Employee
 * @author bsimmelink19
 */
public class Teacher extends Person implements Employee{
		static int teachID = 5000; 
		private int gradeLevel; 
		private String certification; 
		private double savings; 
		private double pay; 
		private int ID; 
		/**
		 * returns the grade level taught by the teacher 
		 * @param this grade level 
		 */
		public void setGradeLevel(int gl)
		{
			this.gradeLevel = gl; 
		}
		/**
		 * sets the teacher's certification
		 * @param the new certification 
		 */
		public void setCert(String c)
		{
			this.certification = c; 
		}
		/**
		 * sets the pay of the teacher 
		 * @param the new pay 
		 */
		public void setPay(int p)
		{
			this.pay = p; 
		}
		/**
		 * pays the teacher by incrementing their savings by their pay 
		 */
		public void Pay()
		{
			this.savings += this.pay; 
		}
		/**
		 * returns the grade level taught by the teacher 
		 * @return this grade level 
		 */
		public int getGradeLevel()
		{
			return this.gradeLevel;
		}
		/**
		 * returns the teacher's certification
		 * @return this certification 
		 */
		public String getCert()
		{
			return this.certification; 
		}
		/**
		 * returns the teacher's current value in savings 
		 * @return this savings 
		 */
		public double getSavings()
		{
			return this.savings; 
		}
		/**
		 * returns the amount this teacher is paid 
		 * @return this pay
		 */
		public double getPay()
		{
			return this.pay; 
		}
		/**
		 * returns the teacher's employee ID
		 * @return this ID
		 */
		public int askID()
		{
			return this.ID; 
		}
		/**
		 * Constructor 
		 * @param grade level 
		 * @param certification 
		 * @param pay
		 * @param name
		 * @param age
		 * @param phone number 
		 */
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
